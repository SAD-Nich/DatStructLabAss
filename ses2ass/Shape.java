package ses2ass;
abstract class Shape{
    public String color;
    public Shape(){
        color = "darkgreen";
    }
    abstract int getArea();
}