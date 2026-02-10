package Assignment2.q6;

public class Main {
    public static void main(String[] args) {
        int primitiveInt = 100;
        Integer objectInt = primitiveInt;
        System.out.println("Object: " + objectInt);

        int backToPrimitive = objectInt;
        System.out.println("Primitive: " + backToPrimitive);

        String strFromPrimitive = String.valueOf(primitiveInt);
        System.out.println("String from primitive: " + strFromPrimitive);

        String numericData = "500";
        Integer objectFromString = Integer.valueOf(numericData);
        System.out.println("Object from String: " + objectFromString);

        String strFromObject = objectInt.toString();
        System.out.println("String from object: " + strFromObject);
    }
}
