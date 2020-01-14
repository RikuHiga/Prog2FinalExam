package jp.ac.uryukyu.ie.e195760;

/**
 * タスクを変更するコマンドの処理。
 */
public class editCommand {
    /**
     * 指定されたtodoをコマンドの通りに書き換える。
     * @param cmd 入力されたコマンド
     */
    void edit(String[] cmd){
        String[] todo;
        String[] splitCmd;
        try{
            todo=TodoManager.todoList.get(TodoManager.visibleList.get(Integer.parseInt(cmd[1])-1));
            splitCmd=cmd[2].split(",");
            for(String config:splitCmd){
                if(config.indexOf(Main.TITLE[0])==0&&config.split(Main.TITLE[0]).length>=1){
                    todo[Integer.parseInt(Main.TITLE[2])]=config.split(Main.TITLE[0])[1];
                }else if(config.indexOf(Main.DESCRIPTION[0])==0){
                    if(config.split(Main.DESCRIPTION[0]).length==0){
                        todo[Integer.parseInt(Main.DESCRIPTION[2])]="";
                    }else{
                        todo[Integer.parseInt(Main.DESCRIPTION[2])]=config.split(Main.DESCRIPTION[0])[1];
                    }
                }else if(config.indexOf(Main.DEADLINE[0])==0){
                    if(config.split(Main.DEADLINE[0]).length==0){
                        todo[Integer.parseInt(Main.DEADLINE[2])]="";
                    }else{
                        todo[Integer.parseInt(Main.DEADLINE[2])]=config.split(Main.DEADLINE[0])[1];
                    }
                }else if(config.indexOf(Main.TAG[0])==0){
                    if(config.split(Main.TAG[0]).length==0){
                        todo[Integer.parseInt(Main.TAG[2])]="";
                    }else{
                        todo[Integer.parseInt(Main.TAG[2])]=config.split(Main.TAG[0])[1];
                    }
                }else if(config.indexOf(Main.DURATION[0])==0){
                    if(config.split(Main.DURATION[0]).length==0){
                        todo[Integer.parseInt(Main.DURATION[2])]="";
                    }else{
                        todo[Integer.parseInt(Main.DURATION[2])]=config.split(Main.DURATION[0])[1];
                    }
                }else if(config.equals(Main.PRIORITY[0])){
                    if(todo[Integer.parseInt(Main.PRIORITY[2])].equals("true")){
                        todo[Integer.parseInt(Main.PRIORITY[2])]="false";
                    }else{
                        todo[Integer.parseInt(Main.PRIORITY[2])]="true";
                    }
                }else{
                    System.out.println(config+"は不明なコマンドです。");
                }
            }
            TodoManager.todoList.set(TodoManager.visibleList.get(Integer.parseInt(cmd[1])-1),todo);
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }

    }
}
