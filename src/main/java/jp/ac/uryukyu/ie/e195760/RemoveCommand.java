//package jp.ac.uryukyu.ie.e195760;
//
//import java.util.Arrays;
//
///**
// * removeコマンドの処理。数字で指定されたタスクをゴミ箱に入れる。
// */
//public class RemoveCommand {
//    int index;
//    String[] todo;
//    void remove(String[] cmd){
//        //System.out.println(TodoManager.visibleList);
//        try{
//            index=Integer.parseInt(cmd[1]);
//        }catch(NumberFormatException ex){
//            System.out.println("数値以外の指定");
//            //文字列で検索してもいい
//        }
//        todo=TodoManager.todoList.get(TodoManager.visibleList.get(index-1));
//        todo[Integer.parseInt(Main.TRASH[2])]="true";
//        TodoManager.todoList.set(TodoManager.visibleList.get(index-1),todo);
//        TodoManager.updateVisibleList(Main.DEFAULTVIEW);
//    }
//}
