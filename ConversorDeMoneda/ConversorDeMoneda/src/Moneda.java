import java.util.Scanner;

public enum Moneda {
    USD("Dólar Estadounidense"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    JPY("Yen Japonés"),
    CAD("Dólar Canadiense"),
    AUD("Dólar Australiano"),
    CHF("Franco Suizo"),
    CNY("Yuan Chino"),
    MXN("Peso Mexicano"),
    BRL("Real Brasileño"),
    COP("Peso Colombiano"),
    ARS("Peso Argentino"),
    CLP("Peso Chileno"),
    PEN("Sol Peruano");

    private final String nombreCompleto;

    Moneda(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public static void mostrarMenu(){
        System.out.println("==========  MONEDAS DISPONIBLES ============");
        Moneda[] monedas = Moneda.values();
        for (int i = 0; i < monedas.length; i++){
            System.out.printf("%2d. %s (%s)%n", i + 1, monedas[i].getNombreCompleto(), monedas[i].name());
        }
    }

    public static Moneda seleccionarMoneda(Scanner lectura, String tipo){
        while (true){
            System.out.println("\n--- Seleccionar Moneda "+tipo.toUpperCase() + "---");
            mostrarMenu();
            System.out.println("Seleccione el numero de la moneda");
            try{
                int seleccion = lectura.nextInt();
                lectura.nextLine();
                if(seleccion >=1 && seleccion <= Moneda.values().length){
                    return Moneda.values()[seleccion - 1];
                }else {
                    System.out.println("Error: Seleccione un numero entre 1 y "+Moneda.values().length);
                }
            } catch (Exception e){
                System.out.println("Error: Entrada invalida. Debe ingresar un numero.");
                lectura.nextLine();
            }
        }
    }
}
