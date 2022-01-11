package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

/**
 * Anything that will write list of symptoms and their associated occurrence to an output
 *
 */
public interface ISymptomOccurrenceWriter {

     /**
     * Formats and writes list of symptom/occurrences to an output
     *
     * @param symptomsOccurrences list of symptom/occurrences key-value pairs.
      *                            Symptoms keys are sorted by natural order.
     */
    void write(SortedMap<String, Integer> symptomsOccurrences);
}
