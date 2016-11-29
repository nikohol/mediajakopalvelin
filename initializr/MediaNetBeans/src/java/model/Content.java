/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miikka
 */
@Entity
@Table(name = "Content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c")
    , @NamedQuery(name = "Content.findByCid", query = "SELECT c FROM Content c WHERE c.cid = :cid")
    , @NamedQuery(name = "Content.findByTitle", query = "SELECT c FROM Content c WHERE c.title = :title")
    , @NamedQuery(name = "Content.findByLocation", query = "SELECT c FROM Content c WHERE c.location = :location")
    , @NamedQuery(name = "Content.findByDop", query = "SELECT c FROM Content c WHERE c.dop = :dop")
    , @NamedQuery(name = "Content.findByRestriction", query = "SELECT c FROM Content c WHERE c.restriction = :restriction")})
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "restriction")
    private boolean restriction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<ReportContent> reportContentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<ContentTags> contentTagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Comments> commentsCollection;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User uid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Likes> likesCollection;

    public Content() {
    }

    public Content(Integer cid) {
        this.cid = cid;
    }

    public Content(Integer cid, String title, String location, Date dop, boolean restriction) {
        this.cid = cid;
        this.title = title;
        this.location = location;
        this.dop = dop;
        this.restriction = restriction;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDop() {
        return dop;
    }

    public void setDop(Date dop) {
        this.dop = dop;
    }

    public boolean getRestriction() {
        return restriction;
    }

    public void setRestriction(boolean restriction) {
        this.restriction = restriction;
    }

    @XmlTransient
    public Collection<ReportContent> getReportContentCollection() {
        return reportContentCollection;
    }

    public void setReportContentCollection(Collection<ReportContent> reportContentCollection) {
        this.reportContentCollection = reportContentCollection;
    }

    @XmlTransient
    public Collection<ContentTags> getContentTagsCollection() {
        return contentTagsCollection;
    }

    public void setContentTagsCollection(Collection<ContentTags> contentTagsCollection) {
        this.contentTagsCollection = contentTagsCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Content[ cid=" + cid + " ]";
    }
    
}
