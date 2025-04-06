import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow {
    
    private JFrame window;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainWindow() {
        window = new JFrame();
        window.setTitle("Pill Helper");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create both panels
        JPanel loginPanel = createLoginPanel();
        // JPanel mainPanel = createMainPanel();

        cardPanel.add(loginPanel, "login");
        window.add(cardPanel);
    }

    public void show() {
        window.setVisible(true);
        cardLayout.show(cardPanel, "login");
    }


    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(140, 30, 150, 25);
        panel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 80, 25);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(140, 70, 150, 25);
        panel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(140, 110, 100, 30);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                cardLayout.show(cardPanel, "main");
            } else {
                JOptionPane.showMessageDialog(window, "Invalid credentials.");
            }
        });

        return panel;
    }
}
