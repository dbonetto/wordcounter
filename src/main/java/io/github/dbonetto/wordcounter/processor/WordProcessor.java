package io.github.dbonetto.wordcounter.processor;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

public class WordProcessor {

	private WordCounter counter;
	private WordPrinter printer;

	public WordProcessor() {
		init();
	}

	private void init() {
		this.counter = new WordCounter(new LowerCaseWordParser());
		Comparator<Map.Entry<String, Long>> comparator = Comparator.comparingLong(word -> word.getValue());
		this.printer = new WordPrinter(comparator.reversed());
	}

	/**
	 * Process file and prints words and frequencies in decreasing order
	 * @param file
	 */
	public void processFile(File file) {
		printer.print(counter.parseFile(file));
	}
}
