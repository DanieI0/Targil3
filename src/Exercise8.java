import java.util.Scanner;

public class Exercise8 {

    public static final int STRING_SIZE = 4;

    public static void main(String[] args) {
        System.out.println(popularSub(getStr()));
    }

    public static String[] getStr() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[] strArr = new String[1];
        System.out.println("Enter a string: ");
        String strInput = scanner.next();
        strArr[count] = strInput;
        count++;
        while (strInput.length() > STRING_SIZE) {
            if (count == strArr.length) {
                strArr = increaseSize(strArr);
            }
            System.out.println("Enter a string: ");
            strInput = scanner.next();
            strArr[count] = strInput;
            count++;

        }
            return strArr;
    }

    public static String[] subString(String str) {
        String[] substrings = new String[(str.length() - 1) * str.length() / 2];
        String tempStr;
        int index = 0;
        int subSize = 2;
        while(index < substrings.length) {
            for(int i = 0; i < str.length() - (subSize - 1); i++) {
                tempStr = "";
                for(int j = 0; j < subSize; j++)
                    tempStr += str.charAt(i + j);
                substrings[index] = tempStr;
                index++;
            }
            subSize++;
        }
        return substrings;
    }

    public static String popularSub(String[] str) {
        String[] allSubs;
        int size1;
        int sizeRes = 0;
        for (String s : str) {
            size1 = (s.length() - 1) * s.length() / 2;
            sizeRes += size1;

        }
        allSubs = new String[sizeRes];
        String[] temp;
        String popularSub = "";
        int count = 0;
        int prevCount = 0;

        for (int o = 0; o < allSubs.length; ) {
            for (int i = 0; i < str.length; i++) {
                String subStr = str[i];
                temp = subString(subStr);
                for (int j = 0; j < temp.length; j++) {
                    allSubs[o] = temp[j];
                    o++;
                }
            }
        }
        for (int n = 0; n<allSubs.length; n++){
            for (int k = 0; k<allSubs.length; k++){
                if (stringEquals(allSubs[n], allSubs[k])) {
                    count++;

                }
            }
            if (count > prevCount) {
                prevCount = count;
                popularSub = allSubs[n];
            }
            count = 0;
        }
        if (prevCount == 1) {
            popularSub = "there is no popular substring";
        }
        return popularSub;
    }
    public static boolean stringEquals(String str, String str2){
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            for ( int j = 0; j<str2.length(); j++) {
                if (str.length() == str2.length()) {
                     if (str.charAt(j) == str2.charAt(j)) {
                        count++;
                    }
                    if (count == str.length()) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static String[] increaseSize(String[] str){

        String[] newArr = new String[str.length + 1];
        for(int i = 0; i < str.length; i++) {
            newArr[i] = str[i];
        }
        return newArr;
    }
}
