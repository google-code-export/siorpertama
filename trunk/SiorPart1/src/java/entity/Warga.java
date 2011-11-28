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
@Table(name = "warga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warga.findAll", query = "SELECT w FROM Warga w"),
    @NamedQuery(name = "Warga.findByNoktp", query = "SELECT w FROM Warga w WHERE w.noktp = :noktp"),
    @NamedQuery(name = "Warga.findByNamalengkap", query = "SELECT w FROM Warga w WHERE w.namalengkap = :namalengkap"),
    @NamedQuery(name = "Warga.findByTempatlahir", query = "SELECT w FROM Warga w WHERE w.tempatlahir = :tempatlahir"),
    @NamedQuery(name = "Warga.findByAlamatktp", query = "SELECT w FROM Warga w WHERE w.alamatktp = :alamatktp"),
    @NamedQuery(name = "Warga.findByKotaktp", query = "SELECT w FROM Warga w WHERE w.kotaktp = :kotaktp"),
    @NamedQuery(name = "Warga.findByKelurahanKTP", query = "SELECT w FROM Warga w WHERE w.kelurahanKTP = :kelurahanKTP"),
    @NamedQuery(name = "Warga.findByKecamatanKTP", query = "SELECT w FROM Warga w WHERE w.kecamatanKTP = :kecamatanKTP"),
    @NamedQuery(name = "Warga.findByRtktp", query = "SELECT w FROM Warga w WHERE w.rtktp = :rtktp"),
    @NamedQuery(name = "Warga.findByRwktp", query = "SELECT w FROM Warga w WHERE w.rwktp = :rwktp"),
    @NamedQuery(name = "Warga.findByKewarganegaraan", query = "SELECT w FROM Warga w WHERE w.kewarganegaraan = :kewarganegaraan"),
    @NamedQuery(name = "Warga.findByKodekeluarga", query = "SELECT w FROM Warga w WHERE w.kodekeluarga = :kodekeluarga"),
    @NamedQuery(name = "Warga.findByTanggallahir", query = "SELECT w FROM Warga w WHERE w.tanggallahir = :tanggallahir")})
public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "noktp")
    private String noktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "namalengkap")
    private String namalengkap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tempatlahir")
    private String tempatlahir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamatktp")
    private String alamatktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kotaktp")
    private String kotaktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kelurahanKTP")
    private String kelurahanKTP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kecamatanKTP")
    private String kecamatanKTP;
    @Column(name = "RTKTP")
    private Integer rtktp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RWKTP")
    private int rwktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kewarganegaraan")
    private String kewarganegaraan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kodekeluarga")
    private String kodekeluarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggallahir")
    @Temporal(TemporalType.DATE)
    private Date tanggallahir;

    public Warga() {
    }

    public Warga(String noktp) {
        this.noktp = noktp;
    }

    public Warga(String noktp, String namalengkap, String tempatlahir, String alamatktp, String kotaktp, String kelurahanKTP, String kecamatanKTP, int rwktp, String kewarganegaraan, String kodekeluarga, Date tanggallahir) {
        this.noktp = noktp;
        this.namalengkap = namalengkap;
        this.tempatlahir = tempatlahir;
        this.alamatktp = alamatktp;
        this.kotaktp = kotaktp;
        this.kelurahanKTP = kelurahanKTP;
        this.kecamatanKTP = kecamatanKTP;
        this.rwktp = rwktp;
        this.kewarganegaraan = kewarganegaraan;
        this.kodekeluarga = kodekeluarga;
        this.tanggallahir = tanggallahir;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getAlamatktp() {
        return alamatktp;
    }

    public void setAlamatktp(String alamatktp) {
        this.alamatktp = alamatktp;
    }

    public String getKotaktp() {
        return kotaktp;
    }

    public void setKotaktp(String kotaktp) {
        this.kotaktp = kotaktp;
    }

    public String getKelurahanKTP() {
        return kelurahanKTP;
    }

    public void setKelurahanKTP(String kelurahanKTP) {
        this.kelurahanKTP = kelurahanKTP;
    }

    public String getKecamatanKTP() {
        return kecamatanKTP;
    }

    public void setKecamatanKTP(String kecamatanKTP) {
        this.kecamatanKTP = kecamatanKTP;
    }

    public Integer getRtktp() {
        return rtktp;
    }

    public void setRtktp(Integer rtktp) {
        this.rtktp = rtktp;
    }

    public int getRwktp() {
        return rwktp;
    }

    public void setRwktp(int rwktp) {
        this.rwktp = rwktp;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getKodekeluarga() {
        return kodekeluarga;
    }

    public void setKodekeluarga(String kodekeluarga) {
        this.kodekeluarga = kodekeluarga;
    }

    public Date getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(Date tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noktp != null ? noktp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.noktp == null && other.noktp != null) || (this.noktp != null && !this.noktp.equals(other.noktp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ noktp=" + noktp + " ]";
    }
    
}
