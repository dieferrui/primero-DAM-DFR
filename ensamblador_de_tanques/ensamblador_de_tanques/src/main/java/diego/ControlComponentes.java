package diego;

import java.util.HashMap;
import java.util.Map;

import diego.componentes.*;
import diego.componentes.enums.*;

public class ControlComponentes {

    protected Map<String, Chassis> mapaChasis = new HashMap<>();
    protected Map<String, Armamento> mapaArmas = new HashMap<>();
    protected Map<String, Motor> mapaMotores = new HashMap<>();
    protected Map<String, Torreta> mapaTorretas = new HashMap<>();

    // El constructor crea una instancia con los componentes especificados
    public ControlComponentes() {

        agregarComponentes();

    }

    // El administrador agregará los componentes disponibles mediante código
    public void agregarComponentes() {

        // Chasis
        Chassis testChasis = new Chassis("Chasis de prueba", new Paises[]{Paises.ALEMANIA}, 18000, 
                                        new double[]{24500, 14000}, new int[]{60, 30, 30});
        Chassis testChasis2 = new Chassis("Chasis de prueba 2", new Paises[]{Paises.ESTADOS_UNIDOS},22000, 
                                        new double[]{26350, 17000}, new int[]{70, 40, 40});

        mapaChasis.put("CHS-GE-000", testChasis);
        mapaChasis.put("CHS-US-000", testChasis2);

        // Armamento
        Armamento testArma = new Armamento("Cañón de prueba", new Paises[]{Paises.ALEMANIA}, 3000,
                                        ClaseArmamento.CANNON, new int[]{131, 109, 94}, 75, Municion.APHE);
        Armamento testArma2 = new Armamento("Cañón automático de prueba", new Paises[]{Paises.ESTADOS_UNIDOS}, 1200,
                                        ClaseArmamento.AUTOCANNON, new int[]{71, 58, 33}, 37, Municion.AP);

        mapaArmas.put("GUN-GE-000", testArma);
        mapaArmas.put("GUN-US-000", testArma2);

        // Motores
        Motor testMotor = new Motor("Motor de prueba", new Paises[]{Paises.ALEMANIA}, 700, 
                    500, 45, 540);
        Motor testMotor2 = new Motor("Motor de prueba 2", new Paises[]{Paises.ESTADOS_UNIDOS}, 800, 
                    600, 50, 600);

        mapaMotores.put("ENG-GE-000", testMotor);
        mapaMotores.put("ENG-US-000", testMotor2);

        // Torretas
        Torreta testTorreta = new Torreta("Torreta de prueba", new Paises[]{Paises.ALEMANIA}, 3400,
                        TipoTorreta.TORRETA, new double[]{360, 8, 8}, new int[]{80, 50, 50});
        Torreta testTorreta2 = new Torreta("Torreta de prueba 2", new Paises[]{Paises.ESTADOS_UNIDOS}, 2000,
                        TipoTorreta.SUPERESTRUCTURA, new double[]{40, 12, 10}, new int[]{90, 60, 60});

        mapaTorretas.put("TUR-GE-000", testTorreta);
        mapaTorretas.put("SUP-US-000", testTorreta2);

    }
}
