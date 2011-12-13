/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Putri A.
 */
@Entity
public class Rumah implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRum;
    private String alamatRumah;
    private int rtRumah;
    private int rwRumah;
    private String kelurahanRt;
    private String kecamatanRumah;
    private String kotaRumah;
    private String provinsiRumah;
    private String kodeRumah;

    public Integer getIdRum() {
        return idRum;
    }

    public void setIdRum(Integer idRum) {
        this.idRum = idRum;
    }

    public String getAlamatRumah() {
        return alamatRumah;
    }

    public void setAlamatRumah(String alamatRumah) {
        this.alamatRumah = alamatRumah;
    }

    public int getRtRumah() {
        return rtRumah;
    }

    public void setRtRumah(int rtRumah) {
        this.rtRumah = rtRumah;
    }

    public int getRwRumah() {
        return rwRumah;
    }

    public void setRwRumah(int rwRumah) {
        this.rwRumah = rwRumah;
    }

    public String getKelurahanRt() {
        return kelurahanRt;
    }

    public void setKelurahanRt(String kelurahanRt) {
        this.kelurahanRt = kelurahanRt;
    }

    public String getKecamatanRumah() {
        return kecamatanRumah;
    }

    public void setKecamatanRumah(String kecamatanRumah) {
        this.kecamatanRumah = kecamatanRumah;
    }

    public String getKotaRumah() {
        return kotaRumah;
    }

    public void setKotaRumah(String kotaRumah) {
        this.kotaRumah = kotaRumah;
    }

    public String getProvinsiRumah() {
        return provinsiRumah;
    }

    public void setProvinsiRumah(String provinsiRumah) {
        this.provinsiRumah = provinsiRumah;
    }
    
    public String getKodeRumah() {
        return provinsiRumah;
    }

    public void setKodeRumah(String kodeRumah) {
        this.kodeRumah = kodeRumah;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRum != null ? idRum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rumah)) {
            return false;
        }
        Rumah other = (Rumah) object;
        if ((this.idRum == null && other.idRum != null) || (this.idRum != null && !this.idRum.equals(other.idRum))) {
            return false;
        }
        return true;
    }

     public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodeRumah)) {
            return true;
        } else {
            return false;
        }
    }
    
}
