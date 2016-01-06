/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import vo.Map;
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
    
    private String URL = "jdbc:oracle:thin:NPAADM/NPAADM@10.2.221.192:1527:LOANUAT2";
    private Connection conn;
    private Statement stmt;
    
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
    public List<String> test(@PathParam("test") String test) throws SQLException{
        try {
            dataBase();
        } catch (SQLException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("--------------" + test);
        
        return testDB();
    }
    
    private void dataBase() throws SQLException{
        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver( myDriver );
        
        String URL = "jdbc:oracle:thin:NPAADM/NPAADM@10.2.221.192:1527:LOANUAT2";
        conn = DriverManager.getConnection(URL);
        
        System.out.println("DB -- : " + conn);
    }
    
    @Path("/getMap/{lat}/{lng}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map> getMap(@PathParam("lat") String lat, @PathParam("lng") String lng) throws SQLException{
        List<Map> mapsList = new ArrayList<Map>();

        String sql = "select COLL.COLLT_ID, COLL.ADDRLINE1, " +
                        "(SELECT PROVINCE_NAME " +
                        "  FROM npadba.TBL_PROVINCE " +
                        "  WHERE PROVINCE_NO = coll.PROVINCE_NO) AS PROVINCE_NAME , " +
                        "  (SELECT AMPHUR_NAME FROM npadba.TBL_AMPHUR " +
                        "  WHERE PROVINCE_NO = coll.PROVINCE_NO " +
                        "  AND AMPHUR_NO = coll.AMPHUR_NO) AS AMPHUR_NAME, " +
                        "  (SELECT TAMBON_NAME " +
                        "  FROM npadba.TBL_TAMBON " +
                        "  WHERE PROVINCE_NO = coll.PROVINCE_NO " +
                        "  AND AMPHUR_NO = coll.AMPHUR_NO " +
                        "  AND TAMBON_NO = coll.TAMBON_NO) AS TAMBON_NAME  , " +
                        "    r_gis.rrr, r_gis.lat, r_gis.lon " +
                        " from npadba.tbl_coll coll" +
                        " inner join ( select COLL_ID,  rrr, lat, lon from ( Select COLL_ID,lat,lon, SQRT( POWER( (lat - " + lat + ") ,2) + POWER( (lon - " + lng + ") ,2)) As rrr  from npadba.tbl_coll_gis " +
                        " ) where rrr < 0.05 )  r_gis on r_gis.coll_id = coll.coll_id";
        System.out.println("SQL : " + sql);
        
        
        conn = DriverManager.getConnection(URL);
        stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder address;
        String spea = " ";
        
        while(rs.next()){
            Map map = new Map();
            map.setCollId(rs.getString(1));
            
            address = new StringBuilder();
            
            address.append(rs.getString(2)).append(spea).append(rs.getString(3)).append(spea).append(rs.getString(4)).append(spea).append(rs.getString(5));
            
            map.setAddress(address.toString());
            map.setLat(rs.getString(7));
            map.setLng(rs.getString(8));
            
            mapsList.add(map);
        }
        
        
        return mapsList;
    }
    
    private List<String> testDB() throws SQLException{
        
        stmt = conn.createStatement();
        
        String sql = "select coll.COLL_ID from NPADBA.tbl_coll coll where ROWNUM <= 10";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        List<String> a = new ArrayList<String>();
        while(rs.next()){
            a.add(rs.getString("COLL_ID"));
            System.out.println("get : " + rs.getString("COLL_ID"));
        }
        
        return a;
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
