package main.lessons_25;

public class PlaneFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
