public class RomanNumber {
    private String number;

    public RomanNumber(String num){
        number = num;
    }

    public static boolean isRomanNumber(String number){
        return (number.contains("I") || number.contains("V") || number.contains("X"));
    }

    public int romanToArabic() {
        switch (number){
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: throw new RuntimeException("Недопустимый ввод пользователя");
        }
    }

    public static String arabicToRoman(int arabic){
        int h = arabic / 100;
        int t = (arabic / 10) % 10;
        int o = arabic % 10;

        String hundredsRoman = "";
        String tensRoman = "";
        String onesRoman = "";

        switch (h) {
            case 0 -> hundredsRoman = "";
            case 1 -> hundredsRoman = "C";
        }

        switch (t) {
            case 0 -> tensRoman = "";
            case 1 -> tensRoman = "X";
            case 2 -> tensRoman = "XX";
            case 3 -> tensRoman = "XXX";
            case 4 -> tensRoman = "XL";
            case 5 -> tensRoman = "L";
            case 6 -> tensRoman = "LX";
            case 7 -> tensRoman = "LXX";
            case 8 -> tensRoman = "LXXX";
            case 9 -> tensRoman = "XC";
        }

        switch (o) {
            case 0 -> onesRoman = "";
            case 1 -> onesRoman = "I";
            case 2 -> onesRoman = "II";
            case 3 -> onesRoman = "III";
            case 4 -> onesRoman = "IV";
            case 5 -> onesRoman = "V";
            case 6 -> onesRoman = "VI";
            case 7 -> onesRoman = "VII";
            case 8 -> onesRoman = "VIII";
            case 9 -> onesRoman = "IX";
        }

        String roman = hundredsRoman + tensRoman + onesRoman;
        return roman;
    }
}