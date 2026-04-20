// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// For a programme (such as, BCSE), each Instructor has name and phone number. Each
// textbook has a title, author name and publisher. Each course (that is, subject) has a
// course name, instructor and text book.
//   - One can set the data for a textbook and view the same.
//   - One can view instructor information and set the information.
//   - One can set the course data and view the same.

package Assignmen1.q8;

public class Main {
    public static void main(String[] args) {
        // build up a sample instructor, textbook, and course
        Instructor myInstructor = new Instructor("INS101", "Dr. Aris");
        TextBook myBook = new TextBook("Java Programming", "John Smith", "TechPress");
        Course myCourse = new Course("Intro to CS", myInstructor, myBook);

        System.out.println("Initial State:");
        System.out.println(myCourse);

        // mutate a few attributes and re-print to confirm the course sees the change
        System.out.println("\nUpdates");

        myBook.setTitle("Advanced Java");
        myBook.setPublisher("Global Ed");
        System.out.println("Updated Textbook: " + myCourse.getTextBook());

        myInstructor.setName("Dr. Sarah Connor");
        System.out.println("Updated Instructor: " + myCourse.getInstructor());

        myCourse.setName("CS 202: Advanced Programming");

        System.out.println("\nFinal Course View:");
        System.out.println(myCourse);
    }
}
