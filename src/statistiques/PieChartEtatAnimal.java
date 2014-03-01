/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistiques;

import Dao.AnimalDAO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChartEtatAnimal {

    private static final long serialVersionUID = 1L;

    public static PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        AnimalDAO anDAO = new AnimalDAO();

        result.setValue("Perdu", anDAO.getAnimalEtatPerdu());
        result.setValue("Sans refuge", anDAO.getAnimalEtatSansRefuge());
        result.setValue("Sans foyer", anDAO.getAnimalEtatSansFoyer());

        return result;

    }

    /**
     * Creates a chart
     */
    public static JFreeChart createChart(String title) {


        JFreeChart chart = ChartFactory.createPieChart3D(title, // chart title
                createDataset(), // data
                true, // include legend
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}
