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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lia
 */
@Entity
@Table(name = "keluarga", catalog = "gunasior", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keluarga.findAll", query = "SELECT k FROM Keluarga k"),
    @NamedQuery(name = "Keluarga.findByKodeKeluarga", query = "SELECT k FROM Keluarga k WHERE k.kodeKeluarga = :kodeKeluarga"),
    @NamedQuery(name = "Keluarga.findByAnggotaKeluarga", query = "SELECT k FROM Keluarga k WHERE k.anggotaKeluarga = :anggotaKeluarga"),
    @NamedQuery(name = "Keluarga.findByKepalaKeluarga", query = "SELECT k FROM Keluarga k WHERE k.kepalaKeluarga = :kepalaKeluarga")})
public class Keluarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KodeKeluarga", nullable = false, length = 10)
    private String kodeKeluarga;
    @Basic(optional = false)
    @Column(name = "AnggotaKeluarga", nullable = false)
    private int anggotaKeluarga;
    @Basic(optional = false)
    @Column(name = "KepalaKeluarga", nullable = false, length = 30)
    private String kepalaKeluarga;

    public Keluarga() {
    }

        public Keluarga(String kodeKeluarga) {
        this.kodeKeluarga = kodeKeluarga;
    }

    public Keluarga(String kodeKeluarga, int anggotaKeluarga, String kepalaKeluarga) {
        this.kodeKeluarga = kodeKeluarga;
        this.anggotaKeluarga = anggotaKeluarga;
        this.kepalaKeluarga = kepalaKeluarga;
    }

    public String getKodeKeluarga() {
        return kodeKeluarga;
    }

    public void setKodeKeluarga(String kodeKeluarga) {
        this.kodeKeluarga = kodeKeluarga;
    }

    public int getAnggotaKeluarga() {
        return anggotaKeluarga;
    }

    public void setAnggotaKeluarga(int anggotaKeluarga) {
        this.anggotaKeluarga = anggotaKeluarga;
    }

    public String getKepalaKeluarga() {
        return kepalaKeluarga;
    }

    public void setKepalaKeluarga(String kepalaKeluarga) {
        this.kepalaKeluarga = kepalaKeluarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeKeluarga != null ? kodeKeluarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keluarga)) {
            return false;
        }
        Keluarga other = (Keluarga) object;
        if ((this.kodeKeluarga == null && other.kodeKeluarga != null) || (this.kodeKeluarga != null && !this.kodeKeluarga.equals(other.kodeKeluarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Keluarga[ kodeKeluarga=" + kodeKeluarga + " ]";
    }
    
}
