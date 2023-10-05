package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Coche;
import modelo.Parking;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDateTime;




public class Pruebas {

	
	// Creo variables de coche y parking para poder utilizar e iniciarlas en el metodo antes para crearlas antes de los test
    static Coche coche; 
    static Parking parking;
    
    @BeforeAll
    @DisplayName ("Creo objetos para las pruebas")
    static void Antes() {
    	//creo un coche con variacion de 30 minutos para comprobar que el resultado de cantidadAPagar es correcto
    	coche = new Coche("Clio", "Renault", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
		parking = new Parking();
	
    }

    @Test
    @DisplayName ("Prueba cantidad a pagar")
    void TestCantidadAPagar() {
        assertEquals(4.5, coche.cantidadAPagar(), "Valor no esperado");
    }
    

    @Test
    @DisplayName ("Prueba existe coche")
    public void testExisteCoche() {
        // Agrego el coche creado al parking, añadiendole la matricula   
        parking.putCoche("7162 BSR", coche);
        // Compruebo que exista ese coche en el parking
        assertTrue(parking.existeCoche("7162 BSR"));
    }

    @Test
    @DisplayName ("Prueba de get coche del parking")
    public void testGetCoche() {
    	// Agrego el coche creado al parking, añadiendole la matricula
        parking.putCoche("7162 BSR", coche);
        //guardo en un variable coche el coche que obtiene el metodo pasandole la matricula
        Coche cocheObtenido = parking.getCoche("7162 BSR");
        // comparo el coche introducido por mi y el coche que localiza por matricula
        assertEquals(coche, cocheObtenido);
    }

    @Test
    @DisplayName ("Prueba put coche al parking")
    public void testPutCoche() {
    	// Agrego el coche creado al parking, añadiendole la matricula
        parking.putCoche("7162 BSR", coche);

        // Comprobar si el coche existe
        assertTrue(parking.existeCoche("7162 BSR"));
    }

    @Test
    @DisplayName ("Prueba los coches que estan en el sistema")
    public void testImprimirCochesSistema() {
        // para la prueba de este metodo creo otro coche 
        Coche coche2 = new Coche("Focus", "Ford", LocalDateTime.now(), LocalDateTime.now());
        parking.putCoche("7162 BSR", coche);
        parking.putCoche("4431 DRS", coche2);

        // compruebo que el metodo no lanze la excepcion
       assertDoesNotThrow( ()->  {
    	   parking.imprimirCochesSistema();
       });                            

    }

    @Test
    @DisplayName ("Prueba los coches que estan en el parking")
    public void testImprimirCochesParking() {
        /* Agrego otro coche al parking, en este caso con null en hora de salida
         * ya que aun esta en el parking y es el que deberia imprimir
         */
        Coche coche1 = new Coche("Focus", "Ford", LocalDateTime.now(), null);
        parking.putCoche("7162 BSR", coche);
        parking.putCoche("4431 DRS", coche1);

        // compruebo que el metodo no lanze la excepcion
        assertDoesNotThrow( ()->  {
     	   parking.imprimirCochesParking();
        }); 
    }

    @Test
    @DisplayName ("Prueba cantidad a pagar localizando el coche por matricula")
    public void testCantidadAPagar() {
        // Agrego el coche al parking
        parking.putCoche("7162 BSR", coche);

        // Compruebo que el metodo cantidad a pagar localice correctamente por la matricula
        parking.cantidadAPagar("7162 BSR");
    }
}

