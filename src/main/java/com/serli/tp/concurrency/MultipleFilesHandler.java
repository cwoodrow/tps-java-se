package com.serli.tp.concurrency;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;

public class MultipleFilesHandler {
    public void copyFiles(String sourceFolder, String destinationFolder, int nbThreads) {
        checkArgument(sourceFolder != null);
        checkArgument(destinationFolder != null);
        checkArgument(nbThreads > 0);

        File source = new File(sourceFolder);
        checkArgument(source.exists() && source.isDirectory());

        final File destinationParent = new File(destinationFolder);
        checkArgument(destinationParent.exists() && destinationParent.isDirectory());

        ExecutorService executorService = Executors.newFixedThreadPool(nbThreads);

        System.out.println(source.getAbsolutePath());
        for (final File child : source.listFiles()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("copying " + child.getAbsolutePath() + " to : " + destinationParent.getAbsolutePath());
                    copyOneFile(Paths.get(child.getAbsolutePath()), Paths.get(destinationParent.getAbsolutePath() + File.separator + child.getName()));
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void copyOneFile(Path source, Path destination) {

        try {
            Files.copy(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("moved source to  : " + destination);
    }
}
