class Solution {
    public String simplifyPath(String path) {
        List<String> arr = new ArrayList<>();
        int i = 0;

        while (i < path.length()) {
            StringBuilder cur = new StringBuilder();
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            
            while (i < path.length() && path.charAt(i) != '/') {
                cur.append(path.charAt(i));
                i++;
            }
            
            String current = cur.toString();

            if (current.equals("..")) {
                if (!arr.isEmpty()) {
                    arr.remove(arr.size() - 1); 
                }
            } else if (!current.equals("") && !current.equals(".")) {
                arr.add(current);
            }
        }

        StringBuilder result = new StringBuilder("/");

        for (int j = 0; j < arr.size(); j++) {
            result.append(arr.get(j));
            if (j < arr.size() - 1) {
                result.append("/");
            }
        }

        return result.length() == 1 ? "/" : result.toString(); 
    }
}
