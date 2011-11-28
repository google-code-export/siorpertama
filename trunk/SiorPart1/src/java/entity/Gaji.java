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
@Table(name = "gaji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gaji.findAll", query = "SELECT g FROM Gaji g"),
    @NamedQuery(name = "Gaji.findByKodegaji", query = "SELECT g FROM Gaji g WHERE g.kodegaji = :kodegaji"),
    @NamedQuery(name = "Gaji.findByJenisgaji", query = "SELECT g FROM Gaji g WHERE g.jenisgaji = :jenisgaji"),
    @NamedQuery(name = "Gaji.findByGajikepada", query = "SELECT g FROM Gaji g WHERE g.gajikepada = :gajikepada"),
    @NamedQuery(name = "Gaji.findByBulangaji", query = "SELECT g FROM Gaji g WHERE g.bulangaji = :bulangaji"),
    @NamedQuery(name = "Gaji.findByJumlahgaji", query = "SELECT g FROM Gaji g WHERE g.jumlahgaji = :jumlahgaji"),
    @NamedQuery(name = "Gaji.findByTanggalbayargaji", query = "SELECT g FROM Gaji g WHERE g.tanggalbayargaji = :tanggalbayargaji")})
public class Gaji implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodegaji")
    private String kodegaji;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "jenisgaji")
    private String jenisgaji;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "gajikepada")
    private String gajikepada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "bulangaji")
    private String bulangaji;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jumlahgaji")
    private int jumlahgaji;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggalbayargaji")
    @Temporal(TemporalType.DATE)
    private Date tanggalbayargaji;

    public Gaji() {
    }

    public Gaji(String kodegaji) {
        this.kodegaji = kodegaji;
    }

    public Gaji(String kodegaji, String jenisgaji, String gajikepada, String bulangaji, int jumlahgaji, Date tanggalbayargaji) {
        this.kodegaji = kodegaji;
        this.jenisgaji = jenisgaji;
        this.gajikepada = gajikepada;
        this.bulangaji = bulangaji;
        this.jumlahgaji = jumlahgaji;
        this.tanggalbayargaji = tanggalbayargaji;
    }

    public String getKodegaji() {
        return kodegaji;
    }

    public void setKodegaji(String kodegaji) {
        this.kodegaji = kodegaji;
    }

    public String getJenisgaji() {
        return jenisgaji;
    }

    public void setJenisgaji(String jenisgaji) {
        this.jenisgaji = jenisgaji;
    }

    public String getGajikepada() {
        return gajikepada;
    }

    public void setGajikepada(String gajikepada) {
        this.gajikepada = gajikepada;
    }

    public String getBulangaji() {
        return bulangaji;
    }

    public void setBulangaji(String bulangaji) {
        this.bulangaji = bulangaji;
    }

    public int getJumlahgaji() {
        return jumlahgaji;
    }

    public void setJumlahgaji(int jumlahgaji) {
        this.jumlahgaji = jumlahgaji;
    }

    public Date getTanggalbayargaji() {
        return tanggalbayargaji;
    }

    public void setTanggalbayargaji(Date tanggalbayargaji) {
        this.tanggalbayargaji = tanggalbayargaji;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodegaji != null ? kodegaji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gaji)) {
            return false;
        }
        Gaji other = (Gaji) object;
        if ((this.kodegaji == null && other.kodegaji != null) || (this.kodegaji != null && !this.kodegaji.equals(other.kodegaji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gaji[ kodegaji=" + kodegaji + " ]";
    }
    
}
