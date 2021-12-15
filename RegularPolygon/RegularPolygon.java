package RegularPolygon;

public class RegularPolygon{
    private int myNumSides;      //number of sides
    private double mySideLength; //length of side
    private double myR;          //radius of circumscribed circle
    private double myr;          //radius of inscribed circle
    
    public RegularPolygon(){
        myNumSides = 3;
        mySideLength = 1; //not sure if this is right, i dont think that it says what the default val should be here
        calcR();
        calcr();
    }
    public RegularPolygon(int numSides, double sideLength){
        myNumSides = numSides;
        mySideLength = sideLength;
        calcR();
        calcr();
    }

    private void calcr(){
        myr = (mySideLength / 2.0) * Math.tan(Math.toRadians(vertexAngle() / 2.0));
    }

    private void calcR(){
        myR = myr / Math.sin(Math.toRadians(vertexAngle() / 2.0));
    }

    public double vertexAngle(){
        return (180 * ((double)myNumSides - 2)) / (double)myNumSides;
    }

    public double perimeter(){
        return mySideLength * myNumSides;
    }

    //breaks the polygon into a bunch of congruent triangles
    public double area(){
        return (myNumSides - 2) * (mySideLength * myr / 2);
    }

    public double getNumSide(){
        return (double)myNumSides;
    }

    public double getSideLength(){
        return mySideLength;
    }

    public double getR(){
        return myR;
    }

    public double getr(){
        return myr;
    }

    @Override
    public String toString(){
        return myNumSides + " sides, " + mySideLength + " long, r = " + myr +", R = " + myR;
    }
}