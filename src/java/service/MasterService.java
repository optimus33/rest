/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import vo.District;
import vo.Province;

/**
 *
 * @author pakorn
 */
@Path("/masterJSON")
public class MasterService {
    
    private static List<Province> provincesList;
    private static List<District> districtsList;
    
    static {
        provincesList = province();
        districtsList = district();
    }
    
    @GET
    @Path("/getProvinceListByJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Province> getProvinceListByJSON() {
        return provincesList;
    }
    
    @GET
    @Path("/getDistrictByJSON/{provinceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<District> getDistrictByJSON(@PathParam("provinceId") int provinceId) {
       List<District> districts = new ArrayList<District>();
       
       for(District d : districtsList){
           if(d.getProvinceId() == provinceId){
               districts.add(d);
           }
       }
        
        return districts;
    }
    
    private static List<Province> province(){
        provincesList = new ArrayList<Province>();
        provincesList.add(new Province(1, "กรุงเทพ"));
        provincesList.add(new Province(2, "ขอนแก่น"));
        provincesList.add(new Province(3, "สมุครสาทร"));
        provincesList.add(new Province(4, "นครปฐม"));
        provincesList.add(new Province(5, "สมุทรปราการ"));
        provincesList.add(new Province(6, "เชียงใหม่"));
        provincesList.add(new Province(7, "เชียงราย"));
        provincesList.add(new Province(8, "ปทุมธานี"));
        
        return provincesList;
    }
    
    private static List<District> district(){
        districtsList = new ArrayList<District>();
        districtsList.add(new District(1, "เขตพระนคร", 1));
        districtsList.add(new District(2, "เขตบางบอน", 1));
        districtsList.add(new District(3, "เขตบางกะปิ", 1));
        districtsList.add(new District(4, "เขตบางแค", 1));
        districtsList.add(new District(5, "เขตบางรัก", 1));
        districtsList.add(new District(6, "เขตบางซื่อ", 1));
        
        districtsList.add(new District(7, "อำเภอโนนศิลา", 2));
        districtsList.add(new District(8, "อำเภอเมืองขอนแก่น", 2));
        districtsList.add(new District(9, "อำเภอมัญจาคีรี", 2));
        districtsList.add(new District(10, "อำเภอแวงน้อย", 2));
        districtsList.add(new District(11, "อำเภอเวียงเก่า", 2));
        districtsList.add(new District(12, "อำเภอหนองนาคำ", 2));
        
        districtsList.add(new District(13, "อำเภอกระทุ่มแบน", 3));
        districtsList.add(new District(14, "อำเภอบ้านแพ้ว", 3));
        
        districtsList.add(new District(15, "อำเภอพุทธมณฑล", 4));
        districtsList.add(new District(16, "อำเภอกำแพงแสน", 4));
        districtsList.add(new District(17, "อำเภอดอนตูม", 4));
        districtsList.add(new District(18, "อำเภอนครชัยศรี", 4));
        districtsList.add(new District(19, "อำเภอบางเลน", 4));
        districtsList.add(new District(20, "อำเภอเมืองนครปฐม", 4));
        districtsList.add(new District(21, "อำเภอสามพราน", 4));
        
        districtsList.add(new District(22, "อำเภอบางบ่อ", 5));
        districtsList.add(new District(23, "อำเภอพระประแดง", 5));
        districtsList.add(new District(24, "อำเภอบางพลี", 5));
        districtsList.add(new District(25, "อำเภอบางเสาธง", 5));
        districtsList.add(new District(26, "อำเภอพระสมุทรเจดีย์", 5));
        districtsList.add(new District(27, "อำเภอเมืองสมุทรปราการ", 5));
        
        districtsList.add(new District(22, "อำเภอกัลยาณิวัฒนา", 6));
        districtsList.add(new District(23, "อำเภอฝาง", 6));
        districtsList.add(new District(24, "อำเภอพร้าว", 6));
        districtsList.add(new District(25, "อำเภอแม่วาง", 6));
        districtsList.add(new District(26, "อำเภอหางดง", 6));
        districtsList.add(new District(27, "อำเภอเมืองเชียงใหม่", 6));
        
        districtsList.add(new District(28, "อำเภอขุนตาล", 7));
        districtsList.add(new District(29, "อำเภอป่าแดด", 7));
        districtsList.add(new District(30, "อำเภอแม่สรวย", 7));
        districtsList.add(new District(31, "อำเภอแม่สาย", 7));
        districtsList.add(new District(32, "อำเภอเวียงแก่น", 7));
        districtsList.add(new District(33, "อำเภอเวียงป่าเป้า", 7));
        
        districtsList.add(new District(34, "อำเภอคลองหลวง", 8));
        districtsList.add(new District(35, "อำเภอเมืองปทุมธานี", 8));
        districtsList.add(new District(36, "อำเภอสามโคก", 8));
        districtsList.add(new District(37, "อำเภอหนองเสือ", 8));
        districtsList.add(new District(38, "อำเภอลาดหลุมแก้ว", 8));
        districtsList.add(new District(39, "อำเภอธัญบุรี", 8));
        
        return districtsList;
    }
    
}
