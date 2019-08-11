public class BitAlgorithm {

    public int hammingWeight(int n) {
        int count = 0;
        //还原原码
        long x = n & 0x0FFFFFFFFl;
        while (x != 0){
            if((x & 1) != 0){
                count++;
            }
            x = x >> 1;
        }
       return  count;
    }

    public boolean hasAlternatingBits(int n) {
        boolean bResult = true;
        while (n != 0){
            if ( n%2 == (n/2)%2){
                bResult = false;
                break;
            }
            n = n >> 1;
        }
        return bResult;
    }

    public boolean isPowerOfTwo(int n) {
        boolean r = false;
        if((n>0) && (n &(n-1)) == 0){
            r = true;
        }
        return r;
    }
    public boolean isPowerOfFour(int num) {
        if((num<=0) || (num&(num-1)) != 0){
            return false;
        }
        return (num & 0x55555555) != 0;
    }
    public static void main(String[] args){
        BitAlgorithm o = new BitAlgorithm();
        System.out.print(o.isPowerOfFour(6));
    }
}
