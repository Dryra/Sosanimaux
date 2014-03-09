/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistiques;

import Dao.DaoInt;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChartSexeAdherants {

    private static final long serialVersionUID = 1L;

//  public PieChart(String applicationTitle, String chartTitle) {
//        // This will create the dataset
//        PieDataset dataset = createDataset();
//        // based on the dataset we create the chart
//        JFreeChart chart = createChart(dataset, chartTitle);
//        // we put the chart into a panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        // default size
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        // add it to our application
//
//    }
    /**
     * Creates a sample dataset
     */
    public static PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        DaoInt adhDAO = new DaoInt();

        result.setValue("Masculin", adhDAO.getAdherantMasculin());
        result.setValue("Femin", adhDAO.getAdherantFeminin());


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
