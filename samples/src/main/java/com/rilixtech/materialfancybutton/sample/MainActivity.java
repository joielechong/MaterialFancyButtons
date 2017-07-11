package com.rilixtech.materialfancybutton.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, getListItems()));
    getListView().setOnItemClickListener(this);
  }

  private String[] getListItems() {
    String[] listItems = {
        getString(R.string.title_activity_xml_buttons),
        getString(R.string.title_activity_program_buttons),
        getString(R.string.title_activity_community_material_buttons),
        getString(R.string.title_activity_devicon_buttons),
        getString(R.string.title_activity_entypo),
        getString(R.string.title_activity_fontawesome),
        getString(R.string.title_activity_foundation_icons),
        getString(R.string.title_activity_google_material),
        getString(R.string.title_activity_ionicons), getString(R.string.title_activity_mfglabs),
        getString(R.string.title_activity_material_design_iconic),
        getString(R.string.title_activity_meteocons),
        getString(R.string.title_activity_mobiriseicons),
        getString(R.string.title_activity_octicons),
        getString(R.string.title_activity_pixeden7),
        getString(R.string.title_activity_themify_icons),
        getString(R.string.title_activity_typicons),
        getString(R.string.title_activity_vaadin_icons),
        getString(R.string.title_activity_weather_icons),

    };
    return listItems;
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    switch (position) {
      case 0:
        Intent intentXML = new Intent(MainActivity.this, XmlButtons.class);
        startActivity(intentXML);

        break;
      case 1:
        Intent intentProg = new Intent(MainActivity.this, ProgramButtons.class);
        startActivity(intentProg);
        break;
      case 2:
        Intent intentCommunity =
            new Intent(MainActivity.this, CommunityMaterialButtonsActivity.class);
        startActivity(intentCommunity);
        break;
      case 3:
        Intent intentDevIcon = new Intent(MainActivity.this, DeviconButtonsActivity.class);
        startActivity(intentDevIcon);
        break;
      case 4:
        Intent intentEntypo = new Intent(MainActivity.this, EntypoButtonsActivity.class);
        startActivity(intentEntypo);
        break;
      case 5:
        Intent intentFontAwesome = new Intent(MainActivity.this, FontAwesomeActivity.class);
        startActivity(intentFontAwesome);
        break;
      case 6:
        Intent intentFoundationIcons =
            new Intent(MainActivity.this, FoundationIconsButtonsActivity.class);
        startActivity(intentFoundationIcons);
        break;
      case 7:
        Intent intentGoogleMaterial =
            new Intent(MainActivity.this, GoogleMaterialButtonsActivity.class);
        startActivity(intentGoogleMaterial);
        break;
      case 8:
        Intent intentIonics = new Intent(MainActivity.this, IoniconsButtonsActivity.class);
        startActivity(intentIonics);
        break;
      case 9:
        Intent intentMFGLabs = new Intent(MainActivity.this, MFGLabsIconsetButtonsActivity.class);
        startActivity(intentMFGLabs);
        break;
      case 10:
        Intent intentMaterialDesign = new Intent(MainActivity.this, MaterialDesignIconicButtonsActivity.class);
        startActivity(intentMaterialDesign);
        break;
      case 11:
        Intent intentMeteo = new Intent(MainActivity.this, MeteoconsButtonsActivity.class);
        startActivity(intentMeteo);
        break;
      case 12:
        Intent intentMobirise = new Intent(MainActivity.this, MobiriseIconsActivity.class);
        startActivity(intentMobirise);
        break;
      case 13:
        Intent intentOcticons = new Intent(MainActivity.this, OcticonsButtonsActivity.class);
        startActivity(intentOcticons);
        break;
      case 14:
        Intent intentPixeden = new Intent(MainActivity.this, Pixeden7StrokeActivity.class);
        startActivity(intentPixeden);
        break;
      case 15:
        Intent intentThemify = new Intent(MainActivity.this, ThemifyIconsActivity.class);
        startActivity(intentThemify);
        break;
      case 16:
        Intent intentTypicons = new Intent(MainActivity.this, TypiconsActivity.class);
        startActivity(intentTypicons);
        break;
      case 17:
        Intent intentVaadin = new Intent(MainActivity.this, VaadinIconsActivity.class);
        startActivity(intentVaadin);
        break;
      case 18:
        Intent intentWeatherIcons = new Intent(MainActivity.this, WeatherIconsActivity.class);
        startActivity(intentWeatherIcons);
        break;
      default:
        throw new IllegalArgumentException("Hold up, hold my phone :)");
    }
  }
}
