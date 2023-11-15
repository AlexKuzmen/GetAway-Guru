/*
  Home.java
  The Home class models the homepage.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk, Samien Bell, Krish Patel
  Date Created: March 27, 2023
  Last Modified By: Samien Bell
  Date Modified: June 9, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Home implements ActionListener{
  private JButton loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8, loc9, loc10, rate, discover, about, profile, admin, refresh;
  private JLabel reccomended, header, recText;
  private JFrame homeF;
  private JLayeredPane layer;
  private User user;

  private Destination[] recs;

  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);
  private Font small = new Font("Arial", Font.BOLD, 10);
  
// ⭐Contrustor methods
  /**
  * Constructor that sets the field. BY: Oskar, Samien, Krish
  */
  public Home(User u){

    user = new User(u);
    destR(); //recomendation code - Samien
    homeF = new JFrame();
    loc1 = new JButton();
    loc2 = new JButton();
    loc3 = new JButton();
    loc4 = new JButton();
    loc5 = new JButton();
    loc6 = new JButton();
    loc7 = new JButton();
    loc8 = new JButton();
    loc9 = new JButton();
    loc10 = new JButton();
    rate = new JButton();
    discover = new JButton();
    about = new JButton();
    profile = new JButton(new ImageIcon("Images/profile.png"));
    admin = new JButton();
    reccomended = new JLabel();
    header = new JLabel();
    layer = new JLayeredPane();
    recText = new JLabel("Recommended For You", SwingConstants.CENTER);
    refresh = new JButton(new ImageIcon("Images/refresh.png"));

    refresh.setBounds(700, 136, 50, 52);
    refresh.addActionListener(this);
    refresh.setBackground(darkGreen);

    
    

    homeF.setSize(800,500);
    homeF.getContentPane().setBackground(blue);

    header.setBounds(0,0,800,75);
    header.setBackground(darkGreen);
    header.setOpaque(true);

    rate.setBounds(50,12,150,50);
    rate.setText("Rate Locations");
    rate.setBackground(darkGreen);
    rate.setForeground(darkBlue);
    rate.setBorder(BorderFactory.createLineBorder(darkBlue));
    rate.addActionListener(this);

    discover.setBounds(275,12,150,50);
    discover.setText("Discover Locations");
    discover.setBackground(darkGreen);
    discover.setForeground(darkBlue);
    discover.setBorder(BorderFactory.createLineBorder(darkBlue));
    discover.addActionListener(this);
    
    about.setBounds(500,12,150,50);
    about.setText("About Us");
    about.setBackground(darkGreen);
    about.setForeground(darkBlue);
    about.setBorder(BorderFactory.createLineBorder(darkBlue));
    about.addActionListener(this);

    profile.setBounds(725, 12, 50, 50);
    profile.setBackground(darkGreen);
    profile.addActionListener(this);

    reccomended.setBounds(25, 125, 750, 75);
    reccomended.setBackground(darkGreen);
    reccomended.setOpaque(true);

    recText.setBounds(200, 137, 400, 50);
    //recText.setText();
    recText.setFont(subTitle);
    recText.setOpaque(false);
    recText.setForeground(darkBlue);

    layer.setBounds(0,0,800,500);
    layer.add(header, new Integer(1));
    layer.add(rate, new Integer(2));
    layer.add(discover, new Integer(3));
    layer.add(about, new Integer(4));
    layer.add(profile, new Integer(5));
    layer.add(reccomended, new Integer(6));
    layer.add(recText, new Integer(7));
    layer.add(refresh, new Integer(8));
    
    loc1.setBounds(12, 225, 375, 40);
    loc1.setBackground(green);
    loc1.setText(recs[0].toString());
    loc1.setForeground(darkBlue);
    loc1.setFont(defaultF);
    loc1.addActionListener(this);
    
    loc2.setBounds(12, 277, 375, 40);
    loc2.setBackground(green);
    loc2.setText(recs[1].toString());
    loc2.setForeground(darkBlue);
    loc2.setFont(defaultF);
    loc2.addActionListener(this);
    
    loc3.setBounds(12, 329, 375, 40);
    loc3.setBackground(green);
    loc3.setText(recs[2].toString());
    loc3.setForeground(darkBlue);
    loc3.setFont(defaultF);
    loc3.addActionListener(this);
    
    loc4.setBounds(12, 381, 375, 40);
    loc4.setBackground(green);
    loc4.setText(recs[3].toString());
    loc4.setForeground(darkBlue);
    loc4.setFont(defaultF);
    loc4.addActionListener(this);
    
    loc5.setBounds(12, 433, 375, 40);
    loc5.setBackground(green);
    loc5.setText(recs[4].toString());
    loc5.setForeground(darkBlue);
    loc5.setFont(defaultF);
    loc5.addActionListener(this);

    loc6.setBounds(412, 225, 375, 40);
    loc6.setBackground(green);
    loc6.setText(recs[5].toString());
    loc6.setForeground(darkBlue);
    loc6.setFont(defaultF);
    loc6.addActionListener(this);

    loc7.setBounds(412, 277, 375, 40);
    loc7.setBackground(green);
    loc7.setText(recs[6].toString());
    loc7.setForeground(darkBlue);
    loc7.setFont(defaultF);
    loc7.addActionListener(this);

    loc8.setBounds(412, 329, 375, 40);
    loc8.setBackground(green);
    loc8.setText(recs[7].toString());
    loc8.setForeground(darkBlue);
    loc8.setFont(defaultF);
    loc8.addActionListener(this);

    loc9.setBounds(412, 381, 375, 40);
    loc9.setBackground(green);
    loc9.setText(recs[8].toString());
    loc9.setForeground(darkBlue);
    loc9.setFont(defaultF);
    loc9.addActionListener(this);

    loc10.setBounds(412, 433, 375, 40);
    loc10.setBackground(green);
    loc10.setText(recs[9].toString());
    loc10.setForeground(darkBlue);
    loc10.setFont(defaultF);
    loc10.addActionListener(this);

    //Check if admin - Krish
    admin.setBounds(200, 75, 400, 50);
    admin.setBackground(darkBlue);
    admin.setText("Admin Statistics");
    admin.setForeground(Color.WHITE);
    admin.setFont(defaultF);
    admin.setVisible(false);
    admin.addActionListener(this);
    
    boolean adminTest = user.isAdminV2();
    if(adminTest == true){
       admin.setVisible(true);
    }
    
    

    layer.setVisible(true);
    
    homeF.add(layer);homeF.add(loc1);homeF.add(loc2);homeF.add(loc3);homeF.add(loc4);homeF.add(loc5);homeF.add(loc6);homeF.add(loc7);homeF.add(loc8);homeF.add(loc9);homeF.add(loc10);homeF.add(admin);

    homeF.setLayout(null);
    homeF.setVisible(true);
    
    
  }

