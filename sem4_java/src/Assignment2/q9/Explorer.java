// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting interface for q9 - explorer visitor contract

package Assignment2.q9;

public interface Explorer {
    // one explore method per planet type so behaviour can differ per planet
    void explore(Mars mars);
    void explore(Venus venus);
    void explore(Saturn saturn);
}
