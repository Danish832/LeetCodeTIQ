import java.util.*;

class solution {

    public static void main (String args[]){
        int nums[] = {3,8,4,1,2} ;
        // int nums[] = {1,2,3,4,3} ;
        int ans[] = new int[nums.length];
        int n = nums.length;
        int x = 0 ;
        int y = 0 ;
        Stack<Integer> st = new Stack<>() ;

        for(int i=n-2  ; i>=0 ; i--){
            while(st.size()!=0 && st.peek()<=nums[i]){
                x++;
                st.pop() ;
            }
            st.push(nums[i]);
            
        }
        for(int i=n-1  ; i>=0 ; i--){
            while(st.size()!=0 && st.peek()<=nums[i]){
                y++;
                st.pop() ;
            }
            ans[i] = st.size()==0?-1 : st.peek();
            st.push(nums[i]);
            
        }
        for(int i=0 ; i<n ; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        System.out.println(x);
        System.out.println(y);

    }
}