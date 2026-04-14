import java.time.Year;

public class Validador {

    // Validar texto (titulo, autor, genero)

    public static boolean textoValido(String texto) {

        if (texto == null)
            return false;

        if (texto.trim().length() < 3)
            return false;

        return true;
    }

    // Validar año

    public static boolean anioValido(int anio) {

        int actual =
                Year.now().getValue();

        if (anio < 1500)
            return false;

        if (anio > actual)
            return false;

        return true;
    }
}