/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.StationMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class StationMasterData {

    DatabaseHelper db;

    public StationMasterData() {

        db = new DatabaseHelper();
    }

    public ArrayList<DbClasses.StationMaster> getStations() {
        ArrayList<DbClasses.StationMaster> stations = new ArrayList<StationMaster>();


        ResultSet rs = db.getResultSet("Select * From stationmaster");
        StationMaster station;

        try {
            while (rs.next()) {
                station = new StationMaster();
                station.setStationId(rs.getInt("StationId"));
                station.setStationName(rs.getString("StationName"));
                station.setStationCode(rs.getString("StationCode"));

                stations.add(station);
            }
        } catch (SQLException se) {
        }
        return stations;
    }

    public StationMaster getStation(int stationId) {


        ResultSet rs = db.getResultSet("Select * From stationmaster where StationId = " + stationId);
        StationMaster station = new StationMaster();

        try {
            while (rs.next()) {
                station.setStationId(rs.getInt("StationId"));
                station.setStationName(rs.getString("StationName"));
                station.setStationCode(rs.getString("StationCode"));


            }
        } catch (SQLException se) {
        }
        return station;
    }

    public StationMaster getStation(String stationName) {


        ResultSet rs = db.getResultSet("Select * From StationMaster where StationName = " + stationName);
        StationMaster station = new StationMaster();

        try {
            while (rs.next()) {

                station.setStationId(rs.getInt("StationId"));
                station.setStationName(rs.getString("StationName"));
                station.setStationCode(rs.getString("StationCode"));

            }
        } catch (SQLException se) {
        }
        return station;
    }
}
