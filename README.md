# GenerateLottery

## 问题描述

制作一个大乐透号码生成器：从1~35中随机选取5个不重复的数字，从1~12中随机选取2个不重复的数字，这些数字组成一个七位数。

## 模块介绍 

Lottery类用于生成大乐透号码，其中：

- getHeadNumber()方法用于生成前半段号码。该方法需要从1到36中随机选取一个数作为号码。并调用Collections.sort()方法对结果进行排序。

- getRearNum()方法用于生成后半段号码。

- genarateLottery(String groupNum)方法用于生成最终结果，具体生成多少组号码依据用户的需求。

LotteryTest类用于测试。

- 在其中创建一个彩票对象并调用其产生号码的方法。

