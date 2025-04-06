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

        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(BorderFactory.createEmptyBorder(150, 250, 250, 250));

        // Logo

        panel.add(Box.createVerticalGlue());
        

        ImageIcon icon = new ImageIcon("assets/LOGO.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imgLabel = new JLabel(scaledIcon);
        panel.add(imgLabel);

        panel.add(Box.createVerticalStrut(35));

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField userTextField = new JTextField();
        userTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        userTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(userLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(userTextField);

        panel.add(Box.createVerticalStrut(25));

        // Username
        JLabel passLabel = new JLabel("Password:");
        passLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField passTextField = new JPasswordField();
        passTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        passTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(passLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(passTextField);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(100, 30));

        panel.add(Box.createVerticalStrut(15));
        panel.add(loginButton);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED); // make it red
        errorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(errorLabel);

        panel.add(Box.createVerticalGlue());

        // Action
    loginButton.addActionListener(e -> {
        String user = userTextField.getText();
        String pass = new String(passTextField.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            cardLayout.show(cardPanel, "main");
        } else {
            errorLabel.setText("Invalid credentials");
        }
    });
    
        return panel;
    }
}
