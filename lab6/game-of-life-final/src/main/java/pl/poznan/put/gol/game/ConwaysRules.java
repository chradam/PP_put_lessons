package pl.poznan.put.gol.game;

public class ConwaysRules implements Rules {

	@Override
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {
		if(alive)
                {
                    if(numberOfNeighbors == 2 || numberOfNeighbors == 3)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if(numberOfNeighbors == 3)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
	}

}
