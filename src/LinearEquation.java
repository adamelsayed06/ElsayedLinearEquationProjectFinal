public class LinearEquation {
    //instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) { //takes x values user inputted, and makes our variables that.
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double roundedToHundredth(double toRound){
        double roundedNumber = (double)Math.round(toRound * 100) / 100; //ex: 5.462 -> 546.2 -> 546.0 -> 5.46 :)
        return roundedNumber;
    }


    public double distance(){
        return (Math.sqrt((Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2.0)))); //this is just formula for distance
    }

    public double slope(){

        double slope = roundedToHundredth((double)(y2-y1) / (x2-x1)); //formula for slope rounded to nearest hundredth
        return slope;
    }

    public double yIntercept(){
        double slope = slope();
        double yintercept = ((double)y1 - (slope * x1));
        return yintercept;

        /*
        this one is actually a little unintuitive. let's say you have a point (3, 4) and we know the slope is 2
        equation can be made to be 4 = (3)(2) + b
        so we can just do 4 - 6 = b so b = -2
         */
    }

    public String equation(){ // good luck
        double numerator = (y2 -y1);
        double denominator = (x2-x1);

        if (denominator < 0){
            denominator = denominator * -1;
            numerator = numerator * -1;
            // if denom is negative we change it so that the negative ends up on the numerator side of the slope
        }

        if (numerator == 0){
            String slopeInterceptForm = ("y = " + yIntercept() + "\n");
            return slopeInterceptForm;
            // if numerator is 0, omit the slope
        }

        if ((numerator / denominator) == -1){
            String slopeInterceptForm = ("y = " + "-x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInterceptForm = ("y = " + "-x" + " - " + (yIntercept() * -1) + "\n");
            }
            if (yIntercept() == 0){
                slopeInterceptForm = ("y = " + "-x" + "\n");
            }
            return slopeInterceptForm;
            //if slope is -1, make it -x instead of -1.0x, then checks all y intercept conditions
        }

        if (numerator / denominator == 1){
            String slopeInterceptForm = ("y = " + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInterceptForm = ("y = " + "x" + " - " + (yIntercept() * -1) + "\n");
            }
            if (yIntercept() == 0){
                slopeInterceptForm = ("y = x" + "\n");
            }
            return slopeInterceptForm;
            //if slope is 1, omit the coefficient, then check all y intercept conditions and rewrite as such
        }

        if (y2 == y1){
            String slopeInterceptForm = ("y = " + yIntercept());
            // if the y values are the same, it is just a horizontal line, form reflects such
        }

        if (numerator % denominator == 0){
            String slopeInterceptForm = ("y = " + numerator/denominator + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInterceptForm = ("y = " + numerator/denominator + "x - " + (yIntercept() * -1) + "\n");
            }
            if (yIntercept() == 0){
                slopeInterceptForm = ("y = " + numerator/denominator + "x" + "\n");
            }
            return slopeInterceptForm;

            //if numerator and denominator divide evenly into each other, divide them and return the decimal, then check y intercept conditions
        }

        /*if none of the above if statements apply, we have a (hopefully) normal input, and this is what the default
        slope intercept form looks like, and yet again we check the y intercept conditions
         */

        String slopeAsFraction = (int)numerator + "/" + (int)denominator;
        String slopeInterceptForm = ("y = " + slopeAsFraction + "x" + " + " + yIntercept() + "\n");
        if (yIntercept() == 0){
            slopeInterceptForm = ("y = " + slopeAsFraction + "x"  + "\n");
        }
        if (yIntercept() < 0){
            slopeInterceptForm = ("y = " + slopeAsFraction + "x"  + yIntercept() + "\n");
        }
        return slopeInterceptForm;
    }

    public String coordinateForX(double xValue){
        double yValue = xValue * slope() + yIntercept(); //takes x value, multiplies by slope, adds y intercept and gives us our output.
        return roundedToHundredth(yValue) + "";
    }

    public String lineInfo(){ //this takes all the info we collected and orders it for the user to see, points, slope, y intercept, and equation
        String point1 = ("Point 1: " + "(" + x1 +"," + y1 + ")\n");
        String point2 = ("Point 2: " + "(" + x2 +"," + y2 + ")\n");
        double slope = slope();
        double yintercept = yIntercept();
        String slopeInterceptForm = equation();
        double distance = distance();
        return point1 + point2 + "The slope is: " + slope + "\n" + "The y-intercept is: " + yintercept + "\n" + slopeInterceptForm + "The distance between the two points is: " + roundedToHundredth(distance);
    }
}

