package com.lalitbodana.sde.ds.backtracking;

public class GenerateParentheses {

    public static void main(String[] args) {
        generate(1, 1, "");
    }

    public static void generate(int op, int cp, String ans) {
        if (op == 0 && cp == 0) {
            System.out.println(ans);
            return;
        }

        if (op != 0) generate(op - 1, cp, ans + "(");

        if (op < cp) generate(op, cp - 1, ans + ")");


    }
}
