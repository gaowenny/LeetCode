public class DecodeIndex {

//会有内存泄漏
    public String decodeAtIndex(String S, int K) {
        String sDecode = String.valueOf(S.charAt(0));
        for (int i = 1; i < S.length(); i++){
            if (sDecode.length() > K){
                break;
            }
            if (Character.isDigit(S.charAt(i))){
                int n = Integer.parseInt(String.valueOf(S.charAt(i)));
                if(sDecode.length() * n >= K){
                    int nResidue = K % sDecode.length();
                    if (nResidue == 0) {
                        return String.valueOf(sDecode.charAt(sDecode.length() - 1));
                    }else {
                        return String.valueOf(sDecode.charAt(nResidue - 1));
                    }
                } else {
                    String sIndex = sDecode;
                    for(int j = 0; j < n - 1; j++){
                        sDecode = sDecode + sIndex;
                    }}
            }else {
                sDecode = sDecode + String.valueOf(S.charAt(i));
            }
        }
        return  String.valueOf(sDecode.charAt(K - 1));
    }


    //official

    public String decodeAtIndexOffical(String S, int K) {

        long nExtendLength = 0;

        for (int i = 0; i< S.length(); i++){
            if(Character.isDigit(S.charAt(i))){
                nExtendLength = nExtendLength * Integer.parseInt(String.valueOf(S.charAt(i)));
            }else{
                nExtendLength++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);

            K %= nExtendLength;
            if(K == 0 && Character.isLetter(c)){
                return String.valueOf(c);
            }
            if (Character.isDigit(c)){

                nExtendLength = nExtendLength / Integer.parseInt(String.valueOf(S.charAt(i)));
            }else {
                nExtendLength--;
            }
        }
        throw null;
    }


    public static void main(String[] args){
        DecodeIndex o = new DecodeIndex();
        String s = "a2345678999999999999999";
        System.out.println(o.decodeAtIndexOffical(s, 1));

    }
}
