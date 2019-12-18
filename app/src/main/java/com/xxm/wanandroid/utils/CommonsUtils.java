package com.xxm.wanandroid.utils;

import android.graphics.Color;
import android.util.Log;

import net.sourceforge.pinyin4j.PinyinHelper;

public class CommonsUtils {


    private static final String TAG = CommonsUtils.class.getSimpleName();

    /**
     * 提取首个字符的首字母，其他返回*
     *
     * @param str
     * @return String
     */
    public static String getFirstPinYinHeadChar(String str) {
        StringBuffer pybf = new StringBuffer();
        char word = str.charAt(0);
        // 提取汉字的首字母
        String[] pinyinArray;
        // 是否是因为字母
        if (word > 128) {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            // 如果不是汉字，就返回*
            if (pinyinArray != null) {
                pybf.append(pinyinArray[0].charAt(0));
            } else {
                pybf.append("*");
            }
        } else {

            // 是字母直接返回，不是返回*
            if (Character.isLetter(word)) {
                pybf.append(word);
            } else {
                pybf.append("*");
            }
        }

        // 全部返回大写
        return pybf.toString().toUpperCase();
    }

    public static int getChipBgColor(String name) {
        String pinyin = getFirstPinYinHeadChar(name);
        Log.d(TAG, "pinyin=" + pinyin);
        pinyin = pinyin.substring(0, 1).toUpperCase();
        return nameToColor(pinyin);
    }

    /**
     * 提取每个汉字的首字母
     *
     * @param str
     * @return String
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    private static int nameToColor(String name) {
        if (name.equals("*")) {
            return Color.RED;
        }
        int hash = DartHashCode.valueOf(name).getValue() & 0xffff;
        float hue = (360.0f * hash / (1 << 15)) % 360.0f;
        Log.d(TAG, "(float) hue=" + hue);
        return Color.HSVToColor(new float[]{hue, 0.4f, 0.90f});
        //return HSVColor.fromAHSV(1.0, hue, 0.4, 0.90).toColor();
    }
}
