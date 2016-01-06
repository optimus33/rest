/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

/**
 *
 * @author pakorn
 */
public class Map {
    private String collId;
    private String address;
    private String lat;
    private String lng;

    public Map() {
    }

    public Map(String collId, String address, String lat, String lng) {
        this.collId = collId;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
    
    public String getCollId() {
        return collId;
    }

    public void setCollId(String collId) {
        this.collId = collId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    
    
    
}
