package com.culfoshe.config.controller;

import org.springframework.stereotype.Controller;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Controller
    public class TestController {


    public static void main(String[] args) {

        int[] arr = {72, 43, 54, 56, 52, 29, 70, 15, 73, 5, 23, 81, 75, 44, 48, 19, 60, 92, 78, 20, 47, 88, 48, 51, 58, 80, 56, 71, 4};
        int n = 29;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[n];
        for(int i = 0 ; n>i ; i++){
            int cnt1 = 0;
            int cnt2 = 0;
            int element = arr[i];
            for(int j = i+1 ; j<arr.length&&j < i+n ; j++){
                cnt1 = j-i;
                if(element > arr[j]){
                    cnt1--;
                    break;
                }
            }
            for(int k = i-1 ; k >= 0 && i-n<k ; k--){
                cnt2 = i-k;
                if(element >= arr[k]){
                    cnt2--;
                    break ;
                }
            }
            int cnt = cnt1+cnt2;
            int compare1 = map.higherEntry(cnt+1) !=null ? map.higherEntry(cnt+1).getValue() : 0;
            while (cnt>=0){
                if(map.containsKey(cnt)&&map.get(cnt)>element){
                    break;
                }
                if(element>compare1){
                    map.put(cnt,element);
                }else{
                    break;
                }
                cnt--;
            }

        }

        int value = map.firstEntry().getValue();
        for(int i = -1 ; i < n-1 ; i++){
            value = map.higherEntry(i) != null ? map.higherEntry(i).getValue() : value;
            result[i+1] = value;
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            System.out.println("iterator : " + it.next());
        }

//        for(int i = 1 ; i<=n ; i++){
//            result[i-1] = map.lowerEntry(i-1).getValue();
//        }

        for(int i = 0 ; i < n ; i++){
            System.err.println(i+" :" + result[i]);
        }

    }




}
