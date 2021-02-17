//import java.util.Scanner;
//
//public class ProgramNew {
//    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        String numberPhone = reader.nextLine();
//        repairNumber(numberPhone);
//    }
//    public static void repairNumber(String numberPhone) {
//        String replaceNumber = numberPhone.replace("+7", "8");
//        replaceNumber = replaceNumber.replace(" ", "");
//        replaceNumber = replaceNumber.replace("+", "");
//        replaceNumber = replaceNumber.replace("(", "");
//        replaceNumber = replaceNumber.replace(")", "");
//        replaceNumber = replaceNumber.replace("-", "");
//        if (replaceNumber.length() != 11) System.out.println("Введен некорректный номер");
//        else System.out.println("Корректный номер: " + replaceNumber);
//    }
//}
