// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// You are asked to create a notice board. Anybody can read the notice board parallelly
// but when any one is writing on it, all others should wait for the modification to
// finish. So, the waiting threads would display a suitable message to indicate that it
// is waiting for the update to finish.

package Assignment3.q8;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class q8 {

    // shared notice board protected by a read-write lock
    static class NoticeBoard {
        private String message = "(empty)";
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        // reader - multiple readers can run in parallel
        String read(String threadName) {
            // try without blocking - if busy, print the wait notice first
            if (!rwLock.readLock().tryLock()) {
                System.out.println(threadName + " waiting for update to finish");
                rwLock.readLock().lock();
            }
            try {
                return message;
            } finally {
                rwLock.readLock().unlock();
            }
        }

        // writer - exclusive access, readers must wait
        void write(String threadName, String newMessage) {
            if (!rwLock.writeLock().tryLock()) {
                System.out.println(threadName + " waiting for update to finish");
                rwLock.writeLock().lock();
            }
            try {
                System.out.println(threadName + " writing: " + newMessage);
                message = newMessage;
                // small pause so contention is easier to observe
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            } finally {
                rwLock.writeLock().unlock();
            }
        }
    }

    // reader thread - peeks at the board several times
    static class Reader extends Thread {
        private final NoticeBoard board;
        Reader(String name, NoticeBoard board) {
            super(name);
            this.board = board;
        }
        public void run() {
            for (int i = 0; i < 5; i++) {
                String msg = board.read(getName());
                System.out.println(getName() + " read: " + msg);
                // random short pause between reads
                try { Thread.sleep((long)(Math.random() * 100)); } catch (InterruptedException ignored) {}
            }
        }
    }

    // writer thread - updates the board a few times
    static class Writer extends Thread {
        private final NoticeBoard board;
        Writer(String name, NoticeBoard board) {
            super(name);
            this.board = board;
        }
        public void run() {
            for (int i = 0; i < 3; i++) {
                board.write(getName(), "Notice from " + getName() + " #" + (i + 1));
                try { Thread.sleep((long)(Math.random() * 150)); } catch (InterruptedException ignored) {}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NoticeBoard board = new NoticeBoard();

        // mix of readers and writers all banging on the same board
        Thread[] threads = {
            new Reader("Reader-1", board),
            new Reader("Reader-2", board),
            new Reader("Reader-3", board),
            new Reader("Reader-4", board),
            new Reader("Reader-5", board),
            new Writer("Writer-1", board),
            new Writer("Writer-2", board),
        };

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println("\nFinal message: " + board.read("Main"));
    }
}
