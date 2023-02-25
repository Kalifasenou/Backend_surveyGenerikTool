package com.malicollecte.payload.request;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Repondant {
    private String genre;
    private String tranche;
    private Set<String> localite;
}
