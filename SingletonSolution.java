package fortinet;

class Singleton {

	private static Singleton singleObj;

	private Singleton() {
	}

	// synchronization is mandatory in a multi-threaded environment.
	// However, it reduces performance of getInstance method
	public static synchronized Singleton getInstance() {
		if (singleObj == null) {
			singleObj = new Singleton();
		}
		return singleObj;
	}

	public void printMessage() {
		System.out.println("Singleton Obj method" + singleObj.hashCode());
	}
}

class Singleton_2 {
	// Eager instantiation: Use this when your singleton class is lightweight
	// and is used throughout the execution of the program.
	private static Singleton_2 singleObj = new Singleton_2();

	private Singleton_2() {
	}

	public static Singleton_2 getInstance() {
		return singleObj;
	}

	public void printMessage() {
		System.out.println("Singleton Obj method" + singleObj.hashCode());
	}
}

class Singleton_3 {

	/*
	 * Double checked locking mechanism: As seen from the Eager instantiation
	 * above, once an singleton obj is created, synchronization is no longer
	 * required. Therefore, it is better acquire lock on the getInstance()
	 * method only once when the obj is null
	 */

	private volatile static Singleton_3 singleObj;

	private Singleton_3() {
	}

	public static Singleton_3 getInstance() {
		if (singleObj == null) {
			synchronized (Singleton_3.class) {
				// synchronized block will prevent multiple threads from
				// accessing at once. However, these threads might have already
				// entered the above if block. Therefore, double checking.
				if (singleObj == null) {
					singleObj = new Singleton_3();
				}
			}
		}
		return singleObj;
	}

	public void printMessage() {
		System.out.println("Singleton Obj method" + singleObj.hashCode());
	}
}

public class SingletonSolution {
	public static void main(String args[]) {

		Singleton s;

		s = Singleton.getInstance();
		s.printMessage();

		s = Singleton.getInstance();
		s.printMessage();

		Singleton_2 s2;

		s2 = Singleton_2.getInstance();
		s2.printMessage();

		s2 = Singleton_2.getInstance();
		s2.printMessage();

		Singleton_3 s3;

		s3 = Singleton_3.getInstance();
		s3.printMessage();

		s3 = Singleton_3.getInstance();
		s3.printMessage();

	}
}

/* Output */
/*
Singleton Obj method366712642
Singleton Obj method366712642
Singleton Obj method1829164700
Singleton Obj method1829164700
Singleton Obj method2018699554
Singleton Obj method2018699554
*/
