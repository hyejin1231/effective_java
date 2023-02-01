package chapter02.item13.inheritance;

public abstract class Shape implements Cloneable {
    private int area;

    public abstract int getArea();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
