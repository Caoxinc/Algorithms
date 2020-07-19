package Thread;

import java.util.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/3 17:10
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        List<Integer> arrayList1= Collections.unmodifiableList(arrayList);
        Iterator<Integer> iterator=arrayList1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        arrayList.add(4);
        arrayList1.add(5);
    }
}
