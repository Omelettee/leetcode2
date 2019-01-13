/***
 *
 * LC 408 easy String
 *
 *  Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 *
 * A string such as "word" contains only the following valid abbreviations:
 *
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 *
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 *
 * Example 1:
 *
 * Given s = "internationalization", abbr = "i12iz4n":
 *
 * Return true.
 *
 * Example 2:
 *
 * Given s = "apple", abbr = "a2e":
 *
 * Return false.
 */


public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr){
        if (word == null || abbr == null) return false;
        int i = 0; // index of word
        int count = 0; // number of accumulated letters

        for (char c : abbr.toCharArray()){

            if (count == 0 && c == '0') return false;
            if (c >= '0' && c <= '9') count = count * 10 + (c - '0'); // character could be treated to an int
            else {
                i += count;
                if (i >= word.length() || c != word.charAt(i)) {
                    return false;
                }
                count = 0;
                i++;
            }

        }

        //System.out.println(i+count);
        return i + count == word.length();

    }

    public static void main (String[] args){
        String s = "internationalization";
        String abbr = "i12iz4n";
        ValidWordAbbreviation test = new ValidWordAbbreviation();
        System.out.println(test.validWordAbbreviation(s, abbr));
    }


}
