package jp.ac.uryukyu.ie.e195760;

import java.util.ArrayList;

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
        int count=0;//todoListの何番目にあるかを示すために使う
        //System.out.println("==========================================");
        for(String[] todoList:TodoManager.todoList){//フィルターをかける
            if(cmd[1].equals(Main.COMPLETE[0])){
                ViewManager.place=Main.COMPLETE[1];
                if(todoList[Integer.parseInt(Main.COMPLETE[2])]=="true"){
                    TodoManager.visibleList.add(count);
                }
            }else if(cmd[1].equals(Main.PRIORITY[0])){
                ViewManager.place=Main.PRIORITY[1];
                if(todoList[Integer.parseInt(Main.PRIORITY[2])]=="true"){
                    TodoManager.visibleList.add(count);
                }
            }else if(cmd[1].equals(Main.TRASH[0])){
                ViewManager.place=Main.TRASH[1];
                if(todoList[Integer.parseInt(Main.TRASH[2])]=="true"){
                    TodoManager.visibleList.add(count);
                }
            }else if(cmd[1].indexOf(Main.TAG[0])==0&&cmd[1].split("=").length==2){
                String tag=cmd[1].split("=")[1];
                ViewManager.place=Main.TAG[1]+":"+tag;
                if(todoList[Integer.parseInt(Main.TAG[2])].equals(tag)){//コマンドはview tag=otherなどとする予定
                    TodoManager.visibleList.add(count);
                }
            }else{//デフォルト
                ViewManager.place=Main.INCOMPLETE[1];
                if(todoList[Integer.parseInt(Main.COMPLETE[2])].equals("false")&&todoList[Integer.parseInt(Main.TRASH[2])].equals("false")){
                    //未完了タスクかつゴミ箱に入っていないタスク
                    TodoManager.visibleList.add(count);
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