package ru.jma.dto.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private String text;

    private LocalDateTime creationDatetime;

    private boolean justFlag;
}
