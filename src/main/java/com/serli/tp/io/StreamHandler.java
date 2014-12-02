package com.serli.tp.io;

import com.google.common.base.Preconditions;

import java.io.*;

import static com.google.common.base.Preconditions.checkArgument;

public class StreamHandler {
    public void stringToFile(String content, File destination) {
        checkArgument(content != null && !content.isEmpty());
        checkArgument(destination != null);

        try (InputStream inputStream = new ByteArrayInputStream(content.getBytes());
             OutputStream outputStream = new FileOutputStream(destination);
        ) {
            int read;
            while ((read = inputStream.read()) != -1) {
                outputStream.write(read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
