package day04;

public class Class {

    private String tutor;
    private String subject;
    private String group;
    private int weeklyOcc;

    public Class(String tutor, String subject, String group, int weeklyOcc) {
        this.tutor = tutor;
        this.subject = subject;
        this.group = group;
        this.weeklyOcc = weeklyOcc;
    }

    public String getTutor() {
        return tutor;
    }

    public String getSubject() {
        return subject;
    }

    public String getGroup() {
        return group;
    }

    public int getWeeklyOcc() {
        return weeklyOcc;
    }

    @Override
    public String toString() {
        return "Class{" +
                "tutor='" + tutor + '\'' +
                ", subject='" + subject + '\'' +
                ", group='" + group + '\'' +
                ", weeklyOcc=" + weeklyOcc +
                '}';
    }
}
