package Stack;

public class Main {
    static void main(String[] args) {
       StackOps2 st=new StackOps2();
       st.push(10);
       st.push(20);
       st.push(30);
       st.push(40);
       st.push(50);

       st.display();
        System.out.println();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();

        System.out.println("After removing the top element ");
        st.display();
        System.out.println();
        System.out.println("This is my top element :- "+ st.peek());
    }
}
