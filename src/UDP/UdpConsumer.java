package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 17:41
 */
public class UdpConsumer {
    public static void main(String[] args) throws Exception{
        @SuppressWarnings("resource")
        DatagramSocket datagramSocket=new DatagramSocket(8080);//绑定消息接收端口8080

        //存放接受数据字节数组
        byte[] msgByte=new byte[1024];
        //接受消息的数据报包
        DatagramPacket packet=new DatagramPacket(msgByte,msgByte.length);
            @SuppressWarnings({"resource"})
            Scanner sc=new Scanner(System.in);
            while (true){
                datagramSocket.receive(packet);
                String msg=new String(packet.getData(),0,packet.getLength());
                System.out.println("窗口b收到信息"+msg);
            }



    }
}
