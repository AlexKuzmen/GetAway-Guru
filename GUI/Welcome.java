/*
  SignUp.java
  The SignUp class models the signup of a user.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 20, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 30, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class Welcome implements ActionListener{
  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Font title = new Font("Arial", Font.PLAIN, 48);
  private Font defaultF = new Font("Arial", Font.PLAIN, 16);
  private Font subTitle = new Font("Arial", Font.PLAIN, 24);

  //Welcome Screen variables
  private JFrame welcomeF;
  private JButton welcomeS, welcomeL;
  private JLabel nameW, phrase, logoW;

// ⭐Contrustor methods

  /**
  * Default constructor method By: Oskar
  */
  public Welcome(){

    /*================ Welcome Screen ================*/

    welcomeF = new JFrame();
    welcomeF.setSize(800, 500);
    welcomeF.getContentPane().setBackground(blue);

    welcomeS = new JButton("Sign Up");
    welcomeS.setBounds(500,125,200,100);
    welcomeS.setBackground(green);
    welcomeS.addActionListener(this);
    
    welcomeL = new JButton("Login");
    welcomeL.setBounds(500,275,200,100);
    welcomeL.setBackground(green);
    welcomeL.addActionListener(this);

    nameW = new JLabel("Getaway Guru");
    nameW.setFont(title);
    nameW.setBounds(50,50,400,100);

    phrase = new JLabel("Real People, Real Reviews");
    phrase.setFont(defaultF);
    phrase.setBounds(125,125,200,50);

    logoW = new JLabel(new ImageIcon("Images/logo.png"));
    logoW.setBounds(100, 200, 250, 250);

    welcomeF.add(welcomeS);welcomeF.add(welcomeL);welcomeF.add(nameW);welcomeF.add(phrase);welcomeF.add(logoW);
    welcomeF.setLayout(null);
    welcomeF.setVisible(true);

    
  }

// ⭐Public instance methods
  /**
  * Method that performs after user action By: Oskar
  * @param e the ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == welcomeS){
      welcomeF.setVisible(false);
      welcomeF.dispose();
      new SignUp(false);
    
    }//end actionPerformed

    else if(e.getSource() == welcomeL){
      welcomeF.setVisible(false);
      welcomeF.dispose();
      new Login();
      
    }

  }//end actionPerformed
  
}//end Welcome.java