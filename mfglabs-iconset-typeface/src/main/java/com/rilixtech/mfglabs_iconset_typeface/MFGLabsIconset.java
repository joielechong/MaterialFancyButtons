package com.rilixtech.mfglabs_iconset_typeface;

import android.content.Context;
import android.graphics.Typeface;
import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class MFGLabsIconset implements ITypeface {
    private static final String TTF_FILE = "mfglabsiconset-webfont-1.0.ttf";
    private static final String MAPPING_FONT_PREFIX = "mfgi";

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
                aChars.put(v.name(),
                        v.character);
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
        return "mfglabs-iconset";
    }

    @Override
    public String getVersion() {
        return "1.0";
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
        return "MFG Labs";
    }

    @Override
    public String getUrl() {
        return "https://github.com/MfgLabs/mfglabs-iconset";
    }

    @Override
    public String getDescription() {
        return "Awesome web font icon by MFG Labs.";
    }

    @Override
    public String getLicense() {
        return "Licensed under the SIL Open Font License - http://scripts.sil.org/OFL";
    }

    @Override
    public String getLicenseUrl() {
        return "http://scripts.sil.org/OFL";
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(),
                        "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {
        // MFG Labs iconset 1.0
        mfgi_icon_cloud('\u2601'),
        mfgi_icon_at('\u0040'),
        mfgi_icon_plus('\u002B'),
        mfgi_icon_minus('\u2212'),
        mfgi_icon_arrow_up('\u2191'),
        mfgi_icon_arrow_down('\u2193'),
        mfgi_icon_arrow_right('\u2192'),
        mfgi_icon_arrow_left('\u2190'),
        mfgi_icon_chevron_down('\uf004'),
        mfgi_icon_chevron_up('\uf005'),
        mfgi_icon_chevron_right('\uf006'),
        mfgi_icon_chevron_left('\uf007'),
        mfgi_icon_reorder('\uf008'),
        mfgi_icon_list('\uf009'),
        mfgi_icon_reorder_square('\uf00a'),
        mfgi_icon_reorder_square_line('\uf00b'),
        mfgi_icon_coverflow('\uf00c'),
        mfgi_icon_coverflow_line('\uf00d'),
        mfgi_icon_pause('\uf00e'),
        mfgi_icon_play('\uf00f'),
        mfgi_icon_step_forward('\uf010'),
        mfgi_icon_step_backward('\uf011'),
        mfgi_icon_fast_forward('\uf012'),
        mfgi_icon_fast_backward('\uf013'),
        mfgi_icon_cloud_upload('\uf014'),
        mfgi_icon_cloud_download('\uf015'),
        mfgi_icon_data_science('\uf016'),
        mfgi_icon_data_science_black('\uf017'),
        mfgi_icon_globe('\uf018'),
        mfgi_icon_globe_black('\uf019'),
        mfgi_icon_math_ico('\uf01a'),
        mfgi_icon_math('\uf01b'),
        mfgi_icon_math_black('\uf01c'),
        mfgi_icon_paperplane_ico('\uf01d'),
        mfgi_icon_paperplane('\uf01e'),
        mfgi_icon_paperplane_black('\uf01f'),
        mfgi_icon_color_balance('\uf020'),
        mfgi_icon_star('\u2605'),
        mfgi_icon_star_half('\uf022'),
        mfgi_icon_star_empty('\u2606'),
        mfgi_icon_star_half_empty('\uf024'),
        mfgi_icon_reload('\uf025'),
        mfgi_icon_heart('\u2665'),
        mfgi_icon_heart_broken('\uf028'),
        mfgi_icon_hashtag('\uf029'),
        mfgi_icon_reply('\uf02a'),
        mfgi_icon_retweet('\uf02b'),
        mfgi_icon_signin('\uf02c'),
        mfgi_icon_signout('\uf02d'),
        mfgi_icon_download('\uf02e'),
        mfgi_icon_upload('\uf02f'),
        mfgi_icon_placepin('\uf031'),
        mfgi_icon_display_screen('\uf032'),
        mfgi_icon_tablet('\uf033'),
        mfgi_icon_smartphone('\uf034'),
        mfgi_icon_connected_object('\uf035'),
        mfgi_icon_lock('\uF512'),
        mfgi_icon_unlock('\uF513'),
        mfgi_icon_camera('\uF4F7'),
        mfgi_icon_isight('\uf039'),
        mfgi_icon_video_camera('\uf03a'),
        mfgi_icon_random('\uf03b'),
        mfgi_icon_message('\uF4AC'),
        mfgi_icon_discussion('\uf03d'),
        mfgi_icon_calendar('\uF4C5'),
        mfgi_icon_ringbell('\uf03f'),
        mfgi_icon_movie('\uf040'),
        mfgi_icon_mail('\u2709'),
        mfgi_icon_pen('\u270F'),
        mfgi_icon_settings('\u9881'),
        mfgi_icon_measure('\uf044'),
        mfgi_icon_vector('\uf045'),
        mfgi_icon_vector_pen('\u2712'),
        mfgi_icon_mute_on('\uf047'),
        mfgi_icon_mute_off('\uf048'),
        mfgi_icon_home('\u2302'),
        mfgi_icon_sheet('\uf04a'),
        mfgi_icon_arrow_big_right('\u21C9'),
        mfgi_icon_arrow_big_left('\u21C7'),
        mfgi_icon_arrow_big_down('\u21CA'),
        mfgi_icon_arrow_big_up('\u21C8'),
        mfgi_icon_dribbble_circle('\uf04f'),
        mfgi_icon_dribbble('\uf050'),
        mfgi_icon_facebook_circle('\uf051'),
        mfgi_icon_facebook('\uf052'),
        mfgi_icon_git_circle_alt('\uf053'),
        mfgi_icon_git_circle('\uf054'),
        mfgi_icon_git('\uf055'),
        mfgi_icon_octopus('\uf056'),
        mfgi_icon_twitter_circle('\uf057'),
        mfgi_icon_twitter('\uf058'),
        mfgi_icon_google_plus_circle('\uf059'),
        mfgi_icon_google_plus('\uf05a'),
        mfgi_icon_linked_in_circle('\uf05b'),
        mfgi_icon_linked_in('\uf05c'),
        mfgi_icon_instagram('\uf05d'),
        mfgi_icon_instagram_circle('\uf05e'),
        mfgi_icon_mfg_icon('\uf05f'),
        mfgi_icon_xing('\uF532'),
        mfgi_icon_xing_circle('\uF533'),
        mfgi_icon_mfg_icon_circle('\uf060'),
        mfgi_icon_user('\uf061'),
        mfgi_icon_user_male('\uf062'),
        mfgi_icon_user_female('\uf063'),
        mfgi_icon_users('\uf064'),
        mfgi_icon_file_open('\uF4C2'),
        mfgi_icon_file_close('\uf067'),
        mfgi_icon_file_alt('\uf068'),
        mfgi_icon_file_close_alt('\uf069'),
        mfgi_icon_attachment('\uf06a'),
        mfgi_icon_check('\u2713'),
        mfgi_icon_cross_mark('\u274C'),
        mfgi_icon_cancel_circle('\uF06E'),
        mfgi_icon_check_circle('\uf06d'),
        mfgi_icon_magnifying('\uF50D'),
        mfgi_icon_inbox('\uf070'),
        mfgi_icon_clock('\u23F2'),
        mfgi_icon_stopwatch('\u23F1'),
        mfgi_icon_hourglass('\u231B'),
        mfgi_icon_trophy('\uf074'),
        mfgi_icon_unlock_alt('\uF075'),
        mfgi_icon_lock_alt('\uF510'),
        mfgi_icon_arrow_doubled_right('\u21D2'),
        mfgi_icon_arrow_doubled_left('\u21D0'),
        mfgi_icon_arrow_doubled_down('\u21D3'),
        mfgi_icon_arrow_doubled_up('\u21D1'),
        mfgi_icon_link('\uf07B'),
        mfgi_icon_warning('\u2757'),
        mfgi_icon_warning_alt('\u2755'),
        mfgi_icon_magnifying_plus('\uf07E'),
        mfgi_icon_magnifying_minus('\uf07F'),
        mfgi_icon_white_question('\u2754'),
        mfgi_icon_black_question('\u2753'),
        mfgi_icon_stop('\uf080'),
        mfgi_icon_share('\uf081'),
        mfgi_icon_eye('\uf082'),
        mfgi_icon_trash_can('\uf083'),
        mfgi_icon_hard_drive('\uf084'),
        mfgi_icon_information_black('\uf085'),
        mfgi_icon_information_white('\uf086'),
        mfgi_icon_printer('\uf087'),
        mfgi_icon_letter('\uf088'),
        mfgi_icon_soundcloud('\uf089'),
        mfgi_icon_soundcloud_circle('\uf08A'),
        mfgi_icon_anchor('\u2693'),
        mfgi_icon_female_sign('\u2640'),
        mfgi_icon_male_sign('\u2642'),
        mfgi_icon_joystick('\uF514'),
        mfgi_icon_high_voltage('\u26A1'),
        mfgi_icon_fire('\uF525'),
        mfgi_icon_newspaper('\uF4F0'),
        mfgi_icon_chart('\uF526'),
        mfgi_icon_spread('\uF527'),
        mfgi_icon_spinner_1('\uF528'),
        mfgi_icon_spinner_2('\uF529'),
        mfgi_icon_chart_alt('\uF530'),
        mfgi_icon_label('\uF531'),
        mfgi_icon_brush('\uE000'),
        mfgi_icon_refresh('\uE001'),
        mfgi_icon_node('\uE002'),
        mfgi_icon_node_2('\uE003'),
        mfgi_icon_node_3('\uE004'),
        mfgi_icon_link_2_nodes('\uE005'),
        mfgi_icon_link_3_nodes('\uE006'),
        mfgi_icon_link_loop_nodes('\uE007'),
        mfgi_icon_node_size('\uE008'),
        mfgi_icon_node_color('\uE009'),
        mfgi_icon_layout_directed('\uE010'),
        mfgi_icon_layout_radial('\uE011'),
        mfgi_icon_layout_hierarchical('\uE012'),
        mfgi_icon_node_link_direction('\uE013'),
        mfgi_icon_node_link_short_path('\uE014'),
        mfgi_icon_node_cluster('\uE015'),
        mfgi_icon_display_graph('\uE016'),
        mfgi_icon_node_link_weight('\uE017'),
        mfgi_icon_more_node_links('\uE018'),
        mfgi_icon_node_shape('\uE00A'),
        mfgi_icon_node_icon('\uE00B'),
        mfgi_icon_node_text('\uE00C'),
        mfgi_icon_node_link_text('\uE00D'),
        mfgi_icon_node_link_color('\uE00E'),
        mfgi_icon_node_link_shape('\uE00F'),
        mfgi_icon_credit_card('\uF4B3'),
        mfgi_icon_disconnect('\uF534'),
        mfgi_icon_graph('\uF535'),
        mfgi_icon_new_user('\uF536');


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
                typeface = new MFGLabsIconset();
            }
            return typeface;
        }
    }
}
