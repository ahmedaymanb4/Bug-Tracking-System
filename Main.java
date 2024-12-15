package bug_tracking;

// @author "Ahmed Ayman"

import javax.swing.*;
import java.io.*;
import java.util.*;

// Main class to start the Bug Tracking System
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().displayLogin());
    }
}
