/*
  About.java
  The About class models the about us page.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: April 14, 2023
  Last Modified By: Krish Patel
  Date Modified: April 19, 2023
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
public class About implements ActionListener{
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
  private JButton back, profile;
  private JLabel nameBack, name, scooby, saena, sio, aran, keena, descriptionBack, scoobyPhoto, saenaPhoto, sioPhoto, aranPhoto, keenaPhoto, quote, contact;
  private JLayeredPane layer;
  
  private User user;

  
  /**
   * A constructor that creates the frame By: Krish 
   */
  public About(User u){

    user = new User(u);
    aboutF = new JFrame();
    aboutF.setSize(800, 650);
    aboutF.getContentPane().setBackground(blue);
    
    back = new JButton();
    profile = new JButton(new ImageIcon("Images/profile.png"));
    nameBack = new JLabel();
    name = new JLabel("About Us");
    scooby = new JLabel();
    saena = new JLabel();
    sio = new JLabel();
    aran = new JLabel();
    keena = new JLabel();
    scoobyPhoto = new JLabel();
    saenaPhoto = new JLabel();
    sioPhoto = new JLabel();
    aranPhoto = new JLabel();
    keenaPhoto = new JLabel();
    descriptionBack = new JLabel();
    layer = new JLayeredPane();
    quote = new JLabel("<html>\"At Getaway Guru we strive to help you dispel any myths regarding travel and aim to help you save time and money finding a travel destination that suits your needs!\"<html>");
    contact = new JLabel("<html>We are eager to hear your comments or concerns. Please contact us at GetawayGuruTravelOfficialOn@gmail.com<html>");

    nameBack.setBounds(100, 50, 600, 75);
    nameBack.setOpaque(true);
    nameBack.setBackground(darkGreen);

    name.setBounds(320, 62, 400, 50);
    name.setFont(subTitle);
    name.setForeground(darkBlue);
    name.setOpaque(false);

    descriptionBack.setBounds(12, 150, 775, 640);
    descriptionBack.setOpaque(true);
    descriptionBack.setBackground(green);

    scooby.setBounds(53, 155, 120, 100);
    scooby.setOpaque(false);
    scooby.setForeground(darkBlue);
    scooby.setFont(defaultF);
    scooby.setText("<html>Samien Bell"+"<br/>(Lead Programmer)"+"</html>");
    scoobyPhoto = new JLabel(new ImageIcon("Images/scooby.png"));
    scoobyPhoto.setBounds(53, 250, 120, 180);

    saena.setBounds(205, 155, 120, 100);
    saena.setOpaque(false);
    saena.setForeground(darkBlue);
    saena.setFont(defaultF);
    saena.setText("<html>Alexander Kuzmenko"+"<br/>(Systems Analyst)"+"</html>");
    saenaPhoto = new JLabel(new ImageIcon("Images/saena.png"));
    saenaPhoto.setBounds(205, 250, 120, 180);

    sio.setBounds(345, 155, 120, 100);
    sio.setOpaque(false);
    sio.setForeground(darkBlue);
    sio.setFont(defaultF);
    sio.setText("<html>Krish Patel"+"<br/>(Project Manager)"+"</html>");
    sioPhoto = new JLabel(new ImageIcon("Images/sio.png"));
    sioPhoto.setBounds(345, 250, 120, 180);

    aran.setBounds(485, 155, 120, 100);
    aran.setOpaque(false);
    aran.setForeground(darkBlue);
    aran.setFont(defaultF);
    aran.setText("<html>Oskar Preiswerk"+"<br/>(Graphics Designer)"+"</html>");
    aranPhoto = new JLabel(new ImageIcon("Images/aran.png"));
    aranPhoto.setBounds(485, 250, 120, 180);

    keena.setBounds(625, 155, 120, 100);
    keena.setOpaque(false);
    keena.setForeground(darkBlue);
    keena.setFont(defaultF);
    keena.setText("<html>Nicholas Terek"+"<br/>(Technical Writer)"+"</html>");
    keenaPhoto = new JLabel(new ImageIcon("Images/keena.png"));
    keenaPhoto.setBounds(625, 250, 120, 180);

    quote.setBounds(53, 440, 697, 60);
    quote.setFont(defaultF);
    quote.setForeground(darkBlue);
    quote.setOpaque(false);

    contact.setBounds(53, 500, 697, 50);
    contact.setFont(defaultF2);
    contact.setForeground(darkBlue);
    contact.setOpaque(false);

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
    layer.add(scooby, new Integer(4));
    layer.add(scoobyPhoto, new Integer(4));
    layer.add(saena, new Integer(4));
    layer.add(saenaPhoto, new Integer(4));
    layer.add(sio, new Integer(4));
    layer.add(sioPhoto, new Integer(4));
    layer.add(aran, new Integer(4));
    layer.add(aranPhoto, new Integer(4));
    layer.add(keena, new Integer(4));
    layer.add(keenaPhoto, new Integer(4));
    layer.add(quote, new Integer(4));
    layer.add(contact, new Integer(4));

    layer.setVisible(true);
    
    aboutF.add(layer);aboutF.add(back);aboutF.add(profile);

    aboutF.setLayout(null);
    aboutF.setVisible(true);
    
  }

  /**
   * Catches the user's click  By: Krish
   * @param e The button being clicked
   */
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == back){
      System.out.println("working");
      aboutF.setVisible(false);
      aboutF.dispose();
      new Home(new User(user));
    }
    else if(e.getSource() == profile){
      System.out.println("working");
      aboutF.setVisible(false);
      aboutF.dispose();
      new Profile(new User(user));
    }
  }
}