package src.java.com.javarush.anishchenko.cryptoanalyser;

import java.util.HashMap;
import java.util.Map;


public final class Alphabet {

    public static final char[] CHARACTERS = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З',
            'И', 'Й','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final int ALPHABET_SIZE = CHARACTERS.length;

    public static final Map<Character, Integer> ALPHABET_MAPPING;

    static {
        ALPHABET_MAPPING = new HashMap<>();
        for (int i = 0; i < CHARACTERS.length; i++) {
            ALPHABET_MAPPING.put(CHARACTERS[i], i);
        }
    }

    public static Integer getPosition(char c) {
        return ALPHABET_MAPPING.get(c);
    }

    public static String getCypheredCharacter(char c, int cypherKey) {
        Integer position = getPosition(c);
        if (position == null) {
            return "";
        }
        int cipheredPosition = (position + cypherKey % ALPHABET_SIZE) % ALPHABET_SIZE;
        return String.valueOf(CHARACTERS[cipheredPosition]);
    }

    public static String getDecryptedСharacter(char c, int cypherKey) {
        Integer position = getPosition(c);
        if (position == null) {
            return "";
        }
        if ((position - cypherKey % ALPHABET_SIZE) % ALPHABET_SIZE < 0) {
            int cipheredPosition = (ALPHABET_SIZE + position - cypherKey % ALPHABET_SIZE) % ALPHABET_SIZE;
            return String.valueOf(CHARACTERS[cipheredPosition]);
        } else {
            int cipheredPosition = (position - cypherKey % ALPHABET_SIZE) % ALPHABET_SIZE;
            return String.valueOf(CHARACTERS[cipheredPosition]);
        }

    }

    private Alphabet() {
        throw new UnsupportedOperationException();
    }
}
