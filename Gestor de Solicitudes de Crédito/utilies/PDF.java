package utilies;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Crea un archivo de extension pdf a partir de un string
 * @author KEVIN SALAZAR
 * @version 2.0
 */
public class PDF {
    public PDF(){
        
    }
   
    /**
     * Crea un pdf a partir de un string
     * @param pTexto Texto a agregar al pdf
     * @param pNombreArchivo Nombre del pdf a crear, tambien se puede insertar una direccion junto con el nombre, 
     * 
     * ¡¡¡PONER LA EXTENSION.PDF NO ES NECESARIO!!!
     */
    public void crearPDF(String pTexto, String pNombreArchivo){
      try{  
        PDDocument doc = new PDDocument();
        PDPage pag = new PDPage(PDRectangle.LETTER); //pagina tamaño carta
        doc.addPage(pag);
        PDPageContentStream contenido = new PDPageContentStream(doc,pag);
        //Inicio de escritura del pdf
        contenido.beginText();
        contenido.newLineAtOffset(20, pag.getMediaBox().getHeight()-52); //medidas estandar donde comienza el archivo
        contenido.setFont(PDType1Font.TIMES_ROMAN, 12); //Fuente Times new Roman, tamaño 12
        
        //preparacion del texto para guardado en pdf
        String linea = "";
        
        for(int i=0; i<pTexto.length(); i++){
          if(pTexto.charAt(i)=='\t'){
            linea += "        ";
            continue;
          }  
          if(pTexto.charAt(i)=='\n'){
            contenido.showText(linea);
            contenido.newLineAtOffset(0, -15); //dichos numero por estandar visto en video (esto es un salto de linea)
            linea = ""; //limpieza de variable de guardado
            continue;
          }  
          linea += pTexto.charAt(i);
        }
        
        contenido.endText();
        contenido.close();
        
        doc.save(pNombreArchivo+".pdf");
      }
      catch(Exception e){
        System.err.println(e.getMessage());
      }
    }
     
}
