package bugtrackingsystem;

import javax.swing.*;
import java.awt.*;
/**
 * 
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
public class ProjectManagerGUI {
    public ProjectManagerGUI() {
        JFrame frame = new JFrame("Project Manager Module");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JButton checkPerformanceButton = new JButton("Check Performance");
        checkPerformanceButton.addActionListener(e -> ProjectModule.showMenu());
        frame.add(checkPerformanceButton);

        JButton monitorBugsButton = new JButton("Monitor Bugs");
        monitorBugsButton.addActionListener(e -> ProjectModule.showMenu());
        frame.add(monitorBugsButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);

        frame.setVisible(true);
    }
}