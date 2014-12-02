package com.serli.tp.io;

import com.google.common.base.Preconditions;

import java.io.*;

import static com.google.common.base.Preconditions.checkArgument;

public class TextFileHandler {
    void readShowAndWriteFile(File source, File destination) throws IOException {
        checkArgument(source != null && source.exists());
        checkArgument(destination != null);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }

    }
}
