package com.malicollecte.Services;

import com.malicollecte.models.Resultat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ResultatService {
    void exporterCsv();

    void exporterExcel();

    void importerCsv(String filePath);

    void importerExcel(String filePath);


    String AjouterResultat(Resultat resultat);

    String ModifierResultat(Long id,Resultat resultat);

    void SupprimerResultat(Long id);

    Resultat RecupererResultat(String id);

    Resultat AfficherUnResultat(Long id);

    Resultat AfficherToutResultat(List<Long> id);

    String PublierResultat(Long id);
}
