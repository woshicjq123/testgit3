import java.util.ArrayList;

public class Demo19Replicate {
    static int flag_Demo19;
    public static void main(String[] args) {
        int[] array = {2,5,1,2,3};
        quick_sort(array,0,array.length-1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1])
                arrayList.add(array[i]);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     *  1）当前位上的数字作为索引去进行元素交换，即item = array[i]; array[item]
     *  与item进行交换，直到array为止。
     *
     */

    /**
     * 找到一个重复数字就可以
     * 异常情况：数组为空  或者数组长度为0
     *
     */

    public static int replicate3(int []array){
        int a = 1;
        return a;
    }

    public static void quick_sort(int []array,int left,int right){
        int mid;
        if (left < right){
            mid = partition(array,left,right);
            quick_sort(array,left,mid-1);
            quick_sort(array,mid+1,right);
        }
    }

    /**
     * 找到一个元素 item 的在某一区间的正确索引
     * 1）left ，right
     * 2）从左边开始，如果左边的小于 item，则记其为temp
     * 3)然后从右边开始
     */
    public static int partition(int []array, int left, int right){
        //从后边找，找一个比基准元素小的
        int item = array[left];
        while (left < right) {
            while (left < right && array[right] >= item) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= item) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = item;
        return right;
    }
}
