import java.lang.*;
import java.util.InputMismatchException;

// create Fraction as an object that holds numerator and denominator
public class Fraction {
    private int numerator;
    private int denominator;

    //create 2 parameter constructor to initialize numerator and denominator
    public Fraction(int num, int den) {
        this.numerator = num;
        this.denominator = den;
        if (den == 0) { //if user enters "0"
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }   else if (den < 0){  //if user enters a negative number, bump it up to numerator
            this.numerator = num *-1;
            this.denominator = den *-1;
        }   else {  //if everything goes right
            this.numerator = num;
            this.denominator = den;
        }
    }

    //one parameter constructor that initializes the object equal in value to the integer parameter
    public Fraction(int num){

        this(num,1);
    }


    //zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
    public Fraction(){

        this(0);
    }

    //methods to implement

//exposes the value of the numerator field to the user
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() { //exposes the value of the denominator field to the user

        return denominator;
    }
//"numerator/denominator", a String representation of the Fraction

    public String toString() {
        return numerator + "/" + denominator;
    }
//the result of numerator / denominator

    public double toDouble() {
        return numerator/denominator;
    }
//returns a new Fraction that is the sum of other and this fractions


    public Fraction add (Fraction other) {
        Fraction myFrac = new Fraction (((this.numerator * other.denominator) + (other.numerator * this.denominator)),
                (this.denominator * other.denominator));
        myFrac.toLowestTerms();
        return myFrac;
    }

    //converts the current fraction to the lowest terms
    private void toLowestTerms() {
        int gcd = gcd (this.numerator,this.denominator);

        numerator = this.numerator/gcd;
        denominator = this.denominator/gcd;
    }

    //takes in two ints and determines the greatest common divisor of the two ints, should be a static method
    private static int gcd(int num, int den) {
        while (num!=0&&den!=0){
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
//returns a new Fraction that is the difference between the other and this fraction
    public Fraction subtract (Fraction other) {
        Fraction myFrac = new Fraction (((this.numerator * other.denominator) - (other.numerator * this.denominator)),
                (this.denominator * other.denominator));
        myFrac.toLowestTerms();
        return myFrac;
    }
/*returns a new Fraction that is the product of the
other and this fraction*/
    public Fraction multiply (Fraction other) {
        Fraction myFrac = new Fraction((this.numerator * other.denominator),(this.denominator * other.denominator));
        return myFrac;
    }

    /*returns a new Fraction that is the division of the
other and this fraction, throw an
IllegalArgumentException() if the user asks you to */
    public Fraction divide (Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }   else {
            Fraction myFrac = new Fraction ((this.numerator * other.denominator),
            (this.denominator * other.numerator));
            myFrac.toLowestTerms();
            return myFrac;
        }

    }
/*must take in an "Object" to properly override the
Object class's equals method, but should ultimately
check if two fractions are equal
*/
    public boolean equals(Object other) {
        if(other instanceof Fraction){
            Fraction otherFrac = (Fraction)other;
            otherFrac.toLowestTerms();

            Fraction thisFrac = new Fraction(this.numerator, this.denominator);
            thisFrac.toLowestTerms();

            if ((thisFrac.numerator == otherFrac.numerator) && (thisFrac.denominator == otherFrac.denominator)) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new InputMismatchException();
        }
    }
}


