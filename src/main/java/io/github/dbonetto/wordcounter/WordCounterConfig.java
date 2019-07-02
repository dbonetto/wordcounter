package io.github.dbonetto.wordcounter;

import io.github.dbonetto.wordcounter.processor.WordProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfig {

	@Bean
	public WordProcessor wordProcessor() {
		return new WordProcessor();
	}
}
