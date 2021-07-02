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

    @GetMapping("/MenuList")
    @ApiOperation(value = "Getting all full menu",
            notes = "Returns full menu")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Menu>> listAllMenu(){
        System.out.println("request hit");
        return Response.<List<Menu>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((menuServices.getAllMenus()))
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
        System.out.println(menu);
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

}
