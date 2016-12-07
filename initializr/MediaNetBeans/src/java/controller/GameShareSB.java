/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import model.Comments;
import model.Content;
import model.ContentTags;
import model.Friends;
import model.Likes;
import model.ReportContent;
import model.User;

/**
 *
 * @author Miikka
 */
//stateless methods
@Stateless
public class GameShareSB {
    @PersistenceContext
    private EntityManager em;
    
    public User uInsert(User u) {
        em.persist(u);
        return u;
    }

    public void uUpdate(User u) {
        em.merge(u);
    }
    public ReportContent rcInsert(ReportContent rc) {
        em.persist(rc);
        return rc;
    }

    public void rcUpdate(ReportContent rc) {
        em.merge(rc);
    }
    public Likes lInsert(Likes l) {
        em.persist(l);
        return l;
    }

    public void lUpdate(Likes l) {
        em.merge(l);
    }
    public Friends fInsert(Friends f) {
        em.persist(f);
        return f;
    }

    public void fUpdate(Friends f) {
        em.merge(f);
    }
    public ContentTags ctInsert(ContentTags ct) {
        em.persist(ct);
        return ct;
    }

    public void ctUpdate(ContentTags ct) {
        em.merge(ct);
    }
    public Content cInsert(Content c) {
        em.persist(c);
        return c;
    }

    public void cUpdate(Content c) {
        em.merge(c);
    }
    public Comments comInsert(Comments com) {
        em.persist(com);
        return com;
    }

    public void comUpdate(Comments com) {
        em.merge(com);
    }

//User thingies.
    public List<User> readAllUsers() {
        List<User> ulst = em.createNamedQuery("User.findAll").getResultList();
        return ulst;
    }
    public User readUserByUid(int uid){
        User u = em.find(User.class, uid);
        return u;
    }
    public User readUserByUsername(String username){
        User u = em.find(User.class, username);
        return u;
    }
    // This might not be needed at all
    public User readUserByPword(String pword){
        User u = em.find(User.class, pword);
        return u;
    }
    //Comment thingies
    public List<Comments> readAllComments() {
        List<Comments> comlst = em.createNamedQuery("Comments.findAll").getResultList();
            return comlst;
        }
    
    public List<Content> readAllContent() {
        List<Content> clst = em.createNamedQuery("Content.findAll").getResultList();
        return clst;
    }
    public List<ContentTags> readAllContentTags() {
        List<ContentTags> ctlst = em.createNamedQuery("ContentTags.findAll").getResultList();
        return ctlst;
    }
    public List<Friends> readAllFriends() {
        List<Friends> flst = em.createNamedQuery("Friends.findAll").getResultList();
        return flst;
    }
    public List<Likes> readAllLikes() {
        List<Likes> llst = em.createNamedQuery("Likes.findAll").getResultList();
        return llst;
    }public List<ReportContent> readAllReportContent() {
        List<ReportContent> rclst = em.createNamedQuery("ReportContent.findAll").getResultList();
        return rclst;
    }
    
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

