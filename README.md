# Material Fancy Button

Beautiful Fancy Button on endorphins.

Icons, Borders, Radius ... for Android buttons


## IN PROGRESS
====================

<img src="/resources/cover.png" width="80%" alt="Android About Page Cover"/>

## Overview
![MaterialFancyButtons](https://github.com/joielechong/MaterialFancyButtons/blob/master/resources/no-drawables.png)

### Demo Application : [Download APK](https://github.com/joielechong/MaterialFancyButtons/blob/master/resources/fancybuttons_samples.apk)

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


### Installation
```gradle
compile 'com.rilixtech:materialfancybuttons:1.8.6'
```

Add maven to your build.gradle
```gradle
maven {
      url "http://dl.bintray.com/rilixtech/maven"
    }
```

## Additional, Choose your desired fonts
If you want to use a precompiled font, add the font that you want to use from below list:

```gradle
compile 'com.rilixtech:community-material-typeface:1.9.32.2'
compile 'com.rilixtech:devicon-typeface:2.0.0.3'
compile 'com.rilixtech:entypo-typeface:1.0.0.3'
compile 'com.rilixtech:fontawesome-typeface:4.7.0.4'
compile 'com.rilixtech:foundation-icons-typeface:3.0.0.3'
compile 'com.rilixtech:google-material-typeface:3.0.1.1.original'
compile 'com.rilixtech:mfglabs-iconset-typeface:1.0'
compile 'com.rilixtech:material-design-iconic-typeface:2.2.0.3'
compile 'com.rilixtech:meteocons-typeface:1.1.0.3'
compile 'com.rilixtech:ionicons-typeface:2.0.1.3'
compile 'com.rilixtech:octicons-typeface:3.2.0.3'
compile 'com.rilixtech:pixeden-7-stroke-typeface:1.2.0.1'



compile 'com.rilixtech:weather-icons-typeface:2.0.10.3@aar'
compile 'com.rilixtech:typeicons-typeface:2.0.7.3@aar'
```

### Usage

1 - Include MaterialFancyButton namespace to the root element:

	xmlns:fancy="http://schemas.android.com/apk/res-auto"

2 - Add the MaterialFancyButton View with custom params:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"/>

3 - Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : fontawesome
    Then add the following attribute:

 For text:

    fancy:fb_textFont="fontawesome.ttf"
    fancy:fb_text="your text"

so it will be look like this:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    fancy:fb_textFont="robotothin.ttf"
        fancy:fb_text="your text"/>

 For icon:

    fancy:fb_iconFont="fontawesome.ttf"
    fancy:fb_fontIconResource="&#xf087;"

so it will be look like this:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	   android:id="@+id/btn_preview"
	   android:layout_width="wrap_content"
	   android:layout_height="wrap_content"
	   fancy:fb_iconFont="fontawesome.ttf"
       fancy:fb_fontIconResource="&#xf087;"/>

If you use a precompiled font icon (like fontawesome) instead manual copying to asset folder with:
```gradle
compile 'com.rilixtech:fontawesome-typeface:4.7.0.1'
```
then you can use a more simpler way:

    fancy:fb_icon="fawi_star"

so it will be look like this:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    fancy:fb_icon="fawi_star"/>

This is the recommended way, so you don't need to manually copy the font and remembering all the characters of the font, which is very tedious and error prone.
Please be noted that when using fancy:fb_icon you don't need to use fancy:fb_iconFont and fancy:fb_fontIconResource. Iff both value is present, they will be override and ignored.

### Use Icon Font
The are already available fonts that you can use, you can select it from the list below. To use it, you need to add a string value to `fb_icon` attribute like this:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    fancy:fb_icon="fawi_star"/>

Here we use Font Awesome icon, because we use `fawi_star` as the value for `fancy:fb_icon`. `fawi` prefix is the prefix for Font Awesome.

The following list is within this format:
* Font Icon link
  * "Prefix", this is prefix for each icon in the font
  * `compile 'com.rilixtech:...'`, this is the dependency to use the icon font.

**Icon Font List:**

* [Community Material](http://materialdesignicons.com/)
  * "cmdi"
  * `compile 'com.rilixtech:community-material-typeface:1.9.32.2'`

* [Devicon](http://devicon.fr/)
  * "devi"
  * `compile 'com.rilixtech:devicon-typeface:2.0.0.3'`

* [Entypo](http://www.entypo.com/)
  * "enti"
  * `compile 'com.rilixtech:entypo-typeface:1.0.0.3'`

* [Fontawesome](http://fontawesome.io)
  * "fawi"
  * `compile 'com.rilixtech:fontawesome-typeface:4.7.0.4'`

* [Foundation Icons](http://zurb.com/playground/foundation-icon-fonts-3)
  * "foui"
  * `compile 'com.rilixtech:foundation-icons-typeface:3.0.0.3'`

* [Google Material Design Icons](https://github.com/google/material-design-icons)
  * "gmdi"
  * `compile 'com.rilixtech:google-material-typeface:3.0.1.1.original'`

* [Ionicons](http://ionicons.com/)
  * "ioni"
  * `compile 'com.rilixtech:ionicons-typeface:2.0.1.3'`

* [Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font)
  * "gmii"
  * **Google Material Iconic**
  * `compile 'com.rilixtech:material-design-iconic-typeface:2.2.0.3'`

* [MFGLabs Iconset](https://github.com/MfgLabs/mfglabs-iconset)
  * "mfgi"
  * `compile 'com.rilixtech:mfglabs-iconset-typeface:1.0'`

* [Meteocons](http://www.alessioatzeni.com/meteocons/)
  * "meti"
  * `compile 'com.rilixtech:meteocons-typeface:1.1.0.3'`

* [Octicons](https://github.com/github/octicons)
  * "octi"
  * `compile 'com.rilixtech:octicons-typeface:3.2.0.3'`

* [Pixden7Stroke](http://themes-pixeden.com/font-demos/7-stroke/)
  * "pe7i"
  * `compile 'com.rilixtech:pixeden-7-stroke-typeface:1.2.0.1'`




* [Weather Icons](https://erikflowers.github.io/weather-icons/)
  * "wici"
  * compile 'com.rilixtech:weather-icons-typeface:+@aar'
* [Typeicons](http://typicons.com/)
  * "typi"
  * compile 'com.rilixtech:typeicons-typeface:+@aar'


Licenses for all included fonts are linked inside the class or can be found on the coresponding repoistories.

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
| fancy:mfb_radius | setRadius(int)      |    Radius of the button|
| fancy:mfb_radiusTopLeft | setRadiusTopLeft(int)      |    Radius top left of the button|
| fancy:mfb_radiusTopRight | setRadiusTopRight(int)      |    Radius top right of the button|
| fancy:mfb_radiusBottomLeft | setRadiusBottomLeft(int)      |    Radius bottom left of the button|
| fancy:mfb_radiusBottomRight | setRadiusBottomRight(int)      |    Radius bottom right of the button|
| fancy:fb_iconPaddingLeft | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingRight | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingTop | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingBottom | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_ghost | setGhost(boolean)      |    Ghost (Hollow)|
| fancy:fb_useSystemFont | setUsingSystemFont(boolean) | If enabled, the button title will ignore its custom font and use the default system font |

For setting the radius of the button, you can also use `setRadius(int radiusTopLeft, int radiusTopRight, int radiusBottomLeft, int radiusBottomRight)`

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
| ------------- | -----:|
| getText() | Returns Text Value of the button|
| getTextViewObject() | Returns TextView Object|
| getIconFontObject() | Returns icon defined by fb_fontIconResource|
| getIconImageObject() | Returns icon defined by fb_iconResource |

#### Sample

**1 - Spotify Button**

![MaterialFancyButton Spotify](https://raw.github.com/joielechong/MaterialFancyButtons/master/resources/spotify-button.png)

	<com.rilixtech.materialfancybutton.MaterialFancyButton
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
		fancy:mfb_radius="30dp"
		fancy:fb_text="SHUFFLE PLAY"
		fancy:fb_textColor="#FFFFFF" />

**2 - Facebook Button**

![MaterialFancyButton Facebook](https://raw.github.com/joielechong/MaterialFancyButtons/master/resources/facebook-button.png)

	MaterialFancyButton facebookLoginBtn = new MaterialFancyButton(this);
    facebookLoginBtn.setText("Login with Facebook");
    facebookLoginBtn.setBackgroundColor(Color.parseColor("#3b5998"));
    facebookLoginBtn.setFocusBackgroundColor(Color.parseColor("#5474b8"));
    facebookLoginBtn.setTextSize(17);
    facebookLoginBtn.setRadius(5);
    foursquareBtn.setIconFont("fontawesome.ttf");
    facebookLoginBtn.setIconResource("\uf082");
    facebookLoginBtn.setIconPosition(FancyButton.POSITION_LEFT);
    facebookLoginBtn.setFontIconSize(30);

See the [example project](https://github.com/joielechong/MaterialFancyButtons/tree/master/samples/src/main/java/com/rilixtech/materialfancybutton/sample) for more samples


- - - -

![MaterialFancyButtons Android](/resources/fancy.png)![MaterialFancyButtons Android](/resources/fancy2.png)![MaterialFancyButtons Android](/resources/fancy3.png)

### FAQ

**How to add new fonts ?**
Just Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : entypo

## Contributions
MaterialFancyButtons needs you to build the missing features:
* Supporting Circular buttons
* Add elevation (Material Design)

# Credits

- [El Mehdi Sakout](http://twitter.com/medyo80) The creator of [FancyButtons](https://github.com/medyo/fancybuttons) which is the origin of this project.
- [mikepenz.com](http://mikepenz.com) He is the creator of [Android-Iconics](https://github.com/mikepenz/Android-Iconics/) which is the origin of the icon font project.

# Developed By

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