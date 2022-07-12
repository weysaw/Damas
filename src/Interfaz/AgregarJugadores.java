package Interfaz;

import damas.Jugador;
import javax.swing.JOptionPane;

/**
 * Agrega los jugadores a la partida.
 * 
 * @version 19.02.2020
 * @author Ornelas Munguía Axel Leonardo
 */
public class AgregarJugadores extends javax.swing.JDialog {

    //Almacena los jugadores que se agregaran.
    private final Jugador[] jugadores;
    //Es el menu para poder realizar acciones con el.
    private final MenúDeInicio menu;
            
    public AgregarJugadores(java.awt.Frame parent, boolean modal,Jugador[] jugadores,MenúDeInicio menu) {
        super(parent, modal);
        initComponents();
        this.jugadores = jugadores;
        this.menu = menu;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        j2 = new javax.swing.JTextField();
        j1 = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Jugadores");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Jugador 1");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Jugador 2");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(j2)
                            .addComponent(j1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(agregar)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        //Inicializo los jugadores con los nombre que se ingresaron en los campos.
        jugadores[0].setNombre(j1.getText());
        jugadores[1].setNombre(j2.getText());
        //Si hay espacio en blanco se le indica que se llene de nuevo.
        if(jugadores[0].getNombre().equals("") || jugadores[1].getNombre().equals(""))
            JOptionPane.showMessageDialog(this, "No agregue espacios vacios", "ERROR", JOptionPane.ERROR_MESSAGE);      
        //Si todo esta correcto se hace visible, iniciar partida y se sale de la ventana.
        else {
            menu.hacerInvisibleAgregar();
            JOptionPane.showMessageDialog(this, "Jugadores agregados con exito", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            menu.setVisible(true);
            dispose(); 
        }
            
    }//GEN-LAST:event_agregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField j1;
    private javax.swing.JTextField j2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
