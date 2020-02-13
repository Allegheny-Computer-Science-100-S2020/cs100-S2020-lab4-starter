package labfour;

// TODO: Add in the correct import for the ColorSpace and BufferedImage

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;

// TODO: Add in the import for File and FileOutputStream

import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

// TODO: Make sure to read the article referenced in the following comment

/** This class has methods that convert images to different types of display levels.
 * The first line displays the name of the programmer and the date. Then, the
 * program's main method reads in the source image, performs conversions, and writes
 * out the converted images. This program's main method produces diagnostic messages
 * that will display the progress of the image conversions.
 *
 * <p>Reference: http://codehustler.org/blog/java-to-create-grayscale-images-icons/
 *
 * <p>Bugs: This program has no known bugs.
 *
 * @author Gregory M. Kapfhammer
 */

public class ConvertGraphicImage {

  /**
   * Convert the provided BufferedImage to a greyscale version.
   *
   * @param sourceImage the source image that will be converted
   *
   **/
  public static void convertImageToGreyScale(BufferedImage sourceImage) throws IOException {
    BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    BufferedImage image = op.filter(sourceImage, null);
    File file = new File("images/source_converted_greyscale.png");
    FileOutputStream fos = new FileOutputStream(file);
    ImageIO.write(image, "png", fos);
    System.out.println(" Saved images/source_converted_greyscale.png");
  }

  /**
   * Convert the provided BufferedImage to a simplified, brighter and saturated RGB version.
   *
   * @param sourceImage the source image that will be converted
   *
   **/
  public static void convertImageToBrighten(BufferedImage sourceImage) throws IOException {
    BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB), null);
    // TODO: Follow the example in the convertImageToGreyScale for this conversion method
  }

  /**
   * Convert the provided BufferedImage to a simplified, darker and subdued RGB version.
   *
   * @param sourceImage the source image that will be converted
   *
   **/
  public static void convertImageToDarken(BufferedImage sourceImage) throws IOException {
    BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_CIEXYZ), null);
    // TODO: Follow the example in the convertImageToGreyScale for this conversion method
  }

  /**
   * The main entry point for ConvertGraphicImage.
   * The source code inside of this method will be executed when the program
   * is run in the command-line. The program reads in the graphic image and
   * then runs some conversion methods that will change the pixels in the
   * graphic image.
   *
   * @param args The command-line arguments
   *
   **/
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Gregory M. Kapfhammer " + new Date());

    // create the image and then perform the three conversions
    // TODO: Make sure to import the BufferedImage class at the top of the program
    // TODO: You need to determine the package of the BufferedImage class
    BufferedImage sourceImage = null;
    try {
      // call a method to convert the image to grey-scale
      sourceImage = ImageIO.read(new File("images/source.png"));
      System.out.println("Starting to convert to grey-scale ...");
      convertImageToGreyScale(sourceImage);
      System.out.println("... Finished converting to grey-scale!");
      // call a method to convert the image to one that is more saturated
      System.out.println("Starting to convert to brighter, saturated image ...");
      convertImageToBrighten(sourceImage);
      System.out.println("... Finished converting to brighter, saturated image!");
      // call a method to convert the image to one that is more subdued
      // TODO: Follow the two previous examples to call the convertImageToDarken method
    } catch (IOException imageException) {
      imageException.printStackTrace();
    }
  }

}

// TODO: Make sure that the program produces three output files:
// Here is an example of the original input graphic and then the
// three output graphics that are saved in the images directory.
// ├── images
// │ ├── source_converted_brighten.png
// │ ├── source_converted_darken.png
// │ ├── source_converted_greyscale.png
// │ └── source.png
