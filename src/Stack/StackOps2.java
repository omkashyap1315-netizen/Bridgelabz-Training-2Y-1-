package Stack;

public class StackOps2 {
    int arr[]=new int[5];
    int top=0;

    public void push(int data)
    {
        if(top==arr.length)
        {
            System.out.println("Stack is Full ");
            return;
        }
     arr[top]=data;
     top++;
    }

    public int pop()
    {
        if(top==0)
        {
            System.out.println("Stack Under flow");
            return -1;
        }
        int data;
        top--;
        data=arr[top];
        arr[top]=0;

        return data;
    }

    public void display()
    {
       for(int i : arr)
       {
           System.out.print(i+" ");
       }
    }

    public int peek()
    {
        return arr[top--];
    }
}
