/*
  ContinentQuestionFrame.java
  The ClimateQuestionFrame class models a question, specifically, the type of continent.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: May 11, 2023
  Last Modified By: Krish Patel
  Date Modified: May 20, 2023
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ContinentQuestionFrame extends JFrame implements ActionListener{

  private String theQuestion = "Continent of Residence";
  private String option1 = "Asia";
  private String option2 = "Africa";
  private String option3 = "North America";
  private String option4 = "South America";
  private String option5 = "Antartica";
  private String option6 = "Europe";
  private String option7 = "Australia";
  private String response;
  private User theUser;
  private String cityString;
  private String countryString;
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
  String choiceA, choiceB, choiceC, choiceD, choiceE, choiceF, choiceG;
  private JRadioButton optionA, optionB, optionC, optionD, optionE, optionF, optionG;
  private JPanel box;

  // ⭐Constructor method
  /**
  * Constructor that sets the fields. BY: Krish
  * @param user the User object
  * @param city the city of the user
  * @param country the country of the user
  */
  ContinentQuestionFrame(int a, User user, String city, String country){

    theUser = new User(user);
    cityString = city;
    countryString = country;
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
  }//end ContinentQuestionFrame

  // ⭐Public instance methods
  /**
  * Method that checks for user action. BY: Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){

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
      this.dispose();
      User userCopy = new User(theUser);
      LanguageQuestionFrame question4 = new LanguageQuestionFrame(adminTest, userCopy, cityString, countryString, response);
    }
  }//end actionPerformed
  
}//end ContinentQuestionFrame class