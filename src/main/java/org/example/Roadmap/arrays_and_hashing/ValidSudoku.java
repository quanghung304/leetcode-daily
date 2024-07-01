package org.example.Roadmap.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;
//accepted. Beats 60%
public class ValidSudoku {
    //Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    //
    //Each row must contain the digits 1-9 without repetition.
    //Each column must contain the digits 1-9 without repetition.
    //Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    //Note:
    //
    //A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    //Only the filled cells need to be validated according to the mentioned rules.
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','.','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'9','3','.','.','2','.','4','.','.'},
                {'.','.','7','.','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','4','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','.'},
                {'.','.','.','.','.','5','2','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> firstBox = new HashSet<>();
        Set<Character> secondBox = new HashSet<>();
        Set<Character> thirdBox = new HashSet<>();

        Set<Character>[] columns = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashSet<>();
        }

        for (int i=0; i<9; i++) {
            if (i==3 || i==6) {
                firstBox = new HashSet<>();
                secondBox = new HashSet<>();
                thirdBox = new HashSet<>();
            }

            for(int j=0; j<9; j++) {
                if (j == 0) {
                    rowSet = new HashSet<>();
                }

                Character c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (!rowSet.add(c)) {
                    return false;
                }

                if (j < 3) {
                    if (!firstBox.add(c)) {
                        return false;
                    }
                } else if (j<6) {
                    if (!secondBox.add(c)) {
                        return false;
                    }
                } else {
                    if (!thirdBox.add(c)) {
                        return false;
                    }
                }

                if (!columns[j].add(c)) {
                    return false;
                }
            }
        }

        return true;
    }
}
