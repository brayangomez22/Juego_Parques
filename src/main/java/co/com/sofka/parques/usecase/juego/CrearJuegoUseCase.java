package co.com.sofka.parques.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.parques.domain.juego.Juego;
import co.com.sofka.parques.domain.juego.command.CrearJuego;
import co.com.sofka.parques.domain.juego.factory.JugadorFactory;

public class CrearJuegoUseCase extends UseCase<RequestCommand<CrearJuego>, ResponseEvents> {

    public static final int CATINDAD_DE_BASES = 2;

    @Override
    public void executeUseCase(RequestCommand<CrearJuego> input) {
        var command = input.getCommand();

        var factoryJugador = JugadorFactory.builder();
        command.getNombres()
                .forEach((jugadorId, nombre) ->
                        factoryJugador.nuevoJugador(jugadorId, nombre));

        if(factoryJugador.getJugadores().size() < CATINDAD_DE_BASES){
            throw new IllegalArgumentException("No se puede crear el juego porque no estan todos los jugadores");
        }

        var juego = new Juego(command.getJuegoId(), factoryJugador);

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
