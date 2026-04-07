package Assignment3.q8;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class q8 {

    static class NoticeBoard {
        private String message = "(empty)";
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        String read(String threadName) {
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

        void write(String threadName, String newMessage) {
            if (!rwLock.writeLock().tryLock()) {
                System.out.println(threadName + " waiting for update to finish");
                rwLock.writeLock().lock();
            }
            try {
                System.out.println(threadName + " writing: " + newMessage);
                message = newMessage;
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            } finally {
                rwLock.writeLock().unlock();
            }
        }
    }

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
                try { Thread.sleep((long)(Math.random() * 100)); } catch (InterruptedException ignored) {}
            }
        }
    }

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
