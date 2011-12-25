/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ntonk
 */
/*@Entity
@Table(name = "akun")
@XmlRootElement
  @NamedQueries({
    @NamedQuery(name = "Akun.findAll", query = "SELECT a FROM Akun a"),
    @NamedQuery(name = "Akun.findByUsername", query = "SELECT a FROM Akun a WHERE a.username = :username"),
    @NamedQuery(name = "Akun.findByPassword", query = "SELECT a FROM Akun a WHERE a.password = :password"),
    @NamedQuery(name = "Akun.findByEmail", query = "SELECT a FROM Akun a WHERE a.email = :email"),
    @NamedQuery(name = "Akun.findByNamaakun", query = "SELECT a FROM Akun a WHERE a.namaakun = :namaakun"),
    @NamedQuery(name = "Akun.findByRtakun", query = "SELECT a FROM Akun a WHERE a.rtakun = :rtakun"),
    @NamedQuery(name = "Akun.findByRwakun", query = "SELECT a FROM Akun a WHERE a.rwakun = :rwakun"),
    @NamedQuery(name = "Akun.findByKelurahanakun", query = "SELECT a FROM Akun a WHERE a.kelurahanakun = :kelurahanakun"),
    @NamedQuery(name = "Akun.findByKecamatanakun", query = "SELECT a FROM Akun a WHERE a.kecamatanakun = :kecamatanakun"),
    @NamedQuery(name = "Akun.findByKotaakun", query = "SELECT a FROM Akun a WHERE a.kotaakun = :kotaakun"),
    @NamedQuery(name = "Akun.findByJumlahrumah", query = "SELECT a FROM Akun a WHERE a.jumlahrumah = :jumlahrumah"),
    @NamedQuery(name = "Akun.findByIduser", query = "SELECT a FROM Akun a WHERE a.iduser = :iduser")})
*/
public class Akun implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAkun;
    private String username;
    private String password;
    private String email;
    private String namaakun;
    private String rtakun;
    private String rwakun;
    private String kelurahanakun;
    private String kecamatanakun;
    private String kotaakun;
    private String jumlahrumah;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaakun() {
        return namaakun;
    }

    public void setNamaakun(String namaakun) {
        this.namaakun = namaakun;
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

    public Long getIdakun() {
        return idAkun;
    }

    public void setIdakun(Long idAkun) {
        this.idAkun = idAkun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAkun != null ? idAkun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.idAkun == null && other.idAkun != null) || (this.idAkun != null && !this.idAkun.equals(other.idAkun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Akun[ idAkun=" + idAkun + " ]";
    }

    public Long getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(Long idAkun) {
        this.idAkun = idAkun;
    }
    
}
