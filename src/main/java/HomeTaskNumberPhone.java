import java.util.Arrays;

public class HomeTaskNumberPhone {
    public static void main(String[] args) {

        String phoneNumber = "8 (800) 555 - 25 - 11";
        String[][] arr = new String[][]{{checkNumbers(phoneNumber)}, {getChanges(phoneNumber)}};
        System.out.println(Arrays.deepToString(arr)); //Arrays использовал только для вывода в консоль (самопроверка)
    }

    public static String checkNumbers (String phoneNumber){  //Проверка номера на корректность
        String checkNumber = "";
        if (phoneNumber.replace("+7", "8").replaceAll("[- _():=+]", "").length()!=11){
            checkNumber = "Введен некоректный номер";
        }
        else checkNumber = phoneNumber.replace("+7", "8").replaceAll("[- _():=+]", "");
        return checkNumber;
    }

    public static String getChanges(String phoneNumber) { // Здесь его редактируем, проверяем, отдаем результат
        String builder = ""; //сборщик изменений в номере телефона
        String tmp = phoneNumber; // сохраняем в памяти для сравнения
        String formattedNumber = phoneNumber; // форматируем номер

        if (phoneNumber.contains("+7")) {
            formattedNumber = formattedNumber.replace("+7","8");
            builder += "+7 заменен на 8; ";
        }
        if (phoneNumber.contains(")") || phoneNumber.contains("(")) {
            formattedNumber = formattedNumber.replaceAll("[()]","");
            builder += "Убраны скобки; ";
        }
        if (phoneNumber.contains("-")) {
            formattedNumber = formattedNumber.replace("-","");
            builder += "Убраны знаки тире; ";
        }
        if (phoneNumber.contains(" ")) {
            formattedNumber = formattedNumber.replace(" ","");
            builder += "Убраны пробелы";
        }
        if(formattedNumber.equals(tmp)) builder = "Изменений не было";

        return builder;
    }
}