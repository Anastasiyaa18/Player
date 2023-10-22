package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void player1Win() {
        Player Alex = new Player(1, "Alex", 500);
        Player Vanya = new Player(2, "Vanya", 630);
        Game game = new Game();

        game.register(Alex);
        game.register(Vanya);

        int expected = 1;
        int actual = game.round("Vanya", "Alex");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void player2Win() {
        Player Alex = new Player(1, "Alex", 500);
        Player Vanya = new Player(2, "Vanya", 730);
        Game game = new Game();

        game.register(Vanya);
        game.register(Alex);


        int expected = 2;
        int actual = game.round("Alex", "Vanya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawBetweenPlayers() {
        Player Alex = new Player(1, "Alex", 250);
        Player Vanya = new Player(2, "Vanya", 250);
        Game game = new Game();

        game.register(Vanya);
        game.register(Alex);


        int expected = 0;
        int actual = game.round("Vanya", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player1NotRegistered() {
        Player Alex = new Player(1, "Alex", 550);
        Player Vanya = new Player(2, "Vanya", 250);
        Game game = new Game();

        game.register(Vanya);
        game.register(Alex);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Petr", "Vanya"));
    }

    @Test
    public void player2NotRegistered() {
        Player Alex = new Player(1, "Alex", 550);
        Player Vanya = new Player(2, "Vanya", 250);
        Game game = new Game();

        game.register(Vanya);
        game.register(Alex);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Alex", "Lida"));
    }

}
