package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class computes the occurrences of symptoms.
 *
 * Symptoms occurrences are added by using
 * {@link #updateSymptomOccurrences(ISymptomReader, boolean) updateSymptomOccurrences} method.
 *
 */
public class AnalyticsCounter {

	/**
	 * symptomOccurrences holds symptoms and their associated occurrences as a key/value map.
	 *  Where keys are symptoms (lowercase String) and values are occurrences (Integer).
	 *  TreeMap type guarantees that Symptoms will be sorted in natural String order.
	 */
	private TreeMap<String, Integer> symptomOccurrences = new TreeMap<>();

	/**
	 * The updateSymptomOccurrences method computes the occurrences of symptoms from a list of
	 * symptoms given by an {@link com.hemebiotech.analytics.ISymptomReader ISymptomReader}
	 *
	 * Several list of symptoms from different sources (different ISymptomReader) can be aggregated by AnalyticsCounter.
	 * To do that, call updateSymptomOccurrences for each source, with the parameter "append" set to true.
	 *
	 * @param reader list of symptoms provider
	 * @param append True: aggregate new occurrences to already registered ones. False: flush already registered occurrences
	 *
	 */
	public void updateSymptomOccurrences(ISymptomReader reader, boolean append) {

		if(!append) {
			/* flush already registered symptom occurrences when "append" is set to false */
			symptomOccurrences.clear();
		}

		if(reader != null) {

			List<String> symptoms = reader.GetSymptoms();

			if(symptoms != null){
				for(String symptom : symptoms) {
					if(symptom != null)	{
						/*symptom keys shall be lowercase*/
						symptom = symptom.toLowerCase(Locale.ROOT).trim();

						/*Add symptom to symptomOccurrences map with occurrence set to 1 if symptom is not already present
						  Otherwise increment the occurrence by 1 */
						symptomOccurrences.merge(symptom, 1, Integer::sum);
					}
				}
			}
		}
	}

	/**
	 * The print method writes the symptoms/occurrences dictionary to an output through an
	 *  {@link com.hemebiotech.analytics.ISymptomOccurrenceWriter ISymptomOccurrenceWriter}
	 *
	 * Several list of symptoms from different sources (different ISymptomReader) can be aggregated by AnalyticsCounter.
	 * To do that, call updateSymptomOccurrences for each source, with the parameter "append" set to true.
	 *
	 * @param symptomOccurrenceWriter Anything that will write list of symptoms and their associated occurrence to an output
	 */
	public void print(ISymptomOccurrenceWriter symptomOccurrenceWriter) {
		if(symptomOccurrenceWriter != null)
		{
			/*to guarantee encapsulation, do not give access to symptomOccurrences from the outside,
				pass a copy of it
			 */
			symptomOccurrenceWriter.write(new TreeMap<String,Integer>(symptomOccurrences));
		}
	}
}
