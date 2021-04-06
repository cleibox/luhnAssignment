// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray



import java.util.Scanner;
import java.io.BufferedReader; // import buffer reader class (because scanner likes to skip lines)
import java.io.FileReader; // import class to read files
import java.io.IOException; // import class to handle exceptions

import java.io.File; // import file class
import java.io.FileNotFoundException; // import class to handle errors
import java.io.PrintWriter; // import class to extend writer


class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
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
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    /**
     * @author Daiphy Lee
     * Enter customer information
     * 
     * @param reader scanner for user input; saves the hassle of reinitializing
     * @param ID a unique customer ID per visit
     * @return the user's inputted name, city, postal code, credit card
     */
    public static void enterCustomerInfo(Scanner reader, int ID) {
        System.out.println("\nEnter the customer info method");

        ID += 1;

        System.out.println("customerID: " + ID);
        
        // prompt reader to enter first name, last name, city, postal code, and credit card num

        System.out.print("Enter your first name: ");
        String firstName = reader.nextLine();
        System.out.println("The first name is stored as " + firstName + "\n");
        
        System.out.print("Enter your last name: ");
        String lastName = reader.nextLine();
        System.out.println("The last name is stored as " + lastName + "\n");
        
        System.out.print("Enter your city: ");
        String city = reader.nextLine();
    	System.out.println("The city is stored as " + city + "\n");

        System.out.print("Enter your postal code: ");
        String postalCode = reader.nextLine();
        // call on the changeCase method to change the postal code to uppercase so "l3s" is equivalent to "L3S"
        postalCode = changeCase(postalCode);
        System.out.println("The Postal Code is stored as " + postalCode + "\n");


        System.out.print("Enter a valid credit card number: ");
        String creditCardNum = reader.nextLine();
        System.out.println("The Credit Card Number is stored as " + creditCardNum + "\n");

        // must call generateCustomerDataFile after all user input is done so that
        // if the user wants to input a new set of data, the just inputted data won't
        // be lost
    }
    /**
     * @author Daiphy Lee
     * Description : Open & reads postal_codes.csv file and identifies if the postal code entered matchs with postal codes on file
     * 
     * @param postalCode - 3 character code the user enters
     * @return true, false
     */
    public static boolean validatePostalCode(String postal){

        // call on the changeCase method to change the postal code to uppercase so "l3s" is equivalent to "L3S"
        postal = changeCase(postal);

        // initialize bufferedreader to null
        BufferedReader objReader = null;

        try {
            String strCurrentLine;
            // read the file
            objReader = new BufferedReader(new FileReader("/Users/daiphylee/luhnAssignment/code/postal_codes.csv"));
                // conds when the user inputs 
                while ((strCurrentLine = objReader.readLine()) != null) {  
                    // condS to make sure the postal code entered only matches wiith the first 3 characters in each line
                    if (strCurrentLine.substring(0, 3).equals(postal)) {
                        return true;
                    }      
                }
        }
        // catch if file not found
        catch (IOException e) {
            e.printStackTrace();
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
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }
    /**
     * @author Daiphy Lee
     * Description : Changes whole postal code to uppercase 
     * 
     * @param code - postal the user enters
     * @return the postal code as capital
     */
    public static String changeCase(String code){
        String caseChanged;
        // changes the user input into uppercase letters
        caseChanged = code.toUpperCase();
        return caseChanged;
    }
}
