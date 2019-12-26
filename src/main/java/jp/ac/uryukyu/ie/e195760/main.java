package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Todo todo=new Todo();
        String cmd=scan.nextLine();
        System.out.println(cmd+"　が入力されました。");
        todo.ViewAll();

//        System.out.println("Hello World");
//        System.out.println(add(64,128));
    }

//    /**
//     * 足算するメソッド
//     * @param a　引数一つ目
//     * @param b 引数二つ目
//     * @return 演算結果を返す
//     */
//    public static int add(int a,int b){
//        return a+b;
//    }
}
