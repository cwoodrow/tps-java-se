package com.serli.tp.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSynchronizedCounter {
    private AtomicInteger counter = new AtomicInteger(1);

    public int getNext(){
        return counter.getAndIncrement();
    }

}
