package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.Scanner;

public class AdminModule {
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
            System.out.print("Enter Role (Tester/Developer/PM/Admin): ");
            String role = scanner.nextLine();

            User newUser = new User(username, role); // Using the User class
            writer.write(newUser.getUsername() + "," + newUser.getRole() + "\n");
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
}