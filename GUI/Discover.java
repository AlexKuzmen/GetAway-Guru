import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Discover implements ActionListener{
   //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);
  private Font small = new Font("Arial", Font.BOLD, 10);

  JFrame discoverF;
  JLabel adventure;
  JButton filter, search, back;
  User user;

  public Discover(User u){

    user = new User(u);
    
    discoverF = new JFrame();
    discoverF.setSize(800,500);
    discoverF.getContentPane().setBackground(blue);
    
    adventure = new JLabel("Adventure Awaits", SwingConstants.CENTER);
    filter = new JButton();
    search = new JButton();
    back = new JButton();

    adventure.setBounds(100, 50, 600, 100);
    adventure.setFont(title);

    filter.setBounds(75, 200, 300, 100);
    filter.setText("Search By Filter");
    filter.setFont(subTitle);
    filter.setBackground(green);
    filter.addActionListener(this);

    search.setBounds(425, 200, 300, 100);
    search.setText("Search By Name");
    search.setFont(subTitle);
    search.setBackground(green);
    search.addActionListener(this);

    back.setBounds(30, 80, 75, 50);
    back.setText("Back");
    back.setBackground(green);
    back.addActionListener(this);

    discoverF.add(adventure);discoverF.add(filter);discoverF.add(search);discoverF.add(back);

    discoverF.setLayout(null);
    discoverF.setVisible(true);
    
    
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == filter){
      discoverF.setVisible(false);
      discoverF.dispose();
      new Filter(new User(user));
    }

    else if(e.getSource() == search){
      discoverF.setVisible(false);
      discoverF.dispose();
      new Search(new User(user));
    }

    if(e.getSource() == back){
      discoverF.setVisible(false);
      discoverF.dispose();
      new Home(user);
    }
  }
}