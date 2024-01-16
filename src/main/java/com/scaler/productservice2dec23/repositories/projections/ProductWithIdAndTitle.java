package com.scaler.productservice2dec23.repositories.projections;

public interface ProductWithIdAndTitle {
    // this can be superset
    Long getId();
    String getTitle();
    String getDescription();
}
