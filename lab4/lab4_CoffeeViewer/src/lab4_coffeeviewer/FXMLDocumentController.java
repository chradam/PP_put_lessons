package lab4_coffeeviewer;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 *
 * @author Adam Ch
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private VBox vbox;
    
    private CoffeeDao dao;
    private TableView<Coffee> coffeesTable;
            
    public void initialize(URL url, ResourceBundle rb) {
        dao = new CoffeeDao();
        
        //Name column
        TableColumn<Coffee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("name"));
        
        //SupplierId column
        TableColumn<Coffee, Integer> supplierIdColumn = new TableColumn<>("SupplierId");
        supplierIdColumn.setMinWidth(200);
        supplierIdColumn.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        
        //Price column
        TableColumn<Coffee, BigDecimal> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Sales column
        TableColumn<Coffee, Integer> salesColumn = new TableColumn<>("Sales");
        salesColumn.setMinWidth(200);
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));
        
        //Total column
        TableColumn<Coffee, Integer> totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(200);
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        coffeesTable = new TableView();
        coffeesTable.setItems(getCoffes());
        
        vbox.getChildren().addAll();
    }

    public List<Coffee> getCoffes(){
        return dao.getAll();
    }
    
}
