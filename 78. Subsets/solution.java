import java.util.* ;
class solution {
    public static void main(String args[]){
        int nums[] = {1,2,3} ;
        int n = nums.length ;
        List<List<Integer>> ans  = new ArrayList<>();
        ans = subsets(nums);
        System.out.println(ans);

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length ;
        
        backtrack(result,new ArrayList<>(),nums,0,n) ;

        return result ;
        
    }

    static void backtrack(List<List<Integer>> powerSet, List<Integer> currentSubset,int[]nums,int i,int n){

        if(i==n){
        powerSet.add(new ArrayList<>(currentSubset));
        return ;
        }

        currentSubset.add(nums[i]);
        backtrack(powerSet,currentSubset,nums,i+1,n);
        currentSubset.remove(currentSubset.size()-1);
        backtrack(powerSet,currentSubset,nums,i+1,n);
    }
}