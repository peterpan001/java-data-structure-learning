package com.panli.sword.offer._0005;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 替换空格
 */
public class Main {

    /**
     * 借助字符串API:replace方法
     *
     * @param s
     * @return
     */
    public String replaceSpace_1(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 借助字符串API:charAt,依次判断是否为空格，空格替换为"%20"，否则不替换
     * StringBuilder:线程安全;StringBuffer:线程不安全
     *
     * @param s
     * @return
     */
    public String replaceSpace_2(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
