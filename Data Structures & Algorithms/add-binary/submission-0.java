class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int s1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int s2 = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = s1 + s2 + carry;
            sb.append(sum % 2);   
            carry = sum / 2;     
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
