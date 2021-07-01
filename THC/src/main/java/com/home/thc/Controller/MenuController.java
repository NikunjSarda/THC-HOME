package com.home.thc.Controller;

import com.home.thc.Model.Menu;
import com.home.thc.Services.MenuServices;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    notes = "Returns full menu",
    response = Menu.class)
    public ResponseEntity<List<Menu>> listAllMenu(){
        return new ResponseEntity<>(menuServices.findAllMenus(), HttpStatus.OK);
    }

}
