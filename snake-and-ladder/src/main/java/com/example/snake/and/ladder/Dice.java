package com.example.snake.and.ladder;

import lombok.*;

import java.util.Scanner;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Dice {
    private int numberOfDice;
    int rollDice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dice roll value (1-6): ");
        return scanner.nextInt();
    }
    int rollDice1(){
        return ((int)(Math.random() * 6 *numberOfDice - 1 * numberOfDice) +1);
    }
}
