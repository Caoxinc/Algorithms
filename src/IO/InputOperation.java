package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/30 11:29
 */
public class InputOperation {
    public static void main(String[] args) {
        File in=new File("d:\\IO\\1.txt");
        File out=new File("d:\\IO\\2.txt");
        try {
            fileInput(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void fileInput(File in,File out)throws IOException {

        FileInputStream fis=new FileInputStream(in);
        FileOutputStream fos=new FileOutputStream(out);
        if(!in.exists())
            throw new IllegalArgumentException("文件不存在");
        int b;
        byte[] bytes=new byte[8*1024];//利用字节数组存储
        while((b=fis.read(bytes,0,bytes.length))!=-1){
            fos.write(bytes,0,b);
            fos.flush();
        }
        fis.close();
        fos.close();
    }
}
