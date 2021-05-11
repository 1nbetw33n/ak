package Internship2;


import java.math.BigInteger;

public class OneTimePad {




    //HELPER_METHOD for ASCII string -> hex string conversion
    final protected static String asciiStringToHexString(final String IN){
        StringBuffer buffer = new StringBuffer();
        char[] chars        = IN.toCharArray();
        for (Character c : chars) {
            String hexString = Integer.toHexString(c);
            buffer.append(hexString);
        }
        return buffer.toString();
    }


    //HELPER METHOD for hex string -> ASCII string conversion
    final protected static String hexStringToAsciiString(String in){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i += 2) {
            String hexLetter = in.substring(i, i + 2);
            out.append((char) Integer.parseInt(hexLetter, 16));
        }
        return out.toString();
    }


    //HELPER_METHOD for XOR-ing 2 hex_strings
    final protected static String xorHexStrings(String hexIn1, String hexIn2){
        return (new BigInteger(hexIn1, 16).xor(new BigInteger(hexIn2, 16))).toString(16);
    }


    //here we do the encryption with a given key
    final protected static String encrypt (final String PLAINTEXT, final String KEY){
        //converts plain and key -> hex strings, then does plain text XOR key
        return xorHexStrings(asciiStringToHexString(PLAINTEXT), asciiStringToHexString(KEY));
    }


    //here we break the encryption with a given key
    final protected static String decrypt (final String CIPHER, final String KEY){
        //conversion to hex-strings
        StringBuilder hexCipher = new StringBuilder(asciiStringToHexString(CIPHER));
        StringBuilder hexKey   = new StringBuilder(asciiStringToHexString(KEY));

        //cipher text XOR key
        return xorHexStrings(hexCipher.toString(), hexKey.toString());
    }



}

