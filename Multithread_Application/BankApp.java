package multithread_application;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdrawSynchronized(String threadName, int amount) {
        synchronized (this) {
            if (balance >= amount) {
                System.out.println(threadName + " is withdrawing ₹" + amount + " (synchronized)");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                balance -= amount;
                System.out.println(threadName + " completed withdrawal. Remaining balance: ₹" + balance);
            } else {
                System.out.println(threadName + " failed. Insufficient balance: ₹" + balance);
            }
        }
    }

    public void withdrawWithLock(String threadName, int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(threadName + " is withdrawing ₹" + amount + " (lock)");
                Thread.sleep(100);
                balance -= amount;
                System.out.println(threadName + " completed withdrawal. Remaining balance: ₹" + balance);
            } else {
                System.out.println(threadName + " failed. Insufficient balance: ₹" + balance);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

class CustomerTask implements Runnable {
    private final BankAccount account;
    private final String customerName;
    private final int amount;
    private final boolean useLock;

    public CustomerTask(BankAccount account, String name, int amount, boolean useLock) {
        this.account = account;
        this.customerName = name;
        this.amount = amount;
        this.useLock = useLock;
    }

    public void run() {
        if (useLock)
            account.withdrawWithLock(customerName, amount);
        else
            account.withdrawSynchronized(customerName, amount);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial bank balance: ₹");
        int balance = scanner.nextInt();
        BankAccount sharedAccount = new BankAccount(balance);

        while (true) {
            System.out.print("\nEnter customer name (or type 'exit' to quit): ");
            String name = scanner.next();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Enter amount to withdraw: ₹");
            int amount = scanner.nextInt();

            System.out.print("Use lock? (yes/no): ");
            String lockChoice = scanner.next();
            boolean useLock = lockChoice.equalsIgnoreCase("yes");

            Thread t = new Thread(new CustomerTask(sharedAccount, name, amount, useLock));
            t.start();

            // Wait a bit to prevent overlapping input mess
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }

        System.out.println("\nFinal Balance: ₹" + sharedAccount.getBalance());
        scanner.close();
    }
}
