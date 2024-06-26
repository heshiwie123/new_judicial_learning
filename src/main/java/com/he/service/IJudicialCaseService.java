package com.he.service;

import com.he.domin.entity.mongo.JudicialCase;
import com.mongodb.lang.Nullable;

import java.util.List;

public interface IJudicialCaseService {
    public List<JudicialCase> getJudicialCaseList(@Nullable Integer contract_type, @Nullable Integer legal_nature, @Nullable Integer formulation_organ, @Nullable Integer pageIndex, @Nullable Integer perPageSum);

    public List<JudicialCase> getJudicialCaseListByTile(@Nullable String title,@Nullable Integer pageIndex,@Nullable Integer perPageSum);
}
