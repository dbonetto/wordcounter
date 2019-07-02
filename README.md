# WordCounter

This is a command-line application that takes a path to a file as an argument and prints a word count of its contents.
The output consists of a line for each word sorting them by the number of occurrences beginning with the most frequent word.

## Installation

Use maven from command-line to create the executable .jar file:

```
mvn package
```

The output file ``` target/wordcounter-1.0-SNAPSHOT.jar``` will be available at the end of the build process. 

## Usage

You can run wordcounter application from command line:

```
java -jar ${jar-file-path} ${target-file-path}
```

You can easily test this application from the project folder using the test resource files in ```src/test/resources``` folder.

```
java -jar target/wordcounter-1.0-SNAPSHOT.jar src/test/resources/test1.txt
```

The files contain exactly the same words, but in a different order. Please note that using both files won't change the result.