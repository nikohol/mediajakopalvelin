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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miikka
 */
@Entity
@Table(name = "ContentTags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentTags.findAll", query = "SELECT c FROM ContentTags c")
    , @NamedQuery(name = "ContentTags.findByTagid", query = "SELECT c FROM ContentTags c WHERE c.tagid = :tagid")
    , @NamedQuery(name = "ContentTags.findByTag", query = "SELECT c FROM ContentTags c WHERE c.tag = :tag")})
public class ContentTags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tagid")
    private Integer tagid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tag")
    private String tag;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Content cid;

    public ContentTags() {
    }

    public ContentTags(Integer tagid) {
        this.tagid = tagid;
    }

    public ContentTags(Integer tagid, String tag) {
        this.tagid = tagid;
        this.tag = tag;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Content getCid() {
        return cid;
    }

    public void setCid(Content cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagid != null ? tagid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentTags)) {
            return false;
        }
        ContentTags other = (ContentTags) object;
        if ((this.tagid == null && other.tagid != null) || (this.tagid != null && !this.tagid.equals(other.tagid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ContentTags[ tagid=" + tagid + " ]";
    }
    
}
