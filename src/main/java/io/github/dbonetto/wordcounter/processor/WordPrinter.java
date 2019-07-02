package io.github.dbonetto.wordcounter.processor;

import lombok.extern.log4j.Log4j;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j
public class WordPrinter {

	private Comparator<Map.Entry<String, Long>> comparator;

	public WordPrinter(Comparator<Map.Entry<String, Long>> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Prints words and frequencies on output
	 * @param words
	 */
	public void print(Map<String, Long> words) {
		words.entrySet().stream()
				.sorted(comparator)
				.collect(Collectors.toList())
				.forEach(word -> printWord(word.getKey(), word.getValue()));
	}

	private void printWord(String word, long count) {
		log.info(MessageFormat.format("{0}: {1}", word, count));
	}
}