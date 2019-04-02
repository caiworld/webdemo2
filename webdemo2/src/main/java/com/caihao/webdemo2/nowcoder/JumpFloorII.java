package com.caihao.webdemo2.nowcoder;

/**
 * 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @Author 蔡浩
 * @Date 2019/3/28 09:11
 */
public class JumpFloorII {
  public static void main(String[] args) {
    System.out.println(new JumpFloorII().jumpFloorII(4));
  }

  public int jumpFloorII(int target){
    if (target<=0){
      return 0;
    }
    return 1<<(target-1);
  }
}
