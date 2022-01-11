package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

/**
 * WriteSymptomOccurrenceToFile class writes list of symptoms and their associated occurrences to a text file
 */
public class WriteSymptomOccurrenceToFile implements ISymptomOccurrenceWriter {

    private String filePath;

    /**
     * ReadSymptomDataFromFile
     *
     * @param filePath a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomOccurrenceToFile(String filePath)  {
        this.filePath = filePath;
    }

    /**
     * Formats and writes list of symptom/occurrences to text file
     *
     * @param symptomsOccurrences list of symptom/occurrences key-value pairs.
     *                                  Symptoms keys are sorted by natural order.
     */
    @Override
    public void write(SortedMap<String, Integer> symptomsOccurrences) {
       try {
           FileWriter fileWr = new FileWriter(filePath);
           for(String symptom: symptomsOccurrences.keySet()) {
               fileWr.write(symptom + " : " + symptomsOccurrences.get(symptom) + System.lineSeparator());
           }
           fileWr.close();
       }
       catch(IOException e){
           e.printStackTrace();
       }
    }
}
