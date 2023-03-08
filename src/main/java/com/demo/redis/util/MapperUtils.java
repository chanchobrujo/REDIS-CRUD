package com.demo.redis.util;

import com.google.gson.Gson;
import static java.util.Objects.isNull;

public
class MapperUtils {

    public static <D> D mapper(Class<D> destiny, Object origen) {
        Gson gson = new Gson();
        if (isNull(origen)) throw new RuntimeException("");
        else return gson.fromJson(gson.toJson(origen), destiny);
    }

    public static <D> String toJsonString(D origen) {
        Gson gson = new Gson();
        if (isNull(origen)) throw new RuntimeException("");
        return gson.toJson(origen);
    }
}
