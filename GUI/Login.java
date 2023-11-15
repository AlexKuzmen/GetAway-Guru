/*
  Login.java
  The Login class models the login of the user.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 3, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 27, 2023
*/

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login implements ActionListener{
   //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Font title = new Font("Arial", Font.PLAIN, 48);
  private Font defaultF = new Font("Arial", Font.PLAIN, 16);
  private Font subTitle = new Font("Arial", Font.PLAIN, 24);

  private JFrame logInF;
  private JButton logIn, backL;
  private JTextField usernameL;
  private JPasswordField passwordL;
  private JLabel promoL, welcomeBackL, imageL, dividerL, userL, passL, invalidUser, invalidPass, djKhaled;
  private JLayeredPane layerLL;

// ⭐Contrustor methods

  /**
  * Constructor that sets the fields By: Oskar
  */
  public Login(){
    logInF = new JFrame();
    logInF.setSize(800,500);
    logInF.getContentPane().setBackground(green);

    dividerL = new JLabel();
    welcomeBackL = new JLabel();
    promoL = new JLabel();
    userL = new JLabel();
    passL = new JLabel();
    imageL = new JLabel();
    usernameL = new JTextField();
    passwordL = new JPasswordField();
    backL = new JButton();
    logIn = new JButton();
    layerLL = new JLayeredPane();
    invalidUser = new JLabel();
    invalidPass = new JLabel();
    

    djKhaled = new JLabel(new ImageIcon("Images/djKhaled2.jpg"));
    djKhaled.setBounds(50, 125, 300, 338);

    invalidUser.setText("Username or Password invalid");
    invalidUser.setFont(defaultF);
    invalidUser.setForeground(Color.red);
    invalidUser.setBounds(525,190,250,25);
    invalidUser.setVisible(false);
    
    logIn.addActionListener(this);
    backL.addActionListener(this);

    dividerL.setBackground(blue);
    dividerL.setOpaque(true);
    dividerL.setBounds(0,0,400,500);
    
    welcomeBackL.setText("Login");
    welcomeBackL.setBackground(green);
    welcomeBackL.setOpaque(true);
    welcomeBackL.setFont(subTitle);
    welcomeBackL.setBounds(605,50,300,100);

    promoL.setText("Let Us Help Plan Your Next Trip!");
    promoL.setFont(defaultF);
    promoL.setBounds(75,50,300,100);

    layerLL.setBounds(0,0,400,500);
    layerLL.add(dividerL, new Integer(1));
    layerLL.add(promoL, new Integer(2));
    layerLL.add(djKhaled, new Integer(3));
      
    userL.setText("Username:");
    userL.setBounds(425,200,100,50);

    usernameL.setBounds(525,210,250,25);

    passL.setText("Password:");
    passL.setBounds(425,250,100,50);

    passwordL.setBounds(525,260,250,25);

    logIn.setText("Log In");
    logIn.setBackground(darkBlue);
    logIn.setForeground(Color.WHITE);
    logIn.setBounds(575,325,100,50);

    backL.setText("Back");
    backL.setBackground(darkBlue);
    backL.setForeground(Color.WHITE);
    backL.setBounds(575,400,100,50);     

    layerLL.setVisible(true);
      
logInF.add(welcomeBackL);logInF.add(layerLL);logInF.add(userL);logInF.add(passL);logInF.add(usernameL);logInF.add(passwordL);logInF.add(logIn);logInF.add(backL);logInF.add(invalidUser);logInF.add(invalidPass);

    logInF.setLayout(null);
    logInF.setVisible(true);
  }

// ⭐Public instance methods
  /**
  * Method that performs after user action By: Oskar
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == backL){
      logInF.setVisible(false);
      logInF.dispose();
      new Welcome();
    }

    else if(e.getSource() == logIn){

      String user = usernameL.getText();
      String pass = passwordL.getText();

      User theUser = new User(user, pass);

      boolean valid = fileException(theUser);
      
      if(!valid){
        invalidUser.setVisible(true);
      }

      
      else if(valid){
        logInF.setVisible(false);
        logInF.dispose();
        new Home(new User(theUser));
      }
    }
  }//end actionPerformed
  
// ⭐Public static methods

  /**
  * Method that checks for valid login By: Oskar
  * @param u The user object
  * @return tf The boolean result
  */
   public static boolean fileException(User u){

    boolean tf;
    
    try{
      tf = u.validLogin();
      return tf;
    }

    catch(IOException e){
      throw new RuntimeException(e);
    }
     
  }//end fileException
  
}//end Login.java