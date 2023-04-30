package novalsmandala.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVTest {

    @Test
    void createCSV() throws IOException {
        StringWriter stringWriter = new StringWriter();

        Path path = Path.of("person.csv");
        Writer writer = Files.newBufferedWriter(path);

        CSVPrinter csvFilePrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        CSVPrinter csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);

        csvFilePrinter.printRecord("Noval", "Mandala", 18);
        csvFilePrinter.printRecord("Eko", "Khannedy", 30);
        csvFilePrinter.flush();

        csvPrinter.printRecord("Noval", "Mandala", 18);
        csvPrinter.printRecord("Eko", "Khannedy", 30);
        csvPrinter.flush();

        System.out.println(stringWriter.getBuffer().toString());
    }

    @Test
    void readCSV() throws IOException {
        Path path = Path.of("person.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVParser csvRecords = new CSVParser(reader, CSVFormat.DEFAULT);
        for (var record: csvRecords) {
            System.out.println("First Name: " + record.get(0));
            System.out.println("Last Name: " + record.get(1));
            System.out.println("Age: " + record.get(2));
        }
    }

    @Test
    void readCSVWithHeader() throws IOException {
        Path path = Path.of("person-with-header.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser csvRecords = new CSVParser(reader, csvFormat);
        for (var record : csvRecords) {
            System.out.println("First Name: " + record.get("First Name"));
            System.out.println("Last Name: " + record.get("Last Name"));
            System.out.println("Age: " + record.get("Age"));
        }
    }

    @Test
    void createCSVWithHeader() throws IOException {
        Path path = Path.of("person-with-header.csv");
        Writer writer = Files.newBufferedWriter(path);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader("First Name", "Last Name", "Age").build();
        CSVPrinter csvFilePrinter = new CSVPrinter(writer, csvFormat);

        csvFilePrinter.printRecord("Noval", "Mandala", 18);
        csvFilePrinter.printRecord("Jack", "Sparrow", 40);
        csvFilePrinter.printRecord("Erling", "Halaand", 22);
        csvFilePrinter.flush();

        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    void createCSVWithFormat() throws IOException {
        StringWriter stringWriter = new StringWriter();
        CSVFormat csvFormat = CSVFormat.TDF.builder().setHeader("First Name", "Last Name", "Age").build();
        CSVPrinter csvPrinter = new CSVPrinter(stringWriter, csvFormat);

        csvPrinter.printRecord("Noval", "Mandala", 18);
        csvPrinter.printRecord("Jack", "Sparrow", 40);
        csvPrinter.printRecord("Erling", "Halaand", 22);
        csvPrinter.flush();

        System.out.println(stringWriter.getBuffer().toString());
    }
}
