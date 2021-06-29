//package be.digitalcity.heroesVersusMonster;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Game {
//
//    private final short SIZE = 15;
//    private boolean isOver;
//    private Heroes player;
//    private Board board;
//
//    Game(){
//        this.isOver = false;
//        this.board = new Board(SIZE);
//        this.player = createPlayer();
//    }
//
//    private Heroes createPlayer() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Bonjour fier héros!");
//        String race;
//
//        do {
//            System.out.println("Veuillez choisir votre race (Human/Dwarf)");
//            race = sc.nextLine();
//        }
//        while(!race.equals("Human") && !race.equals("Dwarf"));
//
//        System.out.println("Quel est votre nom?");
//        String name = sc.nextLine();
//        if (race.equals("Human")) return new Human(new Position((short)0,(short)0), name);
//        return new Dwarf(new Position((short)0,(short)0), name);
//    }
//
//
//    public boolean isGameOver() {
//        if(this.board.getMonsters().size()==0 || !this.player.getAlive() || isOver ) return true;
//        return false;
//    }
//
//    public void play() {
//        askDecision();
//    }
//
//    private void checkCombat() {
////        if(board[player.getY()][player.getY()].equals("Orc") ||
////                board[player.getY()][player.getY()].equals("Whelp") ||
////                board[player.getY()][player.getY()].equals("Wolf")) {
////            //logique de combat
////            player.attack(get(player.getX(), player.getY()));
////            get(player.getX(), player.getY()).attack(player);
////        }
//    }
//
//    /*
//    must implement equals
//     */
//
//
//    public void removeEnnemy() {
//        List<Monster> monsters = board.getMonsters();
//        for (Monster m : monsters){
//            if(m.getPosition().equals(player.getPosition()));
//        }
//    }
//
//    public void askDecision() {
//        Scanner sc = new Scanner(System.in);
//
//        //logique de vérification
//        System.out.println("Voulez vous avancer (N,S,E,W), attaquer ou abandonner?");
//        String s = sc.nextLine();
//        if(s.equals("abandonner")) {
//            isOver = true;
//            System.out.println("\u001B[91m"+"you are die");
//        }
//        if(s.equals("attaquer")) {
//            if(checkMonster()) //check if there's a monster on the square
//            player.attack(get(player.getX(), player.getY()));
//            get(player.getX(), player.getY()).attack(player);
//        }
//        else {
//            switch (s){
//                case "N" : movePlayer("N");
//                    break;
//                case "S" : movePlayer("S");
//                    break;
//                case "E" : movePlayer("E");
//                    break;
//                case "W" : movePlayer("W");
//                    break;
//           }
//        }
//    }
//
//    public boolean checkMonster(Position position) {
//
//
//    }
//
//    private void movePlayer(String n) {
//        //board[player.getX()][player.getY()] = "Plain";
//        switch (n) {
//            case "N":
//                if (player.getY() > 0) player.setY((short) (player.getY() - 1));
//                break;
//            case "S":
//                if (player.getY() < 14) player.setY((short) (player.getY() + 1));
//                break;
//            case "E":
//                if (player.getX() < 14) player.setX((short) (player.getX() + 1));
//                break;
//            case "W":
//                if (player.getX() > 0) player.setX((short) (player.getX() - 1));
//                break;
//        }
//        checkCombat();
//        board[player.getX()][player.getY()] = player.getName();
//    }
//
//    public void launch() {
//        while(!this.isGameOver()) {
//            this.displayBoard();
//            this.play();        }
//    }
//
//    public void displayBoard() {
//        String playerColor = "\u001B[92m";
//        for (int y = 0 ; y < board.length ; y ++){
//            System.out.println();
//            for (int x = 0 ; x < board.length ; x++) {
//                if(board[x][y].equals("Plain")) {
//                    System.out.format("%-8s", board[x][y]);
//                }
//                else if(board[x][y].equals("Forest")) {
//                    System.out.format("%-8s",board[x][y]);
//                }
//                else if(board[x][y].equals("Orc")) {
//                    System.out.format("%-8s", board[x][y]);
//                }
//                else if(board[x][y].equals("Whelp")) {
//                    System.out.format("%-8s", board[x][y]);
//                }
//                else if(board[x][y].equals("Wolf")) {
//                    System.out.format("%-8s", board[x][y]);
//                }
//                else if(board[x][y].equals(player.getName())) {
//                    System.out.format("%-8s", playerColor+board[x][y]+"   ");
//                    System.out.print("\u001B[0m");
//                }
//            }
//        }
//        System.out.println();
//    }
//
//}
