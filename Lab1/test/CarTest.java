import org.junit.Before;
import org.junit.Test;

/**
 * Tests various methods
 */
public class CarTest {

    private Saab95 saab;
    private Volvo240 volvo;
    double amount;

    @Before
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
        amount = 0.5;
    }

    @Test
    public void move() {
        saab.startEngine();
        saab.move();
        assert (saab.getX() == 0.1 && saab.getY() == 0);
    }

    @Test
    public void gasVolvo() throws Exception {
        volvo.startEngine();
        volvo.gas(0.5);
        assert (volvo.getCurrentSpeed() == Math.min(0.1 + (volvo.getEnginePower() * 0.01 * 1.25) * amount, volvo.getEnginePower()));
    }

    @Test
    public void gasSaab() throws Exception {
        saab.startEngine();
        saab.gas(0.5);
        assert (saab.getCurrentSpeed() == 0.1 + saab.speedFactor() * amount);
    }

    @Test
    public void turboSaab() throws Exception {
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.5);
        assert (saab.getCurrentSpeed() == (Math.min(0.1 + saab.speedFactor() * amount, saab.getEnginePower())));
    }

    @Test
    public void breakVolvo() throws Exception {
        volvo.setCurrentSpeed(0.5);
        volvo.brake(0.5);
        assert (volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void leftVolvo(){
        volvo.turnLeft();
        assert(volvo.getDx() == 0 && volvo.getDy() == 1);
    }

    @Test
    public void rightSaab(){
        saab.turnRight();
        assert(saab.getDx() == 0 && saab.getDy() == 1);
    }

    @Test
    public void stopEngine(){
        saab.startEngine();
        saab.move();
        saab.stopEngine();
        assert(saab.getCurrentSpeed() == 0);
    }
}
