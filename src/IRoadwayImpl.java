import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class IRoadwayImpl implements IRoadway {

    private String roadwayName;
    private Double roadCenterGPS;
    private String sideOfRoad;
    private SweepOccurrence sweepDateAndTime;

    public IRoadwayImpl(String roadwayName, Double roadCenterGPS, String sideOfRoad, SweepOccurrence sweepDateAndTime) {
        this.roadwayName = roadwayName;
        this.roadCenterGPS = roadCenterGPS;
        this.sideOfRoad = sideOfRoad;
        this.sweepDateAndTime = sweepDateAndTime;
    }

    @Override
    public String getRoadwayName() {
        return this.roadwayName;
    }

    @Override
    public void setRoadwayName(String name) {
        this.roadwayName = name;
    }

    @Override
    public Double getRoadCenterGPS() {
        return this.roadCenterGPS;
    }

    @Override
    public void setRoadCenterGPS(String name) {
        this.roadCenterGPS = 1.0;
    }

    @Override
    public String getSideOfRoad() {
        return this.sideOfRoad;
    }

    @Override
    public void setSideOfRoad(String name) {
        this.sideOfRoad = name;
    }

    @Override
    public SweepOccurrence getSweepDateAndTime() {
        return this.sweepDateAndTime;
    }

    @Override
    public void setSweepDateAndTime(SweepOccurrence sweepTime) {
        this.sweepDateAndTime = sweepTime;
    }

}
