/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 /*
 * First develop the Testing Method, then Develop the actual Methods [Test Driven Development (TDD)]
 *
 * Can still handle carries on addition, just 0 instead of 1 if no carry
 *
 */

 // Interesting Line of Code
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;
import java.lang.Object;

public class BrobInt {

   private static final String usageMessage = "\n  Error! Please make sure all entries (besides the sign)" +
                                             "\n  are integers. No decimals, no symbols, no craziness. Just integers." +
                                             "\n  USAGE: java BrobInt <required_integer>\n\n";


   public static final BrobInt ZERO     = new BrobInt( new String ("0") );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt( new String ("1") );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt( new String ("2") );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt( new String ("3") );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt( new String ("4") );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt( new String ("5") );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt( new String ("6") );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt( new String ("7") );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt( new String ("8") );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt( new String ("9") );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( new String ("10") );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( new String( new Integer( Integer.MAX_VALUE ).toString()) );
   public static final BrobInt MIN_INT  = new BrobInt( new String (new Integer( Integer.MIN_VALUE ).toString()) );
   public static final BrobInt MAX_LONG = new BrobInt( new String (new Long( Long.MAX_VALUE ).toString()) );
   public static final BrobInt MIN_LONG = new BrobInt( new String (new Long( Long.MIN_VALUE ).toString()) );

  /// These are the internal fields
   private String internalValue = "";        // internal String representation of this BrobInt
   public int     sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   public int[] intArray = null;
   private byte[] byteVersion = null;
   private int CHARS_THAT_FIT = 8;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  args  String value to make into a BrobInt
   */

