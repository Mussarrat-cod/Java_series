public class linear
{

    public static void main(String[] args)
    {
        int nums[]={4,6,7,8,5,4};
        int target=7;
        int result = learsearch(nums, target);
        System.out.println(result);

    }
    public static int learsearch(int[] nums, int target)
    {
        for (int i=0;i<6;i++)
        {
            if(nums[i]==target)
            {
                System.out.println(i);
                return i;
            }
            
        }
        return -1;

    }
    
}