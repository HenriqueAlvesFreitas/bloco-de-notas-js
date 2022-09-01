package shape.fala.pormim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML TextArea textArea;

   public void salvar(){
    String texto = textArea.getText();

    var dialogoSalvar = new FileChooser();
    var file = dialogoSalvar.showSaveDialog(null);

   //String file = "C:\\Users\\logonrmlocal\\Desktop\\Shape\\texto.txt";
    try {
        var out = new PrintWriter(file);
        out.write(texto);
        out.close();
    } catch (FileNotFoundException e) {
      var alerta = new Alert(AlertType.ERROR);
    alerta.setContentText("Arquivo não encontrado");
    alerta.show();
    }
    System.out.println("Salvar o arquivo -> " + texto);
   }

   public void abrir(){
    var dialogAbrir = new FileChooser();
    var file = dialogAbrir.showOpenDialog(null);
       
       try {
           var path = file.toPath();
           //Path path = Path.of("C:\\Users\\logonrmlocal\\Desktop\\Shape\\texto.txt");
           String texto;
           
           texto = Files.readString(path);
          
           textArea.setText(texto);
        } 
       catch (IOException e) {
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("erro ao abrir o arquivo");
            alerta.show();
        }
   }
} 
