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
        
        String firstName = "Cynthia";
        System.out.println("firstName is " + firstName);
        
        String lastName = "Lei";
        System.out.println("lastName is " + lastName);
        
        String city = "Toronto";
        System.out.println("city is " + city);

        String postalCode = "L4S";
        System.out.println("postalCode is " + postalCode);

        System.out.print("Enter a valid credit card number: ");
        String creditCardNum = reader.nextLine();
        while ( (creditCardNum.length() < 9) 
            || (isStringAllNum(creditCardNum) != true) 
            //|| if credit card not valid
            ) {
            System.out.print("Please input with ONLY NUMBERS and AT LEAST 9 digits: ");
            creditCardNum = reader.nextLine();
        }
        System.out.println("creditCardNum is stored as " + creditCardNum + "\n");

        luhnAlgor(creditCardNum);

        // must call generateCustomerDataFile after all user input is done so that
        // if the user wants to input a new set of data, the just inputted data won't
        // be lost

    }
    
    public static boolean isStringAllNum (String str) {
        // Checks if the credit card number string input consists of all numerical values

        int len = str.length();
        for (int i = 0; i < len; i++) {
            // if statement to check if a character is NOT a number
            if (!Character.isDigit(str.charAt(i))) { 
                return false;
            }
        }
        return true; // every character is a number
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
    public static void validateCreditCard(int num){ 
        System.out.println("Enter the validateCreditCard() method");
        
    }

    public static void luhnAlgor(String credit) {
        System.out.println("credit number so far is " + credit);

        // Reversing the string --------------------------------------------------
        String link = ""; // this helps link all the characters together
        int len = credit.length(); // length of credit

        // for loop range starts from the end and counts down (reversed order)
        for (int i = (len - 1); i >= 0; i--) {
            link = link + credit.charAt(i);
        }
        System.out.println("Reversed: " + link);
        // ------------------------------------------------------------------------

        // Sum1 -------------------------------------------------------------------
        int sum1 = 0;

        for (int x = 0; x < len; x++) {
            if (x % 2 == 0) {
                // every ODD digit
                System.out.println(link.charAt(x));
                String digit = Character.toString(link.charAt(x));
                sum1 += Integer.parseInt(digit);
            }
        }
        System.out.println("sum of odd digits is " + sum1);
        // ------------------------------------------------------------------------

        

    }

    public static int creditDigitLength(String digits) {
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
