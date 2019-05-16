/**This project is designed to help you practice building your own object class and testing it with a client
 class. You will be creating two classes, one called Fraction and the other called FractionCalculator. The
 Fraction class is an object that holds information about a Fraction (numerator and denominator). It will
 have several constructors and both private and public methods implementing the behavior of a Fraction.
 The FractionCalculator class is a class that will allow the user to enter in fractions and operations,
 calculating and displaying the result. It will run until the user tells it to quit. When this program is
 complete, you won’t have to second guess your Fraction arithmetic ever again!*/

import javafx.beans.binding.IntegerExpression;

import java.util.*;

//In this section, you will implement a FractionCalculator class that has a main method and three helper methods
public class fractionCalculator {

    public static Scanner console = new Scanner(System.in);

    public static void intro() {
        System.out.println("Welcome to Fraction Calculator.");
        System.out.println("It will help you add, subtract, divide and multiply fractions until you enter \"Q\" to quit");
        System.out.println("Please enter your fraction in the form of (a/b) where \"a\" and \"b\" are integers.");
    }


    public static void main (String[] args) {
        Fraction frac1;
        Fraction frac2;


        intro();    //run intro first
        String op = getOperation();     //run getOperation and store it as operator
        frac1 = getFraction();  //run getFraction and store it as 2nd input by user
        frac2 = getFraction();  //run getFraction and store it as 1st input by user

        if (op.equals("+")) {
            System.out.println(frac1 + " + " + frac2 + " = " + frac1.add(frac2));

        } else if (op.equals("-")) {
            System.out.println(frac1 + " - " + frac2 + " = " + frac1.subtract(frac2));

        }else if (op.equals("/")) {
            System.out.println(frac1+ " / " +frac2+ " = " +frac1.divide(frac2));

        }else if (op.equals("*")) {
            System.out.println(frac1+ " / " +frac2+ " = " +frac1.multiply(frac2));

        } else if (op.equals("=")) {
            System.out.println(frac1+ " = " +frac2+ " is " +frac1.equals(frac2));
        }
    }






    public static String getOperation() {
        System.out.println("Please enter an operation (+,-,/,*,= or \"Q\" to quit)");
        String op = console.nextLine();

        int x = 0;
        while (x == 0) {
            if (op.equalsIgnoreCase("q")) {
                System.exit(0);

            } else if (op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*") || op.equals("=")) {
                x++;
            } else {
                System.out.println("Invalid entry. Please choose again.");
                op = console.nextLine();
            }
        }
        return op;
    }

     public static boolean validFraction(String fraction) {
        boolean valid;
            if (fraction.startsWith("-")) {//remove the "-" character
               fraction = fraction.substring(1, fraction.length());
            }

            if (fraction.contains("-")) {      // eliminate negative values from anywhere else
                fraction = fraction.replace("-", "");
            }
            if (fraction.charAt(fraction.indexOf("/")+1)==('0')) {  // to negate if denominator is zero
                valid = false;
            }
            if (fraction.matches("[0-9]+")) {    //ensure they are numbers
                valid = true;

            } else {
                valid = false;
            } if (fraction.contains("/")) {
                valid = true;
         }

            return valid;

         //if there is no "/" character, then every character in the string must be a number
         //if there is a "/" character, create substrings for num and den
         //both substrings musn't be empty and both substrings must be only numbers and den cannot be "0"



        }

        public static Fraction getFraction() {
            //if user enter an invalid fraction, prompt until it is
            System.out.println("Please enter a fraction (a/b) or integer (a)");
            String input = console.nextLine();

            while(!validFraction(input)) {  //call back validFraction method to test if they are true
                System.out.println("Invalid fraction. Please enter (a/b) or (a), where a and b are integers" +
                        " " + "and b is not zero");
                input = console.nextLine();
            }
            int num = 0; // initialize num and den to return those values
            int den = 0;

            if (input.contains("/")) {

                    String[] frac = input.split("/");

                    num = Integer.parseInt(frac[0]);
                    den = Integer.parseInt(frac[1]);



            }  else {
                String[] frac = input.split("/");
                num = Integer.parseInt(frac[0]);// convert input into integer using parseInt
                den = 1;
            }


            Fraction properFrac = new Fraction(num,den);
            return properFrac;

        }


}


