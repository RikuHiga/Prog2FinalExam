package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODOリストを管理し、ViewAll機能を制御するクラス。
 */
public class TodoManager {
    public static ArrayList<String[]> todoList=new ArrayList<String[]>();
    public static ArrayList<Integer> visibleList=new ArrayList<Integer>();

    /**
     * タスク一覧を表示するためのvisibleListを作る。フィルター機能あり
     */
    static void updateVisibleList(String[] cmd){
        visibleList.clear();
        //TodoManager.visibleList=new ArrayList<Integer>();
        int count=0;//todoListの何番目にあるかを示すために使う
        //System.out.println("==========================================");
        for(String[] todoList:TodoManager.todoList){//フィルターをかける
            if(cmd[1].equals(Main.COMPLETE[0])){
                if(todoList[Integer.parseInt(Main.COMPLETE[2])]=="true"){

                }
            }else if(cmd[1].equals(Main.PRIORITY[0])){
                if(todoList[Integer.parseInt(Main.PRIORITY[2])]=="true"){

                }
            }else if(cmd[1].equals(Main.TRASH[0])){
                if(todoList[Integer.parseInt(Main.TRASH[2])]=="true"){

                }
            }else if(cmd[1].equals(Main.TAG[0])){
                if(todoList[Integer.parseInt(Main.TAG[2])]==cmd[2]){//コマンドはview tag=otherなどとする予定

                }
            }else{//デフォルト

//                System.out.println(todoList[Integer.parseInt(Main.COMPLETE[2])]);
                System.out.println(todoList[Integer.parseInt(Main.TRASH[2])]);
                if(todoList[Integer.parseInt(Main.COMPLETE[2])].equals("false")&&todoList[Integer.parseInt(Main.TRASH[2])].equals("false")){
                    //未完了タスクかつゴミ箱に入っていないタスク
                    TodoManager.visibleList.add(count);
                    //System.out.println(Arrays.toString(todoList)+count);
                }
            }
//            if(!todoList[Integer.parseInt(Main.TRASH[2])].equals("true")){//可変にする
//                TodoManager.visibleList.add(count);
//            }
            count++;//todoListの何番目にあるかを数える用
        }
        //System.out.println("==========================================");
    }
}