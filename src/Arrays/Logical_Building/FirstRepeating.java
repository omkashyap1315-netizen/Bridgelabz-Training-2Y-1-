package Arrays.Logical_Building;

public class FirstRepeating {
    public static void display(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]+ " ");
        }
    }
    public static int firstRepeating(int arr[])
    {
        for(int i=0; i< arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i]==arr[j])
                {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,3,2,1};
        System.out.println("This is first reap No. firstRepeating(arr)");

    }
}
