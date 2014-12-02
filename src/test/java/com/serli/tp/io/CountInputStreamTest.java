package com.serli.tp.io;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CountInputStreamTest {

    public static final String ABCDEFGH = "abcdefgh";

    @Test
    public void shouldCount() throws IOException {
        CountInputStream countInputStream = new CountInputStream(new ByteArrayInputStream(ABCDEFGH.getBytes()));
        int read = countInputStream.read();
        while (read != -1) {
            read = countInputStream.read();
        }
        assertEquals(ABCDEFGH.length(), countInputStream.getCount());
    }

    @Test
    public void shouldCountWithBuffer() throws IOException {
        CountInputStream countInputStream = new CountInputStream(new ByteArrayInputStream(ABCDEFGH.getBytes()));
        byte[] bytes = new byte[1024];
        int read = countInputStream.read(bytes);
        while (read != -1) {
            read = countInputStream.read();
        }
        assertEquals(ABCDEFGH.length(), countInputStream.getCount());
    }
}
