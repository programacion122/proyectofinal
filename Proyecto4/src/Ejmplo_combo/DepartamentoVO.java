/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejmplo_combo;

/**
 *
 * @author David
 */
public class DepartamentoVO{
    
 private int idDepartamento;
 private String departamento;
 
 public DepartamentoVO(){}
 
 public DepartamentoVO(int id, String name){
     this.idDepartamento = id;
     this.departamento = name;
 }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String toString(){
        return this.departamento;
    }
    
}
