package main;

import java.util.Scanner;

/**
 * @author MengLeiFudge
 */
public class Main {

    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        System.out.println("输入功能序号");
        switch (sc.nextInt()) {
            case 1:
                processFunc1();
                break;
            default:
        }
    }

    public static void processFunc1() {
        System.out.println("输入要创建的文件夹路径");
        PrintFile printFile = new PrintFile(sc.next());

        System.out.println("输入要创建的文件名");
        printFile.createFile(sc.next());
    }

}
