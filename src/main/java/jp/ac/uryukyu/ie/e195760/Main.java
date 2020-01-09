package jp.ac.uryukyu.ie.e195760;

import java.sql.Time;
import java.util.Scanner;
//remove、completeされた時のtimestampを記録
//remove,completeを実行したときにtimestamp記録処理実行
//salvage実行時、timestamp削除処理実行
//セーブリストにtimestampを追加
//timestampによる削除の時、TodoListには反映されるがsaveには反映されない可能性。
//scopeを考える。クラス全体で共有されてる変数を移動する
//DEFAULTVIEWを変更できるようにすれば見ている場所を変えたくないとき操作できる

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
    static String HELP="help";
    static String[] TITLE={"title=","題名","0"};
    static String[] DESCRIPTION={"description=","説明","1"};//コマンドの定形文定義
    static String[] DEADLINE={"deadline=","締切","2"};
    static String[] TAG={"tag=","タグ","4"};
    static String[] DURATION={"duration=","所要時間","3"};
    static String[] PRIORITY={"priority","優先タスク","6"};
    static String[] INCOMPLETE={"","未完了タスク",""};
    static String[] COMPLETE={"complete","完了済タスク","7"};
    static String[] TRASH={"trash","ゴミ箱","8"};
    static int TIMESTAMP=5;//timestampが何番目にあるか
    static int DELETELIMIT=1;//ゴミ箱に捨てられるか完了してから消すまでの日にち
    static String[] DEFAULTVIEW={"","",""};//デフォルトのviewListを作るためのコマンド

    public static void main(String[] args){
        ViewManager view=new ViewManager();
        Analysis analysis=new Analysis();
        SaveandLoad savefile=new SaveandLoad();
        Scanner scan=new Scanner(System.in);
        savefile.load();//ファイルロード

//        TimeStamp tStamp=new TimeStamp();
//        System.out.println(tStamp.getTime());
//        System.out.println(tStamp.daycount("2020/01/08 01:23:45"));

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

    }
}
