package me.cire3.drafts;

import me.cire3.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class DFunction {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("6\n" +
                "0 1 4\n" +
                "0 2 7\n" +
                "1 2 1\n" +
                "1 2 3\n" +
                "582 74663 3\n" +
                "0 3 1\n"));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long sol = 0;

            if (k >= 10) {
                System.out.println(l == 0 ? 9 : 0);
                continue;
            }

            if (k == 1) {
                System.out.println((long)(Math.pow(10, r)) - (long)(Math.pow(10, l)));
                continue;
            }

            int maxDigit = (int) Math.floor(10D / k);

            System.out.println(getResult(l, r, maxDigit));
        }
    }

    public static BigInteger pow(BigInteger num, BigInteger pow) {
        BigInteger result = num;
        if (pow.compareTo(new BigInteger("0")) < 0)
            throw new IllegalArgumentException();
        if (pow.compareTo(new BigInteger("0")) == 0)
            return new BigInteger("1");
        while ((pow = pow.subtract(new BigInteger("1"))).compareTo(new BigInteger("0")) > 0) {
            result = result.multiply(num);
        }
        return result;
    }

    // FIXME very very very slow
    public static String getResult(long l, long r, long maxDigit) {
        long modulus = (long) (Math.pow(10, 9) + 7);
        BigInteger result = BigInteger.ZERO;
        BigInteger mDPlusOne = BigInteger.valueOf(maxDigit + 1);
        long digits = r;

        while (digits > 0) {
            digits--;
            result = result.add(pow(mDPlusOne, BigInteger.valueOf(digits)));
        }

        if (l != 0) {
            while (l > 0) {
                l--;
                result = result.subtract(pow(mDPlusOne, BigInteger.valueOf(l)));
            }
        }

        result = result.multiply(new BigInteger(String.valueOf(maxDigit)));

        return result.mod(BigInteger.valueOf(modulus)).toString();
    }
}
