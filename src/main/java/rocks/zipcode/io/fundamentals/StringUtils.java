package rocks.zipcode.io.fundamentals;


import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        List<String> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(i);
        }
        Set<Set<Integer>> powerSet = getPowerSet(set);
        for (Set<Integer> s : powerSet) {
            result.add(upperCaseIndices(string, s.toArray(new Integer[s.size()])));
        }
        return result;
    }

    public static <Integer> Set<Set<Integer>> getPowerSet(Set<Integer> set) {
        Set<Set<Integer>> sets = new HashSet<>();
        if (set.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<Integer> list = new ArrayList<>(set);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<Integer> integerSet : getPowerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(integerSet);
            sets.add(newSet);
            sets.add(integerSet);
        }
        return sets;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        String result = string;
        for (Integer i : indices) {
            result = replaceAtIndex(result, Character.toUpperCase(string.charAt(i)), i);
        }
        return result;
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        StringBuilder stringBuilder = new StringBuilder(stringToBeManipulated.substring(0, index));
        stringBuilder.append(valueToBeInserted).append(stringToBeManipulated.substring(index));
        return stringBuilder.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        StringBuilder stringBuilder = new StringBuilder(stringToBeManipulated.substring(0, index));
        stringBuilder.append(replacementValue).append(stringToBeManipulated.substring(index + 1));
        return stringBuilder.toString();
    }
}