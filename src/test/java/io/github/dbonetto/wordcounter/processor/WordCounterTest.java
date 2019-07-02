package io.github.dbonetto.wordcounter.processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class WordCounterTest {

	@Test
	public void parseFileWrongFrequency() throws FileNotFoundException {
		File file = new File("src/test/resources/test1.txt");
		WordCounter counter = new WordCounter(new LowerCaseWordParser());
		Map<String, Long> words = counter.parseFile(file);
		Assert.assertNotEquals(10, words.get("ipsum").longValue());
	}

	@Test
	public void parseSameContent() throws FileNotFoundException {
		parseLoremIpsumFile(new File("src/test/resources/test1.txt"));
		parseLoremIpsumFile(new File("src/test/resources/test2.txt"));
	}

	private void parseLoremIpsumFile(File file) throws FileNotFoundException {
		WordCounter counter = new WordCounter(new LowerCaseWordParser());
		Map<String, Long> words = counter.parseFile(file);
		Assert.assertEquals(98, words.keySet().size());
		Assert.assertEquals(1, words.get("lorem").longValue());
		Assert.assertEquals(2, words.get("ipsum").longValue());
	}
}