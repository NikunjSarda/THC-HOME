package com.home.thc.Services;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Model.Menu;
import com.home.thc.Response.Response;

import java.util.List;

public interface MenuInterface {

    public List<Menu> getAllMenus();
    public Menu getMenuById(String id);
    public  List<Menu> findByMenuName(String item);
    public  List<Menu> findByMenuType(String type);
    public Boolean createMenu(MenuDTO menu);
    public Boolean updateMenu(String id, MenuDTO menu);
}
