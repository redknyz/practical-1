package com.mypackage.ChemicalSample;

import javax.persistence.*;

@Entity
@Table(name = "chemical_samples")
public class ChemicalSample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idchemical_samples;

    private String name;
    private int quantity;

    public int getIdchemical_samples() {
        return idchemical_samples;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
