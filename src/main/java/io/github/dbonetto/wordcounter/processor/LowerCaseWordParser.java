package io.github.dbonetto.wordcounter.processor;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

@Log4j
public class LowerCaseWordParser implements Function<File, Map<String, Long>> {

	@Override
	public Map<String, Long> apply(File file) {
		HashMap<String, Long> words = new HashMap<>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase();
				if (word.endsWith(".")) word = word.replace(".", "");
				addOccurrence(words, word);
			}
		} catch (FileNotFoundException e) {
			log.error(MessageFormat.format("File not found: {0}", file.getName()));
		}
		return words;
	}

	private void addOccurrence(Map<String, Long> words, String word) {
		long count = (words.containsKey(word)) ? words.get(word) : 0;
		// increment word counter and add to map
		count++;
		words.put(word, count);
	}
}
