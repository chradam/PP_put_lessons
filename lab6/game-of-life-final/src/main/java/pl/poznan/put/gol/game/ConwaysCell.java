package pl.poznan.put.gol.game;

import java.util.Arrays;

public class ConwaysCell implements Cell {

	public int i;
	public int j;

	public ConwaysCell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public Cells neighbors() {
            Cells neighbors = new Cells();
            for (int k = -1; k < 2; k++) {
                for (int l = -1; l < 2; l++) {
                    if (k == 0 && l == 0)
                        continue;
                    neighbors.add(new ConwaysCell(i - k, j - l));
                }
            }
            return neighbors;
	}

	@Override
	public String toString() {
		return "c(" + i + ":" + j + ")";
	}
        @Override
        public int hashCode() {
            final int[] numbers = {i, j};
            return Arrays.hashCode(numbers);
        }
        
        public boolean equals(Object  obj)
        {
            if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		final ConwaysCell cell = (ConwaysCell) obj;

		if (this.i == cell.i && this.j == cell.j)
			return true;
		else
			return false;
        }
}
