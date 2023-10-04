class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(),strs.end());
        string s1=strs[0];
        int i=0;
        int j=0;
        string s2=strs[strs.size()-1];
        string LongComPRE="";
        while(i<s1.length()&&j<s2.length()){
            if(s1[i]==s2[i]){
                LongComPRE=LongComPRE+s1[i];
            }
            else{
                break;
            }
            i++;j++;
        }
        return LongComPRE;
    }
};