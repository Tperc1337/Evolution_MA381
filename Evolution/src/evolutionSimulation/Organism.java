package evolutionSimulation;
public class Organism {
	private double fitness;

	public double getFitness() {
		return fitness;
	}
	public void setFitness(double input) {
		fitness = input;
	}
	
	public Organism() {
		fitness = Math.random();
	}
		
}
