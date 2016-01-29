package com.example.tacademy.sampletypeface1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;

/**
 * Created by Tacademy on 2016-01-29.
 */
public class FontManager  { // 싱글톤 사용하기 , 일반적으로 하나만 만들어야 하는 객체를 관리해야 할 때는 싱글톤 사용, 폰트는 하나만 필요
    private static FontManager instance;

    public static FontManager getInstance(){
        if(instance == null){
            instance = new FontManager();
        }
         return instance;
    }

    private FontManager(){

    }

    private static class FontItem{
        String name;
        String file;
        Typeface typeface;

        public FontItem(String name, String file){
            this.name =name;
            this.file = file;

        }

        public Typeface getTypeface(Context context,String name){
            if(this.name.equals(name)){
                if (typeface == null){
                    typeface = Typeface.createFromAsset(context.getAssets(), file);
                }
                return typeface;
            }
           return null;
        }
    }

    FontItem[] fontList = { new FontItem(FONT_NAME_NANUM, FONT_FILE_NANUM),
                               new FontItem(FONT_NAME_NOTO, FONT_FILE_NOTO),
                              new FontItem(FONT_NAME_ROBOTO, FONT_FILE_ROBOTO),
                            };

    public static final String FONT_NAME_NANUM = "nanum";
    public static final String FONT_NAME_NOTO = "noto";
    public static final String FONT_NAME_ROBOTO = "roboto";

    private static final String FONT_FILE_NANUM = "nanumgothic.ttf";
    private static final String FONT_FILE_NOTO = "NotoSansKR-Regular.otf";
    private static final String FONT_FILE_ROBOTO = "Roboto-Regular.ttf";

    public Typeface getTypeface(Context context, String fontName) {
        for (FontItem item : fontList) {
            Typeface typeface = item.getTypeface(context, fontName);
            if (typeface != null) {
                return typeface;
            }
        }
        return null;
    }


}
