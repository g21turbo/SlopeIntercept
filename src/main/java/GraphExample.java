import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class GraphExample extends JFrame {

    public GraphExample(String title, double m, double b) {
        super(title);

        // Create dataset
        XYSeries series = new XYSeries("y = " + m + "x + " + b);
        for (double x = -10; x <= 10; x += 0.1) {
            double y = m * x + b;
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Create panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static void main(String[] args) {
        GraphExample example = new GraphExample("y = 2x + 3", 2, 3);
        example.setSize(800, 600);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
