package com.example.oder_putout.service.impl;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.stereotype.Service;

@Service
public class CNChangeServiceImpl {

    public String CNChange(String chinese){
        String convert = "";
        for (int i = 0; i < chinese.length(); i++) {
            char word = chinese.charAt(i);
            //提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null){
                convert += pinyinArray[0].charAt(0);
            }else{
                convert += word;
            }
        }
        return convert.toUpperCase();
    }


}
