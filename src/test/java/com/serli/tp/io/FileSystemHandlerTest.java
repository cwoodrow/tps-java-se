package com.serli.tp.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileSystemHandlerTest {
    private FileSystemHandler testedObject = new FileSystemHandler();

    @Test
    public void shouldExist() {
        assertTrue(testedObject.folderExists("."));
    }

    @Test
    public void shouldNotExist() {
        assertFalse(testedObject.folderExists("./dazdzadzadazdzadaza"));
    }

    @Test
    public void shouldDisplayAll() {
        testedObject.showFolderTree(".", false);
    }

    @Test
    public void shouldDisplayOnlyFolders() {
        testedObject.showFolderTree(".", true);
    }

    @Test
    public void shouldMoveFileToParentFolder() throws IOException {
        File tempFile = File.createTempFile("tp4", ".txt");
        System.out.println("tempFile : " + tempFile.getAbsolutePath());

        testedObject.moveFileToParentFolder(tempFile.getAbsolutePath());
    }


}
