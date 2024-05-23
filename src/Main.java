import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private static void countEachLetter(String str) {
        String strLowerCase = str.toLowerCase();
        char[] letters = strLowerCase.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char letter : letters) {
            if (letter == ' ') continue;
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        map.forEach((key, value) -> {
            result.append(key).append("=").append(value).append(", ");
        });

        String output = result.substring(0, result.length() - 2);
        System.out.println(output);
    }

    public static String groupLetters(String[] letters) {
        Map<Character, Integer> map = getCharacterIntegerMap(letters);

        Stream<Map.Entry<Character, Integer>> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()));

        StringBuilder result = new StringBuilder();
        sorted.forEach(entry -> {
            if (entry.getValue() > 1) {
                entry.setValue(1);
            }
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        });

        return result.toString();
    }

    private static Map<Character, Integer> getCharacterIntegerMap(String[] letters) {
        StringBuilder arrToString = new StringBuilder();
        for (String s : letters) {
            arrToString.append(s);
        }

        char[] lettersChar = arrToString.toString().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : lettersChar) {
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }
        return map;
    }

    private static void runApp() {
        // Count Each Letter
        String input1 = "We Always Mekar";
        String input2 = "coding is fun";

        System.out.println("Count Each Letter");
        System.out.println("-".repeat(20));
        countEachLetter(input1);
        countEachLetter(input2);

        // Group Sorted Letters
        String[] letters = {"Abc", "bCd"};
        String[] letters2 = {"Oke", "One"};
        String[] letters3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

        System.out.println("\nGroup Sorted Letters");
        System.out.println("-".repeat(20));
        System.out.println(groupLetters(letters));
        System.out.println(groupLetters(letters2));
        System.out.println(groupLetters(letters3));
    }

    public static void main(String[] args) {
        runApp();
    }
}