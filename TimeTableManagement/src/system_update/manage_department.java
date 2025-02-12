/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_update;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pasindu
 */
public final class manage_department extends javax.swing.JFrame {

    /**
     * Creates new form manage_department
     */
    public manage_department() {
        initComponents();
        jtableColumnWidth();
        //call hide size
        hidesize();
          //Gride Add Jtable
        jTable1.setShowGrid(true);

    }
    
//Set Desktop Application size and hide Maximize Window
void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      
  }
 
    
 void jtableColumnWidth(){
 
        jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
       
 
 
 
 
 }
   
   
    
public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from faculty_dep";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){
                       //Data will be added until finish
                       String fac_id       = String.valueOf(rs.getInt("fac_id"));
                       String name    = rs.getString("name");
                       String department        = rs.getString("department");
                       String dean_name =rs.getString("dean_name");
                       String dep_head_name=rs.getString("dep_head_name");
                       String dep_head_email=rs.getString("dep_head_email");

                       //string array for store data into jtable
                       String tbData[]={fac_id,name,department,dean_name,dep_head_name,dep_head_email};
                       DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                       
                       tblModel.addRow(tbData);
                   }
                   
                   rs.close();
                   pst.close();
                   cn.close();
               }
                 }catch(SQLException e){
                
                
                    JOptionPane.showMessageDialog(this, e);
                
                }
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtfacultyid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfacultyname = new javax.swing.JTextField();
        txtdepartment = new javax.swing.JTextField();
        txtdeanname = new javax.swing.JTextField();
        txtdepartmenthead = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtheademail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        MenuClick = new javax.swing.JButton();
        AddDepartmentClick = new javax.swing.JButton();
        ManageDepartmentClick = new javax.swing.JButton();
        BackClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(484, 439));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fac_Id", "Fac_Name", "Department", "Dean_Name", "Deparment_Head", "Department_Head_Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setRowHeight(55);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(3000);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(3000);
            jTable1.getColumnModel().getColumn(2).setMinWidth(240);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(3000);
            jTable1.getColumnModel().getColumn(3).setMinWidth(230);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(3000);
            jTable1.getColumnModel().getColumn(4).setMinWidth(230);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(3000);
            jTable1.getColumnModel().getColumn(5).setMinWidth(230);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(3000);
        }

        UpdateButton.setBackground(new java.awt.Color(0, 153, 153));
        UpdateButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(0, 153, 153));
        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Faculty Id:");

        txtfacultyid.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtfacultyid.setText("2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Faculty Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Department:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Dean Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Department Head:");

        txtfacultyname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfacultynameActionPerformed(evt);
            }
        });

        txtdeanname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeannameActionPerformed(evt);
            }
        });

        txtdepartmenthead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdepartmentheadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Department Head Email");

        txtheademail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtheademailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtdepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtfacultyname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdeanname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdepartmenthead, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(txtheademail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(txtfacultyid)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfacultyid))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtfacultyname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtdepartmenthead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtheademail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdeanname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 80, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Department");

        MenuClick.setBackground(new java.awt.Color(0, 153, 153));
        MenuClick.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        MenuClick.setText("Menu");
        MenuClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClickActionPerformed(evt);
            }
        });

        AddDepartmentClick.setBackground(new java.awt.Color(0, 153, 153));
        AddDepartmentClick.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        AddDepartmentClick.setText("Add Department");
        AddDepartmentClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDepartmentClickActionPerformed(evt);
            }
        });

        ManageDepartmentClick.setBackground(new java.awt.Color(0, 153, 153));
        ManageDepartmentClick.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ManageDepartmentClick.setText("Manage Department");
        ManageDepartmentClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageDepartmentClickActionPerformed(evt);
            }
        });

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddDepartmentClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MenuClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageDepartmentClick, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MenuClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(AddDepartmentClick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ManageDepartmentClick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
menu_updates mu;
    private void MenuClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClickActionPerformed
        // TODO add your handling code here:
       try {
            if (mu == null) {
                mu = new menu_updates();
            }

            mu.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuClickActionPerformed
    Add_department sdu;
    private void AddDepartmentClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDepartmentClickActionPerformed
        // TODO add your handling code here:
    try {
            if (sdu == null) {
                sdu = new Add_department();
            }

            sdu.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddDepartmentClickActionPerformed
manage_department md;
    private void ManageDepartmentClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageDepartmentClickActionPerformed
        // TODO add your handling code here:
         try {
            if (md == null) {
                md = new manage_department();
            }

            md.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ManageDepartmentClickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
      try {
            if (mu == null) {
                mu = new menu_updates();
            }

            mu.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BackClickActionPerformed

    private void jScrollPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPane1AncestorAdded
        // TODO add your handling code here:
        displaytable();
    }//GEN-LAST:event_jScrollPane1AncestorAdded

    private void txtfacultynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfacultynameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfacultynameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
  int i=jTable1.getSelectedRow();
           
            TableModel model=jTable1.getModel();
           
            txtfacultyid.setText(model.getValueAt(i, 0).toString());
            txtfacultyname.setText(model.getValueAt(i, 1).toString());
            txtdepartment.setText(model.getValueAt(i, 2).toString());
            txtdeanname.setText(model.getValueAt(i, 3).toString());
            txtdepartmenthead.setText(model.getValueAt(i, 4).toString());
            txtheademail.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

     private void updateRe_table(){
       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from faculty_dep";

try{
           PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

           jTable1.setModel(DbUtils.resultSetToTableModel(rs));

           jtableColumnWidth();
           
           pst.close();
           cn.close();
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }  
    
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
           try{
                Connection cn=connection.DB_Connect.ConnecrDB();

                int row =jTable1.getSelectedRow(); 
                String value =(jTable1.getModel().getValueAt(row, 0).toString());
                String update="Update faculty_dep set name=?,department=?,dean_name=?,dep_head_name=?,dep_head_email=?  where fac_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                pst.setString(1,txtfacultyname.getText());
                pst.setString(2,txtdepartment.getText());
                pst.setString(3,txtdeanname.getText());
                pst.setString(4,txtdepartmenthead.getText());
                pst.setString(5,txtheademail.getText());

      
      if(txtdeanname.getText().trim().isEmpty()||txtdepartment.getText().trim().isEmpty()||txtdeanname.getText().isEmpty()||txtheademail.getText().isEmpty()){          
     
                          JOptionPane.showMessageDialog(this, "Text Feildes Are Empty");

          
          
      }else{    
                JOptionPane.showMessageDialog(this, "Upadate Sucsessfully");
                pst.execute();

            
                updateRe_table();
        
                pst.close();
                cn.close();
      }
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void txtdeannameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeannameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeannameActionPerformed

    private void txtdepartmentheadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdepartmentheadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdepartmentheadActionPerformed

    private void txtheademailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtheademailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtheademailActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
             Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        int row =jTable1.getSelectedRow();
        String value=(jTable1.getModel().getValueAt(row, 0).toString());
        String query="DELETE FROM faculty_dep where fac_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
         DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
         tableModel.setRowCount(0);
       
//call modhode
        displaytable();
        
        pst.close();
        cn.close();
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manage_department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_department().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDepartmentClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ManageDepartmentClick;
    private javax.swing.JButton MenuClick;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtdeanname;
    private javax.swing.JTextField txtdepartment;
    private javax.swing.JTextField txtdepartmenthead;
    private javax.swing.JLabel txtfacultyid;
    private javax.swing.JTextField txtfacultyname;
    private javax.swing.JTextField txtheademail;
    // End of variables declaration//GEN-END:variables
}
