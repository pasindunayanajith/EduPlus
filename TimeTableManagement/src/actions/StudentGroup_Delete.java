/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StudentGroup_Delete {
      public int value;

    //Delete Location
 public void DeleteStudentGroup(){
                        
            Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        String query="DELETE FROM student_group where stu_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
        
        pst.close();
        cn.close();
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
                                  
 
 
 }
 
}
