package reversi.view;

import javafx.scene.paint.Color;

public class Disk {


    public static Color BLACK = Color.BLACK;
    public static Color WHITE = Color.WHITE;
    private int column;
    private int row;

    public Disk create() {
        return new Disk();
    }

    public Disk color(Color color){
        this.color = color;
        return this;
    }

    public Disk size(int column, int row) {
        this.column = column;
        this.row = row;
        return this;
    }

    public Disk boxSize(int column, int row) {
        this.column = column;
        this.row = row;
        return this;
    }

    private Color color;

    public void draw() {


    }

    private Disk() {}


    public Color getColor() {
        return color;
    }

}
