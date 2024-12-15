package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.util.Scanner;

public class BugTrackingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBug Tracking System");
            System.out.println("1. Tester Module");
            System.out.println("2. Developer Module");
            System.out.println("3. Admin Module");
            System.out.println("4. Project Manager Module");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
                    

            switch (choice) {
                case 1 -> TesterModule.showMenu();
                case 2 -> DeveloperModule.showMenu();
                case 3 -> AdminModule.showMenu();
                case 4 -> ProjectModule.showMenu();
                case 5 -> {
                    System.out.println("Exiting System.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}