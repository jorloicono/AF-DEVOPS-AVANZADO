package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Class5 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        try{

            // Navegamos a la web

            driver.get("https://www.wikipedia.es");

            // Esperamos 2 segundos

            Thread.sleep(2000);

            // Busco el elemento con ese xpath y lo guardo en un webelement

            WebElement leerButton = driver.findElement(By.xpath("//*[@id=\"main-tfa\"]//*[text() = ' Leer ']"));
            leerButton.click();

            // Esperamos 2 segundos

            Thread.sleep(2000);

            // Printeo el titulo de esa nueva pagina

            System.out.println(driver.getTitle());

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
