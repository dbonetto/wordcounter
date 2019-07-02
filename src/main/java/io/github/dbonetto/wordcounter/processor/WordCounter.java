package io.github.dbonetto.wordcounter.processor;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Function;

@Log4j
public class WordCounter {

	private Function<File, Map<String, Long>> parser;

	public WordCounter(Function<File, Map<String, Long>> parser) {
		this.parser = parser;
	}

	/**
	 * Parse file and return words map with frequencies
	 * @param file
	 * @return words map
	 */
	public Map<String, Long> parseFile(File file) {
		log.info(MessageFormat.format("Processing file: {0}", file.getName()));
		return parser.apply(file);
	}
}