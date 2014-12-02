package com.serli.tp.concurrency;


import com.google.common.io.Files;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class MultipleFilesHandlerTest {
    private MultipleFilesHandler testedObject;

    @Before
    public void before() {
        testedObject = new MultipleFilesHandler();
    }

    @Test
    public void shouldCopyFiles() {
        File tempDir = Files.createTempDir();
        URL testDir = MultipleFilesHandlerTest.class.getResource("/testMoveFiles/");
        testedObject.copyFiles(testDir.getPath(), tempDir.getAbsolutePath(), 10);


    }
}
