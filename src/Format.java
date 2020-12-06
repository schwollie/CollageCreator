public class Format {

    private double width;
    private double height;
    private double ratio;

    public Format(double width, double height) {
        this.width = width;
        this.height = height;

        this.ratio = width / height;
    }

    public Format() {
        this.width = 1;
        this.height = 1;
        this.ratio = 1;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRatio() {
        return ratio;
    }
}
