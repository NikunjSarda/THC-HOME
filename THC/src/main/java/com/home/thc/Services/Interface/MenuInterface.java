package com.home.thc.Services.Interface;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Model.Menu;

import java.util.List;

public interface MenuInterface {

    List<Menu> getAllMenus();
    Menu getMenuById(String id);
    List<Menu> findByMenuName(String item);
    List<Menu> findByMenuType(String type);
    Boolean createMenu(MenuDTO menu);
    Boolean updateMenu(String id, MenuDTO menu);
    Boolean deleteMenu(String id);
}
