// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Consider a wrapper class for a numeric basic type. Check the support for the following:
// conversion from i) basic type to object ii) object to basic type iii) basic type to String
// iv) String (holding numeric data) to numeric object v) object to String.

package Assignment2.q6;

public class Main {
    public static void main(String[] args) {
        // (i) basic type -> object: auto boxing
        int primitiveInt = 100;
        Integer objectInt = primitiveInt;
        System.out.println("Object: " + objectInt);

        // (ii) object -> basic type: auto unboxing
        int backToPrimitive = objectInt;
        System.out.println("Primitive: " + backToPrimitive);

        // (iii) basic type -> string
        String strFromPrimitive = String.valueOf(primitiveInt);
        System.out.println("String from primitive: " + strFromPrimitive);

        // (iv) numeric string -> wrapper object
        String numericData = "500";
        Integer objectFromString = Integer.valueOf(numericData);
        System.out.println("Object from String: " + objectFromString);

        // (v) wrapper object -> string via toString
        String strFromObject = objectInt.toString();
        System.out.println("String from object: " + strFromObject);
    }
}
