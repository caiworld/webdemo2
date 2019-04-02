package com.caihao.webdemo2.nowcoder;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @Author 蔡浩
 * @Date 2019/3/29 15:45
 */
public class RectCover {
  public static void main(String[] args) {
    System.out.println(new RectCover().rectCover(4));
    System.out.println(new RectCover().rectCover2(4));
    int i = 1;
    double j = 1.0;
    System.out.println(i == j);
  }

  public int rectCover(int target) {
    if (target <= 0) {
      return 0;
    }
    if (target == 1) {
      return 1;
    }
    int pre = 1;
    int prepre = 1;
    for (int i = 2; i <= target; i++) {
      pre += prepre;
      prepre = pre - prepre;
    }
    return pre;

  }

  public int rectCover2(int number) {
    if (number < 1) {
      return 0;
    }
    int g = 1, f = 2;
    while (--number > 0) {
      f = f + g;
      g = f - g;
    }
    return g;
  }

}
