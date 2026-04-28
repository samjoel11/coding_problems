class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //pre tank-cost+new gas
        int totgas=0,totcost=0;
        for(int i=0;i<gas.length;i++){
            totgas += gas[i];
            totcost += cost[i];
        }
        if(totgas<totcost){
            return -1;
        }
        int currentgas=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            currentgas += gas[i]-cost[i];
            if(currentgas<0){
                currentgas=0;
                start=i+1;
            }
        }
        return start;    
    }
}