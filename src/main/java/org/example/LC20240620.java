package org.example;

import java.util.Arrays;

//passed. Beat 97.35%
public class LC20240620 {
    //Magnetic Force Between Two Balls
    //In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in
    //his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs
    //to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
    //Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
    //
    //Given the integer array position and the integer m. Return the required force.

    //Solution: max - min problem so we gonna think about binary search technique.
    //Binary search technique: define a max and min possible answer. Then use binary search to find the best answer that
    //satisfy the problem's condition
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low=1; //min distance: all balls're next to each other
        int high = (position[position.length-1] - position[0])/(m-1); //max distance
        int possibleAnswer = high;

        //binary search
        while (low<high) {
            int mid = (high+low)/2;
            boolean possible = canDistribute(position, m, mid);
            if (!possible) {
                high=mid;
            } else {
                possibleAnswer = mid;
                low = mid+1;
            }
        }

        if (low==high && canDistribute(position, m, low)) {
            return low;
        }

        return possibleAnswer;
    }

    //true if the balls can be distributed by distance
    public static boolean canDistribute(int[] position, int m, int distance) {
        int index = 0;
        int ballCount = 1;
        for (int i=0; i< position.length; i++) {
            if(position[i] - position[index] >= distance) {
                index = i;
                ballCount++;
            }

            if (ballCount == m) {
                return true;
            }
        }

        return false;
    }
}
