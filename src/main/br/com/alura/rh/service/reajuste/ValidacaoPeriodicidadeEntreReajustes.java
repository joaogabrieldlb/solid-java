package main.br.com.alura.rh.service.reajuste;

import main.br.com.alura.rh.ValidacaoException;
import main.br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        final var dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        final var dataAtual = LocalDate.now();
        final var mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser no minimo de 6 meses!");
        }
    }
}
