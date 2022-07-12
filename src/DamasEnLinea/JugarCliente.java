package DamasEnLinea;

import conexiones.Cliente;
import damas.Jugador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Se encarga de visualizar el menú de juego.
 *
 * @version 16.03.2020
 * @author Ornelas Munguía Axel Leonardo
 */
public class JugarCliente extends javax.swing.JFrame {

    private final Jugador[] jugadores;
    private Cliente cliente;

    public JugarCliente(String nombre,Jugador[] jugadores) {       
        this.jugadores = jugadores;
        try {
            cliente = new Cliente();
        } catch (IOException ex) {
            Logger.getLogger(JugarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.enviarDatosServidor(nombre);
        String datos = cliente.leerDatosServidor();
        jugadores[0].setNombre(datos);
        jugadores[1].setNombre(nombre);
        initComponents();
        setTitle("Cliente");
        //Obtiene le turno y lo muestra.
        obtenerTurno();
    }
    private void initComponents() {

        reloj1 = new Interfaz.Reloj();
        jPanel1 = new javax.swing.JPanel();
        textTurno = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        tablero = new DamasEnLinea.TableroCliente(jugadores,this,cliente);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textTurno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textTurno.setText("Turno de:");

        salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(textTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(salir)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reloj1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloj1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Se sale del menú de juego.
     */
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        //Le indica que si juega de nuevo, tenga fichas diferentes.
        for (Jugador jugadore : jugadores) 
            jugadore.nuevasFichas();  
        System.out.println("Salio cliente");
        dispose();
        cliente.cerrarCliente();
    }//GEN-LAST:event_salirActionPerformed
    
    /**
     * Visualiza el jugador actual moviendo la pieza y la pone en el panel.
     */
    public final void obtenerTurno() {
        textTurno.setText("Es el turno de: " + jugadores[tablero.getTurno()].getNombre());
    }
    
    /**
     * Detiene el tiempo cuando se acaba el tiempo.
     */
    public void detenerTiempo()  {
        reloj1.detenerTiempo();
    }
    /**
     * Inicia el conteo del reloj
     */
    public void iniciarReloj(){
        reloj1.iniciarReloj();
    }
    /**
     * El Tiempo actual del reloj, se utiliza cuando se acaba el juego.
     * 
     * @return Es la hora del reloj. 
     */
    public String devolverReloj(){
        return reloj1.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Interfaz.Reloj reloj1;
    private javax.swing.JButton salir;
    private DamasEnLinea.TableroCliente tablero;
    private javax.swing.JLabel textTurno;
    // End of variables declaration//GEN-END:variables
}
