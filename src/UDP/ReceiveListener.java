package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 19:54
 */
public class ReceiveListener implements Runnable {
    private int port;

    ReceiveListener(int port){
        this.port = port;
    }

    @Override
    public void run() {
        try{
            @SuppressWarnings("resource")
            DatagramSocket datagramSocket = new DatagramSocket(port);//绑定消息接收端口8080
            // 用以存放接收数据的字节数组
            byte[] msgByte = new byte[1024];
            // 接收消息的数据报包
            DatagramPacket packet = new DatagramPacket(msgByte, msgByte.length);
            while(true){
                datagramSocket.receive(packet);
                String msg = new String(packet.getData(),0,packet.getLength());
                System.out.println(msg);
            }
        }catch(Exception e){
            System.out.println("出错了!出错信息:"+e.getMessage());
        }
    }


}
