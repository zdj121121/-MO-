import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Match
 * @Description 匹配算法
 * @Author ZDJ
 * @Date 2018/6/14 16:52
 * @Version 1.0
 **/

public class Match {
    /**
     * @return java.util.List<Data>
     * @author ZDJ
     * @Description 发送号码匹配
     * @Date 22:52 2018/6/14
     * @Param [num, list]
     **/
    public List<Data> matchAccessNo(String num, List<Data> list) {
        List<Data> result = new ArrayList<Data>();
        for (Data data : list) {
            if (data.isANCheckFlag()) {
                if (num.equals(data.getAccessNo()))
                    result.add(data);
            } else {
                if (matchBlur(num, data.getAccessNo()))
                    result.add(data);
            }
        }
        return result;
    }

    /**
     * @return Data
     * @author ZDJ
     * @Description 发送内容匹配
     * @Date 22:52 2018/6/14
     * @Param [content, list]
     **/
    public Data matchFeatureStr(String content, List<Data> list) {
        List<Data> result = new ArrayList<Data>();
        for (Data data : list) {
            if (data.isFSCheckFlag()) {
                if (content.equals(data.getFeatureStr()))
                    result.add(data);
            } else {
                if (data.getFeatureStr() == null) {
                    result.add(data);
                } else if (matchBlur(content, data.getFeatureStr())) {
                    result.add(data);
                }
            }
        }
        if (result.size() == 0) return null;
        else if (result.size() == 1) return result.get(0);
        else {
            Data data = result.get(0);
            for (Data data1 : result) {
                if (data.getFeatureStr() != null && data1.getFeatureStr() != null) {
                    if (data1.getFeatureStr().length() > data.getFeatureStr().length())
                        data = data1;
                }
            }
            return data;
        }
    }

    /**
     * @return boolean
     * @author ZDJ
     * @Description 模糊匹配
     * @Date 22:52 2018/6/14
     * @Param [source, target]
     **/
    public boolean matchBlur(String source, String target) {
        if (source.length() < target.length()) return false;
        int max = source.length()-target.length();
        char first = target.charAt(0);
        int i = 0;
        while (i < max) {
            if (source.charAt(i) != first)
                while (i < max && source.charAt(i) != first) {//源字符串中寻找与目标字符串第一个匹配的位置
                i++;
                }
            if (i <= max) {
                int j = i + 1;
                int end = i + target.length();
                int k = 1;
                while (j < end&& source.charAt(j) == target.charAt(k)) {//从第一个位置开始匹配到目标字符串末尾
                    j++;
                    k++;
                }
                if (j == end) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

}
