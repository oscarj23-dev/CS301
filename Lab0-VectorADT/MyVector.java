import java.util.*;
//Oscar Maldonado 
//CS301
//3/30/2022
//MyVector.java

public class MyVector {
	private ArrayList<Double> vectA;
	private double[] arr;
	//constructs the vector object, and initializes the arraylist
    public MyVector(double[] initValues) {
		arr = initValues;
		vectA = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
          vectA.add(arr[i]);
		}
	}

	//copy constructor
	public MyVector (MyVector vector) {
		this.vectA = vector.vectA;
		this.arr = vector.arr;
		for(int i = 0; i < arr.length; i++) {
			vectA.add(arr[i]);
		}
	}

	//returns the vector object
	public ArrayList<Double> getVect() {
		return vectA;
	}
	
	//the plus method takes a MyVector object as a parameter
	//and traverses the array subrtracting each number in both arrays at
	//the I'th index
	public MyVector plus(MyVector y) {
		double [] val = new double[vectA.size()];
		ArrayList<Double> vect = y.getVect();
		for(int i = 0; i < vectA.size(); i++) {
			val[i] = (vectA.get(i) + vect.get(i));
		}
		return new MyVector(val);
	}

	//the minus method takes a MyVector object as a parameter
	//and traverses the array subrtracting each number in both arrays at
	//the I'th index
	public MyVector minus(MyVector y) {
		double [] val = new double[vectA.size()];
		ArrayList<Double> vect = y.getVect();
		for(int i = 0; i < vectA.size(); i++) {
			val[i] = (vectA.get(i) - vect.get(i));
		}
		return new MyVector(val);
	}

	//scaledBy traverses the array and multiplies
	//every element by the scalar passed in
	public MyVector scaledBy(int scalar) {
		double [] val = new double[vectA.size()];
		for(int i = 0; i < vectA.size(); i++) {
			val[i] = (vectA.get(i) * scalar);
		}
		return new MyVector(val);
	}

	//returnds a string version of the vector object
	public String toString() {
		return vectA.toString();
	}

	//equals method makes use of the equals method in 
	//the arraylist collection library and uses logic to
	//determine of the vector objects are the same.
	public boolean equals(MyVector y) {
		ArrayList<Double> vect = y.getVect();
		if(vectA.equals(vect)) {
			return true;
		} else {
			return false;
		}
	}

	//the abs method traverses every element in the array and 
	//multiplies the element by itself to simulate raising
	//the element to the 2nd power
	public MyVector abs() {
		double [] val = new double[vectA.size()];
		for(int i = 0; i < vectA.size(); i++) {
			val[i] = (vectA.get(i) *  vectA.get(i));
		}
		return new MyVector(val);

	}
	
	//the dotProduct method takes a MyVector object as a parameter
	//and traverses the array multiplying each number in both arrays at
	//the I'th index
	public MyVector dotProduct(MyVector y) {
		double [] val = new double[vectA.size()];
		ArrayList<Double> vect = y.getVect();
		for(int i = 0; i < vectA.size(); i++) {
			val[i] = (vectA.get(i) * vect.get(i));
		}
		return new MyVector(val);
	}


	//the accessor method conducts a standard array traversal
	//and checks to see which element is equal to the parameter,
	//if the number is not in the arraylist then it returns a -1.
	public double accessor(double x) {
		for(int i = 0; i < vectA.size(); i++) {
			if(vectA.get(i) == x) {
				return x;
			}
		}
		return -1;
	}
}