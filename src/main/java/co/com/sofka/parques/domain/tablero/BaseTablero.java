package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.Ficha;

import java.util.ArrayList;
import java.util.List;

public class BaseTablero extends Entity<BaseId> {
    private final List<Ficha> fichas;

    public BaseTablero(BaseId entityId) {
        super(entityId);
        this.fichas = new ArrayList<>();
    }

    public void agregarFicha(Ficha ficha){
        for (var i = 1; i <= 4; i ++){
            fichas.add(ficha);
        }
    }

    public List<Ficha> getFichas() {
        return fichas;
    }
}
