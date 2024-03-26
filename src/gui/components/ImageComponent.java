package gui.components;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Extends ImageIcon to create an image icon from a file, with the ability to resize the image.
 * Throws IllegalArgumentException if the file is invalid.
 */
public class ImageComponent extends ImageIcon {

    /**
     * Constructs an ImageComponent by loading an image from the specified file path.
     *
     * @param filename Path to the image file.
     * @throws IllegalArgumentException If the file does not exist or cannot be read.
     */
    public ImageComponent(String filename) {
        super(validateFile(filename));
    }

    /**
     * Constructs an ImageComponent by loading an image from the specified file path
     * and resizing it to the given dimensions.
     *
     * @param filename Path to the image file.
     * @param width    Desired width of the image.
     * @param height   Desired height of the image.
     * @throws IllegalArgumentException If the file does not exist or cannot be read.
     */
    public ImageComponent(String filename, int width, int height) {
        super(new ImageIcon(validateFile(filename)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    /**
     * Validates the existence and readability of the specified file.
     *
     * @param filename Path to the file to validate.
     * @return The file path if validation succeeds.
     * @throws IllegalArgumentException If the file does not exist or cannot be read.
     */
    private static String validateFile(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("Invalid file: " + filename);
        }
        return filename;
    }
}
