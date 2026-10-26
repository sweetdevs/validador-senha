package br.com.ungqs;

import java.util.List;

public record ResultadoValidacao(boolean valida, List<String> erros) {}