package io.github.dftrakesh.cloverrest.model.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    private String href;
    private String id;
    private String name;
    private String email;
    private Boolean inviteSent;
    private Long claimedTime;
    private String role;
    private Boolean isOwner;
    private Orders orders;
}