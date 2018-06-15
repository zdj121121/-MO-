/**
 * @ClassName Data
 * @Description 数据类
 * @Author ZDJ
 * @Date 2018/6/14 16:29
 * @Version 1.0
 **/
public class Data {
    private int seq;
    private String accessNo;
    private String featureStr;
    private boolean ANCheckFlag;
    private boolean FSCheckFlag;

    public int getSeq() {
        return seq;
    }
    public String getAccessNo() {
        return accessNo;
    }
    public String getFeatureStr() {
        return featureStr;
    }
    public boolean isANCheckFlag() {
        return ANCheckFlag;
    }
    public boolean isFSCheckFlag() {
        return FSCheckFlag;
    }

    /**
     * @return
     * @author ZDJ
     * @Description
     * @Date 16:51 2018/6/14
     * @Param [seq, accessNo, featureStr, ANCheckFlag, FSCheckFlag]
     **/
    public Data(int seq, String accessNo, String featureStr, boolean ANCheckFlag, boolean FSCheckFlag) {
        this.seq = seq;
        this.accessNo = accessNo;
        this.featureStr = featureStr;
        this.ANCheckFlag = ANCheckFlag;
        this.FSCheckFlag = FSCheckFlag;
    }
}
