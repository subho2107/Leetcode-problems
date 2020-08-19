import java.util.*;

public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        for (int pos = 0; pos < words.length; pos++) {
            StringBuilder word = new StringBuilder(words[pos]);
            char firstChar = word.charAt(0);
            if (!vowels.contains(firstChar)) {
                word = new StringBuilder(word.substring(1) + firstChar);
            }
            word.append("ma");
            word.append("a".repeat(pos + 1));
            words[pos] = word.toString();
        }
        return String.join(" ", words);
    }
}
