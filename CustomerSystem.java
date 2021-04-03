// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray



import java.util.Scanner;
// More packages may be imported in the space below

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
    public static void enterCustomerInfo(Scanner reader) {
        System.out.println("\nEnter the customer info method");

        int customerID = 1;
        System.out.println("customerID is " + customerID);
        
        String firstName = "Cynthia";
        System.out.println("firstName is " + firstName);
        
        String lastName = "Lei";
        System.out.println("lastName is " + lastName);
        
        String city = "Toronto";
        System.out.println("city is " + city);

        String postalCode = "L4S";
        System.out.println("postalCode is " + postalCode);

        int creditCardNum = 123456789;
        while (validateCreditCard(creditCardNum) != true) {
            try {
                System.out.print("Enter credit card number: ");
                creditCardNum = reader.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Please input an INTEGER");
            }
            reader.nextLine();
            System.out.println("creditCardNum is " + creditCardNum + "\n");
        }
        System.out.println("The stored creditCardNum is " + creditCardNum + "\n");
        System.out.println("The number of digits: " + creditDigitLength(Integer.toString(creditCardNum)) + "\n");


        // must call generateCustomerDataFile after all user input is done so that
        // if the user wants to input a new set of data, the just inputted data won't
        // be lost

    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static boolean validateCreditCard(int num){
        System.out.println("Enter the validateCreditCard() method");

        String numString = Integer.toString(num); // convert from int to string

        if (num == 123){
            return true;
        }
        else {
            return false;
        }
        
    }

    public static int creditDigitLength (String digits) {
        return digits.length();
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
