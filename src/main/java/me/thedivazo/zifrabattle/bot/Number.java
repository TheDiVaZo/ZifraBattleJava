package me.thedivazo.zifrabattle.bot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Number {
    private static final List<Integer> arrayDigits = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
    private static final Random random = new Random();

    private int intNumber;
    private String strNumber;
    /***
     * Метод генерирует случайное четырех-значное число, цифры которого не повторяются.
     * Для этого используется массив, содержащий числа от 0 до 9.
     * Далее случайным образом получается элемент массива, после чего из массива он удаляется.
     * И так происходит еще 3 раза. Из полученных значений строится {@link Number}.
     * @return возвращает случайно сгенерированный {@link Number}.
     */
    public static Number generateRandomNumber() {
        List<Integer> integerArray = new ArrayList<>(arrayDigits);
        int one = integerArray.get(random.nextInt(integerArray.size()));
        integerArray.remove(Integer.valueOf(one));
        int two = integerArray.get(random.nextInt(integerArray.size()));
        integerArray.remove(Integer.valueOf(two));
        int three = integerArray.get(random.nextInt(integerArray.size()));
        integerArray.remove(Integer.valueOf(three));
        int four = integerArray.get(random.nextInt(integerArray.size()));

        int number = one * 1000 + two * 100 + three * 10 + four;

        return new Number(number, StringUtils.leftPad(String.valueOf(number), 4, '0'));
    }

    public static boolean isValidNumber(int number) {
        if (number >= 9876 || number <= 123) return false;

        int one = number / 1000;
        int two = (number - one*1000) / 100;
        int three = (number - one*1000 - two*100) / 10;
        int four = number - one * 1000 - two * 100 - three * 10;
        return one != two && one != three && one != four && two != three && two != four && three != four;
    }

    public static boolean isValidNumber(String number) {
        if (number.length() != 4) return false;

        char[] chars = number.toCharArray();
        return chars[0] != chars[1] && chars[0] != chars[2] && chars[0] != chars[3] && chars[1] != chars[2] && chars[1] != chars[3] && chars[2] != chars[3];
    }

}
