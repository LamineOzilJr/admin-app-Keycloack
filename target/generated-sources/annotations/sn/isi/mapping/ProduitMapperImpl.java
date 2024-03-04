package sn.isi.mapping;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sn.isi.dto.Produit;
import sn.isi.entities.ProduitEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T22:10:30+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ProduitMapperImpl implements ProduitMapper {

    @Override
    public Produit toProduit(ProduitEntity produitEntity) {
        if ( produitEntity == null ) {
            return null;
        }

        Produit produit = new Produit();

        produit.setId( produitEntity.getId() );
        produit.setNom( produitEntity.getNom() );
        produit.setQtStock( produitEntity.getQtStock() );

        return produit;
    }

    @Override
    public ProduitEntity fromProduit(Produit produit) {
        if ( produit == null ) {
            return null;
        }

        ProduitEntity produitEntity = new ProduitEntity();

        produitEntity.setId( produit.getId() );
        produitEntity.setNom( produit.getNom() );
        produitEntity.setQtStock( produit.getQtStock() );

        return produitEntity;
    }
}
