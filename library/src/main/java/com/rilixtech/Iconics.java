/*
 * Copyright 2014 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rilixtech;

import android.content.Context;
import android.util.Log;
import com.rilixtech.typeface.IIcon;
import com.rilixtech.typeface.ITypeface;
import com.rilixtech.utils.GenericsUtil;
import java.util.Collection;
import java.util.HashMap;

public final class Iconics {

    public static final String TAG = Iconics.class.getSimpleName();

    private static boolean INIT_DONE = false;
    private static HashMap<String, ITypeface> FONTS = new HashMap<>();

    /**
     * initializes the FONTS. This also tries to find all founds automatically via their font file
     *
     * @param ctx
     */
    public static void init(Context ctx) {
        if (!INIT_DONE) {
            String[] fonts = GenericsUtil.getFields(ctx);
            for (String fontsClassPath : fonts) {
                try {
                    ITypeface typeface = (ITypeface) Class.forName(fontsClassPath).newInstance();
                    validateFont(typeface);
                    FONTS.put(typeface.getMappingPrefix(), typeface);
                    Log.d(TAG, "Typeface = " + typeface.getAuthor());
                } catch (Exception e) {
                    Log.e("Android-Iconics", "Can't init: " + fontsClassPath);
                }
            }
            Log.d(TAG, "Total font = "  + FONTS.size());
            INIT_DONE = true;
        }
    }

    /**
     * this makes sure the FONTS are initialized. If the given fonts Map is empty we set the initialized FONTS on it
     *
     * @param ctx
     * @param fonts
     * @return
     */
    private static HashMap<String, ITypeface> init(Context ctx, HashMap<String, ITypeface> fonts) {
        init(ctx);
        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }
        return fonts;
    }

    /**
     * Test if the icon exists in the currently loaded fonts
     *
     * @param context A context to access application resources
     * @param icon The icon to verify
     * @return true if the icon is available
     */
    public static boolean iconExists(Context context, String icon) {
        try {
            ITypeface font = findFont(context, icon.substring(0, 3));
            icon = icon.replace("-", "_");
            font.getIcon(icon);
            return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    /**
     * Registers a fonts into the FONTS array for performance
     *
     * @param font
     * @return
     */
    public static boolean registerFont(ITypeface font) {
        validateFont(font);

        FONTS.put(font.getMappingPrefix(), font);
        return true;
    }

    /**
     * Perform a basic sanity check for a font.
     * @param font
     */
    private static void validateFont(ITypeface font) {
        if(font.getMappingPrefix().length() != 3) {
            throw new IllegalArgumentException("The mapping prefix of a font must be three characters long.");
        }
    }

    /**
     * return all registered FONTS
     *
     * @param ctx
     * @return
     */
    public static Collection<ITypeface> getRegisteredFonts(Context ctx) {
        init(ctx);
        return FONTS.values();
    }

    /**
     * tries to find a font by its key in all registered FONTS
     *
     * @param ctx
     * @param key
     * @return
     */
    public static ITypeface findFont(Context ctx, String key) {
        init(ctx);
        return FONTS.get(key);
    }

    /**
     * fetches the font from the Typeface of an IIcon
     *
     * @param icon
     * @return
     */
    public static ITypeface findFont(IIcon icon) {
        return icon.getTypeface();
    }

    private Iconics() {
        // Prevent instantiation
    }

}
