import java.awt.*;

/**
 * Abstract class that contains all shared methods and variables among cars
 */
abstract class AbstractCar implements Movable{
    private int nrDoors;            /**     Number of doors on the car      */
    private int enginePower;        /**     Engine power of the car         */
    private double currentSpeed;    /**     The current speed of the car    */
    private Color color;            /**     Color of the car                */
    private String modelName;       /**     The car model name              */
    private int dx;                 /**     Direction in the x-axis         */
    private int dy;                 /**     Direction in the y-axis         */
    private double x;               /**     Car position x                  */
    private double y;

    public AbstractCar(int nrDoors, int enginePower, double currentSpeed, Color color, String modelName, int dx, int dy, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.dx = dx;
        this.dy = dy;
        this.x = x;
        this.y = y;
    }

    /**     Car position y                  */


    /**     Getters/Setters     */
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double d){
        currentSpeed = d;
    }

    public int getDx(){
        return dx;
    }

    public int getDy(){
        return dy;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    /**
     * Starts the car engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the car engine
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Speed factor of car, value set in subclasses
     */
    public abstract double speedFactor();{

    }

    /**
     * Represents the rate at which velocity increases
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Represents the rate at which velocity decreases
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * Increasing the speed of the car
     * @param amount which to increase the speed with
     * @throws Exception if amount is not in interval [0, 1]
     */
    public void gas (double amount) throws Exception {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new Exception("Error: Value is out of bounds.");
        }
    }

    /**
     * Decreasing the speed of the car
     * @param amount which to decrease the speed with
     * @throws Exception if amount is not in interval [0, 1]
     */
    public void brake ( double amount) throws Exception {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new Exception("Error: Value is out of bounds.");
        }
    }

    /**
     * Turning the car 90 degrees to the left
     */
    public void turnLeft () {
        int temp = -dy;
        dy = dx;
        dx = temp;
    }

    /**
     * Turning the car 90 degrees to the right
     */
    public void turnRight () {
        int temp = dy;
        dy = dx;
        dx = temp;
    }

    /**
     * Moving the car based on currentSpeed
     */
    public void move () {
        x += dx * currentSpeed;
        y += dy * currentSpeed;
    }
}
