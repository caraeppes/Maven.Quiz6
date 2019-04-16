package rocks.zipcode.io.fundamentals;

import java.util.Arrays;
import java.util.List;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {
        return new String(chars);
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
        String string = "";
        for(Character c : chars){
            string += c;
        }
        return string;
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {
        return removeSpecifiedCharacters(string, "aeiouAEIOU");
    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {
        String result = "";
        List<String> toRemove = Arrays.asList(charactersToRemove.split(""));
        for(String s : string.split("")){
            if(!toRemove.contains(s)){
                result += s;
            }
        }
        return result;
    }

}
