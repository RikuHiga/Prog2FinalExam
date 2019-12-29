package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODOリストを管理するクラス
 */
public class TodoManager {
    public static ArrayList<String[]> todoList=new ArrayList<String[]>();
    public TodoManager(){
        //todoList=new ArrayList<String[]>();
    }
    void ViewAll(){
        System.out.println("ViewAll起動");
        for(String[] n:this.todoList){
            System.out.println(Arrays.toString(n));
        }
    }
    void TodoAdd(String[] TodoData){
//        System.out.println("TodoAdd起動");
//        String[] todoData=new String[7];//タイトル,説明,日付,タグ,優先タグ,完了か否か,ゴミ箱
//        todoData="TodoListを作る,JavaでTodoListを作る,201912261754,java,true,false,false".split(",");
//        todoData[4]="false";
//        todoList.add(todoData);
//        todoData="Pomodoroを作る,UnityでPomodoroを作る,201912261817,Unity,true,false,false".split(",");
//        todoList.add(todoData);
//        todoData="どう森のBGMを編集する,音源編集ソフトでintroとmainに分ける,201912261818,Unity,true,false,false".split(",");
//        todoList.add(todoData);
//        todoData=todoList.get(1);
//        todoData[4]="false";
        todoList.add(TodoData);
    }
}
