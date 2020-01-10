package jp.ac.uryukyu.ie.e195760;

/**
 * removeコマンド、completeコマンド、salvageコマンドの処理。
 */
public class RemoveCompleteSalvage {
    /***TimeStampクラスを使うためにインスタンス化*/TimeStamp tStamp=new TimeStamp();
    /***変更したいデータがtodoListの何番目かを示す */int infoPlace;
    /***変更したいデータをどう変更のデータを入れる */String setData;
    /***タイムスタンプをこの変数の内容に書き換える。 */String Date;

    /**
     * ゴミ箱に捨てるためにtodo[COMPELTE[2]]にtrueをセットし、timestampをつけるための前準備
     * @param cmd 入力されたコマンド
     */
    void remove(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.TRASH[2]);//変更する場所
            setData="true";//変更したい内容
            Date=tStamp.getTime();//日付を文字型で取得
            common(cmd);//共通処理
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);//visibleList更新
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    /**
     * 完了タグをつけるためにtodo[COMPELTE[2]]にtrueをセットし、timestampをつけるための前準備
     * @param cmd 入力されたコマンド
     */
    void complete(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.COMPLETE[2]);
            setData="true";
            Date=tStamp.getTime();
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    /**
     * ゴミ箱からも完了タスクからも戻すためにcompleteもtrashもfalseに戻し、timestampを""に設定するための前準備
     * @param cmd 入力されたコマンド
     */
    void salvage(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.COMPLETE[2]);
            setData="false";
            Date="";
            common(cmd);
            infoPlace=Integer.parseInt(Main.TRASH[2]);
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    /**
     * 予め設定されたフラグとtimestampを設定する。remove,complete,salavageのそれぞれの共通処理をまとめた。
     * @param cmd 入力されたコマンド
     */
    void common(String[] cmd){
        int index=0;
        String[] todo;
        try{
            index=Integer.parseInt(cmd[1]);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
        todo=TodoManager.todoList.get(TodoManager.visibleList.get(index-1));
        todo[infoPlace]=setData;
        todo[Main.TIMESTAMP]=Date;
        TodoManager.todoList.set(TodoManager.visibleList.get(index-1),todo);
    }
}
