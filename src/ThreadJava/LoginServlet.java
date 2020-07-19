package ThreadJava;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/19 16:23
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;
    public static synchronized void doPost(String username,String password){
        try {
            usernameRef=username;
            if(username.equals("a")){
                Thread.sleep(5000);
            }
            passwordRef=password;
            System.out.println("username= "+ usernameRef+"   password= "+passwordRef);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Alogin a=new Alogin();
        a.start();
        Blogin b=new Blogin();
        b.start();
    }

}

class Alogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}
class Blogin extends  Thread{
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
