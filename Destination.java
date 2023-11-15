/*
  Destination.java
  This class models a travel destination and holds the city, country, continent, climate, language, cost range, safety, and ratings as fields
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Samien Bell, Alexander Kuzmenko
  Date Created: April 19, 2023
  Last Modified By: A K
  Date Modified: June 5, 2023
*/

import java.io.*;
import java.util.*;

public class Destination implements Comparable<Destination> {

  private String city;
  private String country;
  private String continent;
  private String climate;
  private String language;
  private double costLower;
  private double costUpper;
  private Ratings ratings;

  // ⭐Public constructors
  /**
    Default Constructor BY: Samien
  */
  public Destination() {
    city = null;
    country = null;
    continent = null;
    climate = null;
    language = null;
    costLower = 0.0;
    costUpper = 0.0;
    ratings = new Ratings();
  }

  
  /**
  * Constructor method BY: Alexander
  * @param cit    The city of the destination
  * @param cou    The country of the destination
  * @param con    The continent of the destination
  * @param cli    The climate of the destination
  * @param lan    The language of the destination
  * @param costL  The lower cost of the destination
  * @param costH  The upper cost of the destination
  * @param rat    The rating Object of the destination
  */
  public Destination(String cit, String cou, String con, String cli, String lan, double costL, double costH, Ratings rat) {
    city = cit;
    country = cou;
    continent = con;
    climate = cli;
    language = lan;
    costLower = costL;
    costUpper = costH;
    ratings = new Ratings(rat);
  
  }//end Destination constructor

  /**
  * Constructor method that excludes ratings BY: Alexander
  * @param cit    The city of the destination
  * @param cou    The country of the destination
  * @param con    The continent of the destination
  * @param cli    The climate of the destination
  * @param lan    The language of the destination
  * @param costL  The lower cost of the destination
  * @param costH  The upper cost of the destination
  */
  public Destination(String cit, String cou, String con, String cli, String lan, double costL, double costH) {
    city = cit;
    country = cou;
    continent = con;
    climate = cli;
    language = lan;
    costLower = costL;
    costUpper = costH;
    ratings = new Ratings();
  
  }//end Destination constructor
  
  
  /**
  * The copy constructor initializes the object as a copy of another Destination BY: Alexander
  * @param object 2 The object to copy
  */
  public Destination(Destination dest) {
    city = dest.city;
    country = dest.country;
    continent = dest.continent;
    climate = dest.climate;
    language = dest.language;
    costLower = dest.costLower;
    costUpper = dest.costUpper;
    ratings = new Ratings(dest.ratings);
  }//end Destination

// ⭐Getters and Setters
  /**
    Getter method for city BY: Alexander
  */
  public String getCity() {
    return city;
  }

  /**
    Getter method for country BY: Alexander
  */
  public String getCountry() {
    return country;
  }

  /**
    Getter method for continent BY: Alexander
  */
  public String getContinent() {
    return continent;
  }

  /**
    Getter method for climate BY: Alexander
  */
  public String getClimate() {
    return climate;
  }

  /** 
    Getter method for language BY: Alexander
  */
  public String getLanguage() {
    return language;
  }

  /**
    Getter method for lower cost BY: Alexander
  */
  public double getCostLower() {
    return costLower;
  }

  /** 
     Getter method for upper cost BY: Alexander
  */
  public double getCostUpper() {
    return costUpper;
  }

  /**
    Getter method for ratings BY: Alexander
  */
  public Ratings getRatings() {
    return ratings;
  }

  /**
    Setter method for ratings BY: Alexander
  */
  public void setRatings(Ratings newRats) {
    ratings = newRats;
  }


  /**
    Method that returns a destination as a string BY: Alexander
  */
  public String toString() {
    double avrgDouble = Math.round(ratings.getAverage());
    
    if (avrgDouble == 0) {
      return "<html>"+city + ", " + country + "<br/> Average Rating: " + "N/A</html>";
    }
    else {
      return "<html>"+city + ", " + country + "<br/> Average Rating: " + avrgDouble/2 + "/5 stars</html>";
    }
  }


