package leetcode;

public class test {
    public static void main(String[] args) {
        int[]candidates ={9,1,-3,2,4,8,3,-1,6,-2,-4,7};
        Solution s1=new Solution();
        //System.out.println(s1.longestConsecutive(candidates));
        //System.out.println(s1.numDecodings("11111 "));
        //System.out.println(s1.canJump(candidates));
        //System.out.println(s1.judeg1("aaa","bbb" ));
        //List<Integer>list=new LinkedList<>();
        //s1.spiralOrder(list,candidates.length-2,candidates[0].length-2,candidates,1);
        //System.out.println(list);
       //System.out.println(s1.spiralOrder(candidates));
        //int[][]out=s1.generateMatrix(3);
        int[] digits={};
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(3);
        ListNode p4=new ListNode(4);
        ListNode p5=new ListNode(5);
        ListNode p6=new ListNode(6);
        ListNode p7=new ListNode(7);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;

        /*String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);//true
        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);//false*/
        //p6.next=p7;
        //s1.oddEvenList(p1).print();

        /*List<List<String>>lists=s1.groupAnagrams(strings);
        for(List<String>list:lists){
            System.out.println(list);
        }*/
        /*int[] coins={1,2,5};
        int[] coins2={2};
        System.out.println(s1.coinChange(coins2,4));*/
        /*String str="aaabbb";
        System.out.println(s1.longestPalindrome(str));*/
       /* String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        //List<String> list = new ArrayList<String>(Arrays.asList(wordList));
        System.out.println(s1.ladderLength(beginWord,endWord,Arrays.asList(wordList)));
*/
       /*String str="Mdove";
       fun(str);
       String str1=new String("abc");
       fun(str1);
        System.out.println(str);
        System.out.println(str1);*/
       int[][]a={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
       //s1.numIslands(a);
    }
    private static void fun(String a){
        a="Mdove is ugly";
    }

}
