// 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
// s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
// s1 = AABCD, s2 = CDAA
// Return : true

class Solution {
    public boolean rotateContains(String s1,String s2) {
        if(s1 == null||s2 == null||s1.length()  <  s2.length()) {
            return false;
        }
        StringBuilder sb=new StringBuilder(s1);
        sb.append(s1);
        return sb.toString().contains(s2);
    }
}

class Solution {
    public boolean rotateContains(String s1,String s2) {
        if(s1 == null||s2 == null||s1.length()  <  s2.length()) {
            return false;
        }
        for(int i = 0; i < s1.length(); i++) {//以s1的每个字符都作为匹配首部进行循环匹配
            int j = 0;
            for(; j < s2.length(); j++) {
                if(s2.charAt(j) != s1.charAt((i + j) % s1.length())) {
                    break;
                }
            }
            if(j == s2.length()) {
                return true;
            }
        }
        return false;
    }
}
