package com.hemebiotech.analytics;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadSymptomDataFromFile class read symptoms list from a text file
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * ReadSymptomDataFromFile
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * The GetSymptoms method reads line by line a text file that contains symptom strings (one per line)
	 *
	 * @return a list of symptom strings that may contain many duplications. If no data in text file, returns an empty list.
	 */
	@Override
	public List<String> GetSymptoms() {
		List<String> symptoms = new ArrayList<String>();

		if (filepath != null) {
			try {
				symptoms = Files.readAllLines(Paths.get(filepath), Charset.defaultCharset());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return symptoms;
	}
}
