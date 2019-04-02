package com.caihao.webdemo2.nowcoder;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author 蔡浩
 * @date 2019/3/30 14:12
 */
public class Power {

  public static void main(String[] args) {
    System.out.println(new Power().power(2, -3));
  }

  private double power(double base, int exponent) {
    if (base == 0 || base == 1) {
      return 1;
    }
    double res = 1;
    double n = base;
    int curr = exponent > 0 ? exponent : -exponent;
    while (curr != 0) {
      if ((curr & 1) == 1) {
        res *= n;
      }
      n *= n;
      curr >>= 1;
    }
    return exponent > 0 ? res : 1 / res;
  }
}
