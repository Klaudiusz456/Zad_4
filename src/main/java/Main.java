import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Wyświetl studentów");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.print("Imię: ");
            String name = sc.nextLine();

            System.out.print("Wiek: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Data urodzenia: ");
            String birthDate = sc.nextLine();

            Student s = new Student(name, age, birthDate);
            Service.save(s);
        } 
        else if (option == 2) {
            List<Student> students = Service.load();
            students.forEach(System.out::println);
        }
    }
}
