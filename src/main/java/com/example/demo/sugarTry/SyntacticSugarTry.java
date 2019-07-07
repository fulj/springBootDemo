package com.example.demo.sugarTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author fulj
 * @date 2019年07月01日 10:36 AM
 */
public class SyntacticSugarTry {
    // 调用有finally的case值
    public static final int OLD_TRY = 1;
    // 调用新式语法糖式的case值
    public static final int SUGAR_TRY = 2;

    /**
     * 根据输入参数执行不同方法
     *
     * @param type
     * @return
     */
    public InputStream invokeTry(int type) {
        InputStream inputStream = null;
        switch (type) {
            case OLD_TRY:
                inputStream = oldTryCatch();
                break;
            case SUGAR_TRY:
                inputStream = newTryCatch();
                break;
            default:
                System.out.println("error type");
        }
        return inputStream;
    }

    /**
     * 采用旧式的finally写法
     *
     * @return
     */
    public InputStream oldTryCatch(){
        // 构建文件对象
        File inputFile = new File("D:\\input.txt");
        // 初始化输入流
        InputStream inputStream = null;
        try {
            // 创建字节输入流
            inputStream = new FileInputStream(inputFile);
            // 读取到1KB字节数组中
            byte[] buffer = new byte[12];
            // 读取数据并放到buffer数组中
            inputStream.read(buffer);
            System.out.println("oldTryCatch读取输出"+new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭流过程，也有可能出现异常
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return inputStream;
    }

    /**
     * 采用语法糖式写法
     *
     * @return
     */
    public InputStream newTryCatch() {
        // 构建文件对象
        File inputFile = new File("D:\\input.txt");
        // 初始化输入流
        InputStream returnStream = null;
        // try with resource 语法糖式写法
        try (InputStream inputStream = new FileInputStream(inputFile)) {
            byte[] buffer = new byte[12];
            inputStream.read(buffer);
            System.out.println("newTryCatch读取输出"+new String(buffer));
            returnStream = inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 省略了繁琐的finally
        return returnStream;
    }

    public static void main(String[] args) {
        SyntacticSugarTry sugarTry = new SyntacticSugarTry();
        InputStream oldStream = sugarTry.invokeTry(OLD_TRY);
        InputStream sugarStream = sugarTry.invokeTry(SUGAR_TRY);
        // 检查流是否正常关闭
        try {
            // 再次尝试读取，检查是否关闭
            oldStream.read();
        } catch (IOException e) {
            // 已关闭
            System.out.println("oldStream 输入流已关闭");
        }
        try {
            // 再次尝试读取，检查是否关闭
            sugarStream.read();
        } catch (IOException e) {
            // 已关闭
            System.out.println("sugarStream 输入流已关闭");
        }
    }
}
