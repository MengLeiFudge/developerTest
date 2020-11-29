package main;

import java.util.Scanner;

public class Clac {

    Clac() {

    }

    public void process() {
        System.out.println("输入第一个数字");
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        System.out.println("输入第二个数字");
        double num2 = sc.nextDouble();
        System.out.println("你计算的差值为");
        double yourSub = sc.nextDouble();

        double computerSub = sub1(num1, num2);
        boolean isCorrect = equals1(computerSub, yourSub);
        //boolean isCorrect = equals2(computerSub, yourSub);
        System.out.println("这两个数的差值为：" + computerSub);
        System.out.println("你计算的差值为：" + yourSub);
        if (isCorrect) {
            System.out.println("恭喜你算对啦！");
        } else {
            System.out.println("很遗憾，你算错了呢！");
        }
    }

    public double sub1(double num1, double num2) {
        double ret = num1 - num2;
        if (ret > 0) {
            return ret;
        } else {
            return -ret;
        }
    }

    public double sub2(double num1, double num2) {
        return Math.abs(num1 - num2);
    }

    public boolean equals1(double num1, double num2) {
        return num1 == num2;
    }

    public boolean equals2(double num1, double num2) {
        double ret = num1 - num2;
        return Math.abs(ret) < 1e-5;
    }

}
