package br.com.ungqs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class ValidadorSenhaTest {
    private final ValidadorSenha validador = new ValidadorSenha();

    @Test
    void deveRejeitarSenhaComMenosDeOitoCaracteres() {
        ResultadoValidacao resultado = validador.validar("Ab1!");
        assertFalse(resultado.valida());
        assertTrue(resultado.erros().contains("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveRejeitarSenhaComMenosDeDoisDigitos() {
        ResultadoValidacao resultado = validador.validar("Abcdefg1!");
        assertFalse(resultado.valida());
        assertTrue(resultado.erros().contains("A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        ResultadoValidacao resultado = validador.validar("abcdef12!");
        assertFalse(resultado.valida());
        assertTrue(resultado.erros().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    void deveRejeitarSenhaSemCaractereEspecial() {
        ResultadoValidacao resultado = validador.validar("Abcdefg12");
        assertFalse(resultado.valida());
        assertTrue(resultado.erros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveRetornarTodosOsErrosParaMypass() {
        ResultadoValidacao resultado = validador.validar("mypass");
        assertFalse(resultado.valida());
        assertEquals(List.of(
            "A senha deve ter pelo menos 8 caracteres",
            "A senha deve conter pelo menos 2 dígitos",
            "A senha deve conter pelo menos uma letra maiuscula",
            "A senha deve conter pelo menos um caractere especial"
        ), resultado.erros());
    }

    @Test
    void deveAceitarSenhaValida() {
        ResultadoValidacao resultado = validador.validar("Senha123!");
        assertTrue(resultado.valida());
        assertTrue(resultado.erros().isEmpty());
    }
}