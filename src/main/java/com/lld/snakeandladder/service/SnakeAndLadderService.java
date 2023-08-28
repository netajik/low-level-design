package com.lld.snakeandladder.service;

import com.lld.snakeandladder.model.Board;
import com.lld.snakeandladder.model.Ladder;
import com.lld.snakeandladder.model.Player;
import com.lld.snakeandladder.model.Snake;

import java.util.*;

public class SnakeAndLadderService {
    private Board board;
    private Integer initialNoOfPlayers;
    private Queue<Player> players;
    private Boolean isGameCompleted;

    private Integer noOfDices;
    private Boolean shouldGameContinueTillLastPlayer;
    private Boolean shouldAllowMultipleDiceRollOnSix;
    private static final Integer DEFAULT_BOARD_SIZE = 100;
    private static final Integer DEFAULT_NO_OF_DICES = 1;

    public SnakeAndLadderService(Integer size) {
        this.board = new Board(size);
        this.players = new LinkedList<>();
        this.noOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;
    }

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

    public void setNoOfDices(Integer noOfDices) {
        this.noOfDices = noOfDices;
    }

    public void setShouldGameContinueTillLastPlayer(Boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRollOnSix(Boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.initialNoOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<>();
        for(Player player: players) {
            this.players.add(player);
            playerPieces.put(player.getId(),0);
        }
        this.board.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        this.board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        this.board.setLadders(ladders);
    }

    private Boolean isGameCompleted() {
        // Can use shouldGameContinueTillLastPlayer to change the logic of determining if game is completed (Optional requirements)
        Integer currentPlayers = this.players.size();
        System.out.println(currentPlayers < this.initialNoOfPlayers);
        return currentPlayers < this.initialNoOfPlayers;
    }

    private Integer getTotalDiceValue() {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        return DiceService.roll();
    }

    private Integer getNewPosition(Integer newPosition) {
        int previousPosition;
        do {
            previousPosition = newPosition;
            for(Snake snake: this.board.getSnakes()) {
                if(snake.getStart() == newPosition){
                    newPosition = snake.getEnd();
                }
            }

            for(Ladder ladder: this.board.getLadders()) {
                if(ladder.getStart() == newPosition){
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != previousPosition);
        return newPosition;
    }

    private void movePlayer(Player player, Integer position) {
        int oldPosition = this.board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition+position;
        int boardSize = this.board.getSize();

        if(newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPosition(newPosition);
        }
        this.board.getPlayerPieces().put(player.getId(), newPosition);
        System.out.println(player.getName()+" rolled a "+ position +" and moved from "+ oldPosition+" to "+newPosition);
    }

    private Boolean hasPlayerOwnTheGame(Player player){
        Integer playerPosition = this.board.getPlayerPieces().get(player.getId());
        Integer boardSize = this.board.getSize();
        return playerPosition == boardSize;
    }

    public void startGame() {
        System.out.println("Game started..!");
        while(!isGameCompleted()) {
            Integer totalDiceValue = getTotalDiceValue();
            Player player = players.poll();
            movePlayer(player,totalDiceValue);
            if(hasPlayerOwnTheGame(player)) {
                System.out.println(player.getName()+" wins the game");
                this.board.getPlayerPieces().remove(player.getId());
            } else {
                this.players.add(player);
            }
        }
    }
}
