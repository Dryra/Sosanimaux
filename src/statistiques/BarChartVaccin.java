package statistiques;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartVaccin {

//    public BarChartVaccin(final String title) throws IOException {
//        super(title);
//        final CategoryDataset dataset = createDataset();
//        final JFreeChart graphe = createChart(dataset);
//        final ChartPanel chartPanel = new ChartPanel(graphe);
//        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
//        setContentPane(chartPanel);
//    }
    public static CategoryDataset createDataset() {
        // 0. Création d'un diagramme.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //Valeurs statiques
        dataset.addValue(10, "Vacciné", " ");
        dataset.addValue(12, "Non vacciné", " ");
        return dataset;
    }

    public static JFreeChart createChart(String title) {

        JFreeChart chart = ChartFactory.createBarChart3D(
                title, // chart title
                " ", // domain axis label
                "  Le nombre des animaux", // range axis label
                createDataset(), // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                true // urls
                );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        return chart;
    }
//    public static void main(final String[] args) throws IOException {
//        final BarChart demo = new BarChart("Test de la couverture ");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//    }
}
