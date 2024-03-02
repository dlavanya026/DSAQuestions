package Recurssion.Strings;
//input =abc output= abc,bca,cab,acb,bac,cba
public class premutationBasic {
    public static void main(String[] args) {
        permutations("","abc");
        String abc="ab";
        System.out.println("0:0"+abc.substring(0,0));
        System.out.println("0:1"+abc.substring(0,1));
        System.out.println("1:2"+abc.substring(1,2));
        System.out.println("2:2"+abc.substring(2,2));
        System.out.println("0:2"+abc.substring(0,2));
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

}
