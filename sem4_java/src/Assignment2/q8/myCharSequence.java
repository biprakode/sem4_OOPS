package Assignment2.q8;

import java.util.Arrays;

public class myCharSequence implements CharSequence{
    private char[] charSeq;
    private int length;

    myCharSequence(String str) {
        this.length = str.length();
        this.charSeq = new char[length];
        for (int i = 0; i < length; i++) {
            charSeq[i] = str.charAt(i);
        }
    }

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
        if(index < 0 || index >= charSeq.length) {
            throw new IndexOutOfBoundsException("index out of bound");
        }
        return charSeq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > length || start > end) {
            throw new IndexOutOfBoundsException();
        }

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
