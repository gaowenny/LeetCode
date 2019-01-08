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
    public static void main(String[] args){
        BitAlgorithm o = new BitAlgorithm();
        System.out.print(o.hasAlternatingBits(7));
    }
}
