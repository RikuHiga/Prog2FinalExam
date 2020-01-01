package jp.ac.uryukyu.ie.e195760;

import java.util.Arrays;

//remove 5
//remove index の後のvisibleList[index-1]を持ってくる
//持ってきた数番目のtodoListを持ってくる
//trashをtrueに変更する
//同じ場所に戻す
public class RemoveCommand {
    int index;
    String[] todo;
    void remove(String[] cmd){
        try{
            index=Integer.parseInt(cmd[1]);
        }catch(NumberFormatException ex){
            System.out.println("数値以外の指定");
            //文字列で検索してもいい
        }
        todo=TodoManager.todoList.get(TodoManager.visibleList.get(index-1));
        System.out.println(Arrays.toString(todo));
    }
}
