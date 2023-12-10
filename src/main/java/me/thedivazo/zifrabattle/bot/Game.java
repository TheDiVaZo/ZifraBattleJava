package me.thedivazo.zifrabattle.bot;

public interface Game {
    /***
     * @return ходы игроков, начиная с самого первого
     */
    Move[] getMovies();
    Player getOnePlayer();
    Player getTwoPlayer();

    /***
     * @return загаданное первым игроком число
     */
    Number getOnePlayerNumber();

    /***
     * @return загаданное вторым игроком число
     */
    Number getTwoPlayerNumber();
    TypeGame getTypeGame();
}
