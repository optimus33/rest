/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import vo.Home;
import vo.Search;

/**
 *
 * @author pakorn
 */
@Path("/homeJSON")
public class HomeService {
    
    private static List<Home> homesList;
    
    static{
        homesList = home();
    }
    
    @Path("/getHomeListByJSON/{json}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
//    public List<Home> getHomeListByJSON(@PathParam("name") String name, @PathParam("province") int province){
    public List<Home> getHomeListByJSON(@PathParam("json") JSONObject json) throws JSONException{
        
        String name = json.getString("name");
        String province = json.getString("province");
        String district = json.getString("district");
        double maxPrice = json.getDouble("maxPrice");
        double minPrice = json.getDouble("minPrice");
        
        List<Home> home = new ArrayList<Home>();
        
        for(Home h : homesList){
            if(name.equalsIgnoreCase(h.getName()) && province.equals(h.getProvince()) && district.equals(h.getDistrict())){
                if(maxPrice >= h.getPrice() && minPrice <= h.getPrice()){
                    home.add(h);
                }
                
            }
        }
       
        return home;
    }
    
    @Path("/test/{test}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@PathParam("test") String test){
        System.out.println("--------------" + test);
        
        return "";
    }
    
    
    private static List<Home> home(){
        homesList = new ArrayList<Home>();
        
        homesList.add(new Home(1, "img/Home/home1/home1_1.jpg", "Pleno", "ถ.บางบอน3 ซ.8 แขวงบางบอน เขตบางบอน กรุงเทพฯ", 1850000, "158", "1" , "กรุงเทพ", "2", "บางบอน"));
        
        return homesList;
    }
}
