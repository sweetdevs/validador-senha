package br.com.ungqs;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {
    private static final int TAMANHO_MINIMO = 8;
    private static final int DIGITOS_MINIMOS = 2;

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha.length() < TAMANHO_MINIMO) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }
        if (senha.chars().filter(Character::isDigit).count() < DIGITOS_MINIMOS) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }
        if (senha.chars().noneMatch(Character::isUpperCase)) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }
        if (senha.chars().allMatch(Character::isLetterOrDigit)) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}