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
package com.rilixtech.devicon_typeface;

import android.content.Context;
import android.graphics.Typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class DevIcon implements ITypeface {
	private static final String TTF_FILE = "devicon-font-v2.0.0.1.ttf";
	private static final String MAPPING_FONT_PREFIX = "devi";

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

    @Override
    public String getMappingPrefix() {
        return MAPPING_FONT_PREFIX;
    }

    @Override
    public String getFontName() {
        return "DevIcon";
    }

    @Override
    public String getVersion() {
        return "2.0.0.1";
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
        return "Konpa";
    }

    @Override
    public String getUrl() {
        return "http://devicon.fr/";
    }

    @Override
    public String getDescription() {
        return "Devicon is a set of icons representing programming languages, designing & development tools. You can use it as a font or directly copy/paste the svg code into your project.";
    }

    @Override
    public String getLicense() {
        return "MIT License";
    }

    @Override
    public String getLicenseUrl() {
        return "https://github.com/konpa/devicon/blob/master/LICENSE";
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
        devi_ssh_plain_wordmark('\ue900'),
		devi_ssh_plain('\ue901'),
		devi_sourcetree_plain_wordmark('\ue902'),
		devi_sourcetree_plain('\ue903'),
		devi_phpstorm_plain_wordmark('\ue904'),
		devi_phpstorm_plain('\ue905'),
		devi_jeet_plain_wordmark('\ue906'),
		devi_jeet_plain('\ue907'),
		devi_gitlab_plain_wordmark('\ue908'),
		devi_gitlab_plain('\ue909'),
		devi_github_plain_wordmark('\ue90a'),
		devi_github_plain('\ue90b'),
		devi_d3js_plain('\ue90c'),
		devi_confluence_plain_wordmark('\ue90d'),
		devi_confluence_plain('\ue90e'),
		devi_bitbucket_plain_wordmark('\ue90f'),
		devi_bitbucket_plain('\ue910'),
		devi_safari_line_wordmark('\ue632'),
		devi_safari_line('\ue63a'),
		devi_safari_plain_wordmark('\ue63b'),
		devi_safari_plain('\ue63c'),
		devi_jetbrains_plain_wordmark('\ue63d'),
		devi_django_line_wordmark('\ue63e'),
		devi_django_plain_wordmark('\ue63f'),
		devi_gimp_plain('\ue633'),
		devi_redhat_plain_wordmark('\ue62a'),
		devi_redhat_plain('\ue62b'),
		devi_cplusplus_line_wordmark('\ue634'),
		devi_cplusplus_plain_wordmark('\ue635'),
		devi_csharp_line_wordmark('\ue636'),
		devi_csharp_plain_wordmark('\ue637'),
		devi_c_line_wordmark('\ue638'),
		devi_c_plain_wordmark('\ue639'),
		devi_nodewebkit_line_wordmark('\ue611'),
		devi_nodewebkit_line('\ue612'),
		devi_nodewebkit_plain_wordmark('\ue613'),
		devi_nodewebkit_plain('\ue614'),
		devi_nginx_plain_wordmark('\ue615'),
		devi_erlang_plain_wordmark('\ue616'),
		devi_erlang_plain('\ue617'),
		devi_doctrine_line_wordmark('\ue618'),
		devi_doctrine_line('\ue619'),
		devi_doctrine_plain_wordmark('\ue61a'),
		devi_doctrine_plain('\ue625'),
		devi_apache_line_wordmark('\ue626'),
		devi_apache_line('\ue627'),
		devi_apache_plain_wordmark('\ue628'),
		devi_apache_plain('\ue629'),
		devi_go_line('\ue610'),
		devi_redis_plain_wordmark('\ue606'),
		devi_redis_plain('\ue607'),
		devi_meteor_plain_wordmark('\ue608'),
		devi_meteor_plain('\ue609'),
		devi_heroku_original_wordmark('\ue60a'),
		devi_heroku_original('\ue60b'),
		devi_heroku_plain_wordmark('\ue60c'),
		devi_heroku_plain('\ue60f'),
		devi_go_plain('\ue61b'),
		devi_docker_plain_wordmark('\ue61e'),
		devi_docker_plain('\ue61f'),
		devi_amazonwebservices_plain('\ue603'),
		devi_amazonwebservices_plain_wordmark('\ue604'),
		devi_android_plain_wordmark('\ue60d'),
		devi_android_plain('\ue60e'),
		devi_angularjs_plain_wordmark('\ue61c'),
		devi_angularjs_plain('\ue61d'),
		devi_appcelerator_plain('\ue620'),
		devi_appcelerator_plain_wordmark('\ue621'),
		devi_apple_plain('\ue622'),
		devi_atom_plain_wordmark('\ue623'),
		devi_atom_plain('\ue624'),
		devi_backbonejs_plain_wordmark('\ue62c'),
		devi_backbonejs_plain('\ue62d'),
		devi_bootstrap_plain_wordmark('\ue62e'),
		devi_bootstrap_plain('\ue62f'),
		devi_bower_line_wordmark('\ue630'),
		devi_bower_line('\ue631'),
		devi_bower_plain_wordmark('\ue64e'),
		devi_bower_plain('\ue64f'),
		devi_chrome_plain_wordmark('\ue665'),
		devi_chrome_plain('\ue666'),
		devi_codeigniter_plain_wordmark('\ue667'),
		devi_codeigniter_plain('\ue668'),
		devi_coffeescript_plain_wordmark('\ue669'),
		devi_coffeescript_plain('\ue66a'),
		devi_css3_plain_wordmark('\ue678'),
		devi_css3_plain('\ue679'),
		devi_debian_plain_wordmark('\ue67e'),
		devi_debian_plain('\ue67f'),
		devi_dot_net_plain_wordmark('\ue6d3'),
		devi_dot_net_plain('\ue6d4'),
		devi_drupal_plain_wordmark('\ue6e2'),
		devi_drupal_plain('\ue6e3'),
		devi_firefox_plain_wordmark('\ue75d'),
		devi_firefox_plain('\ue75e'),
		devi_foundation_plain_wordmark('\ue7a2'),
		devi_foundation_plain('\ue7a3'),
		devi_git_plain_wordmark('\ue7a7'),
		devi_git_plain('\ue7a8'),
		devi_grunt_line_wordmark('\ue7a9'),
		devi_grunt_line('\ue7aa'),
		devi_grunt_plain_wordmark('\ue7ea'),
		devi_grunt_plain('\ue7eb'),
		devi_gulp_plain('\ue7ec'),
		devi_html5_plain_wordmark('\ue7f6'),
		devi_html5_plain('\ue7f7'),
		devi_ie10_plain('\ue7f8'),
		devi_illustrator_line('\ue7f9'),
		devi_illustrator_plain('\ue7fa'),
		devi_inkscape_plain_wordmark('\ue834'),
		devi_inkscape_plain('\ue835'),
		devi_java_plain_wordmark('\ue841'),
		devi_java_plain('\ue842'),
		devi_javascript_plain('\ue845'),
		devi_jquery_plain_wordmark('\ue849'),
		devi_jquery_plain('\ue84a'),
		devi_krakenjs_plain_wordmark('\ue84f'),
		devi_krakenjs_plain('\ue850'),
		devi_laravel_plain_wordmark('\ue851'),
		devi_laravel_plain('\ue852'),
		devi_less_plain_wordmark('\ue853'),
		devi_linux_plain('\ueb1c'),
		devi_mongodb_plain_wordmark('\ueb43'),
		devi_mongodb_plain('\ueb44'),
		devi_moodle_plain_wordmark('\ueb5a'),
		devi_moodle_plain('\ueb5b'),
		devi_mysql_plain_wordmark('\ueb60'),
		devi_mysql_plain('\ueb61'),
		devi_nodejs_plain_wordmark('\ueb69'),
		devi_nodejs_plain('\ueb6a'),
		devi_oracle_plain('\ueb6b'),
		devi_photoshop_line('\ueb6c'),
		devi_photoshop_plain('\ueb6d'),
		devi_php_plain('\ueb71'),
		devi_postgresql_plain_wordmark('\ueb7c'),
		devi_postgresql_plain('\ueb7d'),
		devi_python_plain_wordmark('\ueb88'),
		devi_python_plain('\ueb89'),
		devi_rails_plain_wordmark('\ueba2'),
		devi_rails_plain('\ueba3'),
		devi_react_plain_wordmark('\ue600'),
		devi_react_plain('\ue601'),
		devi_ruby_plain_wordmark('\uebc9'),
		devi_ruby_plain('\uebca'),
		devi_sass_plain('\uebcb'),
		devi_symfony_plain_wordmark('\ue602'),
		devi_symfony_plain('\ue605'),
		devi_travis_plain_wordmark('\uebcc'),
		devi_travis_plain('\uebcd'),
		devi_trello_plain_wordmark('\uebce'),
		devi_trello_plain('\uebcf'),
		devi_ubuntu_plain_wordmark('\uebd0'),
		devi_ubuntu_plain('\uebd1'),
		devi_vim_plain('\uebf3'),
		devi_windows8_plain_wordmark('\uebf4'),
		devi_windows8_plain('\uebf5'),
		devi_wordpress_plain_wordmark('\uebfd'),
		devi_wordpress_plain('\uebfe'),
		devi_yii_plain_wordmark('\uec01'),
		devi_yii_plain('\uec02'),
		devi_zend_plain_wordmark('\uec03'),
		devi_zend_plain('\uec04');

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
                typeface = new DevIcon();
            }
            return typeface;
        }
    }
}
