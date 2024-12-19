package bugtrackingsystem;

import javax.swing.*;
import java.awt.*;
/**
 * 
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bug Tracking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new GridLayout(5, 1));

            JLabel titleLabel = new JLabel("Bug Tracking System", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            frame.add(titleLabel);

            JButton testerButton = new JButton("Tester Module");
            testerButton.addActionListener(e -> new TesterGUI());
            frame.add(testerButton);

            JButton developerButton = new JButton("Developer Module");
            developerButton.addActionListener(e -> new DeveloperGUI());
            frame.add(developerButton);

            JButton adminButton = new JButton("Admin Module");
            adminButton.addActionListener(e -> new AdminGUI());
            frame.add(adminButton);

            JButton projectManagerButton = new JButton("Project Manager Module");
            projectManagerButton.addActionListener(e -> new ProjectManagerGUI());
            frame.add(projectManagerButton);

            frame.setVisible(true);
        });
    }
}