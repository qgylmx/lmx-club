package com.lmx.subject.application.convert;

import com.lmx.subject.application.dto.SubjectAnswerDTO;
import com.lmx.subject.domain.entity.SubjectAnswerBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-15T18:34:50+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
public class SubjectAnswerDTOConverterImpl implements SubjectAnswerDTOConverter {

    @Override
    public SubjectAnswerBO convertDtoToAnswerBo(SubjectAnswerDTO subjectAnswerDTO) {
        if ( subjectAnswerDTO == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectAnswerDTO.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectAnswerDTO.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectAnswerDTO.getIsCorrect() );

        return subjectAnswerBO;
    }

    @Override
    public List<SubjectAnswerBO> convertListDtoToAnswerBoList(List<SubjectAnswerDTO> subjectAnswerDTOList) {
        if ( subjectAnswerDTOList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectAnswerDTOList.size() );
        for ( SubjectAnswerDTO subjectAnswerDTO : subjectAnswerDTOList ) {
            list.add( convertDtoToAnswerBo( subjectAnswerDTO ) );
        }

        return list;
    }
}
