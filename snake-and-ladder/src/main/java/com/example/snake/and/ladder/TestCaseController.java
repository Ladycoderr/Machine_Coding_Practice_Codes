package com.example.snake.and.ladder;

import org.springframework.stereotype.Controller;

import java.net.Inet4Address;
import java.util.*;

@Controller
public class TestCaseController {
    public void testcases(){
        Dice dice = new Dice(1);
        Player p1 = new Player("Albert",1);
        Player p2 = new Player("Shivangi",2);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        Jumper snake1 = new Jumper(10,2);
        Jumper snake2 = new Jumper(99,12);
        List<Jumper>snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        Jumper ladder1 = new Jumper(5,15);
        Jumper ladder2 = new Jumper(10,20);
        List<Jumper>ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        Map<String, Integer>playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("Albert", 0);
        playerCurrentPosition.put("Shivangi",0);
        GameBoard gb = new GameBoard(dice,allPlayers,snakes,ladders,playerCurrentPosition,100);
        gb.startGame();
    }
}
