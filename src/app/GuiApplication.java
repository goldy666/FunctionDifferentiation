package app;

import functions.StringFunction;
import math.Differentiator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class GuiApplication extends JFrame {

    private final JTextField functionField;
    private final JTextField startField;
    private final JTextField stopField;
    private final JTextField stepField;
    private final JPanel chartContainer;

    public GuiApplication() {
        setTitle("Function Differentiation GUI");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        functionField = new JTextField("sin(x)");
        startField = new JTextField("1.5");
        stopField = new JTextField("6.5");
        stepField = new JTextField("0.05");

        JButton plotButton = new JButton("Plot");
        JButton exitButton = new JButton("Exit");

        chartContainer = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));

        JPanel functionPanel = new JPanel(new BorderLayout());
        functionPanel.setBorder(BorderFactory.createTitledBorder("Function"));
        functionPanel.add(new JLabel("f(x): "), BorderLayout.WEST);
        functionPanel.add(functionField, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Start:"));
        controlPanel.add(startField);
        controlPanel.add(new JLabel("Stop:"));
        controlPanel.add(stopField);
        controlPanel.add(new JLabel("Step:"));
        controlPanel.add(stepField);
        controlPanel.add(plotButton);
        controlPanel.add(exitButton);

        inputPanel.add(functionPanel);
        inputPanel.add(controlPanel);

        add(inputPanel, BorderLayout.NORTH);
        add(chartContainer, BorderLayout.CENTER);

        plotButton.addActionListener(e -> plotFunction());
        exitButton.addActionListener(e -> dispose());

        plotFunction();
    }

    private void plotFunction() {
        try {
            String expression = functionField.getText();

            double start = Double.parseDouble(startField.getText());
            double stop = Double.parseDouble(stopField.getText());
            double step = Double.parseDouble(stepField.getText());

            StringFunction function = new StringFunction(expression);
            Differentiator differentiator = new Differentiator(1e-5);

            XYSeries functionSeries = new XYSeries("Function");
            XYSeries derivativeSeries = new XYSeries("Derivative");

            for (double x = start; x <= stop; x += step) {
                functionSeries.add(x, function.value(x));
                derivativeSeries.add(x, differentiator.derivative(function, x));
            }

            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(functionSeries);
            dataset.addSeries(derivativeSeries);

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Function and Derivative",
                    "x",
                    "y",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            ChartPanel chartPanel = new ChartPanel(chart);

            chartContainer.removeAll();
            chartContainer.add(chartPanel, BorderLayout.CENTER);
            chartContainer.revalidate();
            chartContainer.repaint();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage(),
                    "Input error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiApplication().setVisible(true));
    }
}