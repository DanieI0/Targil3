public class Exercise4 {

    public static void main(String[] args) {
        int[] arr = {5,7,8,6,9};
       fullArrayCheck(arr);
    }

    public static boolean fullArrayCheck(int[] a) {
        if (isFullArray(a)) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                       return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean isFullArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int count;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = min; i <= max; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i)
                    count++;
            }
            if (count != 1) return false;
        }
        return true;
    }

}