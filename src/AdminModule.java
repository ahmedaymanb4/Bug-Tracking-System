package bug_tracking;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.Scanner;

class AdminModule extends User{
    public AdminModule(String username, String password) {
        super(username, password, "Admin");
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdmin Module");
            System.out.println("1. View All Bugs");
            System.out.println("2. Manage Users");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAllBugs();
                case 2 -> manageUsers(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewAllBugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            System.out.println("\nList of All Bugs:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading bugs.");
        }
    }

    private static void manageUsers(Scanner scanner) {
        while (true) {
            System.out.println("\nManage Users");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addUser(scanner);
                case 2 -> viewUsers();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addUser(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Role (Tester/Developer/ProjectManager/Admin): ");
            String role = scanner.nextLine();

            User newUser;

            // Instantiate the appropriate subclass based on role
            switch (role) {
                case "Tester":
                    newUser = new TesterModule(username, password);
                    break;
                case "Developer":
                    newUser = new DeveloperModule(username, password);
                    break;
                case "ProjectManager":
                    newUser = new ProjectManager(username, password);
                    break;
                case "Admin":
                    newUser = new AdminModule(username, password);
                    break;
                default:
                    System.out.println("Invalid role. User not added.");
                    return;
            }

            // Write the user details to file
            writer.write(newUser.username + "," + newUser.password + "," + newUser.role + "\n");
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding user.");
        }
    }

    private static void viewUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            System.out.println("\nList of Users:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading users.");
        }
    }

    /**
     * <p>
     * @Override public void displayDashboard() is important, 
     * as this Class is inherited from (extends) User Abstract Class. 
     * </p>
     */
    @Override
    public void displayDashboard() {
        System.out.println("Welcome, Admin! Here you can report and monitor bugs.");
        // You can expand this with GUI or options.
    }
}