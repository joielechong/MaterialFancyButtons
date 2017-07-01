import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IconText2String {
  public static void main(String[] args) {
    File file = new File("data.txt");
    File outputFile = new File("output.txt");

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(outputFile);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        for (String line; (line = br.readLine()) != null; ) {
          // process the line.

          // Split by comma
          String[] data = line.split("\\(");

          String iconName = data[0].trim();

          //String countryCode = data[0].replace("\"", "");
          //String countryNumber = data[1].replace(" \"", "");
          //countryNumber = countryNumber.replace("\"", "");
          //String countryName = data[2].replace(" \"", "\"");
          //countryName = countryName.replace("\"", "");

          //<string name="fawi_glass">fawi_glass</string>

          bw.write("<string name=\"");
          bw.write(iconName);
          bw.write("\">");
          bw.write(iconName);
          bw.write("</string>");
          bw.newLine();

        }
        bw.close();
        // line is not visible here.
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
