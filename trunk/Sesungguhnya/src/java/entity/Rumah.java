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
 * @author Meylindra Ap
 */
@Entity
public class Rumah implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idrumah; 
    private int rt;
    private int rw;
    private String Alamat;
    private String kelurahan;
    private String kodeRumah;
    private String kecamatan;
    private String kota;
    private String provinsi;
    

    public Integer getIdrum() {
        return idrumah;
    }

    public void setIdrum(Integer idrumah) {
        this.idrumah = idrumah;
    }

    public String getKoderum() {
        return kodeRumah;
    }
    public int getRT(){
       return rt; 
    } 
    public void setRT(int rt){
        this.rt=rt;
    }
    public int getRW(){
        return rw;
    }
   public void setRW(int rw){
        this.rw=rw;
    }
    public void setKodeRumah(String kodeRumah) {
        this.kodeRumah = kodeRumah;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }
    public void setKelurahan(String kelurahan){
        this.kelurahan=kelurahan;
    }
    public String getKecamatan(){
        return kecamatan;
    }
    public void setKecamatan(String kecamatan){
        this.kecamatan=kecamatan;
    }
    public String getKota(){
        return kota;
    }
    public void setKota(String kota){
        this.kota=kota;
    }
    public String getProvinsi(){
      return provinsi;  
    }
    public void setPovinsi(String provinsi) {
        this.provinsi=provinsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrumah != null ? idrumah.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Rumah)) {
            return false;
        }
        Rumah other = (Rumah) object;
        if ((this.idrumah == null && other.idrumah != null) || (this.idrumah != null && !this.idrumah.equals(other.idrumah))) {
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
