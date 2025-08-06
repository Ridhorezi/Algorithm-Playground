package com.algorithm.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class AlgoritmaTest {

    Algoritma algo = new Algoritma();

    /**
     * Test untuk fungsi Fibonacci
     * - Memverifikasi perhitungan deret Fibonacci ke-5 dan ke-6
     * - Output nilai Fibonacci(5) ke console
     */
    @Test
    void testFibonacci() {
        assertEquals(5, algo.fibonacci(5));
        assertEquals(8, algo.fibonacci(6));
        System.out.println("Fibonacci(5): " + algo.fibonacci(5));
    }

    /**
     * Test untuk fungsi Factorial
     * - Memverifikasi perhitungan faktorial 5 dan 6
     * - Output nilai Factorial(5) ke console
     */
    @Test
    void testFactorial() {
        assertEquals(120, algo.factorial(5));
        assertEquals(720, algo.factorial(6));
        System.out.println("Factorial(5): " + algo.factorial(5));
    }

    /**
     * Test untuk Binary Search
     * - Mencari nilai 9 dan 2 dalam array terurut
     * - Output hasil pencarian ke console
     */
    @Test
    void testBinarySearch() {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        int result = algo.binarySearch(nums, target);
        System.out.println("Binary Search for 9: Index " + result);
        assertEquals(4, result);
        target = 2;
        result = algo.binarySearch(nums, target);
        System.out.println("Binary Search for 2: Index " + result);
        assertEquals(-1, result);
    }

    /**
     * Test untuk pengurutan array
     * - Mengurutkan array [5,2,3,1]
     * - Output array sebelum dan sesudah diurutkan
     */
    @Test
    void testSortArray() {
        int[] nums = { 5, 2, 3, 1 };
        int[] sorted = algo.sortArray(nums);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
        assertArrayEquals(new int[] { 1, 2, 3, 5 }, sorted);
    }

    /**
     * Test untuk mencari substring terpanjang tanpa karakter berulang
     * - Mencari substring terpanjang dalam "abcabcbb"
     * - Output hasil ke console
     */
    @Test
    void testLengthOfLongestSubstring() {
        String s = "abcabcbb";
        int result = algo.lengthOfLongestSubstring(s);
        System.out.println("Longest substring without repeating in '" + s + "': " + result);
        assertEquals(3, result);
    }

    /**
     * Test untuk Two Sum II
     * - Mencari dua angka dalam array terurut yang jumlahnya 9
     * - Output indeks hasil pencarian
     */
    @Test
    void testTwoSum() {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = algo.twoSum(numbers, target);
        System.out.println("Two Sum II indices: [" + result[0] + ", " + result[1] + "]");
        assertArrayEquals(new int[] { 1, 2 }, result);
    }

    /**
     * Test untuk Jump Game
     * - Mengecek apakah bisa mencapai akhir array
     * - Test dengan dua skenario berbeda
     */
    @Test
    void testCanJump() {
        int[] nums1 = { 2, 3, 1, 1, 4 };
        boolean result1 = algo.canJump(nums1);
        System.out.println("Can jump (nums1): " + result1);
        assertTrue(result1);
        int[] nums2 = { 3, 2, 1, 0, 4 };
        boolean result2 = algo.canJump(nums2);
        System.out.println("Can jump (nums2): " + result2);
        assertFalse(result2);
    }

    /**
     * Test untuk Jump Game II
     * - Mencari jumlah lompatan minimal untuk mencapai akhir
     * - Output jumlah lompatan ke console
     */
    @Test
    void testJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        int result = algo.jump(nums);
        System.out.println("Minimum jumps: " + result);
        assertEquals(2, result);
    }

    /**
     * Test untuk menghitung jumlah pulau
     * - Menghitung pulau dalam grid 2D
     * - Output jumlah pulau ke console
     */
    @Test
    void testNumIslands() {
        char[][] grid = { 
            { '1', '1', '0', '0', '0' }, 
            { '1', '1', '0', '0', '0' }, 
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' } 
        };
        int result = algo.numIslands(grid);
        System.out.println("Number of islands: " + result);
        assertEquals(3, result);
    }

    /**
     * Test untuk mencari maximum path sum dalam binary tree
     * - Membangun tree sederhana dan menghitung path sum maksimal
     * - Output hasil ke console
     */
    @Test
    void testMaxPathSum() {
        // Membangun tree: [-10,9,20,null,null,15,7]
        Algoritma.TreeNode root = algo.new TreeNode(-10);
        root.left = algo.new TreeNode(9);
        root.right = algo.new TreeNode(20);
        root.right.left = algo.new TreeNode(15);
        root.right.right = algo.new TreeNode(7);
        int result = algo.maxPathSum(root);
        System.out.println("Maximum path sum: " + result);
        assertEquals(42, result);
    }

    /**
     * Test untuk mencari minimum path sum dalam segitiga
     * - Membangun segitiga dan mencari path sum terkecil
     * - Output hasil ke console
     */
    @Test
    void testMinimumTotal() {
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        int result = algo.minimumTotal(triangle);
        System.out.println("Minimum path sum in triangle: " + result);
        assertEquals(11, result);
    }

    /**
     * Test untuk menghasilkan kombinasi angka
     * - Menghasilkan semua kombinasi 2 angka dari 1-4
     * - Output semua kombinasi ke console
     */
    @Test
    void testCombine() {
        int n = 4, k = 2;
        List<List<Integer>> result = algo.combine(n, k);
        System.out.println("Combinations of " + k + " numbers from 1 to " + n + ":");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
        assertEquals(6, result.size());
    }

    /**
     * Test untuk word search
     * - Mencari kata "ABCCED" dalam grid huruf
     * - Output hasil pencarian ke console
     */
    @Test
    void testExist() {
        char[][] board = { 
            { 'A', 'B', 'C', 'E' }, 
            { 'S', 'F', 'C', 'S' }, 
            { 'A', 'D', 'E', 'E' } 
        };
        String word = "ABCCED";
        boolean result = algo.exist(board, word);
        System.out.println("Word '" + word + "' exists: " + result);
        assertTrue(result);
    }

    /**
     * Test untuk N-Queens problem
     * - Menyelesaikan masalah 4-Queens
     * - Output semua solusi ke console
     */
    @Test
    void testSolveNQueens() {
        int n = 4;
        List<List<String>> result = algo.solveNQueens(n);
        System.out.println("Solutions for " + n + "-Queens problem:");
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        assertEquals(2, result.size());
    }
}