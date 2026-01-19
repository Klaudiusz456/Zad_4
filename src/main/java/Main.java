import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Dodaj studenta");
            System.out.println("2 - Pokaż studentów");
            System.out.println("3 - Znajdź studenta po imieniu");
            System.out.println("0 - Wyjście");

            int option;
            try {
                option = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Błąd: Proszę podać liczbę.");
                sc.nextLine(); // czyszczenie bufora po błędnym wpisie
                continue;
            }
            sc.nextLine(); // czyszczenie bufora po poprawnym wpisie

            if (option == 1) {
                System.out.print("Imię: ");
                String name = sc.nextLine();

                System.out.print("Wiek: ");
                int age = sc.nextInt();
                sc.nextLine(); // czyszczenie

                System.out.print("Data urodzenia (np. 2000-05-12): ");
                String birthDate = sc.nextLine();

                Service.save(new Student(name, age, birthDate));
                System.out.println("Student zapisany.");
            }
            else if (option == 2) {
                List<Student> students = Service.load();
                if (students.isEmpty()) {
                    System.out.println("Brak studentów.");
                } else {
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
            }
            else if (option == 3) {
                System.out.print("Podaj imię do wyszukania: ");
                String name = sc.nextLine();

                Student found = Service.findStudentByName(name);
                if (found != null) {
                    System.out.println("Znaleziono: " + found);
                } else {
                    System.out.println("Nie znaleziono studenta");
                }
            }
            else if (option == 0) {
                System.out.println("Koniec programu.");
                break;
            }
            else {
                System.out.println("Nieprawidłowa opcja.");
            }
        }
        sc.close();
    }
}
