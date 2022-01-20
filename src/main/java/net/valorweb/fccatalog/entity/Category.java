package net.valorweb.fccatalog.entity;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;


    public Category(UUID id){
        super.setId(id);
    }

    public Category(String name) {
        super.generateUUID();
        this.name = name;
    }

    public Category(UUID id, String name) {
        super.setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name;
    }
}
