package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (isValidWord(word)) {
            words.add(word);
        }
    }

    public List<String> getWords() {
        return words;
    }

    public boolean isThereAWordTwice() {
        for (String word : words) {
            List<String> tmp = new ArrayList<>(words);
            tmp.remove(word);
            if (tmp.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidWord(String s) {
        if (s.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        return true;
    }
}
