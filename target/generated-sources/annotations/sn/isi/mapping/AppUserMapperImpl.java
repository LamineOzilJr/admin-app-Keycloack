package sn.isi.mapping;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sn.isi.dto.AppUser;
import sn.isi.entities.AppUserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T22:10:30+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUser toAppUser(AppUserEntity appUserEntity) {
        if ( appUserEntity == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( appUserEntity.getId() );
        appUser.setNom( appUserEntity.getNom() );
        appUser.setPrenom( appUserEntity.getPrenom() );
        appUser.setEmail( appUserEntity.getEmail() );
        appUser.setPassword( appUserEntity.getPassword() );
        appUser.setEtat( appUserEntity.getEtat() );

        return appUser;
    }

    @Override
    public AppUserEntity fromAppUser(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserEntity appUserEntity = new AppUserEntity();

        appUserEntity.setId( appUser.getId() );
        appUserEntity.setNom( appUser.getNom() );
        appUserEntity.setPrenom( appUser.getPrenom() );
        appUserEntity.setEmail( appUser.getEmail() );
        appUserEntity.setPassword( appUser.getPassword() );
        appUserEntity.setEtat( appUser.getEtat() );

        return appUserEntity;
    }
}
