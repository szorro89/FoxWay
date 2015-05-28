/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import com.esri.map.JMap;
import com.esri.map.MapOptions;
import com.esri.toolkit.overlays.NavigatorOverlay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author PowerFox
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private JMap map;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          // instance of this application
          PantallaPrincipal mapExtentApp = new PantallaPrincipal();
          // create the UI, including the map and menu, for the application.
          JFrame appWindow = mapExtentApp.createWindow();
          appWindow.add(mapExtentApp.createUI());
          appWindow.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    }
    
    private JFrame createWindow() {
    JFrame window = new JFrame("FoxWay Application");
    window.setSize(1366, 768);
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    ImageIcon img = new ImageIcon("src\\img\\FoxWay.png");
    window.setIconImage(img.getImage());
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setLayout(new BorderLayout());
    window.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent windowEvent) {
        super.windowClosing(windowEvent);
        map.dispose();
      }
    });
    return window;
  }
    
  // ------------------------------------------------------------------------
  // Core functionality
  // ------------------------------------------------------------------------
  /**
   * Creates and displays the UI, including the map, for this application.
     * @return 
     * @throws java.lang.Exception
   */
    private JComponent createUI() throws Exception {

    // application content
    JPanel contentPane = new JPanel(new BorderLayout());

    // map options: tipo de mapa street map, centrado en lat-lon 4.65, -74.08 (Bogotá), zoom level 11
    MapOptions mapOptions = new MapOptions(MapOptions.MapType.STREETS, 4.65000, -74.080, 11);
    
    // crea el mapa usando MapOptions
    map = new JMap(mapOptions);
    
    //adding menu panel
    final JPanel menu = new JPanel();
    GroupLayout layout = new GroupLayout(menu);
    menu.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    menu.setLocation(1060,0);
    menu.setSize(300,740);
    menu.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    
    //adding Cargar Información option
    final JPanel cargar = new JPanel();
    GroupLayout layoutCargar = new GroupLayout(cargar);
    cargar.setLayout(layoutCargar);
    layoutCargar.setAutoCreateGaps(true);
    layoutCargar.setAutoCreateContainerGaps(true);
    cargar.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    JLabel cargarInfo = new JLabel("Cargar Información:");
    final JRadioButton checkVelocidad = new JRadioButton("Velocidad");
    final JRadioButton checkVolumen = new JRadioButton("Volumen");
    ButtonGroup group = new ButtonGroup();
    group.add(checkVelocidad);
    group.add(checkVolumen);
    String[] meses = {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    final JComboBox comboBoxMeses = new JComboBox(meses);
    String[] anios = {"Año","2011", "2012", "2013", "2014"};
    final JComboBox comboBoxAnios = new JComboBox(anios);
    JButton botonCargar = new JButton("Cargar");
    
    botonCargar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tipoDato = "";
            if(checkVelocidad.isSelected())
                tipoDato = checkVelocidad.getActionCommand();
            if(checkVolumen.isSelected())
                tipoDato = checkVolumen.getActionCommand();
            String mes = String.valueOf(comboBoxMeses.getSelectedItem());
            String anio = String.valueOf(comboBoxAnios.getSelectedItem());
            
            Controlador.cargarDatos(tipoDato, mes, anio, map);
        }
    });
    
    layoutCargar.setHorizontalGroup(layoutCargar.createSequentialGroup()
            .addGroup(layoutCargar.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(cargarInfo)
                .addComponent(checkVelocidad)
                .addComponent(comboBoxMeses)
            )
            .addGroup(layoutCargar.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(checkVolumen)
                .addComponent(comboBoxAnios)
                .addComponent(botonCargar, GroupLayout.Alignment.TRAILING)
            )
    );
    layoutCargar.setVerticalGroup(layoutCargar.createSequentialGroup()
            .addComponent(cargarInfo)
            .addGroup(layoutCargar.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(checkVelocidad)
                .addComponent(checkVolumen)
            )
            .addGroup(layoutCargar.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(comboBoxMeses)
                .addComponent(comboBoxAnios)
            )
            .addComponent(botonCargar)
    );
    
    //adding Limpiar mapa option
    final JPanel limpiar = new JPanel();
    GroupLayout layoutLimpiar = new GroupLayout(limpiar);
    limpiar.setLayout(layoutLimpiar);
    layoutLimpiar.setAutoCreateGaps(true);
    layoutLimpiar.setAutoCreateContainerGaps(true);
    limpiar.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    JLabel limpiarMapa = new JLabel("Limpiar:");
    JButton botonLimpiarMapa = new JButton("Limpiar Mapa");
    
    botonLimpiarMapa.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controlador.limpiarMapa();
        }
    });
    
    layoutLimpiar.setHorizontalGroup(layoutLimpiar.createSequentialGroup()
            .addComponent(limpiarMapa)
            .addGap(90)
            .addComponent(botonLimpiarMapa)
    );
    layoutLimpiar.setVerticalGroup(layoutLimpiar.createSequentialGroup()
            .addGroup(layoutLimpiar.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarMapa)
                    .addComponent(botonLimpiarMapa)
            )
    );
    
    //adding Información option
    final JPanel informacion = new JPanel();
    GroupLayout layoutInfo = new GroupLayout(informacion);
    informacion.setLayout(layoutInfo);
    layoutInfo.setAutoCreateGaps(true);
    layoutInfo.setAutoCreateContainerGaps(true);
    informacion.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    JLabel informacionEspacio = new JLabel("Información:");
    JEditorPane informacionCargar = new JEditorPane();
    JButton botonMasInfo = new JButton("Más información");
    
    botonMasInfo.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controlador.cargarMasInfo();
        }
    });
    
    layoutInfo.setHorizontalGroup(layoutInfo.createSequentialGroup()
            .addGroup(layoutInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(informacionEspacio)
                    .addComponent(informacionCargar)
                    .addComponent(botonMasInfo,GroupLayout.Alignment.TRAILING)
            )
    );
    layoutInfo.setVerticalGroup(layoutInfo.createSequentialGroup()
            .addComponent(informacionEspacio)
            .addComponent(informacionCargar)
            .addComponent(botonMasInfo)
    );
    
    //adding app logo to the menu
    final JPanel logos = new JPanel();
    GroupLayout layoutApp = new GroupLayout(logos);
    logos.setLayout(layoutApp);
    layoutApp.setAutoCreateGaps(true);
    layoutApp.setAutoCreateContainerGaps(true);
    logos.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    BufferedImage fx = ImageIO.read(new File("src\\img\\FoxWay.png"));
    JLabel logoFx = new JLabel(new ImageIcon(fx));
    BufferedImage jv = ImageIO.read(new File("src\\img\\Javeriana.png"));
    JLabel logoPUJ = new JLabel(new ImageIcon(jv));
    layoutApp.setHorizontalGroup(layoutApp.createSequentialGroup()
            .addComponent(logoPUJ)
            .addGap(27)
            .addComponent(logoFx)
    );
    layoutApp.setVerticalGroup(layoutApp.createSequentialGroup()
            .addGroup(layoutApp.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(logoPUJ)
                    .addComponent(logoFx)
            )
            
    );
    
    //adding Acerca de option
    final JPanel acerca = new JPanel();
    GroupLayout layoutAcerca = new GroupLayout(acerca);
    acerca.setLayout(layoutAcerca);
    layoutAcerca.setAutoCreateGaps(true);
    layoutAcerca.setAutoCreateContainerGaps(true);
    acerca.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(1,1,1,1)));
    JButton botonAcercaDe = new JButton("Acerca de...");
    botonAcercaDe.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Controlador.mostrarInfo();
            } catch (Exception ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    layoutAcerca.setHorizontalGroup(layoutAcerca.createSequentialGroup()
            .addGap(158)
            .addComponent(botonAcercaDe)
    );
    layoutAcerca.setVerticalGroup(layoutAcerca.createSequentialGroup()
            .addComponent(botonAcercaDe)
    );
    

    //adding components to the menu
    layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(cargar)
                .addComponent(limpiar)
                .addComponent(informacion)
                .addComponent(logos)
                .addComponent(acerca)
            )
    );
    layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(cargar)
            .addComponent(limpiar)
            .addComponent(informacion)
            .addComponent(logos)
            .addComponent(acerca)
    );
    
    //adding components to the window 
    contentPane.add(menu);
    contentPane.add(map);
        // add marker graphics directly to the map
