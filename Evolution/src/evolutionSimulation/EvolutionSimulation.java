package evolutionSimulation;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class EvolutionSimulation {

	public static void main(String[] args) {
		double k = 0.75;
		int n = 50;
		int G = 50;
		double[][] fitnessMap = new double[G][n];
		double[] averages = new double[n];
		double[] variances = new double[n];
		
		// TODO Auto-generated method stub
		Population p = new Population(n);
		p.printPopulation();
		for(int i = 0; i < G; i++) {
			averages[i] = p.getPopulationAverage();
			variances[i] = p.getPopulationVariance();
			fitnessMap[i] = p.fitnessArray();
			p.nextGeneration(k);
		}
		p.printPopulation();
		//heatmap representation
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Evolution Simulator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new HeatmapPanel(fitnessMap));
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null); // center on screen
            frame.setVisible(true);
            
        });
        //graph averages and variances
        JFrame frameAverage = new JFrame("Averages");
        JFrame frameVariance = new JFrame("Variances");
        GraphComponent averageGraph = new GraphComponent(averages);
        GraphComponent varianceGraph = new GraphComponent(variances);
        frameAverage.add(averageGraph);
        frameVariance.add(varianceGraph);
        frameAverage.setSize(400, 400);
        frameAverage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAverage.setVisible(true);
        frameVariance.setSize(400, 400);
        frameVariance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameVariance.setVisible(true);
		
	}

}
