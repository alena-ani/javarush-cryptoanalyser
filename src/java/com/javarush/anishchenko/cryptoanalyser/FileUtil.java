package src.java.com.javarush.anishchenko.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtil {

    public static boolean isValidFile(String inputPath) {
        return Files.isRegularFile(Path.of(inputPath)) || Files.exists(Path.of(inputPath));
    }

    public static BufferedWriter getNewBufferedWriter(String s) throws IOException {
        return new BufferedWriter(new FileWriter(s));
    }

    public static BufferedReader getNewBufferedReader(String inputPath) throws IOException {
        return new BufferedReader(new FileReader(inputPath));
    }

    private FileUtil() {
        throw new UnsupportedOperationException();
    }
}
