/* 
* Name : Cynthia Lei & Daiphy Lee
* Date : April 6, 2021
* Teacher : Mr. Ho
* Description : LuhnAssignment
* */

import java.util.Scanner; // import scanner class
import java.io.BufferedReader; // import buffer reader class (because scanner likes to skip lines)
import java.io.FileReader; // import class to read files
import java.io.IOException; // import class to handle exceptions

import java.io.File; // import file class
import java.io.PrintWriter; // import class to extend writer 

import java.io.*; // for generating the data file (reading, writing data)

import java.sql.Timestamp; // timestamp class to generate exact time

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        String fileStorage = "";

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                fileStorage = enterCustomerInfo(reader, fileStorage); 
                // after each run of inputting customer info, each customer's info is stored
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile(fileStorage, reader);
                fileStorage = ""; // refresh so that if the user inputs one customer and just keeps on generating a datafile,
                // this will prevent the file from duplicating that customer's data
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    
    /**
     * @author Daiphy Lee
     * Enter customer information
     * 
     * @param reader scanner for user input; saves the hassle of reinitializing
     * @return the user's inputted first name, last name, city, postal code, credit card
     */
    public static String enterCustomerInfo(Scanner reader, String storage) {
        System.out.println("\nEnter the customer info method");

        // prompt reader to enter first name, last name, city, postal code, and credit card num

        System.out.print("Enter your first name: ");
        String firstName = reader.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = reader.nextLine();
        
        System.out.print("Enter your city: ");
        String city = reader.nextLine();

        System.out.print("Enter your postal code: ");
        String postalCode = reader.nextLine();

        // while loop to ensure user enters a 3 character and valid postal code (call on vpc method)
        while ( (postalCode.length() < 3) || (validatePostalCode(postalCode) != true) ) {
            if (postalCode.length() < 3) {
                System.out.println("Please enter AT LEAST 3 characters");
            }
            if (validatePostalCode(postalCode) != true) {
                System.out.println("Please enter a VALID postal code");
            }
            // cond if not valid or 3 characters - then they can redo
            postalCode = reader.nextLine();
        }
        // call on the changeCase method to change the postal code to uppercase so "l3s" is equivalent to "L3S"
        postalCode = changeCase(postalCode);

        // Credit card input
        System.out.print("Enter a valid credit card number: ");
        String creditCardNum = reader.nextLine();
        // Checks to see if the inputted credit card number is valid or not
        // If invalid, it will force user to reinput
        while ( (creditCardNum.length() < 9) 
            || (isStringAllNum(creditCardNum) != true) 
            || (validateCreditCard(creditCardNum) != true)
            ) {
            // credit card number not at least 9 digits
            if (creditCardNum.length() < 9) {
                System.out.println("Please enter AT LEAST 9 digits");
            }
            // credit card number does not contain all numbers
            if (isStringAllNum(creditCardNum) != true) {
                System.out.println("Please enter ONLY NUMBERS (no spaces, hypens)");
            }
            // credit card number fails the luhn algorithm/test
            if (validateCreditCard(creditCardNum) != true) {
                System.out.println("Please enter a VALID credit number");
            }
            creditCardNum = reader.nextLine(); // reinput
        }
  
        // this stores each customer's inputted file 
        // this adds on so the user can input multiple customers' info before generating a data file
        storage += "1"+getTimestamp() + "," + firstName + "," + lastName + "," + city + "," + postalCode + "," + creditCardNum + "\n"; 
        return storage;
    }
    /**
     * @author Daiphy Lee
     * Description : Open & reads postal_codes.csv file and identifies if the postal code entered matchs with postal codes on file
     * 
     * @param postalCode - 3 character code the user enters
     * @return true - 3 character code the user enters is a valid postal code on the list provided
     * @return false - the postal code inputted is less than 3 characters long OR if postal code is not part of the list provided
     */
    public static boolean validatePostalCode(String postal){

        // call on the changeCase method to change the postal code to uppercase so "l3s" is equivalent to "L3S"
        postal = changeCase(postal);

        // initialize bufferedreader to null
        BufferedReader objReader = null;

        try {
            String strCurrentLine;
            // read the file
            objReader = new BufferedReader(new FileReader("postal_codes.csv"));
                // conds when the user inputs 
                while ((strCurrentLine = objReader.readLine()) != null) {  
                    // condS to make sure the postal code entered only matches wiith the first 3 characters in each line
                    if (strCurrentLine.substring(0, 3).equals(postal.substring(0,3))) {
                        return true;
                    }      
                }
        }
        // catch when file not found
        catch (IOException e) {
            System.out.println("Postal Code File not found.");
        }
        catch (java.lang.StringIndexOutOfBoundsException e) {
            // System.out.println("Postal code too short");
            return false;
        }
        // to close reader
        finally {
            try {
                if (objReader != null){
                    objReader.close();
                }
            }
            // for catching errors
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // after everything is run and it is still running it is not a valid postal code false
        return false;    
    }
    /**
     * @author Cynthia Lei
     * Check if the inputted credit card is valid
     * 
     * @param credit the inputted credit card value
     * @return true if credit number is valid, otherwise false
     */
    public static boolean validateCreditCard(String credit){
        // Reversing the string --------------------------------------------------
        String link = ""; // this helps link all the characters together
        int len = credit.length(); // length of credit

        // for loop range starts from the end and counts down (reversed order)
        for (int i = (len - 1); i >= 0; i--) {
            link = link + credit.charAt(i);
        }
        //System.out.println("Reversed: " + link);
        // ------------------------------------------------------------------------

        // Put a try-catch here because the try block includes a code that will convert
        // string data type to integer so there will be an issue if the original string
        // is not a numerical value
        try {
            // sum1 and sum2 -----------------------------------------------------------
            int sum1 = 0;
            int sum2 = 0;

            for (int x = 0; x < len; x++) {
                if (x % 2 == 0) {
                    // every ODD digit
                    //System.out.println(link.charAt(x));
                    String digit = Character.toString(link.charAt(x)); // character to string
                    sum1 += Integer.parseInt(digit); // string to int
                }
                // every EVEN digit
                else {
                    int digit = Integer.parseInt(Character.toString(link.charAt(x)));
                    int doubleDigit = digit*2;
                    //System.out.println(digit*2);
                    
                    if (doubleDigit > 9) {
                        int doubleDigitSum = 0;
                        
                        // Sum of the digits
                        while(doubleDigit > 0) {
                            int remainder = doubleDigit % 10; // Get the ones place value
                            doubleDigitSum = doubleDigitSum + remainder;
                            doubleDigit = doubleDigit/10; // Get tens value
                        } 
                        sum2 += doubleDigitSum;
                    }
                    else {
                        sum2 += doubleDigit;
                    }
                }
            }
            // ------------------------------------------------------------------------

            // Credit Card Validitiy --------------------------------------------------
            int sumTotal = sum1 + sum2;

            if (sumTotal % 10 == 0){
                return true; // valid credit card
            }
            else {
                return false; // invalid credit card
            }
            // ------------------------------------------------------------------------

        }
        catch (java.lang.NumberFormatException e) {
            return false; // credit number input is not all numerical values
        }
    }
    /**
     * @author Cynthia Lei
     * Generating the customer data file
     * 
     * @param storage this contains all of the stored customer informations
     * @param read scanner used for user input
     */
    public static void generateCustomerDataFile(String storage, Scanner read){
        // System.out.println(storage);

        // Custom file name
        System.out.print("Enter file name: ");
        String fileName = read.nextLine();

        char slash = "\\".charAt(0); // this is so I can output \ without vscode freaking out
        // Prompt user to input custome file location
        System.out.print("If you input nothing, the data file will be found in the same folder as this program.");
        System.out.print("\nEnter file location (ex: '/Users/cynthia/Downloads/' or 'C:" + slash + "Users" + slash + "Steve" + slash + "Desktop" + slash + "'): ");
        String fileLocation = read.nextLine();
        // String fileLocation = "/Users/cynthia/Downloads/";

        // Create a file instance to reference the customer data file
        File file = new File(fileLocation + fileName + ".csv");
        
        try {
            // Adding lines ------------------------------------------
            // File doesn't exist
            if (!file.exists()) {
                // System.out.println("File doesn't exist so we will create a new one for you.");
                file.createNewFile();
            }
            
            // System.out.println("\nFile exists.");
            
            // True allows content to be appended to the file
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw); // Better performance
            PrintWriter pw = new PrintWriter(bw); // appends line to the file
            
            // Add a new line of customer info to the file content
            pw.print(storage);
            
            pw.close();
            // ------------------------------------------------------
        }
        catch (IOException e){
            System.out.println(e); // input/output issue
            System.out.println("You inputted a nonexistent file path ...");
        }

    }

    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    /**
     * @author Cynthia Lei
     * Checks if the string (credit number) consists of all numerical values
     * 
     * @param str user inputted String credit number
     * @return true if it contains all numerical values, otherwise false
     */
    public static boolean isStringAllNum (String str) {
        // Checks if the credit card number string input consists of all numerical values
        int len = str.length();
        for (int i = 0; i < len; i++) {
            // Interrupts the for loop the moment it hits a non-numerical character
            if (!Character.isDigit(str.charAt(i))) { 
                return false;
            }
        }
        return true; // every character is a number
    }
     /**
     * @author Daiphy Lee
     * Description : Changes whole postal code to uppercase 
     * 
     * @param code - postal the user enters
     * @return the postal code in capital letter
     */
    public static String changeCase(String code){
        String caseChanged;
        // changes the user input into uppercase letters
        caseChanged = code.toUpperCase();
        return caseChanged;
    }
    /**
     * @author Daiphy Lee
     * Description : Generates unique customer ID to match timestamp
     * 
     * @return the time stamp for the customer ID number
     */
    public static long getTimestamp(){
        // timestamp for customer ID number
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}
