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
       // minStack.printStack();
    }
}



class MinStack {

    int arr[] ;
    int top ;
    int min ;
    

    public MinStack() {
        arr = new int[10000];
        top=-1 ;
        min = 0 ;
    }

    public void printStack(){
        for(int i=0 ; i<=top ; i++){
            System.out.println(arr[i]);
        }
    }
    
    public void push(int val) {
        if(top>=10000){
            return ;
        }
        else if(top==-1){
            top++;
            arr[top]  = val ;
            min = val;
        }
        else{
            if(val>min){
                arr[++top] = val ;
            }
            else{
                arr[++top] = (2*val)-min ;
                min = val ;
                
            }
        }
        
    }
    
    public void pop() {
        if(top<=0){
            return ;
        }
        else {
            if(arr[top]>=min){
                top-- ;
            }
            else{
                min = 2*min-arr[top];
                top-- ;
            }
        }
        
    }
    
    public int top() {
        if(arr[top]<min){
            return min;
        }
        else
            return arr[top];
    }
    
    public int getMin() {

        return min;
    }

    
}