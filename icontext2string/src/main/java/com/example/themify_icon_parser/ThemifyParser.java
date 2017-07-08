package com.example.themify_icon_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by joielechong on 7/9/17.
 */

public class ThemifyParser {
  public static final String ICON_PREFIX = "thei";

  public static void main(String[] args) {
    File file = new File("themify-icons.css");
    File outputFile = new File("themify_icon_output.txt");

    System.out.println("Starting parsing Themify IconFonts");
    FileOutputStream fos;
    int totalIcon = 0;
    try {
      fos = new FileOutputStream(outputFile);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {

        boolean hasBeforeTag = false;
        String iconName = "";
        String iconValue;
        for (String line; (line = br.readLine()) != null; ) {
          // process the line.

          // All icon text is in this format:
          //.ti-wand:before {
          //  content: "\e600";
          //}

          // So we need to only read the line with :before
          // then read the next line as the icon.

          if(line.contains(":before")) {
            hasBeforeTag = true;
            String[] iconNameTexts = line.split(":");
            iconName = iconNameTexts[0];
            iconName = iconName.replace(".", "");
            iconName = iconName.replace("ti-", ICON_PREFIX + "_");
            iconName = iconName.replace("-", "_");
            // get the icon name.
          } else {
            // get the icon value.
            if(hasBeforeTag) {
              // we have iconName before, so now generate
              // icon value with the following format
              // thei_icon_name('\\ufxxx'),

              // But first, get the value from text:
              // content: "\e600";
              String[] iconValues = line.split(":");
              // we need the second part
              iconValue = iconValues[1];
              iconValue = iconValue.trim();
              // remove "
              iconValue = iconValue.replace("\"", "");
              // remove ;
              iconValue = iconValue.replace(";", "");
              iconValue = iconValue.replace("\\", "\\u");

              // now write it to file
              bw.write(iconName);
              bw.write("('");
              bw.write(iconValue);
              bw.write("'),");
              bw.newLine();
              totalIcon++;
              System.out.println("Write icon value: " + iconName);
            }

            hasBeforeTag = false;
          }

        }
        bw.close();
        // line is not visible here.
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("Total Icon = " + totalIcon);
    System.out.println("Finish.");
  }
}
