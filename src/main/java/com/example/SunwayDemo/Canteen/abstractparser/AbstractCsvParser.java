//package com.example.SunwayDemo.Canteen.abstractparser;
//
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.quixoticone.erpengine.inventory.exception.attachmentexception.InvalidFileFormatException;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.util.List;
//
//public abstract class AbstractCsvParser<T> implements CsvParser<T> {
//    @Override
//    public List<T> parse(MultipartFile file) throws Exception {
//        List<T> records;
//        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
//                    .withType(getEntity())
//                    .withSeparator(getDelimiter())
//                    .withSkipLines(0)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .withIgnoreEmptyLine(true)
//                    .build();
//
//            records = (List<T>) csvToBean.parse();
//        } catch (Exception ex) {
//            throw new InvalidFileFormatException(ex.getMessage());
//        }
//        return records;
//    }
//
//}