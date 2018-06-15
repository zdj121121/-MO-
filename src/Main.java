import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 主函数
 * @Author ZDJ
 * @Date 2018/6/14 18:33
 * @Version 1.0
 **/

public class Main {
    /**
     * @return void
     * @author ZDJ
     * @Description
     * @Date 22:56 2018/6/14
     * @Param [args]
     **/
    public static void main(String[] args) {
        List<Data> list = new ArrayList<Data>();
        Data data = new Data(1, "10628888", "xw", true, false);
        Data data1 = new Data(2, "1062888801", "xw", false, false);
        Data data2 = new Data(3, "1062888801", "xw1", false, true);
        Data data3 = new Data(4, "10628888", "01xw", true, true);
        Data data4 = new Data(5, "10628888", null, false, false);
        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入发送号码：");
        String accessNo = scanner.nextLine();
        System.out.print("请输入发送内容：");
        String featureStr = scanner.nextLine();
        Match match = new Match();
        List l = match.matchAccessNo(accessNo, list);
        Data da = match.matchFeatureStr(featureStr, l);
        if(da==null){
            System.out.println("匹配失败！");
        }else {
            System.out.println("匹配第" + da.getSeq() + "记录");
        }
    }
}
