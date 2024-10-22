package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Compute {

    public static void calculateStatistics(double[] data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        for (double num : data) {
            stats.addValue(num);
        }

        double mean = stats.getMean();
        double stdDev = stats.getStandardDeviation();
        double variance = stats.getVariance();

        System.out.println("Średnia: " + mean);
        System.out.println("Odchylenie standardowe: " + stdDev);
        System.out.println("Wariancja: " + variance);
    }
}
