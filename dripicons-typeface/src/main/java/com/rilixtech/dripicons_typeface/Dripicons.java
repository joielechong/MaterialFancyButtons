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

  private static final char a = 0x0027;
  private static final char back_slash = 0x005C;

  public enum Icon implements IIcon {
    drpi_alarm('\u0061'),
    drpi_align_center('\u0062'),
    drpi_align_justify('\u0063'),
    drpi_align_left('\u0064'),
    drpi_align_right('\u0065'),
    drpi_anchor('\u0066'),
    drpi_archive('\u0067'),
    drpi_arrow_down('\u0068'),
    drpi_arrow_left('\u0069'),
    drpi_arrow_right('\u006a'),
    drpi_arrow_thin_down('\u006b'),
    drpi_arrow_thin_left('\u006c'),
    drpi_arrow_thin_right('\u006d'),
    drpi_arrow_thin_up('\u006e'),
    drpi_arrow_up('\u006f'),
    drpi_article('\u0070'),
    drpi_backspace('\u0071'),
    drpi_basket('\u0072'),
    drpi_basketball('\u0073'),
    drpi_battery_empty('\u0074'),
    drpi_battery_full('\u0075'),
    drpi_battery_low('\u0076'),
    drpi_battery_medium('\u0077'),
    drpi_bell('\u0078'),
    drpi_blog('\u0079'),
    drpi_bluetooth('\u007a'),
    drpi_bold('\u0041'),
    drpi_bookmark('\u0042'),
    drpi_bookmarks('\u0043'),
    drpi_box('\u0044'),
    drpi_briefcase('\u0045'),
    drpi_brightness_low('\u0046'),
    drpi_brightness_max('\u0047'),
    drpi_brightness_medium('\u0048'),
    drpi_broadcast('\u0049'),
    drpi_browser('\u004a'),
    drpi_browser_upload('\u004b'),
    drpi_brush('\u004c'),
    drpi_calendar('\u004d'),
    drpi_camcorder('\u004e'),
    drpi_camera('\u004f'),
    drpi_card('\u0050'),
    drpi_cart('\u0051'),
    drpi_checklist('\u0052'),
    drpi_checkmark('\u0053'),
    drpi_chevron_down('\u0054'),
    drpi_chevron_left('\u0055'),
    drpi_chevron_right('\u0056'),
    drpi_chevron_up('\u0057'),
    drpi_clipboard('\u0058'),
    drpi_clock('\u0059'),
    drpi_clockwise('\u005a'),
    drpi_cloud('\u0030'),
    drpi_cloud_download('\u0031'),
    drpi_cloud_upload('\u0032'),
    drpi_code('\u0033'),
    drpi_contract('\u0034'),
    drpi_contract_2('\u0035'),
    drpi_conversation('\u0036'),
    drpi_copy('\u0037'),
    drpi_crop('\u0038'),
    drpi_cross('\u0039'),
    drpi_crosshair('\u0021'),
    drpi_cutlery('\u0022'),
    drpi_device_desktop('\u0023'),
    drpi_device_mobile('\u0024'),
    drpi_device_tablet('\u0025'),
    drpi_direction('\u0026'),
    drpi_disc(a),
    drpi_document('\u0028'),
    drpi_document_delete('\u0029'),
    drpi_document_edit('\u002a'),
    drpi_document_new('\u002b'),
    drpi_document_remove('\u002c'),
    drpi_dot('\u002d'),
    drpi_dots_2('\u002e'),
    drpi_dots_3('\u002f'),
    drpi_download('\u003a'),
    drpi_duplicate('\u003b'),
    drpi_enter('\u003c'),
    drpi_exit('\u003d'),
    drpi_expand('\u003e'),
    drpi_expand_2('\u003f'),
    drpi_experiment('\u0040'),
    drpi_export('\u005b'),
    drpi_feed('\u005d'),
    drpi_flag('\u005e'),
    drpi_flashlight('\u005f'),
    drpi_folder('\u0060'),
    drpi_folder_open('\u007b'),
    drpi_forward('\u007c'),
    drpi_gaming('\u007d'),
    drpi_gear('\u007e'),
    drpi_graduation(back_slash),
    drpi_graph_bar('\ue000'),
    drpi_graph_line('\ue001'),
    drpi_graph_pie('\ue002'),
    drpi_headset('\ue003'),
    drpi_heart('\ue004'),
    drpi_help('\ue005'),
    drpi_home('\ue006'),
    drpi_hourglass('\ue007'),
    drpi_inbox('\ue008'),
    drpi_information('\ue009'),
    drpi_italic('\ue00a'),
    drpi_jewel('\ue00b'),
    drpi_lifting('\ue00c'),
    drpi_lightbulb('\ue00d'),
    drpi_link('\ue00e'),
    drpi_link_broken('\ue00f'),
    drpi_list('\ue010'),
    drpi_loading('\ue011'),
    drpi_location('\ue012'),
    drpi_lock('\ue013'),
    drpi_lock_open('\ue014'),
    drpi_mail('\ue015'),
    drpi_map('\ue016'),
    drpi_media_loop('\ue017'),
    drpi_media_next('\ue018'),
    drpi_media_pause('\ue019'),
    drpi_media_play('\ue01a'),
    drpi_media_previous('\ue01b'),
    drpi_media_record('\ue01c'),
    drpi_media_shuffle('\ue01d'),
    drpi_media_stop('\ue01e'),
    drpi_medical('\ue01f'),
    drpi_menu('\ue020'),
    drpi_message('\ue021'),
    drpi_meter('\ue022'),
    drpi_microphone('\ue023'),
    drpi_minus('\ue024'),
    drpi_monitor('\ue025'),
    drpi_move('\ue026'),
    drpi_music('\ue027'),
    drpi_network_1('\ue028'),
    drpi_network_2('\ue029'),
    drpi_network_3('\ue02a'),
    drpi_network_4('\ue02b'),
    drpi_network_5('\ue02c'),
    drpi_pamphlet('\ue02d'),
    drpi_paperclip('\ue02e'),
    drpi_pencil('\ue02f'),
    drpi_phone('\ue030'),
    drpi_photo('\ue031'),
    drpi_photo_group('\ue032'),
    drpi_pill('\ue033'),
    drpi_pin('\ue034'),
    drpi_plus('\ue035'),
    drpi_power('\ue036'),
    drpi_preview('\ue037'),
    drpi_print('\ue038'),
    drpi_pulse('\ue039'),
    drpi_question('\ue03a'),
    drpi_reply('\ue03b'),
    drpi_reply_all('\ue03c'),
    drpi_return('\ue03d'),
    drpi_retweet('\ue03e'),
    drpi_rocket('\ue03f'),
    drpi_scale('\ue040'),
    drpi_search('\ue041'),
    drpi_shopping_bag('\ue042'),
    drpi_skip('\ue043'),
    drpi_stack('\ue044'),
    drpi_star('\ue045'),
    drpi_stopwatch('\ue046'),
    drpi_store('\ue047'),
    drpi_suitcase('\ue048'),
    drpi_swap('\ue049'),
    drpi_tag('\ue04a'),
    drpi_tag_delete('\ue04b'),
    drpi_tags('\ue04c'),
    drpi_thumbs_down('\ue04d'),
    drpi_thumbs_up('\ue04e'),
    drpi_ticket('\ue04f'),
    drpi_time_reverse('\ue050'),
    drpi_to_do('\ue051'),
    drpi_toggles('\ue052'),
    drpi_trash('\ue053'),
    drpi_trophy('\ue054'),
    drpi_upload('\ue055'),
    drpi_user('\ue056'),
    drpi_user_group('\ue057'),
    drpi_user_id('\ue058'),
    drpi_vibrate('\ue059'),
    drpi_view_apps('\ue05a'),
    drpi_view_list('\ue05b'),
    drpi_view_list_large('\ue05c'),
    drpi_view_thumb('\ue05d'),
    drpi_volume_full('\ue05e'),
    drpi_volume_low('\ue05f'),
    drpi_volume_medium('\ue060'),
    drpi_volume_off('\ue061'),
    drpi_wallet('\ue062'),
    drpi_warning('\ue063'),
    drpi_web('\ue064'),
    drpi_weight('\ue065'),
    drpi_wifi('\ue066'),
    drpi_wrong('\ue067'),
    drpi_zoom_in('\ue068'),
    drpi_zoom_out('\ue069');

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
