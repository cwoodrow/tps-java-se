package com.serli.tp.concurrency;

public class SynchronizedCounter {
    private volatile int counter = 1;


    public synchronized int getNext(){
        return counter++;
    }
}
