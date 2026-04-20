// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q4 - dedicated exception for overdraft breaches

package Assignment2.q4;

public class OverdraftLimitException extends RuntimeException {
    public OverdraftLimitException(String message) {
        super(message);
    }
}
