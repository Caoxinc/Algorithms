package UDP;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/28 19:54
 */
public class WindowsB {
    private static final int SEND_PORT = 8080;//向哪个端口发送信息
    private static final int RECEIVE_PORT = 8090;//绑定一个端口接收信息
    public static void main(String[] args) {
        System.out.println("开始聊天啦!");
        new Thread(new ReceiveListener(RECEIVE_PORT)).start();
        new Thread(new SendListener(SEND_PORT,"小明")).start();
    }

}
