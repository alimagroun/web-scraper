package com.magroun.scarper.service;

import java.util.List;

import com.magroun.scarper.dto.ResponseDTO;

public interface ScraperService {
    List<ResponseDTO> getProductByKeyword(String keyword);
    List<ResponseDTO> getProductByKeywordWithJsoup(String keyword);

}
