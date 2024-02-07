package practica.demo_vehiculo;

public interface IMotor {

    public static boolean esMasRapido(IMotor vehiculoMotor, IMotor vehiculoMotor2) {
        if (vehiculoMotor.getMaxVel() > vehiculoMotor2.getMaxVel()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public default void consumoComb() {

        // TODO método de consumo de combustible para camiones
    }

    float getMaxVel();

    void arrancar();

    void detener();

}
