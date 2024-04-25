package com.culfoshe.config;

import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Transfer {
    private static final ModelMapper modelMapper = new ModelMapper();

    public ModelMapper getModelMapper(){
        return modelMapper;
    }
    public static List<String> asList(String resource,String regex){
        if(resource == null){
            return null;
        }
        List list = new ArrayList();
        String[] resourceArr = resource.split(regex);
        for (int i = 1 ; i<resourceArr.length ; i++) {
            list.add(resourceArr[i]);
        }
        return list;
    }
    public static String asString(List<String> resource){
        String result = "";
        for (String each: resource) {
            result +="$" + each;
        }
        return result;
    }
}
