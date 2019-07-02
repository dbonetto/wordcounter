package io.github.dbonetto.wordcounter;

import io.github.dbonetto.wordcounter.processor.WordProcessor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;

import static java.lang.System.exit;

@Log4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	WordProcessor processor;

	public static void main(String[] args) {
		log.info(MessageFormat.format("Running with arguments: {0}", Arrays.toString(args)));
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) {
		switch (args.length) {
			case 0:
				// missing args
				log.error("Missing arguments");
				exit(1);
				break;
			case 1:
				// filename passed
				processFile(args[0]);
				break;
			default:
				// invalid args
				log.error(MessageFormat.format("Invalid arguments: {0}", Arrays.toString(args)));
				exit(2);
				break;
		}
	}

	private void processFile(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			try {
				processor.processFile(file);
				exit(0);
			} catch (Exception e) {
				log.error(MessageFormat.format("Error processing file: {0}", e));
				exit(3);
			}
		} else {
			log.error(MessageFormat.format("File not found: {0}", filename));
			exit(2);
		}
	}
}