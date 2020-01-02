package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;

public class ViewManager {
    int count;
    /**
     * タスク一覧を表示する。フィルター機能あり
     */
    void ViewAll(){
        TodoManager.visibleList=new ArrayList<Integer>();
        count=0;//todoListの何番目にあるかを示すために使う
        System.out.println("==========================================");
        for(String[] todoList:TodoManager.todoList){//ゴミ箱にあるタスクを弾くため
            if(!todoList[Integer.parseInt(Main.TRASH[2])].equals("true")){
                TodoManager.visibleList.add(count);
            }
            count++;//todoListの何番目にあるかを数える用
        }
        count=0;//visibleListの何番目にあるかを示すために使う
        for(int visibleIndex:TodoManager.visibleList){
            count++;//タスクの一番最初に表示する数字用
            ViewTodo(TodoManager.todoList.get(visibleIndex));
        }
        System.out.println("==========================================");
    }
    /**
     * Todoリストの見え方を整える。
     * @param visibleList フィルターにかけたTodoList
     */
    void ViewTodo(String[] visibleList){
        String priority="　";
        if(visibleList[5].equals("true")){
            priority=Main.PRIORITY[1];
        }
        System.out.println("\n"+count+"."+priority+visibleList[0]);
        if(visibleList[Integer.parseInt(Main.DESCRIPTION[2])].length()!=0){
            System.out.println("　"+visibleList[Integer.parseInt(Main.DESCRIPTION[2])]);
        }
        if(visibleList[Integer.parseInt(Main.DEADLINE[2])].length()!=0){
            System.out.print("　"+Main.DEADLINE[1]+":"+visibleList[Integer.parseInt(Main.DEADLINE[2])]);
        }
        if(visibleList[Integer.parseInt(Main.TAG[2])].length()!=0){
            System.out.print("　"+Main.TAG[1]+":"+visibleList[Integer.parseInt(Main.TAG[2])]);
        }
        if(visibleList[Integer.parseInt(Main.DURATION[2])].length()!=0){
            System.out.print("　"+Main.DURATION[1]+":"+visibleList[Integer.parseInt(Main.DURATION[2])]);
        }
        if(visibleList[Integer.parseInt(Main.DEADLINE[2])].length()+visibleList[Integer.parseInt(Main.TAG[2])].length()+visibleList[Integer.parseInt(Main.DURATION[2])].length()!=0){//改行はタスクの追加データがある時のみでいいため
            System.out.println();
        }
    }
}