package com.hemebiotech.analytics;

/**
 * Analytics class holds the main method of the program.
 */
public class Analytics {

    /**
     * main method of the program
     *
     * @param args array of parameters
     */
    public static void main(String args[]) {

        final String symptomInputFilePath = "./Project02Eclipse/symptoms.txt";
        final String resultOutputFilePath = "./Project02Eclipse/results.out";

        AnalyticsCounter counter = new AnalyticsCounter();

        /*read symptoms from input file and compute occurrences for each symptom*/
        counter.updateSymptomOccurrences(new ReadSymptomDataFromFile(symptomInputFilePath), false);

        counter.print(new WriteSymptomOccurrenceToFile(resultOutputFilePath));
    }
}