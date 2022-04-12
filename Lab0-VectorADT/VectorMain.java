//Oscar Maldonado 
//CS301
//3/30/2022
//MyVector.java
public class VectorMain {
    public static void main(String[] args) {
        //initialization of the vector objects
        double[] val = {8.0, 8.0, 8.0};
        MyVector vect = new MyVector(val);
        double[] val2 = {8.0, 9.0, 8.0};
        MyVector vect2 = new MyVector(val2);
        
        //testing of the implemented code
        MyVector plus = vect2.plus(vect);
        System.out.println(plus.toString());
        MyVector plus2 = vect2.minus(vect);
        System.out.println(plus2.toString());
        MyVector plus3 = vect2.dotProduct(vect);
        System.out.println(plus3.toString());
        MyVector plus4 = vect2.scaledBy(4);
        System.out.println(plus4.toString());
        boolean tf = vect2.equals(vect);
        System.out.println(tf);
        MyVector plus5 = vect2.abs();
        System.out.println(plus5.toString());
        double value = vect2.accessor(8.0);
        System.out.println(value);
    }
}
