class Solution {
    public boolean isPowerOfFour(int n) {
        int count=0;
        if(n<=0){
            return false;
        }
        while(n>1){
            if(n%4!=0){
                return false;
            }
            n/=4;
        }
        return true;
    }
}