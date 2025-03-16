import Algorithms.InsertionSort;
import Algorithms.MergeSort;
import Algorithms.SortingAlgorithm;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] inputSizes = {5, 10, 50, 100, 250, 500, 1000, 2500, 5000, 10000, 25000, 50000, 100000};

        int[][] testArrays = generateTestArrays(inputSizes);

        Map<String, Map<Integer, Long>> algorithmResults = new HashMap<>();
        algorithmResults.put("Insertion Sort", new HashMap<>());
        algorithmResults.put("Merge Sort", new HashMap<>());
        algorithmResults.put("Quick Sort", new HashMap<>());

        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();

        int[] warmUpArray = generateRandomArray(1000);
        insertionSort.doSort(warmUpArray);

        testAlgorithm("Insertion Sort", inputSizes, testArrays, insertionSort, algorithmResults);
        testAlgorithm("Merge Sort", inputSizes, testArrays, mergeSort, algorithmResults);
        // testAlgorithm("Quick Sort", inputSizes, testArrays, Main::quickSort, algorithmResults);

        createScatterPlot(algorithmResults.get("Insertion Sort"), "Insertion Sort Performance", "Input Size", "Time (nanoseconds)", "InsertionSortScatterPlot.png");
        createScatterPlot(algorithmResults.get("Merge Sort"), "Merge Sort Performance", "Input Size", "Time (nanoseconds)", "MergeSortScatterPlot.png");
        // createScatterPlot(algorithmResults.get("Quick Sort"), "Quick Sort Performance", "Input Size", "Time (nanoseconds)", "QuickSortScatterPlot.png");

        createCombinedScatterPlot(algorithmResults, "Combined Sorting Algorithms Performance", "Input Size", "Time (nanoseconds)", "CombinedSortingAlgorithmsScatterPlot.png");
    }

    private static void testAlgorithm(String algorithmName, int[] inputSizes, int[][] testArrays, SortingAlgorithm sortingAlgorithm, Map<String, Map<Integer, Long>> algorithmResults) {
        for (int i = 0; i < inputSizes.length; i++) {
            int n = inputSizes[i];
            int[] arr = testArrays[i].clone();

            long startTime = System.nanoTime();
            int compCount = sortingAlgorithm.doSort(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            algorithmResults.get(algorithmName).put(n, elapsedTime);

            System.out.println("Algorithm: " + algorithmName + ", Input size: " + n + ", Comparisons: " + compCount + ", Elapsed time: " + elapsedTime + " nanoseconds");
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }

    private static int[][] generateTestArrays(int[] inputSizes) {
        int[][] testArrays = new int[inputSizes.length][];
        for (int i = 0; i < inputSizes.length; i++) {
            testArrays[i] = generateRandomArray(inputSizes[i]);
        }
        return testArrays;
    }

    private static void createScatterPlot(Map<Integer, Long> data, String title, String xAxisLabel, String yAxisLabel, String filename) {
        XYSeries series = new XYSeries("Performance Data");
        for (Map.Entry<Integer, Long> entry : data.entrySet()) {
            series.add(entry.getKey(), entry.getValue());
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createScatterPlot(
                title,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        addBestFitLine(dataset, renderer, 0, Color.GREEN);

        try {
            ChartUtils.saveChartAsPNG(new File(filename), chart, 800, 600);
        } catch (IOException e) {
            System.err.println("Error while saving chart as PNG.");
        }
    }

    private static void createCombinedScatterPlot(Map<String, Map<Integer, Long>> algorithmResults, String title, String xAxisLabel, String yAxisLabel, String filename) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (Map.Entry<String, Map<Integer, Long>> entry : algorithmResults.entrySet()) {
            String algorithmName = entry.getKey();
            Map<Integer, Long> data = entry.getValue();

            XYSeries series = new XYSeries(algorithmName);
            for (Map.Entry<Integer, Long> dataPoint : data.entrySet()) {
                series.add(dataPoint.getKey(), dataPoint.getValue());
            }
            dataset.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createScatterPlot(
                title,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        try {
            ChartUtils.saveChartAsPNG(new File(filename), chart, 800, 600);
        } catch (IOException e) {
            System.err.println("Error while saving chart as PNG.");
        }
    }

    /**
     * Adds a best fit line for a specific series in the dataset
     *
     * @param dataset The dataset containing the series
     * @param renderer The renderer to configure for the best fit line
     * @param seriesIndex The index of the series to add a best fit line for
     * @param lineColor The color to use for the best fit line
     */
    private static void addBestFitLine(XYSeriesCollection dataset, XYLineAndShapeRenderer renderer, int seriesIndex, Color lineColor) {
        // Calculate regression
        double[] coefficients = Regression.getOLSRegression((XYDataset)dataset, seriesIndex);
        double slope = coefficients[1];
        double intercept = coefficients[0];

        // Get series key to name the best fit line
        Comparable<?> seriesKey = dataset.getSeriesKey(seriesIndex);
        XYSeries bestFitLine = new XYSeries(seriesKey + " Best Fit");

        // Find min and max x values to draw the line
        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        for (int j = 0; j < dataset.getItemCount(seriesIndex); j++) {
            double x = dataset.getXValue(seriesIndex, j);
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
        }

        // Add points for the best fit line
        bestFitLine.add(minX, intercept + slope * minX);
        bestFitLine.add(maxX, intercept + slope * maxX);

        // Add the best fit line to the dataset
        dataset.addSeries(bestFitLine);

        // Configure the renderer for the best fit line
        int bestFitIndex = dataset.getSeriesCount() - 1;
        renderer.setSeriesLinesVisible(bestFitIndex, true);
        renderer.setSeriesShapesVisible(bestFitIndex, false);
        renderer.setSeriesPaint(bestFitIndex, lineColor);
        renderer.setSeriesStroke(bestFitIndex, new BasicStroke(2.0f));
    }
}

