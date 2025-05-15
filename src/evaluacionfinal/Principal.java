/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionfinal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import jflex.Main;

/**
 *
 * @author Oscar Velásquez
 */
public class Principal {
    public static void main(String[] args) {
        String[] flexArchivo1 = {"C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/src/evaluacionfinal/Lexer.flex"};
        String[] flexArchivo2 = {"C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/src/evaluacionfinal/LexerCup.flex"};
        String[] rutaS = {"-parser","Sintax","C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/src/evaluacionfinal/Sintax.cup"};
        
        try {
            Main.main(flexArchivo1);
            System.out.println("Lexer.java generado correctamente.");
            Main.main(flexArchivo2);
            System.out.println("LexerCup.java generado correctamente.");
            java_cup.Main.main(rutaS);
            
            Files.move(
                      Paths.get("C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/sym.java"),
                      Paths.get("C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/src/evaluacionfinal/sym.java"),
                      StandardCopyOption.REPLACE_EXISTING
            );
            
            Files.move(
                      Paths.get("C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/Sintax.java"),
                      Paths.get("C:/Users/Oscar Velásquez/Documents/NetBeansProjects/EvaluacionFinal/src/evaluacionfinal/Sintax.java"),
                      StandardCopyOption.REPLACE_EXISTING
            );
            
            
        } catch (Exception e) {
            System.err.println("Error al generar Lexer.java: " + e.getMessage());
        }
        
    }
}
