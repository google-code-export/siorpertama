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
 * @author ntonk
 */
@Entity
@Table(name = "warga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warga.findAll", query = "SELECT w FROM Warga w"),
    @NamedQuery(name = "Warga.findByIdktp", query = "SELECT w FROM Warga w WHERE w.idktp = :idktp"),
    @NamedQuery(name = "Warga.findByNoktp", query = "SELECT w FROM Warga w WHERE w.noktp = :noktp"),
    @NamedQuery(name = "Warga.findByNamalengkap", query = "SELECT w FROM Warga w WHERE w.namalengkap = :namalengkap"),
    @NamedQuery(name = "Warga.findByTempatlahir", query = "SELECT w FROM Warga w WHERE w.tempatlahir = :tempatlahir"),
    @NamedQuery(name = "Warga.findByAlamat", query = "SELECT w FROM Warga w WHERE w.alamat = :alamat"),
    @NamedQuery(name = "Warga.findByKotaktp", query = "SELECT w FROM Warga w WHERE w.kotaktp = :kotaktp"),
    @NamedQuery(name = "Warga.findByKelurahanktp", query = "SELECT w FROM Warga w WHERE w.kelurahanktp = :kelurahanktp"),
    @NamedQuery(name = "Warga.findByKecamatanktp", query = "SELECT w FROM Warga w WHERE w.kecamatanktp = :kecamatanktp"),
    @NamedQuery(name = "Warga.findByRtktp", query = "SELECT w FROM Warga w WHERE w.rtktp = :rtktp"),
    @NamedQuery(name = "Warga.findByRwktp", query = "SELECT w FROM Warga w WHERE w.rwktp = :rwktp"),
    @NamedQuery(name = "Warga.findByKewarganegaraanktp", query = "SELECT w FROM Warga w WHERE w.kewarganegaraanktp = :kewarganegaraanktp"),
    @NamedQuery(name = "Warga.findByKodekeluarga", query = "SELECT w FROM Warga w WHERE w.kodekeluarga = :kodekeluarga"),
    @NamedQuery(name = "Warga.findByTanggallahir", query = "SELECT w FROM Warga w WHERE w.tanggallahir = :tanggallahir")})
public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idktp")
    private Integer idktp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noktp")
    private int noktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "namalengkap")
    private String namalengkap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tempatlahir")
    private String tempatlahir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kotaktp")
    private String kotaktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kelurahanktp")
    private String kelurahanktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kecamatanktp")
    private String kecamatanktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rtktp")
    private String rtktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwktp")
    private String rwktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kewarganegaraanktp")
    private String kewarganegaraanktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kodekeluarga")
    private String kodekeluarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tanggallahir")
    private String tanggallahir;

    public Warga() {
    }

    public Warga(Integer idktp) {
        this.idktp = idktp;
    }

    public Warga(Integer idktp, int noktp, String namalengkap, String tempatlahir, String alamat, String kotaktp, String kelurahanktp, String kecamatanktp, String rtktp, String rwktp, String kewarganegaraanktp, String kodekeluarga, String tanggallahir) {
        this.idktp = idktp;
        this.noktp = noktp;
        this.namalengkap = namalengkap;
        this.tempatlahir = tempatlahir;
        this.alamat = alamat;
        this.kotaktp = kotaktp;
        this.kelurahanktp = kelurahanktp;
        this.kecamatanktp = kecamatanktp;
        this.rtktp = rtktp;
        this.rwktp = rwktp;
        this.kewarganegaraanktp = kewarganegaraanktp;
        this.kodekeluarga = kodekeluarga;
        this.tanggallahir = tanggallahir;
    }

    public Integer getIdktp() {
        return idktp;
    }

    public void setIdktp(Integer idktp) {
        this.idktp = idktp;
    }

    public int getNoktp() {
        return noktp;
    }

    public void setNoktp(int noktp) {
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKotaktp() {
        return kotaktp;
    }

    public void setKotaktp(String kotaktp) {
        this.kotaktp = kotaktp;
    }

    public String getKelurahanktp() {
        return kelurahanktp;
    }

    public void setKelurahanktp(String kelurahanktp) {
        this.kelurahanktp = kelurahanktp;
    }

    public String getKecamatanktp() {
        return kecamatanktp;
    }

    public void setKecamatanktp(String kecamatanktp) {
        this.kecamatanktp = kecamatanktp;
    }

    public String getRtktp() {
        return rtktp;
    }

    public void setRtktp(String rtktp) {
        this.rtktp = rtktp;
    }

    public String getRwktp() {
        return rwktp;
    }

    public void setRwktp(String rwktp) {
        this.rwktp = rwktp;
    }

    public String getKewarganegaraanktp() {
        return kewarganegaraanktp;
    }

    public void setKewarganegaraanktp(String kewarganegaraanktp) {
        this.kewarganegaraanktp = kewarganegaraanktp;
    }

    public String getKodekeluarga() {
        return kodekeluarga;
    }

    public void setKodekeluarga(String kodekeluarga) {
        this.kodekeluarga = kodekeluarga;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idktp != null ? idktp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.idktp == null && other.idktp != null) || (this.idktp != null && !this.idktp.equals(other.idktp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ idktp=" + idktp + " ]";
    }
    
}
