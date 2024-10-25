package neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackTracking {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();


        dfs(0, new ArrayList<>(), 0, target, nums, result);

        return result;

    }

    private void dfs(int i, List<Integer> cur, int total, int target, int[] nums, List<List<Integer>> result) {
        if(total == target){
            result.add(cur);
        }

        if(i >= nums.length || total > target){
            return;
        }

        cur.add(nums[i]);
        int index = cur.size() - 1;
        dfs(i, cur, total + nums[i], target, nums, result);
        cur.remove(index);
        dfs(i + 1, cur, total, target, nums, result);


    }

    public boolean exist(char[][] board, String word){
        Set<List<Integer>> path = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(existHelper(path, board, r, c, word, 0)){
                    return true;
                }
            }
        }
       return false;
    }

    public boolean existHelper(Set<List<Integer>> path, char[][] board, int r, int c , String word,  int currPos){
        if(currPos == word.length()){
            return true;
        }

        List<Integer> newPath = new ArrayList<>();
        newPath.add(r);
        newPath.add(c);
        if(r < 0 || c < 0 || r>= board.length || c >= board[0].length
                || String.valueOf(word.charAt(currPos)).equalsIgnoreCase(String.valueOf(board[r][c]))
                || path.contains(newPath)){
            return false;
        }
        path.add(newPath);

        return (
        existHelper(path, board, r + 1, c, word, currPos + 1) ||
        existHelper(path, board, r - 1, c, word, currPos + 1) ||
        existHelper(path, board, r, c + 1, word, currPos + 1) ||
        existHelper(path, board, r, c + 1, word, currPos + 1) );
    }
}
