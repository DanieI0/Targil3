public class Exercise2 {

    public static void main(String[] args) {
        int[] arr1 = {2,9,11};
        int[] arr2 = {135,234,45,263,54,74};
        System.out.println((findCloseness(arr1, arr2)));
    }


    public static int findCloseness(int[] a, int[] b) {
        int index = 0;
        int closeness = 0;
        int current = 0;
        int j = 0;
        int i = 0;
        while (j < a.length && i < b.length) {
            if (a[j] == addNum(b[i])) {
                closeness++;
            }
            i++;
            if (i > b.length-1) {
                i = 0;
                if (closeness >= current && closeness > 0) {
                    current = closeness;
                    closeness = 0;
                    index = j;
                }
                j++;
            }
              }
        return index;
    }

    public static int addNum(int num){
        int result = 0;
        while (num > 0) {
            int n = num % 10;
            num /= 10;
            result = n + result;
        }
        return result;
    }
}