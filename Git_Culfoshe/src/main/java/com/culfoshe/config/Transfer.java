package com.culfoshe.config;

import com.culfoshe.main.dto.SearchPreviewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import javax.swing.tree.TreeNode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Transfer {
    private static final ModelMapper modelMapper = new ModelMapper();

    public ModelMapper getModelMapper(){
        return modelMapper;
    }
    public static List<String> asList(String resource,String regex){
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

    public static Page<SearchPreviewDTO> transferRegTime(Page<SearchPreviewDTO> resource){
        List<SearchPreviewDTO> content = resource.getContent();
        for(int i = 0 ; i < content.size() ; i++){
            SearchPreviewDTO each = content.get(i);

             each.setString_regTime(
                     each.getRegTime() == null ? "123": each.getRegTime()
                             .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
            );

//            if(each.getRegTime() != null){
//                each.setString_regTime(
//                        each.getRegTime()
//                                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
//                );
//            }
        }
        return resource;
    }

    public static void main(String[] args) {
        String str = "1234$224$가나다$마바사";
        System.err.println(Transfer.asList(str,"$"));

    }
}
