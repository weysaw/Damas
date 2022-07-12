package conexiones;

import DamasEnLinea.JugarServidor;
import damas.Jugador;
import java.io.IOException;
/**
 * Es la sala de espera.
 * 
 * @author Ornelas Munguía Axel Leonardo
 * @version 23.04.2020
 */
public class SalaDeEspera extends javax.swing.JDialog implements Runnable{

    //Atributos de clase
    private Servidor servidor;
    private final String nombre;
    private final Jugador[] jugadores;
    
    public SalaDeEspera(java.awt.Frame parent, boolean modal,String nombre,Jugador[] jugadores) {
        super(parent, modal);
        this.jugadores = jugadores;
        initComponents();
        try {
            servidor = new Servidor(1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.nombre = nombre;
        jLabel1.setText(jLabel1.getText() + " " + nombre);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        texto = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        animacion1 = new Interfaz.Animacion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sala De Espera");

        texto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        texto.setText("Esperando conexion de jugador");

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Servidor por: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salir)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(animacion1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        servidor.cerrarConexiónCliente();
        servidor.finalizarConexión();
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Interfaz.Animacion animacion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables


    @Override
    public void run() {     
        setVisible(true);
        Thread hilo = new Thread(animacion1);
        hilo.start();       
        //Se espera la conexión el cliente mientras se hace la animación de la sala
        servidor.esperarConexion();
        //Cuando se conecta le envia los datos al cliente.
        servidor.enviarDatoCliente(nombre);
        //Hace invisible la sala de espera.
        setVisible(false);             
        //Abre el tablero de juego
        JugarServidor juego = new JugarServidor(nombre, servidor,jugadores);       
        juego.setVisible(true);
 
    }
    
    
 
}
