package be.digitalcity.heroesVersusMonster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Character player;
    private List <Monster> ennemies;
    private boolean isOver;
    private short lvl;
    boolean [][] board;

    Game(){
        this.lvl = 1;
        this.isOver = false;
        this.board = new boolean[15][15];
        this.player = createPlayer();
        this.ennemies = new ArrayList<>();
        generateEnemies(lvl);
    }

    private Character createPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bonjour fier héros!");
        String race;

        do {
            System.out.println("Veuillez choisir votre race (Human/Dwarf)");
            race = sc.nextLine();
        }
        while(!race.equals("Human") && !race.equals("Dwarf"));

        System.out.println("Quel est votre nom?");
        String name = sc.nextLine();
        if (race.equals("Human")) return new Human(name);
        return new Dwarf(name);
    }

    private void generateEnemies(short lvl) {
        int nbEnemies = lvl * 10;
        short x = 0;
        short y = 0;
        Random r = new Random();
        for (int i = 0 ; i < nbEnemies ; i++){
            do {
                x = (short) r.nextInt(14);
                y = (short) r.nextInt(14);
            }
            while ( checkPosition(x,y));

            if (i%2==0)this.ennemies.add(new Orc("Orc",x,y));
            else if (i%3==0)this.ennemies.add(new Whelp("Whelp",x,y));
            else this.ennemies.add(new Wolf("Wolf", x, y));
            this.board[x][y] = true;
            System.out.println(this.board[x][y]);
        }
    }

    public boolean checkPosition(short x, short y) {

            switch (x) {
                case 0:
                    return false;
                case 1:
                    return this.board[x-1][y] || this.board[x+1][y] || this.board[x+2][y];
                case 13:
                    return this.board[x-2][y] || this.board[x-1][y] || this.board[x+1][y];
            }
            switch (y) {
                case 0 : return false;
                case 1 :
                    return this.board[x][y-1] || this.board[x][y+1] || this.board[x][y+2];
                case 13 :
                    return this.board[x][y+1] || this.board[x][y-1] || this.board[x][y-2];
            }
        return this.board[x-2][y] || this.board[x-1][y] ||this.board[x+1][y] ||this.board[x+2][y] ||
                this.board[x][y-2] ||this.board[x][y-1] ||this.board[x][y+1] ||this.board[x][y+2];
    }

    public boolean isGameOver() {
        if(this.ennemies.size()==0 || !this.player.getAlive() ) return true;
        return false;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, boolean b) {
        this.board[x][y]=b;
    }

    public void play() {

    }


    public void removeEnnemy() {

    }

    public void displayBoard() {
        for (int y = 0 ; y < board.length ; y ++){
            System.out.println();
            for (int x = 0 ; x < board.length ; x++) {
                System.out.print(board[x][y]+ ",");
            }
        }
    }
}
