
package Modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PowerFox
 */
public class Modelo{
    
    static final String PREFIJO_RUTA = "src\\zData";
    static final String WIN_APPENDER = "\\";
    
    
    public static void cargarDatos(String tipoDato, String mes, String anio){
        if(!"".equals(tipoDato) && !"Mes".equals(mes) && !"Año".equals(anio)){
            if("Velocidad".equals(tipoDato)){
                List<VelocidadDTO> velocidades = leerVelocidades(tipoDato,mes,anio);
            }if("Volumen".equals(tipoDato)){
                List<VolumenDTO> volumenes = leerVolumenes(tipoDato,mes,anio);
            }
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
    
    static List<VelocidadDTO> leerVelocidades(String tipoDato, String mes, String anio){
        List<VelocidadDTO> velocidadesDTO = new ArrayList<>();
        try{
            System.out.println("leerVelocidades");
            String ruta = hacerRuta(tipoDato, mes, anio);
            
            File folder = new File(ruta);
            File[] listOfFiles = folder.listFiles();
            
            for(File file: listOfFiles){
                if(!file.getName().startsWith("~")){
                    System.out.println(ruta + WIN_APPENDER + file.getName() + "--------------------------------------------------------------");
                    VelocidadDTO vel = new VelocidadDTO();
                    FileInputStream stream = new FileInputStream(new File(ruta + WIN_APPENDER + file.getName()));
                    XSSFWorkbook workbook = new XSSFWorkbook(stream);
                    XSSFSheet worksheet = workbook.getSheet("1.IDENTIFICACION");

                    //Lectura nombreArchivo
                    Row row1 = worksheet.getRow(9);
                    Cell cell1 = row1.getCell(21);
                    vel.setNombreArchivo(cell1.getStringCellValue());
                    System.out.println("Nombre del archivo: " + vel.getNombreArchivo());
                    
                    //Lectura nombreCorredor
                    Row row2 = worksheet.getRow(11);
                    Cell cell2 = row2.getCell(21);
                    vel.setNombreCorredor(cell2.getStringCellValue());
                    System.out.println("Corredor vial: " + vel.getNombreCorredor());
                    
                    //Lectura fechaEstudio
                    Row row3 = worksheet.getRow(25);
                    Cell cell3 = row3.getCell(17);
                    vel.setFechaEstudio(cell3.getStringCellValue());
                    System.out.println("Fecha del estudio: " + vel.getFechaEstudio());
                    
                    //Lectura analisisPuntual
                    Row row4 = worksheet.getRow(57);
                    Cell cell4 = row4.getCell(16);
                    vel.setAnalisisPuntual(cell4.getStringCellValue());
                    System.out.println("El análisis: " + vel.getAnalisisPuntual());
                    
                    //Lectura descripcionTramos
                    List<List<String>> tramos = new ArrayList<>();
                    for(int i = 33 ; i < 55 ; i++){
                        List<String> descripcion = new ArrayList<>();
                        Row tramo = worksheet.getRow(i);
                        int cont = 0;
                        for(int j = 17 ; j < 20 ; j++){
                            Cell desc = tramo.getCell(j);
                            if(cont == 0 || cont ==1){
                                if(!desc.getStringCellValue().isEmpty() || !desc.getStringCellValue().equals(""))
                                    descripcion.add(desc.getStringCellValue());
                            }else{
                                if(desc.getNumericCellValue() != 0)
                                    descripcion.add(String.valueOf(desc.getNumericCellValue()));
                            }
                            cont++;
                        }
                        tramos.add(descripcion);
                    }
                    vel.setDescripcionTramos(tramos);
                    
                    for(int i = 0; i<vel.getDescripcionTramos().size(); i++){
                        for(int j = 0; j<vel.getDescripcionTramos().get(i).size(); j++){
                            System.out.println("Tramos: " + vel.getDescripcionTramos().get(i).get(j));
                        }
                    }
                    
                    //Lectura tipoVehiculos
                    List<String> tipoVehiculos = new ArrayList<>();
                    for(int i = 31 ; i < 33 ; i++){
                        Row tipo = worksheet.getRow(i);
                        for(int j = 25 ; j < 29 ; j+=2){
                            Cell vehiculo = tipo.getCell(j);
                            if(!vehiculo.getStringCellValue().isEmpty() || !vehiculo.getStringCellValue().equals(""))
                                tipoVehiculos.add(vehiculo.getStringCellValue());
                        }
                    }
                    vel.setTipoVehiculo(tipoVehiculos);
                    
                    for(int i = 0; i<vel.getTipoVehiculo().size(); i++){
                        System.out.println("Tipo vehiculo: " + vel.getTipoVehiculo().get(i));
                    }
                    
                    //Lectura horarios de periodos
                    List<List<String>> horarios = new ArrayList<>();
                    for(int i = 34 ; i < 37 ; i++){
                        List<String> periodos = new ArrayList<>();
                        Row horario = worksheet.getRow(i);
                        for(int j = 25 ; j < 29 ; j+=2){
                            Cell periodo = horario.getCell(j);
                            if(!periodo.getStringCellValue().isEmpty() || !periodo.getStringCellValue().equals(""))
                                periodos.add(periodo.getStringCellValue());
                        }
                        horarios.add(periodos);
                    }
                    vel.setHorarioDePeriodos(horarios);
                    
                    for(int i = 0; i<vel.getHorarioDePeriodos().size(); i++){
                        for(int j = 0; j<vel.getHorarioDePeriodos().get(i).size(); j++){
                            System.out.println("Horarios: " + vel.getHorarioDePeriodos().get(i).get(j));
                        }
                    }
                    
                    //Lectura numEquipos
                    List<List<String>> equipos = new ArrayList<>();
                    for(int i = 37 ; i < 40 ; i++){
                        List<String> num = new ArrayList<>();
                        Row equipo = worksheet.getRow(i);
                        int cont = 0;
                        for(int j = 25 ; j < 29 ; j+=2){
                            Cell numero = equipo.getCell(j);
                            if(cont == 0){
                                if(!numero.getStringCellValue().isEmpty() || !numero.getStringCellValue().equals(""))
                                    num.add(numero.getStringCellValue());
                            }
                            else{
                                if(numero.getNumericCellValue() != 0)
                                    num.add(String.valueOf((int)numero.getNumericCellValue()));
                            }
                            cont++;
                        }
                        equipos.add(num);
                    }
                    vel.setNumEquipos(equipos);
                    
                    for(int i = 0; i<vel.getNumEquipos().size(); i++){
                        for(int j = 0; j<vel.getNumEquipos().get(i).size(); j++){
                            System.out.println("Equipos: " + vel.getNumEquipos().get(i).get(j));
                        }
                    }
                    
                    //Lectura de velocidades
                    XSSFSheet worksheet1 = workbook.getSheet("4c.PERFIL DE VELOCIDAD");
                    List<List<String>> velocidades = new ArrayList<>();
                    int k = 15;
                    while(worksheet1.getRow(k) != null){
                        int cont = 0;
                        Row tramo = worksheet1.getRow(k);
                        List<String> velocidad = new ArrayList<>();
                        for(int j = 1; j < 6; j++){
                            Cell cell = tramo.getCell(j);
                            if(cont == 0 || cont == 1){
                                if(!cell.getStringCellValue().isEmpty() || !cell.getStringCellValue().equals(""))
                                    velocidad.add(cell.getStringCellValue());
                            }
                            if(cont == 2 || cont == 3 || cont == 4){
                                if(cell.getNumericCellValue() != 0)
                                    velocidad.add(String.valueOf(cell.getNumericCellValue()));
                            }
                            cont++;
                        }
                        velocidades.add(velocidad);
                        k++;
                    }
                    vel.setVelocidadesPromedio(velocidades);
                    
                    for(int i = 0; i<vel.getVelocidadesPromedio().size(); i++){
                        for(int j = 0; j<vel.getVelocidadesPromedio().get(i).size(); j++){
                            System.out.println("Velocidades: " + vel.getVelocidadesPromedio().get(i).get(j));
                        }
                    }
                    
                    //Lectura de datos definitivos
                    XSSFSheet worksheet2 = workbook.getSheet("5b.RESUMEN MENSUAL");
                    Row res1 = worksheet2.getRow(7);
                    
                    Cell ce1 = res1.getCell(8);
                    vel.setVelTP_AM_NS_WE(ce1.getNumericCellValue());
                    
                    Cell ce2 = res1.getCell(9);
                    vel.setVelTP_M_NS_WE(ce2.getNumericCellValue());
                    
                    Cell ce3 = res1.getCell(10);
                    vel.setVelTP_PM_NS_WE(ce3.getNumericCellValue());
                    
                    Cell ce4 = res1.getCell(11);
                    vel.setVelTPC_AM_NS_WE(ce4.getNumericCellValue());
                    
                    Cell ce5 = res1.getCell(12);
                    vel.setVelTPC_M_NS_WE(ce5.getNumericCellValue());
                    
                    Cell ce6 = res1.getCell(13);
                    vel.setVelTPC_PM_NS_WE(ce6.getNumericCellValue());
                    
                    Cell ce7 = res1.getCell(14);
                    vel.setVelTPI_AM_NS_WE(ce7.getNumericCellValue());
                    
                    Cell ce8 = res1.getCell(15);
                    vel.setVelTPI_M_NS_WE(ce8.getNumericCellValue());
                    
                    Cell ce9 = res1.getCell(16);
                    vel.setVelTPI_PM_NS_WE(ce9.getNumericCellValue());
                    
                    Cell ce10 = res1.getCell(20);
                    vel.setVelTP_AM_SN_EW(ce10.getNumericCellValue());
                    
                    Cell ce11 = res1.getCell(21);
                    vel.setVelTP_M_SN_EW(ce11.getNumericCellValue());
                    
                    Cell ce12 = res1.getCell(22);
                    vel.setVelTP_PM_SN_EW(ce12.getNumericCellValue());
                    
                    Cell ce13 = res1.getCell(23);
                    vel.setVelTPC_AM_SN_EW(ce13.getNumericCellValue());
                    
                    Cell ce14 = res1.getCell(24);
                    vel.setVelTPC_M_SN_EW(ce14.getNumericCellValue());
                    
                    Cell ce15 = res1.getCell(25);
                    vel.setVelTPC_PM_SN_EW(ce15.getNumericCellValue());
                    
                    Cell ce16 = res1.getCell(26);
                    vel.setVelTPI_AM_SN_EW(ce16.getNumericCellValue());
                    
                    Cell ce17 = res1.getCell(27);
                    vel.setVelTPI_M_SN_EW(ce17.getNumericCellValue());
                    
                    Cell ce18 = res1.getCell(28);
                    vel.setVelTPI_PM_SN_EW(ce18.getNumericCellValue());
                    System.out.println("velTPI: " + vel.getVelTPI_PM_SN_EW());
                    
                    velocidadesDTO.add(vel);
                }
            }
        }catch(Exception e){
            System.out.println("Se ha generado un problema leyendo los archivos -> " + e );
            e.printStackTrace();
        }
        System.out.println("Done!");
        return velocidadesDTO;
    }
    
    static List<VolumenDTO> leerVolumenes(String tipoDato, String mes, String anio){
        List<VolumenDTO> volumenesDTO = new ArrayList<>();
        try{
            System.out.println("leerVolumenes");
            String ruta = hacerRuta(tipoDato, mes, anio);
            
            File folder = new File(ruta);
            File[] listOfFiles = folder.listFiles();
            
            for(File file: listOfFiles){
                if(!file.getName().startsWith("~")){
                    System.out.println(ruta + WIN_APPENDER + file.getName() + "--------------------------------------------------------------");
                    VolumenDTO vol = new VolumenDTO();
                    FileInputStream stream = new FileInputStream(new File(ruta + WIN_APPENDER + file.getName()));
                    XSSFWorkbook workbook = new XSSFWorkbook(stream);
                    XSSFSheet worksheet = workbook.getSheet("1.IDENTIFICACION");
                    
                    //Lectura Longitud y Latitud
                    Row longitud = worksheet.getRow(12);
                    Cell longitu = longitud.getCell(23);
                    vol.setLon(longitu.getStringCellValue());
                    System.out.println("Longitud: " + vol.getLon());
                    
                    Row latitud = worksheet.getRow(13);
                    Cell latitu = latitud.getCell(23);
                    vol.setLat(latitu.getStringCellValue());
                    System.out.println("Latitud: " + vol.getLat());
                    
                    //Lectura nombreArchivo
                    Row nombre = worksheet.getRow(9);
                    Cell nom = nombre.getCell(21);
                    vol.setNombreArchivo(nom.getStringCellValue());
                    System.out.println("Nombre del Archivo:" + vol.getNombreArchivo());
                    
                    //Lectura interseccion
                    Row interseccion = worksheet.getRow(9);
                    Cell inter = interseccion.getCell(21);
                    vol.setInterseccion(inter.getStringCellValue());
                    System.out.println("Intersección: " + vol.getInterseccion());
                    
                    //Lectura fechaEstudio
                    Row fecha = worksheet.getRow(27);
                    Cell fec = fecha.getCell(18);
                    vol.setFechaEstudio(fec.getStringCellValue());
                    System.out.println("Fecha: " + vol.getFechaEstudio());
                    
                    //Lectura analisisPuntual
                    Row analisis = worksheet.getRow(58);
                    Cell ana = analisis.getCell(16);
                    vol.setAnalisisPuntual(ana.getStringCellValue());
                    System.out.println("Analisis: " + vol.getAnalisisPuntual());
                    
                    //Lectura numPeriodos
                    List<String> numPeriodos = new ArrayList<>();
                    for(int i = 34; i < 37; i++){
                        Row periodos = worksheet.getRow(i);
                        Cell per = periodos.getCell(23);
                        if(!per.getStringCellValue().isEmpty() || !per.getStringCellValue().equals("")){
                            numPeriodos.add(per.getStringCellValue());
                        }
                    }
                    vol.setNumPeriodos(numPeriodos);
                    
                    for(int i = 0; i<vol.getNumPeriodos().size(); i++){
                        System.out.println("Periodo " + i + ": " + vol.getNumPeriodos().get(i));
                    }
                    
                    //Lectura numHoras
                    Row horas = worksheet.getRow(37);
                    Cell hor = horas.getCell(24);
                    vol.setNumHoras(String.valueOf(hor.getNumericCellValue()));
                    System.out.println("Número de horas: " + vol.getNumHoras());
                    
                    //Lectura horario
                    Row horario = worksheet.getRow(38);
                    Cell hora = horario.getCell(24);
                    vol.setHorario(hora.getStringCellValue());
                    System.out.println("Horario: " + vol.getHorario());
                    
                    //Lectura numEquipos
                    Row equipos = worksheet.getRow(39);
                    Cell equi = equipos.getCell(24);
                    vol.setNumEquipos(String.valueOf(equi.getNumericCellValue()));
                    System.out.println("Numero de equipos: " + vol.getNumEquipos());
                    
                    //Lectura resumen mensual
                    XSSFSheet worksheet1 = workbook.getSheet("5a.RESUMEN MENSUAL");
                    
                    Row livianos = worksheet1.getRow(7);
                    Cell livi = livianos.getCell(9);
                    vol.setVolLivianos((int)livi.getNumericCellValue());
                    System.out.println("Volumen vehículos livianos: " + vol.getVolLivianos());
                    
                    Row vtpc = worksheet1.getRow(7);
                    Cell tpc = vtpc.getCell(10);
                    vol.setVolTPC((int)tpc.getNumericCellValue());
                    System.out.println("Volumen Transporte público colectivo: " + vol.getVolTPC());
                    
                    Row camiones = worksheet1.getRow(7);
                    Cell camion = camiones.getCell(11);
                    vol.setVolCamiones((int)camion.getNumericCellValue());
                    System.out.println("Volumen camiones: " + vol.getVolCamiones());
                    
                    Row motos = worksheet1.getRow(7);
                    Cell moto = motos.getCell(12);
                    vol.setVolMotos((int)moto.getNumericCellValue());
                    System.out.println("Volumen motos: " + vol.getVolMotos());
                    
                    Row total = worksheet1.getRow(7);
                    Cell tot = total.getCell(17);
                    vol.setVolTotal((int)tot.getNumericCellValue());
                    System.out.println("Volumen total: " + vol.getVolTotal());
                }
            }
        }catch(Exception e){
            System.out.println("Se ha generado un problema leyendo los archivos -> " + e );
            e.printStackTrace();
        }
        System.out.println("Done!");
        return volumenesDTO;
    }
    
    static String hacerRuta (String tipoDato, String mes, String anio){
        String ruta = PREFIJO_RUTA + WIN_APPENDER + tipoDato + WIN_APPENDER + 
                anio + WIN_APPENDER + mes;
        return ruta;
    }
    
}

//                    FileInputStream stream = new FileInputStream(new File(ruta + WIN_APPENDER + file.getName()));
//                    XSSFWorkbook workbook = new XSSFWorkbook(stream);
//                    XSSFSheet worksheet = workbook.getSheet("1.IDENTIFICACION");
//                    Iterator<Row> rowIterator = worksheet.iterator();
//                    int i = 0;
//                    while (rowIterator.hasNext()) {
//                      Row row = rowIterator.next();
//                      Iterator <Cell> cellIterator = row.cellIterator();
//                      int j = 0;
//                      while (cellIterator.hasNext()) {
//                        Cell cell = cellIterator.next();
//                        System.out.print(i + "," + j + ": "+ cell.getStringCellValue() + "\n");
//                        j++;
//                      }
//                      i++;
//                    }