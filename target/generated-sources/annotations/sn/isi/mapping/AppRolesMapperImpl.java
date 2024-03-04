package sn.isi.mapping;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sn.isi.dto.AppRoles;
import sn.isi.entities.AppRolesEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T22:10:30+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class AppRolesMapperImpl implements AppRolesMapper {

    @Override
    public AppRoles toAppRoles(AppRolesEntity appRolesEntity) {
        if ( appRolesEntity == null ) {
            return null;
        }

        AppRoles appRoles = new AppRoles();

        appRoles.setId( appRolesEntity.getId() );
        appRoles.setNom( appRolesEntity.getNom() );

        return appRoles;
    }

    @Override
    public AppRolesEntity fromAppRoles(AppRoles appRoles) {
        if ( appRoles == null ) {
            return null;
        }

        AppRolesEntity appRolesEntity = new AppRolesEntity();

        appRolesEntity.setId( appRoles.getId() );
        appRolesEntity.setNom( appRoles.getNom() );

        return appRolesEntity;
    }
}
