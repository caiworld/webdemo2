package com.caihao.webdemo2.nowcoder;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 *
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * @Author 蔡浩
 * @Date 2019/3/27 14:40
 */
public class Fibonacci {

  public static void main(String[] args) {
    int n = 5;
    int pre = 0;
    int prepre = 0;
    for (int i = 1; i <= n; i++) {
      if (i == 1) {
        pre = 1;
      } else if (i == 2){
        prepre = pre;
        pre = 2;
      }else {
        pre += prepre;
        prepre = pre - prepre;
      }
    }
    System.out.println(pre);
    System.out.println("------------");
    System.out.println(new Fibonacci().fibonacci(n));
  }

  public int fibonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int pre = 1;
    int prepre = 1;
    for (int i = 2; i <= n; i++) {
      pre = pre + prepre;
      prepre = pre - prepre;
    }
    return pre;
  }
}
