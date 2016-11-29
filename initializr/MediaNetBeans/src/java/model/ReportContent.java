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
@Table(name = "ReportContent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportContent.findAll", query = "SELECT r FROM ReportContent r")
    , @NamedQuery(name = "ReportContent.findByRid", query = "SELECT r FROM ReportContent r WHERE r.rid = :rid")
    , @NamedQuery(name = "ReportContent.findByReport", query = "SELECT r FROM ReportContent r WHERE r.report = :report")})
public class ReportContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rid")
    private Integer rid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "report")
    private String report;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Content cid;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User uid;

    public ReportContent() {
    }

    public ReportContent(Integer rid) {
        this.rid = rid;
    }

    public ReportContent(Integer rid, String report) {
        this.rid = rid;
        this.report = report;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Content getCid() {
        return cid;
    }

    public void setCid(Content cid) {
        this.cid = cid;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportContent)) {
            return false;
        }
        ReportContent other = (ReportContent) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReportContent[ rid=" + rid + " ]";
    }
    
}
