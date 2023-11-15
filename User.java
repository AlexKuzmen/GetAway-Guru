/*
  User.java
  The User class does operations that are related to an user. In other words, it models an user and holds the username, password, and rating as fields.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Alexander Kuzmenko, Samien Bell, Krish Patel
  Date Created: March 14, 2023
  Last Modified By: A K
  Date Modified: June 5, 2023
*/

//Import the util package
import java.util.*;

//Import the io package
import java.io.*;

//Import the lang package
import java.lang.*;

public class User { // Start of the User class

  // Allows user to input information at any method
  public static Scanner keyboard = new Scanner(System.in); // make a keyboard object of the scanner class

  private String username; // Username
  private String password; // Password
  // private Rating userRatings; // Their ratings

// ⭐Our public Constructors
  /**
   * Constructor that sets the default values passed as arguments. BY: Krish
   * @param name The user's username
   * @param pass The user's password
   */
  public User(String name, String pass) {
    username = name; // Set the username as the argument passed
    password = pass; // Set the password as the argument passed
  }

  /**
   * A copy constructor that sets the default values passed as the passed object's fields. BY: Krish
   * @param u The object passed
   */
  public User(User u) {
    username = u.username; // Set the username as the argument passed
    password = u.password; // Set the password as the argument passed
    // userRatings = u.userRatings; // Set the user's ratings as the arguments
    // passed
  }

  // ⭐Getters and setters
  /**
  * Getter Method BY: Krish
  * @return username Users username
  */
  public String getUsername() {
    return username;
  }//end getUsername

  /**
  * Getter Method BY: Krish
  * @return password Users password
  */
  public String getPassword() {
    return password;
  }//end getPassword
  
  // ⭐Public "instance" methods

  /**
   * The menu method. This method allows users to select an answer to a question. BY: Krish
   * @param question The question the user wants answered
   * @param bound1   The first of the two boundaries for a valid input
   * @param bound2   The second of the two boundaries for a valid input
   * @return userChoice The selection
   */
  public String menu(String question, int bound1, int bound2) {
    boolean validInput;
    String userChoice;
    char userLetter;
    do { // Run while there is an invalid input
      System.out.println(question);
      userChoice = keyboard.nextLine(); // Catch the user's input
      validInput = false;

      // Making sure they only entered one character
      if (userChoice.length() != 1) {
        validInput = true;
      }

      // Making sure the characteristic is valid
      for (int i = 0; i < userChoice.length(); i++) {
        userLetter = userChoice.charAt(i); // Check each character

        if (userLetter >= bound1 || userLetter <= bound2) { // Make sure the character is a number between 1 and 2
          validInput = true;
        }
      }
      if (validInput == true) {
        System.out.println("Please only enter one number from 1 to 7."); // If the character is not a number tell the
                                                                         // user
      }
    } while (validInput == true);

    return userChoice;
  }//end menu

  /**
   * This method takes in seven options and returns the desired one. BY: Krish
   * @param decider The number in string form we are checking for
   * @param one     The first option
   * @param two     The second option
   * @param three   The third option
   * @param four    The fourth option
   * @param five    The fifth option
   * @param six     The sixth option
   * @param seven   The seventh option
   * @return result The string that had the match
   */
  public String menuResult(String decider, String one, String two, String three, String four, String five, String six, String seven) {

    String result = "null"; // The method requires a return

    if (decider.equalsIgnoreCase("1")) {
      result = new String(one); // They chose this option
    } else if (decider.equalsIgnoreCase("2")) {
      result = new String(two); // They chose this option
    } else if (decider.equalsIgnoreCase("3")) {
      result = new String(three); // They chose this option
    } else if (decider.equalsIgnoreCase("4")) {
      result = new String(four); // They chose this option
    } else if (decider.equalsIgnoreCase("5")) {
      result = new String(five); // They chose this option
    } else if (decider.equalsIgnoreCase("6")) {
      result = new String(six); // They chose this option
    } else if (decider.equalsIgnoreCase("7")) {
      result = new String(seven); // They chose this option
    }
    return result; // Return their choice
  }//end menuResult

