/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ntonk
 */
@Entity
@Table(name = "hunian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hunian.findAll", query = "SELECT h FROM Hunian h"),
    @NamedQuery(name = "Hunian.findById", query = "SELECT h FROM Hunian h WHERE h.id = :id"),
    @NamedQuery(name = "Hunian.findByNamalengkap", query = "SELECT h FROM Hunian h WHERE h.namalengkap = :namalengkap"),
    @NamedQuery(name = "Hunian.findByKoderumah", query = "SELECT h FROM Hunian h WHERE h.koderumah = :koderumah"),
    @NamedQuery(name = "Hunian.findByTanggalmasuk", query = "SELECT h FROM Hunian h WHERE h.tanggalmasuk = :tanggalmasuk"),
    @NamedQuery(name = "Hunian.findByTanggalkeluar", query = "SELECT h FROM Hunian h WHERE h.tanggalkeluar = :tanggalkeluar")})
public class Hunian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NAMALENGKAP")
    private String namalengkap;
    @Basic(optional = false)
    @Column(name = "KODERUMAH")
    private String koderumah;
    @Basic(optional = false)
    @Column(name = "TANGGALMASUK")
    @Temporal(TemporalType.DATE)
    private Date tanggalmasuk;
    @Basic(optional = false)
    @Column(name = "TANGGALKELUAR")
    @Temporal(TemporalType.DATE)
    private Date tanggalkeluar;

    public Hunian() {
    }

    public Hunian(Long id) {
        this.id = id;
    }

    public Hunian(Long id, String namalengkap, String koderumah, Date tanggalmasuk, Date tanggalkeluar) {
        this.id = id;
        this.namalengkap = namalengkap;
        this.koderumah = koderumah;
        this.tanggalmasuk = tanggalmasuk;
        this.tanggalkeluar = tanggalkeluar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getKoderumah() {
        return koderumah;
    }

    public void setKoderumah(String koderumah) {
        this.koderumah = koderumah;
    }

    public Date getTanggalmasuk() {
        return tanggalmasuk;
    }

    public void setTanggalmasuk(Date tanggalmasuk) {
        this.tanggalmasuk = tanggalmasuk;
    }

    public Date getTanggalkeluar() {
        return tanggalkeluar;
    }

    public void setTanggalkeluar(Date tanggalkeluar) {
        this.tanggalkeluar = tanggalkeluar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hunian)) {
            return false;
        }
        Hunian other = (Hunian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hunian[ id=" + id + " ]";
    }
    
}
