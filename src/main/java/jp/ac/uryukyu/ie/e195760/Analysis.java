package jp.ac.uryukyu.ie.e195760;

/**
 * 入力されたコマンドを解析する。
 */
//add イラストを描く description=いぬいらすとを描く,deadline=2020-8-32,tag=趣味,special
public class Analysis {
    String[] splitCmd=new String[3];
    AddCommand addCommand=new AddCommand();
    void classify(String cmd){
        System.out.println("Classify起動");
        splitCmd=cmd.split(" ");
        if(splitCmd[0].equals("add")){
            addCommand.add(splitCmd);
        }
    }
}
