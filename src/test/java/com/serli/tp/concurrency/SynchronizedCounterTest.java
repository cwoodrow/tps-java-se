package com.serli.tp.concurrency;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SynchronizedCounterTest {
    private SynchronizedCounter testedObject;

    @Before
    public void before(){
        testedObject = new SynchronizedCounter();
    }

    @Test
    public void shouldCountTo1000WithOneThread() {
        for (int i = 0; i < 1000; i++) {
            testedObject.getNext();
        }

        assertEquals(1001, testedObject.getNext());
    }

    @Test
    public void shouldCountTo1000With5Threads() throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        testedObject.getNext();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads){
            thread.join();
        }


        assertEquals(5001, testedObject.getNext());
    }

}
