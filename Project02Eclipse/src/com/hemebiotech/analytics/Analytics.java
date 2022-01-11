package com.hemebiotech.analytics;

/**
 * Analytics class holds the main method of the program.
 */
public class Analytics {

    /**
     * main method of the program
     *
     * @param args array of parameters
     *
     */
    public static void main(String args[]) {

        AnalyticsCounter counter = new AnalyticsCounter();

        /*read symptoms from input file and compute occurrences*/
        counter.updateSymptomOccurrences(new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt"), false);
    }
}
