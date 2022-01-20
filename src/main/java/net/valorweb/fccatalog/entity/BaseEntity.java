package net.valorweb.fccatalog.entity;

import java.util.UUID;
import java.util.regex.Pattern;

public class BaseEntity {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if(id == null || !isValidUUID(id.toString())) throw new IllegalArgumentException("id is null or invalid");
        this.id = id;
    }

    protected UUID generateUUID(){
        return UUID.randomUUID();
    }

    protected Boolean isValidUUID(String _id) {
        if(_id == null) return false;
        Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
        return UUID_REGEX_PATTERN.matcher(_id).matches();
    }
}
