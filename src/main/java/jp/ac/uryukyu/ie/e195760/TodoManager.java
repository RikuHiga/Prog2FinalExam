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
     * @param cmd 入力されたコマンド
     */
    static void updateVisibleList(String[] cmd){
        delete();

//        for(String[] tmp:todoList){
//            System.out.println(Arrays.toString(tmp));
//        }

        visibleList.clear();
        int count=0;//todoListの何番目にあるかを示すために使う
        try{
            for(String[] todoList:TodoManager.todoList){//フィルターをかける
//                if(!todoList[Main.TIMESTAMP].equals("")){//完了、もしくは廃棄されてからしばらく経ったタスクを消去する
//                    TimeStamp tStamp = new TimeStamp();
//                    if(tStamp.daycount(todoList[Main.TIMESTAMP])>=Main.DELETELIMIT){//todoListを回してる間にtodoListを変更できない
//                        deleteList.add(count);
//                    }
//                }

                if(cmd[1].equals(Main.COMPLETE[0])){
                    ViewManager.place=Main.COMPLETE[1];
                    if(todoList[Integer.parseInt(Main.COMPLETE[2])].equals("true")){
                        TodoManager.visibleList.add(count);
                    }
                }else if(cmd[1].equals(Main.PRIORITY[0])){
                    ViewManager.place=Main.PRIORITY[1];
                    if(todoList[Integer.parseInt(Main.PRIORITY[2])].equals("true")&&todoList[Integer.parseInt(Main.COMPLETE[2])].equals("false")){
                        //優先タグがついているかつ、未完了
                        TodoManager.visibleList.add(count);
                    }
                }else if(cmd[1].equals(Main.TRASH[0])){
                    ViewManager.place=Main.TRASH[1];
                    if(todoList[Integer.parseInt(Main.TRASH[2])].equals("true")){
                        TodoManager.visibleList.add(count);
                    }
                }else if(cmd[1].indexOf(Main.TAG[0])==0&&cmd[1].split("=").length==2){
                    String tag=cmd[1].split("=")[1];
                    ViewManager.place=Main.TAG[1]+":"+tag;
                    if(todoList[Integer.parseInt(Main.TAG[2])].equals(tag)&&todoList[Integer.parseInt(Main.COMPLETE[2])].equals("false")){//コマンドはview tag=otherなどとする予定
                        TodoManager.visibleList.add(count);
                    }
                }else{//デフォルト
                    ViewManager.place=Main.INCOMPLETE[1];
                    if(todoList[Integer.parseInt(Main.COMPLETE[2])].equals("false")&&todoList[Integer.parseInt(Main.TRASH[2])].equals("false")){
                        //未完了タスクかつゴミ箱に入っていないタスク
                        TodoManager.visibleList.add(count);
                    }
                }
                count++;//todoListの何番目にあるかを数える用
            }
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }

    static void delete(){
        int count=0;
        ArrayList<Integer> deleteList=new ArrayList<Integer>();
        for(String[] todoList:todoList){
            if(!todoList[Main.TIMESTAMP].equals("")){//完了、もしくは廃棄されてからしばらく経ったタスクを消去する
                TimeStamp tStamp = new TimeStamp();
                if(tStamp.daycount(todoList[Main.TIMESTAMP])>=Main.DELETELIMIT){//todoListを回してる間にtodoListを変更できない
                    //System.out.println(Arrays.toString(todoList)+":"+count);
                    deleteList.add(count);
                }
            }
            count++;
        }
        if(deleteList.size()!=0){
            for(int countDelete=deleteList.size()-1;countDelete>=0;countDelete--){
                todoList.remove((int)deleteList.get(countDelete));
            }

        }
    }
}