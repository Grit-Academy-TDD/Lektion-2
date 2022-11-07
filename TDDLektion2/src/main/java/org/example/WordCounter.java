package org.example;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    private int uniqueWordCounter = 0;

    protected void add(String str) {
        if (str == null) {
            return;
        }
        if (!str.isEmpty()) {
            Set<String> uniqueWords = new HashSet<>();
            for (String item : str.split("[ ?,!]")) {
                if (!item.isEmpty()) {
                    uniqueWords.add(item.toLowerCase());
                }
            }
            uniqueWordCounter = uniqueWords.size();
        }
    }

    protected int getUniqueWordAmount() {
        return uniqueWordCounter;
    }

    protected static void longLoop() {
        long counter = 0;
        while (counter < 100000000) {
            counter++;
        }
    }
}
