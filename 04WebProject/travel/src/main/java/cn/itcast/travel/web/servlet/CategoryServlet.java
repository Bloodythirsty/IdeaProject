package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    protected void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 查询Dao
        List<Category> allCategory = categoryService.findAllCategory();
        //2. 序列化json
        toJson(response,allCategory);
    }

}
