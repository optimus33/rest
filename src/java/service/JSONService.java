/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import vo.Track;

/**
 *
 * @author Nanza
 */

@Path("/getJsonWSData")
public class JSONService {
    @GET
    @Path("/getTrackInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        return track;
    }
    
    @GET
    @Path("/getListTrackInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getListTrackInJSON() {

        List<Track> all = new ArrayList<Track>();
        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        all.add(track);
        
        track = new Track();
        track.setTitle("Flashlight");
        track.setSinger("Jessi J");
        all.add(track);
        
        track = new Track();
        track.setTitle("Dear future husband");
        track.setSinger("Meghan Trainor");
        all.add(track);
        
        
        return all;
    }

}
