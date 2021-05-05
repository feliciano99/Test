package problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileProcessor {
	private final Path source;

	public FileProcessor(Path source) {
		this.source = source;
	}

	public void process() throws IOException {
		FileConsumerFactory fileConsumerFactory = new FileConsumerFactory();
		try (Stream<String> stream = Files.lines(source)) {
			stream.forEach(line -> {
				List<String> row = List.of(line.split(";"));
				if (true) {
					FileConsumer fileConsumer = fileConsumerFactory.createFileConsumer(line);
					fileConsumer.consume(line);
				}
			});
		}
	}
	
}
