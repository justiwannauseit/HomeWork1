import java.util.Arrays;

/**
 * Работает для массива размерностью 10.
 * Не отчисляйте меня за эту домашку.
 * Это максимум до чего я дошел.
 */
public class ThanosHomeTask {
    public static void main(String[] args) {
        int[] arr = new int[]{97, 25, 42, 90, 71, 16, 82, 39, 78, 89};


        int halfOfArray = arr.length / 2;

        int[] tempArr = distribute(arr);

        System.out.println("сортируем числа всего массива " + Arrays.toString(tempArr));

        int[] leftPartOfArray = distribute(Arrays.copyOfRange(tempArr, 0, halfOfArray));
        System.out.println("сортируем левую часть массива " + Arrays.toString(leftPartOfArray));

        int[] rightPartOfArray = distribute(Arrays.copyOfRange(tempArr, 5, arr.length));
        System.out.println("сортируем правую часть массива " + Arrays.toString(rightPartOfArray));

        int[] halfOfLeftPart = distribute(Arrays.copyOfRange(leftPartOfArray, 0, 3));
        System.out.println("сортируем часть левой части массива " + Arrays.toString(halfOfLeftPart));

        int[] anotherHalfOfLeftPart = distribute(Arrays.copyOfRange(leftPartOfArray, 3, 5));
        System.out.println("сортируем часть левой части массива " + Arrays.toString(anotherHalfOfLeftPart));


        int[] combinedLeftPartAfterSort = combine(halfOfLeftPart, anotherHalfOfLeftPart);
        int[] firstTwoDigitsOfLeft = distribute(Arrays.copyOfRange(combinedLeftPartAfterSort, 0, 2));
        int[] anotherTwoDigitsOfLeft = distribute(Arrays.copyOfRange(combinedLeftPartAfterSort, 2, 4));
        int[] combineLeftPartAfterAnotherSort = combine(firstTwoDigitsOfLeft, anotherTwoDigitsOfLeft, Arrays.copyOfRange(combinedLeftPartAfterSort, 4, 5));
        System.out.println("отсортирована левая часть " + Arrays.toString(combineLeftPartAfterAnotherSort));

        int[] halfOfRightPart = distribute(Arrays.copyOfRange(rightPartOfArray, 0, 3));
        System.out.println("сортируем часть правой части массива " + Arrays.toString(halfOfRightPart));

        int[] anotherHalfOfRightPart = distribute(Arrays.copyOfRange(rightPartOfArray, 3, 5));
        System.out.println("сортируем часть правой части массива " + Arrays.toString(anotherHalfOfRightPart));

        int[] combinedRightPartAfterSort = combine(halfOfRightPart, anotherHalfOfRightPart);
        int[] firstTwoDigitsOfRight = distribute(Arrays.copyOfRange(combinedRightPartAfterSort, 0, 2));
        int[] anotherTwoDigitsOfRight = distribute(Arrays.copyOfRange(combinedRightPartAfterSort, 2, 4));
        int[] combineRightPartAfterAnotherSort = combine(firstTwoDigitsOfRight, anotherTwoDigitsOfRight, Arrays.copyOfRange(combinedRightPartAfterSort, 4, 5));
        System.out.println("отсортирована правая часть " + Arrays.toString(combineRightPartAfterAnotherSort));

        arr = combine(combineLeftPartAfterAnotherSort, combineRightPartAfterAnotherSort);

        System.out.println("финальная сортировка выполнена " + Arrays.toString(arr));
    }

    private static int countAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    private static int[] distribute(int[] array) {
        int min = 0;
        int max = array.length - 1;

        int average = countAverage(array);
        int[] tempArr = new int[array.length];
        if (!(array.length / 2 < 1))
            for (int i = 0; i < array.length; i++) {
                if (array[i] <= average) {
                    tempArr[min] = array[i];
                    min++;
                } else if (array[i] > average) {
                    tempArr[max] = array[i];
                    max--;
                }
            }
        return tempArr;
    }

    private static int[] combine(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }
        int[] result = new int[length];
        int pos = 0;
        for (int[] array : arrays) {
            for (int element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }
}

