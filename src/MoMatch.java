import java.util.*;
import java.lang.String;

/**
 * @ClassName MoMatch
 * @Description contains匹配
 * @Author ZDJ
 * @Date 2018/6/15 14:34
 * @Version 1.0
 **/

public class MoMatch {
    private static Map<String, String> MoMap = new HashMap<String, String>();

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String[][] MoArray = {

                {"1", "10628888", "xw", "1", "0"},
                {"2", "1062888801", "xw", "0", "0"},
                {"3", "1062888801", "xw1", "0", "1"},
                {"4", "10628888", "01xw", "1", "1"},
                {"5", "10628888", "null", "0", "0"},
        };
        for (String[] aMoArray : MoArray) {
            for (int j = 0; j < aMoArray.length; j++) {
                System.out.print(aMoArray[j] + " ");
                if (j == 4) {
                    System.out.println();
                }

            }
        }
        System.out.println("按照上面指令内容以及长号码输入进行测试");
        String zhiling = in.next();
        String number = in.next();
        MO(zhiling, number, MoArray);
        String val = null;
        String k = null;
        for (String key : MoMap.keySet()) {
            val = MoMap.get(key);
            k = key;
            break;
        }
        Map<String, String> map = new HashMap<String, String>();
        for (String key : MoMap.keySet()) {
            String value = MoMap.get(key);
            if (value.length() >= val.length()) {
                k = key;
            }
        }
        if (k == null) {
            System.out.println("匹配失败");
        } else {
            System.out.println("你匹配的是" + k + "条记录");
        }
    }

    private static void MO(String zhiling, String number, String[][] MoArray) {
        for (int i = 0; i < MoArray.length; i++) {
            if (MoArray[i][3].equals("1") && MoArray[i][4].equals("0")) {
                if (MoArray[i][1].equals(number) && zhiling.contains(MoArray[i][2])) {
                    MoMap.put((MoArray[i][0]), MoArray[i][1]);
                }
            } else if (MoArray[i][3].equals("0") && MoArray[i][4].equals("1")) {
                if (number.contains(MoArray[i][1]) && MoArray[i][2].equals(zhiling)) {
                    MoMap.put(MoArray[i][0], MoArray[i][1]);
                }
            } else if (MoArray[i][3].equals("0") && MoArray[i][4].equals("0")) {

                if (number.contains(MoArray[i][1]) && zhiling.contains(MoArray[i][2])) {
                    MoMap.put(MoArray[i][0], MoArray[i][1]);
                } else if (number.contains(MoArray[i][1]) && zhiling != null) {
                    MoMap.put(MoArray[i][0], MoArray[i][1]);
                }
            } else if (MoArray[i][3].equals("1") && MoArray[i][4].equals("1")) {
                if (MoArray[i][1].equals(number) && MoArray[i][2].equals(zhiling)) {
                    MoMap.put(MoArray[i][0], MoArray[i][1]);
                }
            }
        }

    }


}
