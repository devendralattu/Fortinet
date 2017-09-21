// 2. Sum of multidimensional Array. require no extra space, no recursion.

class MultiDimensionArray {

	// This is a provided function, Assume it works
	public static Long getValue(int... indexOfDimension) {
		// ...
		Long value = 1L; // some internal set example
		// ...
		return value;
	}

	// lengthOfDeminsion: each dimension's length, assume it is valid:
	// lengthOfDeminsion[i]>0.
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
		// Your resolution
		/*
		 * We need to generate indices for each of the multidimention
		 * [0, 0, 0]
		 * [0, 0, 1]
		 * ...
		 * [0, 0, c-1]
		 * ...
		 * ...
		 * [a-1, b-1, c-1] 
		 */
		// Time complexity: O(Number of all the elements of mArray) = O(product of each element from lengthOfDeminsion) 
		// Space complexity: O(n) where n is the dimention of mArray 

		Long sum = 0L;

		if (lengthOfDeminsion == null || lengthOfDeminsion.length == 0) {
			return sum;
		}

		int n = lengthOfDeminsion.length;
		int[] indices = new int[n];
		int i = n - 1;

		while (i >= 0) {
			sum += getValue(indices);

			for (i = n - 1; i >= 0; i--) {
				// set the index
				indices[i]++;

				if (indices[i] < lengthOfDeminsion[i]) {
					break;
				}

				// reset the index
				indices[i] = 0;
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		MultiDimensionArray mArray = new MultiDimensionArray();
		int[] lengthOfDeminsion = { 5, 6, 1, 10 };
		Long sum = sum(mArray, lengthOfDeminsion);
		System.out.println("Sum = " + sum);
	}

}
