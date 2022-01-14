package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
/**
 * WriteSymptomOccurrenceToConsole class writes list of symptoms and their associated occurrences to console
 */
public class WriteSymptomOccurrenceToConsole implements ISymptomOccurrenceWriter {

    /**
     * Formats and writes list of symptom/occurrences to standard output
     *
     * @param symptomsOccurrences list of symptom/occurrences key-value pairs.
     *                            Symptoms keys are sorted by natural order.
     */
    @Override
    public void write(SortedMap<String, Integer> symptomsOccurrences) {

       for (String symptom : symptomsOccurrences.keySet()) {
            System.out.println(symptom + " : " + symptomsOccurrences.get(symptom));
        }
    }
}
