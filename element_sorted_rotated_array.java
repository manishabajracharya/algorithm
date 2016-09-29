
//Find element in sorted rotated array

int rotated_sorted_array_search(int arr[], int low, int high, int target)
{
    while(low<=high)
    {
        int mid = (low+high)/2;

        if(target == arr[mid])
            return mid;

        if(arr[low] <= arr[mid])
        {
            if(arr[low]<=target && target < arr[mid])
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        else
        {
            if(arr[mid]< target && target <=arr[high])
            {
                low = mid+1;
            }
            else
                high = mid-1;
        }
    }
    return -1;
}