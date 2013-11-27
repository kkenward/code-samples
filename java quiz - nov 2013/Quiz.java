package app;

import java.util.Arrays;

/**
 * 1. Implement the function foobar.
 * 
 * 2. Implement the function isPalindrome. You do not have any additional memory
 * to create an additional array. In addition to a correct algorithm, did you
 * apply defensive programming? Did you check against bad inputs, boundary
 * conditions, etc? Drive for completeness in the solution, and eliminate all
 * bugs if possible.
 * 
 * 3. Implement the function sumExists. What is the runtime performance (Big-O)
 * of your solution? Can you achieve better than O(n^2)?
 * Answer>> My implementation of sumExists is slightly better than O(n^2) because
 *  the first loop only goes to n-1 and the second loop always begins with the
 *  index of the first loop plus 1 instead of always starting with 0. That way
 *  it avoids duplicate checks.
 *  I also included an implementation sumExistsSorted. If there is an expectation
 *  that intArray and sum only contain positive integers, sorting the array and
 *  finding the insertion point of sum may further reduce the number of elements
 *  to be tested. 
 * 
 * 4. Implement the function treeSum. The solution will use recursion. What is
 * the recursion exit condition?
 * Answer>> The exit condition is a null node, so return a sum of 0.
 */
class Quiz {

	/**
	 * This function prints the numbers from 1 to 100. But for multiples of
	 * three print “Foo” instead of the number and for the multiples of five
	 * print “Bar” instead of the number. For numbers which are multiples of
	 * both three and five print “FooBar”.
	 */
	void foobar() {
		for (int i=1; i<=100; i++) {	
			System.out.println(modCheck(i));
		}
	}

	String modCheck(int i) {
		String output;
		if (i%15 == 0) {
			output = "FooBar";
		} else if (i%3 == 0) {
			output = "Foo";
		} else if (i%5 == 0) {
			output = "Bar";
		} else {
			output = Integer.toString(i);
		}
		return output;
	}

	/**
	 * Given an array of characters (i.e. a string) return true if the string is
	 * a palindrome, and false if it is not.
	 * 
	 * A palindrome is a sequence of characters which reads the same way
	 * forwards or backwards. For example, "abba" is a palindrome where-as
	 * "abcde" is not.
	 * 
	 * @param input
	 *            The input character sequence
	 * @return Returns true if <code>input</code> is a palindrome, false
	 *         otherwise.
	 */
	boolean isPalindrome(char[] input) throws IllegalArgumentException {
		if (input == null) {
			throw new IllegalArgumentException("char[] input must not be null.");
		}
		if (input.length <= 0) {
			throw new IllegalArgumentException("Invalid length of char[] input.");
		}

		boolean result = true;
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			if (input[left] != input[right]) {
				result = false;
				break;
			}
			left++;
			right--;
		}
		return result;
	}

	/**
	 * Given an array of integers (<code>intArray</code>), find out if any two
	 * elements in this array added together have the value of <code>sum</code>
	 * 
	 * For example, if we have intArray = [1, 5, 2, 10, 13] and sum = 11, then
	 * this method will return true because 1 + 10 = 11 (intArray[0] +
	 * intArray[3] = 11).
	 * 
	 * If sum = 99, then the value returned will be false because no 2 elements
	 * in this array add up to 99.
	 * 
	 * @param intArray
	 *            The array of source integers
	 * @param sum
	 *            The sum to find between 2 integers in <code>intArray</code>
	 * @return Returns true if <code>sum</code> is found in
	 *         <code>intArray</code> , false otherwise.
	 */
	boolean sumExists(final int[] intArray, final int sum) {
		if (intArray == null) {
			throw new IllegalArgumentException("int[] intArray must not be null.");
		}
		if (intArray.length < 2) {
			throw new IllegalArgumentException("int[] intArray contains too few elements.");
		}

		boolean result = false;
		int newsum = 0;
		for (int i = 0; i < intArray.length-1; i++) {
			for (int j = i+1; j < intArray.length; j++) {
				newsum = intArray[i] + intArray[j];
				if (newsum == sum) {
					result = true;
					return result;
				}
			}
		}

		return result;
	}

	boolean sumExistsSorted(final int[] intArray, final int sum) {		
		if (intArray == null) {
			throw new IllegalArgumentException("int[] intArray must not be null.");
		}
		if (intArray.length < 2) {
			throw new IllegalArgumentException("int[] intArray contains too few elements.");
		}

		Arrays.sort(intArray);
		int max = findMax(intArray, sum);

		boolean result = false;
		int newsum = 0;
		for (int i = 0; i < max-1; i++) {
			for (int j = max; j > i; j--) {
				newsum = intArray[i] + intArray[j];
				if (newsum == sum) {
					result = true;
					return result;
				}
			}
		}

		return result;
	}

	int findMax(final int[] intArray, final int sum) {
		int max = Arrays.binarySearch(intArray, sum);
		if (max < 0) {
			max = Math.abs(max) - 1;
			if (max >= intArray.length) {
				max = intArray.length-1;
			}
		}
		return max;
	}


	class TreeNode {
		int value;
		TreeNode leftSubtree;
		TreeNode rightSubtree;
	}

	/**
	 * Takes a root {@link TreeNode} and calculates the sum of all the child
	 * {@link TreeNode}s
	 * 
	 * @param node
	 *            The root node
	 * @return Returns the sum of all the node values
	 */
	long treeSum(TreeNode node) {
		if (node == null) {
			return 0L;
		} else {
			return treeSum(node.leftSubtree) + treeSum(node.rightSubtree) + node.value;
		}
	}

}
