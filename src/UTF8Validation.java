/**
 * LC 393 mediun bit manipulation
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 *     For 1-byte character, the first bit is a 0, followed by its unicode code.
 *     For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 *
 * This is how the UTF-8 encoding would work:
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
 *
 * Example 1:
 *
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 *
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 *
 * Example 2:
 *
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 *
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 *
 */


public class UTF8Validation {

    // naive - self created method
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return true;

        int i = 0;
        while (i < data.length){
            String biStr = Integer.toBinaryString(data[i]);
            if (biStr.length() > 8) return false;
            if (biStr.length() < 8) {
                i++;
                continue;
            }

            int numberOfByte = 0;
            char[] biChar = biStr.toCharArray();
            for (int k = 0; k < biChar.length; k++){
                if (biChar[k] == '1') numberOfByte++;
                else break;
            }
            if (numberOfByte == 1 || numberOfByte > 4 || (i + numberOfByte) > data.length) return false;

            for (int k = i + 1; k < i + numberOfByte; k++){
                if ((data[k] & 1<<7) == 0 || (data[k] & (1 << 6)) != 0)
                    return false;
            }
            i += numberOfByte;
        }

        return true;
    }

    //learned from the submission -> very good method
    public boolean validUtf82(int[] data) {
        if (data == null || data.length == 0) return true;

        int index = 0;
        while(index < data.length){
            if (data[index] > 255) return false;

            int step = 0;
            if ((data[index] & 1 << 7) == 0) {
                index++;
                continue;
            } else if ((data[index] & 7 << 5) == 192) {
                step = 2;
            } else if ((data[index] & 15 << 4) == 224){
                step = 3;
            } else if ((data[index] & 31 << 3) == 240) {
                step = 4;
            } else {
                return false;
            }

            if ((index + step - 1) >= data.length) {
                return false;
            }

            for (int k = index + 1; k < index + step; k++){
                if ((data[k] & 3 << 6) != 128) {
                    return false;
                }
            }
            index += step;
        }
        return index == data.length;
    }
}



