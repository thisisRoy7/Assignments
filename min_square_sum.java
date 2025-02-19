import java.util.HashMap;
import java.util.Scanner;

class min_square_sum {
    int minvalue(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        while (k>0) {
            char ch = max(map);
            map.put(ch, map.get(ch)-1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
            k--;
        }

        int min = 0;
        for (int value : map.values()) {
            min += value * value;
        }
        return min;
    }

    char max(HashMap<Character, Integer> map) {
        int m = 0;
        char n = ' ';
        for (char ch : map.keySet()) {
            int x = map.get(ch);
            if (x>m) {
                m = x;
                n = ch;
            }
            
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str = sc.nextLine();
        System.out.println("Enter k:");
        int k = sc.nextInt();
        sc.close();
        min_square_sum A = new min_square_sum();
        System.out.println(A.minvalue(str, k));
    }
}