/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Putri A.
 */
@Entity
public class Gaji implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idgaji;
    private String kodebayar;
    private String jenisgaji;
    private String penerimagaji;
    private String bulangaji;
    private int jumlahgaji;
    private int tahungaji;
    
    @Temporal(TemporalType.DATE)
    private Date tanggalgaji;

    public Integer getIdgaji() {
        return idgaji;
    }

    public void setIdgaji(Integer idgaji) {
        this.idgaji = idgaji;
    }

    public String getKodebayar() {
        return kodebayar;
    }

    public void setKodebayar(String kodebayar) {
        this.kodebayar = kodebayar;
    }

    public String getJenisgaji() {
        return jenisgaji;
    }

    public void setJenisgaji(String jenisgaji) {
        this.jenisgaji = jenisgaji;
    }

    public String getPenerimagaji() {
        return penerimagaji;
    }

    public void setPenerimagaji(String penerimagaji) {
        this.penerimagaji = penerimagaji;
    }

    public String getBulangaji() {
        return bulangaji;
    }

    public void setBulangaji(String bulangaji) {
        this.bulangaji = bulangaji;
    }

    public int getJumlahgaji() {
        return jumlahgaji;
    }

    public void setJumlahgaji(int jumlahgaji) {
        this.jumlahgaji = jumlahgaji;
    }

    public Date getTanggalgaji() {
        return tanggalgaji;
    }

    public void setTanggalgaji(Date tanggalgaji) {
        this.tanggalgaji = tanggalgaji;
    }

    public int getTahungaji() {
        return tahungaji;
    }
    
    public void setTahungaji (int tahungaji) {
        this.tahungaji = tahungaji;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgaji != null ? idgaji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gaji)) {
            return false;
        }
        Gaji other = (Gaji) object;
        if ((this.idgaji == null && other.idgaji != null) || (this.idgaji != null && !this.idgaji.equals(other.idgaji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gaji[ idgaji=" + idgaji + " ]";
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodebayar)) {
            return true;
        } else {
            return false;
        }
    }


}
