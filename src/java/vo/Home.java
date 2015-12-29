/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

import java.util.List;

/**
 *
 * @author pakorn
 */
public class Home {
    private long id;
    private String path;
    private String detail;
    
    private String name;
    private String address;
    private double price;
    private String area;
    private String province;
    private String district;
    private String provinceDesc;
    private String districtDesc;
    private List<Image> imagesList;

    public Home() {
    }

    public Home(long id, String path, String name, String address, double price, String area, String province, String provinceDesc, String district, String districtDesc) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
        this.province = province;
        this.provinceDesc = provinceDesc;
        this.district = district;
        this.districtDesc = districtDesc;
    }
    
    public Home(long id, String path, String detail) {
        this.id = id;
        this.path = path;
        this.detail = detail;
    }

    public Home(long id, String path) {
        this.id = id;
        this.path = path;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvinceDesc() {
        return provinceDesc;
    }

    public void setProvinceDesc(String provinceDesc) {
        this.provinceDesc = provinceDesc;
    }

    public String getDistrictDesc() {
        return districtDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        this.districtDesc = districtDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Image> imagesList) {
        this.imagesList = imagesList;
    }
    
    
}
