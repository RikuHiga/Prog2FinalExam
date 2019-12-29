package jp.ac.uryukyu.ie.e195760;
//continue文をうまく使って処理を飛ばせるかも

import java.util.Arrays;

public class AddCommand {
    String[] todoData={"","","","","false","false","false"};//タイトル,説明,日付,タグ,優先タグ,完了した,捨てた
    String[] additionalConfig=new String[7];
    Main main=new Main();
    TodoManager todo=new TodoManager();
    public AddCommand(){
        todoData[5]="false";
        todoData[6]="false";
    }
    void add(String[] cmd){
        //boolean checkDescription=false,checkDeadline=false,checkTag=false,checkPriority=false;
        System.out.println("add起動");
        todoData[0]=cmd[1];
        additionalConfig=cmd[2].split(",");
        for(String splitCmd:additionalConfig){
            if(splitCmd.indexOf(main.DESCRIPTION)==0){//"description="が一番最初に来るとはdescriptionコマンドが入力されたということ
                todoData[1] = splitCmd.split(main.DESCRIPTION)[1];
            }
            else if(splitCmd.indexOf(main.DEADLINE)==0){
                todoData[2] = splitCmd.split(main.DEADLINE)[1];
            }
            else if(splitCmd.indexOf(main.TAG)==0){
                todoData[3] = splitCmd.split(main.TAG)[1];
            }
            else if(splitCmd.equals(main.PRIORITY)){
                todoData[4] = "true";
            }
        }
        todo.TodoAdd(todoData);

    }
}
