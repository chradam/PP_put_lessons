package pl.poznan.put.gol.game;

public class Generation {

	private Rules rules;
	private Cells aliveCells;

	public Generation(Rules rules, Cell... aliveCells) {
		this(rules, new Cells(aliveCells));
	}

	public Generation(Rules rules, Cells aliveCells) {
		this.rules = rules;
		this.aliveCells = aliveCells;
	}

	public void evolve() {
		// TODO implement method Generation#evolve()
		// throw new UnsupportedOperationException("Not implemented yet.");
                Cells Gprim = new Cells();
		for(Cell cr : aliveCells.getNeighbors())
                {
                    if(rules.inNextGeneration(isAlive(cr), countAliveNeighbors(cr)))
                    {
                        Gprim.add(cr);
                    }
                }
                aliveCells = Gprim;
        }

	public boolean isAlive(Cell cell) {
		// TODO implement method Generation#isAlive()
		//throw new UnsupportedOperationException("Not implemented yet.");
                return this.aliveCells.contains(cell);
        }

	public int countAliveNeighbors(Cell cell) {
		// TODO implement method Generation#countAliveNeighbors()
		// throw new UnsupportedOperationException("Not implemented yet.");
                int numberOfAliveNeighbors = 0;
                
                for(Cell neighbour : cell.neighbors()) {
                    if(isAlive(neighbour))
                        numberOfAliveNeighbors++;
                }
                
                return numberOfAliveNeighbors;
        }

	public boolean extinct() {
		return aliveCells.isEmpty();
	}

	public Cells getAliveCells() {
		return aliveCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Generation)) {
			return false;
		}
		Generation other = (Generation) obj;
		return aliveCells.equals(other.aliveCells);
	}
}
