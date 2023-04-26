import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

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
public class ImageDisplay extends JFrame implements KeyListener {

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
        this.addKeyListener(this);
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
        this.currentImageIndex = (this.currentImageIndex + 1) % 3;
        String imagePath = ImageDisplay.IMAGES[this.currentImageIndex];
        File imageFile = new File(imagePath);
        // get the new file, if there is an error, switch to the default
        // (first image) and try again
        try {
            this.currentImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            this.currentImageIndex = 0;
            this.switchImage();
        }
        this.displayImage(this.currentImage);
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
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();
        BufferedImage rotatedImage = new BufferedImage(h, w, BufferedImage.TYPE_INT_RGB);
        // first row becomes last column
        // second row becomes second to last column
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                int color = currentImage.getRGB(x, y);
                rotatedImage.setRGB(h - y - 1, x, color);
            }

        // display the rotated image
        this.displayImage(rotatedImage);
    }
    
    /************************************
     * This method takes the current image used and finds the grayscale equivalent
     * image.
     * Pre : the implicit image display is given
     * Post: a gray scale version of the current image is displayed
     */
    public void grayScale() {
        // get the width and height of the image
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();

        BufferedImage bwImage = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                // average the red, blue, and green values
                // of the pixel and set the corresponding
                // grayscale pixel to this average value
                Color color = new Color(this.currentImage.getRGB(x, y));
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                int gray = (red + blue + green) / 3;
                color = new Color(gray, gray, gray);
                bwImage.setRGB(x, y, color.getRGB());
            }

        this.displayImage(bwImage);
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
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();

        BufferedImage invertedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                int color = this.currentImage.getRGB(x, y);
                // subtracting the RGB value from 255 (= 0b11111111)
                // is the same as flipping the bits!
                invertedImage.setRGB(x, y, ~color);
            }
        this.displayImage(invertedImage);
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
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();

        BufferedImage flippedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                int color = this.currentImage.getRGB(x, y);
                flippedImage.setRGB(w - x - 1, y, color);
            }
        this.displayImage(flippedImage);
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
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();

        BufferedImage flippedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                int color = this.currentImage.getRGB(x, y);
                flippedImage.setRGB(x, h - y - 1, color);
            }
        this.displayImage(flippedImage);
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
        int w = this.currentImage.getWidth();
        int h = this.currentImage.getHeight();

        BufferedImage filteredImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                int color = this.currentImage.getRGB(x, y);
                filteredImage.setRGB(x, y, mask & color);
            }
        this.displayImage(filteredImage);
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
    @Override
    public void keyPressed(KeyEvent e) {
        // should we use a switch statement?
        switch (e.getKeyCode()) {
            case KeyEvent.VK_C:
                this.rotate();    
                break;
            case KeyEvent.VK_R:
                this.filter(0x00FF0000);
                break;
            case KeyEvent.VK_G:
                this.filter(0x0000FF00);
                break;
            case KeyEvent.VK_B:
                this.filter(0x000000FF);
                break;
            case KeyEvent.VK_H:
                this.flipHorizontal();
                break;
            case KeyEvent.VK_V:
                this.flipVertical();
                break;
            case KeyEvent.VK_M:
                this.filter(0x00FF00FF);
                break;
            case  KeyEvent.VK_Y:
                this.filter(0x00FFFF00);
                break;
            case  KeyEvent.VK_T:
                this.filter(0x0000FFFF);
                break;
            case KeyEvent.VK_I:
                this.invert();
                break;
            case KeyEvent.VK_W:
                this.grayScale();
                break;
            case KeyEvent.VK_S:
                this.switchImage();
                break;
            default:
                System.out.println("The key " + e.getKeyChar() + " is not tied to an action.");
                break;
        }  // end switch
    }  // end keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

} // end class