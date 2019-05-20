package com.mars;

public class Rover {
    private int posX;
    private int posY;
    private String orientation;
    private Plateau plateau;

    public Rover(int posX, int posY, String orientation, Plateau plateau) {
        this.posX = posX;
        this.posY = posY;
        this.orientation = orientation;
        this.plateau = plateau;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public String getOrientation() {
        return orientation;
    }

    public void rotate(char direction) {
        orientation = Plateau.ORIENTATION_MAP.get(orientation + direction);
    }

    public boolean moveForward() {
        boolean successfullyMoved = true;
        switch (orientation) {
            case "N":
                if (posY + 1 > plateau.getUpperBoundary())
                    successfullyMoved = false;
                else
                    posY++;
                break;
            case "S":
                if (posY - 1 < 0)
                    successfullyMoved = false;
                else
                    posY--;
                break;
            case "W":
                if (posX - 1 < 0)
                    successfullyMoved = false;
                else
                    posX--;
                break;
            case "E":
                if (posX + 1 > plateau.getRightBoundary())
                    successfullyMoved = false;
                else
                    posX++;
                break;
        }
        return successfullyMoved;
    }
}
