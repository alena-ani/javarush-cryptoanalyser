package src.java.com.javarush.anishchenko.cryptoanalyser;

import java.util.Scanner;

public class Main {

    public static final String ENCRYPTED_FILENAME = "encrypted.txt";
    public static final String DECRYPTED_FILENAME = "decrypted.txt";

    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor();
        Decrypt decryptor = new Decrypt();
        int menuItem = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            try {String menuItemAsString = scanner.nextLine();
            menuItem = Integer.parseInt(menuItemAsString);}
            catch (NumberFormatException e) {
                System.err.println("Введен некорректный пункт меню. Произошла ошибка " +e.getMessage() );
            }
            switch (menuItem) {
                case 1: {
                    System.out.println("Введите ключ для шифровки текста");
                    String cypherKeyAsString = scanner.nextLine();
                    int cypherKey = Integer.parseInt(cypherKeyAsString);
                    if (cypherKey < 0) {
                        System.out.println("Вы ввели отрицательное значение ключа");
                    } else {
                        System.out.println("Введите путь к файлу, который вы хотите зашифровать");
                        String inputPath = scanner.nextLine();
                        if (FileUtil.isValidFile(inputPath)) {
                            encryptor.encrypt(cypherKey, inputPath, ENCRYPTED_FILENAME);
                        } else {
                            System.out.println("Файл по заданному пути нет или путь не корректный");
                        }
                    }
                }

                break;
                case 2: {
                    System.out.println("Введите ключ для шифровки текста");
                    String cypherKeyAsString = scanner.nextLine();
                    int cypherKey = Integer.parseInt(cypherKeyAsString);
                    if (cypherKey < 0) {
                        System.out.println("Вы ввели отрицательное значение ключа");
                    } else {
                        System.out.println("Введите путь к файлу, который вы хотите расшифровать");
                        String inputPath = scanner.nextLine();
                        if (FileUtil.isValidFile(inputPath)) {
                            decryptor.decrypt(cypherKey, inputPath, DECRYPTED_FILENAME);
                        } else {
                            System.out.println("Файл по заданному пути нет или путь не корректный");
                        }
                    }
                }
                break;

                case 3:
                    System.out.println("Введите количество вариантов расшифровки");
                    String cypherKeyAsString = scanner.nextLine();
                    int numberDecryption = Integer.parseInt(cypherKeyAsString);
                    System.out.println("Введите путь к файлу, который вы хотите расшифровать");
                    String inputPath = scanner.nextLine();

                    if (FileUtil.isValidFile(inputPath)) {
                        for (int i = 0; i < numberDecryption; i++) {
                            decryptor.decrypt(i, inputPath, "decrypted-" + i + ".txt");
                        }
                    } else {
                        System.out.println("Файл по заданному пути нет или путь не корректный");
                    }
                    break;
                case 4:
                    System.out.println("Завершение программы");
                    break;
                default:
                   System.out.println("Вы ввели неверное значение меню \n");
            }

        }
        while (menuItem != 4);
    }

    private static void printMenu() {
        System.out.println("Выберите пункт меню:\n" +
                "1 - шифрование текста\n" +
                "2 - расшифровка текста\n" +
                "3 - взлома зашифрованного текста\n" +
                "4 - выхода");
        System.out.println("Введите номер меню:");
    }

}







