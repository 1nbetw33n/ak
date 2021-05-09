package exercise1;

final class Permutation_cipher {

    private final String out;
    private final int[] how_to_encrypt;
    private final int[] how_to_decrypt;


    public Permutation_cipher(final String OUT, final int[] HOW_TO_ENCRYPT, final int[] HOW_TO_DECRYPT){
        this.out = OUT;
        this.how_to_encrypt = HOW_TO_ENCRYPT;
        this.how_to_decrypt = HOW_TO_DECRYPT;
    }


    final public java.lang.String toString(){
        StringBuilder encryption_string = new StringBuilder("{");
        StringBuilder decryption_string = new StringBuilder("{");
        for (int i = 0; i < how_to_encrypt.length; i++){
            encryption_string.append(how_to_encrypt[i]);
            decryption_string.append(how_to_decrypt[i]);
            if (i < how_to_encrypt.length - 1){
                encryption_string.append(", ");
                decryption_string.append(", ");
            }
        }
        encryption_string.append("}");
        decryption_string.append("}");
        return this.out +  "  |  " + encryption_string + "  |  " +  decryption_string + "  |  " + this.how_to_encrypt.length;
    }


    private final static int[] randomize(final int BLOCK_LENGTH){
        int[] out = new int[BLOCK_LENGTH];
        for (int i = 0; i < out.length; i++){
            out[i] = i;
        }
        java.util.Random random = new java.util.Random();
        for (int i = BLOCK_LENGTH - 1; i > 0; i--){
            int j = random.nextInt(i + 1);

            int tmp = out[i];
            out[i] = out[j];
            out[j] = tmp;
        }
        return out;
    }


    final private static int rng(final int MAX){
        java.util.Random random = new java.util.Random();
        return random.nextInt(MAX- 5) + 5;
    }


    final private static int[] inverse_permutation(int[] encryption_array){
        int[] decryption_array = new int[encryption_array.length];
        for (int j = 0; j < encryption_array.length; j++){
            decryption_array[encryption_array[j]] = j;
        }
        return decryption_array;
    }


    final private static Permutation_cipher encrypt(String in, final int BLOCK_LENGTH, final boolean GIVEN, final int[] GIVEN_ARRAY){
        /* in = input;
           block_length is used to generate pseudo-random array with length equal to block_length with no duplicates,
           then assign a block from in with length equal to block_length according to the position in the int_array;
           example: int_array with M = 5 -> [3, 5, 1, 4, 2]; that means chars[0] -> chars[3], chars[1] -> chars[5] etc.
         */
        in = in.toLowerCase();
        java.lang.StringBuilder out = new StringBuilder();
        int block_length;
        int[] encryption_array;
        if (GIVEN){
            block_length = BLOCK_LENGTH;
            encryption_array = GIVEN_ARRAY;
        } else {
            block_length = Permutation_cipher.rng(in.length());
            encryption_array = randomize(block_length);
        }
        int number_of_blocks = in.length() / block_length;
        if (in.length() % block_length != 0){
            number_of_blocks++;
        }
        int[] decryption_array;
        decryption_array = Permutation_cipher.inverse_permutation(encryption_array);
        char[][] chars = new char[number_of_blocks][block_length];
        char[][] tmp_chars = new char[number_of_blocks][block_length];
        int count = 0;
        for (int i = 0; i < chars.length; i++){
            for (int j = 0; j < chars[i].length; j++){
                if (count < in.length()){
                    chars[i][j] = in.charAt(count++);
                } else {
                    break;
                }
            }
        }
        for (int x = 0; x < chars.length; x++){
            for (int y = 0; y < chars[x].length; y++){
                tmp_chars[x][y] = chars[x][encryption_array[y]];
            }
        }
        chars = tmp_chars;
        for (int m = 0; m < chars.length; m++){
            for (int n = 0; n < chars[m].length; n++){
                if (chars[m][n] == ' '){
                    break;
                } else {
                    out.append(chars[m][n]);
                }
            }
        }
        return new Permutation_cipher(out.toString(), encryption_array, decryption_array);
    }


    final private static Permutation_cipher decrypt(final java.lang.String IN, final int[] DECRYPTION_ARRAY){
        return Permutation_cipher.encrypt(IN, DECRYPTION_ARRAY.length, true, DECRYPTION_ARRAY);
    }


    final public static void main(final java.lang.String[] ARGS){
        System.out.println(Permutation_cipher.encrypt("WhyCryptographyIsHarderThanItLooks", 10, true, new int[]{7, 8, 9, 2, 1, 0, 5, 4, 3, 6}));
        System.out.println(Permutation_cipher.encrypt("WhyCryptographyIsHarderThanItLooks", 10, false, new int[]{}));
        Permutation_cipher cipher_1 = Permutation_cipher.encrypt("4MGGVvR4Mm3dXjJm3dXjJ9455w0r7@kr4k3niGGVvR4Mm3dXjJ9v", 10, false, new int[]{});
        System.out.println(cipher_1);
        System.out.println(Permutation_cipher.decrypt(cipher_1.out, cipher_1.how_to_decrypt));



        //System.out.println(exercise1.Permutation_cipher.display_array(exercise1.Permutation_cipher.randomize(5)));
    }

}
