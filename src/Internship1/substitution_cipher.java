package Internship1;

import java.util.*;
import java.util.stream.Collectors;

public class substitution_cipher {


    final protected static String decrypt_cipher(String in, String keyword){
        StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        char encrypted_char;
        int encrypted_value;
        char new_encrypted_char;
        StringBuilder out = new StringBuilder();

        keyword = keyword.toLowerCase();
        in = in.toLowerCase();

        keyword = keyword.replaceAll("(.)(?=.*\\1)", "");
        StringBuilder new_value = new StringBuilder(keyword);

        //looping through alphabet and add remainder to new_value
        for (int i = 0; i < alphabet.length(); i++){
            encrypted_char = alphabet.charAt(i);

            //checking if char exists in new key
            if (new_value.indexOf(String.valueOf(encrypted_char)) < 0){
                new_value.append(alphabet.charAt(i));
            }
        }

        //looping through given text
        for (int j = 0; j < in.length(); j++){
            if (in.charAt(j) >= 'a' && in.charAt(j) <= 'z') {
                encrypted_char = in.charAt(j);

                //checking index of char
                encrypted_value = new_value.indexOf(String.valueOf(encrypted_char));

                //picking corresponding char at new_value
                new_encrypted_char = alphabet.charAt(encrypted_value);
                out.append(new_encrypted_char);
            } else {
                out.append(in.charAt(j));
            }
        }

        return out.toString();
    }


    final protected static String get_keyword (String in){
        StringBuilder keyword = new StringBuilder();
        in = in.toLowerCase();

        //frequencies for german language
        final char[] GERMAN_LETTERS = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".replaceAll(",", "").toCharArray();
        final int[] GERMAN_LETTERS_FREQS = new int[]{651, 188, 306, 508, 1741, 166, 301, 476, 755, 27, 121, 344, 253, 978, 251, 79, 2, 7, 789, 615, 435, 67, 189, 3, 4, 113};

        //creating HashMap for frequency of german language
        Map<Character, Integer> frequencies_of_german_language = new HashMap<>();
        for (int i = 0; i < GERMAN_LETTERS.length; i++){
            frequencies_of_german_language.put(GERMAN_LETTERS[i], GERMAN_LETTERS_FREQS[i]);
        }

        //frequencies for given text
        Map<Character, Integer> frequencies_of_in = new LinkedHashMap<>();
        for (Character key :  in.toCharArray()){
            if (key >= 'a' && key <= 'z'){
                frequencies_of_in.merge(key, 1, Integer::sum);
            }
        }

        //swapping keys and values
        Map<Integer, Character> swapped_frequencies_of_in = frequencies_of_in.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        Map<Integer, Character> swapped_frequencies_of_german_language = frequencies_of_german_language.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        //sorting it by using TreeMap
        TreeMap<Integer, Character> sorted_frequencies_of_in = new TreeMap<>(swapped_frequencies_of_in);
        TreeMap<Integer, Character> sorted_frequencies_of_german_language = new TreeMap<>(swapped_frequencies_of_german_language);

       //converting values of TreeMaps to collections for convenience
        Collection<Character> old_chars = sorted_frequencies_of_german_language.values();
        Collection<Character> new_chars = sorted_frequencies_of_in.values();

        //creating iterators for the 2 collections
        Iterator<Character> iterator_old_chars = old_chars.iterator();
        Iterator<Character> iterator_new_chars = new_chars.iterator();

        //replace every letter in given text
        while (iterator_new_chars.hasNext() && iterator_old_chars.hasNext()) {
            char old_char = iterator_old_chars.next();
            char new_char = iterator_new_chars.next();
               in = in.replace(old_char, new_char);
        }

        return in;
    }
}
