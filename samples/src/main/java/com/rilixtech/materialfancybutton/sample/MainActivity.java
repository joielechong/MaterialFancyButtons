package com.rilixtech.materialfancybutton.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

  private List<NameLayout> nameLayouts;

  private class NameLayout {
    String name;
    //Class clazz;
    int layoutId;

    NameLayout(String name, int layoutId) {
      this.name = name;
      //this.clazz = clazz;
      this.layoutId = layoutId;
    }
  }

  private List<NameLayout> getNameAndClasses() {
    List<NameLayout> list = new ArrayList<>();
    list.add(new NameLayout(getString(R.string.title_xml_buttons), R.layout.activity_xml_buttons));
    list.add(new NameLayout(getString(R.string.title_program_buttons), R.layout.activity_program_buttons));
    list.add(new NameLayout(getString(R.string.title_community_material_buttons), R.layout.activity_community_material_buttons));
    list.add(new NameLayout(getString(R.string.title_devicon_buttons), R.layout.activity_devicon_buttons));
    list.add(new NameLayout(getString(R.string.title_dripicons_buttons), R.layout.activity_dripicons_buttons));
    list.add(new NameLayout(getString(R.string.title_entypo), R.layout.activity_entypo_buttons));
    list.add(new NameLayout(getString(R.string.title_fontawesome), R.layout.activity_fontawesome_buttons));
    list.add(new NameLayout(getString(R.string.title_foundation_icons), R.layout.activity_foundation_icons_buttons));
    list.add(new NameLayout(getString(R.string.title_activity_glyphicons_halflings), R.layout.activity_glyphicons_halflings_buttons));
    list.add(new NameLayout(getString(R.string.title_google_material), R.layout.activity_google_material_buttons));
    list.add(new NameLayout(getString(R.string.title_ionicons), R.layout.activity_ionicons_buttons));
    list.add(new NameLayout(getString(R.string.title_mfglabs), R.layout.activity_mfglabs_iconset_buttons));
    list.add(new NameLayout(getString(R.string.title_material_design_iconic), R.layout.activity_material_design_iconic_buttons));
    list.add(new NameLayout(getString(R.string.title_meteocons), R.layout.activity_meteocons_buttons));
    list.add(new NameLayout(getString(R.string.title_mobiriseicons), R.layout.activity_mobirise_icons_buttons));
    list.add(new NameLayout(getString(R.string.title_octicons), R.layout.activity_octicons_buttons));
    list.add(new NameLayout(getString(R.string.title_openiconic), R.layout.activity_openiconic_buttons));
    list.add(new NameLayout(getString(R.string.title_picol), R.layout.activity_picol_icons_buttons));
    list.add(new NameLayout(getString(R.string.title_pixeden7), R.layout.activity_pixeden7stroke_buttons));
    list.add(new NameLayout(getString(R.string.title_themify_icons), R.layout.activity_themify_icons_buttons));
    list.add(new NameLayout(getString(R.string.title_typicons), R.layout.activity_typicons_buttons));
    list.add(new NameLayout(getString(R.string.title_vaadin_icons), R.layout.activity_vaadin_icons_buttons));
    list.add(new NameLayout(getString(R.string.title_weather_icons), R.layout.activity_weather_icons_buttons));

    return list;
  }

  private List<String> getNames(List<NameLayout> nameLayouts) {
    List<String> names = new ArrayList<>();
    for (NameLayout nameLayout : nameLayouts) {
      names.add(nameLayout.name);
    }
    return names;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    nameLayouts = getNameAndClasses();
    setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, getNames(nameLayouts)));
    getListView().setOnItemClickListener(this);
    TextView titleTv = (TextView) findViewById(R.id.title_tv);
    titleTv.setText(
        "MaterialFancyButtons example with " + (nameLayouts.size() - 2) + " icon fonts");
  }

  //@Override public boolean onCreateOptionsMenu(Menu menu) {
  //  // Inflate the menu; this adds items to the action bar if it is present.
  //  getMenuInflater().inflate(R.menu.main, menu);
  //  return true;
  //}
  //
  //@Override public boolean onOptionsItemSelected(MenuItem item) {
  //  // Handle action bar item clicks here. The action bar will
  //  // automatically handle clicks on the Home/Up button, so long
  //  // as you specify a parent activity in AndroidManifest.xml.
  //  int id = item.getItemId();
  //  if (id == R.id.action_settings) {
  //    return true;
  //  }
  //  return super.onOptionsItemSelected(item);
  //}

  @Override public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    //Intent intentActivity = new Intent(MainActivity.this, nameLayouts.get(position).clazz);
    //startActivity(intentActivity);

    if(nameLayouts.get(position).layoutId == R.layout.activity_program_buttons) {
      Intent intentActivity = new Intent(MainActivity.this, ProgramButtons.class);
      startActivity(intentActivity);
    } else {
      Intent buttonActivity = new Intent(MainActivity.this, IconButtonsActivity.class);
      buttonActivity.putExtra(IconButtonsActivity.LAYOUT_ID_EXTRA, nameLayouts.get(position).layoutId);
      buttonActivity.putExtra(IconButtonsActivity.TITLE_EXTRA, nameLayouts.get(position).name);
      startActivity(buttonActivity);
    }
  }
}
