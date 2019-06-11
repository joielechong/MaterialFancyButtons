# Material Fancy Button

Fancy Button yang indah dikarenakan endorphins.

Ikon, Border, Radius ... untuk button Android. Dengan 21 Icon Fonts yang dapat dipilih yang sudah dikompilasi sebelumnya!

Tidak perlu secara manual menggunakan `&#xf087;` untuk karakter ikon font lagi!

<img src="/resources/cover.png" width="80%" alt="Android About Page Cover"/>

## Tinjauan
![MaterialFancyButtons](https://github.com/joielechong/MaterialFancyButtons/blob/master/resources/no-drawables.png)

### Aplikasi demo : [Download APK](https://github.com/joielechong/MaterialFancyButtons/blob/master/resources/fancybuttons_samples.apk)

## Fitur

* Border (stroke, radius, color)
    * Border radius atas kiri
    * Border radius atas kanan
    * Border radius bawah kiri
    * Border radius bawah kanan
* Background (normal, focus)
* Ikon (Drawable, Ikon font)
    * [Community Material](http://materialdesignicons.com/)
    * [Devicon](http://devicon.fr/)
    * [Dripicons](http://demo.amitjakhu.com/dripicons/)
    * [Entypo](http://www.entypo.com/)
    * [Fontawesome](http://fontawesome.io)
    * [Foundation Icons](http://zurb.com/playground/foundation-icon-fonts-3)
    * [Glyphicons Halflings](http://glyphicons.com/)
    * [Google Material Design Icons](https://github.com/google/material-design-icons)
    * [Ionicons](http://ionicons.com/)
    * [Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font)
    * [MFGLabs Iconset](https://github.com/MfgLabs/mfglabs-iconset)
    * [Meteocons](http://www.alessioatzeni.com/meteocons/)
    * [Mobirise Icons](https://mobiriseicons.com/)
    * [Octicons](https://github.com/github/octicons)
    * [Open Iconic](https://useiconic.com/)
    * [PICOL](http://picol.org/)
    * [Pixden7Stroke](http://themes-pixeden.com/font-demos/7-stroke/)
    * [Themify Icons](http://themify.me/themify-icons)
    * [Typeicons](http://typicons.com/)
    * [Vaadin Icons](https://github.com/vaadin/vaadin-icons/)
    * [Weather Icons](https://erikflowers.github.io/weather-icons/)
	* Custom font
* Ikon (Posisi, ukuran)
    * kanan
    * kiri
    * atas
    * bawah
* Ukuran ikon
* Padding ikon


### Pemasangan
Tambahkan Material Fancy Button:
```gradle
compile 'com.rilixtech:materialfancybuttons:1.8.8'
```

Tambahkan maven ke build.gradle:
```gradle
maven {
      url "http://dl.bintray.com/rilixtech/maven"
    }
```

Pilih ikon font yang kamu suka dari daftar font yang sudah dikompilasi, pilih dari daftar berikut:

```gradle
compile 'com.rilixtech:community-material-typeface:1.9.32.2'
compile 'com.rilixtech:devicon-typeface:2.0.0.3'
compile 'com.rilixtech:dripicons-typeface:2.0.0'
compile 'com.rilixtech:entypo-typeface:1.0.0.3'
compile 'com.rilixtech:fontawesome-typeface:4.7.0.4'
compile 'com.rilixtech:foundation-icons-typeface:3.0.0.3'
compile 'com.rilixtech:glyphicons-halflings-typeface:1.0.0'
compile 'com.rilixtech:google-material-typeface:3.0.1.1.original'
compile 'com.rilixtech:mfglabs-iconset-typeface:1.0'
compile 'com.rilixtech:material-design-iconic-typeface:2.2.0.3'
compile 'com.rilixtech:meteocons-typeface:1.1.0.3'
compile 'com.rilixtech:mobirise-icons-typeface:1.0.0'
compile 'com.rilixtech:ionicons-typeface:2.0.1.3'
compile 'com.rilixtech:octicons-typeface:3.2.0.3'
compile 'com.rilixtech:open-iconic-typeface:1.1.1'
compile 'com.rilixtech:picol-typeface:1.0.0'
compile 'com.rilixtech:pixeden-7-stroke-typeface:1.2.0.1'
compile 'com.rilixtech:themify-icons-typeface:0.1.2'
compile 'com.rilixtech:typicons-typeface:2.0.7.3'
compile 'com.rilixtech:vaadin-icons-typeface:4.1.0'
compile 'com.rilixtech:weather-icons-typeface:2.0.10.3'
```

**Daftar Ikon Font:**

Daftar berikut mengikuti format:
* Link font icon
  * "Prefix", Merupakan prefix dari tiap ikon font
  * `compile 'com.rilixtech:...'`, Ini merupakan dependensi yang perlu ditambahkan untuk menggunakan font.

 **Daftar Ikon:**

* [Community Material](http://materialdesignicons.com/)
  * "cmdi"
  * `compile 'com.rilixtech:community-material-typeface:1.9.32.2'`

* [Devicon](http://devicon.fr/)
  * "devi"
  * `compile 'com.rilixtech:devicon-typeface:2.0.0.3'`

* [Dripicons](http://demo.amitjakhu.com/dripicons/)
  * "drpi"
  * `compile 'com.rilixtech:dripicons-typeface:2.0.0'`

* [Entypo](http://www.entypo.com/)
  * "enti"
  * `compile 'com.rilixtech:entypo-typeface:1.0.0.3'`

* [Fontawesome](http://fontawesome.io)
  * "fawi"
  * `compile 'com.rilixtech:fontawesome-typeface:4.7.0.4'`

* [Foundation Icons](http://zurb.com/playground/foundation-icon-fonts-3)
  * "foui"
  * `compile 'com.rilixtech:foundation-icons-typeface:3.0.0.3'`

* [Glyphicons Halflings](http://glyphicons.com/)
  * "glyi"
  * `compile 'com.rilixtech:glyphicons-halflings-typeface:1.0.0'`

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

* [Mobirise Icons](https://mobiriseicons.com/)
  * "mbri"
  * `compile 'com.rilixtech:mobirise-icons-typeface:1.0.0'`

* [Octicons](https://github.com/github/octicons)
  * "octi"
  * `compile 'com.rilixtech:octicons-typeface:3.2.0.3'`

* [Open Iconic](https://useiconic.com/)
  * "opic"
  * `compile 'com.rilixtech:open-iconic-typeface:1.1.1'`

* [PICOL](http://picol.org/)
  * "pici"
  * `compile 'com.rilixtech:picol-typeface:1.0.0'`

* [Pixden7Stroke](http://themes-pixeden.com/font-demos/7-stroke/)
  * "pe7i"
  * `compile 'com.rilixtech:pixeden-7-stroke-typeface:1.2.0.1'`

* [Themify Icons](http://themify.me/themify-icons)
  * "thei"
  * `compile 'com.rilixtech:themify-icons-typeface:0.1.2'`

* [Typeicons](http://typicons.com/)
  * "typi"
  * `compile 'com.rilixtech:typicons-typeface:2.0.7.3'`

* [Vaadin Icons](https://github.com/vaadin/vaadin-icons/)
  * "vaai"
  * `compile 'com.rilixtech:vaadin-icons-typeface:4.1.0'`

* [Weather Icons](https://erikflowers.github.io/weather-icons/)
  * "wici"
  * `compile 'com.rilixtech:weather-icons-typeface:2.0.10.3'`

Lisensi dari setiap font sudah disertakan dalam class nya masing-masing atau juga dapat ditemukan di repositorinya.


### Contoh Penggunaan Dasar
1 - Tambahkan MaterialFancyButton ke dependencies:
```gradle
compile 'com.rilixtech:materialfancybuttons:1.8.7'
```

2 - Masukkan MaterialFancyButton namespace ke element root:

	xmlns:fancy="http://schemas.android.com/apk/res-auto"

3 - Tambahkan View MaterialFancyButton:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"/>

4 - Pilih ikon font yang kamu mau, contohnya FontAwesome. tambahkan di dependencies:
```gradle
compile 'com.rilixtech:fontawesome-typeface:4.7.0.4'
```
 Semua karakter ikon font akan berada dalam **string resource**.

5 - Tambahkan attribut untuk karakter font ikon yang kamu inginkan, contohnya ikon bintang. Nama ikon tersebut harus dalam format `prefix_nama_ikon`.
    Karena kita menggunakan FontAwesome, maka prefiks nya `fawi` dan karakter ikonnya `fawi_star`. Gunakan attribut `fancy:mfb_icon`:

    fancy:mfb_icon="@string/fawi_star"

 Sehingga menjadi:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    fancy:mfb_icon="@string/fawi_star"/>

**Ini merupakan cara yang direkomendasikan**, sehingga kamu tidak perlu mengkopi secara manual semua font yang kamu perlu dan mengingat semua karakter dari font, sehingga menghindari pekerjaan yang melelahkan dan rawan kesalahan.

### Font Kustom
Jika kamu ingin menggunakan Font kustom, ikuti langkah mudah berikut ini:

1 - Kopi dan salin font k dalam folder `assets/fonts/` untuk teks font ata ke dalam `assets/iconfonts/` untuk ikon font. Sebagai contoh : Fontawesome.

2 - Tambahkan attribut berikut:

 Untuk teks text:

    fancy:mfb_textFont="robotothin.ttf"
    fancy:mfb_text="your text"

 Sehingga menjadi seperti berikut ini:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	    android:id="@+id/btn_preview"
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    fancy:mfb_textFont="robotothin.ttf"
        fancy:mfb_text="your text"/>

 Untuk icon:

    fancy:mfb_iconFont="fontawesome.ttf"
    fancy:mfb_fontIconResource="&#xf087;"

 Sehingga menjadi seperti berikut ini:

	<com.rilixtech.materialfancybutton.MaterialFancyButton
	   android:id="@+id/btn_preview"
	   android:layout_width="wrap_content"
	   android:layout_height="wrap_content"
	   fancy:mfb_iconFont="fontawesome.ttf"
       fancy:mfb_fontIconResource="&#xf087;"/>

**Mohon dicatat** bahwa di saat menggunakan `fancy:mfb_icon` kamu tidak perlu menggunakan `fancy:mfb_iconFont` dan `fancy:mfb_fontIconResource`. Jika kedua attribut ini ada, maka attribut ini akan diabaikan.

####  Attribut yang Didukung

| Attribut XML        | Method Java         | Penjelasan  |
| ------------- |:-------------:| -----:|
| fancy:mfb_text      | setText(String)     | Teks dari button |
| fancy:mfb_textColor     | setTextColor(int)      |  Warna teks dari button |
| fancy:mfb_textSize | setTextSize(int)      |    Ukuran dari text |
| fancy:mfb_textFont | setCustomTextFont(String)      |    FontFamily dari teks|
| fancy:mfb_textGravity | setTextGravity(Int)      |    Gravity dari teks|
| fancy:mfb_icon | setIcon(String), setIcon(char) | Set ikon dari ikon font. Membutuhkan ikon font library (fontawesome_typeface, etc) untuk bekerja. Meniadakan efek dari fancy:mfb_fontIconResource dan fancy:mfb_iconFont |
| fancy:mfb_iconResource | setIconResource(Drawable)      |    Ikon Drawable dari button|
| fancy:mfb_iconPosition | setsetIconPosition(int)      |    Posisi dari ikon : Kiri, Kanan, Atas, Bawah|
| fancy:mfb_fontIconResource | setIconResource(String)      |    Ikon font dari button|
| fancy:mfb_fontIconSize | setFontIconSize(int)      |    Ukuran dari ikon |
| fancy:mfb_iconFont | setCustomIconFont(String)      |    FontFamily dari ikon|
| fancy:mfb_borderWidth | setBorderWidth(int)      |    Lebar dari border|
| fancy:mfb_borderColor | setBorderColor(int)      |    Color dari border|
| fancy:mfb_defaultColor | setBackgroundColor(int)      |    Background color dari button|
| fancy:mfb_focusColor | setFocusBackgroundColor(int)      |    Warna Fokus dari background button|
| fancy:mfb_disabledColor | setDisableBackgroundColor(int)      |    Warna Disabled dari background button|
| fancy:mfb_disabledTextColor | setDisableTextColor(int)      |    Warna Disabled dari teks button|
| fancy:mfb_disabledBorderColor | setDisableBorderColor(int)      |    Disabled Color dari border button|
| fancy:mfb_radius | setRadius(int)      |    Radius dari button|
| fancy:mfb_radiusTopLeft | setRadiusTopLeft(int)      |    Radius atas kiri dari button|
| fancy:mfb_radiusTopRight | setRadiusTopRight(int)      |    Radius kanan atas dari button|
| fancy:mfb_radiusBottomLeft | setRadiusBottomLeft(int)      |    Radius kiri bawah dari button|
| fancy:mfb_radiusBottomRight | setRadiusBottomRight(int)      |    Radius kanan bawah dari button|
| fancy:mfb_iconPaddingLeft | setIconPadding(int,int,int,int)      |    Padding Ikon|
| fancy:mfb_iconPaddingRight | setIconPadding(int,int,int,int)      |    Padding Ikon|
| fancy:mfb_iconPaddingTop | setIconPadding(int,int,int,int)      |    Padding Ikon|
| fancy:mfb_iconPaddingBottom | setIconPadding(int,int,int,int)      |    Padding Ikon|
| fancy:mfb_ghost | setGhost(boolean)      |    Ghost (Hollow)|

Untuk menyeting radius dari button, kamu dapat menggunakan `setRadius(int radiusTopLeft, int radiusTopRight, int radiusBottomLeft, int radiusBottomRight)`

Kamu juga dapat menggunakan prefiks bawaan (android:) yang membuat proses migrasi proyekmu lebih cepat.
Attribut Bawaan memiliki prioritas lebih tinggi dari attribut `fancy:`

#### Attribut Bawaan yang Didukung
| Attribut XML    |
| ------------- |
| android:enabled |
| android:text |
| android:textSize |
| android:textAllCaps |
| android:textStyle|

####  Getter yang didukung

| Method        | Deskripsi  |
| ------------- | -----:|
| getText() | Mengembalikan nilai Text dari button|
| getTextViewObject() | Mengembalikan Object TextView|
| getIconFontObject() | Mengembalikan ikon yang didefinisikan dengan `fb_fontIconResource`|
| getIconImageObject() | Mengembalikan ikon yang didefinisikan dengan `fb_iconResource` |

#### Sampel

**1 - Button Spotify**

![MaterialFancyButton Spotify](https://raw.github.com/joielechong/MaterialFancyButtons/master/resources/spotify-button.png)

	<com.rilixtech.materialfancybutton.MaterialFancyButton
		android:id="@+id/btn_spotify"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:paddingBottom="10dp"
		android:paddingLeft="20dp"
		android:paddingRight="20dp"
		android:paddingTop="10dp"
		android:textStyle="bold"
		fancy:mfb_borderColor="#FFFFFF"
		fancy:mfb_borderWidth="1dp"
		fancy:mfb_defaultColor="#7ab800"
		fancy:mfb_focusColor="#9bd823"
		fancy:mfb_iconFont="fontawesome.ttf"
		fancy:mfb_fontIconResource="&#xf04b;"
		fancy:mfb_iconPosition="left"
		fancy:mfb_radius="30dp"
		fancy:mfb_text="SHUFFLE PLAY"
		fancy:mfb_textColor="#FFFFFF" />

**2 - Button Facebook**

![MaterialFancyButton Facebook](https://raw.github.com/joielechong/MaterialFancyButtons/master/resources/facebook-button.png)

	MaterialFancyButton facebookLoginBtn = new MaterialFancyButton(this);
    facebookLoginBtn.setText("Login dengan Facebook");
    facebookLoginBtn.setBackgroundColor(Color.parseColor("#3b5998"));
    facebookLoginBtn.setFocusBackgroundColor(Color.parseColor("#5474b8"));
    facebookLoginBtn.setTextSize(17);
    facebookLoginBtn.setRadius(5);
    foursquareBtn.setIconFont("fontawesome.ttf");
    facebookLoginBtn.setIconResource("\uf082");
    facebookLoginBtn.setIconPosition(FancyButton.POSITION_LEFT);
    facebookLoginBtn.setFontIconSize(30);

Lihat [example project](https://github.com/joielechong/MaterialFancyButtons/tree/master/samples/src/main/java/com/rilixtech/materialfancybutton/sample) for more samples


- - - -

![MaterialFancyButtons Android](/resources/fancy.png)![MaterialFancyButtons Android](/resources/fancy2.png)![MaterialFancyButtons Android](/resources/fancy3.png)

### FAQ

**Bagaimana menambahkan font baru?**
Salin font ke dalam folder `assets/fonts/` untuk teks font atau ke dalam folder `assets/iconfonts/` untuk font ikon. Contohnya : entypo

## Kontribusi
MaterialFancyButtons membutuhkanmu untuk menambahkan fitur berikut:
* Dukungan button Circular
* Tambahkan elevasi (Material Design)

# Credits

- [El Mehdi Sakout](http://twitter.com/medyo80) pembuat [FancyButtons](https://github.com/medyo/fancybuttons) yang merupakan asal dari proyek ini.
- [mikepenz.com](http://mikepenz.com) pembuat [Android-Iconics](https://github.com/mikepenz/Android-Iconics/) yang merupakan dasar dari pembuatan ikon font proyek ini.

# Dikembangkan Oleh

 * [Joielechong](http://www.github.com/joielechong)


# Lisensi

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