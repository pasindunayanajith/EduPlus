/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasindu;
import group_implmentation.dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import actions.*;
/**
 *
 * @author pasindu
 */
public final class Manage_Location extends javax.swing.JFrame {
    //get Location Object             
        Location_Update ul=new Location_Update();
        Location_Delete dl=new Location_Delete();

    /**
     * Creates new form Manage_Location
     */
    public Manage_Location() {
        initComponents();
        //implement the hidesize function
        hidesize();
        //Gride Add Jtable
        jTable.setShowGrid(true);

    }
 //Set Desktop Application size and hide Maximize Window   
   void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
    
  
  }
//Same id Value with Update Lccation Table Class   
void LoadDataUpdate(){
  try{
      int row =jTable.getSelectedRow(); 
      String value =(jTable.getModel().getValueAt(row, 0).toString());
      ul.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
  
  }
//Same id Value with Delete Lccation Table Class   
void LoadDataDelete(){
  try{
      int row =jTable.getSelectedRow(); 
      String value =(jTable.getModel().getValueAt(row, 0).toString());
      dl.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
  
  }
//All the location table data displaed jtable
   public void displaytable(){
         
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from location";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){
                       //Data will be added until finish
                       String location_id       = String.valueOf(rs.getInt("location_id"));
                       String building    = rs.getString("building");
                       String room_name        = rs.getString("room_name");
                       String room_type        = rs.getString("room_type");
                       String capacity         = rs.getString("capacity");
                       
                       //string array for store data into jtable
                       String tbData[]={location_id ,building,room_name,room_type,capacity};
                       DefaultTableModel tblModel=(DefaultTableModel)jTable.getModel();
                       
                       tblModel.addRow(tbData);
                   }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonUpdateLocation = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBuildingName = new javax.swing.JTextField();
        jTextFieldRoomName = new javax.swing.JTextField();
        jTextFieldLecturerHall = new javax.swing.JRadioButton();
        jTextFieldLaboratory = new javax.swing.JRadioButton();
        jTextFieldCapacity = new javax.swing.JTextField();
        erroBuildingName = new javax.swing.JLabel();
        erroRoomName = new javax.swing.JLabel();
        erroRoonType = new javax.swing.JLabel();
        erroCapacity = new javax.swing.JLabel();
        DashboardClick = new javax.swing.JButton();
        ManageLocationClick = new javax.swing.JButton();
        BackClick = new javax.swing.JButton();
        AddLocationClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(484, 439));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Locations");

        jPanel2.setPreferredSize(new java.awt.Dimension(870, 646));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Building", "Room", "Room Type", "Capacity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(51, 153, 255));
        jTable.setRowHeight(40);
        jTable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable.setSelectionForeground(new java.awt.Color(0, 153, 204));
        jTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButtonUpdateLocation.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdateLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdateLocation.setText("Update");
        jButtonUpdateLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateLocationActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(0, 153, 153));
        Clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Building Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Room Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Room Type");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Capacity");

        jTextFieldBuildingName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldBuildingName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuildingNameKeyReleased(evt);
            }
        });

        jTextFieldRoomName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldRoomName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRoomNameKeyReleased(evt);
            }
        });

        buttonGroup1.add(jTextFieldLecturerHall);
        jTextFieldLecturerHall.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldLecturerHall.setText("Lecturer Hall");

        buttonGroup1.add(jTextFieldLaboratory);
        jTextFieldLaboratory.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldLaboratory.setText("Laboratary");

        jTextFieldCapacity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCapacity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCapacityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCapacityKeyTyped(evt);
            }
        });

        erroBuildingName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroBuildingName.setForeground(java.awt.Color.red);

        erroRoomName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroRoomName.setForeground(java.awt.Color.red);

        erroRoonType.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroRoonType.setForeground(java.awt.Color.red);

        erroCapacity.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroCapacity.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonUpdateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(erroRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jTextFieldRoomName))))
                            .addComponent(erroBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(erroRoonType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldLecturerHall)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldLaboratory))
                                    .addComponent(jTextFieldCapacity)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(erroCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUpdateLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLecturerHall)
                    .addComponent(jTextFieldLaboratory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(erroBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroRoonType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(erroRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DashboardClick.setText("DashBoard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        ManageLocationClick.setBackground(new java.awt.Color(0, 153, 153));
        ManageLocationClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ManageLocationClick.setText("Manage Location");

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        AddLocationClick.setBackground(new java.awt.Color(0, 153, 153));
        AddLocationClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddLocationClick.setText("Add Location");
        AddLocationClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLocationClickActionPerformed(evt);
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
                        .addGap(172, 172, 172)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddLocationClick, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(ManageLocationClick, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(AddLocationClick, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageLocationClick, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//user clicked column displayed data feilds
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
              
        int i=jTable.getSelectedRow();
           
            TableModel model=jTable.getModel();
           
            jTextFieldBuildingName.setText(model.getValueAt(i, 1).toString());
            jTextFieldRoomName.setText(model.getValueAt(i, 2).toString());
            String roomtype =model.getValueAt(i, 3).toString();
           
           if(roomtype.equals("Lecturer_Hall")){
                jTextFieldLecturerHall.setSelected(true);
            }
            else{
                jTextFieldLaboratory.setSelected(true);
            
            }
            jTextFieldCapacity.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableAncestorAdded
        // TODO add your handling code here:
 //called methode          
        displaytable();

    }//GEN-LAST:event_jTableAncestorAdded
  
//Display ReUpdate Table  
private void updateRe_table(){
       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from location";

try{
           PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable.setModel(DbUtils.resultSetToTableModel(rs));

}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }
    
    
//update data jtable methode  
    private void jButtonUpdateLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateLocationActionPerformed
 
           //Call Load Data method
            LoadDataUpdate();
            
            //Same With Location Variables
            String BuildingName =jTextFieldBuildingName.getText();
            String RoomName=jTextFieldRoomName.getText();
          
            if(jTextFieldLecturerHall.isSelected()){
                    room_type="Lecturer_Hall";
            
            }      
            if(jTextFieldLaboratory.isSelected()){
                    room_type="Laboratory";
         
            }                  
            String Roomtype=room_type;
            String  Capacity=jTextFieldCapacity.getText();
        if(!("Laboratory".equals(Roomtype) || "Lecturer_Hall".equals(Roomtype))|| jTextFieldBuildingName.getText().trim().isEmpty() || jTextFieldRoomName.getText().trim().isEmpty() || jTextFieldCapacity.getText().trim().isEmpty()){
                  
                Validation();
       }else{   
            ul.Updatelocation(BuildingName, RoomName, Roomtype, Capacity);
        }
            updateRe_table();

    }//GEN-LAST:event_jButtonUpdateLocationActionPerformed

    
    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here
      
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardClickActionPerformed

//selected column data delete medhode
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        //call methode 
        LoadDataDelete();
        
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);            
        dl.DeleteLocation();
//call modhode
        displaytable();
       
  
    }//GEN-LAST:event_jButtonDeleteActionPerformed

//clear all the feilds
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        jTextFieldRoomName.setText("");
        jTextFieldBuildingName.setText("");
        buttonGroup1.clearSelection();
        jTextFieldCapacity.setText("");
        erroBuildingName.setText("");
        erroCapacity.setText("");
        erroRoomName.setText("");
        erroRoonType.setText("");
        
    }//GEN-LAST:event_ClearActionPerformed
Add_Location al2;
    private void AddLocationClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLocationClickActionPerformed
        // TODO add your handling code here:
       if (al2 == null) {
            al2 = new Add_Location();
        }
        
        al2.setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_AddLocationClickActionPerformed
Manage_Location al3;
    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackClickActionPerformed

//Validation Capacity 0 - 120 user can entered and can't entered negetive values
    private void jTextFieldCapacityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacityKeyReleased
        // TODO add your handling code here:
        String PATTERN ="([1-9]|[1-9][0-9]|1[01][0-9]|120)";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(jTextFieldCapacity.getText());

        
        if(!match.matches()){
              erroCapacity.setText("Please Input Number 0-120");
        } else {
            
             erroCapacity.setText(null);
        }    
        
        
        
        
    }//GEN-LAST:event_jTextFieldCapacityKeyReleased

    private void jTextFieldBuildingNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuildingNameKeyReleased
        // TODO add your handling code here:
                     erroBuildingName.setText(null);

    }//GEN-LAST:event_jTextFieldBuildingNameKeyReleased

    private void jTextFieldRoomNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRoomNameKeyReleased
        // TODO add your handling code here:
                     erroRoomName.setText(null);

    }//GEN-LAST:event_jTextFieldRoomNameKeyReleased

    private void jTextFieldCapacityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacityKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
             evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCapacityKeyTyped

   //Validation
   void Validation(){
    //All feilds are empty   
    if(jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldRoomName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() && buttonGroup1.getSelection()==null){
            JOptionPane.showMessageDialog(this, "Fields are Emplty");
   
    }//Room type not empty And (Room Name,Capacity,Bilding name) Empty    
    else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldRoomName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty()){
                           erroRoomName.setText("Please Enter Room Name");
                           erroCapacity.setText("please Enter Capacity");
                           erroBuildingName.setText("Please Select the Building Name");

    }//Room type not empty And (Room Name,Building Name) Empty 
    else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldRoomName.getText().trim().isEmpty()){
       
                          erroRoomName.setText("Please Enter Room Name");
                          erroBuildingName.setText("Please Select the Building Name");

    }//Room tpye not empty And (Capacity,Building Name) Empty
    else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() ){
                          erroCapacity.setText("please Enter Capacity");
                          erroBuildingName.setText("Please Enter the Building Name");
 
    }//Room type not empty And (Capacity,Room Name) Empty
    else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldRoomName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() ){
                          erroCapacity.setText("please Enter Capacity");
                          erroRoomName.setText("Please Enter Room Name");

    }//Room type not empty And (Building Name) Empty
    else if(("Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldBuildingName.getText().trim().isEmpty()){
                          erroBuildingName.setText("Please Select the Building Name");
    
    }//Room type not empty And (Capacity) Empty
    else if(("Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldCapacity.getText().trim().isEmpty()){
                          erroCapacity.setText("please Enter Capacity");

    }//Room trpe not empty And (Room Name) Empty
    else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldRoomName.getText().trim().isEmpty()){
                          erroRoomName.setText("please Enter Room name");
       
    }//Room Name Empty
    else  if(jTextFieldRoomName.getText().trim().isEmpty()){
                          erroRoomName.setText("Please Enter Room Name");

    }//Capacity Empty
    else if(jTextFieldCapacity.getText().trim().isEmpty()){
        
                          erroCapacity.setText("please Enter Capacity");
            
    }//Building Name Empty
    else if(jTextFieldBuildingName.getText().trim().isEmpty()){
    
                          erroBuildingName.setText("Please Select the Building Name");

    }//Room type Empty
    else if(buttonGroup1.getSelection()==null){
            
                          erroRoonType.setText("Please Select Room Type");
    
    }
         
   }
   
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
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Location().setVisible(true);
            }
        });
    }
            String room_type;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddLocationClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton Clear;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton ManageLocationClick;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel erroBuildingName;
    private javax.swing.JLabel erroCapacity;
    private javax.swing.JLabel erroRoomName;
    private javax.swing.JLabel erroRoonType;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdateLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldBuildingName;
    private javax.swing.JTextField jTextFieldCapacity;
    private javax.swing.JRadioButton jTextFieldLaboratory;
    private javax.swing.JRadioButton jTextFieldLecturerHall;
    private javax.swing.JTextField jTextFieldRoomName;
    // End of variables declaration//GEN-END:variables
}