package com.serli.tp.io;

import com.google.common.base.Preconditions;

import java.io.File;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

public class FileSystemHandler {
    public boolean folderExists(String folderPath) {
        File file = new File(folderPath);
        return file.exists() && file.isDirectory();
    }

    public void showFolderTree(String folderPath, boolean showOnlyFolders) {
        checkArgument(folderPath != null);
        File rootFile = new File(folderPath);

        String[] filesList = rootFile.list();
        if (filesList != null) {
            for (String filePath : filesList) {
                File file = new File(filePath);
                if (showOnlyFolders && file.isDirectory() || !showOnlyFolders) {
                    System.out.println(file.getAbsoluteFile());
                    showFolderTree(filePath, showOnlyFolders);
                }
            }
        }
    }

    public void moveFileToParentFolder(String filePath) {
        checkArgument(filePath != null);
        File file = new File(filePath);

        String tempFilePath = filePath + UUID.randomUUID().toString();
        File tempFile = new File(tempFilePath);
        file.renameTo(tempFile);

        File folder = new File(filePath);
        folder.mkdir();


        File newFileLocation = new File(filePath + File.separator + "tpJava4.txt");
        tempFile.renameTo(newFileLocation);
    }
}
