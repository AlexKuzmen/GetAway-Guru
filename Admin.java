/*
  Admin.java
  The Admin class does operations that are related to an admin. In other words, it models the abilities of an admin.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: March 14, 2023
  Last Modified By: Krish Patel
  Date Modified: April 1, 2023
*/

//Import the util package
import java.util.*;

//Import the io package
import java.io.*;

public class Admin extends User { // Start of the admin class

  //Allows user to input information at any method
  public static Scanner keyboard = new Scanner(System.in); //make a keyboard object of the scanner class

  //⭐Our public Constructors
  /**
    Constructor that sets the default values as the correct fields. BY: Krish
  */
  public Admin() {
		super("admin", "adminPassword123@yuh.ca");
	}
  
  //⭐Public instance methods
  /**
    This method adds a user via signup. By: Krish
  */
  public void addUser() throws IOException{
    //Ask the admin if they want to sign somebody up
    boolean validInput;
    String userChoice;
    char userLetter;
    do{ // Run while there are invalid inputs
      System.out.println("Would you like to sign somebody up?\n\n1) Sign-up\n2) No");
      userChoice = keyboard.nextLine(); // Catch the user's input
      validInput = false;

      //Making sure they only entered one character
      if(userChoice.length() != 1){
        validInput = true;
      }

      //Making sure the characteristic is valid
      for(int i = 0; i<userChoice.length(); i++){
        userLetter = userChoice.charAt(i); // Check each character
          
        if(userLetter >= 51 || userLetter <= 48){ //Make sure the character is a number between 1 and 2
          validInput = true;
        }
      }
      if(validInput == true){
        System.out.println("Please only enter one number from 1 to 2."); // If the character is not a number tell the user
      }
    }while(validInput == true);

    if(userChoice.equalsIgnoreCase("1")){ // The admin wants to sign someone up
      //Get the user's username
      System.out.print("Please enter the username: ");
      String username = keyboard.nextLine();
      
      //Get the user's password
      System.out.print("Please enter the password: ");
      String password = keyboard.nextLine();

      //⭐Make user object
      User theUser = new User(username, password);
      theUser.signUp(); // Call the signup method
    }
  }

  /**
    This method displays the program's statistics. By: Krish
  */
  public void displayStats() throws IOException{
    //The number of lines in the Usernames.txt file
    File file2 = new File("Usernames.txt");
    Scanner inputFile2 = new Scanner(file2);
    
    //Count how many lines are in the usernames file
    int numOfUsernames = 0; // Count how many users there are
    while (inputFile2.hasNextLine()){
      inputFile2.nextLine();
      numOfUsernames++;
    }
    inputFile2.close();

    //Find the number of lines in the destinations file
    File file3 = new File("csv files/Destinations.csv");
    Scanner inputFile3 = new Scanner(file3);
    
    //Count how many lines are in the destinations file
    int numDestinations = 0; // Count how many destinations there are
    while (inputFile3.hasNextLine()){
      inputFile3.nextLine();
      numDestinations++;
    }
    inputFile3.close(); 

    //Ask the admin if they want to see the overall program statistics.
    boolean validInput;
    String userChoice;
    char userLetter;
    do{ // Run while invalid input
      System.out.println("Would you like to see the program's statistics?\n\n1) Yes\n2) No");
      userChoice = keyboard.nextLine(); // Catch the user's input
      validInput = false;

      //Making sure they only entered one character
      if(userChoice.length() != 1){
        validInput = true;
      }

      //Making sure the characteristic is valid
      for(int i = 0; i<userChoice.length(); i++){
        userLetter = userChoice.charAt(i); // Check each character
          
        if(userLetter >= 51 || userLetter <= 48){ //Make sure the character is a number between 1 and 2
          validInput = true;
        }
      }
      if(validInput == true){
        System.out.println("Please only enter one number from 1 to 2."); // If the character is not a number tell the user
      }
    }while(validInput == true);

    if(userChoice.equalsIgnoreCase("1")){
      //Tell the admin the number of users
      System.out.println("There are "+numOfUsernames+" users.");
      //Tell them the number of locations
      System.out.println("There are "+numDestinations+" destinations.");
    }
  }

  /**
    This method displays the program's statistics(the number of users). By: Krish
    @return numOfUsernames this int is the number of users
  */
  public int getNumUsers(){
    File file2;
    Scanner inputFile2;
    int numOfUsernames = 0;
    
    try{
      //The number of lines in the Usernames.txt file
      file2 = new File("Usernames.txt");
      inputFile2 = new Scanner(file2);
    
      //Count how many lines are in the usernames file
      numOfUsernames = 0; // Count how many users there are
      while (inputFile2.hasNextLine()){
        inputFile2.nextLine();
        numOfUsernames++;
      }
      inputFile2.close();
    }
    catch (IOException e){
      System.out.println("Error");
    }

    //Tell the admin the number of users
    return numOfUsernames;
  }

  /**
  * This method displays the program's statistics(the number of locations). By: Krish
  * @return numDestinations this int is the number of locations
  */
  public int getLocationsNum(){
    File file3;
    Scanner inputFile3;
    int numDestinations = 0;

    try{
      //Find the number of lines in the destinations file
      file3 = new File("csv files/Destinations.csv");
      inputFile3 = new Scanner(file3);
    
      //Count how many lines are in the destinations file
      numDestinations = 0; // Count how many destinations there are
      while (inputFile3.hasNextLine()){
        inputFile3.nextLine();
        numDestinations++;
      }
      inputFile3.close(); 

    }
    catch(IOException e){
      System.out.println("Error");
    }

    //Tell them the number of locations
    return numDestinations;
  }









  /**
    This method displays the program's statistics(the number of locations). By: Nicholas
  */
  public void getGuruShips(){



    
  }







} // End of Admin class