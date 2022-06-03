/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RAVI PANCHAL
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    String gender;
    public Dashboard() {
        initComponents();
        setStudentTable();
    }

    public Boolean insertStudentData()
    {
        String rollno = txt_rollno.getText();
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        
        String course = (String) cb_course.getSelectedItem().toString();
        String city = (String) cb_city.getSelectedItem().toString();
        String date = txt_date.getText();
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql ="Insert into student values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, rollno);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, course);
            pst.setString(5, city);
            pst.setString(6, gender);
            pst.setString(7, date);
            
            int rowcount = pst.executeUpdate();
            if(rowcount > 0)
            {
                JOptionPane.showMessageDialog(this,"Data Inserted Ok");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Data Insert Faild");
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    public Boolean updateData()
    {
        String rollno = txt_rollno.getText();
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        
        String course = (String) cb_course.getSelectedItem().toString();
        String city = (String) cb_city.getSelectedItem().toString();
        String date = txt_date.getText();
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql ="update student set fname=?,lname=?,course=?,city=?,gender=?,bod=? where rollno=?";
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, course);
            pst.setString(4, city);
            pst.setString(5, gender);
            pst.setString(6, date);
            pst.setString(7, rollno);
            
            int rowcount = pst.executeUpdate();
            if(rowcount > 0)
            {
                JOptionPane.showMessageDialog(this,"Data Updated");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Data Update Faild");
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    public Boolean deleteData()
    {
        String rollno = txt_rollno.getText();
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql ="delete from student where rollno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, rollno);
            int rowcount = pst.executeUpdate();
            if(rowcount > 0)
            {
                JOptionPane.showMessageDialog(this,"Data Deleted");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Data Delete Faild");
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    //int rollno;
    //String fname,lname,course,city,tgender,bod;
    DefaultTableModel model;
    public void setStudentTable()
    {
        //hide a scrollbar
        jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        try
        {
            Connection con = Dbconnection.getConnection();
            Statement st = (Statement) con.createStatement();
            String sql = "Select * from student order by rollno";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                int rollno = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String course = rs.getString(4);
                String city = rs.getString(5);
                String tgender = rs.getString(6);
                String bod = rs.getString(7);
                
                Object[] obj = {rollno,fname,lname,course,city,tgender,bod};
                
                model = (DefaultTableModel) table_student.getModel();
                model.addRow(obj);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void searchData()
    {
        String search_rollno = txt_search.getText();
        try
        {
            Connection con = Dbconnection.getConnection();
            if(search_rollno.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Number To Search !");
            }
            else
            {
                String sql = "Select * from student where rollno=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(search_rollno));
                ResultSet rs = pst.executeQuery();
                
                if(rs.next())
                {
                    int rollno = rs.getInt(1);
                    String fname = rs.getString(2);
                    String lname = rs.getString(3);
                    String course = rs.getString(4);
                    String city = rs.getString(5);
                    String tgender = rs.getString(6);
                    String bod = rs.getString(7);

                    Object[] obj = {rollno,fname,lname,course,city,tgender,bod};

                    model = (DefaultTableModel) table_student.getModel();
                    model.addRow(obj);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Data Not Found !");
                }
            }
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void clearTable()
    {
        model = (DefaultTableModel) table_student.getModel();
        model.setRowCount(0);
    }
    public void setBlank()
    {
        txt_rollno.setText("");
        txt_fname.setText("");
        txt_lname.setText("");
        txt_date.setText("");
        
        cb_course.setSelectedItem("SELECT");
        cb_city.setSelectedItem("SELECT");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_gender = new javax.swing.ButtonGroup();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_rollno = new app.bolivia.swing.JCTextField();
        txt_fname = new app.bolivia.swing.JCTextField();
        txt_lname = new app.bolivia.swing.JCTextField();
        txt_date = new app.bolivia.swing.JCTextField();
        cb_city = new rojerusan.RSComboMetro();
        cb_course = new rojerusan.RSComboMetro();
        rb_female = new javax.swing.JRadioButton();
        rb_male = new javax.swing.JRadioButton();
        bt_delete = new javax.swing.JLabel();
        bt_add = new javax.swing.JLabel();
        bt_update = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_student = new javax.swing.JTable();
        txt_search = new app.bolivia.swing.JCTextField();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/background/dashboard.png"))); // NOI18N
        rSPanelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSPanelImage1MouseClicked(evt);
            }
        });
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 96, 71));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        rSPanelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 23, 60, 26));

        txt_rollno.setBackground(new java.awt.Color(161, 23, 252));
        txt_rollno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        txt_rollno.setForeground(new java.awt.Color(255, 255, 255));
        txt_rollno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_rollno.setAlignmentY(0.0F);
        txt_rollno.setPhColor(new java.awt.Color(255, 255, 255));
        txt_rollno.setPlaceholder("Enter Roll NO.");
        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });
        rSPanelImage1.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        txt_fname.setBackground(new java.awt.Color(161, 23, 252));
        txt_fname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        txt_fname.setForeground(new java.awt.Color(255, 255, 255));
        txt_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fname.setAlignmentY(0.0F);
        txt_fname.setPhColor(new java.awt.Color(255, 255, 255));
        txt_fname.setPlaceholder("Enter First Name");
        rSPanelImage1.add(txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 165, -1, -1));

        txt_lname.setBackground(new java.awt.Color(161, 23, 252));
        txt_lname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        txt_lname.setForeground(new java.awt.Color(255, 255, 255));
        txt_lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lname.setAlignmentY(0.0F);
        txt_lname.setPhColor(new java.awt.Color(255, 255, 255));
        txt_lname.setPlaceholder("Enter Last Name");
        rSPanelImage1.add(txt_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 222, -1, 30));

        txt_date.setBackground(new java.awt.Color(161, 23, 252));
        txt_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        txt_date.setForeground(new java.awt.Color(255, 255, 255));
        txt_date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_date.setAlignmentY(0.0F);
        txt_date.setPhColor(new java.awt.Color(255, 255, 255));
        txt_date.setPlaceholder("Enter Your BOD");
        rSPanelImage1.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 200, 30));

        cb_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "Himmatnagar", "ahemedabad", "vadodara", "surat", "bhavnagar" }));
        cb_city.setColorArrow(new java.awt.Color(0, 102, 153));
        cb_city.setColorBorde(new java.awt.Color(0, 102, 153));
        cb_city.setColorFondo(new java.awt.Color(0, 102, 153));
        rSPanelImage1.add(cb_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, 30));

        cb_course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "MCA", "BCA", "BCOM", "MCOM", "BBA", "MBA", "MSC", "BSC" }));
        cb_course.setColorArrow(new java.awt.Color(0, 102, 153));
        cb_course.setColorBorde(new java.awt.Color(0, 102, 153));
        cb_course.setColorFondo(new java.awt.Color(0, 102, 153));
        rSPanelImage1.add(cb_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, 30));

        rb_female.setBackground(new java.awt.Color(0, 0, 0));
        bt_gender.add(rb_female);
        rb_female.setForeground(new java.awt.Color(255, 255, 255));
        rb_female.setText("Female");
        rb_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_femaleActionPerformed(evt);
            }
        });
        rSPanelImage1.add(rb_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        rb_male.setBackground(new java.awt.Color(0, 0, 0));
        bt_gender.add(rb_male);
        rb_male.setForeground(new java.awt.Color(255, 255, 255));
        rb_male.setText("Male");
        rb_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_maleActionPerformed(evt);
            }
        });
        rSPanelImage1.add(rb_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        bt_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_delete.setForeground(new java.awt.Color(255, 255, 255));
        bt_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_delete.setText("DELETE");
        bt_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_deleteMouseClicked(evt);
            }
        });
        rSPanelImage1.add(bt_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 545, 80, 35));

        bt_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_add.setForeground(new java.awt.Color(255, 255, 255));
        bt_add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_add.setText("ADD");
        bt_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addMouseClicked(evt);
            }
        });
        rSPanelImage1.add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 545, 70, 35));

        bt_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_update.setForeground(new java.awt.Color(255, 255, 255));
        bt_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_update.setText("UPDATE");
        bt_update.setToolTipText("");
        bt_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_updateMouseClicked(evt);
            }
        });
        rSPanelImage1.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 545, 70, 35));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBar(null);

        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "First Name", "Last Name", "Course", "City", "Gender", "B.O.D"
            }
        ));
        table_student.setGridColor(new java.awt.Color(255, 255, 255));
        table_student.setRowHeight(25);
        table_student.setSelectionBackground(new java.awt.Color(51, 204, 0));
        table_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_student);

        rSPanelImage1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 720, 450));

        txt_search.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 0, 255)));
        txt_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_search.setPlaceholder("Enter Roll No to Search");
        rSPanelImage1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 62, 150, 30));

        rSButtonMetro1.setText("Search");
        rSButtonMetro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonMetro1MouseClicked(evt);
            }
        });
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        rSPanelImage1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 61, 80, 31));

        rSButtonMetro2.setText("Show All");
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        rSPanelImage1.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 61, 80, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1200, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSPanelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelImage1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSPanelImage1MouseClicked

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void rb_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_femaleActionPerformed
        // TODO add your handling code here:
        gender = "Female";
    }//GEN-LAST:event_rb_femaleActionPerformed

    private void rb_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_maleActionPerformed
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_rb_maleActionPerformed

    private void bt_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_deleteMouseClicked
        // TODO add your handling code here:
        if(deleteData()==true)
        {
            clearTable();
            setStudentTable();
            setBlank();
        }
    }//GEN-LAST:event_bt_deleteMouseClicked

    private void bt_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addMouseClicked
        // TODO add your handling code here:
        if(insertStudentData()==true)
        {
            clearTable();
            setStudentTable();
            setBlank();
        }
    }//GEN-LAST:event_bt_addMouseClicked

    private void bt_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_updateMouseClicked
        // TODO add your handling code here:
        if(updateData()==true)
        {
            clearTable();
            setStudentTable();
            setBlank();
        }
    }//GEN-LAST:event_bt_updateMouseClicked

    private void table_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentMouseClicked
        // TODO add your handling code here:
        int rowNo = table_student.getSelectedRow();
        model = (DefaultTableModel) table_student.getModel();
        
        txt_rollno.setText(model.getValueAt(rowNo,0).toString());
        txt_fname.setText(model.getValueAt(rowNo,1).toString());
        txt_lname.setText(model.getValueAt(rowNo,2).toString());
        cb_course.setSelectedItem(model.getValueAt(rowNo,3).toString());
        cb_city.setSelectedItem(model.getValueAt(rowNo,4).toString());
        
        txt_date.setText(model.getValueAt(rowNo,6).toString());
        
    }//GEN-LAST:event_table_studentMouseClicked

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro1MouseClicked
        clearTable();
        searchData();
    }//GEN-LAST:event_rSButtonMetro1MouseClicked

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        // TODO add your handling code here:
        clearTable();
        setStudentTable();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_add;
    private javax.swing.JLabel bt_delete;
    private javax.swing.ButtonGroup bt_gender;
    private javax.swing.JLabel bt_update;
    private rojerusan.RSComboMetro cb_city;
    private rojerusan.RSComboMetro cb_course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSPanelImage rSPanelImage1;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JTable table_student;
    private app.bolivia.swing.JCTextField txt_date;
    private app.bolivia.swing.JCTextField txt_fname;
    private app.bolivia.swing.JCTextField txt_lname;
    private app.bolivia.swing.JCTextField txt_rollno;
    private app.bolivia.swing.JCTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
