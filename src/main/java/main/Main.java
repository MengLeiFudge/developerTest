package main;

import java.util.Scanner;

/**
 * @author MengLeiFudge
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("输入功能序号");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                new Func1().process();
                break;
            case 2:
                new Func2().process();
                break;
            case 3:
                new Func3().process();
                break;
            default:
        }
    }

}
