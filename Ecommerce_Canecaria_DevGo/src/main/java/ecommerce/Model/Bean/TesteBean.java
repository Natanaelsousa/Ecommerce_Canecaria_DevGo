/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author natanael.ssousa
 */
@ManagedBean
@SessionScoped
public class TesteBean implements Serializable {
    
    private Integer selectedId;
    
    private Integer id;

    /**
     * Creates a new instance of TesteBean
     */
    public TesteBean() {
    }
    
    public String adicionar() {
        this.id = getSelectedId();
        return "Produto";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the selectedId
     */
    public Integer getSelectedId() {
        return selectedId;
    }

    /**
     * @param selectedId the selectedId to set
     */
    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }
    
}
