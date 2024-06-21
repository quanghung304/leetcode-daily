package org.example;

import java.util.*;

//haven't passed
public class LC20240617 {
    //	Most Profit Assigning Work
    //You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
    //difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
    //worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
    //Every worker can be assigned at most one job, but one job can be completed multiple times.
    //For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker
    // cannot complete any job, their profit is $0.
    //Return the maximum profit we can achieve after assigning the workers to the jobs.
    public static void main(String[] args) {
//        int[] difficulty = {68,35,52,47,86};
//        int[] profit = {67,17,1,81,3};
//        int[] worker = {92,10,85,84,82};
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int jobLength = difficulty.length;
        int workerLength = worker.length;
        int[] sortedWorker = Arrays.stream(worker).sorted().toArray();
        int[][] sortedJobWithProfit = sortJobsWithProfit(difficulty, profit);

        for (int i=0; i<jobLength; i++) {
            difficulty[i] = sortedJobWithProfit[i][0];
            profit[i] = sortedJobWithProfit[i][1];
        }

//        int jobIndex = 0;
        int[] workProfit = new int[workerLength];

        for (int i=0; i<workerLength; i++) {
            int workAbility = sortedWorker[i];
            int jobIndex = 0;
            while (difficulty[jobIndex] > workAbility) {
                if (jobIndex+1 < jobLength && difficulty[jobIndex+1] >= sortedWorker[i]) {
                    jobIndex++;
                } else {
                    break;
                }
            }

            if (difficulty[jobIndex] <= workAbility) {
                workProfit[i] = profit[jobIndex];
            } else {
                workProfit[i] = 0;
            }
        }

        int sum = 0;
        for (int individualProfit: workProfit) {
            sum += individualProfit;
        }

        return sum;
    }

    public static int[][] sortJobsWithProfit(int[] difficulty, int[] profit) {
        int length = difficulty.length;
        // Combine the arrays into a 2D array
        int[][] jobs = new int[length][2];
        for (int i=0; i<length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort the jobs array by the first element (difficulty)
        Arrays.sort(jobs, Comparator.comparingInt((int[] a) -> a[1]).reversed());

        return jobs;
    }
}
