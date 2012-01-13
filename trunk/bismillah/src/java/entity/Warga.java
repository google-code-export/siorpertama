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
import javax.persistence.ManyToOne;

/**
 *
 * @author ACER
 */
@Entity
public class Warga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String noKtp;
    private String namaLengkap;
    private String alamatKtp;
    private String tempatLahir;
    private String tanggalLahir;
    private int rtKtp;
    private int rwKtp;
    private String kelurahanKtp;
    private String kecamatanKtp;
    private String kotaKtp;
    private Long idPengguna;
    @ManyToOne
    private Pengguna pengguna;
    private String idKeluarga;
    @ManyToOne
    private Keluarga keluarga;

    public Long getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Long idPengguna) {
        this.idPengguna = idPengguna;
    }
    

    public String getAlamatKtp() {
        return alamatKtp;
    }

    public void setAlamatKtp(String alamatKtp) {
        this.alamatKtp = alamatKtp;
    }

    public String getIdKeluarga() {
        return idKeluarga;
    }

    public void setIdKeluarga(String idKeluarga) {
        this.idKeluarga = idKeluarga;
    }

    public String getKecamatanKtp() {
        return kecamatanKtp;
    }

    public void setKecamatanKtp(String kecamatanKtp) {
        this.kecamatanKtp = kecamatanKtp;
    }

    public Keluarga getKeluarga() {
        return keluarga;
    }

    public void setKeluarga(Keluarga keluarga) {
        this.keluarga = keluarga;
    }

    public String getKelurahanKtp() {
        return kelurahanKtp;
    }

    public void setKelurahanKtp(String kelurahanKtp) {
        this.kelurahanKtp = kelurahanKtp;
    }

    public String getKotaKtp() {
        return kotaKtp;
    }

    public void setKotaKtp(String kotaKtp) {
        this.kotaKtp = kotaKtp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public int getRtKtp() {
        return rtKtp;
    }

    public void setRtKtp(int rtKtp) {
        this.rtKtp = rtKtp;
    }

    public int getRwKtp() {
        return rwKtp;
    }

    public void setRwKtp(int rwKtp) {
        this.rwKtp = rwKtp;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warga)) {
            return false;
        }
        Warga other = (Warga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warga[ id=" + id + " ]";
    }
    
}
