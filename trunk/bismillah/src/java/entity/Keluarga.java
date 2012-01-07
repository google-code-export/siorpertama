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
public class Keluarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kodeKeluarga;
    private String kepalaKeluarga;
    private int anggotaKeluarga;
    private Long idPengguna;
    @ManyToOne
    private Pengguna pengguna;
    
    public Long getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Long idPengguna) {
        this.idPengguna = idPengguna;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    
    public int getAnggotaKeluarga() {
        return anggotaKeluarga;
    }

    public void setAnggotaKeluarga(int anggotaKeluarga) {
        this.anggotaKeluarga = anggotaKeluarga;
    }

    public String getKepalaKeluarga() {
        return kepalaKeluarga;
    }

    public void setKepalaKeluarga(String kepalaKeluarga) {
        this.kepalaKeluarga = kepalaKeluarga;
    }

    public String getKodeKeluarga() {
        return kodeKeluarga;
    }

    public void setKodeKeluarga(String kodeKeluarga) {
        this.kodeKeluarga = kodeKeluarga;
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
        if (!(object instanceof Keluarga)) {
            return false;
        }
        Keluarga other = (Keluarga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Keluarga[ id=" + id + " ]";
    }
    
}
