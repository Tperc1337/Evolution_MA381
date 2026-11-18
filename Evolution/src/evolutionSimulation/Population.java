package evolutionSimulation;
import java.util.ArrayList;
public class Population {
	private int N; //population size
	
	public int getSize() {
		return N;
	}
	public void setSize(int n) {
		N = n;
	}
	
	private ArrayList<Organism> population = new ArrayList<Organism>(N);
	
	public Population(int n) {
		this.setSize(n);
		for(int i = 0; i < n; i++) { //first generation of organisms with random fitness
			Organism element = new Organism();
			population.add(element);
		}
	}
	
	public double getPopulationAverage() {
		double average = 0;
		for(int i=0; i < N; i++) {
			average += population.get(i).getFitness();
		}
		average /= N;
		
		return average;
	}
	
	public double getPopulationVariance() {
		double average = this.getPopulationAverage();
		double variance = 0;
		for(int i = 0; i < N; i++) {
			variance += Math.pow(population.get(i).getFitness()-average, 2);
		}
		variance /= N;
		return variance;
	}

	public void nextGeneration(double k){ // k is mutation chance
		double sumFitness = 0;
		double cumulativeSum = 0; 
		double target = 0; // based on total fitness
		double compare; // compare to k
		ArrayList<Organism> nextGen = new ArrayList<Organism>();

		for(int i = 0; i < N; i++) {
			sumFitness += population.get(i).getFitness();
		}
		if(sumFitness == 0) {
			return;
		}
		while(nextGen.size() < population.size()) {
			cumulativeSum = 0;
			target = Math.random() * sumFitness;
			//System.out.println(target);
			for(int i = 0; i < N; i++) {
				if(cumulativeSum < target) {
					cumulativeSum += population.get(i).getFitness();
				}
				else {
					nextGen.add(population.get(i));
				}
			}
		}
		//fitness reduction and mutation
		
		for(int i = 0; i < N; i++) {
			
			compare = Math.random();
			if(compare > k) { //mutate probability of 1-k
				nextGen.get(i).setFitness((nextGen).get(i).getFitness()+(Math.random()*0.1));
			}
			//reduce fitness generally
			nextGen.get(i).setFitness((nextGen).get(i).getFitness()-(Math.random()*0.02));
			if(nextGen.get(i).getFitness() < 0) {
				nextGen.get(i).setFitness(0);
			}
			if(nextGen.get(i).getFitness() > 1) {
				nextGen.get(i).setFitness(1);
			}
		}
		population = nextGen;
	}
	public double[] fitnessArray() {
		double[] members = new double[N];
		for(int i = 0; i < N; i++) {
			members[i] = population.get(i).getFitness();
		}
		return members;
	}
	public void printPopulation() {
		for(int i = 0; i < N; i++) {
			System.out.print(population.get(i).getFitness()+" ");
		}
		System.out.println();
		System.out.print("Average:" + this.getPopulationAverage() + " Variance:" + this.getPopulationVariance());
		System.out.println();
	}
}
