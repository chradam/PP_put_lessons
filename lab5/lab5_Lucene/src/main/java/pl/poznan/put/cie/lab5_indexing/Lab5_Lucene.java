package pl.poznan.put.cie.lab5_indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.stream.XMLStreamException;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeDate.parse;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.NoLockFactory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.util.NumericUtils;

public class Lab5_Lucene 
{
    public static final String FIELD_ID = "id";
    public static final String FIELD__PRICE = "_price";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_DESCRIPTION = "description";
    
    public static final String PATH = "C:\\Users\\s0163731\\Desktop\\platformy_programowania\\lab5\\lab5\\items.xml";
    public static final String INDEX_DIR  = "C:\\Users\\s0163731\\Desktop\\platformy_programowania\\lab5\\lab5\\Lab5_luceneIndex";
        
    private static void addDoc(IndexWriter w, String title, String isbn)
        throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }
    
    private static void addItem(IndexWriter w, String id, float price, String name, String category, String decription)
        throws IOException {
        Document doc = new Document();
        doc.add(new StringField("id", id, Field.Store.YES));
        doc.add(new FloatPoint("_price", price));
        doc.add(new TextField("price", String.valueOf(price), Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("category", category, Field.Store.YES));
        doc.add(new TextField("description", decription, Field.Store.YES));
        
        w.addDocument(doc);
    }
    
    private static void zad0() throws IOException, ParseException
    {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new RAMDirectory();
        
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        
        IndexWriter w = new IndexWriter(index, config);
        addDoc(w, "Lucene in Action", "193398817");
        addDoc(w, "Lucene for Dummies", "55320055Z");
        addDoc(w, "Managing Gigabytes", "55063554A");
        addDoc(w, "The Art of Computer Science", "9900333X");
        w.close();
        
        // 2. query
        System.out.println("querry: ");
        Scanner in = new Scanner(System.in);
        String querystr = in.nextLine();
//      String querystr = args.length > 0 ? args[0] : "lucene";
        
        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
        Query q = new QueryParser("title", analyzer).parse(querystr);
        
        // 3. search
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        
        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for(int i=0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
        }

        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
    }
    
    private static IndexWriter createWriter(String path) throws IOException
    {
        FSDirectory dir = FSDirectory.open(Paths.get(path));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(dir, config);
        return writer;
    }
    
    private static IndexSearcher createSearcher(String path) throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get(path));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }
    
    private static TopDocs searchById(Integer id, IndexSearcher searcher) throws Exception
    {
        QueryParser qp = new QueryParser("id", new StandardAnalyzer());
        Query idQuery = qp.parse(id.toString());
        TopDocs hits = searcher.search(idQuery, 10);
        return hits;
    }
    
    private static TopDocs searchByFirstName(String firstName, IndexSearcher searcher) throws Exception
    {
        QueryParser qp = new QueryParser("firstName", new StandardAnalyzer());
        Query firstNameQuery = qp.parse(firstName);
        TopDocs hits = searcher.search(firstNameQuery, 10);
        return hits;
    }
    
//    public static void displayHits(Hits hits) throws CorruptIndexException, IOException {
//        System.out.println("Number of hits: " + hits.length());
//
//        Iterator<Hit> it = hits.iterator();
//        while (it.hasNext()) {
//                Hit hit = it.next();
//                Document document = hit.getDocument();
//                String path = document.get(FIELD_PATH);
//                System.out.println("Hit: " + path);
//        }
//        System.out.println();
//    }
    
    public static void searchIndexRange(String filedName, int f, int l) throws IOException, ParseException {
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);

        QueryParser queryParser = new QueryParser(filedName, new StandardAnalyzer());
        //Query query = queryParser.parse(searchString);
        Query query = FloatPoint.newRangeQuery(filedName, f, l);
        
        System.out.println("Type of query: " + query.getClass().getSimpleName());
        
        TopDocs hits = searcher.search(query, reader.numDocs());
        
        for (ScoreDoc sd : hits.scoreDocs)
        {
            Document d = searcher.doc(sd.doc);
            System.out.println(
                d.get(FIELD_ID) + 
                "\t" + d.get("price")
            );
        }
    }
    
    public static void searchIndexWithQueryParser(String searchString, String filedName) throws IOException, ParseException {
        System.out.println("Searching for '" + searchString + "' using QueryParser");
        
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);

        QueryParser queryParser = new QueryParser(filedName, new StandardAnalyzer());
        Query query = queryParser.parse(searchString);
        System.out.println("Type of query: " + query.getClass().getSimpleName());
        
        TopDocs hits = searcher.search(query, reader.numDocs());
        
        List<Item> lista = new ArrayList<Item>();
        
        for (ScoreDoc sd : hits.scoreDocs)
        {
            Document d = searcher.doc(sd.doc);
//            System.out.println(
//                d.get(FIELD_ID) + 
//                "\t" + d.get(filedName)
//            );
            Item it = new Item();
            it.setCategory(d.get("category"));
            it.setDescription(d.get("description"));
            it.setId(Integer.parseInt(d.get("id")));
            it.setName(d.get("name"));
            it.setPrice(Float.parseFloat(d.get("price")));
            
            lista.add(it);
        }
        
        Collections.sort(lista, new Comparator<Item>(){
        public int compare(Item o1, Item o2){
            if(o1.getPrice() == o2.getPrice())
                return 0;
            return o1.getPrice()< o2.getPrice() ? -1 : 1;
        }
        });
        
        for(int x = 0;x<lista.size();x++)
        {
            System.out.println((x+1) + ". " +lista.get(x).getName() + " - " + lista.get(x).getCategory()+ " - " + lista.get(x).getPrice());
        }
    }
    
