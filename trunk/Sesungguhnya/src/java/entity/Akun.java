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
public class Akun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "namaakun")
    private String namaakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rtakun")
    private String rtakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwakun")
    private String rwakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kelurahanakun")
    private String kelurahanakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kecamatanakun")
    private String kecamatanakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kotaakun")
    private String kotaakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "jumlahrumah")
    private String jumlahrumah;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "iduser")
    private String iduser;

    public Akun() {
    }

    public Akun(String iduser) {
        this.iduser = iduser;
    }

    public Akun(String iduser, String username, String password, String email, String namaakun, String rtakun, String rwakun, String kelurahanakun, String kecamatanakun, String kotaakun, String jumlahrumah) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaakun = namaakun;
        this.rtakun = rtakun;
        this.rwakun = rwakun;
        this.kelurahanakun = kelurahanakun;
        this.kecamatanakun = kecamatanakun;
        this.kotaakun = kotaakun;
        this.jumlahrumah = jumlahrumah;
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

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Akun[ iduser=" + iduser + " ]";
    }
    
}
