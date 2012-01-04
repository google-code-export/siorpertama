
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
 * @author acer
 */
@Entity

public class Akun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;
    private String rtakun;
    private String rwakun;
    private String kelurahanakun;
    private String kecamatanakun;
    private String kotaakun;
    private String jumlahrumah;

  
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
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRtakun() {
        return rtakun;
    }

    public void setRtakun(String rtakun) {
        this.rtakun = rtakun;
    }

    public String getRwakun() {
        return rwakun;
    }

    public void setRwakun(String rwakun) {
        this.rwakun = rwakun;
    }

    public String getKelurahanakun() {
        return kelurahanakun;
    }

    public void setKelurahanakun(String kelurahanakun) {
        this.kelurahanakun = kelurahanakun;
    }

    public String getKecamatanakun() {
        return kecamatanakun;
    }

    public void setKecamatanakun(String kecamatanakun) {
        this.kecamatanakun = kecamatanakun;
    }

    public String getKotaakun() {
        return kotaakun;
    }

    public void setKotaakun(String kotaakun) {
        this.kotaakun = kotaakun;
    }

    public String getJumlahrumah() {
        return jumlahrumah;
    }

    public void setJumlahrumah(String jumlahrumah) {
        this.jumlahrumah = jumlahrumah;
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
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Akun[ id=" + id + " ]";
    }
    
    
    public boolean isEmailNoChange(String email) {
        if (email.equalsIgnoreCase(this.email)) {
            return true;
        } else {
            return false;
        }
    }
}
