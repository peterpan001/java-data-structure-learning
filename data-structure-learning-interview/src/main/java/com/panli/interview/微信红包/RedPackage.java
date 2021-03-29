package com.panli.interview.微信红包;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lipan
 * @date 2020-12-07
 */
public class RedPackage {

    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        List<Integer> list = redPackage.getRandomRedPackageList(100, 10);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<Integer> getRandomRedPackageList(int totalMoney, int totalPerson) {
        // 存储随机红包列表
        List<Integer> redList = new ArrayList<Integer>();

        // 参数校验
        if (totalMoney <= 0 || totalPerson <= 0) {
            return redList;
        }

        if (totalPerson == 1) {
            redList.add(totalMoney);
            return redList;
        }

        // 随机种子
        Random random = new Random();
        // 随机分配给前n-1个人
        for (int i = 0; i < totalPerson - 1; i++) {
            int randomMoney = 0;
            while (true) {
                randomMoney = random.nextInt(totalMoney / (totalPerson - i) * 2 - 1) + 1;
                if (randomMoney <= totalMoney * 0.9) {
                    break;
                }
            }
            totalMoney -= randomMoney;
            redList.add(randomMoney);
        }
        // 剩余的给最后一个人
        redList.add(totalMoney);
        return redList;
    }
}
