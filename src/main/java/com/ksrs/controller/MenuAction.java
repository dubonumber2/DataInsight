package com.ksrs.controller;

import com.ksrs.entity.Menu;
import com.ksrs.entity.User;
import com.ksrs.service.MenuService;
import com.ksrs.utils.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
@Controller
@RequestMapping("/menu")
public class MenuAction {
    @Autowired
    MenuService menuService;

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
    @RequestMapping("/getMenuTree.action")
    public @ResponseBody
    List<MenuTree> getTree(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Menu> list=menuService.getAllMenu();
        List<MenuTree> treeList=new ArrayList<MenuTree>();
        for(int i=0;i<list.size();i++){
            Menu menu=list.get(i);
            if(menu.getPid()==0){
                MenuTree t=new MenuTree();
                t.setId(menu.getId());
                t.setText(menu.getText());
                List<Menu> children=new ArrayList<Menu>();
                for(int j=0;j<list.size();j++){
                    if(list.get(j).getPid()==menu.getId()){
                        children.add(list.get(j));
                    }
                }
                t.setChildren(children);
                treeList.add(t);
            }
        }
        return treeList;

    }
    @RequestMapping("/getMenuByRole_id.action")
    public @ResponseBody List<MenuTree> getMenuByRole_Id(HttpSession session,HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        User user=(User)session.getAttribute("user");
        int roleId=0;
        if(user!=null){
             roleId = user.getRole_id();
        }
        List<Menu> list=menuService.getMenuByroleid(roleId);
        List<MenuTree> treeList=new ArrayList<MenuTree>();
        for(int i=0;i<list.size();i++){
            Menu menu=list.get(i);
            if(menu.getPid()==0){
                MenuTree tree=new MenuTree();
                tree.setId(menu.getId());
                tree.setText(menu.getText());
                List<Menu> children=new ArrayList<Menu>();
                for(int j=0;j<list.size();j++){
                    if(list.get(j).getPid()==menu.getId()){
                        children.add(list.get(j));
                    }
                }
                tree.setChildren(children);
                treeList.add(tree);
            }
        }

        return treeList;
    }
}
