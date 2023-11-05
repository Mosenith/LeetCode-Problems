import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchIIBestApproach {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(board.length);
        System.out.println(board[0].length);
//        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));
        System.out.println("======== Matrix ========");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");

        WordSearchIIBestApproach ans = new WordSearchIIBestApproach();
        System.out.println(ans.findWords(board, words));
    }

    // ***************** 3rd Method ******************
    // Approach 1: Use Trie and dfs
    // Runtime  : 126ms            -> + 76.97%
    // Memory   : 43.78MB        -> + 81.69%
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        printTrie(root);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public void printTrie(TrieNode node, String prefix) {
        if (node == null) {
            return;
        }

        if (node.word != null) {
            System.out.println(prefix + node.word);
        }

        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                char c = (char) ('a' + i);
                printTrie(node.next[i], prefix + c);
            }
        }
    }

    // To print the entire trie, call this method with the root node.
    public void printTrie(TrieNode root) {
        printTrie(root, "");
    }

}
