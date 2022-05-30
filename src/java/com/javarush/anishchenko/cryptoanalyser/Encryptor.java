package src.java.com.javarush.anishchenko.cryptoanalyser;

import java.io.*;

public class Encryptor {

    public void encrypt(int cypherKey, String inputPath, String resultFile) {
        try (BufferedReader bufferedReader = FileUtil.getNewBufferedReader(inputPath);
             BufferedWriter bufferedWriter = FileUtil.getNewBufferedWriter(resultFile)) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                char character = (char) c;
                String cipheredCharacter = Alphabet.getCypheredCharacter(character, cypherKey);
                bufferedWriter.write(cipheredCharacter);
                bufferedWriter.flush();
            }
            System.out.println("Ваш зашифрованный текст находится в фаиле " + resultFile);
        } catch (IOException e) {
            System.out.println("Не удалось зашифровать файл. Произошла ошибка");
            System.err.println(e.getMessage());
        }
    }
}
