/*
  SignUp.java
  The SignUp class models the signup of a user.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 3, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 19, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.io.*;
public class SignUp implements ActionListener{
  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Font title = new Font("Arial", Font.PLAIN, 48);
  private Font defaultF = new Font("Arial", Font.PLAIN, 16);
  private Font subTitle = new Font("Arial", Font.PLAIN, 24);

  //Sign up variables
  private JFrame signUpF;
  private JButton signUp, backS, backA;
  private JTextField usernameS, cityTF, countryTF;
  private JPasswordField passwordS; 
  private JLabel promoS, signUpL, imageS, dividerS, userS, passS, invalidUser, invalidPass, djKhaled;
  private JLayeredPane layerLS;
  private int adminTest;
// ⭐Contrustor methods

  /**
  * Constructor that sets the fields. BY: Oskar, Krish
  */
  public SignUp(boolean adminMakingAccount){
    signUpF = new JFrame();
    signUpF.setSize(800,500);
    signUpF.getContentPane().setBackground(green);

    dividerS = new JLabel();
    signUpL = new JLabel();
    promoS = new JLabel();
    userS = new JLabel();
    passS = new JLabel();
    imageS = new JLabel();
    usernameS = new JTextField();
    passwordS = new JPasswordField();
    backS = new JButton();
    backA = new JButton();
    signUp = new JButton();
    layerLS = new JLayeredPane();
    invalidUser = new JLabel();
    invalidPass = new JLabel();
    
    djKhaled = new JLabel();
    djKhaled = new JLabel(new ImageIcon("Images/djKhaled.jpg"));
    djKhaled.setOpaque(true);
    djKhaled.setVisible(true);
    djKhaled.setBounds(50, 125, 300, 350);

 

    invalidUser.setText("Username is already taken");
    invalidUser.setFont(defaultF);
    invalidUser.setForeground(Color.red);
    invalidUser.setBounds(525,190,250,25);
    invalidUser.setVisible(false);
    
    invalidPass.setText("Password is too weak");
    invalidPass.setFont(defaultF);
    invalidPass.setForeground(Color.red);
    invalidPass.setBounds(525,240,250,25);
    invalidPass.setVisible(false);
    
    signUp.addActionListener(this);
    backS.addActionListener(this);
    backA.addActionListener(this);

    dividerS.setBackground(blue);
    dividerS.setOpaque(true);
    dividerS.setBounds(0,0,400,500);
    
    signUpL.setText("Sign Up Today!");
    signUpL.setBackground(green);
    signUpL.setOpaque(true);
    signUpL.setFont(subTitle);
    signUpL.setBounds(515,50,300,100);

    promoS.setText("Let Us Help Plan Your Next Trip!");
    promoS.setFont(defaultF);
    promoS.setBounds(75,50,300,100);

    layerLS.setBounds(0,0,400,500);
    layerLS.add(dividerS, new Integer(1));
    layerLS.add(promoS, new Integer(2));
    layerLS.add(djKhaled, new Integer(3));
      

    userS.setText("Username:");
    userS.setBounds(425,200,100,50);

    usernameS.setBounds(525,210,250,25);

    passS.setText("Password:");
    passS.setBounds(425,250,100,50);

    passwordS.setBounds(525,260,250,25);

    signUp.setText("Sign Up");
    signUp.setBackground(darkBlue);
    signUp.setForeground(Color.WHITE);
    signUp.setBounds(575,325,100,50);

    backS.setText("Back");
    backS.setBackground(darkBlue);
    backS.setForeground(Color.WHITE);
    backS.setBounds(575,400,100,50);

    backA.setText("Back"); //Krish
    backA.setBackground(darkBlue);
    backA.setForeground(Color.WHITE);
    backA.setBounds(575,400,100,50);

    if(adminMakingAccount == false){ //Krish
      backS.setVisible(true);
      backA.setVisible(false);
      adminTest = 0;
    }
    else{ //Krish
      backS.setVisible(false);
      backA.setVisible(true);
      adminTest = 1;
    }
   
    

    layerLS.setVisible(true);
      
    signUpF.add(signUpL);signUpF.add(layerLS);signUpF.add(userS);signUpF.add(passS);signUpF.add(usernameS);signUpF.add(signUp);signUpF.add(passwordS);signUpF.add(backS);signUpF.add(invalidUser);signUpF.add(invalidPass);signUpF.add(backA);

      signUpF.setLayout(null);
      signUpF.setVisible(true);

  }

// ⭐Public instance methods
  
  /**
  * Method that performs after user action. BY: Oskar, Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == backS){
      signUpF.dispose();
      new Welcome();
    }

    if(e.getSource() == backA){ //Krish
      signUpF.dispose();
      Admin theAdmin = new Admin();
      new AdminStats(theAdmin);
    }

    else if(e.getSource() == signUp){
            
      String user = usernameS.getText();
      String pass = passwordS.getText();

      User theUser = new User(user, pass);

      boolean validUser = fileExceptionU(user, theUser);
      System.out.println(validUser);
      boolean validPass = theUser.isValidPassword(pass);
      
      if(!validUser&&validPass){
        invalidUser.setVisible(true);
        invalidPass.setVisible(false);
      }

      else if(validUser&&!validPass){
        invalidUser.setVisible(false);
        invalidPass.setVisible(true);
      }

      else if(!validUser&&!validPass){
        invalidUser.setVisible(true);
        invalidPass.setVisible(true);
      }

      
      else if(validUser&&validPass){
        //fileExceptionSignUp(theUser);
        
        signUpF.setVisible(false);
        signUpF.dispose();

        User userCopy = new User(theUser);
        new CityQuestionFrame(adminTest, userCopy);
        
      }
    }
  }//end actionPerformed

// ⭐Public static methods
  
  /**
  * Method that checks for valid input. BY: Oskar
  * @param s The string username of the user
  * @param u The user object
  */
  public static boolean fileExceptionU(String s, User u){

    boolean tf;
    
    try{
      tf = u.isValidUsername(s);
      return tf;
    }

    catch(IOException e){
      throw new RuntimeException(e);
    }
  }//end fileExceptionU


  /**
  * Method that sings the user up. BY: Oskar
  * @param u The user object
  */
  public static void fileExceptionSignUp(User u){

   
    
    try{
      u.signUp();
    }

    catch(IOException e){
      throw new RuntimeException(e);
    }
    
  }//end fileExceptionSignUp
  
}//end fileExceptionSignUp.java