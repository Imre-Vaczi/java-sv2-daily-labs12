package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {

    private String path;

    public Run(String path) {
        this.path = path;
    }

    public double sumRunDistance(int year, int month) {
        LocalDate targetMin = LocalDate.of(year, month, 1);
        LocalDate targetMax = targetMin.plusMonths(1);

        double distance = 0;

        for (Map.Entry<LocalDate, Double> entry : morphData(runReader()).entrySet()) {
            if (entry.getKey().isAfter(targetMin.minusDays(1)) & entry.getKey().isBefore(targetMax)) {
                distance += entry.getValue();
            }
        }
        return distance;
    }

    private List<String> runReader() {
        List <String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException("Invalid path", exception);
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Map<LocalDate, Double> morphData(List<String> rawData) {
        Map<LocalDate, Double> result = new HashMap<>();
        for (int i = 1; i < rawData.size(); i++) {
            Double length = Double.parseDouble(rawData.get(i).split(" km;")[0].trim());
            LocalDate time = LocalDate.parse(rawData.get(i).split(" km;")[1].trim());
            result.put(time, length);
        }
        return result;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
