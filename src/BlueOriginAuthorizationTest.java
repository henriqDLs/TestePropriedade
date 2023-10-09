import org.junit.jupiter.api.Test;
import org.quicktheories.QuickTheory;
import org.quicktheories.core.Gen;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class BlueOriginAuthorizationTest {

    @Test
    public void testAuthorization() {
        Gen<Float> pesoGen = floats().between(50, 101);
        Gen<Float> alturaGen = floats().between(1.52f, 1.93f);
        Gen<Float> tempoEscadasGen = floats().between(0, 80);

        QuickTheory.qt()
                .forAll(pesoGen, alturaGen, tempoEscadasGen)
                .check((peso, altura, tempoEscadas) -> {
                    try {
                        return BlueOriginAuthorization.autoriza(peso, altura, tempoEscadas);
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                });
    }
}