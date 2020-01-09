package jp.ac.uryukyu.ie.e195760;

public class editCommand {
    void edit(String[] cmd){
        String[] todo;
        String[] splitCmd;
        //指定されたtodoを持ってくる
        try{
            todo=TodoManager.todoList.get(TodoManager.visibleList.get(Integer.parseInt(cmd[1])-1));
            //cmd[2]を","で分割する
            splitCmd=cmd[2].split(",");
            for(String config:splitCmd){//config:title=example
                //コマンドを一個ずつ、持ってきたtodoに適用する
                if(config.indexOf(Main.TITLE[0])==0){
                    todo[Integer.parseInt(Main.TITLE[2])]=config.split(Main.TITLE[0])[1];
                }else if(config.indexOf(Main.DESCRIPTION[0])==0){
                    todo[Integer.parseInt(Main.DESCRIPTION[2])]=config.split(Main.DESCRIPTION[0])[1];
                }else if(config.indexOf(Main.DEADLINE[0])==0){
                    todo[Integer.parseInt(Main.DEADLINE[2])]=config.split(Main.DEADLINE[0])[1];
                }else if(config.indexOf(Main.TAG[0])==0){
                    todo[Integer.parseInt(Main.TAG[2])]=config.split(Main.TAG[0])[1];
                }else if(config.indexOf(Main.DURATION[0])==0){
                    todo[Integer.parseInt(Main.DURATION[2])]=config.split(Main.DURATION[0])[1];
                }else if(config.equals(Main.PRIORITY[0])){
                    if(todo[Integer.parseInt(Main.PRIORITY[2])].equals("true")){
                        todo[Integer.parseInt(Main.PRIORITY[2])]="false";
                    }else{
                        todo[Integer.parseInt(Main.PRIORITY[2])]="true";
                    }
                }else{
                    System.out.println(config+"は不明なコマンドです。");
                }
                //変更したtodoを元の場所に戻す
            }
            TodoManager.todoList.set(TodoManager.visibleList.get(Integer.parseInt(cmd[1])-1),todo);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }

    }
}
