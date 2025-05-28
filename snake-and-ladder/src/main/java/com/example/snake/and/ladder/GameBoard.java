package com.example.snake.and.ladder;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameBoard {
    private Dice dice;
    private Queue<Player>nextTurn;
    private List<Jumper> snakes;
    private List<Jumper>ladders;
    private Map<String,Integer>playersCurrentPosition;
    int boardSize;

    void startGame() {

        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;
            if (nextCell > boardSize) nextTurn.offer(player);
            else if (nextCell == boardSize) {
                System.out.println(player.getPlayerName() + "Has Won the Game");
            } else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextCell;
                snakes.forEach((v) -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                    }
                });
                if (nextPosition[0] != nextCell)
                    System.out.println("The player" + player.getPlayerName() + "Has Bitten by a snake");
                ladders.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[0] = true;
                    }
                });
                if (nextPosition[0] != nextCell && b[0])
                    System.out.println("The Player " + player.getPlayerName() + " got a Ladder");
                if (nextPosition[0] == boardSize) {
                    System.out.println("Player" + player.getPlayerName() + "has won the game");
                } else {
                    playersCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName() + "is at position " + nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}
