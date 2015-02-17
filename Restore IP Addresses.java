/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

    public List<String> restoreIpAddresses(String s) {
        /*
        0-255
        # of steps: 4
        substring
        */
        List<String> res = new ArrayList<String>();
        if(s==null||s.length()==0){
            return res;
        }
        if(s.length()>12){
            return res;
        }
        
        dfsHelper(res, s, "", 0, 0);
        return res;
        
    }
    private void dfsHelper(List<String> res, String s, String ipstr, int index, int segment){
        if (index == s.length() && segment == 4){
            res.add(ipstr);
            return;
        }
        if (index >= s.length() || segment >=4){
            return;
        }
        for (int len = 1; len <=3 && index+len <= s.length(); len++){
            String temp = s.substring(index, index+len);            //index+len <= s.length()
            if (isValid(temp)){
                if (segment == 0){
                    dfsHelper(res, s, temp, index+len, segment+1);
                }else{
                    dfsHelper(res, s, ipstr+"." + temp, index+len, segment+1);
                }
            }
        }
    }
    
    private boolean isValid(String str){
        int len = str.length();
        //if (len == 0) return false;
        if(len==0||len>3){
            return false;
        }
        if(str.charAt(0)=='0'&&len>1){
            return false;
        }
        int res = Integer.parseInt(str);
        if(res>=0&&res<=255){
            return true;
        }else{
            return false;
        }
    }
