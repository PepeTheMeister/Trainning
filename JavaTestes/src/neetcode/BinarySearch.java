package neetcode;

public class BinarySearch {

    public static int findMin(int[] nums){

        int l = 0;
        int r = nums.length -1;

        int mid = nums[nums.length / 2];
        int min = nums[nums.length / 2];

        while(l < r){
            if(nums[l] < nums[r]){
                r--;
                min = Math.min(nums[l], min);
            }
            else{
                min = Math.min(nums[r], min);
                l++;
            }
        }

        return min;
    }

    public static int search(int[] nums, int target){
        int result = -1;

        int l = 0;
        int r = nums.length - 1;

        if(nums[(nums.length - 1) / 2] == nums[target]) {
            return nums[target];
        }

        while(l <= r){
            if(nums[l] == target){
                result = l;
                break;
            }
            else if(nums[r] == target){
                result = r;
                break;
            }
            l++;
            r--;

        }

        return result;
    }

    public static int searchSecondSolution(int[] nums, int target){
        int result = -1;

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return mid;
            }

            if (nums[mid] >= nums[l]) {
                if(target > nums[mid] || target < nums[l]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            else{
                if(target < nums[mid] || target > nums[r]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }

            }

        }

        return -1;
    }


}
