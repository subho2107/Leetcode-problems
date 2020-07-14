import java.io.*;
import java.util.*;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        if(hour == 12)hour = 0;
        hour *= 5;
        double min = hour + ((double)minutes/(double)60)*5;
        double ans = (Math.max(min, minutes)-Math.min(min, minutes))*6;
        return Math.min(360-ans, ans);
    }
}
