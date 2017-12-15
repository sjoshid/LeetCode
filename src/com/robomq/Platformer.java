package com.robomq;

public class Platformer {

   int[] tiles;
   int position;

    public Platformer(int n, int position) {
        tiles = new int[n];
        this.position = position;
    }

    public void jumpLeft() {
        int newPosition = position - 2;
        while(tiles[newPosition] == -1){
            newPosition--;
        }
        tiles[position] = -1;
        position = newPosition;
    }

    public void jumpRight() {
        int newPosition = position + 2;
        while(tiles[newPosition] == -1){
            newPosition++;
        }
        tiles[position] = -1;
        position = newPosition;
    }

    public int position() {
        return position;
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(10, 0);
        platformer.jumpRight();
        System.out.println(platformer.position());
        platformer.jumpRight();
        System.out.println(platformer.position());
        platformer.jumpRight();
        System.out.println(platformer.position());
        platformer.jumpRight();
        System.out.println(platformer.position());


        platformer.jumpLeft();
        System.out.println(platformer.position());

        platformer.jumpRight();
        System.out.println(platformer.position());

        platformer.jumpRight();
        System.out.println(platformer.position());
    }
}
