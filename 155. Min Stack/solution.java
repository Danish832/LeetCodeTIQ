import java.util.*;

class solution {

    public static void main (String args[]){
        MinStack minStack = new MinStack() ;
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
       // minStack.printStack();
        System.out.println(minStack.getMin()) ; // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        //minStack.printStack();
    }
}



class MinStack {

    int arr[] ;
    int top_ptr ;
    int min_ptr ;
    int min[] ;
    

    public MinStack() {
        arr = new int[10000];
        min = new int[10000];
        top_ptr = -1 ;
        min_ptr = -1 ;

    }

    public void printStack(){
        for(int i=0 ; i<=top_ptr ; i++){
            System.out.println(arr[i]);
        }
    }
    
    public void push(int val) {
        if(top_ptr>=10000){
            return ;
        }
        top_ptr++ ;
        arr[top_ptr] = val ;

        if(min_ptr>=0){
            if(min[min_ptr]<val){
                min[min_ptr+1] = min[min_ptr] ;
                min_ptr+=1 ;
            }
            else{
                min[++min_ptr]= val ;
            }
        }
        else{
            min[++min_ptr]= val ;
        }
        
    }
    
    public void pop() {
        if(top_ptr<0){
            return ;
        }
        top_ptr-=1 ;
        min_ptr-=1 ;
        
    }
    
    public int top() {
        return arr[top_ptr];
    }
    
    public int getMin() {

        return min[min_ptr];
    }

    
}