  /**
    This method returns the Destination who's city name matches the argument
    @param city The name of the city to search for
    @return dest The Destination who's city name matches the argument
  */
  public static Destination toDest(String city) throws IOException {

    Destination dest = new Destination();
    Destination[] allDests = Destination.arrayDest();

    for (int i = 0; i < allDests.length; i++) {
      if (city.equalsIgnoreCase(allDests[i].getCity())) {
        dest = new Destination(allDests[i]); //deep copy
        break;
      }
    }

    return dest;
  }
  
  
// ⭐Static methods
  /**
  * Method that returns an array of Destination objects from Destinations.csv BY: Alexander
  * @return arr 
  */
  public static Destination[] arrayDest() throws IOException{
//size of Destinations.csv and AllRatings.csv
    int counter = 0;
    int countR = 0;

    File tempF = new File("csv files/Destinations.csv");
    Scanner f = new Scanner(tempF);

    while(f.hasNext()){
      counter++;
      f.nextLine();
    }
    f.close();

    File tempFCR = new File("csv files/AllRatings.csv");
    Scanner fCR = new Scanner(tempFCR);
    
    while(fCR.hasNext()){
      countR++;
      fCR.nextLine();
    }
    fCR.close();

    Destination[] arr = new Destination[counter];//array of objects
    
//fill each destination object with with the Destinations.csv
    File tempF1 = new File("csv files/Destinations.csv");
    Scanner fD = new Scanner(tempF);

    for(int i = 0; i < arr.length; i++){//loop total lines in Destinations.csv
//Open AllRatings.csv
      File tempF2 = new File("csv files/AllRatings.csv");
      Scanner fR = new Scanner(tempF2);
      
      String[] lineArr = fD.nextLine().split(",");//split line in Destinations.csv

      String tempCit = lineArr[0];
      String tempCou = lineArr[1];
      String tempCon = lineArr[2];
      String tempCli = lineArr[3];
      String tempLan = lineArr[4];
      double tempCostL = Double.parseDouble(lineArr[5]);
      double tempCostH = Double.parseDouble(lineArr[6]);

      arr[i] = new Destination(tempCit, tempCou, tempCon, tempCli, tempLan, tempCostL, tempCostH);//fill array of objects with destination objects
      
//check if city matches and add it to arraylist
      ArrayList<Integer> allArr = new ArrayList<Integer>();//array list of ratings

//Checking for city matches to fill array with
      for(int r = 0; r < countR; r++){//going through AllRatings.csv file
        String[] rTempArray = fR.nextLine().split(",");//city[0],rating[1]

        if(rTempArray[0].equalsIgnoreCase(tempCit)){//if match add to arraylist
          allArr.add(Integer.parseInt(rTempArray[1]));
        }
          
      }//end r array

      Ratings tempR = new Ratings(allArr);//creating rating object

      arr[i].setRatings(tempR);//use setRatings method to add to Destination object(s)

      fR.close();
    }//end i array (redo for each line in Destinations.csv)

    return arr; //Return the array filled with complete Destination objects of size Destinations.csv
  }//end arrayDest

  
  /**  
    Method that takes in the array of all destinations and returns 10 random destinations BY: Samien
    @param allDests array of destinations of which 10 are selected
    @return array of ten random destinations
  */
  public static Destination[] randomDests(Destination[] allDests) {
    
    Destination[] tenDests = new Destination[10];
    ArrayList <Integer> random = new ArrayList<Integer>();
    
    for (int i = 0; i < allDests.length; i++) {
      random.add(i);
    }
    
    Collections.shuffle(random);
    for (int j = 0; j < tenDests.length; j++) {
      tenDests[j] = allDests[random.get(j)];
    }
    
    return tenDests;
  }//end randomDests

  
  /**
  Override compareTo method BY: Samien
  */
  public int compareTo(Destination dest) {
    double compareAverage = dest.getRatings().getAverage();
    if (this.ratings.getAverage() - compareAverage < 0.0) {
      return 1;
    } else if (this.ratings.getAverage() - compareAverage > 0.0) {
      return -1;
    } else {
      return 0;
    }
  }
 
