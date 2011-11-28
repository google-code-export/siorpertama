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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TYA
 */
@Entity
@Table(name = "hunian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hunian.findAll", query = "SELECT h FROM Hunian h"),
    @NamedQuery(name = "Hunian.findByKodehunian", query = "SELECT h FROM Hunian h WHERE h.kodehunian = :kodehunian"),
    @NamedQuery(name = "Hunian.findByNoktp", query = "SELECT h FROM Hunian h WHERE h.noktp = :noktp"),
    @NamedQuery(name = "Hunian.findByKoderumah", query = "SELECT h FROM Hunian h WHERE h.koderumah = :koderumah"),
    @NamedQuery(name = "Hunian.findByNamalengkap", query = "SELECT h FROM Hunian h WHERE h.namalengkap = :namalengkap"),
    @NamedQuery(name = "Hunian.findByTanggalmasuk", query = "SELECT h FROM Hunian h WHERE h.tanggalmasuk = :tanggalmasuk"),
    @NamedQuery(name = "Hunian.findByTanggalkeluar", query = "SELECT h FROM Hunian h WHERE h.tanggalkeluar = :tanggalkeluar")})
public class Hunian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodehunian")
    private String kodehunian;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "noktp")
    private String noktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "koderumah")
    private String koderumah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "namalengkap")
    private String namalengkap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggalmasuk")
    @Temporal(TemporalType.DATE)
    private Date tanggalmasuk;
    @Column(name = "tanggalkeluar")
    @Temporal(TemporalType.DATE)
    private Date tanggalkeluar;

    public Hunian() {
    }

    public Hunian(String kodehunian) {
        this.kodehunian = kodehunian;
    }

    public Hunian(String kodehunian, String noktp, String koderumah, String namalengkap, Date tanggalmasuk) {
        this.kodehunian = kodehunian;
        this.noktp = noktp;
        this.koderumah = koderumah;
        this.namalengkap = namalengkap;
        this.tanggalmasuk = tanggalmasuk;
    }

    public String getKodehunian() {
        return kodehunian;
    }

    public void setKodehunian(String kodehunian) {
        this.kodehunian = kodehunian;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getKoderumah() {
        return koderumah;
    }

    public void setKoderumah(String koderumah) {
        this.koderumah = koderumah;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
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
        hash += (kodehunian != null ? kodehunian.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hunian)) {
            return false;
        }
        Hunian other = (Hunian) object;
        if ((this.kodehunian == null && other.kodehunian != null) || (this.kodehunian != null && !this.kodehunian.equals(other.kodehunian))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hunian[ kodehunian=" + kodehunian + " ]";
    }
    
}
