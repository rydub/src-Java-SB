import static java.lang.System.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		try {
			String quakeText = readFileToString(new File("4.5_week.atom"));
			String[] quakes = substringsBetween(quakeText, "<title>M ", "</title>");
			out.println(join(quakes, "\n"));

			double largestMag = 0.0;
			String largestLoc = "";
			for (String quake : quakes) {
				String magText = substringBefore(quake, " - ");
				String magLoc = substringAfter(quake, " - ");
				double mag = Double.parseDouble(magText);
				if (mag > largestMag) {
					largestMag = mag;
					largestLoc = magLoc;
				}
			}

			out.println("The largest quake this week was a " + largestMag + " at " + largestLoc);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
