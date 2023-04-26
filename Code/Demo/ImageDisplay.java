import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Author: Dr. Becnel
 * CSCI 3302 Seciton 001
 * 
 * Date: 1/15/2023
 * This class does a simple image display where keyboard
 * inputs are used to maninpulate the images in various ways.
 * 
 * For example, rotate the image 90 degree, filter the image using masks,
 * invert the colors, grays scale, etc.
 * 
 */
public class ImageDisplay extends JFrame  {

    // current image is the image current displayed
    private BufferedImage currentImage;
    // componenet (label) holding the image on the JFrame
    private JLabel imageHolder;
    // images that can be displayed
    private static final String[] IMAGES = new String[] { "buzz.png", "billy.png", "gru.png" };
    // index of current image being display
    private int currentImageIndex = 0;

    public static void main(String avg[]) throws IOException {
        ImageDisplay imageDisplay = new ImageDisplay();
    }

    /*****************************************************
     * This construct sets up and create the Image Display
     * with the first image.
     * 
     * @throws IOException - file not found
     *                     Post: an image is shown on the display
     */
    public ImageDisplay() throws IOException {
        // note super class (JFrame) constructor is auto called
        this.setLayout(new FlowLayout());
//this.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // read in the default (first image)
        String imagePath = ImageDisplay.IMAGES[this.currentImageIndex];
        File imageFile = new File(imagePath);
        this.currentImage = ImageIO.read(imageFile);

        // display the image
        this.displayImage(this.currentImage);

    }

    /*****************************************
     * This method switches between the images available.
     * Pre : none
     * Post: the available images (IMAGES array) are rotated through in
     * a circular queue fashion.
     */
    public void switchImage() {
        // move the circular queue position to next index
    }

    /**********************************
     * This method displays the given image on the JFrame.
     * 
     * @param newImage - non-null buffered image is given
     *                 Post: the given image is display on the JFrame
     */
    private void displayImage(BufferedImage newImage) {
        this.setVisible(false);
        // if there is a current image, then remove it
        if (imageHolder != null)
            this.remove(imageHolder);
        // set the size of the frame with 50 pixels of padding
        this.setSize(newImage.getWidth() + 50, newImage.getHeight() + 50);
        // add the image to the JFrame
        imageHolder = new JLabel(new ImageIcon(newImage));
        this.add(imageHolder);
        this.setVisible(true); // show the JFrame with image

    }

    /**********************************************
     * This method rotates the currently image used by 90 degree
     * in a clockwise fashion.
     * Pre : given an implicit image display (this)
     * Post: the image is rotated 90 degree clockwise
     */
    public void rotate() {
        // get the width and height of the image
    }
    
    /************************************
     * This method takes the current image used and finds the grayscale equivalent
     * image.
     * Pre : the implicit image display is given
     * Post: a gray scale version of the current image is displayed
     */
    public void grayScale() {
        // get the width and height of the image
    }

    /******************************************
     * This method inverts the color of the currently displayed image.
     * That is, we take the current RGB value of the color for the pixel
     * and form a new image where the valuee is 255-R, 255-G, 255-B.
     * Pre : given the implicit image display
     * Post: an image with the inverted colors of the current image is displayed
     */
    public void invert() {
        // get the width and height of the image
    }

    /***************************************
     * This method displays a version of the current image which
     * is flipped horizontally. That is, the first column pixels are
     * swapped with the last column, the 2nd column pixels are swapped
     * with the second to last columns, etc.
     * Pre : given the implicit ImageDisplay
     * Post: a version of the current image that is flipped horizontally is
     * displayed
     */
    public void flipHorizontal() {
        // get the width and height of the image
    }

    /***************************************
     * This method displays a version of the current image which
     * is flipped vertically. That is, the first row pixels are
     * swapped with the last row, the 2nd row pixels are swapped
     * with the second to last row, etc.
     * Pre : given the implicit ImageDisplay
     * Post: a version of the current image that is flipped vertically is displayed
     */
    public void flipVertical() {
        // get the width and height of the image
    }

    /***************************************
     * This method displays a filtered version of the current image.
     * That is, a mask is applied to the pixels to highlight specific
     * colors.
     * 
     * Pre : given the mask as a positive integer
     * Post: a version of the current image that is filtered is displayed
     */
    public void filter(int mask) {
        // get the width and height of the image
    }

    /****************************************************
     * This method hanles the event of a key being pressed
     * and changes the displayed image in accordance
     * with the key pressed.
     * Pre : given a key event holding the keycode and char
     * of the key pressed
     * Post: if the key is tied to an action, a new image will
     * be display. if not, nothing happends
     */
  

} // end class