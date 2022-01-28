package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AltrunManager {

    private List<Altrun> data = new ArrayList<>();
    private String path;

    public List<Altrun> getData() {
        return data;
    }

    public AltrunManager(String path) {
        this.path = path;
    }

    public double sumRuns(int year, int month) {
        LocalDate lowerThreshold = LocalDate.of(year, month, 1);
        LocalDate upperThreshold = lowerThreshold.plusMonths(1);
        readFile(path);
        double sum = 0;

        for (Altrun element : data) {
            if (element.getDate().isAfter(lowerThreshold.minusDays(1)) & element.getDate().isBefore(upperThreshold)) {
                sum += element.getDistance();
            }
        }
        return sum;
    }

    private void readFile(String path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            String line;
            bufferedReader.readLine(); // due to header
            while ((line = bufferedReader.readLine()) != null) {
                data.add(createAltrun(line));
            }
        }
        catch (IOException ioException) {
            throw new IllegalArgumentException("Provided path is invalid, file can not be accessed.", ioException);
        }

    }

    private Altrun createAltrun(String line) {
        double distance = Double.parseDouble(line.split(" km;")[0].trim());
        LocalDate date = LocalDate.parse(line.split(" km;")[1].trim());
        return new Altrun(distance, date);
    }

    public static void main(String[] args) {
        AltrunManager am = new AltrunManager("src/test/resources/running.csv");
        Altrun ar = am.createAltrun("13.5 km;2021-12-01");
        System.out.println(ar.toString());

        am.readFile("src/test/resources/running.csv");
        System.out.println(am.data.toString());
        System.out.println(am.sumRuns(2021,12));
        System.out.println(am.getData().toString());
    }
}
