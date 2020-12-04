
public class CollageSettings {

    private int cols;
    private int rows;
    private boolean autoComplete;

    private double resolution;

    public CollageSettings(int cols, int rows, boolean autoComplete, double resolution) {
        this.cols = cols;
        this.rows = rows;
        this.resolution = resolution;
        this.autoComplete = autoComplete;
        System.out.println(autoComplete);
    }

    public CollageSettings() {
        this.cols = 0;
        this.rows = 1;
        this.resolution = 1.0;
        this.autoComplete = true;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public boolean isAutoComplete() {
        return autoComplete;
    }

    public double getResolution() {
        return resolution;
    }
}
