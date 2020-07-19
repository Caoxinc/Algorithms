package huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/22 19:05
 */
public class Main {
    public static void main(String[] args) {
        //Scanner in=new Scanner(System.in);
       // String string=in.nextLine();
       /* while (in.hasNextInt()) {
            int a = in.nextInt(16);
            string+=a;
        }*/
        //System.out.println(string);
        //in.close();
        new Main().pringHex("5a 12 5b ba 34 5b bb 88 05 5a 75 cd bb 62 5a 34 cd 78 cc da fb 06 5a");
        //System.out.println((char)1);
        //String s="3d50J,Aa3";
       //new Main().pringAns(string);
    }
    public void pringHex(String s){
        StringBuilder sb=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        StringBuilder next=new StringBuilder();
        int a1=0,a2=0;
        int nums=0;
        boolean sign=true;
        for(int i=0;i<s.length()-1;i+=3){
            int j=i+1;
            if(s.charAt(i)==' ')continue;//空格跳出
            temp.append(s.substring(i,j+1));
            if(j<s.length()-3)
            next.append(s.substring(i+3,i+5));

            if (temp.toString().equals("5a") && !next.toString().equals("5a")) {//第一个“5a”
                sign=true;
                a1=i;
                nums = 0;//开始计数
            } else {
                if(sign==true) {
                    if (temp.toString().equals("5b")) {//判断 5b
                        if (next.toString().equals("bb")||next.toString().equals("ba")) {
                            nums++;
                            i = i + 3;
                            temp.delete(0,temp.length());
                            next.delete(0,next.length());
                            continue;
                        } else {
                            sign = false;
                        }
                    }else {
                        nums++;
                    }

                }else {
                    continue;
                }
            }
            if(next.toString().equals("5a")){
                boolean sign2=((temp.charAt(0)-'0')*16+(temp.charAt(1)-'0')==nums-1);
                if(!sign2){
                    sign=false;
                }else {
                    a2=i+2;
                }
                if(sign==true){
                    sb.append(s.substring(a1,a2));
                }
            }
            temp.delete(0,temp.length());
            next.delete(0,next.length());

        }
        System.out.println(sb.toString());

        }



    public void pringAns(String s){
        if(s==null||s.length()==0){
            return;
        }
        Map<Character,Integer> map=new HashMap<>();
        char temp;
        for(int i=0;i<s.length();i++){
            temp=s.charAt(i);
           if(temp>=48&&temp<58){
               if (map.containsKey(temp)){
                   map.put(temp,map.get(temp)+1);
               }else {
                   map.put(temp,1);
               }
           }
        }

        for(char i='0';i<='9';i++){
            if(map.containsKey(i)){
                for(int j=0;j<map.get(i);j++){
                    System.out.print(i);
                }
            }
        }
    }
}
