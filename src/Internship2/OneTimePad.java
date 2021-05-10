package Internship2;


import java.math.BigInteger;

public class OneTimePad {




    //HELPER_METHOD for string -> hex conversion
    final protected static String stringToHexString(String in){
        StringBuffer buffer = new StringBuffer();
        char[] chars        = in.toCharArray();
        for (Character c : chars) {
            String hexString = Integer.toHexString(c);
            buffer.append(hexString);
        }
        return buffer.toString();
    }


    //HELPER_METHOD for XOR-ing 2 hex_strings
    final protected static String xorHexStrings(String hexIn1, String hexIn2){
        return (new BigInteger(hexIn1, 16).xor(new BigInteger(hexIn2, 16))).toString();
    }//TODO: herausfinden, wo ich bin und was ich tue(n muss)



    final protected static String encrypt (String plainText, String key){

        StringBuilder encryptedMessage = new StringBuilder();
        char letter;
        int  index = 0;

        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        //step1: message + key
        for (int i = 0; i < plainText.length(); i++){
            index = plainText.toCharArray()[i] + key.toCharArray()[i];

            //step2: (message + key) mod 26
            index = (index < 26) ? index : index % 26;

            //step3: converting to cipher text
            letter = (char) ('A' + index);
            encryptedMessage.append(letter);
        }

        return encryptedMessage.toString();
    }


    final protected static String decrypt (String plainText, String key){

        StringBuilder decryptedMessage = new StringBuilder();
        char letter;
        int  index = 0;

        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        //step1: message - key
        for (int i = 0; i < plainText.length(); i++){
            index = plainText.toCharArray()[i] - key.toCharArray()[i];

            //step2: (message - key) mod 26
            index = (index > 0) ? index : index +26;

            //step3: converting to plain text
            letter = (char) ('A' + index);
            decryptedMessage.append(letter);
        }

        return decryptedMessage.toString();
    }



}

