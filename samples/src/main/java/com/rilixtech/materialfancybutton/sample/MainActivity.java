package com.rilixtech.materialfancybutton.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

  private List<NameClass> nameClasses;

  private class NameClass {
    String name;
    Class clazz;

    NameClass(String name, Class clazz) {
      this.name = name;
      this.clazz = clazz;
    }
  }

  private List<NameClass> getNameAndClasses() {
    List<NameClass> list = new ArrayList<>();
    list.add(new NameClass(getString(R.string.title_xml_buttons), XmlButtons.class));
    list.add(new NameClass(getString(R.string.title_program_buttons), ProgramButtons.class));
    list.add(new NameClass(getString(R.string.title_community_material_buttons), CommunityMaterialButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_devicon_buttons), DeviconButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_dripicons_buttons), DripiconsActivity.class));
    list.add(new NameClass(getString(R.string.title_entypo), EntypoButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_fontawesome), FontAwesomeActivity.class));
    list.add(new NameClass(getString(R.string.title_foundation_icons), FoundationIconsButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_activity_glyphicons_halflings), GlyphiconsHalflingsActivity.class));
    list.add(new NameClass(getString(R.string.title_google_material), GoogleMaterialButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_ionicons), IoniconsButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_mfglabs), MFGLabsIconsetButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_material_design_iconic), MaterialDesignIconicButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_meteocons), MeteoconsButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_mobiriseicons), MobiriseIconsActivity.class));
    list.add(new NameClass(getString(R.string.title_octicons), OcticonsButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_openiconic), OpenIconicButtonsActivity.class));
    list.add(new NameClass(getString(R.string.title_picol), PicolIconsActivity.class));
    list.add(new NameClass(getString(R.string.title_pixeden7), Pixeden7StrokeActivity.class));
    list.add(new NameClass(getString(R.string.title_themify_icons), ThemifyIconsActivity.class));
    list.add(new NameClass(getString(R.string.title_typicons), TypiconsActivity.class));
    list.add(new NameClass(getString(R.string.title_vaadin_icons), VaadinIconsActivity.class));
    list.add(new NameClass(getString(R.string.title_weather_icons), WeatherIconsActivity.class));

    return list;
  }

  private List<String> getNames(List<NameClass> nameClasses) {
    List<String> names = new ArrayList<>();
    for (NameClass nameClass : nameClasses) {
      names.add(nameClass.name);
    }
    return names;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    nameClasses = getNameAndClasses();
    setListAdapter(
        new ArrayAdapter(this, android.R.layout.simple_list_item_1, getNames(nameClasses)));
    getListView().setOnItemClickListener(this);
    TextView titleTv = (TextView) findViewById(R.id.title_tv);
    titleTv.setText(
        "MaterialFancyButtons example with " + (nameClasses.size() - 2) + " icon fonts");
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
    Intent intentActivity = new Intent(MainActivity.this, nameClasses.get(position).clazz);
    startActivity(intentActivity);
  }
}
