/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proit.pe.tabs;

import com.proit.pe.MainFrame;
import com.proit.pe.dao.ExpenditureDao;
import com.proit.pe.dao.ExpenditureTypeDao;
import com.proit.pe.entity.Expenditure;
import com.proit.pe.entity.ExpenditureType;
import com.proit.pe.util.DateUtil;
import com.proit.pe.util.MessageBox;
import com.proit.pe.validator.ExpenditureTypeValidator;
import com.proit.pe.validator.ExpenditureValidator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author anhnn
 */
public class AddExpenditurePane extends javax.swing.JPanel {
    private MainFrame mainFrame;
    /**
     * Creates new form AddExpenditurePane
     */
    public AddExpenditurePane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        
        initComponents();
        
        loadTypes();
    }
    
    public AddExpenditurePane(MainFrame mainFrame, int id) {
        this.mainFrame = mainFrame;
        
        initComponents();
        
        loadTypes();
        
        loadById(id);
    }
    
    private void loadById(int id){
        try {
            ExpenditureDao dao = new ExpenditureDao();
            
            Expenditure entity = dao.findById(id);
            
            txtId.setText("" +entity.getId());
            txtName.setText(entity.getName());
            ftfAmount.setText("" + entity.getAmount());
            DateUtil dateUtil = new DateUtil();
            ftfDate.setText(dateUtil.toString(entity.getExpenditureDate()));
            txaNote.setText(entity.getNote());
            
            for (int i = 0; i < cbxType.getItemCount(); i++) {
                var item = cbxType.getItemAt(i);
                if (item.getId() == entity.getType()){
                    cbxType.setSelectedItem(item);
                    break;
                }
            }
            changeFieldStates(true);
            changeButtonStates(true, false, true, true);
        } catch (Exception e) {
            MessageBox.showErrorMessage(this, "Error", e.getMessage());
        }
    }

    private void loadTypes(){
        try {
            ExpenditureTypeDao dao = new ExpenditureTypeDao();
            var list = dao.findAll();
            
            for (ExpenditureType item : list) {
                cbxType.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageBox.showErrorMessage(this, e.getMessage());
        }
    }
    private void changeButtonStates(boolean edit, boolean save, boolean update, boolean delete){
        btnEdit.setEnabled(edit);
        btnSave.setEnabled(save);
        btnUpdate.setEnabled(update);
        btnDelete.setEnabled(delete);
    }
    
    private void changeFieldStates(boolean isEditable){
        txtName.setEditable(isEditable);
        ftfAmount.setEditable(isEditable);
        ftfDate.setEditable(isEditable);
        txaNote.setEditable(isEditable);
        cbxType.setEditable(isEditable);
        cbxType.setEnabled(isEditable);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ftfAmount = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaNote = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        ftfDate = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Add New Expenditure");

        jLabel2.setText("ID:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        jLabel3.setText("Name:");

        jLabel4.setText("Amount:");

        ftfAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel5.setText("Type:");

        jLabel6.setText("Note:");

        txaNote.setColumns(20);
        txaNote.setRows(5);
        jScrollPane1.setViewportView(txaNote);

        jLabel7.setText("Date:");

        ftfDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ftfDate, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxType, javax.swing.GroupLayout.Alignment.LEADING, 0, 224, Short.MAX_VALUE)
                                            .addComponent(ftfAmount, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ftfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(ftfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_20.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save_20.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_20.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update_20.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expenditure_20.png"))); // NOI18N
        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_20.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (MessageBox.showConfirmMessage(this, "Do you want to update?")
                    == JOptionPane.NO_OPTION){
                return;
            }
            
            String valid = ExpenditureValidator.validate(txtName, 
                    ftfAmount, ftfDate, cbxType);
            if (valid != null){
                MessageBox.showErrorMessage(this, "Error", valid);
                return;
            }

            Expenditure entity = new Expenditure();
            entity.setName(txtName.getText());
            entity.setAmount(Double.parseDouble(ftfAmount.getText()));
            DateUtil dateUtil = new DateUtil();
            entity.setExpenditureDate(dateUtil.toDate(ftfDate.getText()));
            entity.setNote(txaNote.getText());
            ExpenditureType ext = (ExpenditureType)cbxType.getSelectedItem();
            entity.setType(ext.getId());
            
            entity.setId(Integer.parseInt(txtId.getText()));
            
            ExpenditureDao dao = new ExpenditureDao();
            var result = dao.update(entity);
            
            if (result){
                MessageBox.showInformationMessage(this, "Information", 
                    "Expenditure is updated");
            }else{
                MessageBox.showErrorMessage(this, "Expenditure can be updated");
                
            }
             
            changeFieldStates(false);
            
            changeButtonStates(true, false, false, true);
        } catch (Exception e) {
            e.printStackTrace();
            MessageBox.showErrorMessage(this, "Error", e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String valid = ExpenditureValidator.validate(txtName, 
                    ftfAmount, ftfDate, cbxType);
            if (valid != null){
                MessageBox.showErrorMessage(this, "Error", valid);
                return;
            }

            Expenditure entity = new Expenditure();
            entity.setName(txtName.getText());
            entity.setAmount(Double.parseDouble(ftfAmount.getText()));
            DateUtil dateUtil = new DateUtil();
            entity.setExpenditureDate(dateUtil.toDate(ftfDate.getText()));
            entity.setNote(txaNote.getText());
            ExpenditureType ext = (ExpenditureType)cbxType.getSelectedItem();
            entity.setType(ext.getId());
            
            ExpenditureDao dao = new ExpenditureDao();
            entity = dao.insert(entity);
            
            txtId.setText("" + entity.getId());
            
            changeFieldStates(false);
            
            changeButtonStates(true, false, true, true);
        } catch (Exception e) {
            e.printStackTrace();
            MessageBox.showErrorMessage(this, "Error", e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtId.setText("");
        txtName.setText("");
        ftfAmount.setText("");
        ftfDate.setText("");
        txaNote.setText("");
        
        changeFieldStates(true);
        changeButtonStates(false, true, false, false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        changeButtonStates(true, false, true, true);
        
        changeFieldStates(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (MessageBox.showConfirmMessage(this, "Do you want to delete?")
                    == JOptionPane.NO_OPTION){
                return;
            }
            
            int id = Integer.parseInt(txtId.getText());
            
            ExpenditureDao dao = new ExpenditureDao();
            var result = dao.delete(id);
            
            if (result){
                MessageBox.showInformationMessage(this, "Information", 
                    "Expenditure is deleted");
                
                btnNewActionPerformed(null);
            }else{
                MessageBox.showErrorMessage(this, "Expenditure can be deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageBox.showErrorMessage(this, "Error", e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        mainFrame.showListExpenditures();
    }//GEN-LAST:event_btnListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<ExpenditureType> cbxType;
    private javax.swing.JFormattedTextField ftfAmount;
    private javax.swing.JFormattedTextField ftfDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txaNote;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
