package Internship2;



public class OneTimePad {

    final protected static String stringToHex(String in){
        return null;
    }




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

