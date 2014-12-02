package com.serli.tp.concurrency;

import org.junit.Test;

public class BonjourAuRevoir {

    public static final int NB_LOOPS = 1000;

    @Test
    public void shouldSayHelloGoodbye() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < NB_LOOPS; i++) {
                    System.out.println("Bonjour");
                    System.out.println("Monsieur");
                }
            }
        }).start();

        for (int i = 0; i < NB_LOOPS; i++) {
            System.out.println("Au revoir");
            System.out.println("Madame");
        }
    }
}
