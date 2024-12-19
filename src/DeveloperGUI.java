package bugtrackingsystem;

import javax.swing.*;
import java.awt.*;
/**
 * @author Ahmed Ayman
 */
public class DeveloperGUI {
    private String developerName;

    public DeveloperGUI(String developerName) {
        this.developerName = developerName;
        JFrame frame = new JFrame("Developer Module");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JButton viewAssignedBugsButton = new JButton("View Assigned Bugs");
        viewAssignedBugsButton.addActionListener(e -> DeveloperModule.showMenu(developerName)); 
        frame.add(viewAssignedBugsButton);

        JButton changeBugStatusButton = new JButton("Change Bug Status");
        changeBugStatusButton.addActionListener(e -> DeveloperModule.showMenu(developerName));
        frame.add(changeBugStatusButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);

        frame.setVisible(true);
    }
}