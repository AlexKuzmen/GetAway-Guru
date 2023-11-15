/*
  Ratings.java
  The Ratings class models the ratings of the various destinations. The field is an ArrayList
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Samien Bell, Alexander Kuzmenko
  Date Created: March 14, 2023
  Last Modified By: A K
  Date Modified: June 5, 2023
*/

import java.util.ArrayList;

public class Ratings {

  private ArrayList<Integer> ratings;

// ⭐Our public Constructors
  /**
   * Constructor that sets the default values. BY: Samien
   */
  public Ratings() {
    ratings = new ArrayList<Integer>();
  }

  /**
  * Constructor that sets the info BY: Alexander
  * @param r The ArrayList of integers
  */
  public Ratings(ArrayList<Integer> r) {//added parameter
    ratings = r;
  }

  /**
  * Copy contructor BY: Samien
  * @param rat the Ratings object to copy
  */
  public Ratings(Ratings rat) {//changed
    ratings = rat.ratings;
  }
  
// ⭐Getters and setters
  /**
  * Method that returns the average of the ratings BY: Samien
  * @return a double as the average
  */
  public double getAverage() {
    if (ratings.size() == 0) {
      return 0.0;
    }
    else {
      double sum = 0;
      for (int i = 0; i < ratings.size(); i++) {
        sum = sum + ratings.get(i);
        
      }
      double size = ratings.size();
      
      return sum/size;
    }
  }//end getAverage

// ⭐Instance Methods
  /**
  * Method that can change a rating BY: Samien
  * @param index the int index of the ArrayList 
  * @param newRat the int rating to replace the old one
  */
  public void setRating(int index, int newRat) {
    ratings.set(index, newRat);
  }//end setRating
  
  /**
  * Method that adds a rating to the ArrayList BY: Alexander
  * @param newRat the int rating to add 
  */
  public void addRating(int newRat) {
    ratings.add(newRat);
  }//end addRating

  /**
  * Method that returns the rating at a specific index
  * @param index The int index in the ArrayList
  * @return The rating at the specified index
  */
  public int getRating(int index){
    return ratings.get(index);
  }//end getRating
  
  /**
  * To string method BY: Samien
  * @raturn a String
  */
  public String toString() {
    return ratings.toString();
  }//end toString
  
}//end Ratings.java class