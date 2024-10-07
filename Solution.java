import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(new int[]{1005, 8453, 94585, 7})));
            System.out.println(Arrays.toString(solution.solution(new int[]{1000, 2000, 30000, 50000, 70000, 80000, 3000, 45000})));
        System.out.println(Arrays.toString(solution.solution(new int[]{})));
        }
        public String[] solution(int[] points) {
            int recruit = 0;
            int soldier = 0;
            int warrior = 0;
            int captain = 0;
            int ninja = 0;

            for (int i = 0; i < points.length; ++i) {
                if (points[i] >= 50000) { // Ninja
                    ++ninja;
                }
                else if (points[i] >= 10000 && points[i] <= 49999) { // Captain
                    ++captain;
                }
                else if (points[i] >= 5000 && points[i] <= 9999) { // Warrior
                    ++warrior;
                }
                else if (points[i] >= 1000 && points[i] <= 4999) { // Soldier
                    ++soldier;
                }
                else if (points[i] >= 0 && points[i] <= 999) { // Recruit
                    ++recruit;
                }
            }

            ArrayList<String> result = new ArrayList<>();

            if (ninja != 0) {
                result.add("Ninja - " + ninja);
            }
            if (captain != 0) {
                result.add("Captain - " + captain);
            }
            if (warrior != 0) {
                result.add("Warrior - " + warrior);
            }
            if (soldier != 0) {
                result.add("Soldier - " + soldier);
            }
            if (recruit != 0) {
                result.add("Recruit - " + recruit);
            }

            // sort the levels
            for (int i = 0; i < result.size() - 1; i++) {
                for (int j = i + 1; j < result.size(); j++) {
                    // extract the player count from strings
                    int countI = Integer.parseInt(result.get(i).split(" - ")[1]);
                    int countJ = Integer.parseInt(result.get(j).split(" - ")[1]);

                    // swap if in wrong order
                    if (countJ > countI) {
                        String temp = result.get(i);
                        result.set(i, result.get(j));
                        result.set(j, temp);
                    }
                }
            }


            String[] myArray = new String[result.size()];
            result.toArray(myArray);

            return myArray;
        }
    }





