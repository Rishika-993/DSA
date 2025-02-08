// Problem: FootSteps
/*
 * A child's parent goes for a jog every morning. The child follows the parent several minutes later.
 *  The parent starts at a position that is X1 meters away from their home and runs in a straight line at a constant speed of V1 meters per step for N steps. 
 * The child is standing X2 metres away from their home. They wonder how fast they must run at a constant speed of V2 metres per step to achieve a maximum F,
 where F equals the number of their parents footsteps that the child will land on during their run. 
 The first step that the child will land on from their starting position have been landed on by their parent. 
 Note that if more than one prospective speed results in the same number of maximum common steps, output the highest prospective speed as V2.
Question
Write an algorithm to calculate F and V2.
Input
The first line of the input consists of an integer parentPos, representing the initial position of the child's parent (X1).
The second line consists of an integer-childPos, representing the initial position of the child (X2)
speed.The third line consists of an integer -velParent, representing the speed of the parent (V1).
The last line consists of an integer -steps, representing the number of steps taken by the parent (N)
Output
Print two space-separated integers representing the maximum number of common footsteps Fand respective speed V2
Constraints
1 <= parentPos ≤ 105
0 <=childPoss <= parentPos
1 ≤ velParents <=10^4
1 ≤ steps ≤ 10^4
Example
Input:
3
2
2
20
Output:
21 1
 */


import java.util.*;

public class FootSteps {
    public static int[] max_common_step(int x1, int x2, int v1, int N) {
        // storing position for parents step, we should use hashset as we need to store only one value and in ascending order
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            hp.put(x1 + v1 * i, i);
        }
        int maxF = 0;
        int bestV2 = 0;
        for (int v2 = 1; v2 <= (x1 - x2); v2++) {
            int pos = x2;
            int count = 0;
            while (pos <= x1 + N * v1) {
                if (hp.containsKey(pos)) {
                    count++;
                }
                pos += v2;
            }
            if (count > maxF || (count == maxF && v2 > bestV2)) {
                maxF = count;
                bestV2 = v2;
            }
        }
        return new int[] { maxF, bestV2 };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v1 = sc.nextInt();
        int N = sc.nextInt();
        sc.close();

        int[] result = max_common_step(x1, x2, v1, N);
        System.out.println(result[0] + " " + result[1]);
    }
}