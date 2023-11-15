/*
  InfoRate.java
  The InfoRate class models a page with the programmers' information.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Oskar Preiswerk
  Date Created: May 3, 2023
  Last Modified By: Oskar Preiswerk
  Date Modified: May 27, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.io.*;
import java.util.*;
public class InfoRate implements ActionListener{
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
  private JButton[] emptyStars = new JButton[10];
  private JButton[] fullStars = new JButton[10];
  private JLabel nameBack, name, description, descriptionBack, rate;
  private JLayeredPane layer;
  private User user;
  private Destination destination;
  private boolean hasRated = false;
  private int rating = 0;
  private ArrayList<String> locations;
  private Ratings r;
  private int ratingScore = 0;
  
// ⭐Contrustor methods
  /**
  * Constructor method that sets the fields. BY: Oskar
  * @param d The destination object
  */
  public InfoRate(Destination d, User u){

    user = new User(u);
    destination = new Destination (d);
    infoF = new JFrame();
    infoF.setSize(800, 500);
    infoF.getContentPane().setBackground(blue);
    
    back = new JButton();
    profile = new JButton(new ImageIcon("Images/profile.png"));
    nameBack = new JLabel();
    name = new JLabel(d.getCity(), SwingConstants.CENTER);
    description = new JLabel();
    descriptionBack = new JLabel();
    rate = new JLabel();
    layer = new JLayeredPane();
    layer.setBounds(0,0, 800, 500);

    boolean previousRated = false;

    cities();
    ratings();

    for(int i = 0; i < locations.size(); i++){
      if(locations.get(i).equals(destination.getCity())){
        previousRated = true;
        ratingScore = r.getRating(i);
      }
    }
    
    boolean even = true;
    
    int x = 175;
    
    for(int i = 0; i < 10; i++){
      if(even){
        emptyStars[i] = new JButton(new ImageIcon("Images/emptyLeft.png"));
        emptyStars[i].setBounds(x, 155, 35, 100);
        emptyStars[i].setBorder(null);
        emptyStars[i].setBackground(green);
        emptyStars[i].setOpaque(false);
        emptyStars[i].addActionListener(this);
        layer.add(emptyStars[i], new Integer(3));
        even = false;
      
        x = x+35;
        
      }

      else if(!even){
        emptyStars[i] = new JButton(new ImageIcon("Images/emptyRight.png"));
        emptyStars[i].setBounds(x, 155, 35, 100);
        emptyStars[i].setBorder(null);
        emptyStars[i].setBackground(green);
        emptyStars[i].addActionListener(this);
        emptyStars[i].setOpaque(false);
        layer.add(emptyStars[i], new Integer(3));
        even = true;
      
        x = x+35;
        
      }
    }

    even = true;
    x = 175;
    
    for(int i = 0; i < 10; i++){
      if(even){
        fullStars[i] = new JButton(new ImageIcon("Images/fullLeft.png"));
        fullStars[i].setBounds(x, 155, 35, 100);
        fullStars[i].setBorder(null);
        fullStars[i].setBackground(green);
        fullStars[i].setVisible(false);
        fullStars[i].addActionListener(this);
        layer.add(fullStars[i], new Integer(4));
        even = false;
      
        x = x+35;
      }

      else if(!even){
        fullStars[i] = new JButton(new ImageIcon("Images/fullRight.png"));
        fullStars[i].setBounds(x, 155, 35, 100);
        fullStars[i].setBorder(null);
        fullStars[i].setBackground(green);
        fullStars[i].setVisible(false);
        fullStars[i].addActionListener(this);
        layer.add(fullStars[i], new Integer(4));
        even = true;
        
        x = x+35;
      }
    }

      

    if(previousRated){
      System.out.println(ratingScore);
      for(int i = 0; i < ratingScore; i++){
      
        
        emptyStars[i].setVisible(false);
        fullStars[i].setVisible(true);
      
      
    }
    }

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

    rate.setBounds(75, 180, 100, 50);
    rate.setText("RATE:");
    rate.setFont(subTitle);
    rate.setForeground(darkBlue);
    rate.setOpaque(true);
    rate.setBackground(green);
    
    description.setBounds(75, 225, 650, 250);
    description.setOpaque(false);
    description.setForeground(darkBlue);
    description.setFont(defaultF);
    description.setText("<html>"+ d.getCountry()+", "+d.getContinent()+"<br/><br/><br/>Climate: "+d.getClimate()+"<br/><br/><br/>Language: "+d.getLanguage()+"<br/><br/><br/>Cost of Vacation: "+d.getCostLower()+"-"+d.getCostUpper()+"</html>");

    back.setBounds(12, 62, 75, 50);
    back.setText("Back");
    back.setBackground(darkGreen);
    back.setForeground(darkBlue);
    back.setOpaque(true);
    back.addActionListener(this);

    profile.setBounds(725, 62, 50, 50);
    profile.setBackground(blue);
    profile.addActionListener(this);

    
    layer.add(nameBack, new Integer(1));
    layer.add(descriptionBack, new Integer(2));
    layer.add(name, new Integer(3));
    layer.add(description, new Integer(4));
    layer.add(rate, new Integer(5));

    layer.setVisible(true);
    
    infoF.add(layer);infoF.add(back);

    infoF.setLayout(null);
    infoF.setVisible(true);
  
  }

// ⭐Public instance methods

  /**
  * Method that performs after user action. BY: Oskar
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){

    
    if(e.getSource() == back){

      if(hasRated){
        System.out.println(rating);
        inputRating(rating);
      }
      
      infoF.setVisible(false);
      infoF.dispose();
      new Rate(new User(user));
    
    }
    else if(e.getSource() == profile){
      
      infoF.setVisible(false);
      infoF.dispose();
      new Profile(new User(user));
    }
    

    
    for(int i = 0; i < 10; i++){
      if(e.getSource() == emptyStars[i]||e.getSource() == fullStars[i]){
        hasRated = true;
        rating = i +1;
        wipeStars();
        
        for(int j = 0; j < rating; j++){
          emptyStars[j].setVisible(false);
          fullStars[j].setVisible(true);
          
        }
        break;
      }
      
    }
    
    //end actionPerformed
    
  }
  public void inputRating(int rating){

    String error = null;
    try {
      user.rateDestination(new Destination(destination), rating);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
      
    }
    
  }
  
  public void wipeStars(){
    
    for(int i = 0; i< 10; i++){
      emptyStars[i].setVisible(true);
      fullStars[i].setVisible(false);
      
    }
  }


  public String cities(){

    String error = null;
    
    try{
      locations = user.userCities();
    }
    catch(IOException e){
      throw new RuntimeException(e);
    }
    return error;
    
  }

  public String ratings(){

    String error = null;
    
    try{
      r = user.userRatings();
    }
    catch(IOException e){
      throw new RuntimeException(e);
    }
    return error;
    
  }
}//end Info.java