package reflection;

public class Engine implements StartAndStopEngine {

    private String fuelType = "HFO";
    private double ratedSpeed = 720;
    private int numberOfCylinders = 6;
    private int numberOfInjectors = 12;
    private int numberOfHighPressureFuelPumps = 6;
    private String positionOfCylinders = "In-Line";

////////////////////////////////////////////////////////////////////////

    public Engine(String fuelType ,double ratedSpeed, int numberOfCylinders, int numberOfHighPressureFuelPumps, int numberOfInjectors, String positionOfCylinders) {
        this.fuelType = fuelType;
        this.ratedSpeed = ratedSpeed;
        this.numberOfCylinders = numberOfCylinders;
        this.numberOfHighPressureFuelPumps = numberOfHighPressureFuelPumps;
        this.numberOfInjectors = numberOfInjectors;
        this.positionOfCylinders = positionOfCylinders;
    }

    public Engine(int numberOfCylinders, int numberOfInjectors, int numberOfHighPressureFuelPumps) {
        this.numberOfCylinders = numberOfCylinders;
        this.numberOfCylinders = numberOfCylinders;
        this.numberOfHighPressureFuelPumps = numberOfHighPressureFuelPumps;
    }

    public Engine() {
        System.out.println("Himsen Engine 6H21/32" + '\n');
    }

    public Engine(String positionOfCylinders, int numberOfCylinders) {
        this.positionOfCylinders = positionOfCylinders;
        this.numberOfCylinders = numberOfCylinders;
    }

////////////////////////////////////////////////////////////////////////

    private void startPreLubOilPump() {
        System.out.println("Prelubricating pump is running");
    }


    private void stopPreLubOilPump() {
        System.out.println("Prelubricating pump is stopped");
    }

    private void startJacketWaterPreheater() {
        System.out.println("Water preheater is running");
    }


    private void stopJacketWaterPreheater() {
        System.out.println("Water preheater is stopped");
    }

    private void turningByAir() {
        System.out.println("Engine is turned by air");
    }

    @Override
    public void engineStart() {
        stopPreLubOilPump();
        stopJacketWaterPreheater();
        turningByAir();
        System.out.println("Engine is running now");
    }

    @Override
    public void engineStop() {
        System.out.println("Engine is stopped");
        startPreLubOilPump();
        startJacketWaterPreheater();
    }

////////////////////////////////////////////////////////////////////////

    public String getPositionOfCylinders() {
        return positionOfCylinders;
    }

    public void setPositionOfCylinders(String positionOfCylinders) {
        this.positionOfCylinders = positionOfCylinders;
    }

    public int getNumberOfHighPressureFuelPumps() {
        return numberOfHighPressureFuelPumps;
    }

    public void setNumberOfHighPressureFuelPumps(int numberOfHighPressureFuelPumps) {
        this.numberOfHighPressureFuelPumps = numberOfHighPressureFuelPumps;
    }

    public int getNumberOfInjectors() {
        return numberOfInjectors;
    }

    public void setNumberOfInjectors(int numberOfInjectors) {
        this.numberOfInjectors = numberOfInjectors;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public double getRatedSpeed() {
        return ratedSpeed;
    }

    public void setRatedSpeed(double ratedSpeed) {
        this.ratedSpeed = ratedSpeed;
    }

////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return  "RATED SPEED -> " + ratedSpeed + '\n' +
                "NUMBER OF CYLINDERS - > " + numberOfCylinders + '\n' +
                "NUMBER OF CYLINDERS -> " + numberOfInjectors + '\n' +
                "NUMBER OF HIGH PRESSURE FUEL PUMP -> " + numberOfHighPressureFuelPumps + '\n' +
                "POSITION OF THE CYLINDERS - > " + positionOfCylinders + '\n';
    }

////////////////////////////////////////////////////////////////////////
}
