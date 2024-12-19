package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class ProjectModule {
    public static void showMenu() {
        while (true) {
            System.out.println("\nProject Manager Module");
            System.out.println("1. Check Performance of Developers and Testers");
            System.out.println("2. Monitor Bugs");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> checkPerformance();
                case 2 -> monitorBugs();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void checkPerformance() {
    try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
        Map<String, Integer> developerPerformance = new HashMap<>();
        Map<String, Integer> testerPerformance = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            Bug bug = Bug.fromString(line);

            // تحقق من أن الكائن bug ليس null
            if (bug != null) {
                // حساب أداء المطورين بناءً على حالة الأخطاء
                if (bug.getDeveloperAssigned() != null) {
                    String developer = bug.getDeveloperAssigned();
                    developerPerformance.put(developer, developerPerformance.getOrDefault(developer, 0) + 1);
                }

                // حساب أداء المختبرين بناءً على جميع الأخطاء المضافة
                String tester = "Tester"; // لا يوجد حقل مخصص للمختبر في الكود، لذا سنفترض أنهم جميعًا "Testers"
                testerPerformance.put(tester, testerPerformance.getOrDefault(tester, 0) + 1);
            } else {
                System.out.println("Warning: Skipping invalid bug entry -> " + line);
            }
        }

        // عرض أداء المطورين
        System.out.println("\n--- Developer Performance ---");
        developerPerformance.forEach((developer, count) -> 
            System.out.println("Developer: " + developer + ", Bugs Fixed: " + count));

        // عرض أداء المختبرين
        System.out.println("\n--- Tester Performance ---");
        testerPerformance.forEach((tester, count) -> 
            System.out.println("Tester: " + tester + ", Bugs Reported: " + count));

    } catch (IOException e) {
        System.out.println("Error analyzing performance: " + e.getMessage());
    }
}

    private static void monitorBugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            System.out.println("\nOpen and Closed Bugs:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading bugs.");
        }
    }
}