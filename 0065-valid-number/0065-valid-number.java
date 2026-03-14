class Solution {
    public boolean isNumber(String s) {
        String[] sarr= s.split("[eE]",-1);
        if(sarr.length==0 || sarr.length>2)return false;
        for(int i=0;i<sarr.length;i++){
            if(!isvalid(sarr[i],i))return false;
        }
        return true;
    }
    public boolean isvalid(String s,int ind) {
        int pointcount=0,digcount=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='+' || cur=='-'){
                if(i==0)continue;

                else return false;
            }
            if(cur=='.'){
                if(pointcount>=1 || ind==1)return false;
                pointcount++;
            }
            else if(!Character.isDigit(cur))return false;
            else {
                digcount++;
            }
        }
        if(digcount==0)return false;
        return true;
    }
}