  /**
   * This method signs a user up. BY: Krish
   */
  public void signUp() throws IOException {

    // Make their csv file
    FileWriter fileWriter = new FileWriter("users file/" + username + ".csv");
    BufferedWriter outputFile = new BufferedWriter(fileWriter);

    // Add their preferences as the first line seperated by commas
    System.out.print("\nCity of residence: ");
    String city = keyboard.nextLine(); // Catch their input

    System.out.print("\nCountry of residence: ");
    String country = keyboard.nextLine(); // Catch their input

    // Get their continent
    String continent;
    String continentSelector = menu(
        "\nContinent of residence:\n1) Asia\n2) Africa\n3) North America\n4) South America\n5) Antartica\n6) Europe\n7) Australia",
        56, 48); // They chose a number
    continent = menuResult(continentSelector, "Asia", "Africa", "North America", "South America", "Antartica", "Europe",
        "Australia"); // Match the number to the string

    // Get their language
    String language;
    String languageSelector = menu(
        "\nPrimary language:\n1) English\n2) French\n3) German\n4) Spanish\n5) Standard Mandarin\n6) Hindi\n7) Other",
        56, 48); // They chose a number
    language = menuResult(languageSelector, "English", "French", "German", "Spanish", "Standard Mandarin", "Hindi",
        "Other"); // Match the number to the string

    // Get their climate
    String climate;
    String climateSelector = menu(
        "\nIdeal climate:\n1) Very Cold\n2) Cold\n3) Cool\n4) Moderate\n5) Warm\n6) Hot\n7) Very Hot", 56, 48); 
    climate = menuResult(climateSelector, "Very Cold", "Cold", "Cool", "Moderate", "Warm", "Hot", "Very Hot");

    // Get their price point
    String price;
    String priceSelector = menu(
        "\nPrice range (CAD):\n1) 50 - 100\n2) 101 - 150\n3) 151 - 650\n4) 651 - 1200\n5) 1201 - 2000\n6) 2001 - 5000\n7) 5001+",
        56, 48); // They chose a number
    price = menuResult(priceSelector, "50 - 100", "101 - 150", "151 - 650", "651 - 1200", "1201 - 2000", "2001 - 5000",
        "5001+"); // Match the number to the string

    outputFile.write(city + "," + country + "," + continent + "," + language + "," + climate + "," + price); 

    // Close the file
    outputFile.close();

    // Add their names to the username textfile
    FileWriter fw2 = new FileWriter("Usernames.txt", true);
    PrintWriter outputFile2 = new PrintWriter(fw2);

    outputFile2.println(username);

    // Close the file
    outputFile2.close();

    // Add their names to the password textfile
    FileWriter fw3 = new FileWriter("Passwords.txt", true);
    PrintWriter outputFile3 = new PrintWriter(fw3);

    outputFile3.println(password);

    // Close the file
    outputFile3.close();
  }//end signUp

  /**
   * This method checks whether or not a username/password combination is valid. BY: Krish
   * @return Whether or not the combination is valid
   */
  public boolean validLogin() throws IOException {
    // Open the files and arrays
    File file1 = new File("Passwords.txt");
    Scanner inputFile1 = new Scanner(file1);

    File file2 = new File("Usernames.txt");
    Scanner inputFile2 = new Scanner(file2);

    // See how many lines are in the text file
    int numberOfUsers = 0; // Count the number of users
    while (inputFile2.hasNextLine()) {
      inputFile2.nextLine();
      numberOfUsers++;
    }

    // Close the file
    inputFile2.close();
    // Reset scanner to the top
    inputFile2 = new Scanner(file2);

    // Make and fill in the arrays with data from text files. We know both arrays
    // need to be the same size
    String[] passwordsArray = new String[numberOfUsers];
    String[] usernamesArray = new String[numberOfUsers];

    for (int i = 0; i < numberOfUsers; i++) { // We know that the usernames and passwords must line up
      passwordsArray[i] = inputFile1.nextLine();
      usernamesArray[i] = inputFile2.nextLine();
    }
    // close files
    inputFile1.close();
    inputFile2.close();

    // Compare the user's input to the usernames and passwords then see if they
    // input is valid
    boolean validCombo = false;

    for (int i = 0; i < numberOfUsers; i++) {
      if (username.equals(usernamesArray[i])) {
        if (password.equals(passwordsArray[i])) {
          validCombo = true;
        }
      }
    }

    return validCombo;
  }//end validLogin

