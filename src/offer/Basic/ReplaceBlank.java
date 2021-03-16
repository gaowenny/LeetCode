package offer.Basic;


import javax.sql.rowset.spi.SyncResolver;

/*04、请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。*/
public class ReplaceBlank {

    public static void Replace(char[] str, int usedLength){
        System.out.println(str.length);
        if (str == null || str.length  < usedLength)
            return;

        int blankCount = 0;
        for(int i = 0; i < usedLength; i++){
           if (str[i] == ' ')
               blankCount++;
        }
        int newLength = usedLength + blankCount * 2;
        if (newLength > str.length)
            return;
        int newIndex = newLength - 1;
        int orgIndex = usedLength - 1;
        while (orgIndex >= 0 && newIndex > orgIndex){
            if(str[orgIndex] != ' '){
                str[newIndex--] = str[orgIndex];
            }else {
                str[newIndex--] = '0';
                str[newIndex--] = '2';
                str[newIndex--] = '%';
            }
            orgIndex--;
        }
    }

    public static void main(String[] args){
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        Replace(string, 12);
        System.out.println(string);
    }
}
