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
        glyi_asterisk('\u002a'),
        glyi_plus('\u002b'),
        glyi_eur('\u20ac'),
        glyi_minus('\u2212'),
        glyi_cloud('\u2601'),
        glyi_envelope('\u2709'),
        glyi_pencil('\u270f'),
        glyi_glass('\ue001'),
        glyi_music('\ue002'),
        glyi_search('\ue003'),
        glyi_heart('\ue005'),
        glyi_star('\ue006'),
        glyi_star_empty('\ue007'),
        glyi_user('\ue008'),
        glyi_film('\ue009'),
        glyi_th_large('\ue010'),
        glyi_th('\ue011'),
        glyi_th_list('\ue012'),
        glyi_ok('\ue013'),
        glyi_remove('\ue014'),
        glyi_zoom_in('\ue015'),
        glyi_zoom_out('\ue016'),
        glyi_off('\ue017'),
        glyi_signal('\ue018'),
        glyi_cog('\ue019'),
        glyi_trash('\ue020'),
        glyi_home('\ue021'),
        glyi_file('\ue022'),
        glyi_time('\ue023'),
        glyi_road('\ue024'),
        glyi_download_alt('\ue025'),
        glyi_download('\ue026'),
        glyi_upload('\ue027'),
        glyi_inbox('\ue028'),
        glyi_play_circle('\ue029'),
        glyi_repeat('\ue030'),
        glyi_refresh('\ue031'),
        glyi_list_alt('\ue032'),
        glyi_lock('\ue033'),
        glyi_flag('\ue034'),
        glyi_headphones('\ue035'),
        glyi_volume_off('\ue036'),
        glyi_volume_down('\ue037'),
        glyi_volume_up('\ue038'),
        glyi_qrcode('\ue039'),
        glyi_barcode('\ue040'),
        glyi_tag('\ue041'),
        glyi_tags('\ue042'),
        glyi_book('\ue043'),
        glyi_bookmark('\ue044'),
        glyi_print('\ue045'),
        glyi_camera('\ue046'),
        glyi_font('\ue047'),
        glyi_bold('\ue048'),
        glyi_italic('\ue049'),
        glyi_text_height('\ue050'),
        glyi_text_width('\ue051'),
        glyi_align_left('\ue052'),
        glyi_align_center('\ue053'),
        glyi_align_right('\ue054'),
        glyi_align_justify('\ue055'),
        glyi_list('\ue056'),
        glyi_indent_left('\ue057'),
        glyi_indent_right('\ue058'),
        glyi_facetime_video('\ue059'),
        glyi_picture('\ue060'),
        glyi_map_marker('\ue062'),
        glyi_adjust('\ue063'),
        glyi_tint('\ue064'),
        glyi_edit('\ue065'),
        glyi_share('\ue066'),
        glyi_check('\ue067'),
        glyi_move('\ue068'),
        glyi_step_backward('\ue069'),
        glyi_fast_backward('\ue070'),
        glyi_backward('\ue071'),
        glyi_play('\ue072'),
        glyi_pause('\ue073'),
        glyi_stop('\ue074'),
        glyi_forward('\ue075'),
        glyi_fast_forward('\ue076'),
        glyi_step_forward('\ue077'),
        glyi_eject('\ue078'),
        glyi_chevron_left('\ue079'),
        glyi_chevron_right('\ue080'),
        glyi_plus_sign('\ue081'),
        glyi_minus_sign('\ue082'),
        glyi_remove_sign('\ue083'),
        glyi_ok_sign('\ue084'),
        glyi_question_sign('\ue085'),
        glyi_info_sign('\ue086'),
        glyi_screenshot('\ue087'),
        glyi_remove_circle('\ue088'),
        glyi_ok_circle('\ue089'),
        glyi_ban_circle('\ue090'),
        glyi_arrow_left('\ue091'),
        glyi_arrow_right('\ue092'),
        glyi_arrow_up('\ue093'),
        glyi_arrow_down('\ue094'),
        glyi_share_alt('\ue095'),
        glyi_resize_full('\ue096'),
        glyi_resize_small('\ue097'),
        glyi_exclamation_sign('\ue101'),
        glyi_gift('\ue102'),
        glyi_leaf('\ue103'),
        glyi_fire('\ue104'),
        glyi_eye_open('\ue105'),
        glyi_eye_close('\ue106'),
        glyi_warning_sign('\ue107'),
        glyi_plane('\ue108'),
        glyi_calendar('\ue109'),
        glyi_random('\ue110'),
        glyi_comment('\ue111'),
        glyi_magnet('\ue112'),
        glyi_chevron_up('\ue113'),
        glyi_chevron_down('\ue114'),
        glyi_retweet('\ue115'),
        glyi_shopping_cart('\ue116'),
        glyi_folder_close('\ue117'),
        glyi_folder_open('\ue118'),
        glyi_resize_vertical('\ue119'),
        glyi_resize_horizontal('\ue120'),
        glyi_hdd('\ue121'),
        glyi_bullhorn('\ue122'),
        glyi_bell('\ue123'),
        glyi_certificate('\ue124'),
        glyi_thumbs_up('\ue125'),
        glyi_thumbs_down('\ue126'),
        glyi_hand_right('\ue127'),
        glyi_hand_left('\ue128'),
        glyi_hand_up('\ue129'),
        glyi_hand_down('\ue130'),
        glyi_circle_arrow_right('\ue131'),
        glyi_circle_arrow_left('\ue132'),
        glyi_circle_arrow_up('\ue133'),
        glyi_circle_arrow_down('\ue134'),
        glyi_globe('\ue135'),
        glyi_wrench('\ue136'),
        glyi_tasks('\ue137'),
        glyi_filter('\ue138'),
        glyi_briefcase('\ue139'),
        glyi_fullscreen('\ue140'),
        glyi_dashboard('\ue141'),
        glyi_paperclip('\ue142'),
        glyi_heart_empty('\ue143'),
        glyi_link('\ue144'),
        glyi_phone('\ue145'),
        glyi_pushpin('\ue146'),
        glyi_usd('\ue148'),
        glyi_gbp('\ue149'),
        glyi_sort('\ue150'),
        glyi_sort_by_alphabet('\ue151'),
        glyi_sort_by_alphabet_alt('\ue152'),
        glyi_sort_by_order('\ue153'),
        glyi_sort_by_order_alt('\ue154'),
        glyi_sort_by_attributes('\ue155'),
        glyi_sort_by_attributes_alt('\ue156'),
        glyi_unchecked('\ue157'),
        glyi_expand('\ue158'),
        glyi_collapse_down('\ue159'),
        glyi_collapse_up('\ue160'),
        glyi_log_in('\ue161'),
        glyi_flash('\ue162'),
        glyi_log_out('\ue163'),
        glyi_new_window('\ue164'),
        glyi_record('\ue165'),
        glyi_save('\ue166'),
        glyi_open('\ue167'),
        glyi_saved('\ue168'),
        glyi_import('\ue169'),
        glyi_export('\ue170'),
        glyi_send('\ue171'),
        glyi_floppy_disk('\ue172'),
        glyi_floppy_saved('\ue173'),
        glyi_floppy_remove('\ue174'),
        glyi_floppy_save('\ue175'),
        glyi_floppy_open('\ue176'),
        glyi_credit_card('\ue177'),
        glyi_transfer('\ue178'),
        glyi_cutlery('\ue179'),
        glyi_header('\ue180'),
        glyi_compressed('\ue181'),
        glyi_earphone('\ue182'),
        glyi_phone_alt('\ue183'),
        glyi_tower('\ue184'),
        glyi_stats('\ue185'),
        glyi_sd_video('\ue186'),
        glyi_hd_video('\ue187'),
        glyi_subtitles('\ue188'),
        glyi_sound_stereo('\ue189'),
        glyi_sound_dolby('\ue190'),
        glyi_sound_5_1('\ue191'),
        glyi_sound_6_1('\ue192'),
        glyi_sound_7_1('\ue193'),
        glyi_copyright_mark('\ue194'),
        glyi_registration_mark('\ue195'),
        glyi_cloud_download('\ue197'),
        glyi_cloud_upload('\ue198'),
        glyi_tree_conifer('\ue199'),
        glyi_tree_deciduous('\ue200'),
        glyi_cd('\ue201'),
        glyi_save_file('\ue202'),
        glyi_open_file('\ue203'),
        glyi_level_up('\ue204'),
        glyi_copy('\ue205'),
        glyi_paste('\ue206'),
        glyi_alert('\ue209'),
        glyi_equalizer('\ue210'),
        glyi_king('\ue211'),
        glyi_queen('\ue212'),
        glyi_pawn('\ue213'),
        glyi_bishop('\ue214'),
        glyi_knight('\ue215'),
        glyi_baby_formula('\ue216'),
        glyi_tent('\u26fa'),
        glyi_blackboard('\ue218'),
        glyi_bed('\ue219'),
        glyi_apple('\uf8ff'),
        glyi_erase('\ue221'),
        glyi_hourglass('\u231b'),
        glyi_lamp('\ue223'),
        glyi_duplicate('\ue224'),
        glyi_piggy_bank('\ue225'),
        glyi_scissors('\ue226'),
        glyi_bitcoin('\ue227'),
        glyi_btc('\ue227'),
        glyi_xbt('\ue227'),
        glyi_yen('\u00a5'),
        glyi_jpy('\u00a5'),
        glyi_ruble('\u20bd'),
        glyi_rub('\u20bd'),
        glyi_scale('\ue230'),
        glyi_ice_lolly('\ue231'),
        glyi_ice_lolly_tasted('\ue232'),
        glyi_education('\ue233'),
        glyi_option_horizontal('\ue234'),
        glyi_option_vertical('\ue235'),
        glyi_menu_hamburger('\ue236'),
        glyi_modal_window('\ue237'),
        glyi_oil('\ue238'),
        glyi_grain('\ue239'),
        glyi_sunglasses('\ue240'),
        glyi_text_size('\ue241'),
        glyi_text_color('\ue242'),
        glyi_text_background('\ue243'),
        glyi_object_align_top('\ue244'),
        glyi_object_align_bottom('\ue245'),
        glyi_object_align_horizontal('\ue246'),
        glyi_object_align_left('\ue247'),
        glyi_object_align_vertical('\ue248'),
        glyi_object_align_right('\ue249'),
        glyi_triangle_right('\ue250'),
        glyi_triangle_left('\ue251'),
        glyi_triangle_bottom('\ue252'),
        glyi_triangle_top('\ue253'),
        glyi_console('\ue254'),
        glyi_superscript('\ue255'),
        glyi_subscript('\ue256'),
        glyi_menu_left('\ue257'),
        glyi_menu_right('\ue258'),
        glyi_menu_down('\ue259'),
        glyi_menu_up('\ue260');

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
