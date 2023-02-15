class solution {
    public static void main(String args[]){
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4} ;
        int n = arr.length ;
        int maxSum = maxSubarray(arr,n) ;
        int maxSum1 = KadanesAlgo(arr,n) ;
        System.out.println("The sum of maximum sum subarray is :"+maxSum);
        System.out.println("The sum of maximum sum subarray from kadane's algo is :"+maxSum1);
        
    }

    static int maxSubarray (int arr[],int n){ // O(n^2) 
        int maxSum = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i=0 ; i<n-1 ; i++){
            sum+=arr[i];
            for (int j=i+1 ; j<n ; j++){
                sum += arr[j];
                if(sum>maxSum)
                    maxSum = sum ;
            }
            sum = 0 ;
        }
        return maxSum ;
    }

    static int KadanesAlgo (int arr[],int n){ // O(n) 
        int maxSum = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i=0 ; i<n ; i++){
            sum+=arr[i];
            
                if(sum>maxSum)
                    maxSum = sum ;

                if(sum<0)
                    sum = 0 ;
            
            
        }
        return maxSum ;
    }
}