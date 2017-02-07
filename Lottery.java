package twilighce.github.io.lottery;

/**
 * Created by Twilighce on 2017/2/7.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    //创建生成彩票前半段号码的方法
    public List<String> getHeadNumber() {

        List<String> list = new ArrayList<String>();
        String lotteryNumber = "";

        //这个循环是为了初始化彩票的前半段号码集合
        for (int i = 1; i < 36; i++) {

            if (i < 10) {
                //向集合中添加0~9的号码，因为是单位数，在十位上添加0
                list.add("0" + i + " ");
            }

            else {
                //向集合中添加大于9的号码，双位数
                list.add("" + i + " ");
            }
        }

        //创建并初始化随机数
        int roundIndex = 0;

        //保存前段号码的List集合
        List<String> lotteryList = new ArrayList<String>();

        for (int j = 0; j < 5; j++) {
            int amount = list.size(); //提取前半段号码的个数
            Random r = new Random();  //创建并实例化Random的对象
            roundIndex = r.nextInt(amount);  //获取一个0到amount-1的随机数
            lotteryNumber = list.get(roundIndex);  //获取彩票数字，即摇号的号码
            list.remove(roundIndex);  //移除刚刚产生的号码
        }

        Collections.sort(lotteryList); //对前半段号码进行排序
        return lotteryList;  //返回前半段号码
    }


    //创建生成彩票后半段号码的方法
    public List<String> getRearNumber() {

        List<String> list = new ArrayList<String>();
        String lotteryNumber = "";

        //这个循环是为了初始化彩票的后半段号码集合
        for (int i = 1; i < 13; i++) {

            if (i < 10) {
                //向集合中添加0~9的号码
                list.add("0" + i + " ");
            }

            else {
                //向集合中添加大于9的号码
                list.add("" + i + " ");
            }
        }

        //创建并初始化随机数
        int roundIndex = 0;

        //保存后半段号码的List集合
        List<String> lotteryList = new ArrayList<String>();

        for (int j = 0; j < 2; j++) {
            int amount = list.size();  //获取后半段号码的个数
            Random r = new Random(); // 创建并实例化Random的对象
            roundIndex = r.nextInt(amount); // 获取一个0到amount-1的随机数
            lotteryNumber = list.get(roundIndex); // 摇号
            lotteryList.add(lotteryNumber); // 将彩票号码添加lotteryList中
            list.remove(roundIndex); // 移除刚刚产生的号码
        }

        Collections.sort(lotteryList);  //对后半段号码进行排序
        return lotteryList;  //返回后半段号码
    }


    public void generateLottery(String groupNum) {

        int groupNumber = 0;  //为了避免不必要的错误，一般在创建变量时都要为其赋初始值

        groupNumber = Integer.parseInt(groupNum);
        // 创建字符串生成器对象，使用字符串生成器能够较为方便地在字符串中追加内容
        StringBuilder sbuiler = new StringBuilder();

        for (int i = 0; i < groupNumber; i++) {

            // 获得彩票前半段号码的集合
            List<String> startList = getHeadNumber();

            // 获得彩票后半段号码的集合
            List<String> endList = getRearNumber();

            for (int m = 0; m < startList.size(); m++) {
                // append()用于添加彩票的前半段号码到字符串生成器中
                sbuiler.append(startList.get(m));
            }
            sbuiler.append("    ");

            for (int n = 0; n < endList.size(); n++) {
                // 添加彩票的后半段号码到字符串生成器中
                sbuiler.append(endList.get(n));
            }
            sbuiler.append("\n");
        }

        //将生成好的彩票号码输出
        System.out.println(sbuiler.toString());
    }
}
