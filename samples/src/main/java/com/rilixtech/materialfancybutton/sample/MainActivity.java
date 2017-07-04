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
        getString(R.string.title_activity_mfglabs),
        getString(R.string.title_activity_foundation_icons),
        getString(R.string.title_activity_google_material),
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
        Intent intentMFGLabs = new Intent(MainActivity.this, MFGLabsIconsetButtonsActivity.class);
        startActivity(intentMFGLabs);
        break;
      case 5:
        Intent intentFoundationIcons = new Intent(MainActivity.this, FoundationIconsButtonsActivity.class);
        startActivity(intentFoundationIcons);
        break;
      case 6:
        Intent intentGoogleMaterial = new Intent(MainActivity.this, GoogleMaterialButtonsActivity.class);
        startActivity(intentGoogleMaterial);
        break;
      default:
        throw new IllegalArgumentException("Hold up, hold my phone :)");
    }
  }
}
