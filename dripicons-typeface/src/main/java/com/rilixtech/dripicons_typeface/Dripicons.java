package com.rilixtech.dripicons_typeface;

import android.content.Context;
import android.graphics.Typeface;
import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Dripicons implements ITypeface {
  private static final String TTF_FILE = "dripicons-v2.ttf";
  private static final String MAPPING_FONT_PREFIX = "drpi";

  private static Typeface typeface = null;

  private static HashMap<String, Character> mChars;

  @Override public IIcon getIcon(String key) {
    return Icon.valueOf(key);
  }

  @Override public HashMap<String, Character> getCharacters() {
    if (mChars == null) {
      HashMap<String, Character> aChars = new HashMap<String, Character>();
      for (Icon v : Icon.values()) {
        aChars.put(v.name(), v.character);
      }
      mChars = aChars;
    }

    return mChars;
  }

  @Override public String getMappingPrefix() {
    return MAPPING_FONT_PREFIX;
  }

  @Override public String getFontName() {
    return "Dripicons";
  }

  @Override public String getVersion() {
    return "2.0";
  }

  @Override public int getIconCount() {
    return mChars.size();
  }

  @Override public Collection<String> getIcons() {
    Collection<String> icons = new LinkedList<String>();

    for (Icon value : Icon.values()) {
      icons.add(value.name());
    }

    return icons;
  }

  @Override public String getAuthor() {
    return "Amit Jakhu";
  }

  @Override public String getUrl() {
    return "https://github.com/amitjakhu/dripicons";
  }

  @Override public String getDescription() {
    return "A completely free vector line iconset by Amit Jakhu.";
  }

  @Override public String getLicense() {
    return "SIL Open Font License";
  }

  @Override public String getLicenseUrl() {
    return "http://scripts.sil.org/cms/scripts/page.php?site_id=nrsi&id=OFL";
  }

  @Override public Typeface getTypeface(Context context) {
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
    ;

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
        typeface = new Dripicons();
      }
      return typeface;
    }
  }
}
