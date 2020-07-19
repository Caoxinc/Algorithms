package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 17:52
 */
public class UdpProducer {
    public static void main(String[] args) throws Exception {

        //建立套接字接口
        @SuppressWarnings("resource")
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //实例化Scanner类
        String line;
        while((line = br.readLine())!=null){
            //发送的数据报包
            DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(),line.getBytes().length,address,8080);
            socket.send(datagramPacket);
        }
    }


}
