package com.example.pract5.rest;

import com.example.pract5.model.Contact;
import com.example.pract5.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;


    @Operation(
            tags = "Получить данные о контаках",
            summary = "Данные о контактах будут получены",
            description = "Нажмите кнопку  и получаем данные",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Описание нашего контакта",
                    content = @Content(
                            schemaProperties = {
                                    @SchemaProperty(name = "phone",schema = @Schema(name = "contact")),
                                    @SchemaProperty(name = "name",schema = @Schema(name = "contact")),
                            }
                    )),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Contact.class),mediaType = MediaType.APPLICATION_JSON_VALUE
                            ,examples = {@ExampleObject(name = "Пример",value ="Объект контакта")}),description = "Контакт успешно изменён"),
                    @ApiResponse(responseCode = "500",description = "Ошибка сервера",content = @Content())},
            parameters = {@Parameter(name="ContactID",description = "ID контакта в базе данных",example = "1")}
    )
    @GetMapping("/getAll")
    public List<Contact> getAll(){
        return contactService.getAll();
    }


    @Operation(
            tags = "Сохранить контакт",
            summary = "Контакт сохранится в базу данных",
            description = "Нажмите кнопку и вводите данные о контакте",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Описание нашего контакта",
                    content = @Content(
                            schemaProperties = {
                                    @SchemaProperty(name = "phone",schema = @Schema(name = "contact")),
                                    @SchemaProperty(name = "name",schema = @Schema(name = "contact")),
                            }
                    )),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Contact.class),mediaType = MediaType.APPLICATION_JSON_VALUE
                            ,examples = {@ExampleObject(name = "Пример",value ="Объект контакта")}),description = "Контакт сохранён"),
                    @ApiResponse(responseCode = "500",description = "Ошибка сервера",content = @Content())}
    )

    @PostMapping("/create")
    public void createNewContact(@RequestBody Contact contact){contactService.createContact(contact);}

    @Operation(
            tags = "Обновить данные о контакте",
            summary = "Данные о контакте будут удалены",
            description = "Нажмите кнопку и вводите данные о контакте, который хотите изменить",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Описание нашего контакта",
                    content = @Content(
                            schemaProperties = {
                                    @SchemaProperty(name = "phone",schema = @Schema(name = "contact")),
                                    @SchemaProperty(name = "name",schema = @Schema(name = "contact")),
                            }
                    )),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Contact.class),mediaType = MediaType.APPLICATION_JSON_VALUE
                            ,examples = {@ExampleObject(name = "Пример",value ="Объект контакта")}),description = "Контакт успешно изменён"),
                    @ApiResponse(responseCode = "500",description = "Ошибка сервера",content = @Content()),
                    @ApiResponse(responseCode = "203",description = "Контакт успешно изменён",content = @Content())},
            parameters = {@Parameter(name="ContactID",description = "ID контакта в базе данных",example = "1")}
    )
    @PutMapping("/update")
    public void updateContact(@RequestBody Contact contact){
        System.out.println(contact);
        contactService.updateContact(contact);
    }

    @Operation(
            tags = "Удалить контакт",
            summary = "Контакт удалится из базы данных",
            description = "Нажмите кнопку и вводите данные о контакте, который хотите удалить",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Описание нашего контакта",
                    content = @Content(
                            schemaProperties = {
                                    @SchemaProperty(name = "phone",schema = @Schema(name = "contact")),
                                    @SchemaProperty(name = "name",schema = @Schema(name = "contact")),
                            }
                    )),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Contact.class),mediaType = MediaType.APPLICATION_JSON_VALUE
                            ,examples = {@ExampleObject(name = "Пример",value ="Объект контакта")}),description = "Контакт успешно удалён"),
                    @ApiResponse(responseCode = "500",description = "Ошибка сервера",content = @Content())},
            parameters = {@Parameter(name="ContactID",description = "ID контакта в базе данных",example = "1")}
    )
    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }
}
