package com.architecture.latest.repository.cake.api;

import com.architecture.latest.system.entity.Cake;
import com.architecture.latest.system.entity.convert.ConvertTo;

import java.util.ArrayList;
import java.util.List;

public class ConvertToCake implements ConvertTo<List<CakeModel>, List<Cake>> {

    @Override
    public List<Cake> from(List<CakeModel> models) {

        List<Cake> cakes = new ArrayList<>();

        for (CakeModel model : models) {
            cakes.add(new Cake(
                    model.getTitle(),
                    model.getDesc())
            );
        }

        return cakes;
    }
}
