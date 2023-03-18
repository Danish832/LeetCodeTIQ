import java.util.*;

class solution {

    public static void main (String args[]){
        // int gas[] = {1,2,3,4,5};
        // int cost[] = {3,4,5,1,2};
        int gas[] = {7, 1, 0, 11, 4};
        int cost[] = {5, 9, 1, 2, 5};
        // int gas[] = {2,3,4};
        // int cost[] = {3,4,3};
        int ans = canCompleteCircuit(gas,cost);
        System.out.println(ans);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int pos = 0;
        for(int i=0 ; i<gas.length ; i++){
            sum += gas[i]-cost[i] ;

            if(sum<0){
                pos = i+1 ;
                total += sum ;
                sum=0 ;
            }

        }
        total+=sum ;
        if(total>=0) {return pos;}

        return -1 ;

    }
}