//    map.addMarkerGraphic(41.912402,12.484778, "Villa Borghese", "Lovely park in the center of Rome.");
//    map.addMarkerGraphic(41.902149, 12.454782, "St Peter's Basilica", 
//        "Along St Peter's Square (Piazza San Pietro) in the Vatican City.", 
//        "http://www.neotryte.com/images/roma1_th.jpg", 
//        "http://en.wikipedia.org/wiki/St._Peter's_Basilica", null);
        // option to use a custom marker image by creating a BufferedImage
    NavigatorOverlay navigator = new NavigatorOverlay();
    map.addMapOverlay(navigator);
    map.setShowingEsriLogo(false);
//    BufferedImage imgMarker = null;
//    try {
//      // create buffered image from a public URL
//      imgMarker = ImageIO.read(new URL("http://www.neotryte.com/images/museum-icon.png"));
//    } catch (IOException e) { e.printStackTrace(); }
//        // add marker graphic using the custom marker image
//    map.addMarkerGraphic(41.898548, 12.476858, 
//        "Pantheon", 
//        "Built during the reign of Augustus as a temple to all the gods of ancient Rome.", 
//        "http://www.neotryte.com/images/roma2_th.jpg", 
//        "http://en.wikipedia.org/wiki/Pantheon,_Rome", imgMarker);

    return contentPane;
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
