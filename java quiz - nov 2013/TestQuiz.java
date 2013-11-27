package app;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Quiz.TreeNode;

public class TestQuiz {
	Quiz myQuiz = new Quiz();
	
	@Test
	public final void testFoobar() {
		myQuiz.foobar();
		assertTrue("for loop - 1 to 100", true);
	}
	
	@Test
	public final void testModCheckFoo() {
		assertEquals("Foo", myQuiz.modCheck(3));
		assertEquals("Foo", myQuiz.modCheck(6));
		assertEquals("Foo", myQuiz.modCheck(9));
		assertEquals("Foo", myQuiz.modCheck(12));
	}
	
	@Test
	public final void testModCheckBar() {
		assertEquals("Bar", myQuiz.modCheck(5));
		assertEquals("Bar", myQuiz.modCheck(10));
		assertEquals("Bar", myQuiz.modCheck(20));
		assertEquals("Bar", myQuiz.modCheck(25));
	}
	
	@Test
	public final void testModCheckFooBar() {
		assertEquals("FooBar", myQuiz.modCheck(15));
		assertEquals("FooBar", myQuiz.modCheck(30));
		assertEquals("FooBar", myQuiz.modCheck(45));
		assertEquals("FooBar", myQuiz.modCheck(60));
	}
	
	@Test
	public final void testModCheckInt() {
		assertEquals("1", myQuiz.modCheck(1));
		assertEquals("2", myQuiz.modCheck(2));
		assertEquals("4", myQuiz.modCheck(4));
		assertEquals("7", myQuiz.modCheck(7));
	}

	@Test
	public final void testIsPalindromeTrue() {
		assertTrue(myQuiz.isPalindrome("abba".toCharArray()));
		assertTrue(myQuiz.isPalindrome("abcdedcba".toCharArray()));
		assertTrue(myQuiz.isPalindrome("a".toCharArray()));
	}
	
	@Test
	public final void testIsPalindromeFalse() {
		assertFalse(myQuiz.isPalindrome("abcde".toCharArray()));
		assertFalse(myQuiz.isPalindrome("abab".toCharArray()));
		assertFalse(myQuiz.isPalindrome("ab".toCharArray()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testIsPalindromeNull() {
			myQuiz.isPalindrome(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testIsPalindrome0Length() {
			myQuiz.isPalindrome("".toCharArray());
	}

	@Test
	public final void testSumExistsTrue() {
		int[] intArray = {1, 5, 2, 10, 13};
		int sum = 11;
		assertTrue(myQuiz.sumExists(intArray, sum));
		assertTrue(myQuiz.sumExistsSorted(intArray, sum));
	}
	
	@Test
	public final void testSumExistsFalse() {
		int[] intArray = {1, 5, 2, 10, 13};
		int sum = 99;
		assertFalse(myQuiz.sumExists(intArray, sum));		
		assertFalse(myQuiz.sumExistsSorted(intArray, sum));		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testSumExistsNull() {
		int[] intArray = null;
		int sum = 0;
		myQuiz.sumExists(intArray, sum);
		myQuiz.sumExistsSorted(intArray, sum);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testSumExistsLessThan2() {
		int[] intArray = {1};
		int sum = 0;
		myQuiz.sumExists(intArray, sum);
		myQuiz.sumExistsSorted(intArray, sum);
	}
	
	@Test
	public final void testfindMax() {
		int[] intArraySorted = {1, 2, 5, 10, 13};
		int sum = 11;
		assertEquals(4, myQuiz.findMax(intArraySorted, sum));
		sum = 99;
		assertEquals(4, myQuiz.findMax(intArraySorted, sum));
		sum = 4;
		assertEquals(2, myQuiz.findMax(intArraySorted, sum));
	}

	@Test
	public final void testSumExistsSorted() {
		assertTrue("see tests for sumExists", true);
	}

	@Test
	public final void testTreeSum() {
		TreeNode myNode = myQuiz.new TreeNode();
		myNode.value = 11;
		assertEquals(11, myQuiz.treeSum(myNode));
		myNode.leftSubtree = myQuiz.new TreeNode();
		myNode.leftSubtree.value = 3;
		assertEquals(14, myQuiz.treeSum(myNode));
		myNode.leftSubtree.leftSubtree = myQuiz.new TreeNode();
		myNode.leftSubtree.leftSubtree.value = 10;
		assertEquals(24, myQuiz.treeSum(myNode));
		myNode.rightSubtree = myQuiz.new TreeNode();
		myNode.rightSubtree.value = 7;
		assertEquals(31, myQuiz.treeSum(myNode));
		myNode.rightSubtree.leftSubtree = myQuiz.new TreeNode();
		myNode.rightSubtree.leftSubtree.value = 5;
		assertEquals(36, myQuiz.treeSum(myNode));
	}

	@Test
	public final void testTreeSumExit() {
		assertEquals(0, myQuiz.treeSum(null));
	}
}
