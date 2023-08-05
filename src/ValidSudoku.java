import java.util.*;

public class ValidSudoku {
    // ***************** 1st Method ******************
    // Runtime  : 3ms        -> + 68.84%
    // Memory   : 42.2MB      -> + 84.94%
    public static boolean isValidSudoku(char[][] board) {
        // check row
        for (char[] value : board) {
            List<Character> storeChar = new ArrayList<>();
            for (char c : value) {
                if (storeChar.contains(c))
                    return false;
                else if (c != '.')
                    storeChar.add(c);
            }
        }

        // check collumn
        for(int i=0; i<board.length; i++) {
            List<Character> storeChar = new ArrayList<>();
            for (char[] chars : board) {
                if (storeChar.contains(chars[i]))
                    return false;
                else if (chars[i] != '.')
                    storeChar.add(chars[i]);
            }
        }

        // check 3x3
        for(int row=0; row<board.length;) {
            int prevRow = row;
            for(int col=0; col<board.length;) {
                List<Character> storeChar = new ArrayList<>();
                for(int k=0; k<board.length; k++) {
                    if(board[col][row]!='.' && storeChar.contains(board[col][row]))
                        return false;
                    storeChar.add(board[col][row++]);
                    if(row%3 == 0) {
                        row = prevRow;
                        col++;
                    }
                }
                System.out.println(storeChar);
            }
            row += 3;
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Use Hashset
    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.2 MB      -> + 24.94%
    public static boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    // add method in hashset will add and also check unique value
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        System.out.println(seen);
                        return false;
                    }
                System.out.println(seen);
            }
        }
        return true;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.9 MB      -> + 96.49%
    public static boolean isValidSudoku3(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    System.out.println("idx = " + idx + ", hset[i] = " + hset[i]);
                    System.out.println(hset[i] & idx);
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
//                    System.out.println(Arrays.toString(hset));
//                    System.out.println(Arrays.toString(vset));
//                    System.out.println(Arrays.toString(bckt));
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // true case
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        // false
//        char[][] board =
//                {{'.','.','a','.','5','.','.','1','.'}
//                ,{'.','4','.','3','.','.','.','.','.'}
//                ,{'.','.','.','.','.','3','.','.','1'}
//                ,{'8','.','.','.','.','.','.','2','.'}
//                ,{'.','.','2','.','7','.','.','.','.'}
//                ,{'.','1','5','.','.','.','.','.','.'}
//                ,{'.','.','.','.','.','2','.','.','.'}
//                ,{'.','2','.','9','.','.','.','.','.'}
//                ,{'.','.','4','.','.','.','.','.','.'}};

                System.out.println(isValidSudoku2(board));

        // check 3x3 bad version
//        for(int row = 0; row < board.length; row+=3) {
//            for (int i = 0, j = row; i < board.length; ) {
//                System.out.println(i + "-" + j);
//                List<Character> storeChar = new ArrayList<>();
//                int count = 0;
//                while (count < 9) {
//                    if (board[i][j] != '.' && storeChar.contains(board[i][j]))
//                        return false;
//                    else
//                        storeChar.add(board[i][j++]);
//                    if (j % 3 == 0) {
//                        i++;
//                        j = row;
//                    }
//                    count++;
//                }
//                System.out.println(storeChar);
//            }
//        }
        }

}