// ⭐Public instance methods

  /**
  * Method that performs after a user's action. BY: OSkar, Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == loc1){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[0], new User(user), 1);
    }

    else if(e.getSource() == loc2){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[1], new User(user), 1);
    }
    
    else if(e.getSource() == loc3){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[2], new User(user), 1);
    }

    else if(e.getSource() == loc4){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[3], new User(user), 1);
    }

    else if(e.getSource() == loc5){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[4], new User(user), 1);
    }

    else if(e.getSource() == loc6){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[5], new User(user), 1);
    }

    else if(e.getSource() == loc7){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[6], new User(user), 1);
    }

    else if(e.getSource() == loc8){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[7], new User(user), 1);
    }

    else if(e.getSource() == loc9){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[8], new User(user), 1);
    }

    else if(e.getSource() == loc10){

      homeF.setVisible(false);
      homeF.dispose();
      new Info(recs[9], new User(user), 1);
    }

    else if(e.getSource() == about){ //Krish
      homeF.setVisible(false);
      homeF.dispose();
      new About(new User(user));
    }

    else if(e.getSource() == admin){ //Krish
      homeF.setVisible(false);
      homeF.dispose();
      new AdminStats(new User(user));
    }

    else if(e.getSource() == profile){ //Krish
      homeF.setVisible(false);
      homeF.dispose();
      new Profile(new User(user));
    }

    else if(e.getSource() == rate){
      homeF.setVisible(false);
      homeF.dispose();
      new Rate(new User(user));
    }

    else if(e.getSource() == discover){
      homeF.setVisible(false);
      homeF.dispose();
      new Discover(new User(user));
    }

    else if(e.getSource() == refresh){
      homeF.setVisible(false);
      homeF.dispose();
      new Home(new User(user));
    }
  }//end ActionPerformed

  /**
  * Method that runs the destRecs method and catches the IOException BY: Samien
  * @return error 
  */
  public String destR(){

    String error = null;
    
    try{
      recs = user.destRecs();
    }
    catch(IOException e){
      throw new RuntimeException(e);
    }
    return error;
    
  }//end topD

// ⭐Static methods
  /**
  * Method that returns an array of Destination objects. BY: Samien
  * @return real The array of Destination objects
  */
  public static Destination[] allD(){

    Destination[] array= new Destination[1];
    String error = null;
    try {
      Destination[] real =  Destination.arrayDest();
      return real;
    }
    catch (IOException e) {
      throw new RuntimeException(e);
      
    }
    
  }//end allD
  
}//end Home.java