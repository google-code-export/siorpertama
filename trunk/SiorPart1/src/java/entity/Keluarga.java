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
@Table(name = "keluarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keluarga.findAll", query = "SELECT k FROM Keluarga k"),
    @NamedQuery(name = "Keluarga.findByKodekeluarga", query = "SELECT k FROM Keluarga k WHERE k.kodekeluarga = :kodekeluarga"),
    @NamedQuery(name = "Keluarga.findByAnggotakeluarga", query = "SELECT k FROM Keluarga k WHERE k.anggotakeluarga = :anggotakeluarga"),
    @NamedQuery(name = "Keluarga.findByKepalakeluarga", query = "SELECT k FROM Keluarga k WHERE k.kepalakeluarga = :kepalakeluarga")})

public class Keluarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodekeluarga")
    private String kodekeluarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anggotakeluarga")
    private int anggotakeluarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kepalakeluarga")
    private String kepalakeluarga;

    public Keluarga() {
    }

    public Keluarga(String kodekeluarga) {
        this.kodekeluarga = kodekeluarga;
    }

    public Keluarga(String kodekeluarga, int anggotakeluarga, String kepalakeluarga) {
        this.kodekeluarga = kodekeluarga;
        this.anggotakeluarga = anggotakeluarga;
        this.kepalakeluarga = kepalakeluarga;
    }

    public String getKodekeluarga() {
        return kodekeluarga;
    }

    public void setKodekeluarga(String kodekeluarga) {
        this.kodekeluarga = kodekeluarga;
    }

    public int getAnggotakeluarga() {
        return anggotakeluarga;
    }

    public void setAnggotakeluarga(int anggotakeluarga) {
        this.anggotakeluarga = anggotakeluarga;
    }

    public String getKepalakeluarga() {
        return kepalakeluarga;
    }

    public void setKepalakeluarga(String kepalakeluarga) {
        this.kepalakeluarga = kepalakeluarga;
    }
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodekeluarga != null ? kodekeluarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keluarga)) {
            return false;
        }
        Keluarga other = (Keluarga) object;
        if ((this.kodekeluarga == null && other.kodekeluarga != null) || (this.kodekeluarga != null && !this.kodekeluarga.equals(other.kodekeluarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Keluarga[ kodekeluarga=" + kodekeluarga + " ]";
    } */
    
}
