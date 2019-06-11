package com.rilixtech.materialfancybutton.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by joielechong on 10/15/17.
 */

public class IconButtonsActivity extends AppCompatActivity {

  public static final String LAYOUT_ID_EXTRA = "layoutIdExtra";
  public static final String TITLE_EXTRA = "titleExtra";
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int layoutId = getIntent().getIntExtra(LAYOUT_ID_EXTRA, 0);
    String title = getIntent().getStringExtra(TITLE_EXTRA);

    setContentView(layoutId);
    setTitle(title);
  }

}
