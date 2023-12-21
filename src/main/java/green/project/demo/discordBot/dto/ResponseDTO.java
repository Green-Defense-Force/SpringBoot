package green.project.demo.discordBot.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private Page<T> items;

    private List<T> itemlist;

    private T item;

    private String errorMessage;

    private int statusCode;

    private String message;

}