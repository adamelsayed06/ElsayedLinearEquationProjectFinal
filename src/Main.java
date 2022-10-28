import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter coordinate 1: ");
        String coords = scan.nextLine();
        int a = coords.indexOf(","); //find index of comma so we can find the numbers from theree
        int len1 = coords.length();

        String x1 = (coords.substring(1, a));
        String y1 = (coords.substring(a+2, len1 - 1)); //we use length so it works no matter how big the number is

        System.out.println("Enter coordinate 2: ");
        String coords2 = scan.nextLine();
        int b = coords2.indexOf(",");
        int len2 = coords2.length();

        String x2 = (coords2.substring(1,b));
        String y2 = (coords2.substring(b+2,len2 - 1));

        int x1asInt = Integer.parseInt(x1); //changes all our string variables to integers for the parameters of calc
        int x2asInt = Integer.parseInt(x2);
        int y1asInt = Integer.parseInt(y1);
        int y2asInt = Integer.parseInt(y2);

        LinearEquation calc = new LinearEquation (x1asInt,y1asInt,x2asInt,y2asInt); //new object

        System.out.println(calc.lineInfo());

        System.out.println("");
        System.out.println("Enter a value for x: ");
        String xInput = scan.nextLine();

        String yValue = calc.coordinateForX(Double.parseDouble(xInput));
        System.out.println("The point on the line is (" + xInput + ", " + yValue + ")" );
    }
}