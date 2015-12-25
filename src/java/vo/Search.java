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
public class Search {
    private String name;
    private int selectProvince;
    private int seleteDistrict;
    private int maxPrice;
    private int mixPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectProvince() {
        return selectProvince;
    }

    public void setSelectProvince(int selectProvince) {
        this.selectProvince = selectProvince;
    }

    public int getSeleteDistrict() {
        return seleteDistrict;
    }

    public void setSeleteDistrict(int seleteDistrict) {
        this.seleteDistrict = seleteDistrict;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMixPrice() {
        return mixPrice;
    }

    public void setMixPrice(int mixPrice) {
        this.mixPrice = mixPrice;
    }

    @Override
    public String toString() {
        return "Search{" + "name=" + name + ", selectProvince=" + selectProvince + ", seleteDistrict=" + seleteDistrict + ", maxPrice=" + maxPrice + ", mixPrice=" + mixPrice + '}';
    }
    
    
    
}
