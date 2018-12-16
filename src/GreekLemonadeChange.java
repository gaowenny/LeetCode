import java.awt.desktop.ScreenSleepEvent;

public class GreekLemonadeChange {

    public boolean isEnough(int[] AValue, int[] ACount, int AMoney){
        int nNum = 0;
        for (int i = AValue.length - 1; i >= 0; i--){
            int c = AMoney/AValue[i] >= ACount[i]? ACount[i]: AMoney/AValue[i];
            if(c != 0){
                ACount[i] = ACount[i] - c;
            }
            AMoney = AMoney - c * AValue[i];
            nNum = nNum + c;
        }
        return nNum > 0 && AMoney == 0;
    }

    public boolean lemonadeChange(int[] bills) {
        int[] aValue = {5,10,20};
        int[] aCount = {0, 0, 0};
        for (int i = 0; i < bills.length; i++){
          switch (bills[i]){
              case 5:
                  aCount[0]++;
                  break;
              case 10:
                  if(isEnough(aValue, aCount, 5)){
                      aCount[1]++;
                  }else {
                      return false;
                  }
                  break;
              case 20:
                  if(isEnough(aValue, aCount, 15)){
                      aCount[2]++;
                  }else {
                      return false;
                  }
                  break;
          }
        }
        return true;
    }

    public boolean LemonadeChangeOffical(int[] bills){
        int nFive = 0;
        int nTen = 0;

        for (int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                nFive++;
            }else if(bills[i] == 10){
                if (nFive > 0){
                    nFive--;
                    nTen++;
                }else return false;
            }else if(bills[i] == 20){
                if(nFive > 0 & nTen > 0){
                    nFive--;
                    nTen--;
                }else if(nFive >= 3){
                    nFive -= 3;
                }else return false;
            }
        }
        return true;
    }

    public static void main(String[] agrs){
        int[] money = {5,5,5,5,20,20,5,5,20,5};
        int[] value = {5,10,20};
        int[] count = {2,0,1};
        GreekLemonadeChange o = new GreekLemonadeChange();
        System.out.println(o.LemonadeChangeOffical(money));
//        System.out.println(o.isEnough(value, count, 15));
    }
}
