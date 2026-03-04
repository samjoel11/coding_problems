class comboSum {
    void generate(int i,int target,List<Integer>l,int[]candidates,List<List<Integer>>ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        if(target<0 || i>=candidates.length)
        return;
        
        if(target>=candidates[i])
        {
            l.add(candidates[i]);
            generate(i,target-candidates[i],l,candidates,ans);
            l.remove(l.size()-1);
        }
        generate(i+1,target,l,candidates,ans);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>t=new ArrayList<>();
        generate(0,target,t,candidates,ans);
        return ans;
    }
}