/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
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
import vo.Image;
import vo.Search;

/**
 *
 * @author pakorn
 */
@Path("/homeJSON")
public class HomeService {
    
    private static List<Home> homesList;
    private static List<Image> imagesList;
    private static final AtomicLong counter = new AtomicLong();
    private static final AtomicInteger counterInt = new AtomicInteger();
    
    static{
        homesList = home();
        imagesList = image();
    }
    
    @Path("/getDetail/{id}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
//    public List<Home> getHomeListByJSON(@PathParam("name") String name, @PathParam("province") int province){
    public Home getHomeListByJSON(@PathParam("id") int id) throws JSONException{
        
        Home home = new Home();
        
       for(Home h : homesList){
//           System.out.println("image" + imagesList.size());
           h.setImagesList(imagesList);
           home = h;
       }
       
        return home;
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
        int size = json.getInt("size");
        
        List<Home> home = new ArrayList<Home>();
        
        for(int i=0; i<=size; i++){
            if(name.equalsIgnoreCase(homesList.get(i).getName()) && province.equals(homesList.get(i).getProvince()) && district.equals(homesList.get(i).getDistrict())){
                if(maxPrice >= homesList.get(i).getPrice() && minPrice <= homesList.get(i).getPrice()){
                    home.add(homesList.get(i));
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
        
        for(int i=0; i<100; i++){
            homesList.add(new Home(counterInt.incrementAndGet(), "img/Home/home1/home1_1.jpg", "Pleno", "ถ.บางบอน3 ซ.8 แขวงบางบอน เขตบางบอน กรุงเทพฯ", 1850000, "158", "1" , "กรุงเทพ", "2", "บางบอน"));
        }
        
        return homesList;
    }
    
    private static List<Image> image(){
        imagesList = new ArrayList<Image>();
        
//        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_1.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_2.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_3.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_4.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_5.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_6.jpg"));
        imagesList.add(new Image(counter.incrementAndGet(), "img/Home/home1/home1_7.jpg"));
        
        return imagesList;
    }
    
    public static void main(String[] args) {
        
    }
}
