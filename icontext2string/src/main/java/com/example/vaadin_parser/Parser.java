package com.example.vaadin_parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by joielechong on 7/7/17.
 */

public class Parser {
  public static void main(String[] args) {
    File file = new File("vaadin-font-icons.json");
    File outputFile = new File("vaadin_output.txt");

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(outputFile);
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      String jsonString = "";
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        for (String line; (line = br.readLine()) != null; ) {
          jsonString += line;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<VaadinIcon>>() {}.getType();
        List<VaadinIcon> fromJson = gson.fromJson(jsonString, type);

        String name = "";
        String code = "";
        for (VaadinIcon vaadinIcon : fromJson) {
          //create with the format: vaai_icon_name('\uf002'),
          bw.write("vaai_");
          name = vaadinIcon.name.replace("-", "_");
          name = name.replace("\"", "");
          bw.write(name);
          bw.write("('\\u");
          code = vaadinIcon.code.replace("\"", "");
          bw.write(code);
          bw.write("'),");
          bw.newLine();
        }

        bw.close();
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
