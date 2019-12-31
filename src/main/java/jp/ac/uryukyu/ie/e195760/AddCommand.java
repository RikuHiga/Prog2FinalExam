package jp.ac.uryukyu.ie.e195760;

import java.util.Arrays;

public class AddCommand {
    String[] additionalConfig=new String[7];
    //Main main=new Main();
    TodoManager todo=new TodoManager();
    void add(String[] cmd){
        System.out.println("add起動");
        String[] todoData={"","","","","","false","false","false"};//タイトル,説明,締切,所要時間,タグ,優先タグ,完了した,捨てた
        todoData[0]=cmd[1];
        additionalConfig=cmd[2].split(",");
        for(String splitCmd:additionalConfig){
            if(splitCmd.indexOf(Main.DESCRIPTION[0])==0){//"description="が一番最初に来るとはdescriptionコマンドが入力されたということ
                todoData[1] = splitCmd.split(Main.DESCRIPTION[0])[1];
            }
            else if(splitCmd.indexOf(Main.DEADLINE[0])==0){
                todoData[2] = splitCmd.split(Main.DEADLINE[0])[1];
            }
            else if(splitCmd.indexOf(Main.TAG[0])==0){
                todoData[3] = splitCmd.split(Main.TAG[0])[1];
            }
            else if(splitCmd.indexOf(Main.DURATION[0])==0){
                todoData[4] = splitCmd.split(Main.DURATION[0])[1];
            }
            else if(splitCmd.equals(Main.PRIORITY[0])){
                todoData[5] = "true";
            }
        }
        TodoManager.todoList.add(todoData);

    }
}
