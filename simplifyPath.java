public class Solution {
   		    public String simplifyPath(String path) {
		        // IMPORTANT: Please reset any member data you declared, as
		        // the same Solution instance will be reused for each test case.
		        if (path.length() == 0) return "/";
		        
		        int n = path.length();
		        Deque<String> dq = new ArrayDeque<String>();
		        int i = 0;
		        int start = 0;
		        while (i < n && path.charAt(i) == '/') {
		            i++;
		            start++;
		        }
		        
		        while (i < n) {
		            while (i < n && path.charAt(i) != '/') i++;
		            
		            if (start < i) {
		                String curr = path.substring(start, i);
		                if (curr.equals("..")) {
		                    if(!dq.isEmpty()) dq.removeLast();    
		                }
		                else if (!curr.equals(".")) {
		                    dq.addLast(curr);
		                }
		                i++;
		                start = i;
		                
		            }
		            else {
		                start++;
		                i++;
		            }
		        }
		        
		        // print out the result.
		        StringBuilder sb = new StringBuilder();
		        while (!dq.isEmpty()) {
		            sb.append('/');
		            String curr = dq.getFirst();
		            dq.removeFirst();
		            sb.append(curr);
		        }
		        if (sb.length() == 0) {
		            sb.append('/');
		        }
		        
		        return sb.toString();
		    }
		    
		    private boolean hasOnlyPoints(String str) {
		    	if (str.length() == 0) return false;
		    	
		    	for (int i = 0; i < str.length(); i++) {
		    		if (str.charAt(i) != '.') return false;
		    	}
		    	return true;
		    }
}
