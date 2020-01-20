package jp.ac.uryukyu.ie.e195760;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Analysisクラスの、コマンド調整機能が意図通り動いているかの確認。
 */
class AnalysisTest {

    @Test
    void adjastCommand() {
        String cmd="add title";//入力されたと想定
        String[] idealCmd={"add","title",""};//理想の結果
        String[] adjustCmd;
        Analysis analysis=new Analysis();
        adjustCmd=analysis.adjustCommand(cmd);
        assertEquals(Arrays.toString(adjustCmd), Arrays.toString(idealCmd));
    }
}