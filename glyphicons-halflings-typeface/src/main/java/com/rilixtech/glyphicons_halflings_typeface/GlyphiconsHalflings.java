package com.rilixtech.glyphicons_halflings_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class GlyphiconsHalflings implements ITypeface {
    private static final String TTF_FILE = "glyphicons-halflings-regular.ttf";
    private static final String MAPPING_FONT_PREFIX = "glyi";

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
        return "Glyphicons Halflings";
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
        return "Jan Kovarik";
    }

    @Override public String getUrl() {
        return "http://glyphicons.com/";
    }

    @Override public String getDescription() {
        return "GLYPHICONS Halflings font is also released as an extension of a Bootstrap www.getbootstrap.com for free and it is released under the same license as Bootstrap.";
    }

    @Override public String getLicense() {
        return "MIT License";
    }

    @Override public String getLicenseUrl() {
        return "https://opensource.org/licenses/MIT";
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
        glyphicon_asterisk('\u002a'),
        glyphicon_plus('\u002b'),
        glyphicon_eur('\u20ac'),
        glyphicon_minus('\u2212'),
        glyphicon_cloud('\u2601'),
        glyphicon_envelope('\u2709'),
        glyphicon_pencil('\u270f'),
        glyphicon_glass('\ue001'),
        glyphicon_music('\ue002'),
        glyphicon_search('\ue003'),
        glyphicon_heart('\ue005'),
        glyphicon_star('\ue006'),
        glyphicon_star_empty('\ue007'),
        glyphicon_user('\ue008'),
        glyphicon_film('\ue009'),
        glyphicon_th_large('\ue010'),
        glyphicon_th('\ue011'),
        glyphicon_th_list('\ue012'),
        glyphicon_ok('\ue013'),
        glyphicon_remove('\ue014'),
        glyphicon_zoom_in('\ue015'),
        glyphicon_zoom_out('\ue016'),
        glyphicon_off('\ue017'),
        glyphicon_signal('\ue018'),
        glyphicon_cog('\ue019'),
        glyphicon_trash('\ue020'),
        glyphicon_home('\ue021'),
        glyphicon_file('\ue022'),
        glyphicon_time('\ue023'),
        glyphicon_road('\ue024'),
        glyphicon_download_alt('\ue025'),
        glyphicon_download('\ue026'),
        glyphicon_upload('\ue027'),
        glyphicon_inbox('\ue028'),
        glyphicon_play_circle('\ue029'),
        glyphicon_repeat('\ue030'),
        glyphicon_refresh('\ue031'),
        glyphicon_list_alt('\ue032'),
        glyphicon_lock('\ue033'),
        glyphicon_flag('\ue034'),
        glyphicon_headphones('\ue035'),
        glyphicon_volume_off('\ue036'),
        glyphicon_volume_down('\ue037'),
        glyphicon_volume_up('\ue038'),
        glyphicon_qrcode('\ue039'),
        glyphicon_barcode('\ue040'),
        glyphicon_tag('\ue041'),
        glyphicon_tags('\ue042'),
        glyphicon_book('\ue043'),
        glyphicon_bookmark('\ue044'),
        glyphicon_print('\ue045'),
        glyphicon_camera('\ue046'),
        glyphicon_font('\ue047'),
        glyphicon_bold('\ue048'),
        glyphicon_italic('\ue049'),
        glyphicon_text_height('\ue050'),
        glyphicon_text_width('\ue051'),
        glyphicon_align_left('\ue052'),
        glyphicon_align_center('\ue053'),
        glyphicon_align_right('\ue054'),
        glyphicon_align_justify('\ue055'),
        glyphicon_list('\ue056'),
        glyphicon_indent_left('\ue057'),
        glyphicon_indent_right('\ue058'),
        glyphicon_facetime_video('\ue059'),
        glyphicon_picture('\ue060'),
        glyphicon_map_marker('\ue062'),
        glyphicon_adjust('\ue063'),
        glyphicon_tint('\ue064'),
        glyphicon_edit('\ue065'),
        glyphicon_share('\ue066'),
        glyphicon_check('\ue067'),
        glyphicon_move('\ue068'),
        glyphicon_step_backward('\ue069'),
        glyphicon_fast_backward('\ue070'),
        glyphicon_backward('\ue071'),
        glyphicon_play('\ue072'),
        glyphicon_pause('\ue073'),
        glyphicon_stop('\ue074'),
        glyphicon_forward('\ue075'),
        glyphicon_fast_forward('\ue076'),
        glyphicon_step_forward('\ue077'),
        glyphicon_eject('\ue078'),
        glyphicon_chevron_left('\ue079'),
        glyphicon_chevron_right('\ue080'),
        glyphicon_plus_sign('\ue081'),
        glyphicon_minus_sign('\ue082'),
        glyphicon_remove_sign('\ue083'),
        glyphicon_ok_sign('\ue084'),
        glyphicon_question_sign('\ue085'),
        glyphicon_info_sign('\ue086'),
        glyphicon_screenshot('\ue087'),
        glyphicon_remove_circle('\ue088'),
        glyphicon_ok_circle('\ue089'),
        glyphicon_ban_circle('\ue090'),
        glyphicon_arrow_left('\ue091'),
        glyphicon_arrow_right('\ue092'),
        glyphicon_arrow_up('\ue093'),
        glyphicon_arrow_down('\ue094'),
        glyphicon_share_alt('\ue095'),
        glyphicon_resize_full('\ue096'),
        glyphicon_resize_small('\ue097'),
        glyphicon_exclamation_sign('\ue101'),
        glyphicon_gift('\ue102'),
        glyphicon_leaf('\ue103'),
        glyphicon_fire('\ue104'),
        glyphicon_eye_open('\ue105'),
        glyphicon_eye_close('\ue106'),
        glyphicon_warning_sign('\ue107'),
        glyphicon_plane('\ue108'),
        glyphicon_calendar('\ue109'),
        glyphicon_random('\ue110'),
        glyphicon_comment('\ue111'),
        glyphicon_magnet('\ue112'),
        glyphicon_chevron_up('\ue113'),
        glyphicon_chevron_down('\ue114'),
        glyphicon_retweet('\ue115'),
        glyphicon_shopping_cart('\ue116'),
        glyphicon_folder_close('\ue117'),
        glyphicon_folder_open('\ue118'),
        glyphicon_resize_vertical('\ue119'),
        glyphicon_resize_horizontal('\ue120'),
        glyphicon_hdd('\ue121'),
        glyphicon_bullhorn('\ue122'),
        glyphicon_bell('\ue123'),
        glyphicon_certificate('\ue124'),
        glyphicon_thumbs_up('\ue125'),
        glyphicon_thumbs_down('\ue126'),
        glyphicon_hand_right('\ue127'),
        glyphicon_hand_left('\ue128'),
        glyphicon_hand_up('\ue129'),
        glyphicon_hand_down('\ue130'),
        glyphicon_circle_arrow_right('\ue131'),
        glyphicon_circle_arrow_left('\ue132'),
        glyphicon_circle_arrow_up('\ue133'),
        glyphicon_circle_arrow_down('\ue134'),
        glyphicon_globe('\ue135'),
        glyphicon_wrench('\ue136'),
        glyphicon_tasks('\ue137'),
        glyphicon_filter('\ue138'),
        glyphicon_briefcase('\ue139'),
        glyphicon_fullscreen('\ue140'),
        glyphicon_dashboard('\ue141'),
        glyphicon_paperclip('\ue142'),
        glyphicon_heart_empty('\ue143'),
        glyphicon_link('\ue144'),
        glyphicon_phone('\ue145'),
        glyphicon_pushpin('\ue146'),
        glyphicon_usd('\ue148'),
        glyphicon_gbp('\ue149'),
        glyphicon_sort('\ue150'),
        glyphicon_sort_by_alphabet('\ue151'),
        glyphicon_sort_by_alphabet_alt('\ue152'),
        glyphicon_sort_by_order('\ue153'),
        glyphicon_sort_by_order_alt('\ue154'),
        glyphicon_sort_by_attributes('\ue155'),
        glyphicon_sort_by_attributes_alt('\ue156'),
        glyphicon_unchecked('\ue157'),
        glyphicon_expand('\ue158'),
        glyphicon_collapse_down('\ue159'),
        glyphicon_collapse_up('\ue160'),
        glyphicon_log_in('\ue161'),
        glyphicon_flash('\ue162'),
        glyphicon_log_out('\ue163'),
        glyphicon_new_window('\ue164'),
        glyphicon_record('\ue165'),
        glyphicon_save('\ue166'),
        glyphicon_open('\ue167'),
        glyphicon_saved('\ue168'),
        glyphicon_import('\ue169'),
        glyphicon_export('\ue170'),
        glyphicon_send('\ue171'),
        glyphicon_floppy_disk('\ue172'),
        glyphicon_floppy_saved('\ue173'),
        glyphicon_floppy_remove('\ue174'),
        glyphicon_floppy_save('\ue175'),
        glyphicon_floppy_open('\ue176'),
        glyphicon_credit_card('\ue177'),
        glyphicon_transfer('\ue178'),
        glyphicon_cutlery('\ue179'),
        glyphicon_header('\ue180'),
        glyphicon_compressed('\ue181'),
        glyphicon_earphone('\ue182'),
        glyphicon_phone_alt('\ue183'),
        glyphicon_tower('\ue184'),
        glyphicon_stats('\ue185'),
        glyphicon_sd_video('\ue186'),
        glyphicon_hd_video('\ue187'),
        glyphicon_subtitles('\ue188'),
        glyphicon_sound_stereo('\ue189'),
        glyphicon_sound_dolby('\ue190'),
        glyphicon_sound_5_1('\ue191'),
        glyphicon_sound_6_1('\ue192'),
        glyphicon_sound_7_1('\ue193'),
        glyphicon_copyright_mark('\ue194'),
        glyphicon_registration_mark('\ue195'),
        glyphicon_cloud_download('\ue197'),
        glyphicon_cloud_upload('\ue198'),
        glyphicon_tree_conifer('\ue199'),
        glyphicon_tree_deciduous('\ue200'),
        glyphicon_cd('\ue201'),
        glyphicon_save_file('\ue202'),
        glyphicon_open_file('\ue203'),
        glyphicon_level_up('\ue204'),
        glyphicon_copy('\ue205'),
        glyphicon_paste('\ue206'),
        glyphicon_alert('\ue209'),
        glyphicon_equalizer('\ue210'),
        glyphicon_king('\ue211'),
        glyphicon_queen('\ue212'),
        glyphicon_pawn('\ue213'),
        glyphicon_bishop('\ue214'),
        glyphicon_knight('\ue215'),
        glyphicon_baby_formula('\ue216'),
        glyphicon_tent('\u26fa'),
        glyphicon_blackboard('\ue218'),
        glyphicon_bed('\ue219'),
        glyphicon_apple('\uf8ff'),
        glyphicon_erase('\ue221'),
        glyphicon_hourglass('\u231b'),
        glyphicon_lamp('\ue223'),
        glyphicon_duplicate('\ue224'),
        glyphicon_piggy_bank('\ue225'),
        glyphicon_scissors('\ue226'),
        glyphicon_bitcoin('\ue227'),
        glyphicon_btc('\ue227'),
        glyphicon_xbt('\ue227'),
        glyphicon_yen('\u00a5'),
        glyphicon_jpy('\u00a5'),
        glyphicon_ruble('\u20bd'),
        glyphicon_rub('\u20bd'),
        glyphicon_scale('\ue230'),
        glyphicon_ice_lolly('\ue231'),
        glyphicon_ice_lolly_tasted('\ue232'),
        glyphicon_education('\ue233'),
        glyphicon_option_horizontal('\ue234'),
        glyphicon_option_vertical('\ue235'),
        glyphicon_menu_hamburger('\ue236'),
        glyphicon_modal_window('\ue237'),
        glyphicon_oil('\ue238'),
        glyphicon_grain('\ue239'),
        glyphicon_sunglasses('\ue240'),
        glyphicon_text_size('\ue241'),
        glyphicon_text_color('\ue242'),
        glyphicon_text_background('\ue243'),
        glyphicon_object_align_top('\ue244'),
        glyphicon_object_align_bottom('\ue245'),
        glyphicon_object_align_horizontal('\ue246'),
        glyphicon_object_align_left('\ue247'),
        glyphicon_object_align_vertical('\ue248'),
        glyphicon_object_align_right('\ue249'),
        glyphicon_triangle_right('\ue250'),
        glyphicon_triangle_left('\ue251'),
        glyphicon_triangle_bottom('\ue252'),
        glyphicon_triangle_top('\ue253'),
        glyphicon_console('\ue254'),
        glyphicon_superscript('\ue255'),
        glyphicon_subscript('\ue256'),
        glyphicon_menu_left('\ue257'),
        glyphicon_menu_right('\ue258'),
        glyphicon_menu_down('\ue259'),
        glyphicon_menu_up('\ue260');

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
                typeface = new GlyphiconsHalflings();
            }
            return typeface;
        }
    }
}
