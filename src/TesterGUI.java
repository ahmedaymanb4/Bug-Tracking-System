package bugtrackingsystem;

import javax.swing.*;
import java.awt.*;
/**
 * 
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
public class TesterGUI {
    public TesterGUI() {
        JFrame frame = new JFrame("Tester Module");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(4, 1));

        JButton addBugButton = new JButton("Add a Bug");
        addBugButton.addActionListener(e -> TesterModule.showMenu()); // استدعاء الوظيفة الحالية
        frame.add(addBugButton);

        JButton viewBugsButton = new JButton("View Bugs");
        viewBugsButton.addActionListener(e -> TesterModule.showMenu()); // تعديل لاحق لعرض الواجهة
        frame.add(viewBugsButton);

        JButton changeStatusButton = new JButton("Change Bug Status");
        changeStatusButton.addActionListener(e -> TesterModule.showMenu());
        frame.add(changeStatusButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);

        frame.setVisible(true);
    }
}