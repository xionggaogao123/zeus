package com.zeus.common.constants;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

public class JacksonType {

    public static final TypeReference<List<String>> LIST_OF_STRING = new TypeReference<List<String>>() {};

    public static final TypeReference<Map<String, String>> MAP_OF_STRING = new TypeReference<Map<String, String>>() {};

    public static final TypeReference<Map<String, Integer>> MAP_OF_INTEGER = new TypeReference<Map<String, Integer>>() {};

}
