package App.view;

import org.json.simple.parser.ParseException;
import App.controller.AdminController;
import App.controller.LoginController;
import App.controller.LoginWindowController;
import App.controller.SellerController;
import App.model.Admin;
import App.model.MarketDB;
import App.model.Seller;
import App.model.User;
import App.utils.LanguageResourceBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bizianov on 01.11.2015.
 */
public class LoginPassFrame extends JFrame {

    private MarketDB marketDB;
    private User user;

    private LoginWindowController loginWindowController;

    private JTextField login;
    private JTextField password;

    private JLabel incorrectPass;

    public LoginPassFrame(LoginWindowController loginWindowController) throws HeadlessException{
        this.loginWindowController = loginWindowController;
        this.marketDB = loginWindowController.getMarketDB();

        try {
            loginWindowController.updateAdmins();
            loginWindowController.updateSellers();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        setTitle(LanguageResourceBundle.get("login.title"));
        setSize(350, 125);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    void init(){

        login = new JTextField("");
        password = new JPasswordField("");
        setLayout(new GridLayout(3, 2));

        getContentPane().add(new JLabel("login:"));
        getContentPane().add(login);
        getContentPane().add(new JLabel("password:"));
        getContentPane().add(password);

        JButton okButton = new JButton("OK");
        okButton.setMnemonic('O');
        okButton.setToolTipText("press after typing login and password");
        okButton.addActionListener(new MyActionListener());

        getContentPane().add(okButton);

        incorrectPass = new JLabel("",SwingConstants.CENTER);
        getContentPane().add(incorrectPass);
    }

    private class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginWindowController loginWindowController = new LoginWindowController(new LoginController(marketDB));
            User user = loginWindowController.loginFrame(login.getText(),password.getText());
            if (user instanceof Admin){
                AdminViewFrame adminFrame = new AdminViewFrame(new AdminController(marketDB));
                setVisible(false);
            } else if (user instanceof Seller){
                SellerViewFrame sellerFrame = new SellerViewFrame(new SellerController(marketDB),(Seller)user);
                setVisible(false);
            } else {
                login.setText("");
                password.setText("");
                incorrectPass.setText("invalid login or password");
                incorrectPass.setForeground(Color.red);
            }
        }
    }

}
