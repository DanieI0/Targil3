import java.util.Scanner;

public class Exercise5 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String s = scanner.nextLine();
        System.out.println(editString(s));
    }

    public static String editString(String s) {
        char[] charFrequency = charFrequency(countArr(s));
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == charFrequency[0])
                result += charFrequency[1];
            else if(s.charAt(i) == charFrequency[1])
                result += charFrequency[0];
            else
                result += s.charAt(i);
        }
        return result;
    }

    public static int[] countArr(String s) {
        int[] charCount = new int[128];
        for (int i = 0; i < s.length(); i++)
            charCount[s.charAt(i)]++;
        charCount[' '] = 0;
        return charCount;
    }

    public static char[] charFrequency(int[] charCount) {

        int max = charCount[0];
        int index = 0;
        for(int i = 0; i < charCount.length; i++)
            if(max < charCount[i]) {
                max = charCount[i];
                index = i;
            }
        int index2 = (index + 1 < charCount.length) ? index + 1 : index - 1;
        int max2 = charCount[index2];
        for(int i = 0; i < charCount.length; i++)
            if(max2 < charCount[i] && i != index) {
                max2 = charCount[i];
                index2 = i;
            }
        char[] charFrequency = new char[2];
        charFrequency[0] = (char)index;
        charFrequency[1] = (char)index2;

        return charFrequency;
    }
}