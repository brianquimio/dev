package interviews;


public class Qualtrics {

    //speedup using a cache (hashmap)

    //input: time and day
    //output: degrees of the hour/min hand
    public static double[] calculateDegree (String time) {
        //12 hour time
        String[] times = time.split(":");

        double hour = Integer.parseInt(times[0]);
        assert hour >= 1 && hour <= 12;

        double minute = Integer.parseInt(times[1]);
        assert minute >= 0 && minute <= 60;

        //[hour, minute]
        //hour => 360 / 12 = 30
        //minute => 360/60 = 6

        double[] degrees = new double[2];

        //hour
        degrees[0] = hour * 30;

        //minute
        degrees[1] = minute * 6;

        //shift hour hand to correspond to minute
        degrees[0] += (minute * .5);

        return degrees;

    }


}
