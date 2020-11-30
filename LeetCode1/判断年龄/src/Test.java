public class Test {
    public static String judegyear(int num){
        if(num < 18){
            return "少年";
        }else {
            if (num <= 18 && num <= 28){
                return "青年";
            }else {
                if (num > 28 && num <=55){
                    return "中年";
                }else {
                    return "老年";
                }
            }
        }
    }
}
