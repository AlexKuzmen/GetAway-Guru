/*
  AdminStats.java
  The AdminStats class models the admin only page.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: April 14, 2023
  Last Modified By: Krish Patel
  Date Modified: April 19, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
public class AdminStats implements ActionListener{
  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font defaultF2 = new Font("Arial", Font.BOLD, 12);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);

  private JFrame aboutF;
  private JButton back, profile, addPerson;
  private JLabel nameBack, descriptionBack, name, info;
  private JLayeredPane layer;
  
  private User user;
  private Admin theAdmin;

  
  /**
   * A constructor that creates the frame By: Krish 
   */
  public AdminStats(User u){

    user = new User(u);
    theAdmin = new Admin();
    aboutF = new JFrame();
    aboutF.setSize(800, 650);
    aboutF.getContentPane().setBackground(blue);
    
    back = new JButton();
    addPerson = new JButton();
    profile = new JButton(new ImageIcon("Images/profile.png"));
    nameBack = new JLabel();
    name = new JLabel("Admin Statistics");
    info = new JLabel();
    descriptionBack = new JLabel();
    layer = new JLayeredPane();

    nameBack.setBounds(100, 50, 600, 75);
    nameBack.setOpaque(true);
    nameBack.setBackground(darkGreen);

    name.setBounds(290, 62, 400, 50);
    name.setFont(subTitle);
    name.setForeground(darkBlue);
    name.setOpaque(false);

    descriptionBack.setBounds(12, 150, 775, 640);
    descriptionBack.setOpaque(true);
    descriptionBack.setBackground(green);

    addPerson.setBounds(200, 150, 400, 50);
    addPerson.setText("Add User");
    addPerson.setBackground(darkBlue);
    addPerson.setForeground(Color.WHITE);
    addPerson.setOpaque(true);
    addPerson.addActionListener(this);

    info.setBounds(53, 250, 240, 100);
    info.setOpaque(false);
    info.setForeground(darkBlue);
    info.setFont(defaultF);
    info.setText("<html>Total users: "+theAdmin.getNumUsers()+"<br/>Total destinations: "+theAdmin.getLocationsNum()+"</html>");

    back.setBounds(12, 62, 75, 50);
    back.setText("Back");
    back.setBackground(darkGreen);
    back.setForeground(darkBlue);
    back.setOpaque(true);
    back.addActionListener(this);

    profile.setBounds(725, 62, 50, 50);
    profile.setBackground(blue);
    profile.addActionListener(this);

    layer.setBounds(0,0, 800, 570);
    layer.add(nameBack, new Integer(1));
    layer.add(descriptionBack, new Integer(2));
    layer.add(name, new Integer(3));
    layer.add(addPerson, new Integer(4));
    layer.add(info, new Integer(4));

    layer.setVisible(true);
    
    aboutF.add(layer);aboutF.add(back);aboutF.add(profile);

    aboutF.setLayout(null);
    aboutF.setVisible(true);

    
    
  }

  /**
   * Catches the user's click By: Krish
   * @param e The button being clicked
   */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == back){
      System.out.println("working");
      aboutF.setVisible(false);
      aboutF.dispose();
      new Home(new User(user));
    }
    else if(e.getSource() == addPerson){
      System.out.println("working");
      aboutF.setVisible(false);
      aboutF.dispose();
      new SignUp(true);
    }
    else if(e.getSource() == profile){
      System.out.println("working");
      aboutF.setVisible(false);
      aboutF.dispose();
      new Profile(new User(user));
    }
  }
}