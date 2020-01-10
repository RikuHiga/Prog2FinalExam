package jp.ac.uryukyu.ie.e195760;
/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    /**
     * コマンドの調整を行い、必ず三つの要素の配列に変換して返す。"add"と入力された場合、["add","",""]に変換する。
     * @param cmd 入力されたコマンド
     * @return 三つに分割されたコマンド
     */
    String[] adjastCommand(String cmd){
        String[] splitCmd=new String[3];
        if(cmd.split(" ",3).length==1){
            splitCmd[0]=cmd.split(" ",3)[0];
            splitCmd[1]="";
            splitCmd[2]="";
        }else if(cmd.split(" ",3).length==2){//"add title"など追加設定が入力されていない場合、三つ目を作る
            splitCmd[0]=cmd.split(" ",3)[0];
            splitCmd[1]=cmd.split(" ",3)[1];
            splitCmd[2]="";
        }else{
            splitCmd=cmd.split(" ",3);
        }
        return splitCmd;
    }

    /**
     * コマンドを解析して、適したメソッドを起動する
     * @param cmd 入力されたコマンド
     */
    void classify(String cmd){
        AddCommand addCommand=new AddCommand();
        RemoveCompleteSalvage removeCompleteSalvage=new RemoveCompleteSalvage();
        ViewManager viewcommand=new ViewManager();
        editCommand editCommand=new editCommand();
        helpCommand help=new helpCommand();
        String[] splitCmd=new String[3];
        try{
            if(!cmd.split(" ",3)[0].equals("")){//コマンドが何も入力されていなかったら弾く
                splitCmd=adjastCommand(cmd);
                if(splitCmd[0].equals(Main.ADD)&&!splitCmd[1].equals("")){
                    addCommand.add(splitCmd);
                }else if(splitCmd[0].equals(Main.VIEW)){
                    TodoManager.updateVisibleList(splitCmd);//指定された場所のvisibleListを作る
                }else if(splitCmd[0].equals(Main.HELP)){
                    help.help(splitCmd);
                }else if(TodoManager.visibleList.size()>=Integer.parseInt(splitCmd[1])&&Integer.parseInt(splitCmd[1])>0&&!splitCmd[1].equals("")){
                    if(splitCmd[0].equals(Main.REMOVE)){
                        removeCompleteSalvage.remove(splitCmd);
                    }else if(splitCmd[0].equals(Main.COMPLETE[0])){
                        removeCompleteSalvage.complete(splitCmd);
                    }else if(splitCmd[0].equals(Main.SALVAGE)){
                        removeCompleteSalvage.salvage(splitCmd);
                    }else if(splitCmd[0].equals(Main.EDIT)){
                        editCommand.edit(splitCmd);
                    }else{
                        System.out.println("不明なコマンドです");
                    }
                }else{
                    System.out.println("範囲内の数を指定してください。");
                }
            }
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
    }
}
