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
 * @author Lia
 */
@Entity
public class Keluargaindo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idkel;
    
    private String kodekel;
    private String keplakel;
    private int anggotakel;

    public Integer getIdkel() {
        return idkel;
    }

    public void setIdkel(Integer idkel) {
        this.idkel = idkel;
    }

    public String getKodekel() {
        return kodekel;
    }

    public void setKodekel(String kodekel) {
        this.kodekel = kodekel;
    }

    public String getKeplakel() {
        return keplakel;
    }

    public void setKeplakel(String keplakel) {
        this.keplakel = keplakel;
    }

    public int getAnggotakel() {
        return anggotakel;
    }

    public void setAnggotakel(int anggotakel) {
        this.anggotakel = anggotakel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkel != null ? idkel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Keluargaindo other = (Keluargaindo) obj;
        if (this.idkel != other.idkel && (this.idkel == null || !this.idkel.equals(other.idkel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Keluargaindo[ idkel=" + idkel + " ]";
    }
    
    public boolean isKepalaKelNoChange(String kepalakel) {
        if (kepalakel.equalsIgnoreCase(this.keplakel)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodekel)) {
            return true;
        } else {
            return false;
        }
    }

    
}
