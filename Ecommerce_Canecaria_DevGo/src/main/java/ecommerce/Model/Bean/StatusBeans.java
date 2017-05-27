/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.StatusDAO;
import ecommerce.Model.DaoImplementation.StatusDAOImpl;
import ecommerce.Model.MetodosAcessores.Status;
import java.util.List;
import javax.faces.bean.ManagedBean;
/* @author sibele */
@ManagedBean(name = "StatusVendaBen")
public class StatusBeans {

    
    public StatusBeans() {
    }
    /* Lista os tipos de solicitações cadastrados no banco */
    public List<Status> listarStatusVenda() throws Exception {
        StatusDAO statusDAO = new StatusDAOImpl();

        List<Status> listarTiposDeStatus = statusDAO.listarStatusDasVenda();
       
     
        return listarTiposDeStatus;
    }
}
