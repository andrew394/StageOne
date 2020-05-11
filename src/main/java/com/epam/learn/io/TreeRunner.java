package com.epam.learn.io;

import java.io.*;

public class TreeRunner {

    private static final String FILE_PATH_WRITE = "src/main/resources/io/out.txt";
    private PrintWriter writer;

    public static void main(String[] args) {
        TreeRunner runner = new TreeRunner();
        File dir = new File(args[0]);
        if (dir.exists() && dir.isDirectory()) {
            try {
                runner.writer = new PrintWriter(FILE_PATH_WRITE);
                runner.writeToFile(dir);
                System.out.println("Wrote to file out.txt");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                runner.writer.close();
            }
        }
    }

    private void writeToFile(File file) {
        writer.println(file.getName());
        for (File currentFile : file.listFiles()) {
            if (currentFile.isDirectory()) {
                writeToFile(currentFile);
            } else if (currentFile.isFile()) {
                writer.println(" |- " + currentFile.getName());
            }
        }
    }
}
