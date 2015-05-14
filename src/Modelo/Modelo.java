
package Modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author PowerFox
 */
public class Modelo{
    
    public static void cargarDatos(String tipoDato, String mes, String anio){
        if(tipoDato != "" && mes != "Mes" && anio != "Año"){
        System.out.println(tipoDato + " " + mes + " " + anio);
        }else
            JOptionPane.showMessageDialog(new JFrame(), "Por favor ingrese los datos solicitados");
    }
    
    public static void limpiarMapa(){
        System.out.println("Limpiar mapa a implementar");
    }
    
    public static void cargarMasInfo(){
        System.out.println("Mostrar mas info");
        
        //Creamos la nueva ventana
        JFrame masInfo = new JFrame();
        masInfo.setSize(900,750);    
        masInfo.setResizable(false);
        masInfo.setLocationRelativeTo(null);
        masInfo.setVisible(true);
        
        //Agregamos panel global para la ventana
        JPanel global = new JPanel();
        GroupLayout layout = new GroupLayout(global);
        global.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        //Agrega la información que deseamos mostrar
        JLabel noHay = new JLabel("Por implementar");
        
        //Organizar el layout global
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(noHay)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(noHay)
        );
        
        //Agregamos la informacion a la ventana
        masInfo.add(global);
    }

    public static void mostrarInfo() throws Exception{
        //Creamos la nueva ventana
        JFrame infoApp = new JFrame();
        infoApp.setSize(500,200);    
        infoApp.setResizable(false);
        infoApp.setLocationRelativeTo(null);
        infoApp.setVisible(true);
        
        //Agregamos la información a mostrar
        JLabel cr = new JLabel(InfoApp.COPYRIGHT);
        JLabel des = new JLabel(InfoApp.DESARROLLADOR);
        JLabel dir = new JLabel(InfoApp.DIRECTOR);
        JLabel na = new JLabel(InfoApp.NOMBRE_APP);
        JLabel un = new JLabel(InfoApp.UNIVERSIDAD);
        BufferedImage jv = ImageIO.read(new File("src\\img\\Javeriana.png"));
        JLabel logoPUJ = new JLabel(new ImageIcon(jv));
        
        //Panel de logo
        JPanel logo = new JPanel();
        GroupLayout layoutLogo = new GroupLayout(logo);
        logo.setLayout(layoutLogo);
        layoutLogo.setAutoCreateGaps(true);
        layoutLogo.setAutoCreateContainerGaps(true);

        //Panel de información
        JPanel info = new JPanel();
        GroupLayout layoutInfo = new GroupLayout(info);
        info.setLayout(layoutInfo);
        layoutInfo.setAutoCreateGaps(true);
        layoutInfo.setAutoCreateContainerGaps(true);
        
        //Layout para panel logo
        layoutLogo.setHorizontalGroup(layoutLogo.createSequentialGroup()
                .addComponent(logoPUJ)
        );
        layoutLogo.setVerticalGroup(layoutLogo.createSequentialGroup()
                .addComponent(logoPUJ)
        );
        
        //Layout para panel info
        layoutInfo.setHorizontalGroup(layoutInfo.createSequentialGroup()
                .addGroup(layoutInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cr)
                        .addComponent(des)
                        .addComponent(dir)
                        .addComponent(na)
                        .addComponent(un)
                )
        );
        layoutInfo.setVerticalGroup(layoutInfo.createSequentialGroup()
                .addComponent(cr)
                .addComponent(des)
                .addComponent(dir)
                .addComponent(na)
                .addComponent(un)
        );
        
        //Panel global
        JPanel content = new JPanel();
        GroupLayout layout = new GroupLayout(content);
        content.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        //Layout para panel global
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(logo)
                .addComponent(info)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(logo)
                    .addComponent(info)
                )
        );
        
        //Añadir panel global a la ventana
        infoApp.add(content);
    }
    
}
