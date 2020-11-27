package main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author MengLeiFudge
 */
public class Func2 {

    Func2() {
    }

    public void process() {
        System.out.println("输入随机数");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        judgeNum(num);
    }

    private void judgeNum(int num) {
        if (num < 0) {
            System.out.println(num + "小于0");
        } else if (num < 100) {
            System.out.println(num + "为0-100");
        } else if (num > 1000) {
            System.out.println(num + "为100-1000");
        } else {
            System.out.println(num + "大于1000");
        }
    }

}
