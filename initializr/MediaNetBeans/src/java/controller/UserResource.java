/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.User;

/**
 * REST Web Service
 *
 * @author Miikka
 */
@Path("User")
public class UserResource {

    @Context
    private UriInfo context;
    // remember this!!!
    @EJB
    private GameShareSB gssb;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of controller.UserResource
     * @return an instance of java.lang.String
     */
    // query to find user by id
    @Path("/{uid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserJson(@PathParam("uid") int uid) {
        //TODO return proper representation object
        User u = gssb.readUserByUid(uid);
        // user found and returning json data about login priviliges and activity        

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("uid", u.getUid());
        job.add("username", u.getUsername());
        job.add("pword", u.getPword());
        job.add("admin", u.getAdmin());

        return job.build().toString();
    }
    //query to get user by username (needed for login)
    @Path("/username")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserJson(@FormParam("username") String username) {
        //TODO return proper representation object
        User u = gssb.readUserByUsername(username);
        // user found and returning json data about login priviliges and activity        

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("uid", u.getUid());
        job.add("username", u.getUsername());
        job.add("pword", u.getPword());
        job.add("admin", u.getAdmin());

        return job.build().toString();
    }
    /* might not need this (find user by password)
    @Path("/{pword}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserJson(@PathParam("pword") String pword){
        User u = gssb.readUserByPword(pword);
        
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("uid", u.getUid());
        job.add("username", u.getUsername());
        job.add("pword", u.getPword());
        job.add("admin", u.getAdmin());

        return job.build().toString();
    }
*/
    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
