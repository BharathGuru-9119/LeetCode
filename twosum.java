import java.util.HashMap;

public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {}; 
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers sum to target.");
        }
    }
}
