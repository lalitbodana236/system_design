package com.lalitbodana.sde.ds.recursion.subsequence;

import java.util.List;

public class UniquePaths {

    public static void move(int row, int col, int m, int n, String str, List<String> list) {

        if (row >= m || col >= n) return;

        if (row == m - 1 && col == n - 1) {
            list.add(str);
            return;
        }
        //down
        move(row + 1, col, m, n, str + "d", list);

    }
}
