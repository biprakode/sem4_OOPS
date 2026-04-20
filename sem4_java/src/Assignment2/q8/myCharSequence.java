// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q8 - custom CharSequence implementation

package Assignment2.q8;

public class myCharSequence implements CharSequence {
    // backing store is a char array
    private char[] charSeq;
    private int length;

    myCharSequence(String str) {
        // copy every character in from the given string
        this.length = str.length();
        this.charSeq = new char[length];
        for (int i = 0; i < length; i++) {
            charSeq[i] = str.charAt(i);
        }
    }

    // private ctor used by subSequence to wrap an already-prepared slice
    private myCharSequence(char[] subArray) {
        this.charSeq = subArray;
        this.length = subArray.length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        // bounds check first, then hand back the char
        if (index < 0 || index >= charSeq.length) {
            throw new IndexOutOfBoundsException("index out of bound");
        }
        return charSeq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        // standard bounds validation
        if (start < 0 || end > length || start > end) {
            throw new IndexOutOfBoundsException();
        }

        // copy the requested slice into a fresh array
        int subLength = end - start;
        char[] subArray = new char[subLength];
        System.arraycopy(charSeq, start, subArray, 0, subLength);

        return new myCharSequence(subArray);
    }

    @Override
    public String toString() {
        return new String(charSeq, 0, length);
    }
}
