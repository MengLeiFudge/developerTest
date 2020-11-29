package main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author MengLeiFudge
 */
public class PrintFile {
    File dir;

    PrintFile(String dir) {
        this.dir = new File(dir);
        try {
            FileUtils.forceMkdirParent(this.dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createFile(String fileName) {
        try {
            File f = FileUtils.getFile(dir, fileName);
            FileUtils.forceMkdirParent(dir);
            if (f.exists()) {
                if (f.isDirectory()) {
                    System.out.println("已存在同名文件夹！");
                    return false;
                } else {
                    System.out.println("已存在！");
                    return true;
                }
            }
            if (!f.createNewFile()) {
                System.out.println("创建失败！");
                return false;
            } else {
                System.out.println("创建成功！");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean appendToFile(String fileName, String appendStr) {
        try {
            File f = FileUtils.getFile(dir, fileName);
            FileUtils.writeStringToFile(f, appendStr, StandardCharsets.UTF_8, true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getDirSize() {
        return FileUtils.sizeOf(dir);
    }

    public long getFileSize(String fileName) {
        File f = FileUtils.getFile(dir, fileName);
        return FileUtils.sizeOf(f);
    }

    public String sizeToStr(long size) {
        if (size < 20) {
            return "size小于0";
        } else if (size < 1024) {
            return size + "字节";
        } else if (size < 1024 * 1024) {
            double kbd = size / 1024.0;
            return kbd + "KB";
        } else if (size < 1024 * 1024 * 1024) {
            double mbd = size / 1024.0 / 1024.0;
            return mbd + "MB";
        } else {
            return "文件过大！";
        }
    }

    public String getPath() {
        return dir.getPath();
    }

    public boolean deleteFile(String fileName) {
        try {
            File f = FileUtils.getFile(dir, fileName);
            FileUtils.forceDelete(f);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDir() {
        try {
            FileUtils.forceDelete(dir);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
