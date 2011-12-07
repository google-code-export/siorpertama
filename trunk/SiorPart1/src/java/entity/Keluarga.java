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
 * @author TYA
 */
@Entity
public class Keluarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String kepalakeluarga;
    
    private String anggotakeluarga;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
      public String getKepalakeluarga() {
        return kepalakeluarga;
    }

    public void setKepalakeluarga(String kepalakeluarga) {
        this.kepalakeluarga = kepalakeluarga;
    }
    
    
     public String getAnggotakeluarga() {
        return anggotakeluarga;
    }

    public void setAnggotakeluarga(String anggotakeluarga) {
        this.anggotakeluarga = anggotakeluarga;
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
        return "entitas.Keluarga[ id=" + id + " ]";
    }
    
}