  /**
   * This method checks whether or not a user is an admin. BY: Krish
   * @return isValid Whether or not the user is an admin
   */
  public boolean isAdmin() throws IOException {
    boolean admin = false; // A boolean that is used to see if an admin logs in

    if (username.equals("admin") && password.equals("adminPassword123@yuh.ca")) { // The admin logged in
      admin = true;
    }
    return admin;
  }//end isAdmin

  /**
   * This method checks whether or not a user is an admin. BY: Krish
   * @return isValid Whether or not the user is an admin
   */
  public boolean isAdminV2(){
    boolean admin = false; // A boolean that is used to see if an admin logs in

    if (username.equals("admin") && password.equals("adminPassword123@yuh.ca")) { // The admin logged in
      admin = true;
    }
    return admin;
  }//end isAdminV2

  /**
  * This method checks wether or not the password is valid. BY: Nicholas
  * @return isValid Wether or not the password is valid
  */
  public static boolean isValidPassword(String userPassword) {
    // userinput variable
    String validPassword = new String(userPassword);
    String[] passwordArray = new String[userPassword.length()];
    boolean isValid = true;
    // checking variables
    char passwordChar;
    int howManyNumbers = 0;
    int howManySpecial = 0;
    int howManyCapital = 0;
    int howManySpace = 0;
    int howManyLetter = userPassword.length();

    for (int i = 0; i < passwordArray.length; i++) {
      //converting into a singla character 
      passwordChar = userPassword.charAt(i);

      //checking if its a special character
      if (passwordChar >= 33 && passwordChar <= 47 || passwordChar >= 58 && passwordChar <= 64
          || passwordChar >= 91 && passwordChar <= 96 || passwordChar >= 123 && passwordChar <= 126) {
        howManySpecial++;
        continue;
      }
      //checking if its a upper case character
      if (Character.isUpperCase(passwordChar)) {
        howManyCapital++;
        continue;
      }
      //checking if its a digit character
      if (Character.isDigit(passwordChar)) {
        howManyNumbers++;
        continue;
      }
      //checking if its a white space character
      if (Character.isWhitespace(passwordChar)) {
        howManySpace++;
        continue;
      }

    }
    // checking if the password password a passes all the requirements 
    if (howManyCapital == 0 || howManySpace > 0 || howManySpecial == 0 || howManyNumbers == 0 || howManyLetter < 8) {
      isValid = false;
    }

    return isValid; // true means good password, false means bad

  }//end isValidPassword

  /**
  * This method checks wether or not the username is valid. BY: Nicholas
  * @return validUsername Wether or not the username is valid
  */
  public boolean isValidUsername(String userUsername) throws IOException {
    String validUsername = userUsername;

    File file2 = new File("Usernames.txt");
    Scanner inputFile2 = new Scanner(file2);
    // See how many lines are in the text file
    int numberOfUsers = 0; // Count the number of users
    while (inputFile2.hasNextLine()) {
      inputFile2.nextLine();
      numberOfUsers++;
    }
    // Close the file
    inputFile2.close();
    // Reset scanner to the top
    inputFile2 = new Scanner(file2);

    // Make and fill in the arrays with data from text files. We know both arrays
    // need to be the same size
    String[] usernamesArray = new String[numberOfUsers];

    for (int i = 0; i < numberOfUsers; i++) { // We know that the usernames and passwords must line up
      usernamesArray[i] = inputFile2.nextLine();
    }
    
    // close files
    inputFile2.close();

    boolean valid = true;

    for (int i = 0; i < usernamesArray.length; i++) {
      if (usernamesArray[i].equals(validUsername)) {
        valid = false;
      }
    }

    return valid;
  }//end isValidUsername

  /* 
   * Method that allows the user to rate a location. BY: Nicholas
   * @param chosen This string is the location to be rated
   */
  public void rateDestination(Destination chosen, int ratedIn) throws IOException {
    int rated = ratedIn;
    int userRating = 0;
    Destination copyChosen = new Destination(chosen);
    String location = copyChosen.getCity();
    
    userRating = editedUserFile(location, rated);
    editedAllFile(location, rated, userRating);

  }

