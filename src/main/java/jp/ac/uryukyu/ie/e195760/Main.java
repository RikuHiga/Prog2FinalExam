package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;
//viewAll機能を整える
//removeコマンドを追加
//viewAllの未完了タスクのみ
//viewAllの完了タグのみ
//viewAllのゴミ箱のみ
public class Main {
    static String FILENAME="TodoListSave.csv";
    static String ADD="add";
    static String REMOVE="remove";
    static String[] DESCRIPTION={"description=","説明"};//コマンドの定形文定義
    static String[] DEADLINE={"deadline=","期日"};
    static String[] TAG={"tag=","タグ"};
    static String[] DURATION={"duration=","所要時間"};
    static String[] PRIORITY={"priority","＊"};

    public static void main(String[] args){
        TodoManager todo=new TodoManager();//ViewAllのために実験的に追加
        Analysis analysis=new Analysis();
        SaveandLoad savefile=new SaveandLoad();
        Scanner scan=new Scanner(System.in);
        savefile.load();

        while(true){
            todo.ViewAll();//TodoListが格納できているか確認のために実験的に追加
            System.out.println("コマンドを入力してください。");
            String cmd=scan.nextLine();
            if(cmd.equals("exit")){
                break;
            }
            analysis.classify(cmd);
            savefile.save();
        }

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
