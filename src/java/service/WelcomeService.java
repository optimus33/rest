/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import vo.Home;

/**
 *
 * @author pakorn
 */
@Path("/welcomeJSON")
public class WelcomeService {
    
    private static final AtomicLong counter = new AtomicLong();
    private static List<Home> homeList; 
    
    
    static{
        homeList = home();
    }
    
    @GET
    @Path("/getHomeListByJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Home> getHomeListByJSON() {
        return homeList;
    }
    
    @GET
    @Path("/getHomeByJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHomeByJSON(@PathParam("id") long id) {
        Home home = new Home();
        
        for(Home view : homeList){
            if(view.getId() == id){
                home.setId(view.getId());
                
                if("img/Home/welcome/home1.jpg".equals(view.getPath())){
                    home.setPath("img/View/home1.jpg");
                    home.setDetail("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                        + "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                        + "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                        + "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                        + "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
                } else if("img/Home/welcome/home2.jpg".equals(view.getPath())){
                    home.setPath("img/View/home2.jpg");
                    home.setDetail("22222222222222222222222222222222222222222222222222222222222");
                } else if("img/Home/welcome/home3.jpg".equals(view.getPath())){
                    home.setPath("img/View/home3.jpg");
                    home.setDetail("333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333");
                } else if("img/Home/welcome/home4.jpg".equals(view.getPath())){
                    home.setPath("img/View/home4.jpg");
                   home.setDetail("44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444");
                }
                
                
            }
        }
        
        return home;
    }
    
    
     private static List<Home> home(){
        homeList = new ArrayList<Home>();
        homeList.add(new Home(counter.incrementAndGet(), "img/Home/welcome/home1.jpg"));
        homeList.add(new Home(counter.incrementAndGet(), "img/Home/welcome/home2.jpg"));
        homeList.add(new Home(counter.incrementAndGet(), "img/Home/welcome/home3.jpg"));
        homeList.add(new Home(counter.incrementAndGet(), "img/Home/welcome/home4.jpg"));
        
        return homeList;
    }
    
}
