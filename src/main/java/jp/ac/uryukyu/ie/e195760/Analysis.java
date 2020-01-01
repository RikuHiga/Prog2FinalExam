package jp.ac.uryukyu.ie.e195760;

/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    RemoveCommand removeCommand=new RemoveCommand();
    Main main=new Main();
    void classify(String cmd){
        if(cmd.split(" ",3).length>1){
            if(cmd.split(" ",3).length==2){
                splitCmd[0]=cmd.split(" ",3)[0];
                splitCmd[1]=cmd.split(" ",3)[1];
                splitCmd[2]="";
            }else{
                splitCmd[0]=cmd.split(" ",3)[0];
                splitCmd[1]=cmd.split(" ",3)[1];
                splitCmd[2]=cmd.split(" ",3)[2];
            }
            if(splitCmd[0].equals(main.ADD)){
                addCommand.add(splitCmd);
            }else if(splitCmd[0].equals(main.REMOVE)){
                removeCommand.remove(splitCmd);
            }else{
                System.out.println("不正なコマンドです");
            }
        }else{
            System.out.println("不正なコマンドです。");
        }
    }
}
