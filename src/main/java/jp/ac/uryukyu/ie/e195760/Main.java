package jp.ac.uryukyu.ie.e195760;
import java.util.Scanner;
//scopeを考える。クラス全体で共有されてる変数を移動する
//DEFAULTVIEWを変更できるようにすれば見ている場所を変えたくないとき操作できる
//add title description= と入力するとバグる

/**
 * プログラム全体の司令塔で、不変のデータを置く場所。
 */
public class Main {
    static String FILENAME="TodoListSave.csv";//セーブファイル名
    static String ADD="add";//タスクを追加するコマンド
    static String REMOVE="remove";//タスクをゴミ箱に送るコマンド
    static String VIEW="view";//タスクを絞って見るコマンド
    static String SALVAGE="salvage";//タスクを完了もしくはゴミ箱から、未完了に戻すコマンド
    static String EDIT="edit";//タスクのデータを編集するコマンド
    static String HELP="help";//コマンドについての説明が見れるコマンド
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
    static String[] TODODATA={"","","","","","","false","false","false"};//基本となるtodoList

    public static void main(String[] args){
        ViewManager view=new ViewManager();
        Analysis analysis=new Analysis();
        SaveandLoad savefile=new SaveandLoad();
        Scanner scan=new Scanner(System.in);
        savefile.load();//ファイルロード
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
