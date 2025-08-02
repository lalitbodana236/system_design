package com.lalitbodana.resource.designpattern.creational.singleton;

public class SingletonTestRunner {
    
    public static void main(String[] args) {
        Runnable testAll = () -> {
            EagerSingleton.getInstance();
            LazySingleton.getInstance();
            SynchronizedSingleton.getInstance();
            DoubleCheckedLockingSingleton.getInstance();
            BillPughSingleton.getInstance();
            EnumSingleton.INSTANCE.doSomething();
        };
        
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(testAll, "Thread-" + i);
        }
        
        for (Thread t : threads) {
            t.start();
        }
    }
}

