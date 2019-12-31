package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODOリストを管理し、ViewAll機能を制御するクラス。
 */
public class TodoManager {
    public static ArrayList<String[]> todoList=new ArrayList<String[]>();
    public TodoManager(){
        //todoList=new ArrayList<String[]>();
    }

    /**
     * タスク一覧を表示する。フィルター機能あり
     */
    void ViewAll(){
        ArrayList<String[]> visibleList=new ArrayList<String[]>();
        System.out.println("==========================================");
        for(String[] todoList:this.todoList){
            if(!todoList[7].equals("true")){
                visibleList.add(todoList);
            }
        }
        for(String[] visible:visibleList){
            //System.out.println(Arrays.toString(visible));
            ViewTodo(visible);
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
            priority="＊";
        }
        System.out.println("\n"+priority+visibleList[0]);
        if(visibleList[1].length()!=0){
            System.out.println("　"+visibleList[1]);
        }
        if(visibleList[2].length()!=0){
            System.out.print("　"+Main.DEADLINE[1]+":"+visibleList[2]);
        }
        if(visibleList[3].length()!=0){
            System.out.print("　"+Main.TAG[1]+":"+visibleList[3]);
        }
        if(visibleList[4].length()!=0){
            System.out.print("　"+Main.DURATION[1]+":"+visibleList[4]);
        }
        System.out.println();
    }
}
