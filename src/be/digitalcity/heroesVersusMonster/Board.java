package be.digitalcity.heroesVersusMonster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Square [][] board;
    private final short size;
    private List<Monster> monsters;

    public Board(short size) {
        this.board = new Square[size][size];
        this.size = size;
        generateBoard();
        this.monsters = generateMonsters();
    }

    private void generateBoard() {
        generateMap();
        generateMonsters();
    }

    private List<Monster> generateMonsters() {
        List <Monster> monsters = new ArrayList<>();
        short NBMONSTERS = 15;

        //getting random position
        Position position = new Position((short)0,(short)0);
        for (short i = 0 ; i < NBMONSTERS ; i++) {

            position = position.getRandomPosition();
            while(this.board[position.getX()][position.getY()].getSquareType().equals(SquareType.FOREST) || this.board[position.getX()][position.getY()].isOccupied()) {
                position.getRandomPosition();
            }

            if(i%2==0) {
                Orc orc = new Orc(position);
                monsters.add(orc);
                this.board[position.getX()][position.getY()].setOccupied(true);
            }
            if(i%3==0) {
                Wolf wolf = new Wolf(position);
                monsters.add(wolf);
                this.board[position.getX()][position.getY()].setOccupied(true);
            }
            else {
                Whelp whelp = new Whelp(position);
                monsters.add(whelp);
                this.board[position.getX()][position.getY()].setOccupied(true);
            }
        }

        return monsters;
    }

    private void generateMap() {
        Random r = new Random();
        for (short x = 0 ; x < this.board.length ; x++) {
            for (short y = 0 ; y < this.board.length ; y++) {
                if (r.nextInt(10)<8) this.board[x][y] = new Square(SquareType.PLAIN, new Position(x,y));
                else this.board[x][y] = new Square(SquareType.FOREST, new Position(x,y));
            }
        }
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
