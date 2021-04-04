// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray



import java.util.Scanner;
import java.io.File; // import file class
import java.io.FileNotFoundException; // import class to handle errors
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args){
        
        String postalCode = "T1M";

        System.out.println(validatePostalCode(postalCode));
        
        System.out.println("Program Terminated");
    }
    /**
     * @author Daiphy Lee
     * Description : Open & reads postal_codes.csv file and identifies if the postal code entered matchs with postal codes on file
     * 
     * @param postalCode - 3 character code the user enters
     * @return true, false
     */
    public static boolean validatePostalCode(String postalCode){

        try {
            
            // open the file
            // create a file instance to reference the text file in java
            File textFile = new File("/Users/daiphylee/luhnAssignment/testing/postal_codes.csv");

            // read the file
            // we create a scanner instance to read the file in java
            // Scanner reader = new Scanner(System.in);
            Scanner reader = new Scanner(textFile);
        
            while (reader.hasNextLine()) {
                // read the file 
                String data = reader.nextLine();
                
                // if string is in string index of wont be -1
                if (data.indexOf(postalCode) != -1) {
                    return true;
                }
            } 
            reader.close();
            return false;
        } 
        catch (FileNotFoundException e) {
            return false;
        }
    }
    
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
