package com.example.picol_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by joielechong on 7/11/17.
 */

public class PicolParser {

  public static final String ICON_PREFIX = "pici";

  public static void main(String[] args) {
    File file = new File("picol-codes.css");
    File outputFile = new File("picol_icons_output.txt");

    System.out.println("Starting parsing Picol Icons font");
    FileOutputStream fos;
    int totalIcon = 0;
    try {
      fos = new FileOutputStream(outputFile);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {

        String iconName = "";
        String iconValue;
        for (String line; (line = br.readLine()) != null; ) {
          // process the line.

          // All icon text is in this format:
          //.picol_accept:before { content: '\e800'; } /* '' */

          if(line.isEmpty()) continue;

          String[] iconNameTexts = line.split(":before");
          iconName = iconNameTexts[0];
          iconName = iconName.replace(".", "");
          iconName = iconName.replace("-", "_");
          iconName = iconName.replace("picol", ICON_PREFIX);
          // get the icon name.

          System.out.println("iconName = " + iconName);

          // we need the second part
          iconValue = iconNameTexts[1];
          iconValue = iconValue.trim();
          String[] iconValues = iconValue.split("}");
          iconValue = iconValues[0];
          iconValue = iconValue.replace("{", "");
          iconValue = iconValue.replace("content:", "");

          // remove ;
          iconValue = iconValue.replace(";", "");
          iconValue = iconValue.replace("\\", "\\u");
          iconValue = iconValue.trim();

          // now write it to file
          bw.write(iconName);
          bw.write("(");
          bw.write(iconValue);
          bw.write("),");
          bw.newLine();
          totalIcon++;
          System.out.println("Write icon value: " + iconName);
        }
      }

      bw.close();

      System.out.println("Total Icon = "+totalIcon);
      System.out.println("Finish.");

      // line is not visible here.
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
