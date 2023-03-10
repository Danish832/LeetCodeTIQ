import java.util.* ;
class solution {
    public static void main(String args[]){
        // int arr[] = {1,2,0,3,4};
        //int arr[] = {1,2,3,4};
        int arr[] = {-1,1,0,-3,3};
        int n = arr.length ;

        //int ans1[] = productExceptSelf1(arr,n);
        //int ans1[] = productExceptSelf2(arr,n);
        int ans1[] = productExceptSelf3(arr,n);
        for(int i=0 ; i<n ; i++){
            System.out.print(ans1[i]+" "); 
        }
        System.out.println(); 
    }

    static int[] productExceptSelf1(int arr[],int n){
        int prefix = 1 ;
        int suffix = 1 ;
        int zero_case = 1 ;
        double a = 0 ;
        double  b = 0 ;
        int x = 0 ;
        int ans[] = new int [n];
        int z_count = 0 ;
        int f_zero_i = 0 ;

        for(int i=0 ; i<n ; i++){
            if(arr[i]==0){
                f_zero_i = i ;
                z_count++ ;
            }
        }

        if(z_count>1){
            return ans ;
        }

        else if(z_count==0){
                int prod = 1 ;
            for(int i=0 ; i<n ; i++){
                prod = prod*arr[i];
            }
            
            for(int i=0 ; i<n ; i++){
                a = prod ;
                b = Math.pow(arr[i],-1);
                x = (int)(a*b);
                ans[i] = x;
            }

        return ans ;
        }

        else {
            if(z_count==1){
                        for(int i=0 ; i<f_zero_i ; i++){
                            prefix = prefix*arr[i];
                        }
                        for(int i=f_zero_i+1 ; i<n ; i++){
                            suffix = suffix*arr[i];
                        }
                        zero_case = prefix*suffix;

                ans[f_zero_i] = zero_case ;

            }
        }

        return ans ;
        
        
        

    }

    static int[] productExceptSelf2(int arr[],int n){
        int ans[] = new int[n];
        int left[] = new int[n];
        int right[] = new int [n] ;

        int prodleft = 1;
        int prodright = 1 ;
        for(int i=0 ; i<n; i++){
           prodleft = prodleft*arr[i];
           left[i]  = prodleft ;
        }
         for(int i=n-1 ; i>=0; i--){
           prodright = prodright*arr[i];
          right[i]  = prodright ;
        }

    // boundary cases ;
        ans[0] = right[1];
        ans[n-1] = left[n-2];

        for(int i=1 ; i<n-1 ; i++){
            ans[i] = left[i-1]*right[i+1];
        }


        return ans ;

    }


    static int[] productExceptSelf3(int arr[],int n){
        int ans[] = new int[n];
        int left = 1 ;
        int prod = 1 ; 
        for(int i=0 ; i<n ; i++){
            left = left*arr[i];
            ans[i] = left ;
        }
        

        for(int i=n-1 ; i>=1 ; i--){
            ans[i] = ans[i-1]*prod ;
            prod = prod*arr[i];
            
        }
        ans[0] = prod ;

        return ans ;
    }
}