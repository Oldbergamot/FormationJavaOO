package be.digitalcity.innverClass;

import java.util.ArrayList;
import java.util.List;

public class Echiquier {

    private String model;

    static class Case {  // cette classe n'a de sens, de raison d'exister que pcq elle vit dans l'échiquier
        private int x;
        private int y;
        private boolean occupied;

        public Case(int x, int y) {
            this.x = x;
            this.y = y;
            this.occupied = false;
        }

        public boolean isOccupied() {
            return occupied;
        }

//        public void afficher(){
//            System.out.println(model);
//        }


    }
    List<Case> liste = new ArrayList<>();
}
