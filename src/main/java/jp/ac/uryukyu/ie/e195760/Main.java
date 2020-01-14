package jp.ac.uryukyu.ie.e195760;
import java.util.Scanner;

/**
 * プログラム全体の司令塔で、不変のデータを置く場所。
 */
public class Main {
    /*** セーブファイルの名前。*/static String FILENAME="TodoListSave.csv";
    /*** タスクを追加するコマンドのキーワード。*/static String ADD="add";
    /*** タスクをゴミ箱に送るコマンドのキーワード。*/static String REMOVE="remove";
    /*** タスクを絞って見るコマンドのキーワード。*/static String VIEW="view";
    /*** タスクを完了もしくはゴミ箱から未完了に戻すコマンドのキーワード。*/static String SALVAGE="salvage";
    /*** タスクを編集するコマンドのキーワード。*/static String EDIT="edit";
    /*** ヘルプコマンドのキーワード。*/static String HELP="help";
    /*** タスクの題名に関するデータ群。*/static String[] TITLE={"title=","題名","0"};
    /*** タスクの説明に関するデータ群。*/static String[] DESCRIPTION={"description=","説明","1"};
    /*** タスクの締切に関するデータ群。*/static String[] DEADLINE={"deadline=","締切","2"};
    /*** タスクのタグに関するデータ群。*/static String[] TAG={"tag=","タグ","4"};
    /*** タスクの所要時間に関するデータ群。*/static String[] DURATION={"duration=","所要時間","3"};
    /*** タスクの優先タスクに関するデータ群。*/static String[] PRIORITY={"priority","優先タスク","6"};
    /*** 完了していないタスクの名前を格納*/static String INCOMPLETE="未完了タスク";
    /*** タスクの完了フラグに関するデータ群。*/static String[] COMPLETE={"complete","完了済タスク","7"};
    /*** タスクのゴミ箱フラグに関するデータ群。*/static String[] TRASH={"trash","ゴミ箱","8"};
    /*** タスクのタイムスタンプはtodoListの何番目にあるか*/static int TIMESTAMP=5;
    /*** タスクが完了、またはゴミ箱に捨てられてから完全に削除されるまでの日数。*/static int DELETELIMIT=1;
    /*** デフォルトのviewリストを作るためのコマンド*/static String[] DEFAULTVIEW={"","",""};
    /*** タスクの基本形。*/static String[] TODODATA={"","","","","","","false","false","false"};

    /**
     *ファイルロード、コマンド入力、プログラム終了処理、コマンド解析メソッド起動、セーブ処理を行う。
     * @param args 未使用
     */
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
