package classes;

public class DcMotorEx {
    public String name;
    public double power = 0.0;
    public int direction = Direction.FORWARD;

    public DcMotorEx(String name) {
        this.name = name;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getRealPower() {
        return this.power * this.direction;
    }
}