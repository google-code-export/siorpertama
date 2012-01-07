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
 * @author ACER
 */
@Entity
public class Pengguna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String nmPengguna;
    private int rtPengguna;
    private int rwPengguna;
    private String kelurahanPengguna;
    private String kecamatanPengguna;
    private String kotaPengguna;
    private int jumlahrumah;

    public int getJumlahrumah() {
        return jumlahrumah;
    }

    public void setJumlahrumah(int jumlahrumah) {
        this.jumlahrumah = jumlahrumah;
    }

    public String getKecamatanPengguna() {
        return kecamatanPengguna;
    }

    public void setKecamatanPengguna(String kecamatanPengguna) {
        this.kecamatanPengguna = kecamatanPengguna;
    }

    public String getKelurahanPengguna() {
        return kelurahanPengguna;
    }

    public void setKelurahanPengguna(String kelurahanPengguna) {
        this.kelurahanPengguna = kelurahanPengguna;
    }

    public String getKotaPengguna() {
        return kotaPengguna;
    }

    public void setKotaPengguna(String kotaPengguna) {
        this.kotaPengguna = kotaPengguna;
    }

    public int getRtPengguna() {
        return rtPengguna;
    }

    public void setRtPengguna(int rtPengguna) {
        this.rtPengguna = rtPengguna;
    }

    public int getRwPengguna() {
        return rwPengguna;
    }

    public void setRwPengguna(int rwPengguna) {
        this.rwPengguna = rwPengguna;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email=email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password=password;
    }
    
    public String getNmPengguna() {
        return nmPengguna;
    }
    
    public void setNmPengguna(String nmPengguna) {
        this.nmPengguna=nmPengguna;
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
        if (!(object instanceof Pengguna)) {
            return false;
        }
        Pengguna other = (Pengguna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pengguna[ id=" + id + " ]";
    }
    
}
