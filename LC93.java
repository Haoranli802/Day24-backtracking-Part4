class Solution {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb, 0, 0);
        return result;
    }
    private void backTracking(StringBuilder s, int dot, int start){
        if(dot == 3 && isValid(s, start, s.length() - 1)){
            result.add(s.toString());
        }
        for(int i = start; i < s.length(); i++){
            if(isValid(s, start, i)){
                s.insert(i + 1, '.');
                backTracking(s, dot+1, i+2);
                s.deleteCharAt(i+1);
            }
            else break;
        }
    }
    private boolean isValid(StringBuilder s, int start, int end){
        if(start > end) return false;
        if(s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for(int i = start; i <= end; i++){
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if(num > 255)
                return false;
        }
        return true;
    }
}

//时间复杂度: O(3^4 * n)，IP地址最多包含4个数字，每个数字最多有3种可能的分割方式，则搜索树的最大深度为4，每个节点最多有3个子节点。
//空间复杂度: O(n)
