public class Cell {
    private int point_x;
    private int point_y;
    private boolean top =true;
    private boolean left =true;
    private boolean bottom =true;
    private boolean right =true;

    public Cell(int point_x, int point_y) {
        this.point_x = point_x;
        this.point_y = point_y;
    }

    public int getPoint_x() {
        return point_x;
    }

    public void setPoint_x(int point_x) {
        this.point_x = point_x;
    }

    public int getPoint_y() {
        return point_y;
    }

    public void setPoint_y(int point_y) {
        this.point_y = point_y;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

}
