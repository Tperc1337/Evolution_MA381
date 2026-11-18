package evolutionSimulation;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {
	    private double[] dataPoints;

	    public GraphComponent(double[] dataPoints) {
	        this.dataPoints = dataPoints;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;

	        // Set up the graph area
	        int width = getWidth();
	        int height = getHeight();
	        int padding = 50;

	        // Draw axes
	        g2.drawLine(padding, height - padding, width - padding, height - padding); // X-axis
	        g2.drawLine(padding, padding, padding, height - padding); // Y-axis

	        // Draw the graph
	        for (int i = 0; i < dataPoints.length - 1; i++) {
	            int x1 = padding + i * (width - 2 * padding) / (dataPoints.length - 1);
	            int y1 = height - padding - (int) (dataPoints[i] * (height - 2 * padding));
	            int x2 = padding + (i + 1) * (width - 2 * padding) / (dataPoints.length - 1);
	            int y2 = height - padding - (int) (dataPoints[i + 1] * (height - 2 * padding));
	            g2.drawLine(x1, y1, x2, y2);
	        }
	    }
}
