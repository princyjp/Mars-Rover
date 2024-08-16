package LogicLayer;

import InputLayer.PlateauSize;

import java.util.ArrayList;

public class Plateau {
    private final PlateauSize plateauSize;
    protected ArrayList<Rover> listOfRovers = new ArrayList<>();

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public boolean isPositionOUtOfBounds(){

    }
    public boolean isPositionEmpty(){

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
