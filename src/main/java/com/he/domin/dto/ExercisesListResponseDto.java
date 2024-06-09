package com.he.domin.dto;

import com.he.domin.entity.mongo.Exercises;
import com.he.domin.entity.mongo.ExercisesOption;
import lombok.Data;

import java.util.List;
@Data
public class ExercisesListResponseDto {
    private Exercises exercises;
    private List<ExercisesOption> exercisesOptionList;
}
