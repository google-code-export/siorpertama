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
@Table(name = "iuran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iuran.findAll", query = "SELECT i FROM Iuran i"),
    @NamedQuery(name = "Iuran.findByKodeiuran", query = "SELECT i FROM Iuran i WHERE i.kodeiuran = :kodeiuran"),
    @NamedQuery(name = "Iuran.findByKodekeluarga", query = "SELECT i FROM Iuran i WHERE i.kodekeluarga = :kodekeluarga"),
    @NamedQuery(name = "Iuran.findByJenisiuran", query = "SELECT i FROM Iuran i WHERE i.jenisiuran = :jenisiuran"),
    @NamedQuery(name = "Iuran.findByBulaniuran", query = "SELECT i FROM Iuran i WHERE i.bulaniuran = :bulaniuran"),
    @NamedQuery(name = "Iuran.findByJumlahbayar", query = "SELECT i FROM Iuran i WHERE i.jumlahbayar = :jumlahbayar"),
    @NamedQuery(name = "Iuran.findByTanggalbayar", query = "SELECT i FROM Iuran i WHERE i.tanggalbayar = :tanggalbayar")})
public class Iuran implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodeiuran")
    private String kodeiuran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodekeluarga")
    private String kodekeluarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "jenisiuran")
    private String jenisiuran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "bulaniuran")
    private String bulaniuran;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jumlahbayar")
    private int jumlahbayar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggalbayar")
    @Temporal(TemporalType.DATE)
    private Date tanggalbayar;

    public Iuran() {
    }

    public Iuran(String kodeiuran) {
        this.kodeiuran = kodeiuran;
    }

    public Iuran(String kodeiuran, String kodekeluarga, String jenisiuran, String bulaniuran, int jumlahbayar, Date tanggalbayar) {
        this.kodeiuran = kodeiuran;
        this.kodekeluarga = kodekeluarga;
        this.jenisiuran = jenisiuran;
        this.bulaniuran = bulaniuran;
        this.jumlahbayar = jumlahbayar;
        this.tanggalbayar = tanggalbayar;
    }

    public String getKodeiuran() {
        return kodeiuran;
    }

    public void setKodeiuran(String kodeiuran) {
        this.kodeiuran = kodeiuran;
    }

    public String getKodekeluarga() {
        return kodekeluarga;
    }

    public void setKodekeluarga(String kodekeluarga) {
        this.kodekeluarga = kodekeluarga;
    }

    public String getJenisiuran() {
        return jenisiuran;
    }

    public void setJenisiuran(String jenisiuran) {
        this.jenisiuran = jenisiuran;
    }

    public String getBulaniuran() {
        return bulaniuran;
    }

    public void setBulaniuran(String bulaniuran) {
        this.bulaniuran = bulaniuran;
    }

    public int getJumlahbayar() {
        return jumlahbayar;
    }

    public void setJumlahbayar(int jumlahbayar) {
        this.jumlahbayar = jumlahbayar;
    }

    public Date getTanggalbayar() {
        return tanggalbayar;
    }

    public void setTanggalbayar(Date tanggalbayar) {
        this.tanggalbayar = tanggalbayar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeiuran != null ? kodeiuran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iuran)) {
            return false;
        }
        Iuran other = (Iuran) object;
        if ((this.kodeiuran == null && other.kodeiuran != null) || (this.kodeiuran != null && !this.kodeiuran.equals(other.kodeiuran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Iuran[ kodeiuran=" + kodeiuran + " ]";
    }
    
}
