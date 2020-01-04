package jp.ac.uryukyu.ie.e195760;

/**
 * removeコマンドとcompleteコマンドを処理する。
 */
public class RemoveAndComplete {
    int infoPlace;//trash、またはcompleteの情報があるのはtodoListの何番目かを示す
    void remove(String[] cmd){
        infoPlace=Integer.parseInt(Main.TRASH[2]);
        common(cmd);
    }
    void complete(String[] cmd){
        infoPlace=Integer.parseInt(Main.COMPLETE[2]);
        common(cmd);
    }
    void common(String[] cmd){
        int index=0;
        String[] todo;
        try{
            index=Integer.parseInt(cmd[1]);
        }catch(NumberFormatException ex){
            System.out.println("数値以外の指定");
            //文字列で検索してもいい
        }
        todo=TodoManager.todoList.get(TodoManager.visibleList.get(index-1));
        todo[infoPlace]="true";
        TodoManager.todoList.set(TodoManager.visibleList.get(index-1),todo);
        TodoManager.updateVisibleList(Main.DEFAULTVIEW);
    }
}
