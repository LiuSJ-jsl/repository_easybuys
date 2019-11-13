package com.htkj.subject.util;

import java.util.Random;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/13 10:09
 */
public class GetRundom {
    public String getRundom(int n) {
        String string = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大写字母
        StringBuffer sb = new StringBuffer(); //声明一个StringBuffer对象sb 保存 验证码
        for (int i = 0; i < n; i++) {
            Random random = new Random();//创建一个新的随机数生成器
            int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
            char ch = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》赋值给char字符对象ch
            sb.append(ch);// append(char c) :将 char 参数的字符串表示形式追加到此序列  ==》即将每次获取的ch值作拼接
        }
        return sb.toString();//toString() : 返回此序列中数据的字符串表示形式   ==》即返回一个String类型的数据
    }
}
