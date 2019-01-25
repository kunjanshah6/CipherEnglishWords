package cipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary
{
    private Set<String> wordsSet;

    // Constructor
    public Dictionary() throws IOException
    {
        Path path = Paths.get("src/cipher/words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.toLowerCase().split("\n");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }

    /**
     * @param word
     * @return
     */
    public boolean contains(String word)
    {
        return wordsSet.contains(word);
    }
}