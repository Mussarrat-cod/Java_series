public class binary {
    public static void main(String[] args)
    {
        int nums[]={4,6,8,9,13};
        int target=9;
        int result= binasearch(nums, target);
        System.out.println(result);
        
 
    }

    public static int binasearch(int nums[] , int target)
    {
        
        int first=0;
        int last=nums.length-1;
        int mid;;
        while(first<=last)
        {
            mid=(first+last)/2;
            if(nums[mid]==target)
            {
                return mid;

            }
           
            else if(nums[mid]<target)
            {
            first=mid+1;
            }
            else
            {
                last=mid-1;
            }
           
        }
        return -1;
     }
}
