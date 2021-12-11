public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = {14, 13, 27, 10,10, 35, 19, 42, 44};
        int[] rtn = bsort(arr);
        for (int ele : rtn) {
            System.out.print(ele+"\t");
        }
    }

    private static int[] bsort(int[] arr) {
        int temp;
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length-1 ; i++) {
                if (arr[i] > arr[i + 1]) {
                    //XOR SWAPING
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i] ;
                    arr[i] = temp;
                }
            }


        }
        return arr;
    }
}
