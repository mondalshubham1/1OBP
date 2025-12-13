import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] meetings = {{2,4}, {3,5}, {8,9}, {6,10}, {3,7}, {5,6}};
        //boolean[] result = {true, true, true, true, false, false};
        // Meeting conflicts are allowed upto 1 conflict
        /*
            [0,1,2,3, 4, 5, 6,7,8, 9, 10, 11,12,13]
            [0,0,1,2,2, 1, 1,1,2, 2, 1, 0, 0, 0]
         */
        List<int[]> res = meetingsConducted(meetings);

        for(int[] m : res) {
            System.out.println("MIP : "  + m[0] + " , " + m[1]);
        }
    }

    static List<int[]> meetingsConducted(int[][] meetings) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        return result;
    }
}