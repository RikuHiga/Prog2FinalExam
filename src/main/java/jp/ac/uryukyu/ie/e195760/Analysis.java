package jp.ac.uryukyu.ie.e195760;

import java.util.Arrays;

/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    //RemoveCommand removeCommand=new RemoveCommand();
    //RemoveAndComplete removeAndComplete=new RemoveAndComplete();
    RemoveCompleteSalvage removeCompleteSalvage=new RemoveCompleteSalvage();
    ViewManager viewcommand=new ViewManager();
    //String[] viewCmd={"","",""};//visibleList更新用
    //Main main=new Main();
    void classify(String cmd){
        try{
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
                        removeCompleteSalvage.remove(splitCmd);
                    }else{
                        System.out.println("removeの後の数が不正です。");
                    }
                }else if(splitCmd[0].equals(Main.VIEW)){
                    TodoManager.updateVisibleList(splitCmd);//指定された場所のvisibleListを作る
                }else if(splitCmd[0].equals(Main.COMPLETE[0])&&!splitCmd[1].equals("")){
                    if(TodoManager.visibleList.size()>=Integer.parseInt(splitCmd[1])&&Integer.parseInt(splitCmd[1])>0){
                        //removeの後に指定した数がvisibleListの範囲内に収まっていたら
                        removeCompleteSalvage.complete(splitCmd);
                    }else{
                        System.out.println("completeの後の数が不正です。");
                    }
                }else if(splitCmd[0].equals(Main.SALVAGE)&&!splitCmd[1].equals("")){
                    if(TodoManager.visibleList.size()>=Integer.parseInt(splitCmd[1])&&Integer.parseInt(splitCmd[1])>0){
                        //removeの後に指定した数がvisibleListの範囲内に収まっていたら
                        removeCompleteSalvage.salvage(splitCmd);
                    }else{
                        System.out.println("completeの後の数が不正です。");
                    }
                }else{
                    System.out.println("不明なコマンドです");
                }
            }else{
                System.out.println("不正なコマンドです。");
            }
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }

    }
}
