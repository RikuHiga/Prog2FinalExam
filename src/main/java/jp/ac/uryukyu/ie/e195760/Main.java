package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;
//removeコマンドを追加
//returnコマンド追加
//completeコマンド追加
//remove、completeされた時のtimestampを記録
//viewAllの未完了タスクのみ
//viewAllの完了タグのみ
//viewAllのゴミ箱のみ
//editコマンド追加

public class Main {
    static String FILENAME="TodoListSave.csv";
    static String ADD="add";
    static String REMOVE="remove";
    static String[] TITLE={"title","題名","0"};
    static String[] DESCRIPTION={"description=","説明","1"};//コマンドの定形文定義
    static String[] DEADLINE={"deadline=","締切","2"};
    static String[] TAG={"tag=","タグ","4"};
    static String[] DURATION={"duration=","所要時間","3"};
    static String[] PRIORITY={"priority","＊","5"};
    static String[] COMPLETE={"complete","完了済","6"};
    static String[] TRASH={"trash","ゴミ箱","7"};

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
