package SpartanRide.SpartanRide_db;

public class Stats {


    private int driverNum;
    private int driverOnline;
    private int riderNum;
    private int riderOnline;


    public Stats(int driverNum, int riderNum, int driverCurr, int riderCurr) {

        this.driverNum = driverNum;
        this.driverOnline = driverCurr;
        this.riderNum = riderNum;
        this.riderOnline = riderCurr;
    }


    public int getDriverOnline() {
        return driverOnline;
    }

    public void setDriverOnline(int driverOnline) {
        this.driverOnline = driverOnline;
    }

    public int getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(int driverNum) {
        this.driverNum = driverNum;
    }

    public int getRiderOnline() {
        return riderOnline;
    }

    public void setRiderOnline(int riderOnline) {
        this.riderOnline = riderOnline;
    }

    public int getRiderNum() {
        return riderNum;
    }

    public void setRiderNum(int riderNum) {
        this.riderNum = riderNum;
    }
}