//    private static TopDocs searchAnotB(String A, String B, IndexSearcher searcher) throws Exception
//    {
//        QueryParser qp = new QueryParser("firstName", new StandardAnalyzer());
//        
//        Query query1 = new TermQuery(new Term(FIELD_NAME, A));
//        Query query2 = new TermQuery(new Term(FIELD_NAME, B));
//        
//        BooleanQuery booleanQuery = new BooleanQuery();
//        
//        booleanQuery.add(query1, BooleanClause.Occur.MUST);
//        booleanQuery.add(query2, BooleanClause.Occur.MUST);
//        
//        System.out.println("Query: " + booleanQuery.toString());
//        
//        Query firstNameQuery = qp.parse(booleanQuery);
//        TopDocs hits = searcher.search(firstNameQuery, 10);
//        return hits;
//    }
    
 
    private static void zad1() throws IOException, ParseException, Exception
    {
        
        IndexWriter w = createWriter(INDEX_DIR);
        w.deleteAll();
        
        try (ItemProvider provider = new ItemProvider(PATH)) {
            while (provider.hasNext()) {
                Item item = provider.next();
                // TODO index item
                
                String id = Integer.toString(item.getId());
                Float price = item.getPrice();
                String name = item.getName();
                String category = item.getCategory();
                
                String description = item.getDescription();
                        
                addItem(w, id, price, name, category, description);
            }
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
        
        w.commit();
        w.close();
         
        // 2. query
//        System.out.println("querry: ");
//        Scanner in = new Scanner(System.in);
//        String querystr = in.nextLine();
        
        // 3. search
        //A OK
//        searchIndexWithQueryParser("+Lustrzanka -D90", FIELD_NAME);
        //B OK
//        searchIndexWithQueryParser("name:(Lustrzanka) description:(megapiksela OR stabilizator)", FIELD_DESCRIPTION);
        // C OK
//        searchIndexWithQueryParser("S*y", FIELD_CATEGORY);
        // D OK Toory
//         searchIndexWithQueryParser("Toora~2", FIELD_NAME);
        // E NOT OK
//        searchIndexWithQueryParser("_price:{0.0 TO 59.0}", FIELD_PRICE);
        searchIndexRange(FIELD__PRICE, 0, 59);
        
//            Query dvQuery = SortedNumericDocValuesField.newRangeQuery(FIELD_PRICE,
//                    NumericUtils.floatToSortableInt(0),
//                    NumericUtils.floatToSortableInt(59));
//            query = new IndexOrDocValuesQuery(query, dvQuery);
        
        
        
        
        
//        IndexSearcher searcher = createSearcher(INDEX_DIR);
//        TopDocs foundDocs = searchById(1915, searcher);
//        
//        // 4. display results
//        System.out.println("Total Results :: " + foundDocs.totalHits);
//        
//        for (ScoreDoc sd : foundDocs.scoreDocs)
//        {
//            Document d = searcher.doc(sd.doc);
//            System.out.println(d.get(FIELD_ID) + "\t" + d.get(FIELD_NAME));
//            //System.out.println(String.format(d.get("id")));
//        }
    }
    
    public static void main(String[] args) throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException, FileNotFoundException, XMLStreamException, Exception {
//        zad0();
        zad1();
    }
}
