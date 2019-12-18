package com.xxm.wanandroid.utils;

import android.graphics.Color;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Random;

public class CommonsUtils {

    private static final String TAG = CommonsUtils.class.getSimpleName();

    /**
     * 提取首个字符的首字母，其他返回随机返回26个大写字母中的一个
     *
     * @param str       需要转换的字符串
     * @param defPinyin 不是字母返回的字符串
     * @return String
     */
    public static String getFirstPinYinHeadChar(String str, String defPinyin) {
        StringBuffer pybf = new StringBuffer();
        char word = str.charAt(0);
        // 提取汉字的首字母
        String[] pinyinArray;
        // 是否是因为字母
        if (word > 128) {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            // 如果不是汉字，就返回返回defPinyin
            if (pinyinArray != null) {
                pybf.append(pinyinArray[0].charAt(0));
            } else {
                pybf.append(defPinyin);
            }
        } else {
            // 是字母直接返回，不是返回defPinyin
            if (Character.isLetter(word)) {
                pybf.append(word);
            } else {
                pybf.append(defPinyin);
            }
        }

        // 全部返回大写
        return pybf.toString().toUpperCase();
    }

    public static int getChipBgColor(String name) {
        String pinyin = getFirstPinYinHeadChar(name, String.valueOf((char) (65 + new Random().nextInt(26))));
        //Log.d(TAG, "pinyin=" + pinyin);
        pinyin = pinyin.substring(0, 1).toUpperCase();
        return nameToColor(pinyin);
    }


    private static int nameToColor(String name) {
        int hash = DartHashCode.valueOf(name).getValue() & 0xffff;
        float hue = (360.0f * hash / (1 << 15)) % 360.0f;
        //Log.d(TAG, "(float) hue=" + hue);
        return Color.HSVToColor(new float[]{hue, 0.4f, 0.90f});
    }
}
