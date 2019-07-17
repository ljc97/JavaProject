package FileIo;

import java.io.*;

/**
 * @Author Linjc
 * @Description 文件读写
 * @date 2019/7/15
 */
public class FileOperation {
    //    换行符
    public static final String ENTER = "\r\n";
    //    默认编码集
    public static final String CHARSET_ENCODING = "UTF-8";


    public static void main(String[] args) {
        String path = "F:/a.txt";
        File file = new File(path);
        writeFile("嘿嘿嘿", file, true);
        readFile(file);
    }

    public static void writeFile(String content, File file, boolean append) {
        try (FileOutputStream fos = new FileOutputStream(file, append);
             OutputStreamWriter osw = new OutputStreamWriter(fos, CHARSET_ENCODING);
             BufferedWriter bw = new BufferedWriter(osw);) {
            bw.write(content);
            bw.write(ENTER);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, CHARSET_ENCODING);
             BufferedReader br = new BufferedReader(isr);) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
