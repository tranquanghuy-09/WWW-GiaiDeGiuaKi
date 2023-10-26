package vn.edu.iuh.fit.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.enums.Roles;

@Converter
public class RoleConverter implements AttributeConverter<Roles, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Roles attribute) {
        if(attribute==null)
            return null;
        return attribute.getRole();
    }

    @Override
    public Roles convertToEntityAttribute(Integer dbData) {
        if(dbData == 1)
            return Roles.ADMINISTRATION;
        if(dbData == 2)
            return Roles.STAFF;
        if(dbData == 3)
            return Roles.MANAGER;
        if(dbData == 4)
            return Roles.EXECUTIVE;
        return null;
    }
}
