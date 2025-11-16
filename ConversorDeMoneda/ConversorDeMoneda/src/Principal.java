import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        List<HistorialConversion> historialDeConversion = new ArrayList<>();
        Api api = new Api();
        System.out.println("===== CONVERSOR DE MONEDAS =====");
        while (true){
            try{
                Moneda monedabase = Moneda.seleccionarMoneda(lectura, "BASE");
                Moneda monedaObjetivo = Moneda.seleccionarMoneda(lectura, "OBJETIVO");

                if (monedabase == monedaObjetivo){
                    System.out.println("Error: No se puede convertir la misma moneda.");
                    continue;
                }
                System.out.println("\n Ingrese el monto a converitr: ");
                double monto = lectura.nextDouble();
                lectura.nextLine();
                if (monto <= 0){
                    System.out.println("Error: el monto debe ser mayor a 0");
                    continue;
                }
                Conversor conversor = api.convertir(
                        monedabase.name(),
                        monedaObjetivo.name(),
                        monto
                );
                String fecha = consultarFecha();
                HistorialConversion registro = new HistorialConversion(
                        conversor.base_code(),
                        conversor.target_code(),
                        monto,
                        fecha,
                        conversor.conversion_rate(),
                        conversor.conversion_result()
                );
                mostrarResultado(conversor,monto, registro.fechaDeConversion());
                historialDeConversion.add(registro);
                if(!deseaContinuar(lectura)){
                    mostrarHistorial(historialDeConversion);
                    break;
                }
            } catch (Exception e){
                System.out.println("Error inesperado: " + e.getMessage());
                lectura.nextLine();
            }
        }
    }
    private static void mostrarResultado(HistorialConversion registro) {
        mostrarResultado(
                new Conversor(
                        registro.base_code(),
                        registro.target_code(),
                        registro.conversion_rate(),
                        registro.conversion_result()
                ),
                registro.montoOriginal(),
                registro.fechaDeConversion()
        );
    }

    private static void mostrarResultado(Conversor conversor, double montoOriginal, String fecha){
        System.out.println("RESULTADO DE LA CONVERSION");
        System.out.printf("• Moneda base: %s (%s)%n",
                obtenerNombreMoneda(conversor.base_code()), conversor.base_code());
        System.out.printf("• Moneda objetivo: %s (%s)%n",
                obtenerNombreMoneda(conversor.target_code()), conversor.target_code());
        System.out.printf("• Monto original: %.2f %s%n", montoOriginal, conversor.base_code());
        System.out.printf("• Tasa de cambio: 1 %s = %.6f %s%n",
                conversor.base_code(), conversor.conversion_rate(), conversor.target_code());
        System.out.printf("• Resultado: %.2f %s%n",
                conversor.conversion_result(), conversor.target_code());
        System.out.printf("• Fecha de Conversión: %s",fecha);
    }
    private static String obtenerNombreMoneda(String codigo){
        try{
            return Moneda.valueOf(codigo).getNombreCompleto();
        }catch (Exception e){
            return "Moneda desconocida";
        }
    }

    private static  boolean deseaContinuar(Scanner lectura){
        System.out.println("\n ¿Desea hacer otra conversión? (s/n): ");
        String respuesta = lectura.nextLine().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si");
    }

    private static void mostrarHistorial(List<HistorialConversion> historial){
        if(historial.isEmpty()){
            System.out.println("\n ===== HISTORIAL VACIO =====");
            return;
        }
        System.out.println("\n===== HISTORIAL DE CONVERSIONES =====");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println("Conversión #" + (i + 1));
            mostrarResultado(historial.get(i));
            System.out.println("----------------------------------------");
        }
    }

    private static String consultarFecha(){
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        int hh = hora.getHour();
        int mm = hora.getMinute();
        int ss = hora.getSecond();
        String fechalocal = String.format("""
                %s Hora: %s:%s:%s
                """,fecha,hh,mm,ss);
        return fechalocal;
    }
}
