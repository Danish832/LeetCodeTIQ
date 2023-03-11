import java.util.*;
class solution {
    public static void main(String args[]){
        //int arr[] = {3,4,7,2,-3,1,4,2};
        int arr[] = {1,-1,0};
        int n = arr.length ;
        int k = 0 ;
        int ans = subArraySumKcount1(arr,n,k);
        System.out.println(ans);

    }
    static int subArraySumKcount1(int arr[],int n,int k){

        int cnt = 0 ;
        int currSum = 0 ;

        for(int i=0 ; i<n-1 ; i++){
            if(arr[i]==k){
                cnt++ ;
            }
            currSum += arr[i];

            for(int j=i+1 ; j<=n-1 ; j++){
                currSum += arr[j];
                if(currSum==k){
                    cnt++ ;}
            }
            currSum=0 ;
        }

        if(arr[n-1]==k){cnt++ ;}

        return cnt ;
    }

    // static int subArraySumKcount2(int arr[],int n,int k){
        
    //     int sum = 0, cnt = 0;
    //     Map<Integer, Integer> preSum = new HashMap<>();
    //     preSum.put(0, 1);
        
    //     for (int i = 0; i <arr.length; i++) {
    //         currSum +=arr[i];
    //         if (preSum.containsKey(currSum - k)) {
    //             cnt += preSum.get(currSum - k);
    //         }
    //         preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
    //     }
        
    //     return cnt;
    // }
}
