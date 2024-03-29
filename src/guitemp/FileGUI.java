//package guitemp;
//
//import javax.swing.*;
//import java.awt.event.WindowEvent;
//import java.io.File;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Jim
// */
//public class FileGUI extends JFrame {
//    File localdir;
////    FileClient fc;
////    UserToken token;
//
//    //JFrame parent;
//
//    /**
//     * Creates new form guitemp.FileGUI
//     */
//    public FileGUI() {
//        initComponents();
//    }
//
//    public FileGUI(UserToken t, String hostname, int port) {
//        this();
//
//        //parent = p;
//
//        token = t;
//        localdir = new File(".");
//        fc = new FileClient();
//        fc.connect(hostname, port);
//
//        updateLocalList();
//        updateRemoteList();
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jFileChooser1 = new JFileChooser();
//        localMenu = new JPopupMenu();
//        cmdUpload = new JMenuItem();
//        remoteMenu = new JPopupMenu();
//        cmdDownload = new JMenuItem();
//        cmdRemoteDelete = new JMenuItem();
//        dlgUploadPrompt = new JDialog();
//        jLabel1 = new JLabel();
//        jLabel2 = new JLabel();
//        jLabel3 = new JLabel();
//        txtUploadLocal = new JTextField();
//        txtUploadRemote = new JTextField();
//        txtUploadGroup = new JTextField();
//        jLabel4 = new JLabel();
//        btnUploadOK = new JButton();
//        btnUploadCancel = new JButton();
//        dlgDownloadPrompt = new JDialog();
//        jLabel5 = new JLabel();
//        jLabel6 = new JLabel();
//        jLabel7 = new JLabel();
//        txtDownloadRemote = new JTextField();
//        txtDownloadLocal = new JTextField();
//        btnDownloadCancel = new JButton();
//        btnDownloadOK = new JButton();
//        dlgDeletePrompt = new JDialog();
//        jLabel8 = new JLabel();
//        jLabel9 = new JLabel();
//        txtDeleteRemote = new JTextField();
//        btnDeleteCancel = new JButton();
//        btnDeleteOK = new JButton();
//        jPanel1 = new JPanel();
//        localPathField = new JTextField();
//        jScrollPane1 = new JScrollPane();
//        localList = new JList<>();
//        localBrowse = new JButton();
//        jPanel2 = new JPanel();
//        remotePathField = new JTextField();
//        jScrollPane2 = new JScrollPane();
//        remoteList = new JList<>();
//        btnUpload = new JButton();
//        btnDownload = new JButton();
//        btnRemoteDelete = new JButton();
//        btnDisconnect = new JButton();
//        jSeparator1 = new JSeparator();
//
//        jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//
//        cmdUpload.setText("Upload");
//        cmdUpload.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cmdUploadActionPerformed(evt);
//            }
//        });
//        localMenu.add(cmdUpload);
//
//        cmdDownload.setText("Download");
//        cmdDownload.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cmdDownloadActionPerformed(evt);
//            }
//        });
//        remoteMenu.add(cmdDownload);
//
//        cmdRemoteDelete.setText("Delete");
//        cmdRemoteDelete.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cmdRemoteDeleteActionPerformed(evt);
//            }
//        });
//        remoteMenu.add(cmdRemoteDelete);
//
//        dlgUploadPrompt.setTitle("Upload file...");
//        dlgUploadPrompt.setAlwaysOnTop(true);
//        dlgUploadPrompt.setResizable(false);
//        dlgUploadPrompt.setSize(getPreferredSize());
//
//        jLabel1.setText("Local file:");
//
//        jLabel2.setText("Remote file:");
//
//        jLabel3.setText("Group:");
//
//        jLabel4.setText("Please enter the file to upload.");
//
//        btnUploadOK.setText("OK");
//        btnUploadOK.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnUploadOKActionPerformed(evt);
//            }
//        });
//
//        btnUploadCancel.setText("Cancel");
//        btnUploadCancel.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnUploadCancelActionPerformed(evt);
//            }
//        });
//
//        GroupLayout dlgUploadPromptLayout = new GroupLayout(dlgUploadPrompt.getContentPane());
//        dlgUploadPrompt.getContentPane().setLayout(dlgUploadPromptLayout);
//        dlgUploadPromptLayout.setHorizontalGroup(
//            dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgUploadPromptLayout.createSequentialGroup()
//                .addGap(12, 12, 12)
//                .addComponent(jLabel4)
//                .addContainerGap(143, Short.MAX_VALUE))
//            .addGroup(dlgUploadPromptLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addGroup(dlgUploadPromptLayout.createSequentialGroup()
//                        .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
//                            .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
//                            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
//                        .addGap(18, 18, 18)
//                        .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addComponent(txtUploadGroup, GroupLayout.Alignment.TRAILING)
//                            .addComponent(txtUploadRemote, GroupLayout.Alignment.TRAILING)
//                            .addComponent(txtUploadLocal, GroupLayout.Alignment.TRAILING)))
//                    .addGroup(GroupLayout.Alignment.TRAILING, dlgUploadPromptLayout.createSequentialGroup()
//                        .addGap(0, 0, Short.MAX_VALUE)
//                        .addComponent(btnUploadOK)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(btnUploadCancel)))
//                .addContainerGap())
//        );
//
//        dlgUploadPromptLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUploadCancel, btnUploadOK});
//
//        dlgUploadPromptLayout.setVerticalGroup(
//            dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgUploadPromptLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel4)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel1)
//                    .addComponent(txtUploadLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel2)
//                    .addComponent(txtUploadRemote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel3)
//                    .addComponent(txtUploadGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(dlgUploadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(btnUploadCancel)
//                    .addComponent(btnUploadOK))
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        dlgDownloadPrompt.setTitle("Download file...");
//        dlgDownloadPrompt.setResizable(false);
//        dlgDownloadPrompt.setSize(getPreferredSize());
//
//        jLabel5.setText("Please enter the file to download.");
//
//        jLabel6.setText("Remote file:");
//
//        jLabel7.setText("Local file:");
//
//        btnDownloadCancel.setText("Cancel");
//        btnDownloadCancel.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDownloadCancelActionPerformed(evt);
//            }
//        });
//
//        btnDownloadOK.setText("OK");
//        btnDownloadOK.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDownloadOKActionPerformed(evt);
//            }
//        });
//
//        GroupLayout dlgDownloadPromptLayout = new GroupLayout(dlgDownloadPrompt.getContentPane());
//        dlgDownloadPrompt.getContentPane().setLayout(dlgDownloadPromptLayout);
//        dlgDownloadPromptLayout.setHorizontalGroup(
//            dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgDownloadPromptLayout.createSequentialGroup()
//                .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addGroup(dlgDownloadPromptLayout.createSequentialGroup()
//                        .addContainerGap()
//                        .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addComponent(jLabel6, GroupLayout.Alignment.TRAILING)
//                            .addComponent(jLabel7, GroupLayout.Alignment.TRAILING))
//                        .addGap(18, 18, 18)
//                        .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addComponent(txtDownloadRemote, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
//                            .addComponent(txtDownloadLocal, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
//                    .addGroup(dlgDownloadPromptLayout.createSequentialGroup()
//                        .addGap(12, 12, 12)
//                        .addComponent(jLabel5))
//                    .addGroup(GroupLayout.Alignment.TRAILING, dlgDownloadPromptLayout.createSequentialGroup()
//                        .addContainerGap()
//                        .addComponent(btnDownloadOK)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(btnDownloadCancel)))
//                .addContainerGap())
//        );
//
//        dlgDownloadPromptLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDownloadLocal, txtDownloadRemote});
//
//        dlgDownloadPromptLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDownloadCancel, btnDownloadOK});
//
//        dlgDownloadPromptLayout.setVerticalGroup(
//            dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgDownloadPromptLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel5)
//                .addGap(18, 18, 18)
//                .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel6)
//                    .addComponent(txtDownloadRemote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel7)
//                    .addComponent(txtDownloadLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(dlgDownloadPromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addComponent(btnDownloadOK, GroupLayout.Alignment.TRAILING)
//                    .addComponent(btnDownloadCancel, GroupLayout.Alignment.TRAILING))
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        dlgDeletePrompt.setTitle("Delete...");
//        dlgDeletePrompt.setModal(true);
//        dlgDeletePrompt.setResizable(false);
//        dlgDeletePrompt.setSize(getPreferredSize());
//
//        jLabel8.setText("Please enter the remote file.");
//
//        jLabel9.setText("Remote file:");
//
//        btnDeleteCancel.setText("Cancel");
//        btnDeleteCancel.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDeleteCancelActionPerformed(evt);
//            }
//        });
//
//        btnDeleteOK.setText("OK");
//        btnDeleteOK.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDeleteOKActionPerformed(evt);
//            }
//        });
//
//        GroupLayout dlgDeletePromptLayout = new GroupLayout(dlgDeletePrompt.getContentPane());
//        dlgDeletePrompt.getContentPane().setLayout(dlgDeletePromptLayout);
//        dlgDeletePromptLayout.setHorizontalGroup(
//            dlgDeletePromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgDeletePromptLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(dlgDeletePromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addGroup(dlgDeletePromptLayout.createSequentialGroup()
//                        .addComponent(jLabel8)
//                        .addGap(0, 143, Short.MAX_VALUE))
//                    .addGroup(dlgDeletePromptLayout.createSequentialGroup()
//                        .addComponent(jLabel9)
//                        .addGap(18, 18, 18)
//                        .addComponent(txtDeleteRemote))
//                    .addGroup(GroupLayout.Alignment.TRAILING, dlgDeletePromptLayout.createSequentialGroup()
//                        .addGap(0, 0, Short.MAX_VALUE)
//                        .addComponent(btnDeleteOK)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(btnDeleteCancel)))
//                .addContainerGap())
//        );
//
//        dlgDeletePromptLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteCancel, btnDeleteOK});
//
//        dlgDeletePromptLayout.setVerticalGroup(
//            dlgDeletePromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(dlgDeletePromptLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel8)
//                .addGap(18, 18, 18)
//                .addGroup(dlgDeletePromptLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel9)
//                    .addComponent(txtDeleteRemote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(dlgDeletePromptLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addComponent(btnDeleteOK, GroupLayout.Alignment.TRAILING)
//                    .addComponent(btnDeleteCancel, GroupLayout.Alignment.TRAILING))
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Files");
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosed(WindowEvent evt) {
//                formWindowClosed(evt);
//            }
//        });
//
//        jPanel1.setBorder(BorderFactory.createTitledBorder("Local"));
//
//        localPathField.setEditable(false);
//
//        localList.setModel(new DefaultListModel());
//        localList.setComponentPopupMenu(localMenu);
//        jScrollPane1.setViewportView(localList);
//
//        localBrowse.setText("Browse...");
//        localBrowse.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                localBrowseActionPerformed(evt);
//            }
//        });
//
//        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addComponent(jScrollPane1)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addComponent(localPathField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addComponent(localBrowse)))
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(localPathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                    .addComponent(localBrowse))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
//        );
//
//        jPanel2.setBorder(BorderFactory.createTitledBorder("Remote"));
//
//        remotePathField.setEditable(false);
//
//        remoteList.setModel(new DefaultListModel());
//        remoteList.setComponentPopupMenu(remoteMenu);
//        jScrollPane2.setViewportView(remoteList);
//
//        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//                    .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
//                    .addComponent(remotePathField, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
//                .addContainerGap())
//        );
//        jPanel2Layout.setVerticalGroup(
//            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel2Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(remotePathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        btnUpload.setText("Upload...");
//        btnUpload.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnUploadActionPerformed(evt);
//            }
//        });
//
//        btnDownload.setText("Download...");
//        btnDownload.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDownloadActionPerformed(evt);
//            }
//        });
//
//        btnRemoteDelete.setText("Delete...");
//        btnRemoteDelete.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnRemoteDeleteActionPerformed(evt);
//            }
//        });
//
//        btnDisconnect.setText("Disconnect");
//        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnDisconnectActionPerformed(evt);
//            }
//        });
//
//        jSeparator1.setOrientation(SwingConstants.VERTICAL);
//
//        GroupLayout layout = new GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addContainerGap())
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(btnUpload)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(btnDownload)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(btnRemoteDelete)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(btnDisconnect)
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2});
//
//        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDisconnect, btnDownload, btnRemoteDelete, btnUpload});
//
//        layout.setVerticalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                        .addComponent(btnUpload)
//                        .addComponent(btnDownload)
//                        .addComponent(btnRemoteDelete))
//                    .addComponent(jSeparator1)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(0, 0, Short.MAX_VALUE)
//                        .addComponent(btnDisconnect)))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
//                    .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 347, Short.MAX_VALUE)
//                    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2});
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void localBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localBrowseActionPerformed
//        // Change local directory
//        jFileChooser1.showOpenDialog(this);
//        localdir = jFileChooser1.getSelectedFile();
//
//        updateLocalList();
//    }//GEN-LAST:event_localBrowseActionPerformed
//
//    private void cmdUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUploadActionPerformed
//        openUploadDlg();
//    }//GEN-LAST:event_cmdUploadActionPerformed
//
//    private void cmdDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDownloadActionPerformed
//        openDownloadDlg();
//    }//GEN-LAST:event_cmdDownloadActionPerformed
//
//    private void cmdRemoteDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRemoteDeleteActionPerformed
//        openDeleteDlg();
//    }//GEN-LAST:event_cmdRemoteDeleteActionPerformed
//
//    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
//        fc.disconnect();
//        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
//    }//GEN-LAST:event_btnDisconnectActionPerformed
//
//    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
//        openUploadDlg();
//    }//GEN-LAST:event_btnUploadActionPerformed
//
//    private void btnUploadCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadCancelActionPerformed
//        dlgUploadPrompt.setVisible(false);
//    }//GEN-LAST:event_btnUploadCancelActionPerformed
//
//    private void btnUploadOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadOKActionPerformed
//        String src   = localdir.getPath() + '\\' +txtUploadLocal.getText();
//        String dest  = txtUploadRemote.getText();
//        String group = txtUploadGroup.getText();
//
//        if (src.length() != 0 && dest.length() != 0 && group.length() != 0) {
//            if (token.getGroups().contains(group)) {
//                if (!fc.upload(src, dest, group, token)) {
//                    JOptionPane.showMessageDialog(this, "Error uploading file.");
//                }
//                dlgUploadPrompt.setVisible(false);
//                updateRemoteList();
//            }
//            else
//                JOptionPane.showMessageDialog(this, "You are not a member of that group.");
//        }
//        else
//            JOptionPane.showMessageDialog(this, "All fields are required.");
//    }//GEN-LAST:event_btnUploadOKActionPerformed
//
//    private void btnDownloadCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadCancelActionPerformed
//        dlgDownloadPrompt.setVisible(false);
//    }//GEN-LAST:event_btnDownloadCancelActionPerformed
//
//    private void btnDownloadOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadOKActionPerformed
//        String src   = txtDownloadRemote.getText();
//        String dest  = localdir.getPath() + '\\' +txtDownloadLocal.getText();
//
//        if (src.length() != 0 && dest.length() != 0) {
//            if (!fc.download(src, dest, token)) {
//                JOptionPane.showMessageDialog(this, "Error downloading file.");
//            }
//            dlgDownloadPrompt.setVisible(false);
//            updateLocalList();
//        }
//        else
//            JOptionPane.showMessageDialog(this, "All fields are required.");
//    }//GEN-LAST:event_btnDownloadOKActionPerformed
//
//    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
//        openDownloadDlg();
//    }//GEN-LAST:event_btnDownloadActionPerformed
//
//    private void btnDeleteCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCancelActionPerformed
//
//        dlgDeletePrompt.setVisible(false);
//    }//GEN-LAST:event_btnDeleteCancelActionPerformed
//
//    private void btnDeleteOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOKActionPerformed
//        String src   = txtDeleteRemote.getText();
//
//        if (src.length() != 0) {
//            if (!fc.delete(src, token))
//                JOptionPane.showMessageDialog(this, "Error deleting file!");
//            dlgDeletePrompt.setVisible(false);
//            updateRemoteList();
//        }
//        else
//            JOptionPane.showMessageDialog(this, "All fields are required.");
//    }//GEN-LAST:event_btnDeleteOKActionPerformed
//
//    private void btnRemoteDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoteDeleteActionPerformed
//        openDeleteDlg();
//    }//GEN-LAST:event_btnRemoteDeleteActionPerformed
//
//    private void formWindowClosed(WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        if (fc.isConnected()) fc.disconnect();
//      //  parent.setVisible(true);
//    }//GEN-LAST:event_formWindowClosed
//
//    public void openUploadDlg() {
//        // Set default entries
//        if (localList.getSelectedValue() != null) {
//            txtUploadLocal.setText(localList.getSelectedValue());
//            txtUploadRemote.setText(localList.getSelectedValue());
//       }
//        txtUploadGroup.setText(token.getGroups().get(0));
//
//        dlgUploadPrompt.pack();
//        dlgUploadPrompt.setVisible(true);
//    }
//
//    public void openDownloadDlg() {
//        // Set default entries
//        if (remoteList.getSelectedValue() != null) {
//            txtDownloadLocal.setText(remoteList.getSelectedValue());
//            txtDownloadRemote.setText(remoteList.getSelectedValue());
//       }
//
//        dlgDownloadPrompt.pack();
//        dlgDownloadPrompt.setVisible(true);
//    }
//
//    public void openDeleteDlg() {
//        // Set default entries
//        if (remoteList.getSelectedValue() != null) {
//            txtDeleteRemote.setText(remoteList.getSelectedValue());
//       }
//
//        dlgDeletePrompt.pack();
//        dlgDeletePrompt.setVisible(true);
//    }
//
//    public void updateLocalList() {
//        DefaultListModel dlm = (DefaultListModel) localList.getModel();
//
//        localPathField.setText(localdir.getPath());
//        dlm.clear();
//
//        for (File f : localdir.listFiles())
//            if (f.isFile())
//                dlm.addElement(f.getName());
//    }
//
//    public void updateRemoteList() {
//        DefaultListModel dlm = (DefaultListModel) remoteList.getModel();
//
//        remotePathField.setText("/"); // We can't change dirs yet
//        dlm.clear();
//
//        for (String s : fc.listFiles(token))
//            dlm.addElement(s.replace("/","")); // Remove prefixed '/'
//    }
//
//    public static void go(UserToken t, String hostname, int port) {
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FileGUI(t, hostname, port).setVisible(true);
//            }
//        });
//    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FileGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FileGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FileGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FileGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        go(null, "localhost", 8001);
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private JButton btnDeleteCancel;
//    private JButton btnDeleteOK;
//    private JButton btnDisconnect;
//    private JButton btnDownload;
//    private JButton btnDownloadCancel;
//    private JButton btnDownloadOK;
//    private JButton btnRemoteDelete;
//    private JButton btnUpload;
//    private JButton btnUploadCancel;
//    private JButton btnUploadOK;
//    private JMenuItem cmdDownload;
//    private JMenuItem cmdRemoteDelete;
//    private JMenuItem cmdUpload;
//    private JDialog dlgDeletePrompt;
//    private JDialog dlgDownloadPrompt;
//    private JDialog dlgUploadPrompt;
//    private JFileChooser jFileChooser1;
//    private JLabel jLabel1;
//    private JLabel jLabel2;
//    private JLabel jLabel3;
//    private JLabel jLabel4;
//    private JLabel jLabel5;
//    private JLabel jLabel6;
//    private JLabel jLabel7;
//    private JLabel jLabel8;
//    private JLabel jLabel9;
//    private JPanel jPanel1;
//    private JPanel jPanel2;
//    private JScrollPane jScrollPane1;
//    private JScrollPane jScrollPane2;
//    private JSeparator jSeparator1;
//    private JButton localBrowse;
//    private JList<String> localList;
//    private JPopupMenu localMenu;
//    private JTextField localPathField;
//    private JList<String> remoteList;
//    private JPopupMenu remoteMenu;
//    private JTextField remotePathField;
//    private JTextField txtDeleteRemote;
//    private JTextField txtDownloadLocal;
//    private JTextField txtDownloadRemote;
//    private JTextField txtUploadGroup;
//    private JTextField txtUploadLocal;
//    private JTextField txtUploadRemote;
//    // End of variables declaration//GEN-END:variables
//}
