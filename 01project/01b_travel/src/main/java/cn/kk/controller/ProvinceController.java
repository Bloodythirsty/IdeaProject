package cn.kk.controller;

import cn.kk.pojo.Province;
import cn.kk.pojo.Result;
import cn.kk.service.impl.ProvinceServiceImpl;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("province")
public class ProvinceController {

    @Autowired
    private ProvinceServiceImpl provinceService;

    // @RequestMapping("findAll")
    @GetMapping     //rest风格：http://localhost:8989/province?page=2&pageSize=2
    public Result findAllProvince(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                  @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize){
        log.info("byPage~");
        log.info("page = "+page);
        log.info("pageSize = "+pageSize);

        Result result = new Result();
        try {
            List<Province> provinces = provinceService.findAllProvince(page, pageSize);
            PageInfo<Province> provincePageInfo = new PageInfo<>(provinces);

            result.setState(true).setMsg("查询成功！").setProvincePageInfo(provincePageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    // @RequestMapping("saveProvince")
    @PostMapping
    public Result saveProvince(Province province){
        Result result = new Result();
        try {
            provinceService.saveProvince(province);
            result.setState(true).setMsg("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("保存失败！");
        }
        return result;
    }


    // @RequestMapping("deleteProvince")
    @DeleteMapping("{provinceId}")
    public Result deleteProvince(@PathVariable(name = "provinceId") String  provinceId){
        Result result = new Result();
        try {
            provinceService.deleteProvince(Integer.parseInt(provinceId));
            result.setState(true).setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("删除失败！");
        }
        return result;
    }

    // @RequestMapping("updateProvince")
    @PutMapping
    public Result updateProvince(Province  province){
        Result result = new Result();
        try {
            provinceService.updateProvince(province);
            result.setState(true).setMsg("更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("更新失败！");
        }
        return result;
    }


}
