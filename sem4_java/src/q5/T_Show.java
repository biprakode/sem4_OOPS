package q5;

public class T_Show<T> {
    T val;
    T_Show(T t) {
        this.val = t;
    }
    void show() {
        System.out.println(this.val);
    }
}
