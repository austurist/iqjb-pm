/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf;

/**
 *
 * @author oracle
 */
public interface IqjbLogService {
    
     void create(String content) throws LogException;
    
}