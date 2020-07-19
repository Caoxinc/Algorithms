package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 18:40
 */
public class TcpProducer {
    public static void main(String[] args)throws Exception{
        Socket socket=new Socket("localhost",8010);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        OutputStream os=socket.getOutputStream();
        String line;
        while((line=br.readLine())!=null){
            os.write(line.getBytes());
            os.flush();

        }
    }
}
