package offer.HighQuality;


/*  11. 数值的整数次方
需考虑异常情况的处理 一般有三种：
* 1、 返回值
* 2、全局变量 用来获取错误信息
* 3、抛异常*/
public class Power {
    boolean bInvalidInput = false;

    public boolean GetBInvalidInput(){
        return bInvalidInput;
    }

    private boolean Equal(double num1, double num2){
        if ((num1 - num2 < 0.00001) || (num1 - num2 > -0.00001))
            return true;
        else  return false;
    }


    private double UnSignedPower(double base, int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent; i++){
            result = result * base;
        }
        return result;
    }
    /*高阶版 递归*/
    private double UnSignedPowerex(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = UnSignedPower(base, exponent >> 1);
        if ((exponent & 0x1)== 1)
            result = result * base;
        else  result = result * result;
        return result;
    }

    public double PowerCal(double base, int exponent){
        if(Equal(base, 0.0) && exponent < 0){
            bInvalidInput = true;
            return 0;
        }
        int absExpoent = Math.abs(exponent);
        double result = UnSignedPowerex(base, absExpoent);
        if (exponent < 0){
            result = 1/result;
        }
        return result;
    }

    public static void main(String[] args){
        Power o = new Power();
        System.out.println(o.PowerCal(2.0, 8));
    }
}
