package jp.ac.uryukyu.ie.e195760;

import java.io.*;

/**
 * TodoListをセーブするクラス。csv形式で保存する
 */
public class SaveandLoad {
    //String savedata;
    void save(){
        try {
            FileWriter fileWriter = new FileWriter(Main.FILENAME);
            for(String[] todolist:TodoManager.todoList){
                fileWriter.write(
                        todolist[0]+","+todolist[Integer.parseInt(Main.DESCRIPTION[2])]+
                                ","+todolist[Integer.parseInt(Main.DEADLINE[2])]+","+todolist[Integer.parseInt(Main.DURATION[2])]+
                                ","+todolist[Integer.parseInt(Main.TAG[2])]+","+todolist[Main.TIMESTAMP]+","+todolist[Integer.parseInt(Main.PRIORITY[2])]+
                                ","+todolist[Integer.parseInt(Main.COMPLETE[2])]+","+todolist[Integer.parseInt(Main.TRASH[2])]+
                                "\n");
            }
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    void load(){
        try{
            File file = new File(Main.FILENAME);
            if (!file.exists()) {
                System.out.println("ファイルなし");
                return;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                TodoManager.todoList.add(data.split(","));
            }
            bufferedReader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
