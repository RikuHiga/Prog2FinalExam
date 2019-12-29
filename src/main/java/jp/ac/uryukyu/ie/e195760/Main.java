package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;
//無限ループさせる。コマンドで処理を止める
public class Main {
    String DESCRIPTION="description=";//コマンドの定形文定義
    String DEADLINE="deadline=";
    String TAG="tag=";
    String PRIORITY="priority";

    public static void main(String[] args){
        TodoManager todo=new TodoManager();//ViewAllのために実験的に追加
        Analysis analysis=new Analysis();
        Scanner scan=new Scanner(System.in);
        System.out.println("コマンドを入力してください。");
        String cmd=scan.nextLine();
        analysis.classify(cmd);
        todo.ViewAll();//TodoListが格納できているか確認のために実験的に追加

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
