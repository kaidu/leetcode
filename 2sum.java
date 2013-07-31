public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        if (numbers.length < 2) { return res; }
        
        int len = numbers.length;
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            dict.put(target-numbers[i], i);
        }
        
        for (int i = 0; i < len; i++) {
            if (dict.containsKey(numbers[i])) {
                int index1 = dict.get(numbers[i])+1;
                int index2 = i+1;
                if (index1 == index2) { continue; }
                if (index1 > index2) {
                    res[0] = index2;
                    res[1] = index1;
                }
                else {
                    res[0] = index1;
                    res[1] = index2;
                }
                break;
            }
        }
        
        return res;
    }
}
