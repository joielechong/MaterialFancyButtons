# Material Fancy Button
Icons, Borders, Radius ... for Android buttons
[ ![jCenter](https://api.bintray.com/packages/medyo/maven/fancybuttons/images/download.svg) ](https://bintray.com/medyo/maven/fancybuttons/_latestVersion)  [![jitPack](https://jitpack.io/v/medyo/Fancybuttons.svg)](https://jitpack.io/#medyo/Fancybuttons)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FancyButtons-lightgrey.svg?style=flat)](http://android-arsenal.com/details/1/681)

<img src="/resources/cover.png" width="80%" alt="Android About Page Cover"/>

## Overview
![FancyButtons Android](https://raw.github.com/medyo/fancybuttons/master/resources/no-drawables.png)

### Demo Application : [Download APK](https://raw.github.com/medyo/fancybuttons/master/resources/fancybuttons_samples.apk)

## Features

* Border (stroke, radius, color)
* Background (normal, focus)
* Icon (Drawable, font icon)
	* FontAwesome
	* Custom font
* Icon (Position, size)
    * right
    * left
    * top
    * bottom
* Icon Size
* Icon Padding

**Already available fonts**
- [Google Material Design Icons](https://github.com/google/material-design-icons)
- [Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font)
- [Fontawesome](http://fontawesome.io)
- [Meteocons](http://www.alessioatzeni.com/meteocons/)
- [Octicons](https://github.com/github/octicons)
- [Community Material](http://materialdesignicons.com/)
- [Weather Icons](https://erikflowers.github.io/weather-icons/)
- [Typeicons](http://typicons.com/)
- [Entypo](http://www.entypo.com/)
- [Devicon](http://devicon.fr/)
- [Foundation Icons](http://zurb.com/playground/foundation-icon-fonts-3)
- [Ionicons](http://ionicons.com/)


### Installation
```gradle
compile 'com.github.medyo:fancybuttons:1.8.3'
```
## Additional, Choose your desired fonts
If you want to use a precompiled font, add the font that you want to use from below list:

```gradle
compile 'com.mikepenz:google-material-typeface:3.0.1.1.original@aar'
compile 'com.mikepenz:material-design-iconic-typeface:2.2.0.3@aar'
compile 'com.mikepenz:fontawesome-typeface:4.7.0.1@aar'
compile 'com.mikepenz:octicons-typeface:3.2.0.3@aar'
compile 'com.mikepenz:meteocons-typeface:1.1.0.3@aar'
compile 'com.mikepenz:community-material-typeface:1.9.32.2@aar'
compile 'com.mikepenz:weather-icons-typeface:2.0.10.3@aar'
compile 'com.mikepenz:typeicons-typeface:2.0.7.3@aar'
compile 'com.mikepenz:entypo-typeface:1.0.0.3@aar'
compile 'com.mikepenz:devicon-typeface:2.0.0.3@aar'
compile 'com.mikepenz:foundation-icons-typeface:3.0.0.3@aar'
compile 'com.mikepenz:ionicons-typeface:2.0.1.3@aar'
compile 'com.mikepenz:pixeden-7-stroke-typeface:1.2.0.1@aar'
```
### Usage

1 - Include MaterialFancyButton namespace to the root element:

	xmlns:fancy="http://schemas.android.com/apk/res-auto"

2 - Add the MaterialFancyButton View with custom params:

	<com.rilixtech.MaterialFancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"/>

3 - Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : fontawesome
    Then add the following attribute:

 For text:

    fancy:fb_textFont="fontawesome.ttf"
    fancy:fb_text="your text"

so it will be look like this:

	<com.rilixtech.MaterialFancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	fancy:fb_textFont="robotothin.ttf"
    fancy:fb_text="your text"/>

 For icon:

    fancy:fb_iconFont="fontawesome.ttf"
    fancy:fb_fontIconResource="&#xf087;"

so it will be look like this:

	<com.rilixtech.MaterialFancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	fancy:fb_iconFont="fontawesome.ttf"
    fancy:fb_fontIconResource="&#xf087;"/>

If you use a precompiled font icon (like fontawesome) instead manual copying to asset folder with:
```gradle
compile 'com.mikepenz:fontawesome-typeface:4.7.0.1@aar'
```
then you can use a more simpler way:

    fancy:fb_icon="faw_star"

so it will be look like this:

	<com.rilixtech.MaterialFancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	fancy:fb_icon="faw_star"/>

This is the recommended way, so you don't need to manually copy the font and remembering all the characters of the font, which is very tedious and error prone.
Please be noted that when using fancy:fb_icon you don't need to use fancy:fb_iconFont and fancy:fb_fontIconResource. Iff both value is present, they will be override and ignored.
####  Supported Attributes

| XML Attribute        | Java Attribute           | Description  |
| ------------- |:-------------:| -----:|
| fancy:fb_text      | setText(String)     | Text of the button |
| fancy:fb_textColor     | setTextColor(int)      |  Text Color of the button |
| fancy:fb_textSize | setTextSize(int)      |    Size of the text |
| fancy:fb_textFont | setCustomTextFont(String)      |    FontFamily of the text|
| fancy:fb_textGravity | setTextGravity(Int)      |    Gravity of the text|
| fancy:fb_icon | setIcon(String), setIcon(char) | Set icon from icon font list. Need the font library (fontawesome_typeface_library, etc) to works. This will override fancy:fb_fontIconResource and fancy:fb_iconFont |
| fancy:fb_iconResource | setIconResource(Drawable)      |    Drawable icon of the button|
| fancy:fb_iconPosition | setsetIconPosition(int)      |    Position of the icon : Left, Right, Top, Bottom|
| fancy:fb_fontIconResource | setIconResource(String)      |    font icon of the button|
| fancy:fb_fontIconSize | setFontIconSize(int)      |    Size of the icon |
| fancy:fb_iconFont | setCustomIconFont(String)      |    FontFamily of the icon|
| fancy:fb_borderWidth | setBorderWidth(int)      |    Width of the border|
| fancy:fb_borderColor | setBorderColor(int)      |    Color of the border|
| fancy:fb_defaultColor | setBackgroundColor(int)      |    Background color of the button|
| fancy:fb_focusColor | setFocusBackgroundColor(int)      |    Focus Color of button background|
| fancy:fb_disabledColor | setDisableBackgroundColor(int)      |    Disabled Color of button background|
| fancy:fb_disabledTextColor | setDisableTextColor(int)      |    Disabled Color of button text|
| fancy:fb_disabledBorderColor | setDisableBorderColor(int)      |    Disabled Color of button border|
| fancy:fb_radius | setRadius(int)      |    Radius of the button|
| fancy:fb_iconPaddingLeft | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingRight | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingTop | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingBottom | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_ghost | setGhost(boolean)      |    Ghost (Hollow)|
| fancy:fb_useSystemFont | setUsingSystemFont(boolean) | If enabled, the button title will ignore its custom font and use the default system font |

Also you can use Attributes with default prefix (android:) which makes migrating of your project more fast.
Default Attributes have more priority than Attributes with prefix fancy.

#### Supported default Attributes
| XML Attribute    |
| ------------- |
| android:enabled |
| android:text |
| android:textSize |
| android:textAllCaps |

####  Supported Getters

| Function        | Description  |
| ------------- |:-------------:| -----:|
| getText() | Returns Text Value of the button|
| getTextViewObject() | Returns TextView Object|
| getIconFontObject() | Returns icon defined by fb_fontIconResource|
| getIconImageObject() | Returns icon defined by fb_iconResource |

#### Sample

**1 - Spotify Button**

![FancyButton Spotify](https://raw.github.com/medyo/fancybuttons/master/resources/spotify-button.png)

	<com.rilixtech.MaterialFancyButton
		android:id="@+id/btn_spotify"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:paddingBottom="10dp"
		android:paddingLeft="20dp"
		android:paddingRight="20dp"
		android:paddingTop="10dp"
		fancy:fb_borderColor="#FFFFFF"
		fancy:fb_borderWidth="1dp"
		fancy:fb_defaultColor="#7ab800"
		fancy:fb_focusColor="#9bd823"
		fancy:fb_iconFont="fontawesome.ttf"
		fancy:fb_fontIconResource="&#xf04b;"
		fancy:fb_iconPosition="left"
		fancy:fb_radius="30dp"
		fancy:fb_text="SHUFFLE PLAY"
		fancy:fb_textColor="#FFFFFF" />

**2 - Facebook Button**

![FancyButton Facebook](https://raw.github.com/medyo/fancybuttons/master/resources/facebook-button.png)

	FancyButton facebookLoginBtn = new MaterialFancyButton(this);
    facebookLoginBtn.setText("Login with Facebook");
    facebookLoginBtn.setBackgroundColor(Color.parseColor("#3b5998"));
    facebookLoginBtn.setFocusBackgroundColor(Color.parseColor("#5474b8"));
    facebookLoginBtn.setTextSize(17);
    facebookLoginBtn.setRadius(5);
    foursquareBtn.setIconFont("fontawesome.ttf");
    facebookLoginBtn.setIconResource("\uf082");
    facebookLoginBtn.setIconPosition(FancyButton.POSITION_LEFT);
    facebookLoginBtn.setFontIconSize(30);

See the [example project](https://github.com/medyo/fancybuttons/tree/master/samples/src/main/java/mehdi/sakout/fancybuttons/samples) for more samples


- - - -

![FancyButtons Android](/resources/fancy.png)![FancyButtons Android](/resources/fancy2.png)![FancyButtons Android](/resources/fancy3.png)

### FAQ

**How to add new fonts ?**
Just Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : entypo

## Contributions
Fancybuttons needs you to build the missing features :
* Supporting Circular buttons
* Add elevation (Material Design)

# Credits

- [El Mehdi Sakout](http://twitter.com/medyo80) The creator of [FancyButtons](https://github.com/medyo/fancybuttons) which is the origin of this project.
- [mikepenz.com](http://mikepenz.com) He is the creator of [Android-Iconics](https://github.com/mikepenz/Android-Iconics/) which is the origin of the icon font project.

# Developed By

* Joielechong
 * [Joielechong](http://www.github.com/joielechong)


# License

    Copyright 2017 Joielechong

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.