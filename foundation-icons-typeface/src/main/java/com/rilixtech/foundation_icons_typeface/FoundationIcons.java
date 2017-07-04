package com.rilixtech.foundation_icons_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class FoundationIcons implements ITypeface {
	private static final String TTF_FILE = "foundation-icons-font-v3.0.0.1.ttf";
	private static final String MAPPING_FONT_PREFIX = "foui";

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
		return "Foundation Icons";
	}

	@Override public String getVersion() {
		return "3.0.0.1";
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
		return "ZURB Inc.";
	}

	@Override public String getUrl() {
		return "http://zurb.com/playground/foundation-icon-fonts-3";
	}

	@Override public String getDescription() {
		return "Customize your icons to be any size, color, style in CSS";
	}

	@Override public String getLicense() {
		return "MIT Open Source License";
	}

	@Override public String getLicenseUrl() {
		return "https://github.com/zurb/foundation-icons/blob/master/MIT-LICENSE.txt";
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
		foui_address_book('\uf100'),
		foui_alert('\uf101'),
		foui_align_center('\uf102'),
		foui_align_justify('\uf103'),
		foui_align_left('\uf104'),
		foui_align_right('\uf105'),
		foui_anchor('\uf106'),
		foui_annotate('\uf107'),
		foui_archive('\uf108'),
		foui_arrow_down('\uf109'),
		foui_arrow_left('\uf10a'),
		foui_arrow_right('\uf10b'),
		foui_arrow_up('\uf10c'),
		foui_arrows_compress('\uf10d'),
		foui_arrows_expand('\uf10e'),
		foui_arrows_in('\uf10f'),
		foui_arrows_out('\uf110'),
		foui_asl('\uf111'),
		foui_asterisk('\uf112'),
		foui_at_sign('\uf113'),
		foui_background_color('\uf114'),
		foui_battery_empty('\uf115'),
		foui_battery_full('\uf116'),
		foui_battery_half('\uf117'),
		foui_bitcoin_circle('\uf118'),
		foui_bitcoin('\uf119'),
		foui_blind('\uf11a'),
		foui_bluetooth('\uf11b'),
		foui_bold('\uf11c'),
		foui_book_bookmark('\uf11d'),
		foui_book('\uf11e'),
		foui_bookmark('\uf11f'),
		foui_braille('\uf120'),
		foui_burst_new('\uf121'),
		foui_burst_sale('\uf122'),
		foui_burst('\uf123'),
		foui_calendar('\uf124'),
		foui_camera('\uf125'),
		foui_check('\uf126'),
		foui_checkbox('\uf127'),
		foui_clipboard_notes('\uf128'),
		foui_clipboard_pencil('\uf129'),
		foui_clipboard('\uf12a'),
		foui_clock('\uf12b'),
		foui_closed_caption('\uf12c'),
		foui_cloud('\uf12d'),
		foui_commenti_minus('\uf12e'),
		foui_commenti_quotes('\uf12f'),
		foui_commenti_video('\uf130'),
		foui_comment('\uf131'),
		foui_comments('\uf132'),
		foui_compass('\uf133'),
		foui_contrast('\uf134'),
		foui_credit_card('\uf135'),
		foui_crop('\uf136'),
		foui_crown('\uf137'),
		foui_css3('\uf138'),
		foui_database('\uf139'),
		foui_die_five('\uf13a'),
		foui_die_four('\uf13b'),
		foui_die_one('\uf13c'),
		foui_die_six('\uf13d'),
		foui_die_three('\uf13e'),
		foui_die_two('\uf13f'),
		foui_dislike('\uf140'),
		foui_dollar_bill('\uf141'),
		foui_dollar('\uf142'),
		foui_download('\uf143'),
		foui_eject('\uf144'),
		foui_elevator('\uf145'),
		foui_euro('\uf146'),
		foui_eye('\uf147'),
		foui_fast_forward('\uf148'),
		foui_female_symbol('\uf149'),
		foui_female('\uf14a'),
		foui_filter('\uf14b'),
		foui_first_aid('\uf14c'),
		foui_flag('\uf14d'),
		foui_folder_add('\uf14e'),
		foui_folder_lock('\uf14f'),
		foui_folder('\uf150'),
		foui_foot('\uf151'),
		foui_foundation('\uf152'),
		foui_graph_bar('\uf153'),
		foui_graph_horizontal('\uf154'),
		foui_graph_pie('\uf155'),
		foui_graph_trend('\uf156'),
		foui_guide_dog('\uf157'),
		foui_hearing_aid('\uf158'),
		foui_heart('\uf159'),
		foui_home('\uf15a'),
		foui_html5('\uf15b'),
		foui_indenti_less('\uf15c'),
		foui_indenti_more('\uf15d'),
		foui_info('\uf15e'),
		foui_italic('\uf15f'),
		foui_key('\uf160'),
		foui_laptop('\uf161'),
		foui_layout('\uf162'),
		foui_lightbulb('\uf163'),
		foui_like('\uf164'),
		foui_link('\uf165'),
		foui_list_bullet('\uf166'),
		foui_list_number('\uf167'),
		foui_list_thumbnails('\uf168'),
		foui_list('\uf169'),
		foui_lock('\uf16a'),
		foui_loop('\uf16b'),
		foui_magnifying_glass('\uf16c'),
		foui_mail('\uf16d'),
		foui_male_female('\uf16e'),
		foui_male_symbol('\uf16f'),
		foui_male('\uf170'),
		foui_map('\uf171'),
		foui_marker('\uf172'),
		foui_megaphone('\uf173'),
		foui_microphone('\uf174'),
		foui_minus_circle('\uf175'),
		foui_minus('\uf176'),
		foui_mobile_signal('\uf177'),
		foui_mobile('\uf178'),
		foui_monitor('\uf179'),
		foui_mountains('\uf17a'),
		foui_music('\uf17b'),
		foui_next('\uf17c'),
		foui_no_dogs('\uf17d'),
		foui_no_smoking('\uf17e'),
		foui_page_add('\uf17f'),
		foui_page_copy('\uf180'),
		foui_page_csv('\uf181'),
		foui_page_delete('\uf182'),
		foui_page_doc('\uf183'),
		foui_page_edit('\uf184'),
		foui_page_export_csv('\uf185'),
		foui_page_export_doc('\uf186'),
		foui_page_export_pdf('\uf187'),
		foui_page_export('\uf188'),
		foui_page_filled('\uf189'),
		foui_page_multiple('\uf18a'),
		foui_page_pdf('\uf18b'),
		foui_page_remove('\uf18c'),
		foui_page_search('\uf18d'),
		foui_page('\uf18e'),
		foui_paint_bucket('\uf18f'),
		foui_paperclip('\uf190'),
		foui_pause('\uf191'),
		foui_paw('\uf192'),
		foui_paypal('\uf193'),
		foui_pencil('\uf194'),
		foui_photo('\uf195'),
		foui_play_circle('\uf196'),
		foui_play_video('\uf197'),
		foui_play('\uf198'),
		foui_plus('\uf199'),
		foui_pound('\uf19a'),
		foui_power('\uf19b'),
		foui_previous('\uf19c'),
		foui_price_tag('\uf19d'),
		foui_pricetag_multiple('\uf19e'),
		foui_print('\uf19f'),
		foui_prohibited('\uf1a0'),
		foui_projection_screen('\uf1a1'),
		foui_puzzle('\uf1a2'),
		foui_quote('\uf1a3'),
		foui_record('\uf1a4'),
		foui_refresh('\uf1a5'),
		foui_results_demographics('\uf1a6'),
		foui_results('\uf1a7'),
		foui_rewind_ten('\uf1a8'),
		foui_rewind('\uf1a9'),
		foui_rss('\uf1aa'),
		foui_safety_cone('\uf1ab'),
		foui_save('\uf1ac'),
		foui_share('\uf1ad'),
		foui_sheriff_badge('\uf1ae'),
		foui_shield('\uf1af'),
		foui_shopping_bag('\uf1b0'),
		foui_shopping_cart('\uf1b1'),
		foui_shuffle('\uf1b2'),
		foui_skull('\uf1b3'),
		foui_social_500px('\uf1b4'),
		foui_social_adobe('\uf1b5'),
		foui_social_amazon('\uf1b6'),
		foui_social_android('\uf1b7'),
		foui_social_apple('\uf1b8'),
		foui_social_behance('\uf1b9'),
		foui_social_bing('\uf1ba'),
		foui_social_blogger('\uf1bb'),
		foui_social_delicious('\uf1bc'),
		foui_social_designer_news('\uf1bd'),
		foui_social_deviant_art('\uf1be'),
		foui_social_digg('\uf1bf'),
		foui_social_dribbble('\uf1c0'),
		foui_social_drive('\uf1c1'),
		foui_social_dropbox('\uf1c2'),
		foui_social_evernote('\uf1c3'),
		foui_social_facebook('\uf1c4'),
		foui_social_flickr('\uf1c5'),
		foui_social_forrst('\uf1c6'),
		foui_social_foursquare('\uf1c7'),
		foui_social_game_center('\uf1c8'),
		foui_social_github('\uf1c9'),
		foui_social_google_plus('\uf1ca'),
		foui_social_hacker_news('\uf1cb'),
		foui_social_hi5('\uf1cc'),
		foui_social_instagram('\uf1cd'),
		foui_social_joomla('\uf1ce'),
		foui_social_lastfm('\uf1cf'),
		foui_social_linkedin('\uf1d0'),
		foui_social_medium('\uf1d1'),
		foui_social_myspace('\uf1d2'),
		foui_social_orkut('\uf1d3'),
		foui_social_path('\uf1d4'),
		foui_social_picasa('\uf1d5'),
		foui_social_pinterest('\uf1d6'),
		foui_social_rdio('\uf1d7'),
		foui_social_reddit('\uf1d8'),
		foui_social_skillshare('\uf1d9'),
		foui_social_skype('\uf1da'),
		foui_social_smashing_mag('\uf1db'),
		foui_social_snapchat('\uf1dc'),
		foui_social_spotify('\uf1dd'),
		foui_social_squidoo('\uf1de'),
		foui_social_stack_overflow('\uf1df'),
		foui_social_steam('\uf1e0'),
		foui_social_stumbleupon('\uf1e1'),
		foui_social_treehouse('\uf1e2'),
		foui_social_tumblr('\uf1e3'),
		foui_social_twitter('\uf1e4'),
		foui_social_vimeo('\uf1e5'),
		foui_social_windows('\uf1e6'),
		foui_social_xbox('\uf1e7'),
		foui_social_yahoo('\uf1e8'),
		foui_social_yelp('\uf1e9'),
		foui_social_youtube('\uf1ea'),
		foui_social_zerply('\uf1eb'),
		foui_social_zurb('\uf1ec'),
		foui_sound('\uf1ed'),
		foui_star('\uf1ee'),
		foui_stop('\uf1ef'),
		foui_strikethrough('\uf1f0'),
		foui_subscript('\uf1f1'),
		foui_superscript('\uf1f2'),
		foui_tablet_landscape('\uf1f3'),
		foui_tablet_portrait('\uf1f4'),
		foui_target_two('\uf1f5'),
		foui_target('\uf1f6'),
		foui_telephone_accessible('\uf1f7'),
		foui_telephone('\uf1f8'),
		foui_text_color('\uf1f9'),
		foui_thumbnails('\uf1fa'),
		foui_ticket('\uf1fb'),
		foui_torso_business('\uf1fc'),
		foui_torso_female('\uf1fd'),
		foui_torso('\uf1fe'),
		foui_torsos_all_female('\uf1ff'),
		foui_torsos_all('\uf200'),
		foui_torsos_female_male('\uf201'),
		foui_torsos_male_female('\uf202'),
		foui_torsos('\uf203'),
		foui_trash('\uf204'),
		foui_trees('\uf205'),
		foui_trophy('\uf206'),
		foui_underline('\uf207'),
		foui_universal_access('\uf208'),
		foui_unlink('\uf209'),
		foui_unlock('\uf20a'),
		foui_upload_cloud('\uf20b'),
		foui_upload('\uf20c'),
		foui_usb('\uf20d'),
		foui_video('\uf20e'),
		foui_volume_none('\uf20f'),
		foui_volume_strike('\uf210'),
		foui_volume('\uf211'),
		foui_web('\uf212'),
		foui_wheelchair('\uf213'),
		foui_widget('\uf214'),
		foui_wrench('\uf215'),
		foui_x_circle('\uf216'),
		foui_x('\uf217'),
		foui_yen('\uf218'),
		foui_zoom_in('\uf219'),
		foui_zoom_out('\uf21a');

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
                typeface = new FoundationIcons();
            }
            return typeface;
        }
    }
}
