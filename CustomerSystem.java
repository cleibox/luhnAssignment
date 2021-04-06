// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray



import java.util.Scanner;

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
                enterCustomerInfo(reader);
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
     * @return the user's inputted name, city, postal code, credit card
     */
    public static void enterCustomerInfo(Scanner reader) {
        System.out.println("\nEnter the customer info method");
        
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
        System.out.println("The Postal Code is stored as " + postalCode + "\n");


        System.out.print("Enter a valid credit card number: ");
        String creditCardNum = reader.nextLine();
        System.out.println("The Credit Card Number is stored as " + creditCardNum + "\n");

        // must call generateCustomerDataFile after all user input is done so that
        // if the user wants to input a new set of data, the just inputted data won't
        // be lost
    }
    public static void validatePostalCode(){
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

}
