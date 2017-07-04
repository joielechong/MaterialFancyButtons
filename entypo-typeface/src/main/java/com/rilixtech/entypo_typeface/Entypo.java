package com.rilixtech.entypo_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Entypo implements ITypeface {
    private static final String TTF_FILE = "entypo-font-v1.0.0.1.ttf";
    private static final String MAPPING_FONT_PREFIX = "enti";

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
        return "Entypo";
    }

    @Override
    public String getVersion() {
        return "1.0.0.1";
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
        return "Daniel Bruce";
    }

    @Override
    public String getUrl() {
        return "http://www.entypo.com/";
    }

    @Override
    public String getDescription() {
        return "411 carefully crafted premium pictograms by Daniel Bruce";
    }

    @Override
    public String getLicense() {
        return "CC BY-SA 4.0";
    }

    @Override
    public String getLicenseUrl() {
        return "https://creativecommons.org/licenses/by-sa/4.0/";
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
        enti_add_to_list('\ue900'),
        enti_classic_computer('\ue901'),
        enti_controller_fast_backward('\ue902'),
        enti_creative_commons_attribution('\ue903'),
        enti_creative_commons_noderivs('\ue904'),
        enti_creative_commons_noncommercial_eu('\ue905'),
        enti_creative_commons_noncommercial_us('\ue906'),
        enti_creative_commons_public_domain('\ue907'),
        enti_creative_commons_remix('\ue908'),
        enti_creative_commons_share('\ue909'),
        enti_creative_commons_sharealike('\ue90a'),
        enti_creative_commons('\ue90b'),
        enti_documenti_landscape('\ue90c'),
        enti_remove_user('\ue90d'),
        enti_warning('\ue90e'),
        enti_arrow_bold_down('\ue90f'),
        enti_arrow_bold_left('\ue910'),
        enti_arrow_bold_right('\ue911'),
        enti_arrow_bold_up('\ue912'),
        enti_arrow_down('\ue913'),
        enti_arrow_left('\ue914'),
        enti_arrow_long_down('\ue915'),
        enti_arrow_long_left('\ue916'),
        enti_arrow_long_right('\ue917'),
        enti_arrow_long_up('\ue918'),
        enti_arrow_right('\ue919'),
        enti_arrow_up('\ue91a'),
        enti_arrow_with_circle_down('\ue91b'),
        enti_arrow_with_circle_left('\ue91c'),
        enti_arrow_with_circle_right('\ue91d'),
        enti_arrow_with_circle_up('\ue91e'),
        enti_bookmark('\ue91f'),
        enti_bookmarks('\ue920'),
        enti_chevron_down('\ue921'),
        enti_chevron_left('\ue922'),
        enti_chevron_right('\ue923'),
        enti_chevron_small_down('\ue924'),
        enti_chevron_small_left('\ue925'),
        enti_chevron_small_right('\ue926'),
        enti_chevron_small_up('\ue927'),
        enti_chevron_thin_down('\ue928'),
        enti_chevron_thin_left('\ue929'),
        enti_chevron_thin_right('\ue92a'),
        enti_chevron_thin_up('\ue92b'),
        enti_chevron_up('\ue92c'),
        enti_chevron_with_circle_down('\ue92d'),
        enti_chevron_with_circle_left('\ue92e'),
        enti_chevron_with_circle_right('\ue92f'),
        enti_chevron_with_circle_up('\ue930'),
        enti_cloud('\ue931'),
        enti_controller_fast_forward('\ue932'),
        enti_controller_jump_to_start('\ue933'),
        enti_controller_next('\ue934'),
        enti_controller_paus('\ue935'),
        enti_controller_play('\ue936'),
        enti_controller_record('\ue937'),
        enti_controller_stop('\ue938'),
        enti_controller_volume('\ue939'),
        enti_dot_single('\ue93a'),
        enti_dots_three_horizontal('\ue93b'),
        enti_dots_three_vertical('\ue93c'),
        enti_dots_two_horizontal('\ue93d'),
        enti_dots_two_vertical('\ue93e'),
        enti_download('\ue93f'),
        enti_emoji_flirt('\ue940'),
        enti_flow_branch('\ue941'),
        enti_flow_cascade('\ue942'),
        enti_flow_line('\ue943'),
        enti_flow_parallel('\ue944'),
        enti_flow_tree('\ue945'),
        enti_install('\ue946'),
        enti_layers('\ue947'),
        enti_open_book('\ue948'),
        enti_resize_100('\ue949'),
        enti_resize_full_screen('\ue94a'),
        enti_save('\ue94b'),
        enti_select_arrows('\ue94c'),
        enti_sound_mute('\ue94d'),
        enti_sound('\ue94e'),
        enti_trash('\ue94f'),
        enti_triangle_down('\ue950'),
        enti_triangle_left('\ue951'),
        enti_triangle_right('\ue952'),
        enti_triangle_up('\ue953'),
        enti_uninstall('\ue954'),
        enti_upload_to_cloud('\ue955'),
        enti_upload('\ue956'),
        enti_add_user('\ue957'),
        enti_address('\ue958'),
        enti_adjust('\ue959'),
        enti_air('\ue95a'),
        enti_aircraft_landing('\ue95b'),
        enti_aircraft_take_off('\ue95c'),
        enti_aircraft('\ue95d'),
        enti_align_bottom('\ue95e'),
        enti_align_horizontal_middle('\ue95f'),
        enti_align_left('\ue960'),
        enti_align_right('\ue961'),
        enti_align_top('\ue962'),
        enti_align_vertical_middle('\ue963'),
        enti_archive('\ue964'),
        enti_area_graph('\ue965'),
        enti_attachment('\ue966'),
        enti_awareness_ribbon('\ue967'),
        enti_back_in_time('\ue968'),
        enti_back('\ue969'),
        enti_bar_graph('\ue96a'),
        enti_battery('\ue96b'),
        enti_beamed_note('\ue96c'),
        enti_bell('\ue96d'),
        enti_blackboard('\ue96e'),
        enti_block('\ue96f'),
        enti_book('\ue970'),
        enti_bowl('\ue971'),
        enti_box('\ue972'),
        enti_briefcase('\ue973'),
        enti_browser('\ue974'),
        enti_brush('\ue975'),
        enti_bucket('\ue976'),
        enti_cake('\ue977'),
        enti_calculator('\ue978'),
        enti_calendar('\ue979'),
        enti_camera('\ue97a'),
        enti_ccw('\ue97b'),
        enti_chat('\ue97c'),
        enti_check('\ue97d'),
        enti_circle_with_cross('\ue97e'),
        enti_circle_with_minus('\ue97f'),
        enti_circle_with_plus('\ue980'),
        enti_circle('\ue981'),
        enti_circular_graph('\ue982'),
        enti_clapperboard('\ue983'),
        enti_clipboard('\ue984'),
        enti_clock('\ue985'),
        enti_code('\ue986'),
        enti_cog('\ue987'),
        enti_colours('\ue988'),
        enti_compass('\ue989'),
        enti_copy('\ue98a'),
        enti_credit_card('\ue98b'),
        enti_credit('\ue98c'),
        enti_cross('\ue98d'),
        enti_cup('\ue98e'),
        enti_cw('\ue98f'),
        enti_cycle('\ue990'),
        enti_database('\ue991'),
        enti_dial_pad('\ue992'),
        enti_direction('\ue993'),
        enti_document('\ue994'),
        enti_documents('\ue995'),
        enti_drink('\ue996'),
        enti_drive('\ue997'),
        enti_drop('\ue998'),
        enti_edit('\ue999'),
        enti_email('\ue99a'),
        enti_emoji_happy('\ue99b'),
        enti_emoji_neutral('\ue99c'),
        enti_emoji_sad('\ue99d'),
        enti_erase('\ue99e'),
        enti_eraser('\ue99f'),
        enti_export('\ue9a0'),
        enti_eye('\ue9a1'),
        enti_feather('\ue9a2'),
        enti_flag('\ue9a3'),
        enti_flash('\ue9a4'),
        enti_flashlight('\ue9a5'),
        enti_flat_brush('\ue9a6'),
        enti_folder_images('\ue9a7'),
        enti_folder_music('\ue9a8'),
        enti_folder_video('\ue9a9'),
        enti_folder('\ue9aa'),
        enti_forward('\ue9ab'),
        enti_funnel('\ue9ac'),
        enti_game_controller('\ue9ad'),
        enti_gauge('\ue9ae'),
        enti_globe('\ue9af'),
        enti_graduation_cap('\ue9b0'),
        enti_grid('\ue9b1'),
        enti_hair_cross('\ue9b2'),
        enti_hand('\ue9b3'),
        enti_heart_outlined('\ue9b4'),
        enti_heart('\ue9b5'),
        enti_help_with_circle('\ue9b6'),
        enti_help('\ue9b7'),
        enti_home('\ue9b8'),
        enti_hour_glass('\ue9b9'),
        enti_image_inverted('\ue9ba'),
        enti_image('\ue9bb'),
        enti_images('\ue9bc'),
        enti_inbox('\ue9bd'),
        enti_infinity('\ue9be'),
        enti_info_with_circle('\ue9bf'),
        enti_info('\ue9c0'),
        enti_key('\ue9c1'),
        enti_keyboard('\ue9c2'),
        enti_lab_flask('\ue9c3'),
        enti_landline('\ue9c4'),
        enti_language('\ue9c5'),
        enti_laptop('\ue9c6'),
        enti_leaf('\ue9c7'),
        enti_level_down('\ue9c8'),
        enti_level_up('\ue9c9'),
        enti_lifebuoy('\ue9ca'),
        enti_light_bulb('\ue9cb'),
        enti_light_down('\ue9cc'),
        enti_light_up('\ue9cd'),
        enti_line_graph('\ue9ce'),
        enti_link('\ue9cf'),
        enti_list('\ue9d0'),
        enti_location_pin('\ue9d1'),
        enti_location('\ue9d2'),
        enti_lock_open('\ue9d3'),
        enti_lock('\ue9d4'),
        enti_log_out('\ue9d5'),
        enti_login('\ue9d6'),
        enti_loop('\ue9d7'),
        enti_magnet('\ue9d8'),
        enti_magnifying_glass('\ue9d9'),
        enti_mail('\ue9da'),
        enti_man('\ue9db'),
        enti_map('\ue9dc'),
        enti_mask('\ue9dd'),
        enti_medal('\ue9de'),
        enti_megaphone('\ue9df'),
        enti_menu('\ue9e0'),
        enti_message('\ue9e1'),
        enti_mic('\ue9e2'),
        enti_minus('\ue9e3'),
        enti_mobile('\ue9e4'),
        enti_modern_mic('\ue9e5'),
        enti_moon('\ue9e6'),
        enti_mouse('\ue9e7'),
        enti_music('\ue9e8'),
        enti_network('\ue9e9'),
        enti_new_message('\ue9ea'),
        enti_new('\ue9eb'),
        enti_news('\ue9ec'),
        enti_note('\ue9ed'),
        enti_notification('\ue9ee'),
        enti_old_mobile('\ue9ef'),
        enti_old_phone('\ue9f0'),
        enti_palette('\ue9f1'),
        enti_paper_plane('\ue9f2'),
        enti_pencil('\ue9f3'),
        enti_phone('\ue9f4'),
        enti_pie_chart('\ue9f5'),
        enti_pin('\ue9f6'),
        enti_plus('\ue9f7'),
        enti_popup('\ue9f8'),
        enti_power_plug('\ue9f9'),
        enti_price_ribbon('\ue9fa'),
        enti_price_tag('\ue9fb'),
        enti_print('\ue9fc'),
        enti_progress_empty('\ue9fd'),
        enti_progress_full('\ue9fe'),
        enti_progress_one('\ue9ff'),
        enti_progress_two('\uea00'),
        enti_publish('\uea01'),
        enti_quote('\uea02'),
        enti_radio('\uea03'),
        enti_reply_all('\uea04'),
        enti_reply('\uea05'),
        enti_retweet('\uea06'),
        enti_rocket('\uea07'),
        enti_round_brush('\uea08'),
        enti_rss('\uea09'),
        enti_ruler('\uea0a'),
        enti_scissors('\uea0b'),
        enti_share_alternitive('\uea0c'),
        enti_share('\uea0d'),
        enti_shareable('\uea0e'),
        enti_shield('\uea0f'),
        enti_shop('\uea10'),
        enti_shopping_bag('\uea11'),
        enti_shopping_basket('\uea12'),
        enti_shopping_cart('\uea13'),
        enti_shuffle('\uea14'),
        enti_signal('\uea15'),
        enti_sound_mix('\uea16'),
        enti_sports_club('\uea17'),
        enti_spreadsheet('\uea18'),
        enti_squared_cross('\uea19'),
        enti_squared_minus('\uea1a'),
        enti_squared_plus('\uea1b'),
        enti_star_outlined('\uea1c'),
        enti_star('\uea1d'),
        enti_stopwatch('\uea1e'),
        enti_suitcase('\uea1f'),
        enti_swap('\uea20'),
        enti_sweden('\uea21'),
        enti_switch('\uea22'),
        enti_tablet('\uea23'),
        enti_tag('\uea24'),
        enti_text_documenti_inverted('\uea25'),
        enti_text_document('\uea26'),
        enti_text('\uea27'),
        enti_thermometer('\uea28'),
        enti_thumbs_down('\uea29'),
        enti_thumbs_up('\uea2a'),
        enti_thunder_cloud('\uea2b'),
        enti_ticket('\uea2c'),
        enti_time_slot('\uea2d'),
        enti_tools('\uea2e'),
        enti_traffic_cone('\uea2f'),
        enti_tree('\uea30'),
        enti_trophy('\uea31'),
        enti_tv('\uea32'),
        enti_typing('\uea33'),
        enti_unread('\uea34'),
        enti_untag('\uea35'),
        enti_user('\uea36'),
        enti_users('\uea37'),
        enti_v_card('\uea38'),
        enti_video('\uea39'),
        enti_vinyl('\uea3a'),
        enti_voicemail('\uea3b'),
        enti_wallet('\uea3c'),
        enti_water('\uea3d'),
        enti_500px_with_circle('\uea3e'),
        enti_500px('\uea3f'),
        enti_basecamp('\uea40'),
        enti_behance('\uea41'),
        enti_creative_cloud('\uea42'),
        enti_dropbox('\uea43'),
        enti_evernote('\uea44'),
        enti_flattr('\uea45'),
        enti_foursquare('\uea46'),
        enti_google_drive('\uea47'),
        enti_google_hangouts('\uea48'),
        enti_grooveshark('\uea49'),
        enti_icloud('\uea4a'),
        enti_mixi('\uea4b'),
        enti_onedrive('\uea4c'),
        enti_paypal('\uea4d'),
        enti_picasa('\uea4e'),
        enti_qq('\uea4f'),
        enti_rdio_with_circle('\uea50'),
        enti_renren('\uea51'),
        enti_scribd('\uea52'),
        enti_sina_weibo('\uea53'),
        enti_skype_with_circle('\uea54'),
        enti_skype('\uea55'),
        enti_slideshare('\uea56'),
        enti_smashing('\uea57'),
        enti_soundcloud('\uea58'),
        enti_spotify_with_circle('\uea59'),
        enti_spotify('\uea5a'),
        enti_swarm('\uea5b'),
        enti_vine_with_circle('\uea5c'),
        enti_vine('\uea5d'),
        enti_vk_alternitive('\uea5e'),
        enti_vk_with_circle('\uea5f'),
        enti_vk('\uea60'),
        enti_xing_with_circle('\uea61'),
        enti_xing('\uea62'),
        enti_yelp('\uea63'),
        enti_dribbble_with_circle('\uea64'),
        enti_dribbble('\uea65'),
        enti_facebook_with_circle('\uea66'),
        enti_facebook('\uea67'),
        enti_flickr_with_circle('\uea68'),
        enti_flickr('\uea69'),
        enti_github_with_circle('\uea6a'),
        enti_github('\uea6b'),
        enti_google_with_circle('\uea6c'),
        enti_google('\uea6d'),
        enti_instagram_with_circle('\uea6e'),
        enti_instagram('\uea6f'),
        enti_lastfm_with_circle('\uea70'),
        enti_lastfm('\uea71'),
        enti_linkedin_with_circle('\uea72'),
        enti_linkedin('\uea73'),
        enti_pinterest_with_circle('\uea74'),
        enti_pinterest('\uea75'),
        enti_rdio('\uea76'),
        enti_stumbleupon_with_circle('\uea77'),
        enti_stumbleupon('\uea78'),
        enti_tumblr_with_circle('\uea79'),
        enti_tumblr('\uea7a'),
        enti_twitter_with_circle('\uea7b'),
        enti_twitter('\uea7c'),
        enti_vimeo_with_circle('\uea7d'),
        enti_vimeo('\uea7e'),
        enti_youtube_with_circle('\uea7f'),
        enti_youtube('\uea80');

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
                typeface = new Entypo();
            }
            return typeface;
        }
    }
}
