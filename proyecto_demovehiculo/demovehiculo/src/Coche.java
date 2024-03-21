

public class Coche extends Vehiculo implements IRadio, IClimatizador, IVehiculoMotor {

    private int nPuertas;
    private int nVentanas;
    private boolean packFumador;
    private String tapiceria;
    
    public Coche(int nRuedas, int nAsientos) {

        super(nRuedas, nAsientos);

    }

    @Override
    public void detener() {}

    @Override
    public void startRadio() {}

    @Override
    public void stopRadio() {}

    @Override
    public void apagar() {}

    @Override
    public void cambiarTemperatura() {}

    @Override
    public void encender() {}

    @Override
    public void arrancar() {
        Starter.startEngine(this);
    }

    @Override
    public float getMaxVel() {
        return 0;
    }

    @Override
    public void cambiarMarcha() {}

    @Override
    public void cambiarModo() {}

    @Override
    public void embragar() {}
}
