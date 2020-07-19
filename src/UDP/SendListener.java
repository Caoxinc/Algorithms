package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 19:55
 */
public class SendListener implements Runnable {
    private int port;
    private String name;
    private static SimpleDateFormat format;
    {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    SendListener(int port,String name){
        this.port = port;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            @SuppressWarnings("resource")
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //实例化Scanner类
            String line;
            while((line = br.readLine())!=null){
                //发送的数据报包
                line = name +":"+line+" "+format.format(new Date());
                DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(),line.getBytes().length,address,port);
                socket.send(datagramPacket);
            }
        }catch(Exception e){
            System.out.println("出错了!出错信息:"+e.getMessage());
        }
    }


}
