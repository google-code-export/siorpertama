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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ntonk
 */
@Entity
@Table(name = "gaji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gaji.findAll", query = "SELECT g FROM Gaji g"),
    @NamedQuery(name = "Gaji.findByIdgaji", query = "SELECT g FROM Gaji g WHERE g.idgaji = :idgaji"),
    @NamedQuery(name = "Gaji.findByNamapenerima", query = "SELECT g FROM Gaji g WHERE g.namapenerima = :namapenerima"),
    @NamedQuery(name = "Gaji.findByPeriodegaji", query = "SELECT g FROM Gaji g WHERE g.periodegaji = :periodegaji"),
    @NamedQuery(name = "Gaji.findByPosisi", query = "SELECT g FROM Gaji g WHERE g.posisi = :posisi")})
public class Gaji implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idgaji")
    private Long idgaji;
    @Basic(optional = false)
    @Column(name = "namapenerima")
    private String namapenerima;
    @Basic(optional = false)
    @Column(name = "periodegaji")
    private String periodegaji;
    @Basic(optional = false)
    @Column(name = "posisi")
    private String posisi;

    public Gaji() {
    }

    public Gaji(Long idgaji) {
        this.idgaji = idgaji;
    }

    public Gaji(Long idgaji, String namapenerima, String periodegaji, String posisi) {
        this.idgaji = idgaji;
        this.namapenerima = namapenerima;
        this.periodegaji = periodegaji;
        this.posisi = posisi;
    }

    public Long getIdgaji() {
        return idgaji;
    }

    public void setIdgaji(Long idgaji) {
        this.idgaji = idgaji;
    }

    public String getNamapenerima() {
        return namapenerima;
    }

    public void setNamapenerima(String namapenerima) {
        this.namapenerima = namapenerima;
    }

    public String getPeriodegaji() {
        return periodegaji;
    }

    public void setPeriodegaji(String periodegaji) {
        this.periodegaji = periodegaji;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
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
    
}
