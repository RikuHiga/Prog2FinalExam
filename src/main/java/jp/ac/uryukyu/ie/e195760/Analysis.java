package jp.ac.uryukyu.ie.e195760;

/**
 * 入力されたコマンドを解析する。
 */
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    void classify(String cmd){
        System.out.println("Classify起動");
        splitCmd=cmd.split(" ",3);
        if(splitCmd[0].equals("add")){
            addCommand.add(splitCmd);
        }
    }
}
