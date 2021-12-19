public class Exercise1 {


    public static void main(String[] args) {
        int[] arr = {134,3593,2935,4263,4361,1824,5939};
        System.out.println(indexOfChangeableNumber(arr));
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

    public static int indexOfChangeableNumber(int[] arr){
        int smallestNum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i<arr.length; i++) {
            if (checkNum(arr[i])) {
                if (addNum(arr[i]) <= smallestNum) {
                    smallestNum = addNum(arr[i]);
                    index = i;
                }
                } else if (i > arr.length - 1){
                return -1;
            }
        }
        return index;
    }

    public static boolean checkNum(int num) {
        int current = -1;
        while (num > 0) {
        if (current == num % 2) {
            return false;
            }
        current = num % 2;
        num /= 10;
        }
        return true;
    }
}