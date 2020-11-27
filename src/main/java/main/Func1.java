package main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author MLJ
 */
public class Func1 {

    Func1() {
    }

    public void process() {
        System.out.println(123);
        File f = new File("files/1.txt");
        try {
            FileUtils.forceMkdirParent(f);
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
