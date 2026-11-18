package evolutionSimulation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class HeatmapPanel extends JPanel {
	    private final double[][] fitness;

	    HeatmapPanel(double[][] fitness) {
	        this.fitness = fitness;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        int generations = fitness.length;
	        int elements = fitness[0].length;
	        int cellWidth = getWidth() / generations;
	        int cellHeight = getHeight() / elements;

	        for (int gen = 0; gen < generations; gen++) {
	            for (int i = 0; i < elements; i++) {
	                double f = Math.max(0, Math.min(1, fitness[gen][i]));
	                g.setColor(new Color((float) (1 - f), (float) f, 0));
	                g.fillRect(gen * cellWidth, i * cellHeight,
	                           cellWidth, cellHeight);
	            }
	        }
	    }
}

