package unit8;

public class Timer { //class is as given in the project description

    double count = 0;

    public Timer() {

    }

    public void startTimer() {
        count = System.nanoTime();
    }

    public void stopTimer() {
        long stopCount = System.nanoTime();
        count = stopCount - count;
    }

    public double getMilli() {
        return count / 1000000.0;
    }

    public double getMicro() {
        return count / 1000.0;
    }

    public double getSecond() {
        return count / 1000000000.0;
    }

    public static void main(String[] args) {
        Timer tmr = new Timer();
        try {
            tmr.startTimer();
            Thread.sleep(1000);
            tmr.stopTimer();
            System.out.println("Micro " + tmr.getMicro());
            System.out.println("Milli " + tmr.getMilli());
            System.out.println("Seconds " + tmr.getSecond());

        } catch (Exception e) {

        }

    }

}
