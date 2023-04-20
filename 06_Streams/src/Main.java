import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    static final int GOOD_STUDENT_THRESHOLD = 50;
    static final String FILE_PATH = "text.txt";

    private static class Student {
        public String name;
        public String group;
        public int score;

        public Student(String name, String group, String score) {
            this.name = name;
            this.group = group;
            this.score = Integer.parseInt(score);
        }

        @Override
        public String toString() {
            return name + "(" + group + ")-" + score;
        }

        public String getName() {
            return name;
        }

        public String getGroup() {
            return group;
        }

        public int getScore() {
            return score;
        }

    }

    public static void main(String[] args) {
        try {
            long goodStudentCount = Files.lines(Paths.get(FILE_PATH))
                    .map(line -> line.split(" "))
                    .filter(student -> Integer.parseInt(student[2]) >= GOOD_STUDENT_THRESHOLD)
                    .count();

            System.out.println(goodStudentCount + "\n");

            System.out.println("Good Students:");
            Files.lines(Paths.get(FILE_PATH))
                    .map(line -> line.split(" "))
                    .map(student -> new Student(student[0], student[1], student[2]))
                    .filter(student -> student.score >= GOOD_STUDENT_THRESHOLD)
                    .sorted(Comparator.comparing(Student::getGroup).thenComparing(Student::getScore))
                    .forEach(student -> System.out.println(student.group + " " + student.name + " " + student.score));

            Map<String, List<Student>> studentGroups = Files.lines(Paths.get(FILE_PATH))
                    .map(line -> line.split(" "))
                    .map(student -> new Student(student[0], student[1], student[2]))
                    .collect(Collectors.groupingBy(Student::getGroup));

            System.out.println(studentGroups);
        } catch (Exception e) {
            System.out.println("File in path (" + FILE_PATH + ") doesn't exist.");
        }
    }
}
