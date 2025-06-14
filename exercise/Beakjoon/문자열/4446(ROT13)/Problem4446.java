import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution4446 {
    private final char[] vowels = { 'a', 'i', 'y', 'e', 'o', 'u' };
    private final char[] consonants = { 'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's',
            'r', 'l', 'm', 'f' };
    private String rot13;

    public Solution4446(String rot13) {
        this.rot13 = rot13;
    }

    public String solve() {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : rot13.toCharArray()) {
            decryptedText.append(decrypt(c));
        }

        return decryptedText.toString();
    }

    private char decrypt(char rot13Char) {
        if (!Character.isAlphabetic(rot13Char)) {
            return rot13Char;
        }

        boolean isLowerCase = Character.isLowerCase(rot13Char);
        char lowerRot13Char = Character.toLowerCase(rot13Char);
        char decryptedChar = (isVowel(lowerRot13Char)) ? rotate(lowerRot13Char, vowels, 3)
                : rotate(lowerRot13Char, consonants, 10);

        return (isLowerCase) ? decryptedChar : Character.toUpperCase(decryptedChar);
    }

    private boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) {
                return true;
            }
        }

        return false;
    }

    private char rotate(char c, char[] alphabets, int rotate) {
        int index = -1;

        for (int i = 0; i < alphabets.length; i++) {
            if (c == alphabets[i]) {
                index = i;
                break;
            }
        }

        return alphabets[(index - rotate + alphabets.length) % alphabets.length];
    }
}

public class Problem4446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while ((input = br.readLine()) != null) {
            bw.write(new Solution4446(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
