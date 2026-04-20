// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Write a class that implements the CharSequence interface found in the java.lang package.
// So, it would contain the following methods.
//   (i) char charAt(int index)
//   (ii) int length()
//   (iii) CharSequence subSequence(int start, int end)
//   (iv) Override toString()
// Your implementation should return the string backwards. Select one of the sentences
// from the lecture slide to use as the data. Write a small main method to test your class;
// make sure to call all four methods.

package Assignment2.q8;

public class Main {
    public static void main() {
        // build the custom sequence from a sample sentence
        myCharSequence mySeq = new myCharSequence("Hello World");
        // carve out a slice and print it
        CharSequence sub = mySeq.subSequence(0, 5);
        System.out.println(sub.toString());
        // grab a single char as well
        System.out.println(mySeq.charAt(3));
    }
}
