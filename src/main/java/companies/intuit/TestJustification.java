package companies.intuit;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 */
public class TestJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        final int maxWidth = 16;

        System.out.println(fullJustify(words, maxWidth));
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> wordInCurrentLine = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int currentCharCount = 0;
        for (String word : words) {
            // add new word by adding at least 1 space
            if (wordInCurrentLine.size() >= 1 && currentCharCount + 1 + word.length() <= maxWidth) {
                wordInCurrentLine.add(word);
                currentCharCount += 1 + word.length();
            } else if (wordInCurrentLine.size() == 0) {
                wordInCurrentLine.add(word);
                currentCharCount = word.length();
            } else {
                result.add(getFormattedLine(wordInCurrentLine, maxWidth, false));
                wordInCurrentLine.clear();
                wordInCurrentLine.add(word);
                currentCharCount = word.length();
            }
        }
        result.add(getFormattedLine(wordInCurrentLine, maxWidth, true));

        return result;
    }

    private static String getFormattedLine(List<String> words, int maxWidth, boolean lastLine) {
        int wordCount = words.size();
        int charCount = 0;
        for (String w : words) {
            charCount += w.length();
        }

        if (wordCount == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(words.get(0));
            for (int i = 0; i < maxWidth - charCount; i++) {
                sb.append(" ");
            }

            return sb.toString();
        }

        int totalSpace = maxWidth - charCount;
        int spaceInBetween = totalSpace / (wordCount - 1);
        int remainderSpaces = totalSpace % (wordCount - 1);

        StringBuilder sb = new StringBuilder();
        int spacesAdded = 0;
        for (String w : words) {
            sb.append(w);
            int numberOfSpacesToAdded = lastLine ? 1 : spaceInBetween;
            if (spacesAdded + charCount == maxWidth) {
                break;
            }
            if (!lastLine && remainderSpaces > 0) {
                numberOfSpacesToAdded++;
                remainderSpaces--;
            }
            for (int i = 0; i < numberOfSpacesToAdded; i++) {
                sb.append(" ");
            }
            spacesAdded += numberOfSpacesToAdded;
        }

        while (lastLine && charCount + spacesAdded < maxWidth) {
            sb.append(" ");
            spacesAdded++;
        }

        return sb.toString();
    }
}
