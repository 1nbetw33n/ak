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
    final protected static String hexStringToAsciiString(final String IN){
        return null;
    }

    //HELPER_METHOD for XOR-ing 2 hex_strings
    final protected static String xorHexStrings(String hexIn1, String hexIn2){
        return (new BigInteger(hexIn1, 16).xor(new BigInteger(hexIn2, 16))).toString(16);
    }



    final protected static String encrypt (final String PLAINTEXT, final String KEY){
        //conversion to hex-strings
        StringBuilder hexPlain = new StringBuilder(asciiStringToHexString(PLAINTEXT));
        StringBuilder hexKey   = new StringBuilder(asciiStringToHexString(KEY));

        //plain text XOR key
        return xorHexStrings(hexPlain.toString(), hexKey.toString());
    }


    final protected static String decrypt (String plainText, String key){
       return null;
    }



}

