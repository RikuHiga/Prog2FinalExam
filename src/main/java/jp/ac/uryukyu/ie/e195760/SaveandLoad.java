package jp.ac.uryukyu.ie.e195760;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * TodoListをセーブするクラス。csv形式で保存する
 */
public class SaveandLoad {
    String savedata;
    void save(){
        System.out.println("SaveFile実行");
        try {
            FileWriter fileWriter = new FileWriter(Main.FILENAME);
            for(String[] todolist:TodoManager.todoList){
                //System.out.println(todolist[0]+","+todolist[1]+","+todolist[2]+","+todolist[3]+","+todolist[4]+","+todolist[5]+","+todolist[6]);
                fileWriter.write(todolist[0]+","+todolist[1]+","+todolist[2]+","+todolist[3]+","+todolist[4]+","+todolist[5]+","+todolist[6]+"\n");
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
