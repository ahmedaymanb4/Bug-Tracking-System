package bug_tracking;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Login {
    private Map<String, User> users;

    public Login() {
        users = loadUsersFromFile("users.txt");
    }

    public void displayLogin() {
        JFrame frame = new JFrame("Bug Tracking System - Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            User user = authenticate(username, password);

            if (user != null) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                user.displayDashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
            }
        });
    }

    private User authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).password.equals(password)) {
            return users.get(username);
        }
        return null;
    }

    private Map<String, User> loadUsersFromFile(String fileName) {
        Map<String, User> userMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];

                User user = createUserByRole(username, password, role);
                userMap.put(username, user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return userMap;
    }

    private User createUserByRole(String username, String password, String role) {
        switch (role) {
            case "Tester":
                return new TesterModule(username, password);
            case "Developer":
                return new DeveloperModule(username, password);
            case "ProjectManager":
                return new ProjectManager(username, password);
            case "Admin":
                return new AdminModule(username, password);
            default:
                return null;
        }
    }
}
