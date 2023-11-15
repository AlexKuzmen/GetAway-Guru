/*
  PriceQuestionFrame.java
  The PriceQuestionFrame class models a question, specifficaly, the type of price.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: March 14, 2023
  Last Modified By: Krish Patel
  Date Modified: April 1, 2023
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PriceQuestionFrame extends JFrame implements ActionListener{

  private String theQuestion = "Price Range (CAD)";
  private String option1 = "50 - 100";
  private String option2 = "101 - 150";
  private String option3 = "151 - 650";
  private String option4 = "651 - 1200";
  private String option5 = "1201 - 2000";
  private String option6 = "2001 - 5000";
  private String option7 = "5001+";
  private String response;
  private User theUser;
  private String cityString;
  private String countryString;
  private String continentString;
  private String languageString;
  private String climateString;
  private int adminTest;

  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);

  private JButton submit;
  private JLabel question;
  private String choiceA, choiceB, choiceC, choiceD, choiceE, choiceF, choiceG;
  private JRadioButton optionA, optionB, optionC, optionD, optionE, optionF, optionG;
  private JPanel box;

// ⭐Contrustor methods

  /**
  * Constructor that sets the fields. BY: Krish
  * @param user      The user object
  * @param city      The user's city
  * @param country   The user's country
  * @param continent The user's continent
  * @param language  The user's language
  * @param climate   The user's climate
  */
  PriceQuestionFrame(int a, User user, String city, String country, String continent, String language, String climate){

    theUser = new User(user);
    cityString = city;
    countryString = country;
    continentString = continent;
    languageString = language;
    climateString = climate;
    adminTest = a;

    choiceA = option1;
    choiceB = option2;
    choiceC = option3;
    choiceD = option4;
    choiceE = option5;
    choiceF = option6;
    choiceG = option7;

    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setSize(800,730);
    this.getContentPane().setBackground(blue);
    this.setTitle("Preferences Questionnaire");
    this.setLocationRelativeTo(null);
    this.setLayout(null);

    box = new JPanel();
    box.setBackground(green);
    box.setBounds(100,80,600,600);

    question = new JLabel(theQuestion);
    question.setBounds(250,100,500,50);
    question.setFont(subTitle);
    question.setVerticalAlignment(JLabel.TOP);
    question.setHorizontalAlignment(JLabel.LEFT);

    submit = new JButton("Submit");
    submit.setBounds(250,530,300,50);
    submit.setFocusable(false);
    submit.setFont(defaultF);
    submit.setBackground(darkBlue);
    submit.setForeground(Color.white);
    submit.addActionListener(this);

    optionA = new JRadioButton(option1);
    optionA.setFont(defaultF);
    optionA.setFocusable(false);
    optionA.setBounds(250,150,300,50);
    
    optionB = new JRadioButton(option2);
    optionB.setFont(defaultF);
    optionB.setFocusable(false);
    optionB.setBounds(250,200,300,50);

    optionC = new JRadioButton(option3);
    optionC.setFont(defaultF);
    optionC.setFocusable(false);
    optionC.setBounds(250,250,300,50);

    optionD = new JRadioButton(option4);
    optionD.setFont(defaultF);
    optionD.setFocusable(false);
    optionD.setBounds(250,300,300,50);

    optionE = new JRadioButton(option5);
    optionE.setFont(defaultF);
    optionE.setFocusable(false);
    optionE.setBounds(250,350,300,50);

    optionF = new JRadioButton(option6);
    optionF.setFont(defaultF);
    optionF.setFocusable(false);
    optionF.setBounds(250,400,300,50);

    optionG = new JRadioButton(option7);
    optionG.setFont(defaultF);
    optionG.setFocusable(false);
    optionG.setBounds(250,450,300,50);

    ButtonGroup bg = new ButtonGroup();
    bg.add(optionA);
    bg.add(optionB);
    bg.add(optionC);
    bg.add(optionD);
    bg.add(optionE);
    bg.add(optionF);
    bg.add(optionG);
    
    this.add(question);
    this.add(optionA);
    this.add(optionB);
    this.add(optionC);
    this.add(optionD);
    this.add(optionE);
    this.add(optionF);
    this.add(optionG);
    this.add(submit);
    this.add(box);
    
    this.setVisible(true);
  }

// ⭐Public instance methods
  
  /**
  * Method that performs after user action By: Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e) {

    String selection = "ERROR";
    
    if(optionA.isSelected()){
      selection = choiceA;
    }
    if(optionB.isSelected()){
      selection = choiceB;
    }
    if(optionC.isSelected()){
      selection = choiceC;
    }
    if(optionD.isSelected()){
      selection = choiceD;
    }
    if(optionE.isSelected()){
      selection = choiceE;
    }
    if(optionF.isSelected()){
      selection = choiceF;
    }
    if(optionG.isSelected()){
      selection = choiceG;
    }

    response = selection;
    
    if(e.getSource()==submit){
      submit.setEnabled(false);
      this.setVisible(false);
      //System.out.println(response);
      signUp();
      this.dispose();
    }
  }//end actionPerformed

  /**
    This method signs a user up. By: Krish
  */
  public void signUp(){
    
    try{  
      //Make their csv file
      String username = theUser.getUsername();
      String password = theUser.getPassword();
      FileWriter fileWriter = new FileWriter("users file/"+username+".csv");
      BufferedWriter outputFile = new BufferedWriter(fileWriter);
  
      //Add their preferences as the first line seperated by commas
      String city = cityString;
  
      String country = countryString;
  
      String continent = continentString;
  
      String language = languageString;
  
      String climate = climateString;
  
      String price = response;
      
      outputFile.write(city+","+country+","+continent+","+language+","+climate+","+price); // Add their preferences to their file
      
      //Close the file
      outputFile.close();
  
      //Add their names to the username textfile
      FileWriter fw2 = new FileWriter("Usernames.txt", true);
      PrintWriter outputFile2 = new PrintWriter(fw2);
  
      outputFile2.println(username);
  
      //Close the file
      outputFile2.close();
  
      //Add their names to the password textfile
      FileWriter fw3 = new FileWriter("Passwords.txt", true);
      PrintWriter outputFile3 = new PrintWriter(fw3);
  
      outputFile3.println(password);
  
      //Close the file
      outputFile3.close();

      User userCopy = new User(theUser);
      if(adminTest == 0){
        new Home(userCopy);
      }
      else if(adminTest == 1){
        Admin theAdmin = new Admin();
        new Home(theAdmin);
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    
  }//end signUp
  
}//end PriceQuestionFrame.java