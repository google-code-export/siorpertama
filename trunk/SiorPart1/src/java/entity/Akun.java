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
 * @author TYA
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
    @NamedQuery(name = "Akun.findByJumlahrumah", query = "SELECT a FROM Akun a WHERE a.jumlahrumah = :jumlahrumah")})
public class Akun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "namaakun")
    private String namaakun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rtakun")
    private int rtakun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rwakun")
    private int rwakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kelurahanakun")
    private String kelurahanakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kecamatanakun")
    private String kecamatanakun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kotaakun")
    private String kotaakun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jumlahrumah")
    private int jumlahrumah;

    public Akun() {
    }

    public Akun(String username) {
        this.username = username;
    }

    public Akun(String username, String password, String email, String namaakun, int rtakun, int rwakun, String kelurahanakun, String kecamatanakun, String kotaakun, int jumlahrumah) {
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

    public int getRtakun() {
        return rtakun;
    }

    public void setRtakun(int rtakun) {
        this.rtakun = rtakun;
    }

    public int getRwakun() {
        return rwakun;
    }

    public void setRwakun(int rwakun) {
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

    public int getJumlahrumah() {
        return jumlahrumah;
    }

    public void setJumlahrumah(int jumlahrumah) {
        this.jumlahrumah = jumlahrumah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Akun[ username=" + username + " ]";
    }
    
}
