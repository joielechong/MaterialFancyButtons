package com.rilixtech.octicons_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Octicons implements ITypeface {
    private static final String TTF_FILE = "octicons-v3.2.0.ttf";
    private static final String MAPPING_FONT_PREFIX = "octi";

    private static Typeface typeface = null;

    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<>();
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
        return "Octicons";
    }

    @Override
    public String getVersion() {
        return "3.2.0";
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
        return "GitHub";
    }

    @Override
    public String getUrl() {
        return "https://github.com/github/octicons";
    }

    @Override
    public String getDescription() {
        return "GitHub's icon font https://octicons.github.com/";
    }

    @Override
    public String getLicense() {
        return " SIL OFL 1.1";
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
        //Octicons
        octi_alert('\uf02d'),
        octi_arrow_down('\uf03f'),
        octi_arrow_left('\uf040'),
        octi_arrow_right('\uf03e'),
        octi_arrow_small_down('\uf0a0'),
        octi_arrow_small_left('\uf0a1'),
        octi_arrow_small_right('\uf071'),
        octi_arrow_small_up('\uf09f'),
        octi_arrow_up('\uf03d'),
        octi_microscope('\uf0dd'),
        octi_beaker('\uf0dd'),
        octi_bell('\uf0de'),
        octi_bold('\uf0e2'),
        octi_book('\uf007'),
        octi_bookmark('\uf07b'),
        octi_briefcase('\uf0d3'),
        octi_broadcast('\uf048'),
        octi_browser('\uf0c5'),
        octi_bug('\uf091'),
        octi_calendar('\uf068'),
        octi_check('\uf03a'),
        octi_checklist('\uf076'),
        octi_chevron_down('\uf0a3'),
        octi_chevron_left('\uf0a4'),
        octi_chevron_right('\uf078'),
        octi_chevron_up('\uf0a2'),
        octi_circle_slash('\uf084'),
        octi_circuit_board('\uf0d6'),
        octi_clippy('\uf035'),
        octi_clock('\uf046'),
        octi_cloud_download('\uf00b'),
        octi_cloud_upload('\uf00c'),
        octi_code('\uf05f'),
        octi_color_mode('\uf065'),
        octi_commenti_add('\uf02b'),
        octi_comment('\uf02b'),
        octi_commenti_discussion('\uf04f'),
        octi_credit_card('\uf045'),
        octi_dash('\uf0ca'),
        octi_dashboard('\uf07d'),
        octi_database('\uf096'),
        octi_clone('\uf0dc'),
        octi_desktop_download('\uf0dc'),
        octi_device_camera('\uf056'),
        octi_device_camera_video('\uf057'),
        octi_device_desktop('\uf27c'),
        octi_device_mobile('\uf038'),
        octi_diff('\uf04d'),
        octi_diff_added('\uf06b'),
        octi_diff_ignored('\uf099'),
        octi_diff_modified('\uf06d'),
        octi_diff_removed('\uf06c'),
        octi_diff_renamed('\uf06e'),
        octi_ellipsis('\uf09a'),
        octi_eye_unwatch('\uf04e'),
        octi_eye_watch('\uf04e'),
        octi_eye('\uf04e'),
        octi_file_binary('\uf094'),
        octi_file_code('\uf010'),
        octi_file_directory('\uf016'),
        octi_file_media('\uf012'),
        octi_file_pdf('\uf014'),
        octi_file_submodule('\uf017'),
        octi_file_symlink_directory('\uf0b1'),
        octi_file_symlink_file('\uf0b0'),
        octi_file_text('\uf011'),
        octi_file_zip('\uf013'),
        octi_flame('\uf0d2'),
        octi_fold('\uf0cc'),
        octi_gear('\uf02f'),
        octi_gift('\uf042'),
        octi_gist('\uf00e'),
        octi_gist_secret('\uf08c'),
        octi_git_branch_create('\uf020'),
        octi_git_branch_delete('\uf020'),
        octi_git_branch('\uf020'),
        octi_git_commit('\uf01f'),
        octi_git_compare('\uf0ac'),
        octi_git_merge('\uf023'),
        octi_git_pull_request_abandoned('\uf009'),
        octi_git_pull_request('\uf009'),
        octi_globe('\uf0b6'),
        octi_graph('\uf043'),
        octi_heart('\u2665'),
        octi_history('\uf07e'),
        octi_home('\uf08d'),
        octi_horizontal_rule('\uf070'),
        octi_hubot('\uf09d'),
        octi_inbox('\uf0cf'),
        octi_info('\uf059'),
        octi_issue_closed('\uf028'),
        octi_issue_opened('\uf026'),
        octi_issue_reopened('\uf027'),
        octi_italic('\uf0e4'),
        octi_jersey('\uf019'),
        octi_key('\uf049'),
        octi_keyboard('\uf00d'),
        octi_law('\uf0d8'),
        octi_light_bulb('\uf000'),
        octi_link('\uf05c'),
        octi_link_external('\uf07f'),
        octi_list_ordered('\uf062'),
        octi_list_unordered('\uf061'),
        octi_location('\uf060'),
        octi_gist_private('\uf06a'),
        octi_mirror_private('\uf06a'),
        octi_git_fork_private('\uf06a'),
        octi_lock('\uf06a'),
        octi_logo_github('\uf092'),
        octi_mail('\uf03b'),
        octi_mail_read('\uf03c'),
        octi_mail_reply('\uf051'),
        octi_mark_github('\uf00a'),
        octi_markdown('\uf0c9'),
        octi_megaphone('\uf077'),
        octi_mention('\uf0be'),
        octi_milestone('\uf075'),
        octi_mirror_public('\uf024'),
        octi_mirror('\uf024'),
        octi_mortar_board('\uf0d7'),
        octi_mute('\uf080'),
        octi_no_newline('\uf09c'),
        octi_octoface('\uf008'),
        octi_organization('\uf037'),
        octi_package('\uf0c4'),
        octi_paintcan('\uf0d1'),
        octi_pencil('\uf058'),
        octi_person_add('\uf018'),
        octi_person_follow('\uf018'),
        octi_person('\uf018'),
        octi_pin('\uf041'),
        octi_plug('\uf0d4'),
        octi_repo_create('\uf05d'),
        octi_gist_new('\uf05d'),
        octi_file_directory_create('\uf05d'),
        octi_file_add('\uf05d'),
        octi_plus('\uf05d'),
        octi_primitive_dot('\uf052'),
        octi_primitive_square('\uf053'),
        octi_pulse('\uf085'),
        octi_question('\uf02c'),
        octi_quote('\uf063'),
        octi_radio_tower('\uf030'),
        octi_repo_delete('\uf001'),
        octi_repo('\uf001'),
        octi_repo_clone('\uf04c'),
        octi_repo_force_push('\uf04a'),
        octi_gist_fork('\uf002'),
        octi_repo_forked('\uf002'),
        octi_repo_pull('\uf006'),
        octi_repo_push('\uf005'),
        octi_rocket('\uf033'),
        octi_rss('\uf034'),
        octi_ruby('\uf047'),
        octi_search_save('\uf02e'),
        octi_search('\uf02e'),
        octi_server('\uf097'),
        octi_settings('\uf07c'),
        octi_shield('\uf0e1'),
        octi_log_in('\uf036'),
        octi_sign_in('\uf036'),
        octi_log_out('\uf032'),
        octi_sign_out('\uf032'),
        octi_squirrel('\uf0b2'),
        octi_star_add('\uf02a'),
        octi_star_delete('\uf02a'),
        octi_star('\uf02a'),
        octi_stop('\uf08f'),
        octi_repo_sync('\uf087'),
        octi_sync('\uf087'),
        octi_tag_remove('\uf015'),
        octi_tag_add('\uf015'),
        octi_tag('\uf015'),
        octi_tasklist('\uf0e5'),
        octi_telescope('\uf088'),
        octi_terminal('\uf0c8'),
        octi_text_size('\uf0e3'),
        octi_three_bars('\uf05e'),
        octi_thumbsdown('\uf0db'),
        octi_thumbsup('\uf0da'),
        octi_tools('\uf031'),
        octi_trashcan('\uf0d0'),
        octi_triangle_down('\uf05b'),
        octi_triangle_left('\uf044'),
        octi_triangle_right('\uf05a'),
        octi_triangle_up('\uf0aa'),
        octi_unfold('\uf039'),
        octi_unmute('\uf0ba'),
        octi_versions('\uf064'),
        octi_watch('\uf0e0'),
        octi_remove_close('\uf081'),
        octi_x('\uf081'),
        octi_zap('\u26A1');

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
                typeface = new Octicons();
            }
            return typeface;
        }
    }
}
