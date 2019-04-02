package com.caihao.webdemo2.nowcoder;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/3/30 14:45
 */
public class ReOrderArray {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    new ReOrderArray().reOrderArray(array);

  }

  private void reOrderArray(int[] array) {
    int[] arr = Arrays.copyOf(array, array.length);
    int i = 0;
    int j = arr.length - 1;
    int m = i;
    int n = j;
    for (; i < arr.length; i++, j--) {
      if (arr[i] % 2 == 1) {
        array[m++] = arr[i];
      }
      if (arr[j] % 2 == 0) {
        array[n--] = arr[j];
      }
    }
    for (int k = 0; k < array.length; k++) {
      System.out.print(array[k] + "\t");
    }
  }
}
