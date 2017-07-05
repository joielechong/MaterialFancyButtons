package com.rilixtech.meteocons_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Meteocons implements ITypeface {
    private static final String TTF_FILE = "meteocons.ttf";
    private static final String MAPPING_FONT_PREFIX = "meti";

    private static Typeface typeface = null;

    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }

        return mChars;
    }

    @Override
    public String getMappingPrefix() {
        return MAPPING_FONT_PREFIX;
    }

    @Override
    public String getFontName() {
        return "Meteocons";
    }

    @Override
    public String getVersion() {
        return "1.1.1";
    }

    @Override
    public int getIconCount() {
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();

        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }

        return icons;
    }

    @Override
    public String getAuthor() {
        return "Alessio Atzeni";
    }

    @Override
    public String getUrl() {
        return "http://www.alessioatzeni.com/meteocons/";
    }

    @Override
    public String getDescription() {
        return "Meteocons is a set of weather icons, it containing 40+ icons available in PSD, CSH, EPS, SVG, Desktop font and Web font. All icon and updates are free and always will be.";
    }

    @Override
    public String getLicense() {
        return "Meteocons are free for use in both personal and commercial projects.\n"
            + "No attribution or backlinks are required, but any form of spreading the word is always appreciated!\n"
            + "You must not resell any icons or distribute them in any other way.\n"
            + "The Icons as such are the property of the author.";
    }

    @Override
    public String getLicenseUrl() {
        return "";
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {
        meti_windy_rain_inv('\ue800'),
        meti_snow_inv('\ue801'),
        meti_snow_heavy_inv('\ue802'),
        meti_hail_inv('\ue803'),
        meti_clouds_inv('\ue804'),
        meti_clouds_flash_inv('\ue805'),
        meti_temperature('\ue806'),
        meti_compass('\ue807'),
        meti_na('\ue808'),
        meti_celcius('\ue809'),
        meti_fahrenheit('\ue80a'),
        meti_clouds_flash_alt('\ue80b'),
        meti_sun_inv('\ue80c'),
        meti_moon_inv('\ue80d'),
        meti_cloud_sun_inv('\ue80e'),
        meti_cloud_moon_inv('\ue80f'),
        meti_cloud_inv('\ue810'),
        meti_cloud_flash_inv('\ue811'),
        meti_drizzle_inv('\ue812'),
        meti_rain_inv('\ue813'),
        meti_windy_inv('\ue814'),
        meti_sunrise('\ue815'),
        meti_sun('\ue816'),
        meti_moon('\ue817'),
        meti_eclipse('\ue818'),
        meti_mist('\ue819'),
        meti_wind('\ue81a'),
        meti_snowflake('\ue81b'),
        meti_cloud_sun('\ue81c'),
        meti_cloud_moon('\ue81d'),
        meti_fog_sun('\ue81e'),
        meti_fog_moon('\ue81f'),
        meti_fog_cloud('\ue820'),
        meti_fog('\ue821'),
        meti_cloud('\ue822'),
        meti_cloud_flash('\ue823'),
        meti_cloud_flash_alt('\ue824'),
        meti_drizzle('\ue825'),
        meti_rain('\ue826'),
        meti_windy('\ue827'),
        meti_windy_rain('\ue828'),
        meti_snow('\ue829'),
        meti_snow_alt('\ue82a'),
        meti_snow_heavy('\ue82b'),
        meti_hail('\ue82c'),
        meti_clouds('\ue82d'),
        meti_clouds_flash('\ue82e');

        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new Meteocons();
            }
            return typeface;
        }
    }
}
