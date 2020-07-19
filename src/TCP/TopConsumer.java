package TCP;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 18:44
 */
public class TopConsumer {
    public static void main(String[] args) throws Exception{
        @SuppressWarnings("resource")
        ServerSocket serverSocket=new ServerSocket(8010);
        Socket accept=serverSocket.accept();
        while (true){
            InputStream in=accept.getInputStream();
            byte[] buf=new byte[1024];
            int len=in.read(buf);
            System.out.println(new String(buf,0,len));
        }

    }
}
