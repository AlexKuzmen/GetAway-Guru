/*
  Info.java
  The Info class models a page with the programmers' information.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 3, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 27, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
public class Info implements ActionListener{
  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.PLAIN, 48);
  private Font defaultF = new Font("Arial", Font.PLAIN, 16);
  private Font subTitle = new Font("Arial", Font.PLAIN, 24);

  private JFrame infoF;
  private JButton back, profile;
  private JLabel nameBack, name, description, descriptionBack, picture;
  private JLayeredPane layer;
  private User user;
  private int direction;
  
// ⭐Contrustor methods
  /**
  * Constructor method that sets the fields. BY: Oskar
  * @param d The destination object
  */
  public Info(Destination d, User u, int i){

    direction = i;

    picture = new JLabel();

    if(d.getContinent().equalsIgnoreCase("Asia")){
      picture = new JLabel(new ImageIcon("Images/asia.jpg"));
      picture.setBounds(425, 175, 302, 250);
    }

    else if(d.getContinent().equalsIgnoreCase("Europe")){
      picture = new JLabel(new ImageIcon("Images/europe.jpg"));
      picture.setBounds(425, 175, 246, 250);
    } 

    else if(d.getContinent().equalsIgnoreCase("Africa")){
      picture = new JLabel(new ImageIcon("Images/africa.jpg"));
      picture.setBounds(425, 175, 264, 250);
    } 

    else if(d.getContinent().equalsIgnoreCase("North America")){
      picture = new JLabel(new ImageIcon("Images/na.jpg"));
      picture.setBounds(425, 175, 263, 250);
    } 

    else if(d.getContinent().equalsIgnoreCase("South America")){
      picture = new JLabel(new ImageIcon("Images/sa.jpg"));
      picture.setBounds(425, 175, 210, 250);
    } 

    else if(d.getContinent().equalsIgnoreCase("Europe")){
      picture = new JLabel(new ImageIcon("Images/europe.jpg"));
      picture.setBounds(425, 175, 256, 250);
    } 

    else if(d.getContinent().equalsIgnoreCase("Antarctica")){
      picture = new JLabel(new ImageIcon("Images/antarctica.jpg"));
      picture.setBounds(425, 175, 250, 250);
    } 

    

    
    user = new User(u);
    infoF = new JFrame();
    infoF.setSize(800, 500);
    infoF.getContentPane().setBackground(blue);
    
    back = new JButton();
    profile = new JButton(new ImageIcon("Images/profile.png"));
    nameBack = new JLabel();
    name = new JLabel(d.getCity(), SwingConstants.CENTER);
    description = new JLabel();
    descriptionBack = new JLabel();
    layer = new JLayeredPane();

    nameBack.setBounds(100, 50, 600, 75);
    nameBack.setOpaque(true);
    nameBack.setBackground(darkGreen);

    name.setBounds(200, 62, 400, 50);
    name.setFont(subTitle);
    name.setForeground(darkBlue);
    name.setOpaque(false);

    descriptionBack.setBounds(50, 150, 700, 300);
    descriptionBack.setOpaque(true);
    descriptionBack.setBackground(green);

    description.setBounds(75, 175, 650, 250);
    description.setOpaque(false);
    description.setForeground(darkBlue);
    description.setFont(defaultF);
    description.setText("<html>Average Rating:"+(double)(Math.round(d.getRatings().getAverage()))/2 + " stars"+"<br/><br/><br/>Location: "+d.getCountry()+", "+d.getContinent()+"<br/><br/><br/>Climate: "+d.getClimate()+"<br/><br/><br/>Language: "+d.getLanguage()+"<br/><br/><br/>Cost of Vacation: "+d.getCostLower()+"-"+d.getCostUpper()+"</html>");

    back.setBounds(12, 62, 75, 50);
    back.setText("Back");
    back.setBackground(darkGreen);
    back.setForeground(darkBlue);
    back.setOpaque(true);
    back.addActionListener(this);

    profile.setBounds(725, 62, 50, 50);
    profile.setBackground(blue);
    profile.addActionListener(this);

    layer.setBounds(0,0, 800, 500);
    layer.add(nameBack, new Integer(1));
    layer.add(descriptionBack, new Integer(2));
    layer.add(name, new Integer(3));
    layer.add(description, new Integer(4));
    layer.add(picture, new Integer(5));

    layer.setVisible(true);
    
    infoF.add(layer);infoF.add(back);infoF.add(profile);

    infoF.setLayout(null);
    infoF.setVisible(true);
  
  }

// ⭐Public instance methods

  /**
  * Method that performs after user action. BY: Oskar, Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == back){

      if(direction == 1){
        infoF.setVisible(false);
        infoF.dispose();
        new Home(new User(user));
      }

      else if (direction == 2){
        infoF.setVisible(false);
        infoF.dispose();
        new Search(new User(user));
      }

      else if (direction == 3){
        infoF.setVisible(false);
        infoF.dispose();
        new Filter(new User(user));
      }
    }
    
    else if(e.getSource() == profile){ //Krish

      infoF.setVisible(false);
      infoF.dispose();
      new Profile(new User(user));
    }//end actionPerformed
    
  }//end Info
  
}//end Info.java