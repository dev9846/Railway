/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbClasses;

/**
 *
 * @author Dev
 */
public class StationMaster {
    private int stationId;
    private String stationCode, StationName;

    /**
     * @return the stationId
     */
    public int getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the stationCode
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * @param stationCode the stationCode to set
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    /**
     * @return the StationName
     */
    public String getStationName() {
        return StationName;
    }

    /**
     * @param StationName the StationName to set
     */
    public void setStationName(String StationName) {
        this.StationName = StationName;
    }
    
    
}
