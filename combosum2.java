class combosum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // important for skipping duplicates
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] arr, int idx, int remain, List<Integer> path, List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0 || idx == arr.length) return;

        // Option 1: take arr[idx]
        path.add(arr[idx]);
        backtrack(arr, idx + 1, remain - arr[idx], path, ans);
        path.remove(path.size() - 1);

        // Option 2: skip arr[idx] and skip all duplicates
        int next = idx + 1;
        while (next < arr.length && arr[next] == arr[idx]) next++;
        backtrack(arr, next, remain, path, ans);
    }
}