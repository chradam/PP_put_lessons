/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.cie.coffee;

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
 * @author Adam Ch
 */
@Entity
@Table(name = "COFFEE_HOUSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoffeeHouses.findAll", query = "SELECT c FROM CoffeeHouses c")
    , @NamedQuery(name = "CoffeeHouses.findByStoreId", query = "SELECT c FROM CoffeeHouses c WHERE c.storeId = :storeId")
    , @NamedQuery(name = "CoffeeHouses.findByCity", query = "SELECT c FROM CoffeeHouses c WHERE c.city = :city")
    , @NamedQuery(name = "CoffeeHouses.findByCoffee", query = "SELECT c FROM CoffeeHouses c WHERE c.coffee = :coffee")
    , @NamedQuery(name = "CoffeeHouses.findByMerch", query = "SELECT c FROM CoffeeHouses c WHERE c.merch = :merch")
    , @NamedQuery(name = "CoffeeHouses.findByTotal", query = "SELECT c FROM CoffeeHouses c WHERE c.total = :total")})
public class CoffeeHouses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STORE_ID")
    private Integer storeId;
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "COFFEE")
    private int coffee;
    @Basic(optional = false)
    @Column(name = "MERCH")
    private int merch;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private int total;

    public CoffeeHouses() {
    }

    public CoffeeHouses(Integer storeId) {
        this.storeId = storeId;
    }

    public CoffeeHouses(Integer storeId, int coffee, int merch, int total) {
        this.storeId = storeId;
        this.coffee = coffee;
        this.merch = merch;
        this.total = total;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getMerch() {
        return merch;
    }

    public void setMerch(int merch) {
        this.merch = merch;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoffeeHouses)) {
            return false;
        }
        CoffeeHouses other = (CoffeeHouses) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.poznan.put.cie.coffee.CoffeeHouses[ storeId=" + storeId + " ]";
    }
    
}
