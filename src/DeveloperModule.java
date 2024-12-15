package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.*;

public class DeveloperModule {

    // عرض قائمة خيارات المطور
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDeveloper Module");
            System.out.println("1. View Assigned Bugs");
            System.out.println("2. Change Bug Status");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAssignedBugs(scanner);  // عرض الأخطاء المعينة للمطور
                    break;
                case 2:
                    changeBugStatus(scanner);  // تغيير حالة الخطأ
                    break;
                case 3:
                    return; // العودة للقائمة الرئيسية
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // عرض الأخطاء المعينة للمطور
    private static void viewAssignedBugs(Scanner scanner) {
        System.out.print("Enter your name to view your assigned bugs: ");
        String developerName = scanner.nextLine();

        List<Bug> bugs = loadBugsFromFile(); // تحميل الأخطاء من الملف
        boolean bugFound = false;  // متغير للتحقق إذا تم العثور على أخطاء

        System.out.println("\n--- Assigned Bugs ---");
        for (Bug bug : bugs) {
            // التحقق من أن الخطأ مخصص لهذا المطور
            if (bug.getDeveloperAssigned() != null && bug.getDeveloperAssigned().equalsIgnoreCase(developerName)) {
                System.out.println(bug);  // عرض تفاصيل الخطأ
                bugFound = true;
            }
        }

        if (!bugFound) {
            System.out.println("No assigned bugs found.");
        }
    }

    // تغيير حالة الخطأ
    private static void changeBugStatus(Scanner scanner) {
        System.out.print("Enter Bug Name to Change Status: ");
        String bugName = scanner.nextLine();
        System.out.print("Enter New Status (Open/Closed): ");
        String newStatus = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Name='" + bugName + "'")) {
                    // تحديث حالة الخطأ
                    line = line.replaceFirst("Status='.*?'", "Status='" + newStatus + "'");
                    found = true;
                }
                writer.write(line + "\n");
            }

            if (found) {
                System.out.println("Bug status updated successfully.");
            } else {
                System.out.println("Bug not found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating bug status.");
        }

        // إعادة تسمية الملف بعد التحديث
        new File("temp.txt").renameTo(new File("bugs.txt"));
    }

    // تحميل الأخطاء من الملف
    private static List<Bug> loadBugsFromFile() {
        List<Bug> bugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // تحويل السطر إلى كائن Bug باستخدام دالة fromString
                bugs.add(Bug.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading bugs.");
        }
        return bugs;
    }
}