package jp.ac.uryukyu.ie.e195760;
import java.util.Scanner;

/**
 * ヘルプコマンドの処理
 */
public class helpCommand {
    /**
     * helpコマンドの解析。
     * @param cmd 入力されたコマンド
     */
    void help(String[] cmd){
        Scanner scan=new Scanner(System.in);
        boolean doHelp=false;
        if(cmd[1].equals(Main.ADD)||cmd[1].equals("")){
            addInstruct();
            doHelp=true;
        }
        if(cmd[1].equals(Main.REMOVE)||cmd[1].equals("")){
            removeInstruct();
            doHelp=true;
        }
        if(cmd[1].equals(Main.COMPLETE[0])||cmd[1].equals("")){
            completeInstruct();
            doHelp=true;
        }if(cmd[1].equals(Main.SALVAGE)||cmd[1].equals("")){
            salvageInstruct();
            doHelp=true;
        }
        if(cmd[1].equals(Main.VIEW)||cmd[1].equals("")){
            viewInstruct();
            doHelp=true;
        }
        if(cmd[1].equals(Main.EDIT)||cmd[1].equals("")){
            editInstruct();
            doHelp=true;
        }
        if(doHelp){
            System.out.println("Enterを押すとhelpを終了します。");
            scan.nextLine();
        }else{
            System.out.println("不明なコマンドです。");
        }
    }

    /**
     * addコマンドの説明。
     */
    void addInstruct(){
        System.out.println(Main.ADD+"コマンド==============================");
        System.out.println("Todoリストに任意のToDoを追加するコマンドです。");
        System.out.println("コマンドに"+Main.ADD+" [タスクの名前] と入力すると指定した名前のToDoが追加されます。間には必ず空白を入力してください。");
        System.out.println(Main.ADD+" title [追加設定]で追加の設定ができます。追加設定の種類は以下の通りです。");
        System.out.println(Main.DESCRIPTION[0]+":タスクの説明を入力する。");
        System.out.println(Main.DEADLINE[0]+":具体的な締切日や○○までにやる、などの抽象的な締切を入力する。");
        System.out.println(Main.DURATION[0]+":このタスクはどのくらいの時間で完了できるかを示す所要時間を入力する。");
        System.out.println(Main.TAG[0]+":タスクに任意のタグを設定できる。");
        System.out.println(Main.PRIORITY[0]+":入力するとこのタスクを優先タスクに設定できる。");
        System.out.println(Main.ADD+" title "+Main.DESCRIPTION[0]+"testTask,"+Main.TAG[0]+"sampleTag,"+Main.PRIORITY[0]);
        System.out.println("コマンドを上のように書くと追加設定が付与されたToDoが追加されます、追加設定同士はコンマで区切る必要があります。");
        System.out.println();
    }

    /**
     * removeコマンドの説明。
     */
    void removeInstruct(){
        System.out.println(Main.REMOVE+"コマンド==============================");
        System.out.println("任意のToDoを削除するコマンドです。削除されたToDoはゴミ箱に送られます。");
        System.out.println(Main.REMOVE+" [消したいタスクの番号]と入力してください。必ずToDoに付いている数で指定し、文字では指定しないでください。");
        System.out.println(Main.REMOVE+" 1と入力するとToDoリストの一番目が削除され、ゴミ箱に送られます。");
        System.out.println("未完了タスクで使うことができます。");
        System.out.println();
    }

    /**
     * completeコマンドの説明。
     */
    void completeInstruct(){
        System.out.println(Main.COMPLETE[0]+"コマンド==============================");
        System.out.println("タスクが完了した際に使用するコマンドです。完了したToDoは完了済タスクに送られます。");
        System.out.println(Main.COMPLETE[0]+" [完了したタスクの番号]と入力してください。必ずToDoに付いている数で指定し、文字では指定しないでください。");
        System.out.println(Main.COMPLETE[0]+" 1と入力するとToDoリストの一番目が完了済タスクに送られます。");
        System.out.println("未完了タスクで使うことができます。");
        System.out.println();
    }/**
     * salavgeコマンドの説明。
     */
    void salvageInstruct(){
        System.out.println(Main.SALVAGE+"コマンド==============================");
        System.out.println("任意のToDoを未完了タスクに戻すコマンドです。完了済タスク、ゴミ箱で使うことができます。");
        System.out.println(Main.SALVAGE+" [戻したいタスクの番号]と入力してください。必ずToDoに付いている数で指定し、文字では指定しないでください。");
        System.out.println(Main.SALVAGE+" 1と入力するとToDoリストの一番目が未完了タスクに戻されます。");
        System.out.println("完了済タスク及びゴミ箱で使うことができます。");
        System.out.println();
    }

    /**
     * viewコマンドの説明。
     */
    void viewInstruct(){
        System.out.println(Main.VIEW+"コマンド==============================");
        System.out.println("特定のToDoリストを表示するコマンドです。");
        System.out.println(Main.VIEW+" とだけ入力すると、"+Main.INCOMPLETE+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.COMPLETE[0]+"と入力すると、"+Main.COMPLETE[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.TRASH[0]+"と入力すると、"+Main.TRASH[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.PRIORITY[0]+"と入力すると、"+Main.PRIORITY[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.TAG[0]+"=[任意のタグ]と入力すると、指定したタグのみが表示されます。");
        System.out.println("AND検索、OR検索には対応していません。");
        System.out.println();
    }

    /**
     * editコマンドの説明。
     */
    void editInstruct(){
        System.out.println(Main.EDIT+"コマンド==============================");
        System.out.println("任意のToDoを編集するコマンドです。");
        System.out.println(Main.EDIT+" [編集したいタスクの番号] [編集内容]と入力してください。必ずToDoに付いている数で指定し、文字では指定しないでください。");
        System.out.println("編集するコマンドは以下の通りです。");
        System.out.println(Main.TITLE[0]+"[変更後タスクの名前]:タスクの名前の変更ができます。");
        System.out.println(Main.DESCRIPTION[0]+"[変更後の説明]:説明の変更ができます。");
        System.out.println(Main.DEADLINE[0]+"[変更後の締切]:締切の変更ができます。");
        System.out.println(Main.DURATION[0]+"[変更後の所要時間]:所要時間の変更ができます。");
        System.out.println(Main.TAG[0]+"[変更後タグの名前]:タグの名前の変更ができます。");
        System.out.println(Main.PRIORITY[0]+":優先タグの切り替えを行います。優先タグがない場合は付与し、ある場合は外します。");
        System.out.println("同時に複数の要素の編集がしたい場合は,で区切って記述してください。");
        System.out.println();
    }
}