/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Status;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sibele
 */
public interface StatusDAO {
     public List<Status> listarStatusDasVenda() throws SQLException ;
}
