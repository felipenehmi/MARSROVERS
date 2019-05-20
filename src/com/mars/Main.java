package com.mars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] plateauBoundaries = scanner.nextLine().split(" ");
        Plateau plateau = Plateau.getInstance();
        plateau.setUpperBoundary(Integer.parseInt(plateauBoundaries[0]));
        plateau.setRightBoundary(Integer.parseInt(plateauBoundaries[1]));

        while (scanner.hasNextLine()) {
            String[] position = scanner.nextLine().split(" ");
            Rover rover = new Rover(
                Integer.parseInt(position[0]),
                Integer.parseInt(position[1]),
                position[2],
                plateau
            );

            String movements = scanner.nextLine();
            for (int i = 0; i < movements.length(); i++) {
                char currentMove = movements.charAt(i);
                if (currentMove != 'M')
                    rover.rotate(currentMove);
                else {
                    if (!rover.moveForward()) {
                        System.out.println("Could not move rover: plateau boundary reached");
                    }
                }
            }
            System.out.println(String.format("%d %d %s", rover.getPosX(), rover.getPosY(), rover.getOrientation()));
        }
    }
}
