import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    static String FILE = "db.txt";

    static void save(Student s) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(s.getName() + ";" + s.getAge() + ";" + s.getBirthDate() + "\n");
        } catch (IOException e) {
            System.out.println("Błąd zapisu");
        }
    }

    static List<Student> load() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 3) {
                    list.add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }
        return list;
    }

    static Student findStudentByName(String name) {
        List<Student> students = load();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
