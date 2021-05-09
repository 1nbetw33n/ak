package exercise1;

final class Shift_cipher {

    private java.lang.String out;
    private int k;


    public Shift_cipher(final java.lang.String OUT, final int K){
        this.out = OUT;
        this.k = K;
    }

    public String toString(){
        return "" + this.out + " | " + this.k;
    }


    final private static Shift_cipher encrypt(java.lang.String in, final int K, final int N){
        /*
         E k (x) = (x + k) mod N
         in = message that we want to encrypt
         K = KEY
         N = number of letters in alphabet
        */
        in = in.toLowerCase();
        java.lang.StringBuilder out = new StringBuilder();

        for (char c : in.toCharArray()){
            if (c != ' '){
                int original_alphabet_position = c - 'a';
                int new_alphabet_position = (original_alphabet_position + K) % N;
                char new_char = (char) ('a' + new_alphabet_position);
                out.append(new_char);
            } else {
                out.append(c);
            }
        }
        return new Shift_cipher(out.toString(), K);
    }


    final private static Shift_cipher decrypt(java.lang.String in, final int K, final int N){
        /*
         D k (y ) = (y − k) mod N
         in = message that we want to decrypt
         K = KEY
         N = number of letters in alphabet
        */

        return Shift_cipher.encrypt(in, N - (K % N), N);
    }


   /* final private static String break_encryption (java.lang.String in, final int K, final double[] PROBABILITIES){
         D k (y ) = (y − k) mod N
         in = message that we want to decrypt
         K = KEY
         N = number of letters in alphabet

        in = in.toLowerCase();
        char[] in_as_chars = new char[in.length()];
        java.lang.String out = new String();
        final int N = PROBABILITIES.length;
        java.lang.String finalIn = in;
        double[] expected_letters_frequencies = java.util.Arrays.stream(PROBABILITIES)
                .map(probability -> probability * finalIn.length)
                .toArray();
        double[] chi_squares = new double[PROBABILITIES.length];
        for (int key =0; key < chi_squares.length; key++){
            java.lang.String decrypted_message =
        }
        for (int i = 0; i < in.length(); i++){
            in_as_chars[i] = in.charAt(i);
        }
        for (int i = 0; i < in.length(); i++){
            out += in_as_chars[i];
        }
        return out;
    }*/


    final public static void main (final java.lang.String[] ARGS){
        double[] probability_distribution_of_german = new double[]{.0651, .0189,.0306, .0508, .1741, .0166, .0301, .0476, .0755, .027,
                .0121, .0344, .0253, .0978, .0251, .0079, .0002, .07, .0789, .0615, 0.0435, .0067, .0189, .0003,
                .0004, .0113};
        //System.out.println(encrypt("HE TOLD ME I COULD NEVER TEACH A LLAMA TO DRIVE", 3, 26));
        for (int i = 0; i < 26; i++){
            System.out.println(decrypt("ENWPZXEJQY", i, 26));
        }
    }
}

