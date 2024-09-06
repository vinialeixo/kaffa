package com.codex.kaffa.retanglesIntersect;


class Rectangle {
    int x1, y1; 
    int x2, y2; 

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

  
    public boolean intersects(Rectangle other) {
        if (this.x1 > other.x2 || this.x2 < other.x1 || 
            this.y1 > other.y2 || this.y2 < other.y1) {
            return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle A = new Rectangle(3, 5, 11, 11);
        Rectangle B = new Rectangle(7, 2, 13, 7);
        Rectangle C = new Rectangle(11, 11, 15, 13);

        System.out.println("intersects(A, B) => " + A.intersects(B)); // true
        System.out.println("intersects(A, C) => " + A.intersects(C)); // true
        System.out.println("intersects(B, C) => " + B.intersects(C)); // false
    }
}

