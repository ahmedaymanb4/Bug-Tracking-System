package bugtrackingsystem;
import java.util.Map;
import java.util.HashMap;
/**
 * 
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
public class Bug {
    private String name;
    private String type;
    private String priority;
    private String level;
    private String projectName;
    private String status;
    private String screenshotPath; // New field to store the screenshot path
    private String developerAssigned; // New field to store the developer's name

    // Constructor
    public Bug(String name, String type, String priority, String level, String projectName, String status, String screenshotPath, String developerAssigned) {
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.level = level;
        this.projectName = projectName;
        this.status = status;
        this.screenshotPath = screenshotPath;
        this.developerAssigned = developerAssigned;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getDeveloperAssigned() {
        return developerAssigned;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bug{Name='" + name + "', Type='" + type + "', Priority='" + priority + "', Level='" + level + "', ProjectName='" + projectName + "', Status='" + status + "', ScreenshotPath='" + screenshotPath + "', DeveloperAssigned='" + developerAssigned + "'}";
    }

    public static Bug fromString(String bugString) {
    try {
        String[] parts = bugString.split(", ");
        if (parts.length < 8) {
            throw new IllegalArgumentException("Invalid bug format: " + bugString);
        }

        String name = parts[0].split("=")[1].replace("'", "");
        String type = parts[1].split("=")[1].replace("'", "");
        String priority = parts[2].split("=")[1].replace("'", "");
        String level = parts[3].split("=")[1].replace("'", "");
        String projectName = parts[4].split("=")[1].replace("'", "");
        String status = parts[5].split("=")[1].replace("'", "");
        String screenshotPath = parts[6].split("=")[1].replace("'", "");
        String developerAssigned = parts[7].split("=")[1].replace("'", "").replace("}", "");

        return new Bug(name, type, priority, level, projectName, status, screenshotPath, developerAssigned);
    } catch (Exception e) {
        System.out.println("Error parsing bug: " + bugString + " -> " + e.getMessage());
        return null; // Return null if parsing fails
    }
}}