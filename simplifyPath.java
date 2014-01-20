public class Solution {
  public String simplifyPath(String path) {
	        if (path == null || path.length() == 0) return "/";
	        int n = path.length();
	        
	        Deque<String> dq = new ArrayDeque<String>();
	        int start = 0;
	        int end = 0;
	        while (start+1 < n) {
	            end = path.indexOf('/', start+1);
	            if (end == -1) end = n;
	            
	            if (end == start+1) {
	                start = end;
	                continue;
	            }
	            
	            String str = path.substring(start+1, end);
	            if (str.equals("..")) {
	                if (!dq.isEmpty()) {
	                    dq.pollLast();
	                }
	            }
	            else if (!str.equals(".")) {
	                dq.offerLast(str);
	            }
	            
	            start = end;
	        }
	        
	        if (dq.isEmpty()) return "/";
	        StringBuilder sb = new StringBuilder();
	        while (!dq.isEmpty()) {
	            sb.append('/');
	            sb.append(dq.pollFirst());
	        }
	        
	        return sb.toString();
	    }
}
