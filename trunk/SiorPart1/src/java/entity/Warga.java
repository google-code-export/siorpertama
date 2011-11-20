/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TYA
 */
@Entity
@Table(name = "warga", catalog = "siorsekali", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"namalengkap"}),
    @UniqueConstraint(columnNames = {"kotaktp"}),
    @UniqueConstraint(columnNames = {"alamatktp"}),
    @UniqueConstraint(columnNames = {"tempatlahir"})})
@NamedQueries({
    @NamedQuery(name = "Warga.findAll", query = "SELECT w FROM Warga w")})
public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "noktp", nullable = false, length = 30)
    private String noktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "namalengkap", nullable = false, length = 30)
    private String namalengkap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tempatlahir", nullable = false, length = 25)
    private String tempatlahir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamatktp", nullable = false, length = 50)
    private String alamatktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kotaktp", nullable = false, length = 25)
    private String kotaktp;

    public Warga() {
    }

    public Warga(String noktp) {
        this.noktp = noktp;
    }

    public Warga(String noktp, String namalengkap, String tempatlahir, String alamatktp, String kotaktp) {
        this.noktp = noktp;
        this.namalengkap = namalengkap;
        this.tempatlahir = tempatlahir;
        this.alamatktp = alamatktp;
        this.kotaktp = kotaktp;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getAlamatktp() {
        return alamatktp;
    }

    public void setAlamatktp(String alamatktp) {
        this.alamatktp = alamatktp;
    }

    public String getKotaktp() {
        return kotaktp;
    }

    public void setKotaktp(String kotaktp) {
        this.kotaktp = kotaktp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noktp != null ? noktp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.noktp == null && other.noktp != null) || (this.noktp != null && !this.noktp.equals(other.noktp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ noktp=" + noktp + " ]";
    }
    
}
