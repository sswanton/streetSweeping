public interface IRoadway {

    String getRoadwayName();

    void setRoadwayName(String name);

    Double getRoadCenterGPS();

    void setRoadCenterGPS(String name);

    String getSideOfRoad();

    void setSideOfRoad(String name);

    SweepOccurrence getSweepDateAndTime();

    void setSweepDateAndTime(SweepOccurrence sweepTime);
}
