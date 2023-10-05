package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Class2 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        try{

            // Navegamos a la web

            driver.get("https://www.wikipedia.es");

            // Esperamos 2 segundos

            Thread.sleep(2000);

            // Busco el elemento con id ca-history y clico sobre el

            driver.findElement(By.id("ca-history")).click();

            // Esperamos 2 segundos

            Thread.sleep(2000);

            // Printeo el titulo de esa nueva pagina, veo que es el historial de la pagina

            String titulo = driver.getTitle();
            System.out.println(titulo);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}