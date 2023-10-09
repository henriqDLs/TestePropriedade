public class BlueOriginAuthorization {
    public static boolean autoriza(float peso, float altura, float tempoEscadas) {
        if (peso < 50 || peso > 101 || altura < 1.52 || altura > 1.93 || tempoEscadas > 80) {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
        return true;
    }
}