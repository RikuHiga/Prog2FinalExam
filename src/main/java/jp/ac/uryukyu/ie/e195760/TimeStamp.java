package jp.ac.uryukyu.ie.e195760;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日時を記録したり今の日時と記録の比較をする。
 */
public class TimeStamp {
    /**
     * 今の日時を文字型で返すメソッド
     * @return 現在時刻をString型で返す
     */
    String getTime(){//セーブデータに追記するときに使う。
        String now;
        Date nowDate = new Date();//今の時間
        now = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(nowDate);//Date型をパターンに従ってStringに変換
        return now;
    }

//    long getTime(){
//        long now;
//        Date nowDate = new Date();//今の時間
//        now = nowDate.getTime();
//        //now = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(nowDate);//Date型をパターンに従ってStringに変換
//        return now;
//    }

    /**
     * 今の日時と、渡された日時の日数差を計算する
     * @param pastString 渡された日時記録
     * @return 今の日時と渡された日時の日数差
     */
    int daycount(String pastString){
        long diffDay;
        long now;
        long past;
        Date nowDate = new Date();//今の時間
        Date pastDate=new Date();
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        try{
            pastDate = sdFormat.parse(pastString);//strDateをsdFormatの形でDate型に変換しpastに代入
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        now = nowDate.getTime();
        past= pastDate.getTime();

        diffDay=(now-past)/(1000*60*60*24);
        return (int)diffDay;
    }
}
