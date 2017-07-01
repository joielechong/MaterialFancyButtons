package com.rilixtech.materialfancybutton.utils;

import android.content.Context;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericsUtil {

  public static final String DEFINE_FONT_PREFIX = "define_mfb_font_";

  /**
   * a helper to get the string fields from the R class
   */
  public static String[] getFields(Context ctx) {
    Class rStringClass = resolveRClass(ctx.getPackageName());
    if (rStringClass != null) {
      return getDefinedFonts(ctx, rStringClass.getFields());
    }
    return new String[0];
  }

  /**
   * a helper class to resolve the correct R Class for the package
   */
  private static Class resolveRClass(String packageName) {
    do {
      try {
        return Class.forName(packageName + ".R$string");
      } catch (ClassNotFoundException e) {
        packageName =
            packageName.contains(".") ? packageName.substring(0, packageName.lastIndexOf('.')) : "";
      }
    } while (!TextUtils.isEmpty(packageName));

    return null;

  }

  /**
   * A helper method to get a String[] out of a fieldArray
   *
   * @param fields R.strings.class.getFields()
   * @return a String[] with the string ids we need
   */
  private static String[] getDefinedFonts(Context ctx, Field[] fields) {
    List<String> fieldArray = new ArrayList<>();
    for (Field field : fields) {
      if (field.getName().contains(DEFINE_FONT_PREFIX)) {
        fieldArray.add(getStringResourceByName(ctx, field.getName()));
      }
    }
    return fieldArray.toArray(new String[fieldArray.size()]);
  }

  /**
   * helper class to retrieve a string by it's resource name
   */
  private static String getStringResourceByName(Context ctx, String resourceName) {
    String packageName = ctx.getPackageName();
    int resId = ctx.getResources().getIdentifier(resourceName, "string", packageName);
    if (resId == 0) {
      return "";
    } else {
      return ctx.getString(resId);
    }
  }
}
