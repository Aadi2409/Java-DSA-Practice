import java.util.*;
import java.io.*;

public class Template {
    static final int MOD = 1_000_000_007;
    static final int mod = 998_244_353;
    static final int MAX = 1_000_015;
    static final long INF = (long) 9e18;
    static Scanner sc = new Scanner(System.in);

    // ------------------------- To read an Array ----------------------------
    static ArrayList<Integer> read(int n,FastReader in) throws IOException {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(in.nextInt());
        }
        return temp;
    }
    // ------------------------- isSorted Function ----------------------------
    static boolean isSorted(ArrayList<Integer> arr){
        for (int i=1;i<arr.size();i++)
        {
            if(arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            solve(in);
        }
    }
    static void solve(FastReader in) throws IOException {
            int n=in.nextInt();
            String s=in.nextLine();
            if(n==1)
            {
                if(s.charAt(0)=='.') System.out.println(1);
                else System.out.println(0);
                return;
            }
            int cnt=0;
        for (int i = 1; i <= n-2; i++) {
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)==s.charAt(i-1) && s.charAt(i)=='.') {
                System.out.println(2);
                return;
            }
            if (s.charAt(i)=='.') cnt++;

        }
        if(s.charAt(0)=='.') cnt++;
        if (s.charAt(n-1)=='.') cnt++;
        System.out.println(cnt);
    }

    // ------------------------- Sieve of Eratosthenes ----------------------------

    static List<Integer> Sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }

    static boolean[] boolSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    static int[] spf() {
        int[] sieve = new int[MAX + 1];
        for (int i = 0; i <= MAX; i++) sieve[i] = i;

        for (int i = 2; i * i <= MAX; i++) {
            if (sieve[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (sieve[j] == j) {
                        sieve[j] = i;
                    }
                }
            }
        }
        return sieve;
    }

    // ------------------------- Modular Exponentiation ----------------------------

    static int modExpo(int a, int b) {
        a %= MOD;
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (int) ((1L * a * a) % MOD);
            b >>= 1;
        }
        return (int) result;
    }

    static int inv(int a) {
        return modExpo(a, MOD - 2);
    }

    // ------------------------- Combinatorics ----------------------------

    static int[] factorial() {
        int[] fact = new int[MAX];
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (int) ((1L * fact[i - 1] * i) % MOD);
        }
        return fact;
    }

    static int ncr(int n, int r, int[] fact) {
        return (int) (((1L * fact[n] * inv((int) ((1L * fact[n - r] * fact[r]) % MOD))) % MOD));
    }

    static int npr(int n, int r, int[] fact) {
        return (int) ((1L * fact[n] * inv(fact[n - r])) % MOD);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ------------------------- Utility Classes ----------------------------

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int[] readArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }
}