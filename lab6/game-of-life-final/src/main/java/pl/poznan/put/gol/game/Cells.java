package pl.poznan.put.gol.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Cells implements Iterable<Cell> {

//	protected List<Cell> cells;
        protected Set<Cell> cellsSet;

	public Cells(Cell... cells) {
//		this.cells = Arrays.asList(cells);
                this.cellsSet = new HashSet(Arrays.asList(cells));
	}

	public Cells() {
//		this.cells = new ArrayList<>();
                this.cellsSet = new HashSet();
	}

	public Cells getNeighbors() {
                Cells cc = new Cells();
//		for(Cell c2 : this.cells)
//                {
//                    cc.addAll(c2.neighbors());
//                }
                for(Cell c2 : this.cellsSet){
                    cc.addAll(c2.neighbors());
                }
                
                return cc;
	}

	public boolean isEmpty() {
//		return cells.isEmpty();
                return cellsSet.isEmpty();
	}

	public int size() {
//		return cells.size();
                return cellsSet.size();
	}

	public void add(Cell cell) {
//		if (cells.contains(cell)) {
//			return;
//		}
//		cells.add(cell);
                
                if (cellsSet.contains(cell)) {
                    return;
                }
                cellsSet.add(cell);
	}

	public void addAll(Iterable<? extends Cell> cells) {
		cells.forEach((cell) -> {
			add(cell);
		});
	}

	@Override
	public Iterator<Cell> iterator() {
//		return cells.iterator();
                return cellsSet.iterator();
	}

	public boolean contains(Cell cell) {
//		return cells.contains(cell);
                return cellsSet.contains(cell);
	}

	public void remove(Cell cell) {
//		cells.remove(cell);
                cellsSet.remove(cell);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cells)) {
			return false;
		}
		Cells other = (Cells) obj;
//		if (!cells.stream().noneMatch((cell) -> (!other.contains(cell)))) {
//			return false;
//		}
//		if (!other.cells.stream().noneMatch((cell) -> (!contains(cell)))) {
//			return false;
//		}

                if (!cellsSet.stream().noneMatch((cell) -> (!other.contains(cell)))) {
			return false;
		}
		if (!other.cellsSet.stream().noneMatch((cell) -> (!contains(cell)))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
//		return cells.toString();
                return cellsSet.toString();
	}
}
