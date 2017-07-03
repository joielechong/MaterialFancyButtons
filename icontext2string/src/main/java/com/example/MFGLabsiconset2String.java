import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by joielechong on 7/3/17.
 */

public class MFGLabsiconset2String {

//  .icon-cloud:before                { content: "\2601"; }
//.icon-at:before                   { content: "\0040"; }

  public static void main(String[] args) {
    File file = new File("mfglabs_iconset.css");
    File outputFile = new File("mfglabs_iconset_result.txt");

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(outputFile);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        for (String line; (line = br.readLine()) != null; ) {
          // process the line.

          //  .icon-cloud:before                { content: "\2601"; }
          // get only icon
          if(line.contains(".icon-")) {
            // then split by {
            String[] data = line.split("\\{");

            String iconName = data[0].trim();
            iconName = iconName.trim(); // remove space
            String[] iconNames = iconName.split(":");
            iconName = iconNames[0];
            iconName = iconName.replace(".", "");
            iconName = iconName.replace("-", "_");

            // Now we get the character part
            String iconChar = data[1].trim();
            iconChar = iconChar.replace("content:", "");
            iconChar = iconChar.trim();
            iconChar = iconChar.replace(";", "");
            iconChar = iconChar.trim();
            iconChar = iconChar.replace("}", "");
            iconChar = iconChar.trim();

            // now we have icon char as "\2601"
            // replace \ with \\u for unicode
            iconChar = iconChar.replace("\\", "\\u");
            // replace " with '
            iconChar = iconChar.replace("\"", "\'");

            // then save as:
            // mfgi_icon_cloud('\uF002'),

            bw.write("mfgi_");
            bw.write(iconName);
            bw.write("(");
            bw.write(iconChar);
            bw.write("),");
            bw.newLine();
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

  }
}
