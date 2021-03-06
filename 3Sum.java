class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // Sorting an array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // handle repetation outside the loop
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                // if sum is equal to 0 then add the triplet to list
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[low], nums[high]);
                    result.add(list);
                    low++;
                    high--;
                    // handling repetation inside the loop
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (sum < 0) { // if sum is less than 0 then move the low pointer
                    low++;
                } else { // if sum is greater than 0 then move high pointer to left
                    high--;
                }

            }
        }

        // return the result list
        return result;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
