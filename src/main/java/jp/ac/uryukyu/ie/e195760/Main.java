package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;
//remove、completeされた時のtimestampを記録
//editコマンド追加
//sortコマンド

/**
 * プログラム全体の司令塔で、不変のデータを置く場所。
 */
public class Main {
    static String FILENAME="TodoListSave.csv";
    static String ADD="add";
    static String REMOVE="remove";
    static String VIEW="view";
    static String SALVAGE="salvage";
    static String EDIT="edit";
    static String[] TITLE={"title=","題名","0"};
    static String[] DESCRIPTION={"description=","説明","1"};//コマンドの定形文定義
    static String[] DEADLINE={"deadline=","締切","2"};
    static String[] TAG={"tag=","タグ","4"};
    static String[] DURATION={"duration=","所要時間","3"};
    static String[] PRIORITY={"priority","優先タスク","5"};
    static String[] INCOMPLETE={"","未完了タスク",""};
    static String[] COMPLETE={"complete","完了済タスク","6"};
    static String[] TRASH={"trash","ゴミ箱","7"};
    static String[] ascendingOrder={"ascend","昇順"};
    static String[] descendingOrder={"descend","降順"};
    static String[] DEFAULTVIEW={"","",""};//デフォルトのviewListを作るためのコマンド

    public static void main(String[] args){
        ViewManager view=new ViewManager();//ViewAllのために実験的に追加
        Analysis analysis=new Analysis();
        SaveandLoad savefile=new SaveandLoad();
        Scanner scan=new Scanner(System.in);
        savefile.load();//ファイルロード
        //view.View(DEFAULTVIEW);
        //analysis.classify(VIEW);
        TodoManager.updateVisibleList(DEFAULTVIEW);//デフォルトのvisibleListに更新する

        while(true){
            view.PrintTodo();//毎回visibleListに記されたTodoList// を出力する
            System.out.println("コマンドを入力してください。");
            String cmd=scan.nextLine();//コマンド入力
            if(cmd.equals("exit")){//exitコマンドが入力されたらプログラム終了
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
