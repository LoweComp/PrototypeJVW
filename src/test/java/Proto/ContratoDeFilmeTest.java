package Proto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class ContratoPrototypeTest {

    // Burocracia Fixa
    private static final String CLAUSULAS_MESTRE = "Texto longo e complexo de direitos autorais padronizado conforme lei XXX/2025.";
    private static final String JURISDICAO_PADRAO = "Rio de Janeiro, Brasil";

    private ContratoDeFilme prototipoMestre;

    // SETUP
    @BeforeEach
    void setup() {
        prototipoMestre = new ContratoDeFilme(CLAUSULAS_MESTRE, JURISDICAO_PADRAO);
    }

    // CLONAGEM E INDEPENDÊNCIA
    @Test
    void deveCriarNovaInstanciaAoClonar() {
        ContratoDeFilme clone1 = (ContratoDeFilme) prototipoMestre.clonar();
        assertNotSame(prototipoMestre, clone1, "O clone deve ser uma instância diferente do protótipo mestre.");
    }

    @Test
    void deveCompartilharAtributosCaros() {
        ContratoDeFilme clone2 = (ContratoDeFilme) prototipoMestre.clonar();
        // Atributos fixos foram copiados (referência)
        assertEquals(prototipoMestre.getClausulasDireitosAutorais(), clone2.getClausulasDireitosAutorais(),
                "As cláusulas complexas devem ser idênticas no protótipo e no clone.");
    }

    // MUDANCA E ISOLAMENTO
    @Test
    void deveModificarCloneSemAfetarProtótipo() {
        ContratoDeFilme cloneA = (ContratoDeFilme) prototipoMestre.clonar();
        ContratoDeFilme cloneB = (ContratoDeFilme) prototipoMestre.clonar();

        cloneA.setTitulo("Filme A: Avatar");
        cloneA.setValorDistribuicao(150000.00);

        cloneB.setTitulo("Filme B: Avatar: Fire & Ash");
        cloneB.setValorDistribuicao(500000.00);

        assertEquals("PROTÓTIPO MESTRE", prototipoMestre.getTitulo(),
                "O protótipo mestre deve manter o título original.");

        assertEquals("Filme A: Avatar", cloneA.getTitulo(),
                "O Clone A deve ter o título que lhe foi atribuído.");

        assertEquals("Filme B: Avatar: Fire & Ash", cloneB.getTitulo(),
                "O Clone B deve ter o título que lhe foi atribuído.");

        assertNotEquals(cloneA.getValorDistribuicao(), cloneB.getValorDistribuicao(),
                "Os valores de distribuição devem ser diferentes entre os clones.");
    }
}