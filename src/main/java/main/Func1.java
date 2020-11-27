package main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author MengLeiFudge
 */
public class Func1 {

    Func1() {
    }

    public void process() {
        System.out.println("输入要创建的文件路径");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());
        try {
            // FileUtils.forceMkdirParent(f);
            if (!f.createNewFile()) {
                System.out.println("创建失败！");
            } else {
                System.out.println("创建成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