  /** 
    Method that takes in the array of all destinations and returns the n highest rated BY: Samien
    @param allDests Array of destinations of which n are selected
    @return array of ten random destinations
  */
  public static Destination[] topDests(Destination[] allDests, int n) {
    
    Destination[] tenDests = new Destination[n];
    Arrays.sort(allDests);

    for (int i = 0; i < tenDests.length; i++) {
      tenDests[i] = allDests[i];
    }
    return tenDests;
  }//end topDests

  /*
  * Method that allows the user to rate a location
  * 
  */

  /**
  *  Method that searches for a specific location by name BY: Samien
  *  @param s The user String
  *  @param d The array of destinations
  *  @return userSearch the destination object being searched for
  */
  public static Destination search(String s, Destination[] d){
    
    Destination userSearch = new Destination("0", "0","0", "0", "0", 0, 0);
    
    String[] user = s.split("");
    
    int total, correct;
    double percent;

    for(int i = 0; i < d.length; i++){

      correct = 0;
      
      String[] searching = d[i].getCity().split("");
      String[] compare = new String[searching.length];
      
  
      for(int k =0; k <searching.length; k++){
        if(k < user.length){
          compare[k] = user[k];
        }

        else if(k >= user.length){
          compare[k] = "!";
        }
      }
      
      total = searching.length;
      
      for(int j = 0; j<total; j++){
        if(compare[j].equalsIgnoreCase(searching[j])){
          correct++;
          
        }
      }

    
      double realCorrect = correct;
      double realTotal = total;
      percent = realCorrect/realTotal;

      if(percent >= 0.75){
        userSearch = d[i];
        
        break;
      }
    }
    
    return userSearch;
    
  }//end search

  public static Destination[] filterCont(String userCont, Destination[] d){

    int counter = 0;
    for(int i = 0; i < d.length; i++){
      if(d[i].getContinent().equals(userCont)){
        counter++;
      }
    }

    Destination[] r = new Destination[counter];

    int counterB = 0;
    
    for(int i = 0; i < d.length; i++){
      if(d[i].getContinent().equals(userCont)){
        r[counterB] = new Destination(d[i]);
        counterB++;
      }
    }

    return r;
  }

  public static Destination[] filterLan(String language, Destination[] d){

    int counter = 0;
    for(int i = 0; i < d.length; i++){
      if(d[i].getLanguage().equals(language)){
        counter++;
      }
    }

    Destination[] r = new Destination[counter];

    int counterB = 0;
    
    for(int i = 0; i < d.length; i++){
      if(d[i].getLanguage().equals(language)){
        r[counterB] = new Destination(d[i]);
        counterB++;
      }
    }

    return r;
  }

  public static Destination[] filterClimate(String climate, Destination[] d){

    int counter = 0;
    for(int i = 0; i < d.length; i++){
      if(d[i].getClimate().equals(climate)){
        counter++;
      }
    }

    Destination[] r = new Destination[counter];

    int counterB = 0;
    
    for(int i = 0; i < d.length; i++){
      if(d[i].getClimate().equals(climate)){
        r[counterB] = new Destination(d[i]);
        counterB++;
      }
    }

    return r;
  }

  public static Destination[] filterPrice(double price, Destination[] d){

    int counter = 0;
    for(int i = 0; i < d.length; i++){
      if(d[i].getCostLower()==price){
        counter++;
      }
    }

    Destination[] r = new Destination[counter];

    int counterB = 0;
    
    for(int i = 0; i < d.length; i++){
      if(d[i].getCostLower() == price){
        r[counterB] = new Destination(d[i]);
        counterB++;
      }
    }

    return r;
  }


  
}//end class Destination.java