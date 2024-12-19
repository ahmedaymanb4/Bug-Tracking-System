package bugtrackingsystem;

import javax.swing.*;
import java.awt.*;

public class AdminGUI {
    public AdminGUI() {
        JFrame frame = new JFrame("Admin Module");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JButton viewBugsButton = new JButton("View All Bugs");
        viewBugsButton.addActionListener(e -> AdminModule.showMenu());
        frame.add(viewBugsButton);

        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.addActionListener(e -> AdminModule.showMenu());
        frame.add(manageUsersButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);

        frame.setVisible(true);
    }
}