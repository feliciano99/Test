package teste;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formatter {
	private final Collection<Element> entries;

	public static void main(String[] args) throws IOException {

		// ---------------------- Sample Data preparation (loaded somewhere else in a
		// real application --------------

		long timeIni = System.currentTimeMillis();
		System.out.println("timeIni: " + timeIni);
		Random r = new Random();
		final Collection<Row> rows = IntStream.range(1, 235_000).mapToObj(value -> new Row(r.nextInt(235_000)))
				.collect(Collectors.toSet());

		final Collection<Element> elementList = IntStream.range(1, 1_000_000)
				.mapToObj(value -> new Element(r.nextInt(235_000))).collect(Collectors.toSet());

    	long timeFin = System.currentTimeMillis();
    	System.out.println("timeFin: " + timeFin);
		// --------------------------------------------------------------------------------------------------------------

		// Sample use case. For the sake of simplicity in this exercise, it is
		// initialized in the main method
		final Formatter formatter = new Formatter(elementList);

		try (Writer writer = new PrintWriter(System.out)) {
			for (Row row : rows) {
				formatter.makeFlow(row, writer);
			}

			writer.flush();
		}
	}

	public Formatter(Collection<Element> entries) {
		this.entries = entries;
	}

	/**
	 * <p>
	 * Method that formats lines based on the content of the given {@code Row} and
	 * based on the content of the given list of {@code Element}. The line is
	 * formatted as follow:
	 * </p>
	 * <p>
	 * For each {@code Element id} that matches a {@code Row id}, a new line is
	 * written to the output. Each line is separated by a ';'
	 * </p>
	 */
	void makeFlow(Row row, Writer output) throws IOException {

		// Extracts only the elements which id matches the row.getId()

		final Collection<Element> matchingEntries = this.entries.stream().filter(entry -> entry.getId() == row.getId())
				.collect(Collectors.toSet());

		for (Element element : matchingEntries) {
			output.write(row.getId());
			output.write(";");
			output.write(element.getId());
			output.write(";");
			output.write(row.getContent());
			output.write(";");
			output.write(element.getContent());
			output.write(System.lineSeparator());
		}

		// This call must remains here as it is
		ExternalClass.execute(this.entries, row);
	}

	static class Row {
		private final int id;
		private final String content;

		public Row(int value) {
			this.id = value;
			this.content = "Row " + value;
		}

		public int getId() {
			return id;
		}

		public String getContent() {
			return content;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Row element = (Row) o;
			return id == element.id && Objects.equals(content, element.content);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, content);
		}
	}

	static class Element {
		private final int id;
		private final String content;

		public Element(int value) {
			this.id = value;
			this.content = "Data " + value;
		}

		public int getId() {
			return id;
		}

		public String getContent() {
			return content;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Element element = (Element) o;
			return id == element.id && Objects.equals(content, element.content);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, content);
		}
	}

	static class ExternalClass {
		public static void execute(Collection<Element> elementList, Row row) {
			// do something that does not matter to the context of this exercise
		}
	}
}
