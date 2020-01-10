package jp.ac.uryukyu.ie.e195760;

/**
 * ユーザーが見やすい形にtodoListを整える
 */
public class ViewManager {
    /*** 見ているリストが今どこなのかを示す。初期値は完了していないリスト*/static String place=Main.INCOMPLETE;
    /**
     * visibleListで指定されたtodoListの見え方を整えて出力する。
     */
    void PrintTodo(){
        int count=0;//visibleListの何番目にあるかを示すために使う
        boolean optionCheck;//追加設定があるかの確認
        System.out.println("==========================================");
        System.out.println(place);
        try{
            for(int visibleIndex:TodoManager.visibleList){
                count++;//タスクの一番最初に表示する数字に使う
                optionCheck=false;
                String priority="　";
                if(TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.PRIORITY[2])].equals("true")){//todoListのvisibleIndex番目のMain.PRIORITY[2]番目はtrue
                    priority="＊";
                }
                System.out.println("\n"+count+"."+priority+TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.TITLE[2])]);
                if(TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DESCRIPTION[2])].length()!=0){
                    System.out.println("　"+TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DESCRIPTION[2])]);
                }
                if(TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DEADLINE[2])].length()!=0){
                    System.out.print("　"+Main.DEADLINE[1]+":"+TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DEADLINE[2])]);
                    optionCheck=true;
                }
                if(TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.TAG[2])].length()!=0){
                    System.out.print("　"+Main.TAG[1]+":"+TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.TAG[2])]);
                    optionCheck=true;
                }
                if(TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DURATION[2])].length()!=0){
                    System.out.print("　"+Main.DURATION[1]+":"+TodoManager.todoList.get(visibleIndex)[Integer.parseInt(Main.DURATION[2])]);
                    optionCheck=true;
                }
                if(optionCheck){//改行はタスクの追加データがある時のみでいいため
                    System.out.println();
                }
            }
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
        System.out.println("==========================================");
    }
}
