package jp.ac.uryukyu.ie.e195760;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Analysisクラスの、コマンド調整機能が意図通り動いているかの確認。
 */
class AnalysisTest {

    @Test
    void adjastCommand() {
        String cmd="add title";
        String[] idealCmd={"add","title",""};
        String[] adjustCmd;
        Analysis analysis=new Analysis();
        adjustCmd=analysis.adjustCommand(cmd);
        assertEquals(Arrays.toString(adjustCmd), Arrays.toString(idealCmd));
    }
}