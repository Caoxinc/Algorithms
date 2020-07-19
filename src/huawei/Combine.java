package huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/6/2 11:44
 */
public class Combine {
    public static void main(String[] args) {

        System.out.println(new Combine().getKfromN(4,2));
    }
        private List<String> list=new ArrayList<>();

    int getKfromN(int n ,int k){
        if(n<k){
            return 0;
        }else if(n==k || k==0){
            return 1;
        }else{
            return getKfromN(n-1,k-1)+getKfromN(n-1,k);
        }
    }



}



