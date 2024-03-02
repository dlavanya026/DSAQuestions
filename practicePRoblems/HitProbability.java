package practicePRoblems;
/*

You're playing Battleship on a grid of cells with R rows and C columns. There are
0 or more battleships on the grid, each occupying a single distinct cell. The cell in the
ith row from the top and jth column from the left either contains a battleship
You're going to fire a single shot at a random cell in the grid.
You'll choose this cell uniformly at random from the R∗C possible cells.
You're interested in the probability that the cell hit by your shot contains a battleship.
Your task is to implement the function getHitProbability(R, C, G) which returns this probability.
Sample test case #1
R = 2
C = 3
G = 0 0 1
    1 0 1
Expected Return Value = 0.50000000

Sample test case #2
R = 2
C = 2
G = 1 1
    1 1
Expected Return Value = 1.00000000
In the first case,
3
3 of the
6
6 cells in the grid contain battleships. Therefore, the probability that your shot will hit one of them is
3
/
6
=
0.5
3/6=0.5.
In the second case, all
4
4 cells contain battleships, resulting in a probability of
1
.
0
1.0 of hitting a battleship.

 */
public class HitProbability {
    public static void main(String[] args) {
        int[][] G={
                {0,0,1},
                {1,0,1}
        };
        getHitProbability(2,3,G);
    }

    public static double getHitProbability(int R, int C, int[][] G) {
        // Write your code here
        int total=R*C;
        int totalBattle=0;
        for(int row=0;row<G.length;row++){
            for(int col=0;col<G[row].length;col++){
                totalBattle+=G[row][col];
            }
        }
        double ans=(double) totalBattle/total;
        System.out.println(ans);
        return ans;
    }

}
