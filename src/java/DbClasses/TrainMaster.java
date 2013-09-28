/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbClasses;

/**
 *
 * @author Dev
 */
public class TrainMaster {
  
    private int trainId, trainNumber ;
    private String trainName, trainType;

    /**
     * @return the trainId
     */
    public int getTrainId() {
        return trainId;
    }

    /**
     * @param trainId the trainId to set
     */
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    /**
     * @return the trainNumber
     */
    public int getTrainNumber() {
        return trainNumber;
    }

    /**
     * @param trainNumber the trainNumber to set
     */
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    /**
     * @return the trainName
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * @param trainName the trainName to set
     */
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    /**
     * @return the trainType
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * @param trainType the trainType to set
     */
    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
    
    
}
