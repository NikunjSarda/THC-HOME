package com.home.thc.Controller;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Model.Menu;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.MenuServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class MenuController {

    MenuServices menuServices;

    public MenuController(MenuServices menuServices){
        this.menuServices = menuServices;
    }

    @GetMapping(value = "/MenuList", produces = "application/json")
    @ApiOperation(value = "Getting all full menu",
            notes = "Returns full menu")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Menu>> listAllMenu(){
        return Response.<List<Menu>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuServices.getAllMenus()))
                .build();
    }

    @GetMapping(value = "/MenuById/{id}", produces = "application/json")
    @ApiOperation(value = "Get a Menu",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<Menu> getMenuById(@PathVariable("id") String id){
        return  Response.<Menu>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuServices.getMenuById(id)))
                .build();
    }

    @GetMapping(value = "/MenuByName/{name}", produces = "application/json")
    @ApiOperation(value = "Get Menu by name",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Menu>> getMenuByName(@PathVariable("name") String name){
        return  Response.<List<Menu>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuServices.findByMenuName(name)))
                .build();
    }

    @GetMapping(value = "/MenuByType/{type}", produces = "application/json")
    @ApiOperation(value = "Get Menu by Type",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Menu>> getMenuByType(@PathVariable("type") String type){
        return  Response.<List<Menu>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuServices.findByMenuType(type)))
                .build();
    }

    @PostMapping(value = "/MenuCreate", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create a Menu",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> createMenu(@RequestBody MenuDTO menu){
        return menuServices.createMenu(menu) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Menu Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu Not Created")
                        .build();
    }

    @PutMapping(value = "/MenuUpdate/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update a Menu",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "UPDATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> updateMenu(@PathVariable(name = "id") String id, @RequestBody MenuDTO menu){
        return menuServices.updateMenu(id, menu) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Menu Updated")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu Not Updated")
                        .build();
    }

    @DeleteMapping(value = "/MenuDelete/{id}")
    @ApiOperation(value = "Delete a Reservation",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "DELETED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> deleteMenu(@PathVariable(name = "id") String id){
        return menuServices.deleteMenu(id) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Menu deleted")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Menu Not deleted")
                        .build();
    }
}
