// javac -cp .:lib/algs4.jar seamcarving/SeamCarver.java
// java -cp .:lib/algs4.jar seamcarving.SeamCarver seamcarving/6x5.png

package seamcarving;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
    private Picture pic;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) throw new IllegalArgumentException();
        pic = new Picture(picture); // make a copy
    }

    // current picture
    public Picture picture() {
        return new Picture(pic);
    }

    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    private double gradientSquared(int rgbA, int rgbB) {
        int rA = (rgbA >> 16) & 0xFF;
        int gA = (rgbA >> 8) & 0xFF;
        int bA = (rgbA >> 0) & 0xFF;
        int rB = (rgbB >> 16) & 0xFF;
        int gB = (rgbB >> 8) & 0xFF;
        int bB = (rgbB >> 0) & 0xFF;
        return Math.pow(rA - rB, 2) + Math.pow(gA - gB, 2) + Math.pow(bA - bB, 2);
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width()) throw new IllegalArgumentException();
        if (y < 0 || y >= height()) throw new IllegalArgumentException();
        if (x == 0 || x == width() - 1 || y == 0 || y == height() - 1) return 1000;
        int rgbLeft = pic.getRGB(x - 1, y);
        int rgbRight = pic.getRGB(x + 1, y);
        int rgbTop = pic.getRGB(x, y - 1);
        int rgbBottom = pic.getRGB(x, y + 1);
        return Math.sqrt(gradientSquared(rgbLeft, rgbRight) + gradientSquared(rgbTop, rgbBottom));
    }

    private int[] findSeam(Picture picture, double[][] energies) {
        int w = picture.width();
        int h = picture.height();

        double[][] distTo = new double[w][h];
        int[][] edgeTo = new int[w][h];

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (x == 0) distTo[x][y] = energies[x][y];
                else distTo[x][y] = Double.POSITIVE_INFINITY;
            }
        }

        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h; y++) {
                // from   -> (x, y)
                double distance;
                // mid    -> (x + 1, y)
                distance = distTo[x][y] + energies[x + 1][y];
                if (distance < distTo[x + 1][y]) {
                    distTo[x + 1][y] = distance;
                    edgeTo[x + 1][y] = y;
                }
                // top    -> (x + 1, y - 1)
                if (y != 0) {
                    distance = distTo[x][y] + energies[x + 1][y - 1];
                    if (distance < distTo[x + 1][y - 1]) {
                        distTo[x + 1][y - 1] = distance;
                        edgeTo[x + 1][y - 1] = y;
                    }
                }
                // bottom -> (x + 1, y + 1)
                if (y != h - 1) {
                    distance = distTo[x][y] + energies[x + 1][y + 1];
                    if (distance < distTo[x + 1][y + 1]) {
                        distTo[x + 1][y + 1] = distance;
                        edgeTo[x + 1][y + 1] = y;
                    }
                }
            }
        }

        int minPos = 0; // y
        double minDist = Double.POSITIVE_INFINITY;

        for (int y = 0; y < h; y++) {
            if (distTo[w - 1][y] < minDist) {
                minDist = distTo[w - 1][y];
                minPos = y;
            }
        }

        int[] seam = new int[w];
        seam[w - 1] = minPos;
        for (int x = w - 2; x >= 0; x--) {
            int y = seam[x + 1];
            seam[x] = edgeTo[x + 1][y];
        }
        return seam;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        double[][] energies = new double[width()][height()];
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                energies[x][y] = energy(x, y);
            }
        }
        return findSeam(pic, energies);
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        double[][] energies = new double[height()][width()];
        for (int x = 0; x < height(); x++) {
            for (int y = 0; y < width(); y++) {
                energies[x][y] = energy(y, x);
            }
        }
        return findSeam(transpose(pic), energies);
    }

    private void validateSeam(int[] seam, int w, int h) {
        if (h <= 1) throw new IllegalArgumentException();
        if (seam == null || seam.length != w) throw new IllegalArgumentException();
        for (int i = 0; i < seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= h) throw new IllegalArgumentException();
            if (i > 0) {
                if (Math.abs(seam[i] - seam[i-1]) > 1) throw new IllegalArgumentException();
            }
        }
    }

    private static Picture transpose(Picture picture) {
        Picture transposed = new Picture(picture.height(), picture.width());
        for (int x = 0; x < transposed.width(); x++) {
            for (int y = 0; y < transposed.height(); y++) {
                transposed.setRGB(x, y, picture.getRGB(y, x));
            }
        }
        return transposed;
    }

    private static Picture removeSeam(Picture picture, int[] seam) {
        Picture ret = new Picture(picture.width(), picture.height() - 1);
        for (int x = 0; x < ret.width(); x++) {
            for (int y = 0; y < ret.height(); y++) {
                int rgb;
                if (y < seam[x]) rgb = picture.getRGB(x, y);
                else rgb = picture.getRGB(x, y + 1);
                ret.setRGB(x, y, rgb);
            }
        }
        return ret;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        validateSeam(seam, width(), height());
        pic = removeSeam(pic, seam);
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        validateSeam(seam, height(), width());
        pic = transpose(removeSeam(transpose(pic), seam));
    }

    //  unit testing (optional)
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        SeamCarver sc = new SeamCarver(picture);
        StdOut.println("width: " + sc.width());
        StdOut.println("height: " + sc.height());
        int[] seam = sc.findHorizontalSeam();
        for (int i = 0; i < seam.length; i++) {
            StdOut.println("seam " + i + " :" + seam[i]);
        }
    }
}
