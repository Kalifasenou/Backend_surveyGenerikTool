package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.ResultatService;
import com.malicollecte.models.Resultat;
import com.malicollecte.repository.ResultatRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatServiceImpl implements ResultatService {

    @Autowired
    private ResultatRepositorie resultatRepositorie;

    @Override
    public void exporterCsv() {
        // Code pour exporter les résultats sous format CSV
    }

    @Override
    public void exporterExcel() {
        // Code pour exporter les résultats sous format Excel
    }

    @Override
    public void importerCsv(String filePath) {
        // Code pour importer les résultats à partir d'un fichier CSV
    }

    @Override
    public void importerExcel(String filePath) {
        // Code pour importer les résultats à partir d'un fichier Excel
    }

    @Override
    public String AjouterResultat(Resultat resultat){
        resultatRepositorie.save(resultat);
        return "Resultat : " + resultat +"créer avec succés !";
    }

    /**
     * @param resultat
     * @return
     */
    @Override
    public String ModifierResultat(Long id, Resultat resultat) {

        resultatRepositorie.findById(id).map(resultat1 -> {
            resultat1.setLibelle(resultat.getLibelle());
            resultat1.setEnquete(resultat.getEnquete());

            return resultatRepositorie.save(resultat1);
        }).orElseThrow(() -> new RuntimeException("impossible de modifier cet resultat"));

        return "Modifier avec succés";
    }

    /**
     * @param id
     */
    @Override
    public void SupprimerResultat(Long id) {

        resultatRepositorie.deleteById(id);
    }


    /**
     * @param id
     * @return
     */
    @Override
    public Resultat RecupererResultat(String id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Resultat AfficherUnResultat(Long id) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Resultat AfficherToutResultat(List<Long> id) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String PublierResultat(Long id) {
        return null;
    }


}
