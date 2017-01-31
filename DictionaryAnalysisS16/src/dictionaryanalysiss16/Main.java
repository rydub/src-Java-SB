package dictionaryanalysiss16;

import static java.lang.System.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		long start = nanoTime();
		List<String> words = readLines(new File("full_dictionary.txt"));
		long end = nanoTime();
		out.println("It took " + (end - start) / 1e6 + "ms");
		out.println("There are " + words.size() + " words in the dictionary.");

		List<String> last5Words = words.subList(words.size() - 5, words.size());

		out.println(join(last5Words, ", "));

		String longestWord = "";

		for (String word : words)
			if (word.length() > longestWord.length())
				longestWord = word;

		out.println(longestWord);


	}

}
