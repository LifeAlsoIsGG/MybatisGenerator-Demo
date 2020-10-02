package com.pactera.sz.cmb202102.mapper;

import com.pactera.sz.cmb202102.pojo.Menu;
import com.pactera.sz.cmb202102.pojo.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    @Select("select a.menu_id asm menuId,a.enu_name as menuName,a.menu_url as menuUrl,a.menu_order as menuOrder,a.type,a.parent_id as parentId,b.menu_name as parentName\n" +
            "from sys_menu as a LEFT JOIN sys_menu b\n" +
            "on b.menu_id = a.parent_id\n" +
            "where a.state = 1 and a.menu_name LIKE #{menuName}")
    List<Menu> listMenuByMenuName(String menuName);

    List<Menu> listMenuByMenuIds(List<Integer> list);
}