  /**
   * Method that writes and checks file BY: Nicholas
   * @param location This string is the location rated
   * @param rated This int is the user's rating
   * @param userRating the user's int rating
   */
  public void editedAllFile(String location, int rated, int userRating) throws IOException {
    // This is all the files variables
    String tempFile = "csv files/temp.csv";
    String filePath = "csv files/AllRatings.csv";
    File newFile = new File(tempFile);
    File oldFile = new File(filePath);
    // these are the strings that holds the scanner values
    String locationFile = "";
    String ratingFile = "";
    String usernameFile = "";
    boolean found = false;
    int user = userRating;

    try {
      
      FileWriter fw = new FileWriter(tempFile, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      //creating the index for the scanner
      Scanner x = new Scanner(new File(filePath));
      x.useDelimiter("[,\n]");

      while (x.hasNext()) {

        //setting the file infomation to a variable
        locationFile = x.next();
        ratingFile = x.next();

        //checking if location in the file is the one we are looking for
        if (locationFile.equalsIgnoreCase(location) && !found && user > 0 && user == Integer.parseInt(ratingFile)) {
          found = true;
          pw.println(locationFile + "," + rated);
        } else {
          pw.println(locationFile + "," + ratingFile);
        }

      }
      if (!found) {
        pw.println(location + "," + rated);
      }

      //cleaning up the no longer used things
      x.close();
      pw.flush();
      pw.close();
      oldFile.delete();

      //finishing the file transfer
      File dump = new File(filePath);
      newFile.renameTo(dump);

    } catch (Exception e) {
      System.out.println("ERROR with editedAllFile method");
    }
  
  }//end editedAllFiles

  /**
   * Method that writes and checks file BY: Nicholas
   * @param location This string is the location rated
   * @param rated This int is the user's rating
   * @return userRated This int is the user's rating from the file  
   */
  public int editedUserFile(String location, int rated) throws IOException {
    // This is all the files variables
    String tempFile = "users file/temp.csv";
    String filePath = "users file/" + username + ".csv";
    File newFile = new File(tempFile);
    File oldFile = new File(filePath);
    // these are the strings that holds the scanner values
    String locationFile = "";
    String ratingFile = "";
    String header = "";
    
    boolean found = false;
    int userRated = -1;
    try {

      FileWriter fw = new FileWriter(tempFile, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      Scanner x = new Scanner(new File(filePath));
      x.useDelimiter("[,\n]");
      
      //This for loop to save and bypass the header 
      for (int i = 1; i <= 6; i++) {

        if (i == 1) {
          header = x.next() + ",";
        } else if (i == 6) {
          header = header + x.next();
        } else {
          header = header + x.next() + ",";
        }
      }
      pw.println(header);

      
      while (x.hasNext()) {

        locationFile = x.next();
        ratingFile = x.next();
        
        //checking if its the location in the file we are after, if so also get the rating too
        if (locationFile.equalsIgnoreCase(location)) {
          found = true;
          userRated = Integer.parseInt(ratingFile);
          pw.println(locationFile + "," + rated);
        } else {
          pw.println(locationFile + "," + ratingFile);
        }

      }
      if (!found) {
        pw.println(location + "," + rated);
        userRated = -1;
      }

      //cleaning up the no longer used things
      x.close();
      pw.flush();
      pw.close();
      oldFile.delete();

      File dump = new File(filePath);
      newFile.renameTo(dump);
      
      return userRated; // the users rating and its -1 if it hasn't been rated
      
    } catch (Exception e) {
      System.out.println("ERROR with editedUserFile method");
      return -1;
    }

  }//end editedUserFile

  /**
  *  Method that returns a Ratings obejct of user's ratings BY: Alexander
  *  @return r The Ratings object
  */
  public Ratings userRatings() throws IOException{
  
    File uF = new File("users file/" + username + ".csv");
    Scanner userF = new Scanner(uF);
  
    Ratings r = new Ratings();
  
    
    userF.nextLine();
    
    while(userF.hasNext()){
      String[] tempArray = userF.nextLine().split(",");
      r.addRating(Integer.parseInt(tempArray[1]));
    }
  
    userF.close();
    return r;
  
  }//end userRatings

  /**
  *  Method that returns an arraylist of destination names BY: Alexander
  *  @return a the arraylist of strings
  */
  public ArrayList<String> userCities() throws IOException{
    
    File uF = new File("users file/" + username + ".csv");
    Scanner userF = new Scanner(uF);
  
    ArrayList<String> a = new ArrayList<String>();
  
    userF.nextLine();
    
    while(userF.hasNext()){
      String[] tempArray = userF.nextLine().split(",");
      a.add(tempArray[0]);
    }
  
    userF.close();
    return a;
    
  }//end userCities

/**
*   Method that prints out user file BY: Alexander
*/
  public void printUser() throws IOException{

    Ratings r = userRatings();
    ArrayList<String> a = userCities();

    
    for(int i = 0; i < a.size(); i++){

      System.out.println(a.get(i) + ": " + r.getRating(i));
      
    }
    
  }//end printUser

  /**
   * This method generates an array of the top ten locations best suited for the user, determined based on their previous ratings By: Samien
   * @return an array of best fitted Destination objects
  */
  public Destination[] destRecs() throws IOException {
    
    Destination[] topTen = new Destination[10];
    Destination[] allDests = Destination.arrayDest();
    boolean onlyOneRating = false;
    int onlyRating = 0;


    //⭐Read in previous ratings from the user's file
    File userFile = new File("users file/" + username + ".csv");
    Scanner inputUser = new Scanner(userFile);

    int prevRatings = -1; //-1 because it must disregard the first line in the file
    while (inputUser.hasNext()) {
      inputUser.nextLine();
      prevRatings++;
    }
    inputUser.close();


    //return an array containing 10 of the highest rated destinations if they have never rated any destinations previously
    if (prevRatings == 0) {
      Destination []sortedDests = Destination.topDests(allDests, allDests.length);
      Random rand = new Random();
      int addedCounter = 0;

      for (int i = 0; i < sortedDests.length; i++) {
        if (rand.nextInt(5) > 0) {
          topTen[addedCounter] = new Destination(sortedDests[i]);
          addedCounter++;
        }
        if (addedCounter == 10) {
          break;
        }
      }
      
      return topTen;
    }      
    else {
      //if they only have one rating, store that rating for later use
      if (prevRatings == 1) {
        onlyOneRating = true;
        inputUser = new Scanner(userFile);
        inputUser.nextLine();
        
        String[] currentLine = inputUser.nextLine().split(",");
        onlyRating = Integer.parseInt(currentLine[1]);
      }
      
      inputUser = new Scanner(userFile);
      inputUser.nextLine();
      
      Destination currentDest = new Destination();
      int currentRat = 0;
      
      Ratings[] continentRatings = new Ratings[7];
      Ratings[] climateRatings = new Ratings[7];
      Ratings[] languageRatings = new Ratings[6];
      Ratings[] costRatings = new Ratings[7];
  
      for (int i = 0; i < 7; i++) {
        continentRatings[i] = new Ratings();
        climateRatings[i] = new Ratings();
        costRatings[i] = new Ratings();
        if (i < 6) {
          languageRatings[i] = new Ratings();
        }
      }

  
      //for loop that goes through all of the user's previous ratings
      for (int i = 0; i < prevRatings; i++) {
        
        String[] currentLine = inputUser.nextLine().split(",");
        currentDest = Destination.toDest(currentLine[0]);
        currentRat = Integer.parseInt(currentLine[1]);
        
        //add current destination's rating to the correspoding continent Ratings object
        switch (currentDest.getContinent()) {
          case "Asia":
            continentRatings[0].addRating(currentRat);
            break;
          case "Africa":
            continentRatings[1].addRating(currentRat);
            break;
          case "Europe":
            continentRatings[2].addRating(currentRat);
            break;
          case "North America":
            continentRatings[3].addRating(currentRat);
            break;
          case "South America":
            continentRatings[4].addRating(currentRat);
            break;
          case "Australia":
            continentRatings[5].addRating(currentRat);
            break;
          case "Antarctica":
            continentRatings[6].addRating(currentRat);
            break;
          default:
            throw new IllegalArgumentException("Continent " + currentDest.getContinent() + " does not exist");
        }
  
        //add current destination's rating to the correspoding climate Ratings object
        switch (currentDest.getClimate()) {
          case "Very Cold":
            climateRatings[0].addRating(currentRat);
            break;
          case "Cold":
            climateRatings[1].addRating(currentRat);
            break;
          case "Cool":
            climateRatings[2].addRating(currentRat);
            break;
          case "Moderate":
            climateRatings[3].addRating(currentRat);
            break;
          case "Warm":
            climateRatings[4].addRating(currentRat);
            break;
          case "Hot":
            climateRatings[5].addRating(currentRat);
            break;
          case "Very Hot":
            climateRatings[6].addRating(currentRat);
            break;
          default:
            throw new IllegalArgumentException("Continent " + currentDest.getContinent() + " does not exist");
        }
        
        //add current destination's rating to the correspoding language Ratings object
        switch (currentDest.getLanguage()) {
          case "English":
            languageRatings[0].addRating(currentRat);
            break;
          case "French":
            languageRatings[1].addRating(currentRat);
            break;
          case "Spanish":
            languageRatings[2].addRating(currentRat);
            break;
          case "German":
            languageRatings[3].addRating(currentRat);
            break;
          case "Mandarin":
            languageRatings[4].addRating(currentRat);
            break;
          case "Arabic":
            languageRatings[5].addRating(currentRat);
            break;
          default:
            
        }
  
  
        //add current destination's rating to the correspoding cost Ratings object
        if (currentDest.getCostLower() == 50.0) {
          costRatings[0].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 101.0) {
          costRatings[1].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 151.0) {
          costRatings[2].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 651.0) {
          costRatings[3].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 1201.0) {
          costRatings[4].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 2001.0) {
          costRatings[5].addRating(currentRat);
        }
        else if (currentDest.getCostLower() == 5001.0) {
          costRatings[6].addRating(currentRat);
        }
        else {
          throw new IllegalArgumentException("Lower Cost " + currentDest.getCostLower() + " does not exist");
        }
        
      }
      inputUser.close();
      
  
      //⭐Determine the user's preferences
      String preferCont, worstCont;
      String preferLang, worstLang;
      int preferClim;
      int preferCost;
  
      double[] continentAverages = new double[7];
      double[] climateAverages = new double[7];
      double[] languageAverages = new double[6];
      double[] costAverages = new double[7];
  
  
      //fill average arrays
      for (int j = 0; j < 7; j++) {
        continentAverages[j] = continentRatings[j].getAverage();
        climateAverages[j] = climateRatings[j].getAverage();
        costAverages[j] = costRatings[j].getAverage();
        if (j < 6) {
          languageAverages[j] = languageRatings[j].getAverage();
        }
      }
  
      double contMax = 0, contMin = 10, langMax = 0, langMin = 10, climMax = 0, costMax = 0;
  
      for (int k = 0; k < 7; k++) {
        if (continentAverages[k] > contMax) {
          contMax = continentAverages[k];
        }
        if (continentAverages[k] < contMin && continentAverages[k] > 0) {
          contMin = continentAverages[k];
        }
        if (climateAverages[k] > climMax) {
          climMax = climateAverages[k];
        }
        if (costAverages[k] > costMax) {
          costMax = costAverages[k];
        }
        if (k < 6) {
          if (languageAverages[k] > langMax) {
            langMax = languageAverages[k];
          }
          if (languageAverages[k] < langMin && languageAverages[k] > 0) {
            langMin = languageAverages[k];
          }
        }
      }
  
      //linear search to find indexes of maxes and mins
      int contMaxIndex = 0, contMinIndex = 0, langMaxIndex = 0, langMinIndex = 0, climMaxIndex = 0, costMaxIndex = 0;
      
      for (int h = 0; h < 7; h++) {
        if (continentAverages[h] == contMax) {
          contMaxIndex = h;
        }
        if (continentAverages[h] == contMin) {
          contMinIndex = h;
        }
        if (climateAverages[h] == climMax) {
          climMaxIndex = h;
        }
        if (costAverages[h] == costMax) {
          costMaxIndex = h;
        }
        if (h < 6) {
          if (languageAverages[h] == langMax) {
            langMaxIndex = h;
          }
          if (languageAverages[h] == langMin) {
            langMinIndex = h;
          }
        }
      }
  
      //assign values to the "prefer" and "worst" variables
      String[] continents = {"Asia", "Africa", "Europe", "North America", "South America", "Australia", "Antarctica"};
      String[] languages = {"English", "French", "Spanish", "German", "Mandarin", "Arabic"};
      String[] climates = {"Very Cold", "Cold", "Cool", "Moderate", "Warm", "Hot", "Very Hot"};
      double[] costs = {50.0, 101.0, 151.0, 651.0, 1201.0, 2001.0, 5001.0};
  
      preferCont = continents[contMaxIndex];
      worstCont = continents[contMinIndex];
      preferLang = languages[langMaxIndex];
      worstLang = languages[langMinIndex];
      preferClim = climMaxIndex;
      preferCost = costMaxIndex;
  
      if (langMax == 0) {
        preferLang = null;
        worstLang = null;
      }


      //⭐Determine top 10 locations that fit the user's preferences
      HashMap<String, Integer> destScores = new HashMap<>();
      LinkedHashMap<String, Integer> destScoresSorted = new LinkedHashMap<>();
      ArrayList<Integer> list = new ArrayList<>();
      Random rand = new Random();

      int currentScore;
      int climateIndex = 0, costIndex = 0;
      
      for (int i = 0; i < allDests.length; i++) {

        currentScore = rand.nextInt(5) + rand.nextInt(5);
        
        for (int j = 0; j < 7; j++) {
            if (climates[j].equals(allDests[i].getClimate())) {
              climateIndex = j;
            }
            if (costs[j] == allDests[i].getCostLower()) {
              costIndex = j;
            }
          }

        if (onlyOneRating) {
          
          if (allDests[i].getContinent().equals(preferCont)) {
            currentScore = currentScore - 6;
            currentScore = currentScore + onlyRating;
          }
          if (allDests[i].getLanguage().equals(preferLang)) {
            currentScore = currentScore - 3;
            currentScore = currentScore + onlyRating/2;
          }
          if (onlyRating < 4) {
            currentScore = currentScore + Math.abs(preferClim - climateIndex);
            currentScore = currentScore + Math.abs(preferCost - costIndex);
          }
          else if (onlyRating > 6) {
            currentScore = currentScore - Math.abs(preferClim - climateIndex);
            currentScore = currentScore - Math.abs(preferCost - costIndex);
          }
        }
        else {
          
          if (allDests[i].getContinent().equals(preferCont)) {
            currentScore = currentScore + 4;
          }
          if (allDests[i].getContinent().equals(worstCont)) {
            currentScore = currentScore - 4;
          }
          if (allDests[i].getLanguage().equals(preferLang)) {
            currentScore = currentScore + 2;
          }
          if (allDests[i].getLanguage().equals(worstLang)) {
            currentScore = currentScore - 2;
          }
  
          currentScore = currentScore - Math.abs(preferClim - climateIndex);
          currentScore = currentScore - Math.abs(preferCost - costIndex);
        }
        
        if (allDests[i].getRatings().getAverage() == 0) {
          currentScore = currentScore + 5;
        } else {
          currentScore = currentScore + (int)Math.round(allDests[i].getRatings().getAverage());
        }

        //add the destination and its score to the HashMap
        destScores.put(allDests[i].getCity(), currentScore);
      }
      
      for (Map.Entry<String, Integer> entry : destScores.entrySet()) {
        list.add(entry.getValue());
      }
      Collections.sort(list); 
      for (int num : list) {
        for (Map.Entry<String, Integer> entry : destScores.entrySet()) {
          if (entry.getValue().equals(num)) {
            destScoresSorted.put(entry.getKey(), num);
          }
        }
      }
      
      int destsAdded = 0;
      boolean alreadyBeen;
      String[] sortedCities = destScoresSorted.keySet().toArray(new String[0]);
      
      for (int i = 0; i < sortedCities.length; i++) {
        
        alreadyBeen = false;
        inputUser = new Scanner(userFile);
        inputUser.nextLine();
        
        while (inputUser.hasNext()) {
          String[] currentLine = inputUser.nextLine().split(",");
          if (currentLine[0].equals(sortedCities[sortedCities.length - 1 - i])) {
            alreadyBeen = true;
          }
        }
        
        
        if (alreadyBeen) {
          continue;
        }
        
        topTen[destsAdded] = new Destination(Destination.toDest(sortedCities[sortedCities.length - 1 - i]));
        destsAdded++;
        if (destsAdded == 10) {
          break;
        }
      }

      return topTen;
    }
    
  }//end destRecs method
  
  /**
   * This method generates an arraylist of all of your friend friends By: Nicholas
   * @return friendFriends ArrayList of friends
  */
  public ArrayList<String> friendFriends(String friend) throws IOException{

    User tempUser = new User(friend, null);
    ArrayList<String> friendFriends = tempUser.listFriend();

      return friendFriends;
  
}

   /**
   * This method gets your friends rating object holding all of their ratings By: Nicholas
   * @return friendRating Ratings objects of friends rating
  */
  public Ratings friendRating(String friend) throws IOException{

    User tempUser = new User(friend, null);
      return tempUser.userRatings();
  
}



  
/**
  * This method generates an arraylist of one of your friends By: Nicholas
  * @return list ArrayList of friends
  */
public ArrayList<String> listFriend() throws IOException{
String myName = username;
String head;
String tail;
  
  String filePath = "csv files/Friends.csv";
  File friends = new File(filePath);
  Scanner x = new Scanner(new File(filePath));
  x.useDelimiter("[,\n]");
  
ArrayList<String> list = new ArrayList<String>();
  x.next();
  x.next();
  
  while (x.hasNext()) {
            head = x.next();
            tail = x.next();
        if(head.equals(username)){
              list.add(tail);
        }
  }
 

  if(list.isEmpty()){
    //maybe do something special list.add("You have 0 friends");
    return list;
  }
  else{
   return list;
  }

}

/**
  * This method adds one of the users to your friends list By: Nicholas
  * @param addingFriend This String is the friend your adding
  */
public void addFriend(String addingFriend) throws IOException{
 
    String userAddingFriend = addingFriend;
    //This is all the files variables 
    boolean found = false;
    String tempFile = "csv files/tempFriends.csv";
    String filePath = "csv files/Friends.csv";
    File newFile = new File(tempFile);
    File oldFile = new File(filePath);
    //these are the strings that holds the scanner values
    String head = "";
    String tail = "";
  
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        Scanner x = new Scanner(new File(filePath));
        x.useDelimiter("[,\n]");
        x.next();
        x.next();
        pw.println("follower,followed");
        
        while (x.hasNext()) {

            head = x.next();
            tail = x.next();
            
            if (head.equalsIgnoreCase(username) &&  tail.equalsIgnoreCase(userAddingFriend) && !found) {
                found = true;
                pw.println(head + "," + tail);
            } else {
                pw.println(head + "," + tail);
            }

        }
        if(!found){
        pw.println(username + "," + userAddingFriend);}
        
        x.close();
        pw.flush();
        pw.close();
        oldFile.delete();
        
        File dump = new File(filePath);
        newFile.renameTo(dump);
      
}
/**
  * This method removes one of your friends By: Nicholas
  * @param removingFriend This String is the friend your removing
  */
public void removeFriend(String removingFriend) throws IOException{

    String userAddingFriend = removingFriend;
    //This is all the files variables 
    boolean found = false;
    String tempFile = "csv files/tempFriends.csv";
    String filePath = "csv files/Friends.csv";
    File newFile = new File(tempFile);
    File oldFile = new File(filePath);
    //these are the strings that holds the scanner values
    String head = "";
    String tail = "";
  
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        Scanner x = new Scanner(new File(filePath));
        x.useDelimiter("[,\n]");
        x.next();
        x.next();
        pw.println("follower,followed");
        
        while (x.hasNext()) {

            head = x.next();
            tail = x.next();
            
            if (head.equalsIgnoreCase(username) &&  tail.equalsIgnoreCase(userAddingFriend)) {
                
            } else {
                pw.println(head + "," + tail);
            }

        }
      
        x.close();
        pw.flush();
        pw.close();
        oldFile.delete();
        
        File dump = new File(filePath);
        newFile.renameTo(dump);
  
}  

} // End of User class