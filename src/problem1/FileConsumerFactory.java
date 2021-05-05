package problem1;

public class FileConsumerFactory {
	FileConsumer createFileConsumer(String line) {
		// Some logic here to create a valid file consumer.
		// For this example it only return a Default File Consumer
		return new DefaultFileConsumer();
	}
}
