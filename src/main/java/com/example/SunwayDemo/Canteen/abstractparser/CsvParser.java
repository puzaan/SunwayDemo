package com.example.SunwayDemo.Canteen.abstractparser;/*
 * @author sailesh
 * @created 21/07/2022 - 09:11
 */

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvParser<T> {
    Class<? extends T> getEntity();

    Character getDelimiter();

    List<?> parseAndMap(MultipartFile file) throws Exception;

    List<T> parse(MultipartFile file) throws Exception;;
}
