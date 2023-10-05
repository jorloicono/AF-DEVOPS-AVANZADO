package selenium_example;

// Tenemos que tener las librerias externas y los drivers dentro de nuestro proyecto

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Class1 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        // Abrimos un try catch por que hay que cerrar las instanias de navegador y las sesiones de selenium siempre
        // Lo cual le indicamos en el finally con driver.quit. Tenemos tambien la opcion de driver.close. Quit cerrara el navegador
        // completamente cerrara todas las ventanas. Close cerrara solo la que tengamos el foco.

        try{

            // Navegamos a la web

            driver.get("https://www.wikipedia.es");

            // Esperamos 5 segundos

            Thread.sleep(5000);

            // Obtenemos el titulo de la pagina

            String titulo = driver.getTitle();

            System.out.println(titulo);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
