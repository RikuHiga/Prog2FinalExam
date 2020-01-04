package jp.ac.uryukyu.ie.e195760;

import java.util.Arrays;

/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    RemoveCommand removeCommand=new RemoveCommand();
    ViewManager viewcommand=new ViewManager();
    //String[] viewCmd={"","",""};//visibleList更新用
    //Main main=new Main();
    void classify(String cmd){
        if(cmd.split(" ",3).length>=1){//コマンドが何も入力されていなかったら弾く
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
            if(splitCmd[0].equals(Main.ADD)&&!splitCmd[1].equals("")){//addコマンドでタイトルが入力されている場合
                addCommand.add(splitCmd);
                //viewcommand.View(viewCmd);
            }else if(splitCmd[0].equals(Main.REMOVE)&&!splitCmd[1].equals("")){
                if(TodoManager.visibleList.size()>=Integer.parseInt(splitCmd[1])&&Integer.parseInt(splitCmd[1])>0){
                    //removeの後に指定した数がvisibleListの範囲内に収まっていたら
                    removeCommand.remove(splitCmd);
                }else{
                    System.out.println("removeの後の数が不正です。");
                }
            }else if(splitCmd[0].equals(Main.VIEW)){
                TodoManager.updateVisibleList(splitCmd);//指定された場所のvisibleListを作る
            }else{
                System.out.println("不明なコマンドです");
            }
        }else{
            System.out.println("不正なコマンドです。");
        }
    }
}
