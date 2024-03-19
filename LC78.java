class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(nums, 0);
        return result;
    }
    private void backTracking(int[] nums, int start){
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.removeLast();
        }
    }
}

//时间复杂度: O(n * 2^n)
//空间复杂度: O(n)
