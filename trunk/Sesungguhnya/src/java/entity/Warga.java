/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ntonk
 */
/*@Entity
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
*/

public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idWarga;
    private int noktp;
    private String namalengkap;
    private String tempatlahir;
    private String alamat;
    private String kotaktp;
    private String kelurahanktp;
    private String kecamatanktp;
    private String rtktp;
    private String rwktp;
    private String kewarganegaraanktp;
    private String kodekeluarga;
    private String tanggallahir;


    public int getIdWarga() {
        return idWarga;
    }
    
    public void setIdWarga(int idWarga) {
        this.idWarga = idWarga;
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

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (idWarga != null ? idWarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.idWarga == null && other.idWarga != null) || (this.idWarga != null && !this.idWarga.equals(other.idWarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ idWarga=" + idWarga + " ]";
    }
    
    /*public boolean isNoKTPNoChange(String noktp) {
        if (noktp.equalsIgnoreCase(this.noktp)) {
            return true;
        } else {
            return false;
        }
    }*/
    
}
