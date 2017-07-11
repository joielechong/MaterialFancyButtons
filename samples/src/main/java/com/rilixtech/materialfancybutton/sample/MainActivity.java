package com.rilixtech.materialfancybutton.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

  public static final String TAG = MainActivity.class.getSimpleName();
  public static final String PACKAGE_NAME = MainActivity.class.getPackage().getName();

  private List<NameClass> nameClasses;

  class NameClass {
    String name;
    String clazz;

    NameClass(String name, String clazz) {
      this.name = name;
      this.clazz = clazz;
    }
  }

  private List<NameClass> getNameAndClasses() {
    List<NameClass> lists = new ArrayList<>();
    lists.add(new NameClass(getString(R.string.title_activity_xml_buttons),
        XmlButtons.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_program_buttons),
        ProgramButtons.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_community_material_buttons),
        CommunityMaterialButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_devicon_buttons),
        DeviconButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_dripicons_buttons),
        DripiconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_entypo),
        EntypoButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_fontawesome),
        FontAwesomeActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_foundation_icons),
        FoundationIconsButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_google_material),
        GoogleMaterialButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_ionicons),
        IoniconsButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_mfglabs),
        MFGLabsIconsetButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_material_design_iconic),
        MaterialDesignIconicButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_meteocons),
        MeteoconsButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_mobiriseicons),
        MobiriseIconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_octicons),
        OcticonsButtonsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_picol),
        PicolIconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_pixeden7),
        Pixeden7StrokeActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_themify_icons),
        ThemifyIconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_typicons),
        TypiconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_vaadin_icons),
        VaadinIconsActivity.class.getSimpleName()));
    lists.add(new NameClass(getString(R.string.title_activity_weather_icons),
        WeatherIconsActivity.class.getSimpleName()));

    return lists;
  }

  private List<String> getNames(List<NameClass> nameClasses) {
    List<String> names = new ArrayList<>();
    for(NameClass nameClass: nameClasses) {
      names.add(nameClass.name);
    }
    return names;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    nameClasses = getNameAndClasses();
    setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, getNames(nameClasses)));
    getListView().setOnItemClickListener(this);
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
    try {
      Intent intentActivity = new Intent(MainActivity.this, Class.forName(PACKAGE_NAME + "." + nameClasses.get(position).clazz));
      Log.d(TAG, "PACKAGE_NAME = " + PACKAGE_NAME);
      startActivity(intentActivity);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
