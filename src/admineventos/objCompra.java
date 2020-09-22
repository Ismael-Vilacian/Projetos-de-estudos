/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineventos;

/**
 *
 * @author ISMAEL
 */
public class objCompra {
    private String idEvento;
    private String CPFcomprador;
    private String quantIngreco;
    private String valorTotal;
    private String codigoCompra;
    
    public objCompra(String idEvento, String CPFcomprador, String quantIngreco, String valorTotal, String codigoCompra){
        this.idEvento = idEvento;
        this.CPFcomprador = CPFcomprador;
        this.quantIngreco = quantIngreco;
        this.valorTotal = valorTotal;
        this.codigoCompra = codigoCompra;
        
    }
    
    public void setIdCompra(String idEvento){
        this.idEvento = idEvento;
    }
    public String getIdCompra(){
        return idEvento;
    }
    
    public void setCpfCompra(String CPFcomprador){
        this.CPFcomprador = CPFcomprador;
    }
    public String getCpfCompra(){
        return CPFcomprador;
    }
    
    public void setQauntIngrCompra(String quantIngreco){
        this.quantIngreco = quantIngreco;
    }
    public String getQauntIngrCompra(){
        return quantIngreco;
    }
    
    public void setvalorTotal(String valorTotal){
        this.valorTotal = valorTotal;
    }
    public String getvalorTotal(){
        return valorTotal;
    }
    
    public void setCodCompra(String codigoCompra){
        this.codigoCompra = codigoCompra;
    }
    public String getCodCompra(){
        return codigoCompra;
    }
    
}
    
