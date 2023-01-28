class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set  = new HashSet<>() ;
        boolean ishappy = false ;
        boolean nothappy = false ;
        int last = 0 ;
        int sum = 0 ;
        //int n = 32 ;
        while(!ishappy && !nothappy){
            last = n%10 ;
            sum = sum + (last)*(last) ;
            n=n/10 ;

            if(n==0 && sum!=1){
                if(set.contains(sum)){
                    nothappy = true ;
                }
                else {
                    set.add(sum) ;
                }
                n = sum ;
                sum = 0 ;
            }
            else if(n==0 && sum==1){
                ishappy = true ;
            }
        }
       
        return ishappy ;
    }
}