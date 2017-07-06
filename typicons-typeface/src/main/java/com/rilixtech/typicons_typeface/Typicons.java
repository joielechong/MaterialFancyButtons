package com.rilixtech.typicons_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Typicons implements ITypeface {
    private static final String TTF_FILE = "typicons-font-v2.0.7.1.ttf";
    private static final String MAPPING_FONT_PREFIX = "typi";

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
        return "Typicons";
    }

    @Override
    public String getVersion() {
        return "2.0.7.1";
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
        return "Stephen Hutchings";
    }

    @Override
    public String getUrl() {
        return "http://typicons.com/";
    }

    @Override
    public String getDescription() {
        return "336 pixel perfect, all-purpose vector icons";
    }

    @Override
    public String getLicense() {
        return "SIL OPEN FONT LICENSE";
    }

    @Override
    public String getLicenseUrl() {
        return "http://scripts.sil.org/cms/scripts/page.php?item_id=OFL_web";
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
        typi_adjust_brightness('\ue000'),
        typi_adjust_contrast('\ue001'),
        typi_anchor_outline('\ue002'),
        typi_anchor('\ue003'),
        typi_archive('\ue004'),
        typi_arrow_back_outline('\ue005'),
        typi_arrow_back('\ue006'),
        typi_arrow_down_outline('\ue007'),
        typi_arrow_down_thick('\ue008'),
        typi_arrow_down('\ue009'),
        typi_arrow_forward_outline('\ue00a'),
        typi_arrow_forward('\ue00b'),
        typi_arrow_left_outline('\ue00c'),
        typi_arrow_left_thick('\ue00d'),
        typi_arrow_left('\ue00e'),
        typi_arrow_loop_outline('\ue00f'),
        typi_arrow_loop('\ue010'),
        typi_arrow_maximise_outline('\ue011'),
        typi_arrow_maximise('\ue012'),
        typi_arrow_minimise_outline('\ue013'),
        typi_arrow_minimise('\ue014'),
        typi_arrow_move_outline('\ue015'),
        typi_arrow_move('\ue016'),
        typi_arrow_repeat_outline('\ue017'),
        typi_arrow_repeat('\ue018'),
        typi_arrow_right_outline('\ue019'),
        typi_arrow_right_thick('\ue01a'),
        typi_arrow_right('\ue01b'),
        typi_arrow_shuffle('\ue01c'),
        typi_arrow_sorted_down('\ue01d'),
        typi_arrow_sorted_up('\ue01e'),
        typi_arrow_sync_outline('\ue01f'),
        typi_arrow_sync('\ue020'),
        typi_arrow_unsorted('\ue021'),
        typi_arrow_up_outline('\ue022'),
        typi_arrow_up_thick('\ue023'),
        typi_arrow_up('\ue024'),
        typi_at('\ue025'),
        typi_attachmenti_outline('\ue026'),
        typi_attachment('\ue027'),
        typi_backspace_outline('\ue028'),
        typi_backspace('\ue029'),
        typi_battery_charge('\ue02a'),
        typi_battery_full('\ue02b'),
        typi_battery_high('\ue02c'),
        typi_battery_low('\ue02d'),
        typi_battery_mid('\ue02e'),
        typi_beaker('\ue02f'),
        typi_beer('\ue030'),
        typi_bell('\ue031'),
        typi_book('\ue032'),
        typi_bookmark('\ue033'),
        typi_briefcase('\ue034'),
        typi_brush('\ue035'),
        typi_business_card('\ue036'),
        typi_calculator('\ue037'),
        typi_calendar_outline('\ue038'),
        typi_calendar('\ue039'),
        typi_camera_outline('\ue03a'),
        typi_camera('\ue03b'),
        typi_cancel_outline('\ue03c'),
        typi_cancel('\ue03d'),
        typi_chart_area_outline('\ue03e'),
        typi_chart_area('\ue03f'),
        typi_chart_bar_outline('\ue040'),
        typi_chart_bar('\ue041'),
        typi_chart_line_outline('\ue042'),
        typi_chart_line('\ue043'),
        typi_chart_pie_outline('\ue044'),
        typi_chart_pie('\ue045'),
        typi_chevron_left_outline('\ue046'),
        typi_chevron_left('\ue047'),
        typi_chevron_right_outline('\ue048'),
        typi_chevron_right('\ue049'),
        typi_clipboard('\ue04a'),
        typi_cloud_storage('\ue04b'),
        typi_cloud_storage_outline('\ue054'),
        typi_code_outline('\ue04c'),
        typi_code('\ue04d'),
        typi_coffee('\ue04e'),
        typi_cog_outline('\ue04f'),
        typi_cog('\ue050'),
        typi_compass('\ue051'),
        typi_contacts('\ue052'),
        typi_credit_card('\ue053'),
        typi_css3('\ue055'),
        typi_database('\ue056'),
        typi_delete_outline('\ue057'),
        typi_delete('\ue058'),
        typi_device_desktop('\ue059'),
        typi_device_laptop('\ue05a'),
        typi_device_phone('\ue05b'),
        typi_device_tablet('\ue05c'),
        typi_directions('\ue05d'),
        typi_divide_outline('\ue05e'),
        typi_divide('\ue05f'),
        typi_documenti_add('\ue060'),
        typi_documenti_delete('\ue061'),
        typi_documenti_text('\ue062'),
        typi_document('\ue063'),
        typi_download_outline('\ue064'),
        typi_download('\ue065'),
        typi_dropbox('\ue066'),
        typi_edit('\ue067'),
        typi_eject_outline('\ue068'),
        typi_eject('\ue069'),
        typi_equals_outline('\ue06a'),
        typi_equals('\ue06b'),
        typi_export_outline('\ue06c'),
        typi_export('\ue06d'),
        typi_eye_outline('\ue06e'),
        typi_eye('\ue06f'),
        typi_feather('\ue070'),
        typi_film('\ue071'),
        typi_filter('\ue072'),
        typi_flag_outline('\ue073'),
        typi_flag('\ue074'),
        typi_flash_outline('\ue075'),
        typi_flash('\ue076'),
        typi_flow_children('\ue077'),
        typi_flow_merge('\ue078'),
        typi_flow_parallel('\ue079'),
        typi_flow_switch('\ue07a'),
        typi_folder_add('\ue07b'),
        typi_folder_delete('\ue07c'),
        typi_folder_open('\ue07d'),
        typi_folder('\ue07e'),
        typi_gift('\ue07f'),
        typi_globe_outline('\ue080'),
        typi_globe('\ue081'),
        typi_group_outline('\ue082'),
        typi_group('\ue083'),
        typi_headphones('\ue084'),
        typi_heart_full_outline('\ue085'),
        typi_heart_half_outline('\ue086'),
        typi_heart_outline('\ue087'),
        typi_heart('\ue088'),
        typi_home_outline('\ue089'),
        typi_home('\ue08a'),
        typi_html5('\ue08b'),
        typi_image_outline('\ue08c'),
        typi_image('\ue08d'),
        typi_infinity_outline('\ue08e'),
        typi_infinity('\ue08f'),
        typi_info_large_outline('\ue090'),
        typi_info_large('\ue091'),
        typi_info_outline('\ue092'),
        typi_info('\ue093'),
        typi_input_checked_outline('\ue094'),
        typi_input_checked('\ue095'),
        typi_key_outline('\ue096'),
        typi_key('\ue097'),
        typi_keyboard('\ue098'),
        typi_leaf('\ue099'),
        typi_lightbulb('\ue09a'),
        typi_link_outline('\ue09b'),
        typi_link('\ue09c'),
        typi_location_arrow_outline('\ue09d'),
        typi_location_arrow('\ue09e'),
        typi_location_outline('\ue09f'),
        typi_location('\ue0a0'),
        typi_lock_closed_outline('\ue0a1'),
        typi_lock_closed('\ue0a2'),
        typi_lock_open_outline('\ue0a3'),
        typi_lock_open('\ue0a4'),
        typi_mail('\ue0a5'),
        typi_map('\ue0a6'),
        typi_media_eject_outline('\ue0a7'),
        typi_media_eject('\ue0a8'),
        typi_media_fast_forward_outline('\ue0a9'),
        typi_media_fast_forward('\ue0aa'),
        typi_media_pause_outline('\ue0ab'),
        typi_media_pause('\ue0ac'),
        typi_media_play_outline('\ue0ad'),
        typi_media_play_reverse_outline('\ue0ae'),
        typi_media_play_reverse('\ue0af'),
        typi_media_play('\ue0b0'),
        typi_media_record_outline('\ue0b1'),
        typi_media_record('\ue0b2'),
        typi_media_rewind_outline('\ue0b3'),
        typi_media_rewind('\ue0b4'),
        typi_media_stop_outline('\ue0b5'),
        typi_media_stop('\ue0b6'),
        typi_message_typing('\ue0b7'),
        typi_message('\ue0b8'),
        typi_messages('\ue0b9'),
        typi_microphone_outline('\ue0ba'),
        typi_microphone('\ue0bb'),
        typi_minus_outline('\ue0bc'),
        typi_minus('\ue0bd'),
        typi_mortar_board('\ue0be'),
        typi_news('\ue0bf'),
        typi_notes_outline('\ue0c0'),
        typi_notes('\ue0c1'),
        typi_pen('\ue0c2'),
        typi_pencil('\ue0c3'),
        typi_phone_outline('\ue0c4'),
        typi_phone('\ue0c5'),
        typi_pi_outline('\ue0c6'),
        typi_pi('\ue0c7'),
        typi_pin_outline('\ue0c8'),
        typi_pin('\ue0c9'),
        typi_pipette('\ue0ca'),
        typi_plane_outline('\ue0cb'),
        typi_plane('\ue0cc'),
        typi_plug('\ue0cd'),
        typi_plus_outline('\ue0ce'),
        typi_plus('\ue0cf'),
        typi_point_of_interest_outline('\ue0d0'),
        typi_point_of_interest('\ue0d1'),
        typi_power_outline('\ue0d2'),
        typi_power('\ue0d3'),
        typi_printer('\ue0d4'),
        typi_puzzle_outline('\ue0d5'),
        typi_puzzle('\ue0d6'),
        typi_radar_outline('\ue0d7'),
        typi_radar('\ue0d8'),
        typi_refresh_outline('\ue0d9'),
        typi_refresh('\ue0da'),
        typi_rss_outline('\ue0db'),
        typi_rss('\ue0dc'),
        typi_scissors_outline('\ue0dd'),
        typi_scissors('\ue0de'),
        typi_shopping_bag('\ue0df'),
        typi_shopping_cart('\ue0e0'),
        typi_social_at_circular('\ue0e1'),
        typi_social_dribbble_circular('\ue0e2'),
        typi_social_dribbble('\ue0e3'),
        typi_social_facebook_circular('\ue0e4'),
        typi_social_facebook('\ue0e5'),
        typi_social_flickr_circular('\ue0e6'),
        typi_social_flickr('\ue0e7'),
        typi_social_github_circular('\ue0e8'),
        typi_social_github('\ue0e9'),
        typi_social_google_plus_circular('\ue0ea'),
        typi_social_google_plus('\ue0eb'),
        typi_social_instagram_circular('\ue0ec'),
        typi_social_instagram('\ue0ed'),
        typi_social_last_fm_circular('\ue0ee'),
        typi_social_last_fm('\ue0ef'),
        typi_social_linkedin_circular('\ue0f0'),
        typi_social_linkedin('\ue0f1'),
        typi_social_pinterest_circular('\ue0f2'),
        typi_social_pinterest('\ue0f3'),
        typi_social_skype_outline('\ue0f4'),
        typi_social_skype('\ue0f5'),
        typi_social_tumbler_circular('\ue0f6'),
        typi_social_tumbler('\ue0f7'),
        typi_social_twitter_circular('\ue0f8'),
        typi_social_twitter('\ue0f9'),
        typi_social_vimeo_circular('\ue0fa'),
        typi_social_vimeo('\ue0fb'),
        typi_social_youtube_circular('\ue0fc'),
        typi_social_youtube('\ue0fd'),
        typi_sort_alphabetically_outline('\ue0fe'),
        typi_sort_alphabetically('\ue0ff'),
        typi_sort_numerically_outline('\ue100'),
        typi_sort_numerically('\ue101'),
        typi_spanner_outline('\ue102'),
        typi_spanner('\ue103'),
        typi_spiral('\ue104'),
        typi_star_full_outline('\ue105'),
        typi_star_half_outline('\ue106'),
        typi_star_half('\ue107'),
        typi_star_outline('\ue108'),
        typi_star('\ue109'),
        typi_starburst_outline('\ue10a'),
        typi_starburst('\ue10b'),
        typi_stopwatch('\ue10c'),
        typi_support('\ue10d'),
        typi_tabs_outline('\ue10e'),
        typi_tag('\ue10f'),
        typi_tags('\ue110'),
        typi_th_large_outline('\ue111'),
        typi_th_large('\ue112'),
        typi_th_list_outline('\ue113'),
        typi_th_list('\ue114'),
        typi_th_menu_outline('\ue115'),
        typi_th_menu('\ue116'),
        typi_th_small_outline('\ue117'),
        typi_th_small('\ue118'),
        typi_thermometer('\ue119'),
        typi_thumbs_down('\ue11a'),
        typi_thumbs_ok('\ue11b'),
        typi_thumbs_up('\ue11c'),
        typi_tick_outline('\ue11d'),
        typi_tick('\ue11e'),
        typi_ticket('\ue11f'),
        typi_time('\ue120'),
        typi_times_outline('\ue121'),
        typi_times('\ue122'),
        typi_trash('\ue123'),
        typi_tree('\ue124'),
        typi_upload_outline('\ue125'),
        typi_upload('\ue126'),
        typi_user_add_outline('\ue127'),
        typi_user_add('\ue128'),
        typi_user_delete_outline('\ue129'),
        typi_user_delete('\ue12a'),
        typi_user_outline('\ue12b'),
        typi_user('\ue12c'),
        typi_vendor_android('\ue12d'),
        typi_vendor_apple('\ue12e'),
        typi_vendor_microsoft('\ue12f'),
        typi_video_outline('\ue130'),
        typi_video('\ue131'),
        typi_volume_down('\ue132'),
        typi_volume_mute('\ue133'),
        typi_volume_up('\ue134'),
        typi_volume('\ue135'),
        typi_warning_outline('\ue136'),
        typi_warning('\ue137'),
        typi_watch('\ue138'),
        typi_waves_outline('\ue139'),
        typi_waves('\ue13a'),
        typi_weather_cloudy('\ue13b'),
        typi_weather_downpour('\ue13c'),
        typi_weather_night('\ue13d'),
        typi_weather_partly_sunny('\ue13e'),
        typi_weather_shower('\ue13f'),
        typi_weather_snow('\ue140'),
        typi_weather_stormy('\ue141'),
        typi_weather_sunny('\ue142'),
        typi_weather_windy_cloudy('\ue143'),
        typi_weather_windy('\ue144'),
        typi_wi_fi_outline('\ue145'),
        typi_wi_fi('\ue146'),
        typi_wine('\ue147'),
        typi_world_outline('\ue148'),
        typi_world('\ue149'),
        typi_zoom_in_outline('\ue14a'),
        typi_zoom_in('\ue14b'),
        typi_zoom_out_outline('\ue14c'),
        typi_zoom_out('\ue14d'),
        typi_zoom_outline('\ue14e'),
        typi_zoom('\ue14f');

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
                typeface = new Typicons();
            }
            return typeface;
        }
    }
}
