package jp.ac.uryukyu.ie.e195760;

/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    RemoveCommand removeCommand=new RemoveCommand();
    //Main main=new Main();
    void classify(String cmd){
        if(cmd.split(" ",3).length>1){//コマンドのオプションまで入力されているか
            if(cmd.split(" ",3).length==2){//add titleなど追加設定が入力されていない場合、三つ目を偽装する
                splitCmd[0]=cmd.split(" ",3)[0];
                splitCmd[1]=cmd.split(" ",3)[1];
                splitCmd[2]="";
            }else{
                splitCmd=cmd.split(" ",3);
            }
            if(splitCmd[0].equals(Main.ADD)){
                addCommand.add(splitCmd);
            }else if(splitCmd[0].equals(Main.REMOVE)){
                if(TodoManager.visibleList.size()>=Integer.parseInt(splitCmd[1])&&Integer.parseInt(splitCmd[1])>0){
                    removeCommand.remove(splitCmd);
                }else{
                    System.out.println("removeの後の数が不正です。");
                }
            }else{
                System.out.println("不明なコマンドです");
            }
        }else{
            System.out.println("不正なコマンドです。");
        }
    }
}
