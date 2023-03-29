import java.util.*;

class solution {

    public static void main (String args[]){
        // int arr[] = {-1,-2,1,3,1,2,-3,3};
        // int arr[] = {10,2,-5};
        int arr[] = {-2,-2,1,-2};
        int n = arr.length ;

        int ans[] = asteriodCollision(arr,n);
        for(int i=0 ; i<ans.length ; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    static int[] asteriodCollision(int arr[],int n){
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            
            if(arr[i]>0 ){
                st.push(arr[i]);
            }

            else{
                
                   while( st.size()>0 && Math.abs(arr[i])>st.peek() && st.peek()>0){
                    st.pop();
                   }
                   if(st.size()>0 && Math.abs(arr[i])==st.peek()){
                    st.pop();
                   }
                   else if(st.size()>0 && Math.abs(arr[i])<st.peek()){

                   }
                   else{
                    st.push(arr[i]);
                   }
                
            }
        }

        int ans[] = new int[st.size()];
        int k = st.size()-1 ;
        while(st.size()!=0){
            ans[k] = st.pop();
            k--;
        }
        return ans;
    }
}