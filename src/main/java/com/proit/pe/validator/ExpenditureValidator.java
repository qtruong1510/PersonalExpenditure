/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proit.pe.validator;

import com.proit.pe.entity.ExpenditureType;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ExpenditureValidator {
    public static String validate(JTextField txtName, JTextField txtAmount,
            JTextField txtDate, JComboBox<ExpenditureType> cbxType){
        StringBuilder sb = new StringBuilder();
            
        if (Validator.isEmpty(txtName)){
            sb.append("Name must be entered\n");
        }
        
        if (Validator.isEmpty(txtAmount)){
            sb.append("Amount must be entered\n");
        }
        
        if (!Validator.isMin(txtAmount, 0)){
            sb.append("Amount must be greater than 0 or invalid number\n");
        }
        
        if (Validator.isEmpty(txtDate)){
            sb.append("Date must be entered\n");
        }
        if (!Validator.isDate(txtDate)){
            sb.append("Invalid date\n");
        }
        
        return sb.isEmpty()? null : sb.toString();
    }
}


















