/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication24;

/**
 *
 * @author khanh
 */
public class JavaApplication24 {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     * 
     * 
     */




    //cau 1:
    public int minLength(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i) + "");
            }
            else{
                String tmp = "";
                tmp = stack.peek() + s.charAt(i) + "";
                if(tmp.equals("AB") || tmp.equals("CD")){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i) + "");
                }
            }
        }
        return stack.size();
    }


    //cau 2:
    public List<List<String>> solve(String[] strs) {
        int [] tmp = new int[strs.length];
        for(int i = 0 ; i < tmp.length ; i++){
            tmp[i] = 0;
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++){
            if(tmp[i] == 0){
                List<String> ans = new ArrayList<>();
                ans.add(strs[i]);
                HashMap<String,Integer> ms = new HashMap<>();
                for(int j = 0 ; j < strs[i].length() ; j++){
                    if(ms.containsKey(strs[i].charAt(j) + "")){
                        int cnt = ms.get(strs[i].charAt(j)+ "");
                        cnt ++;
                        ms.put(strs[i].charAt(j) + "",cnt);
                    }
                    else{
                        ms.put(strs[i].charAt(j) + "",1);
                    }
                }
                for(int j = i+1 ; j < strs.length ; j++){
                    HashMap<String,Integer> ms2 = new HashMap<>();
                    for(int z = 0 ; z < strs[j].length() ; z++) {
                        if (ms.containsKey(strs[j].charAt(z) + "")) {
                            int cnt = ms.get(strs[z].charAt(z) + "");
                            cnt++;
                            ms.put(strs[j].charAt(z) + "", cnt);
                        } else {
                            ms.put(strs[j].charAt(z) + "", 1);
                        }
                    }
                    if(ms.equals(ms2)){
                        ans.add(strs[j]);
                        tmp[j] = 1;
                    }
                }
                res.add(ans);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
    
}
