package repository;

import java.util.ArrayList;
import java.util.List;
import models.Diarista;

public class DiaristaRepository implements IRepository< Diarista, Long> {

    private List<Diarista> diaristas;
    private Long idAtual;

    public DiaristaRepository() {
        diaristas = new ArrayList<>();
        //diaristas.add(new Diarista(1L, "Nuno Lopes", "+244 923129393", "00239393LA09", "Maianga"));
        idAtual = 1L;
    }

    @Override
    public List<Diarista> buscarTodos() {
        return diaristas;

    }

    @Override
    public Diarista cadastrar(Diarista models) {
        models.setId(idAtual);
        diaristas.add(models);
        idAtual++;
        return models;

    }

    @Override
    public Diarista buscarPorId(Long id) {
        for (Diarista diarista : diaristas) {
            if (diarista.getId().equals(id)) {
                return diarista;
            }

        }
        return null;
    }

    @Override
    public boolean apagarPorId(Long id) {
       var diaristaEncontrada= buscarPorId(id);
       if(diaristaEncontrada!=null){
           diaristas.remove(diaristaEncontrada);
           return true;
       }
       return false;
    }

}
