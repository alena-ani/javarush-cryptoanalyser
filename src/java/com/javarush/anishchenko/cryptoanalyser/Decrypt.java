package src.java.com.javarush.anishchenko.cryptoanalyser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Decrypt {

    public void decrypt(int cypherKey, String inputPath, String resultFile) {
        try (BufferedReader bufferedReader = FileUtil.getNewBufferedReader(inputPath);
             BufferedWriter bufferedWriter = FileUtil.getNewBufferedWriter(resultFile)) {

            int c;
            while ((c = bufferedReader.read()) != -1) {
                char character = (char) c;
                bufferedWriter.write(Alphabet.getDecryptedСharacter(character, cypherKey));
                bufferedWriter.flush();
            }
            System.out.println("Ваш расшифрованный текст находится в файле " + resultFile);
        } catch (IOException e) {
            System.out.println("Не удалось расшифровать файл. Произошла ошибка");
            System.err.println(e.getMessage());
        }
    }
}
