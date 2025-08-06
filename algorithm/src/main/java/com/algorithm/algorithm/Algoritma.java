package com.algorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Algoritma {
	
	//	Notation	Nama				Deskripsi 
	//	O(1)		Constant Time		Waktu eksekusi tidak tergantung pada input size
	//	O(n)		Linear Time			Waktu eksekusi bertambah proporsional dengan ukuran input
	//	O(log n)	Logarithmic Time	Waktu eksekusi tumbuh lambat seiring peningkatan input
	//	O(n log n)	Linearithmic Time	Gabungan linear dan logarithmic
	//	O(n^2)		Quadratic Time		Waktu eksekusi meningkat secara kuadrat terhadap ukuran input
	
	/*
	 * Konsep Algoritma:
	 * 
	 * Recursion: Memecah masalah menjadi sub-masalah yang lebih kecil (Fibonacci, Factorial)
	 * Search: Binary Search untuk pencarian efisien pada data terurut
	 * Sort: Merge Sort sebagai contoh algoritma sorting divide-and-conquer
	 * Sliding Window: Teknik untuk masalah substring/array dengan window yang bergerak
	 * Two Pointer: Pendekatan dengan dua pointer untuk masalah seperti Two Sum
	 * Greedy: Membuat pilihan optimal lokal untuk mencapai solusi global optimal
	 * BFS/DFS: Traversal graf/pohon level-by-level (BFS) atau sedalam mungkin (DFS)
	 * DP: Menyimpan hasil subproblem untuk menghindari komputasi berulang
	 * Backtracking: Mencoba berbagai kemungkinan dan mundur jika tidak valid
	 */

    /**
     * Menghitung deret Fibonacci ke-n menggunakan rekursi
     * Jenis Algoritma: Rekursi
     * Kompleksitas Waktu: O(2^n) (eksponensial)
     * Kompleksitas Ruang: O(n) (kedalaman stack panggilan)
     * Cara kerja: 
     * - Jika n <= 1, langsung kembalikan n
     * - Jika tidak, jumlahkan hasil rekursi untuk n-1 dan n-2
     */
    public int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Menghitung faktorial dari n menggunakan rekursi
     * Jenis Algoritma: Rekursi
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(n) (kedalaman stack panggilan)
     * Cara kerja:
     * - Jika n <= 1, kembalikan 1
     * - Jika tidak, kalikan n dengan hasil faktorial(n-1)
     */
    public int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    /**
     * Mencari target dalam array terurut menggunakan Binary Search
     * Jenis Algoritma: Divide and Conquer
     * Kompleksitas Waktu: O(log n)
     * Kompleksitas Ruang: O(1)
     * Cara kerja:
     * - Bagi array menjadi dua bagian berulang-ulang
     * - Bandingkan elemen tengah dengan target
     * - Sesuaikan pointer kiri/kanan berdasarkan perbandingan
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    /**
     * Mengurutkan array menggunakan Merge Sort
     * Jenis Algoritma: Divide and Conquer
     * Kompleksitas Waktu: O(n log n)
     * Kompleksitas Ruang: O(n)
     * Cara kerja:
     * - Bagi array menjadi dua bagian secara rekursif
     * - Urutkan masing-masing bagian
     * - Gabungkan dua bagian yang sudah terurut
     */
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums;

        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    // Helper method untuk Merge Sort
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];
        while (j < right.length)
            result[k++] = right[j++];

        return result;
    }

    /**
     * Mencari substring terpanjang tanpa karakter berulang
     * Jenis Algoritma: Sliding Window
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(min(m, n)) (m = ukuran charset)
     * Cara kerja:
     * - Gunakan window [i,j] untuk melacak substring saat ini
     * - Geser j ke kanan selama tidak ada duplikat
     * - Jika ada duplikat, geser i ke kanan
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }

    /**
     * Mencari dua angka yang jumlahnya sama dengan target (array terurut)
     * Jenis Algoritma: Two Pointers
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(1)
     * Cara kerja:
     * - Gunakan pointer kiri (awal) dan kanan (akhir)
     * - Hitung jumlah elemen di kedua pointer
     * - Sesuaikan pointer berdasarkan perbandingan dengan target
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[] { left + 1, right + 1 };
            else if (sum < target)
                left++;
            else
                right--;
        }
        
        return new int[] { -1, -1 };
    }

    /**
     * Mengecek apakah bisa mencapai akhir array (nilai = lompatan maks)
     * Jenis Algoritma: Greedy
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(1)
     * Cara kerja:
     * - Lacak jarak terjauh yang bisa dicapai
     * - Jika indeks melebihi jarak terjauh, return false
     * - Jika mencapai akhir, return true
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        
        return true;
    }

    /**
     * Mencari jumlah lompatan minimal untuk mencapai akhir array
     * Jenis Algoritma: Greedy
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(1)
     * Cara kerja:
     * - Lacak jarak terjauh, akhir jangkauan saat ini, dan jumlah lompatan
     * - Update jarak terjauh selama iterasi
     * - Jika mencapai akhir jangkauan, tambah lompatan
     */
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }

    /**
     * Menghitung jumlah pulau dalam grid (1 = daratan, 0 = air)
     * Jenis Algoritma: BFS (Breadth-First Search)
     * Kompleksitas Waktu: O(m*n)
     * Kompleksitas Ruang: O(min(m,n))
     * Cara kerja:
     * - Iterasi setiap sel grid
     * - Jika menemukan daratan, lakukan BFS untuk tandai seluruh daratan terhubung
     * - Tambah counter pulau setiap memulai BFS baru
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    bfs(grid, r, c);
                }
            }
        }
        
        return numIslands;
    }

    // Helper method untuk BFS pada numIslands
    private void bfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        grid[r][c] = '0';
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int newR = current[0] + dir[0];
                int newC = current[1] + dir[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == '1') {
                    queue.add(new int[] { newR, newC });
                    grid[newR][newC] = '0';
                }
            }
        }
    }

    // Kelas bantuan untuk TreeNode (digunakan di maxPathSum)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    /**
     * Mencari jumlah maksimum path sum dalam binary tree
     * Jenis Algoritma: DFS (Depth-First Search)
     * Kompleksitas Waktu: O(n)
     * Kompleksitas Ruang: O(h) (tinggi tree)
     * Cara kerja:
     * - Lakukan DFS traversal
     * - Setiap node menghitung max path sum yang bisa diperoleh
     * - Update maxSum global jika ditemukan path yang lebih besar
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        
        return maxSum;
    }

    // Helper method DFS untuk maxPathSum
    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        
        return node.val + Math.max(left, right);
    }

    /**
     * Mencari path sum minimum dari atas ke bawah dalam segitiga
     * Jenis Algoritma: Dynamic Programming
     * Kompleksitas Waktu: O(n^2)
     * Kompleksitas Ruang: O(n)
     * Cara kerja:
     * - Gunakan array dp untuk menyimpan minimum path sum
     * - Mulai dari baris bawah ke atas
     * - Update dp dengan nilai minimum dari dua jalur yang mungkin
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }

    /**
     * Menghasilkan semua kombinasi k angka dari range [1, n]
     * Jenis Algoritma: Backtracking
     * Kompleksitas Waktu: O(C(n,k))
     * Kompleksitas Ruang: O(k)
     * Cara kerja:
     * - Gunakan rekursi untuk membangun kombinasi
     * - Tambah angka ke kombinasi saat ini
     * - Backtrack jika kombinasi sudah mencapai ukuran k
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        
        return result;
    }

    // Helper method backtrack untuk combine
    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Mengecek apakah kata ada dalam grid (huruf berdekatan vertikal/horizontal)
     * Jenis Algoritma: Backtracking
     * Kompleksitas Waktu: O(m*n*4^L) (L = panjang kata)
     * Kompleksitas Ruang: O(L) (rekursi stack)
     * Cara kerja:
     * - Cari karakter pertama kata di grid
     * - Lakukan DFS 4 arah untuk mencocokkan sisa karakter
     * - Tandai sel yang sudah dikunjungi sementara
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }

    // Helper method backtrack untuk word search
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = backtrack(board, word, i + 1, j, index + 1) || backtrack(board, word, i - 1, j, index + 1)
                || backtrack(board, word, i, j + 1, index + 1) || backtrack(board, word, i, j - 1, index + 1);

        board[i][j] = temp;
        
        return found;
    }

    /**
     * Menyelesaikan masalah N-Ratu (menempatkan N ratu di papan catur NxN tanpa serangan)
     * Jenis Algoritma: Backtracking
     * Kompleksitas Waktu: O(N!)
     * Kompleksitas Ruang: O(N^2)
     * Cara kerja:
     * - Coba tempatkan ratu di setiap kolom secara rekursif
     * - Periksa apakah posisi aman dari serangan
     * - Jika baris terakhir tercapai, simpan solusi
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, result);
        
        return result;
    }

    // Helper method untuk N-Queens
    private void backtrack(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    // Helper method untuk cek posisi valid N-Queens
    private boolean isValid(char[][] board, int row, int col) {
        // Cek kolom
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Cek diagonal kiri atas
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Cek diagonal kanan atas
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    // Helper method untuk konstruksi solusi N-Queens
    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        
        return solution;
    }
}