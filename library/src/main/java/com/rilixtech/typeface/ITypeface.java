package com.rilixtech.typeface;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by mikepenz on 01.11.14.
 */
public interface ITypeface {

    public IIcon getIcon(String key);

    public HashMap<String, Character> getCharacters();

    /**
     * The Mapping Prefix to identify this font
     * must have a length of 3
     *
     * @return mappingPrefix (length = 3)
     */
    public String getMappingPrefix();

    public String getFontName();

    public String getVersion();

    public int getIconCount();

    public Collection<String> getIcons();

    public String getAuthor();

    public String getUrl();

    public String getDescription();

    public String getLicense();

    public String getLicenseUrl();

    public Typeface getTypeface(Context ctx);

}
