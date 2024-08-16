package LogicLayer;

import InputLayer.PlateauSize;

import java.util.ArrayList;

public class Plateau {
    private final PlateauSize plateauSize;
    protected ArrayList<Rover> listOfRovers = new ArrayList<>();

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
        printPlateau();
    }

    private void printPlateau() {
        for (int i = 0; i <= plateauSize.getMaxX(); i++) {
            for (int j = 0; j <= plateauSize.getMaxY(); j++) {
                System.out.print(0 + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean isPositionOutOfBounds(){
    return true;
    }
    public boolean isPositionEmpty(){
    return true;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public ArrayList<Rover> getListOfRovers() {
        return listOfRovers;
    }

    public void setListOfRovers(ArrayList<Rover> listOfRovers) {
        this.listOfRovers = listOfRovers;
    }
}
