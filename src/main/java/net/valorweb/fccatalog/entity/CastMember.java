package net.valorweb.fccatalog.entity;


import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum CastMemberType {
    TYPE1(1),
    TYPE2(2);
    private Integer type;

   CastMemberType(Integer type) {
        this.type = type;
    }

    private static final Map values = new HashMap<>();

    static {
       for(CastMemberType type : CastMemberType.values()) {
           values.put(type.type, type);
       }
    }

    public Integer getType() {
        return type;
    }

    public static Boolean valueOf(CastMemberType type) {
        CastMemberType castMemberType = (CastMemberType) values.get(type);
        return castMemberType != null;
    }
}
@NoArgsConstructor
public class CastMember extends BaseEntity{
    private String name;
    private CastMemberType type;

    public CastMember(UUID id, String name, CastMemberType type) {
        super.setId(id);
        this.setName(name);
        this.setType(type);
    }

    public CastMember(String name, CastMemberType type) {
        super.generateUUID();
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name;
    }

    public CastMemberType getType() {
        return type;
    }

    public void setType(CastMemberType type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if(!CastMemberType.valueOf(type)) throw new IllegalArgumentException("type is not valid");
        this.type = type;
    }
}
