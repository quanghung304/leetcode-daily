package org.example.Roadmap.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//accepted. 55%
public class GenerateParentheses {
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s;
        while (true) {
            s = input.nextInt();
            if (s == 0) {
                break;
            }
            System.out.println(generateParenthesis(s));
        }
        input.close();
    }
    //nhan xet: 1. can phai them ngoac mo '(' vao truoc khi them ngoac dong ')'
    //2. sau khi them 1 ngoac mo, ta co 2 kha nang: them ngoac mo neu so ngoac mo < n; hoac them ngoac dong neu no ngoac dong < so ngoac ngoac mo
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int numOpen = 0, numClose = 0;

        generate(0, 0, "", n, res);

        return res;
    }

    public static void generate(int numOpen, int numClose, String s, int n, List<String> res) {
        if (numOpen ==  numClose && numClose == n) {
            res.add(s);
            return;
        }

            if (numOpen<n) {
                generate(numOpen+1, numClose, s+ "(", n, res);
            }

            if (numClose < numOpen) {
                generate(numOpen, numClose+1, s+ ")", n, res);
            }
    }
}
