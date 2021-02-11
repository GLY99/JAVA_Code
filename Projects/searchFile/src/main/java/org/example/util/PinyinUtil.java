package org.example.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {
    public static String getPinyin(String name){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuffer sb = new StringBuffer();
        for (char ch : name.toCharArray()){
            try {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch,format);//拼音下标一一对应
                if (pinyinArray == null || pinyinArray.length == 0){
                    sb.append(ch);
                    continue;
                }
                sb.append(pinyinArray[0]);
            }catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String getPinyinFirst(String name){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuffer sb = new StringBuffer();
        for (char ch : name.toCharArray()){
            try {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch,format);//拼音下标一一对应(不是汉语的会出错)
                if (pinyinArray == null || pinyinArray.length == 0){
                    sb.append(ch);
                    continue;
                }
                sb.append(pinyinArray[0].charAt(0));
            }catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String ret = getPinyin("好好，ret");
        System.out.println(ret);
    }
}
