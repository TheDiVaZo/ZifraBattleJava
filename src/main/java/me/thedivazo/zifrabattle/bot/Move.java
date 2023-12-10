package me.thedivazo.zifrabattle.bot;

public interface Move {
    Player getFirstPlayer();
    Player getSecondPlayer();

    /***
     * @return возвращает номер хода.
     */
    int getMoveNumber();

    /***
     * @return число первого игрока
     */
    Number getFirstPlayerNumber();

    /***
     * @return кол-во цифр числа первого игрока, совпавших с цифрами загаданного вторым игроком числа
     */
    int getFirstPlayerMatchNumbers();

    /***
     * @return кол-во этих же цифр {@link Move#getFirstPlayerMatchNumbers()}, но только на своем месте.
     */
    int getFirstPlayerNumbersTheirPlace();

    /***
     * @return число второго игрока
     */
    Number getSecondPlayerNumber();

    /***
     * @return кол-во цифр числа второго игрока, совпавших с цифрами загаданного первым игроком числа
     */
    int getSecondPlayerMatchNumbers();

    /***
     * @return кол-во этих же цифр {@link Move#getSecondPlayerMatchNumbers()}, но только на своем месте.
     */
    int getSecondPlayerNumbersTheirPlace();
}
