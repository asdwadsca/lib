package com.asdwadsca.libs.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  对于properties文件的操作方法集合
 */
public class PropertiesAct {

    /**
     *  全局常量,确保调用方法时文件不会只有一行被写入
     */
    private static final Properties PROPERTIES = new Properties();


    /**
     * 该方法接受文件目录和文件名,并将其处理为合法文件文件路径,然后按照路径创建文件
     * 该方法返回boolean类型的值
     * 该方法会抛出IOException异常
     *
     * @param file_path     文件目录
     * @param file_name     文件名
     * @throws IOException  当文件路径不合法时抛出
     * @return              返回处理结果, 为boolean类型
     */
    public static boolean createFile(String file_path, String file_name) throws IOException{
        String pro_file_path = file_path + "/" + file_name + ".properties";
        File file = new File(pro_file_path);
        if (!file.exists()){
            return file.createNewFile();
        }
        return false;
    }

    /**
     * 该方法接受文件目录,文件名和键值对, 并将接受的文件目录和文件名处理为合法文件路径,然后按照接受的键值对修改文件
     * 该方法无返回值
     * 该方法会抛出IOException异常
     *
     * @param file_path     文件的目录
     * @param file_name     文件名
     * @param key           键
     * @param value         对应键的值
     * @throws IOException  当文件路径不合法时抛出
     */
    public static void writeFile(String file_path, String file_name, String key, String value) throws IOException{
        String pro_file_path = file_path + "/" + file_name + ".properties";
        PROPERTIES.setProperty(key, value);
        PROPERTIES.store(new FileOutputStream(pro_file_path), null);
    }

    /**
     * 该方法接受文件目录,文件名和键, 并将接受的文件目录和文件名处理为合法文件路径, 然后按照接受的键查询对应的值
     * 该方法返回String类型的值
     * 该方法会抛出IOException异常
     *
     * @param file_path     文件的目录
     * @param file_name     文件名
     * @param key           键
     * @return              返回查询后的值,为String类型
     * @throws IOException  当文件路径不合法时抛出
     */
    public static String readFile(String file_path, String file_name, String key) throws IOException{
        String pro_file_path = file_path + "/" + file_name + ".properties";
        PROPERTIES.load(new FileInputStream(pro_file_path));
        return PROPERTIES.getProperty(key);
    }

    /**
     * 该方法接受文件目录,文件名, 并将接受的文件目录和文件名处理为合法文件路径, 然后按照处理后的文件路径删除文件
     * 该方法返回boolean类型的值
     * 该方法不抛出异常
     *
     * @param file_path     文件的目录
     * @param file_name     文件名
     * @return              返回处理结果, 为boolean类型
     */
    public static boolean deleteFile(String file_path, String file_name) {
        String pro_file_path = file_path + "/" + file_name + ".properties";
        File file = new File(pro_file_path);
        if (file.exists()){
            return file.delete();
        }
        return false;
    }
}
