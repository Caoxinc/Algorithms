package Thread;

import java.io.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/4 11:54
 */
public class SerializableTest {
    public static void main(String[] args)throws Exception {
        FlyPig flyPig1=new FlyPig();
        serializeFlyPig();
        System.out.println("name "+flyPig1.getAge());
        FlyPig flyPig= deserializeFlyPig();
        System.out.println("name "+flyPig.getName());
        System.out.println(flyPig.toString());
    }

    private static FlyPig deserializeFlyPig() throws Exception {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("d:/flyPig.txt")));
        FlyPig person=(FlyPig) ois.readObject();
        System.out.println("FlyPig 对象反序列化成功");
        return person;
    }

    private static void serializeFlyPig() throws IOException {
        FlyPig flyPig=new FlyPig();
        flyPig.setCar("black");
        flyPig.setName("naruto");
        flyPig.setCar("000");
        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream(new File("d:/flyPig.txt")));
        oos.writeObject(flyPig);
        System.out.println("FlyPig 对象序列化成功");
        oos.close();
    }
}
