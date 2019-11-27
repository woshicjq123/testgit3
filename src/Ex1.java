import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve(a, n);
    }
    /**
     *
     */
    public static void solve(int[] a, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result = Math.max(find(a, j, i), result);
            }
        }
        System.out.println(result);
    }

    public static int find(int[] a, int j, int i) {
        int max = 0;
        int subMax = 0;
        for (int k = j; k <= i; k++) {
            if (a[k] > max) {
                max = a[k];
            } else if (a[k] > subMax) {
                subMax = a[k];
            }
        }
        return max | subMax;
    }

    public static void solve1(int[] a, int n) {
        for (int i = 0; i < n; i++) {

        }
    }

    /**
     *  9 8 3 5 7
     *  遍历数组，设当前值为最大值一重循环，寻找次大值，
     */

    public static int solve2(int[] nums) {
        int first =0;
        int second = 0;
        int result =0;
        for (int i= 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                first = nums[i];
                second = nums[i + 1];
            }else {
                first = nums[i + 1];
                second = nums[i];
            }
            if ((first | second) > result)  {
                result = first | second;
            }
            for (int j = i + 2; j < nums.length; j ++) {
                if (nums[j] < second) {
                    continue;
                }else {
                    if (nums[j] >= first) {
                        int temp = first;
                        first = second;
                        second = temp;
                    }else {
                        second = nums[j];
                    }
                }
                if ((first | second) > result)  {
                    result = first | second;
                }
            }
        }
        return result;
    }

}
