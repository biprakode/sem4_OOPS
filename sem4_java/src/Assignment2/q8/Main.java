package Assignment2.q8;

public class Main {
    public static void main() {
        myCharSequence mySeq = new myCharSequence("Hello World");
        CharSequence sub = mySeq.subSequence(0, 5);
        System.out.println(sub.toString());
        System.out.println(mySeq.charAt(3));
    }
}
