package com.serli.tp.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TextFileHandlerTest {
    private TextFileHandler testedObject;

    @Before
    public void before(){
        testedObject = new TextFileHandler();
    }

    @Test
    public void shouldReadLineByLine() throws IOException {
        String file = TextFileHandlerTest.class.getResource("/textFileHandlerTest.txt").getFile();

        File output = File.createTempFile("output", ".txt");
        System.out.println("output : " + output.getAbsoluteFile());

        testedObject.readShowAndWriteFile(new File(file), output);

    }
}
