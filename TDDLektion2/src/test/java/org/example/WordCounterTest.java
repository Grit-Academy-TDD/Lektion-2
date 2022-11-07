package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest extends WordCounter {
    WordCounter wordCounter = null;

    @BeforeEach
    public void setUp() {
        wordCounter = new WordCounter();
    }

    @AfterEach
    public void tearDown() {
        wordCounter = null;
    }

    @Test
    public void emptyString() {
        wordCounter.add("");
        assertEquals(0, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void oneWord() {
        wordCounter.add("Grit");
        assertEquals(1, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void manyWord() {
        wordCounter.add("Grit Academy");
        assertEquals(2, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void twoSimilarWords() {
        wordCounter.add("Java Java");
        assertEquals(1, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void manyWordsWithIdenticalWordsInside() {
        wordCounter.add("Hello my name name is is is is is Björn");
        assertEquals(5, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void textWithCaseSensative() {
        wordCounter.add("Hello my Name nAme name is Is iS is is Björn");
        assertEquals(5, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void textWithSymbols() {
        wordCounter.add("?Hello! hello? Hello, HELLO?");
        assertEquals(1.00001, wordCounter.getUniqueWordAmount(), 0.0001, "Message vid misslyckande test");
    }

    @Test
    public void textWithManySpaces() {
        wordCounter.add("    Hello                 my              name");
        assertEquals(3, wordCounter.getUniqueWordAmount());
    }

    @Test
    public void textIsNull() {
        wordCounter.add(null);
        assertEquals(0, wordCounter.getUniqueWordAmount());
    }

    @Test
    @Disabled("With Disabled annotation, we disable a certain test")
    public void checkSpeed() {
        assertTimeout(Duration.ofMillis(5), () -> WordCounter.longLoop());
    }

    @Test
    public void checkSpeedAndStopIfNotPassed() {
        assertTimeoutPreemptively(Duration.ofMillis(5), () -> WordCounter.longLoop());
    }

}