import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.FlowLayout;

public class Filter implements ActionListener {
  JFrame f;
  String[] continent = { "Continent", "North America", "South America", "Europe", "Africa", "Asia", "Australia",
      "Antarctica" };
  String[] language = { "Language", "English", "French", "Arabic", "Spanish", "German", "Mandarin" };
  String[] climate = { "Climate", "Very Cold", "Cold", "Cool", "Moderate", "Warm", "Hot", "Very Hot" };
  String[] price = { "Price", "50-100", "101-150", "151-650", "651-1200", "1201-2000", "2001-5000", "5001-10000" };
  JComboBox filterCo, filterL, filterCl, filterP;
  JButton search, back;
  JLabel filtersBack;
  boolean filter = false;
  JPanel panel;
  JScrollPane scroll;
  JLayeredPane layer;
  User user;
  Destination[] dest = allD();

  // color scheme and fonts used
  private Color green = new Color(115, 192, 123);
  private Color blue = new Color(181, 207, 236);
  private Color darkBlue = new Color(53, 63, 158);
  private Color darkGreen = new Color(81, 166, 115);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);
  private Font small = new Font("Arial", Font.BOLD, 10);

  JButton[] filteredLoc = new JButton[50];

  public Filter(User u) {
    user = new User(u);

    f = new JFrame();
    f.getContentPane().setBackground(blue);
    f.setLayout(null);
    f.setSize(800, 500);

    filterCo = new JComboBox(continent);
    filterL = new JComboBox(language);
    filterCl = new JComboBox(climate);
    filterP = new JComboBox(price);
    search = new JButton();
    filtersBack = new JLabel();
    back = new JButton();
    layer = new JLayeredPane();

    filtersBack.setBounds(25, 12, 750, 75);
    filtersBack.setBackground(darkGreen);
    filtersBack.setOpaque(true);

    back.setBounds(75, 110, 100, 50);
    back.setText("Back");
    back.setBackground(darkBlue);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);

    JPanel panel2 = new JPanel();
    panel2.setBounds(100, 150, 600, 5000);

    panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
    panel.setPreferredSize(new Dimension(600, 5000));
    panel.setBackground(blue);
    panel2.add(panel);

    int y = 0;
    for (int i = 0; i < filteredLoc.length; i++) {
      filteredLoc[i] = new JButton();
      filteredLoc[i].setPreferredSize(new Dimension(600, 50));
      filteredLoc[i].setBackground(green);
      filteredLoc[i].setFont(defaultF);
      filteredLoc[i].setVisible(false);
      filteredLoc[i].addActionListener(this);
      panel.add(filteredLoc[i]);
      y = y + 150;
    }

    scroll = new JScrollPane(panel);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBounds(100, 175, 600, 300);

    filterCo.setBounds(50, 25, 150, 50);
    filterL.setBounds(233, 25, 150, 50);
    filterCl.setBounds(416, 25, 150, 50);
    filterP.setBounds(600, 25, 150, 50);

    layer.setBounds(25, 12, 750, 175);
    layer.add(filtersBack, new Integer(1));
    layer.add(filterCo, new Integer(2));
    layer.add(filterL, new Integer(2));
    layer.add(filterCl, new Integer(2));
    layer.add(filterP, new Integer(2));

    search.setBounds(650, 110, 100, 50);
    search.setText("Filter");
    search.setBackground(darkBlue);
    search.setForeground(Color.WHITE);
    search.addActionListener(this);

    f.add(layer);
    f.add(search);
    f.add(scroll);
    f.add(back);
    f.setVisible(true);

  }

  public void actionPerformed(ActionEvent e) {
    

    if (e.getSource() == search) {

      for (int i = 0; i < 50; i++) {
        filteredLoc[i].setVisible(false);
      }

      String cont = (String) filterCo.getSelectedItem();
      String lan = (String) filterL.getSelectedItem();
      String clim = (String) filterCl.getSelectedItem();
      String price = (String) filterP.getSelectedItem();

      if (!cont.equals("Continent")) {

        dest = Destination.filterCont(cont, dest);
        filter = true;
      }

      if (!lan.equals("Language")) {
        dest = Destination.filterLan(lan, dest);
        filter = true;
      }

      if (!clim.equals("Climate")) {
        dest = Destination.filterClimate(clim, dest);
        filter = true;
      }

      if (!price.equals("Price")) {
        String[] minmax = price.split("-");
        dest = Destination.filterPrice(Double.parseDouble(minmax[0]), dest);
        filter = true;
      }

      if (filter == true) {
        
        for (int i = 0; i < dest.length; i++) {

          filteredLoc[i].setText(dest[i].toString());
          
          filteredLoc[i].setVisible(true);
        }

        
      }

    }

    if (e.getSource() == back) {
      f.setVisible(false);
      f.dispose();
      new Discover(user);
    }

    for (int i = 0; i < filteredLoc.length; i++) {
        
      if (e.getSource() == filteredLoc[i]) {

        System.out.println(dest[i]);
        new Info(dest[i], user, 3);
        f.setVisible(false);
        f.dispose();
        break;
      }
    }

  }

  /**
   * Method that returns an array of Destination objects. BY: Samien
   * 
   * @return real The array of Destination objects
   */
  public static Destination[] allD() {

    Destination[] array = new Destination[1];
    String error = null;
    try {
      Destination[] real = Destination.arrayDest();
      return real;
    } catch (IOException e) {
      throw new RuntimeException(e);

    }

  }// end allD
}