import java.util.*;

class solution {

    public static void main (String args[]){
        // int arr[] = {102,4,100,1,101,3,2,1,1};
        // int arr[] = {1,2,3,4,100,101,102};
        int arr[] = {1,1,5,6,2,3,8,7,9};
        // int arr[] = {};
        int n  = arr.length ;
        // int ans = longestSequenceBrute(arr,arr.length);
        // int ans = longestSequenceBetter(arr,arr.length);
        int ans = longestSequenceOptimal(arr,arr.length);
        System.out.println(ans);

    }

    static int longestSequenceBrute(int arr[],int n){
        int longest = 0 ;
        if(n==0)return longest;
        int x;
        int cnt = 1 ;
        for(int i=0 ; i<arr.length ; i++){
           x = arr[i];
           cnt = 1 ;

           while(ls(arr,x+1)==true){
                x=x+1 ;
                cnt = cnt+1 ;
           }
           if(cnt>longest){longest = cnt ;}
        }
        return longest ;
    }

    static boolean ls(int arr[],int num){
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]==num){
                return true ;
            }
        }
        return false ;
    }

    static int longestSequenceBetter(int arr[],int n){
        Arrays.sort(arr);
        int longest = 0 ;
        int lastSmaller = Integer.MIN_VALUE ;
        int cnt=0 ;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]-1 == lastSmaller){
                cnt+=1 ;
                lastSmaller = arr[i];
            }
            else if(arr[i]-1 != lastSmaller){
                cnt = 1; 
                lastSmaller = arr[i];
            }
            longest = Math.max(longest,cnt);
        }
        return longest;
    }

    static int longestSequenceOptimal(int arr[],int n){
        int longest = 0 ;
        int x = 0 ;
        int cnt = 1 ;
        if(n==0)return longest ;

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<arr.length ; i++){
            set.add(arr[i]);
        }
        for(int it: set){
            if(!set.contains(it-1)){
                cnt = 1 ;
                x = it ;
                while(set.contains(x+1)){
                    x = x+1 ;
                    cnt+=1 ;
                }
            }
            longest = Math.max(longest,cnt);
        }

        return longest ;
    }
}