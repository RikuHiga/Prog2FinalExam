package jp.ac.uryukyu.ie.e195760;

/**
 * タスクを追加するコマンドの処理。
 */
public class AddCommand {
    /**
     * コマンドに従ってtodoListにタスクを追加するメソッド。
     * @param cmd 入力されたコマンド
     */
    void add(String[] cmd){
        String[] additionalConfig;
        String[] todoData=Main.TODODATA.clone();//ディープコピー
        try{
            todoData[Integer.parseInt(Main.TITLE[2])]=cmd[1];
            additionalConfig=cmd[2].split(",");//todoの追加設定を分割して格納
            for(String splitCmd:additionalConfig){
                if(splitCmd.indexOf(Main.DESCRIPTION[0])==0&&splitCmd.split(Main.DESCRIPTION[0]).length>=1){//"description="が一番最初に来るとはdescriptionコマンドが入力されたということ
                    todoData[Integer.parseInt(Main.DESCRIPTION[2])] = splitCmd.split(Main.DESCRIPTION[0])[1];//"description="以外を抽出
                }
                else if(splitCmd.indexOf(Main.DEADLINE[0])==0&&splitCmd.split(Main.DEADLINE[0]).length>=1){
                    todoData[Integer.parseInt(Main.DEADLINE[2])] = splitCmd.split(Main.DEADLINE[0])[1];
                }
                else if(splitCmd.indexOf(Main.TAG[0])==0&&splitCmd.split(Main.TAG[0]).length>=1){
                    todoData[Integer.parseInt(Main.TAG[2])] = splitCmd.split(Main.TAG[0])[1];
                }
                else if(splitCmd.indexOf(Main.DURATION[0])==0&&splitCmd.split(Main.DURATION[0]).length>=1){
                    todoData[Integer.parseInt(Main.DURATION[2])] = splitCmd.split(Main.DURATION[0])[1];
                }
                else if(splitCmd.equals(Main.PRIORITY[0])){
                    todoData[Integer.parseInt(Main.PRIORITY[2])] = "true";
                }
            }
        }catch(NumberFormatException ex){
            System.out.println("数値を指定してください。");
        }
        TodoManager.todoList.add(todoData);
        TodoManager.updateVisibleList(Main.DEFAULTVIEW);//visibleリスト更新
    }
}
