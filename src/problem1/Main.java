package problem1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	static Path path = Paths.get("D:/csvFile.csv");
	public static void main(String[] args) {		
		try {
			new FileProcessor(path).process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
