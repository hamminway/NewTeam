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
    public static List<String> asList(String resource){
        List list = new ArrayList();
        while(resource.contains("$")){
            int index = resource.indexOf("$");
            list.add(resource.substring());
        }

        return list;
    }
}
