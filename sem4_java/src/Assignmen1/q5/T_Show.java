// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q5 - generic show container

package Assignmen1.q5;

public class T_Show<T> {
    // one slot that can hold any type
    T val;

    T_Show(T t) {
        this.val = t;
    }

    // just prints whatever is stored
    void show() {
        System.out.println(this.val);
    }
}
