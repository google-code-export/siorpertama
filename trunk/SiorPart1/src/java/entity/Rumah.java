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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TYA
 */
@Entity
@Table(name = "rumah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rumah.findAll", query = "SELECT r FROM Rumah r"),
    @NamedQuery(name = "Rumah.findByKoderumah", query = "SELECT r FROM Rumah r WHERE r.koderumah = :koderumah"),
    @NamedQuery(name = "Rumah.findByAlamatrumah", query = "SELECT r FROM Rumah r WHERE r.alamatrumah = :alamatrumah"),
    @NamedQuery(name = "Rumah.findByKelurahanrumah", query = "SELECT r FROM Rumah r WHERE r.kelurahanrumah = :kelurahanrumah"),
    @NamedQuery(name = "Rumah.findByKecamatanrumah", query = "SELECT r FROM Rumah r WHERE r.kecamatanrumah = :kecamatanrumah"),
    @NamedQuery(name = "Rumah.findByKotarumah", query = "SELECT r FROM Rumah r WHERE r.kotarumah = :kotarumah")})
public class Rumah implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "koderumah")
    private String koderumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamatrumah")
    private String alamatrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kelurahanrumah")
    private String kelurahanrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kecamatanrumah")
    private String kecamatanrumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kotarumah")
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
