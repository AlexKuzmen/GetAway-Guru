/*
  Rate.java
  The Rate class models a question, specifficaly, the rating of a destination.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 3, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 30, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Search implements ActionListener{

  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.PLAIN, 48);
  private Font defaultF = new Font("Arial", Font.PLAIN, 16);
  private Font subTitle = new Font("Arial", Font.PLAIN, 24);

  private JFrame searchF;
  private JButton searchGo, back, loc;
  private JLabel searchBack, noResults;
  private JTextField search;
  private JLayeredPane layer;
  private User user;

// ⭐Contrustor methods

  /**
  * Contructor that sets the fields By: Oskar
  */
  public Search(User u){

    user = new User(u);
    searchF = new JFrame();
    searchF.setSize(800, 500);
    searchF.getContentPane().setBackground(blue);

    searchGo = new JButton();
    searchGo.setBounds(705,100,100,50);
    searchGo.setText("Search");
    searchGo.setBackground(darkBlue);
    searchGo.setForeground(Color.WHITE);
    searchGo.setFont(defaultF);
    searchGo.addActionListener(this);

    back = new JButton();
    back.setBounds(12,100,75,50);
    back.setText("Back");
    back.setBackground(darkBlue);
    back.setForeground(Color.WHITE);
    back.setFont(defaultF);
    back.addActionListener(this);

    searchBack = new JLabel();
    searchBack.setBounds(100,75,600,100);
    searchBack.setBackground(darkGreen);
    searchBack.setOpaque(true);

    search = new JTextField();
    search.setBounds(125, 100, 550, 50);

    loc = new JButton();
    loc.setBounds(100, 250, 600, 100);
    loc.setBackground(green);
    loc.setOpaque(true);
    loc.setVisible(false);
    loc.addActionListener(this);

    noResults = new JLabel("NO RESULTS FOUND", SwingConstants.CENTER);
    noResults.setBounds(100, 250, 600, 100);
    noResults.setBackground(blue);
    noResults.setForeground(darkBlue);
    noResults.setFont(subTitle);
    noResults.setOpaque(true);
    noResults.setVisible(false);
  
    
    layer = new JLayeredPane();
    layer.setBounds(0,0, 800, 500);
    layer.add(searchBack, new Integer(1));
    layer.add(search, new Integer(2));
    
    searchF.add(layer);searchF.add(loc);searchF.add(searchGo);searchF.add(back);searchF.add(noResults);
    searchF.setLayout(null);
    searchF.setVisible(true);
  }

// ⭐Public instance methods

  /**
  * Method that performs after user action By: Oskar
  * @param e The ActionEvent of user
  */
  public void actionPerformed(ActionEvent e){
    
    Destination userSearch = Destination.search(search.getText(), allD());
    
    if(e.getSource() == searchGo){
      
      if(!userSearch.getCity().equalsIgnoreCase("0")){
        loc.setText(userSearch.toString());
        loc.setVisible(true);
        noResults.setVisible(false);
      }

      else if(userSearch.getCity().equalsIgnoreCase("0")){
        loc.setVisible(false);
        noResults.setVisible(true);

      }
    }

    if(e.getSource() == loc){
      searchF.setVisible(false);
      searchF.dispose();
      new Info(userSearch, user, 2);
    }

    if(e.getSource() == back){
      searchF.setVisible(false);
      searchF.dispose();
      new Discover(user);
    }
    
  }//end actionPerformed

  // ⭐Static methods
  /**
  * Method that returns an array of Destination objects By: Oskar
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
  }
}//end Rate.java