package ses2ass;
public class Rect extends Shape{
    public int width, height;

    public Rect(int width, int height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public int getArea(){
        return this.width*this.height;
    }
    public static void main(String[] args){
        Rect rect = new Rect(15, 6, "darkgreen");
        System.out.printf("The area of this shape is : %d\n",rect.getArea(),rect.color);
    }
}
