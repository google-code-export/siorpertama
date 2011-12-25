/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ntonk
 */
/*@Entity
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
*/

public class Hunian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHunian;
    
    private String kodehunian;
    private int noktp;
    private String koderumah;
    private String namalengkap;
    @Temporal(TemporalType.DATE)
    private Date tanggalmasuk;
    @Temporal(TemporalType.DATE)
    private Date tanggalkeluar;

    public Long getIdHunian() {
        return idHunian;
    }
    
    public void setIdHunian(Long idHunian) {
        this.idHunian = idHunian;
    }
    
    public String getKodehunian() {
        return kodehunian;
    }

    public void setKodehunian(String kodehunian) {
        this.kodehunian = kodehunian;
    }

    public int getNoktp() {
        return noktp;
    }

    public void setNoktp(int noktp) {
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
        hash += (idHunian != null ? idHunian.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hunian)) {
            return false;
        }
        Hunian other = (Hunian) object;
        if ((this.idHunian == null && other.idHunian != null) || (this.idHunian != null && !this.idHunian.equals(other.idHunian))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hunian[ idHunian=" + idHunian + " ]";
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodehunian)) {
            return true;
        } else {
            return false;
        }
    }
        
    
}
