package bug_tracking;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.util.Scanner;
class TesterModule extends User {
    public TesterModule(String username, String password) {
        super(username, password, "Tester");
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome, Tester!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Report a Bug\n2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Bug Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Bug Description: ");
                String description = scanner.nextLine();
                System.out.print("Enter Priority (High/Medium/Low): ");
                String priority = scanner.nextLine();
                System.out.print("Enter Assigned Developer: ");
                String developer = scanner.nextLine();

                Bug newBug = new Bug(title, description, priority, developer, username);
                newBug.saveBugToFile("bugs.txt");
                System.out.println("Bug reported successfully!");
            } else {
                break;
            }
        }
    }
}
