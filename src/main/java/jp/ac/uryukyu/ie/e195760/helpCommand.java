package jp.ac.uryukyu.ie.e195760;

import java.util.Scanner;

public class helpCommand {
    /**
     * helpコマンドの解析。
     * @param cmd 入力されたコマンド
     */
    void help(String[] cmd){
        Scanner scan=new Scanner(System.in);
        if(cmd[1].equals(Main.ADD)||cmd[1].equals("")){
            addInstruct();
        }
        if(cmd[1].equals(Main.REMOVE)||cmd[1].equals("")){
            removeInstruct();
        }
        if(cmd[1].equals(Main.VIEW)||cmd[1].equals("")){
            viewInstruct();
        }
        if(cmd[1].equals(Main.EDIT)||cmd[1].equals("")){
            editInstruct();
        }
        System.out.println("Enterを押すとhelpを終了します。");
        String tmp=scan.nextLine();
        //System.out.println(tmp);
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
        System.out.println(Main.ADD+" title "+Main.DESCRIPTION[0]+"試しに作った,"+Main.TAG[0]+"sampleTag,"+Main.PRIORITY[0]);
        System.out.println("コマンドを上のように書くと追加設定が付与されたToDoが追加されます、追加設定同士はコンマで区切る必要があります。");
    }

    /**
     * removeコマンドの説明。
     */
    void removeInstruct(){
        System.out.println(Main.REMOVE+"コマンド==============================");
        System.out.println("任意のToDoを削除するコマンドです。削除されたToDoはゴミ箱に送られます。");
        System.out.println(Main.REMOVE+" [消したいタスクの番号]と入力してください。必ずToDoに付いている数で指定し、文字では指定しないでください。");
        System.out.println(Main.REMOVE+" 1と入力するとToDoリストの一番目が削除され、ゴミ箱に送られます。");
    }

    /**
     * viewコマンドの説明。
     */
    void viewInstruct(){
        System.out.println(Main.VIEW+"コマンド==============================");
        System.out.println("特定のToDoリストを表示するコマンドです。");
        System.out.println(Main.VIEW+" とだけ入力すると、"+Main.INCOMPLETE[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.COMPLETE[0]+"と入力すると、"+Main.COMPLETE[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.TRASH[0]+"と入力すると、"+Main.TRASH[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.PRIORITY[0]+"と入力すると、"+Main.PRIORITY[1]+"のみが表示されます。");
        System.out.println(Main.VIEW+" "+Main.TAG[0]+"=[任意のタグ]と入力すると、指定したタグのみが表示されます。");
        System.out.println("AND検索、OR検索には対応していません。");
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
        System.out.println(Main.PRIORITY[0]+":優先タグがない場合は付与し、ある場合は外します。");
        System.out.println("同時に複数の要素の編集がしたい場合は,で区切って記述してください。");
    }
}