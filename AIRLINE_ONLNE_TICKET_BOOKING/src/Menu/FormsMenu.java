package Menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Forms.FlightForm;
import Forms.airportform;
import Forms.paymentform;
import Forms.reservationform;
import Forms.userForm;

public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu aiptmenu;
    private JMenu flghtmenu;
    private JMenu pymntmenu;
    private JMenu resrvtnmenu;
    private JMenu usermenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem aiptItem;
    private JMenuItem flghtItem;
    private JMenuItem pymntItem;
    private JMenuItem resrvtnItem;
    private JMenuItem userItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        aiptmenu = new JMenu("AIRPORT");
        flghtmenu = new JMenu("FLIGHT");
        pymntmenu= new JMenu("PAYMENT");
        resrvtnmenu = new JMenu("RESERVATION");
        usermenu = new JMenu("USER");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(aiptmenu);
        aiptItem = new JMenuItem("airportform");
        aiptItem.addActionListener(this);
        
        menuBar.add(flghtmenu);
        flghtItem = new JMenuItem("FlightForm");
        flghtItem.addActionListener(this);
        
        menuBar.add(pymntmenu);
        pymntItem = new JMenuItem("paymentform");
        pymntItem.addActionListener(this);
        
        menuBar.add(resrvtnmenu);
        resrvtnItem = new JMenuItem("reservationform");
        resrvtnItem.addActionListener(this);
        
        menuBar.add(usermenu);
        userItem = new JMenuItem("userForm");
        userItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        aiptmenu.add(aiptItem);
        flghtmenu.add(flghtItem);
        pymntmenu.add(pymntItem);
        resrvtnmenu.add(resrvtnItem);
        usermenu.add(userItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aiptItem) {
            new airportform();
        
        } else if (e.getSource() == flghtItem) {
            new FlightForm();
        
        } else if (e.getSource() == pymntItem) {
            new paymentform();
       
        } else if (e.getSource() == resrvtnItem) {
           new reservationform();
        
        } else if (e.getSource() == userItem) {
           new userForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO AIRLINE ONLINE TICKET BOOKING"));
    }
}




