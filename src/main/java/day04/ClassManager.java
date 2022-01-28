package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClassManager {

    private List<Class> classes = new ArrayList<>();
    private String path;

    public ClassManager(String path) {
        this.path = path;
    }

    public int numOfClassesOfTeacher(String nameOfTeacher) {
        int sum = 0;

        populateClasses();

        for (Class cl : classes) {
            if (cl.getTutor().equals(nameOfTeacher)) {
                sum += cl.getWeeklyOcc();
            }
        }

        return sum;
    }

    public List<Class> getClasses() {
        return classes;
    }

    private List<String> fileReader() {

        List<String> result = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Path invalid, file can not be read.");
        }

        return result;
    }

    private void populateClasses() {
        List<String> rawData = fileReader();

        for (int i = 0; i < (rawData.size()/4); i++) {
            String tutor = rawData.get(i+0+i*3);
            String subject = rawData.get(i+1+i*3);
            String group = rawData.get(i+2+i*3);
            int weeklyOcc = Integer.parseInt(rawData.get(i+3+i*3));
            classes.add(new Class(tutor, subject, group, weeklyOcc));
        }
    }

    public static void main(String[] args) {
        ClassManager cm = new ClassManager("src/test/resources/beosztas.txt");
        int sumOfWeeklyCassesBy = cm.numOfClassesOfTeacher("Albatrosz Aladin");
        System.out.println(sumOfWeeklyCassesBy);
    }
}
