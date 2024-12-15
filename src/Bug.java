package bug_tracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bug {
    private static int nextId = 1; // Incremental Bug ID
    private int bugId;
    private String title;
    private String description;
    private String priority; // High, Medium, Low
    private String status;   // Open, Closed
    private String assignedTo; // Developer username
    private String reporter;   // Tester username

    public Bug(String title, String description, String priority, String assignedTo, String reporter) {
        this.bugId = nextId++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Open"; // Default status
        this.assignedTo = assignedTo;
        this.reporter = reporter;
    }

    // Constructor for reading bugs from file
    public Bug(int bugId, String title, String description, String priority, String status, String assignedTo, String reporter) {
        this.bugId = bugId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
        this.reporter = reporter;
    }

    // Method to save the bug to bugs.txt
    public void saveBugToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(bugId + "," + title + "," + description + "," + priority + "," + status + "," + assignedTo + "," + reporter);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving bug to file.");
        }
    }

    // Method to load bugs from file
    public static List<Bug> loadBugsFromFile(String filename) {
        List<Bug> bugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                bugs.add(new Bug(
                    Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],
                    parts[4], parts[5], parts[6]
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading bugs from file.");
        }
        return bugs;
    }

    // Getters and Setters
    public int getBugId() { return bugId; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDeveloperAssigned() {return assignedTo;}
    
    public static Bug fromString(String line) {
        // Split the line into parts using a comma
        String[] parts = line.split(",");

        // Directly assign all parts as Strings
        String id = parts[0].trim();
        String name = parts[1].trim();
        String type = parts[2].trim();
        String priority = parts[3].trim();
        String status = parts[4].trim();

        // Return a new Bug object
        return new Bug(id, name, type, priority, status);
    }

    
    @Override
    public String toString() {
        return "Bug ID: " + bugId + ", Title: " + title + ", Status: " + status +
               ", Assigned To: " + assignedTo + ", Reporter: " + reporter;
    }
}
