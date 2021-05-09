package exercise1;

import java.util.Random;

public class Vigenere_cipher {

    final private String out;
    final private char[] KEY;


    public Vigenere_cipher(final String OUT, final char[] KEY){
        this.out = OUT;
        this.KEY = KEY;
    }


    final public String toString() {
        StringBuilder key_as_string = new StringBuilder();
        if (this.KEY != null) {
            for (int i = 0; i < this.KEY.length; i++) {
                key_as_string.append(this.KEY[i]);
            }
        }
        return this.out + "  |  " + key_as_string;
    }


    private final static String randomize(final String ALPHABET){
        StringBuilder keyword = new StringBuilder();
        java.util.Random random = new Random();
        int length = Vigenere_cipher.rng(ALPHABET.length());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(ALPHABET.length());
            char random_char = ALPHABET.charAt(j);
            keyword.append(random_char);
        }
        return keyword.toString();
    }


    final private static int rng(final int IN_LENGTH){
        java.util.Random random = new java.util.Random();
        return random.nextInt(IN_LENGTH - (IN_LENGTH / 2)) + (IN_LENGTH / 2);
    }


    final private static String get_alphabet(final String ALPHABET){
        String latin = "abcdefghijklmnopqrstuvwxyz";
        switch (ALPHABET){
            default: return latin;
        }
    }



    //TODO: statt kauderwelsch nen ordentlich verschlüsselten string haben
    final private static Vigenere_cipher encrypt(String in, final String KEYWORD, final String ALPHABET, final boolean KEY_GIVEN){
        char[] input = in.toUpperCase().replaceAll("\\s+","").toCharArray();
        char[] out = new char[input.length];
        char[] key = new char[input.length];
        StringBuilder str = new StringBuilder();
        int i,
            j;
        String keyword;
        if (KEY_GIVEN){
            keyword = KEYWORD;
        } else {
            keyword = Vigenere_cipher.randomize(ALPHABET);
        }
       for (i = 0, j = 0; i < input.length; i++, j++) {
           if (j == keyword.length()) {
               j = 0;
           }
           key[i] = keyword.charAt(j);
       }
       for (i = 0; i < input.length; i++){
           str.append((((input[i] + key[i] % 26) + 'A')));
           //out[i] = (char) (((input[i] + key[i] % 26) + 'A'));
       }
           /*for (int i = 0; i < out.length; i++){
           int result = (input[i] + key[i % key.length] - 194) % ALPHABET_LENGTH + 97;
           out[i] = (char) result;
        }*/
        for (i = 0; i < out.length; i++){
            out[i] = (char) str.charAt(i);
        }

        return new Vigenere_cipher(new String(out),key);
    }


    final private static Vigenere_cipher decrypt(String in, final String KEYWORD, final int ALPHABET_LENGTH){
        char[] input = in.toUpperCase().replaceAll("\\s+","").toCharArray();
        char[] out = new char[input.length];
        char[] key = new char[input.length];
        int i,
            j;
        for (i = 0, j = 0; i < input.length; i++, j++) {
            if (j == KEYWORD.length()) {
                j = 0;
            }
            key[i] = KEYWORD.charAt(j);
        }
        for (i = 0; i < input.length; i++){
            out[i] = (char) ((((input[i] - key[i] + 26) % 26) + 'A'));
        }
        return new Vigenere_cipher(new String(out), new char[]{});
    }


    final public static void main(final String[] ARGS){
        System.out.println(Vigenere_cipher.encrypt("JAVAHUNGRYBLOG", "LEMON", Vigenere_cipher.get_alphabet("latin"), true));
        System.out.println((Vigenere_cipher.decrypt("tdcnysyozikxdjxhbbpsisxdk", "VIGENERECIPHER", 26)));
    }



}

