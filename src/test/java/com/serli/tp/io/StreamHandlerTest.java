package com.serli.tp.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class StreamHandlerTest {
    private StreamHandler testedObject = new StreamHandler();

    @Test
    public void shouldWriteStringToFile() throws IOException {
        File tempFile = File.createTempFile("streamHandlerTest", ".txt");

        System.out.println(tempFile.getAbsoluteFile());

        testedObject.stringToFile("aaaa\nbbbbb\neeeeee", tempFile);
    }
}
