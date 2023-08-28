package com.lld.snakeandladder;

import com.lld.snakeandladder.model.Ladder;
import com.lld.snakeandladder.model.Player;
import com.lld.snakeandladder.model.Snake;
import com.lld.snakeandladder.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no of snakes: ");
        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i=0;i<noOfSnakes;i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter no of ladders ");
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<noOfLadders;i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter no of Players ");
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++) {
            players.add(new Player(scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.startGame();
    }
}