   public BrobInt( String args ) throws IllegalArgumentException{
      if (false == validateDigits()) {
        System.out.println ("Error! Make sure you're using just ints! ");
      }

      if (args.length() == 0) {
        throw new IllegalArgumentException (usageMessage);
      }
      StringBuffer value = new StringBuffer(args);
      if (args.charAt(0) == '-'){
        sign = 1;
        value.deleteCharAt(0);
      }
      else if (args.charAt(0) == '+') {
        sign = 0;
        value.deleteCharAt(0);
      }
      while (true) {
        if (value.length() == 1 ) {
          break;
        }
        else if ((value.charAt(0) == '0') ) {
          value.deleteCharAt( 0);
        }
        else {
          break;
        }
      }


     internalValue += value.toString();





      int i = 0;
      int length = internalValue.length();
      int start = length - CHARS_THAT_FIT;
      int size = (int) (Math.ceil(length/CHARS_THAT_FIT) + 1);
      intArray = new int[size];

      StringBuffer sb = new StringBuffer(internalValue).reverse();

      while (length >= 8) {
        intArray[i] = Integer.parseInt(sb.substring(start,length));
        start -= CHARS_THAT_FIT;
        length -= CHARS_THAT_FIT;
        i++;
      }

      if (length > 0) {
        intArray[i] = Integer.parseInt(sb.substring(0,length));
      }
      while (i < size-1){
        intArray[i] = 0;
        i++;
      }

      if (sign == 1) {
        internalValue = "-" + internalValue;
      }

    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() {
      for (int i = 0; i < internalValue.length(); i++) {
        if (false == Character.isDigit(internalValue.charAt(i))) {
          return false;
        }
      }
      return true;

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
     BrobInt b = new BrobInt(new StringBuffer(internalValue).reverse().toString() );
     return b;

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  gint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt gint ) {
     return gint.reverser();
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addInt( BrobInt gint ) {

     int n1Size = intArray.length-1;
     int n2Size = gint.intArray.length-1;
     int indexSum = n1Size > n2Size ? (n1Size + 2) : (n2Size + 2);
     int slack = 0;
     int[] sum = new int[indexSum];
     int s;
     int i = 0;
     int j = 0;
     int k = 0;


     if (sign == gint.sign) {
      while (true) {
        if (i > n1Size && j > n2Size) {
          break;
        }
        s = (i <= n1Size ? intArray[i] : 0) + (j <= n2Size ? gint.intArray[j] : 0) + slack;
        i++;
        j++;
        if (Integer.toString(s).length() > CHARS_THAT_FIT) {
          StringBuffer sb = new StringBuffer( Integer.toString(s) );
          slack = 1;
          sb.deleteCharAt(0);
          sum[k++] = Integer.parseInt( sb.toString() );
        }
        else {
          sum[k++] = s;
          slack = 0;
        }
      }
      if (slack != 0) {
        sum[k++] = slack;
      }
      while (k < indexSum) {
        sum[k++] = 0;
      }


      String strSum = "";
      for (int m = 0; m < sum.length; m++){
        strSum += Integer.toString(sum[m]);
      }
      //for (i = sum.length -1; i >= 0 ;i--){

      //}
      BrobInt result = new BrobInt( strSum );
      result.sign = sign;
      return result;
    }
    else if (0 == compareTo(gint)) {
      return BrobInt.ZERO;
    }
    else if (1 == compareTo(gint) ){
      BrobInt bigInt = this;
      bigInt.sign = 0;
      BrobInt smallInt = gint;
      smallInt.sign = 0;
      BrobInt result = bigInt.subtractInt(smallInt);
      result.sign = sign;
      return result;
    }
    else {
      BrobInt bigInt = gint;
      bigInt.sign = 0;
      BrobInt smallInt = this;
      smallInt.sign = 0;
      BrobInt result = smallInt.subtractInt(bigInt);
      result.sign = gint.sign;
      return result;
    }
  }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractInt( BrobInt gint ) {
      // Set up for substraction sign handling to decide what to do based on the following cases:
      //    1) no sign at all, this item lrger than arg :                       simple subtract a -b
      //    2) both signs (+), this item lrger than arg:                        simple subtract a-b
      //    3) one (+) one no sign, this item lrger than arg:                   simple subtract a-b
      //    4) no signs at all, this item smaller than arg:                     swap a&b, subtract a-b, result negative
      //    5) both signs positive, this item smaller than arg:                 swap a&b, subtract a-b, result negative
      //    6) one positive one no sign, this item smaller than arg:            swap a&b, subtract a-b, result negative
      //    7) this no sign or positive, arg negative:                          remove neg
      if (1 == gint.sign) {
        gint.sign = 0;
        return addInt(gint);
      }
      else if (this.sign == 1) {
        gint.sign = 1;
        return addInt(gint);
      }
      else{
        if (0 == compareTo(gint)){
          return ZERO;
        }
        else if (1 == compareTo(gint)){
          BrobInt bigInt = this;
          BrobInt smallInt = gint;

          int carry = 0;
          int sub;
          int size = bigInt.intArray.length;
          int[] resultArray = new int[size];
          for (int i = 0; i < smallInt.intArray.length; i++) {
            sub = bigInt.intArray[i] - smallInt.intArray[i] - carry;
            if (sub < 0) {
              sub = sub + 10^CHARS_THAT_FIT;
              carry = 1;
            }
            else {
              carry = 0;
            }
            resultArray[i] = sub;
          }

          for (int i = smallInt.intArray.length; i < bigInt.intArray.length; i++ ) {
            sub = bigInt.intArray[i] - carry;
            if (sub < 0) {
              sub = sub + 10^CHARS_THAT_FIT;
              carry = 1;
            }
            else {
              carry = 0;
            }
            resultArray[i] = sub;
          }

          String strSum = "";
          for (int i = resultArray.length -1; i >= 0 ;i--){
            strSum += resultArray[i];
          }
          BrobInt result = new BrobInt(strSum );
          result.sign = sign;
          return result;
        }
        else {
          BrobInt bigInt = gint;
          BrobInt smallInt = this;

          int carry = 0;
          int sub;
          int size = bigInt.intArray.length;
          int[] resultArray = new int[size];
          for (int i = 0; i < smallInt.intArray.length; i++) {
            sub = bigInt.intArray[i] - smallInt.intArray[i] - carry;
            if (sub < 0) {
              sub = sub + 10^CHARS_THAT_FIT;
              carry = 1;
            }
            else {
              carry = 0;
            }
            resultArray[i] = sub;
          }

          for (int i = smallInt.intArray.length; i < bigInt.intArray.length; i++ ) {
            sub = bigInt.intArray[i] - carry;
            if (sub < 0) {
              sub = sub + 10^CHARS_THAT_FIT;
              carry = 1;
            }
            else {
              carry = 0;
            }
            resultArray[i] = sub;
          }

          String strSum = "";
          for (int i = resultArray.length -1; i >= 0 ;i--){
            strSum += resultArray[i];
          }
          BrobInt result = new BrobInt(strSum);
          result.sign = 1;
          return result;
        }
      }
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt gint ) {
      int finalSign = ((sign == gint.sign) ? 0 : 1);

      BrobInt bigInt;
      BrobInt smallInt;
      BrobInt result = ZERO;
      int digitPlace;
      int tempSum;
      int s = 0;
      BrobInt sum = ZERO;
      int carry;


      if (internalValue.length() > gint.internalValue.length()) {
        bigInt = this;
        smallInt = gint;
      }
      else {
        bigInt = gint;
        smallInt = this;
      }

      for (int i = 0; i < smallInt.internalValue.length(); i++) {
        digitPlace = i;
        tempSum = 0;
        sum = ZERO;
        carry = 0;
        for (int j = bigInt.internalValue.length() - 1 ; j >= 0 ; j--) {
          tempSum = Character.getNumericValue(j)*Character.getNumericValue(-i) + carry;
          carry = s % 10;
          tempSum = (int) Math.floor(tempSum / 10 );
          sum = sum.addInt(new BrobInt(Integer.toString(tempSum * 10^digitPlace)) );
          digitPlace++;
        }
        sum = sum.addInt( new BrobInt( Integer.toString( carry*10^digitPlace ) ));
        result = result.addInt( sum );
      }
      result.sign = finalSign;
      return result;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  gint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

      // for implementation, in this discussion/ comment/ steps:
      //  0. divsor [passed in as ARGUMENT] is 'd1'
      //    dividend [ME] is 'd2'
      //    current dividend being handled is 'd3'
      //    quotient is 'q' and string length count is 'n'
      //      for example, 56789 divided by 37: d1 == 37 and d2 == 56789
      //      d3 starts with 56 and goes on adding single digits with each iteration
      //      "q" starts at zero and "n" starts at 2

      // 1. is d1 == 0? if so throw IllegalArgumentException
      // IF ARGUMENT is equal to BrobInt.ZERO
      //  throw new IllegalArgumentException

      // 2. is d1 == d2? if so, return BrobInt.one

      // 3. is d1 > d2? if so, return BrobInt.ZERO (integer arthimetic)

      //4. otherwise, get length of d1 and put into "n"

      //5. extract that many char from the front of d2 and put into d3

      //6. is d1>d3? if so, add one to "n" and re-extract characters from d2 into d3

      //7. while "n" <= d2.toString().length()
      //  a. while d3 > d1:
      //      i. subract d1 from d3 [gint.subtract(this)]
      //      ii. add one to quotient [q.add(BrobInt.ONE)]
      //  b. d3 now has any remainder [e.g. 56-37 = 19, "q" is one and d3 is 19]
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  gint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  gint  BrobInt to add to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
   *        THAT was easy.....
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt gint ) {
    if( internalValue.length() > gint.internalValue.length() ) {
       return 1;
    }
    else if( internalValue.length() < gint.internalValue.length() ) {
       return (-1);
    }
    else {
       for( int i = 0; i < internalValue.length(); i++ ) {
          Character a = new Character( internalValue.charAt(i) );
          Character b = new Character( gint.internalValue.charAt(i) );
          if( new Character(a).compareTo( new Character(b) ) > 0 ) {
             return 1;
          } else if( new Character(a).compareTo( new Character(b) ) < 0 ) {
             return (-1);
          }
       }
    }
    return 0;
 }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  gint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt gint ) {
      return (internalValue.equals( gint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value         long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt gi = null;
      try {
         gi = new BrobInt( new Long( value ).toString() );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( "\n  Sorry, the value must be numeric of type long." );
      }
      return gi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  note:  we don't really care about these
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );
      BrobInt b = new BrobInt("1431423145135812348091273498075490832745908173490187359803475");
      System.exit( 0 );
   }
}
