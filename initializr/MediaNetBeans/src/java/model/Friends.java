/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miikka
 */
@Entity
@Table(name = "Friends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f")
    , @NamedQuery(name = "Friends.findByFid", query = "SELECT f FROM Friends f WHERE f.fid = :fid")})
public class Friends implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fid")
    private Integer fid;
    @JoinColumn(name = "friendid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User friendid;
    @JoinColumn(name = "ownerid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User ownerid;

    public Friends() {
    }

    public Friends(Integer fid) {
        this.fid = fid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public User getFriendid() {
        return friendid;
    }

    public void setFriendid(User friendid) {
        this.friendid = friendid;
    }

    public User getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(User ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Friends[ fid=" + fid + " ]";
    }
    
}
