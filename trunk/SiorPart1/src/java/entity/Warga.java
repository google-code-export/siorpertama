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
@Table(name = "warga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warga.findAll", query = "SELECT w FROM Warga w"),
    @NamedQuery(name = "Warga.findByIdKTP", query = "SELECT w FROM Warga w WHERE w.idKTP = :idKTP"),
    @NamedQuery(name = "Warga.findByNamaLengkap", query = "SELECT w FROM Warga w WHERE w.namaLengkap = :namaLengkap"),
    @NamedQuery(name = "Warga.findByTempatLahir", query = "SELECT w FROM Warga w WHERE w.tempatLahir = :tempatLahir"),
    @NamedQuery(name = "Warga.findByTanggalLahir", query = "SELECT w FROM Warga w WHERE w.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "Warga.findByAlamatKTP", query = "SELECT w FROM Warga w WHERE w.alamatKTP = :alamatKTP")})
public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdKTP")
    private Integer idKTP;
    @Basic(optional = false)
    @Column(name = "NamaLengkap")
    private String namaLengkap;
    @Basic(optional = false)
    @Column(name = "TempatLahir")
    private String tempatLahir;
    @Basic(optional = false)
    @Column(name = "TanggalLahir")
    private String tanggalLahir;
    @Basic(optional = false)
    @Column(name = "AlamatKTP")
    private String alamatKTP;

    public Warga() {
    }

    public Warga(Integer idKTP) {
        this.idKTP = idKTP;
    }

    public Warga(Integer idKTP, String namaLengkap, String tempatLahir, String tanggalLahir, String alamatKTP) {
        this.idKTP = idKTP;
        this.namaLengkap = namaLengkap;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.alamatKTP = alamatKTP;
    }

    public Integer getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(Integer idKTP) {
        this.idKTP = idKTP;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamatKTP() {
        return alamatKTP;
    }

    public void setAlamatKTP(String alamatKTP) {
        this.alamatKTP = alamatKTP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKTP != null ? idKTP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.idKTP == null && other.idKTP != null) || (this.idKTP != null && !this.idKTP.equals(other.idKTP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ idKTP=" + idKTP + " ]";
    }
    
}
