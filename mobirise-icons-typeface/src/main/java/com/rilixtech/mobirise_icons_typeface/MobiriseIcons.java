package com.rilixtech.mobirise_icons_typeface;

import android.content.Context;
import android.graphics.Typeface;
import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class MobiriseIcons implements ITypeface {
  private static final String TTF_FILE = "mobirise-icons-v1.0.0.ttf";
  private static final String MAPPING_FONT_PREFIX = "mbri";

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
    return "Mobirise Icons";
  }

  @Override public String getVersion() {
    return "1.0.0";
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
    return "Free Website Builder, https://mobirise.com/";
  }

  @Override public String getUrl() {
    return "https://mobirise.com/";
  }

  @Override public String getDescription() {
    return "A free, open source set of 150 elegant, pixel-perfect vector icons from Free Website Builder.";
  }

  @Override public String getLicense() {
    return "CC BY 4.0.";
  }

  @Override public String getLicenseUrl() {
    return "https://creativecommons.org/licenses/by/4.0/";
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
    mbri_add_submenu('\ue900'),
    mbri_alert('\ue901'),
    mbri_align_center('\ue902'),
    mbri_align_justify('\ue903'),
    mbri_align_left('\ue904'),
    mbri_align_right('\ue905'),
    mbri_android('\ue906'),
    mbri_apple('\ue907'),
    mbri_arrow_down('\ue908'),
    mbri_arrow_next('\ue909'),
    mbri_arrow_prev('\ue90a'),
    mbri_arrow_up('\ue90b'),
    mbri_bold('\ue90c'),
    mbri_bookmark('\ue90d'),
    mbri_bootstrap('\ue90e'),
    mbri_briefcase('\ue90f'),
    mbri_browse('\ue910'),
    mbri_bulleted_list('\ue911'),
    mbri_calendar('\ue912'),
    mbri_camera('\ue913'),
    mbri_cart_add('\ue914'),
    mbri_cart_full('\ue915'),
    mbri_cash('\ue916'),
    mbri_change_style('\ue917'),
    mbri_chat('\ue918'),
    mbri_clock('\ue919'),
    mbri_close('\ue91a'),
    mbri_cloud('\ue91b'),
    mbri_code('\ue91c'),
    mbri_contact_form('\ue91d'),
    mbri_credit_card('\ue91e'),
    mbri_cursor_click('\ue91f'),
    mbri_cust_feedback('\ue920'),
    mbri_database('\ue921'),
    mbri_delivery('\ue922'),
    mbri_desktop('\ue923'),
    mbri_devices('\ue924'),
    mbri_down('\ue925'),
    mbri_download('\ue926'),
    mbri_drag_n_drop('\ue927'),
    mbri_drag_n_drop2('\ue928'),
    mbri_edit('\ue929'),
    mbri_edit2('\ue92a'),
    mbri_error('\ue92b'),
    mbri_extension('\ue92c'),
    mbri_features('\ue92d'),
    mbri_file('\ue92e'),
    mbri_flag('\ue92f'),
    mbri_folder('\ue930'),
    mbri_gift('\ue931'),
    mbri_github('\ue932'),
    mbri_globe_2('\ue933'),
    mbri_globe('\ue934'),
    mbri_growing_chart('\ue935'),
    mbri_hearth('\ue936'),
    mbri_help('\ue937'),
    mbri_home('\ue938'),
    mbri_hot_cup('\ue939'),
    mbri_idea('\ue93a'),
    mbri_image_gallery('\ue93b'),
    mbri_image_slider('\ue93c'),
    mbri_info('\ue93d'),
    mbri_italic('\ue93e'),
    mbri_key('\ue93f'),
    mbri_laptop('\ue940'),
    mbri_layers('\ue941'),
    mbri_left_right('\ue942'),
    mbri_left('\ue943'),
    mbri_letter('\ue944'),
    mbri_like('\ue945'),
    mbri_link('\ue946'),
    mbri_lock('\ue947'),
    mbri_login('\ue948'),
    mbri_logout('\ue949'),
    mbri_magic_stick('\ue94a'),
    mbri_map_pin('\ue94b'),
    mbri_menu('\ue94c'),
    mbri_mobile('\ue94d'),
    mbri_mobile2('\ue94e'),
    mbri_mobirise('\ue94f'),
    mbri_more_horizontal('\ue950'),
    mbri_more_vertical('\ue951'),
    mbri_music('\ue952'),
    mbri_new_file('\ue953'),
    mbri_numbered_list('\ue954'),
    mbri_opened_folder('\ue955'),
    mbri_pages('\ue956'),
    mbri_paper_plane('\ue957'),
    mbri_paperclip('\ue958'),
    mbri_photo('\ue959'),
    mbri_photos('\ue95a'),
    mbri_pin('\ue95b'),
    mbri_play('\ue95c'),
    mbri_plus('\ue95d'),
    mbri_preview('\ue95e'),
    mbri_print('\ue95f'),
    mbri_protect('\ue960'),
    mbri_question('\ue961'),
    mbri_quote_left('\ue962'),
    mbri_quote_right('\ue963'),
    mbri_redo('\ue964'),
    mbri_refresh('\ue965'),
    mbri_responsive('\ue966'),
    mbri_right('\ue967'),
    mbri_rocket('\ue968'),
    mbri_sad_face('\ue969'),
    mbri_sale('\ue96a'),
    mbri_save('\ue96b'),
    mbri_search('\ue96c'),
    mbri_setting('\ue96d'),
    mbri_setting2('\ue96e'),
    mbri_setting3('\ue96f'),
    mbri_share('\ue970'),
    mbri_shopping_bag('\ue971'),
    mbri_shopping_basket('\ue972'),
    mbri_shopping_cart('\ue973'),
    mbri_sites('\ue974'),
    mbri_smile_face('\ue975'),
    mbri_speed('\ue976'),
    mbri_star('\ue977'),
    mbri_success('\ue978'),
    mbri_sun('\ue979'),
    mbri_sun2('\ue97a'),
    mbri_tablet_vertical('\ue97b'),
    mbri_tablet('\ue97c'),
    mbri_target('\ue97d'),
    mbri_timer('\ue97e'),
    mbri_to_ftp('\ue97f'),
    mbri_to_local_drive('\ue980'),
    mbri_touch_swipe('\ue981'),
    mbri_touch('\ue982'),
    mbri_trash('\ue983'),
    mbri_underline('\ue984'),
    mbri_undo('\ue985'),
    mbri_unlink('\ue986'),
    mbri_unlock('\ue987'),
    mbri_up_down('\ue988'),
    mbri_up('\ue989'),
    mbri_update('\ue98a'),
    mbri_upload('\ue98b'),
    mbri_user('\ue98c'),
    mbri_user2('\ue98d'),
    mbri_users('\ue98e'),
    mbri_video_play('\ue98f'),
    mbri_video('\ue990'),
    mbri_watch('\ue991'),
    mbri_website_theme('\ue992'),
    mbri_wifi('\ue993'),
    mbri_windows('\ue994'),
    mbri_zoom_out('\ue995');

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
        typeface = new MobiriseIcons();
      }
      return typeface;
    }
  }
}
