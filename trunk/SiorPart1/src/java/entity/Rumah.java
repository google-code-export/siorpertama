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
@Table(name = "rumah", catalog = "siorsekali", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"alamatrumah"}),
    @UniqueConstraint(columnNames = {"kotarumah"}),
    @UniqueConstraint(columnNames = {"kecamatanrumah"}),
    @UniqueConstraint(columnNames = {"kelurahanrumah"})})
@NamedQueries({
    @NamedQuery(name = "Rumah.findAll", query = "SELECT r FROM Rumah r")})
public class Rumah implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "koderumah", nullable = false, length = 10)
    private String koderumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamatrumah", nullable = false, length = 50)
    private String alamatrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kelurahanrumah", nullable = false, length = 30)
    private String kelurahanrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kecamatanrumah", nullable = false, length = 20)
    private String kecamatanrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kotarumah", nullable = false, length = 25)
    private String kotarumah;

    public Rumah() {
    }

    public Rumah(String koderumah) {
        this.koderumah = koderumah;
    }

    public Rumah(String koderumah, String alamatrumah, String kelurahanrumah, String kecamatanrumah, String kotarumah) {
        this.koderumah = koderumah;
        this.alamatrumah = alamatrumah;
        this.kelurahanrumah = kelurahanrumah;
        this.kecamatanrumah = kecamatanrumah;
        this.kotarumah = kotarumah;
    }

    public String getKoderumah() {
        return koderumah;
    }

    public void setKoderumah(String koderumah) {
        this.koderumah = koderumah;
    }

    public String getAlamatrumah() {
        return alamatrumah;
    }

    public void setAlamatrumah(String alamatrumah) {
        this.alamatrumah = alamatrumah;
    }

    public String getKelurahanrumah() {
        return kelurahanrumah;
    }

    public void setKelurahanrumah(String kelurahanrumah) {
        this.kelurahanrumah = kelurahanrumah;
    }

    public String getKecamatanrumah() {
        return kecamatanrumah;
    }

    public void setKecamatanrumah(String kecamatanrumah) {
        this.kecamatanrumah = kecamatanrumah;
    }

    public String getKotarumah() {
        return kotarumah;
    }

    public void setKotarumah(String kotarumah) {
        this.kotarumah = kotarumah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (koderumah != null ? koderumah.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rumah)) {
            return false;
        }
        Rumah other = (Rumah) object;
        if ((this.koderumah == null && other.koderumah != null) || (this.koderumah != null && !this.koderumah.equals(other.koderumah))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rumah[ koderumah=" + koderumah + " ]";
    }
    
}
