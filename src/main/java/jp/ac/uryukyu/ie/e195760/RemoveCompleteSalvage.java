package jp.ac.uryukyu.ie.e195760;

public class RemoveCompleteSalvage {
    int infoPlace;//trash、またはcompleteの情報があるのはtodoListの何番目かを示す
    String setData;

    void remove(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.TRASH[2]);
            setData="true";
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }

    }
    void complete(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.COMPLETE[2]);
            setData="true";
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    /**
     * ゴミ箱からも完了タスクからも戻すためにcompleteもtrashもfalseに戻す。
     * @param cmd コマンド
     */
    void salvage(String[] cmd){
        try{
            infoPlace=Integer.parseInt(Main.COMPLETE[2]);
            setData="false";
            common(cmd);
            infoPlace=Integer.parseInt(Main.TRASH[2]);
            common(cmd);
            TodoManager.updateVisibleList(Main.DEFAULTVIEW);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }
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
        TodoManager.todoList.set(TodoManager.visibleList.get(index-1),todo);
    }
}
