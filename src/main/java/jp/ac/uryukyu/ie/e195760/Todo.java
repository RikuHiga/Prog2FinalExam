package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODOリストを管理するクラス
 */
public class Todo {
    ArrayList<String[]> todoList=new ArrayList<String[]>();//タイトル,説明,日付,タグ,優先タグ
    String[] todoData=new String[5];
    //todoData={"TodoListを作る,JavaでTodoListを作る,201912261754,java,true".split(",");


    void ViewAll(){
        todoData="TodoListを作る,JavaでTodoListを作る,201912261754,java,true".split(",");
        todoData[4]="false";
        todoList.add(todoData);
        todoData="Pomodoroを作る,UnityでPomodoroを作る,201912261817,Unity,true".split(",");
        todoList.add(todoData);
        todoData="どう森のBGMを編集する,音源編集ソフトでintroとmainに分ける,201912261818,Unity,true".split(",");
        todoList.add(todoData);
        todoData=todoList.get(1);
        todoData[4]="false";
        for(String[] n:todoList){
            System.out.println(Arrays.toString(n));
        }
    }
}
