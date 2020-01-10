package jp.ac.uryukyu.ie.e195760;

public class RemoveCompleteSalvage {
    TimeStamp tStamp=new TimeStamp();
    int infoPlace;//trash、またはcompleteの情報があるのはtodoListの何番目かを示す
    String setData;
    String Date;

    /**
     * ゴミ箱に捨てるためにtodo[COMPELTE[2]]にtrueをセットし、timestampをつけるための前準備
     * @param cmd
     */
    void remove(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.TRASH[2]);
            setData="true";
            Date=tStamp.getTime();
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    /**
     * 完了タグをつけるためにtodo[COMPELTE[2]]にtrueをセットし、timestampをつけるための前準備
     * @param cmd
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
     * @param cmd コマンド
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
     * 予め設定されたフラグとtimestampを設定する。
     * @param cmd
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
