package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository  repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
       List<Category> list =  repository.findAll();

//       List<CategoryDTO> listDto = new ArrayList<>();
//       for (Category category : list){
//          listDto.add( new CategoryDTO(category));
//       }

//        method reference
//        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

    }
}